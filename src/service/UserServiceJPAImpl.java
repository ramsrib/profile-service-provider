package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import bean.User;

@Transactional
public class UserServiceJPAImpl implements UserService {

    //private List<User> users = new ArrayList<User>();
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persistUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void createUser(User user) {
        //users.add(user);
        persistUser(user);

    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public User getUserById(Long Id) {
        User user = entityManager.find(User.class, Id);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        //users.remove(user);
        //persistUser(user);
        entityManager.remove(user);
    }

    @Override
    public List<User> listUser() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public boolean authenticateUser(String username, String password) {

        Query query = entityManager.createQuery("from User where username = :username and password = :password").setParameter("username", username).setParameter("password", password);

        List result =  query.getResultList();
        if ( !result.isEmpty() ) {
            return true;
        }
        return false;
    }

    @Override
    public User getUserData(String username, String password) {
        Query query = entityManager.createQuery("from User where username = :username").setParameter("username", username);
        List result =  query.getResultList();
        if ( !result.isEmpty() ) {
            return (User) result.get(0);
        }
        return null;
    }

    @Override
    public boolean isUserExists(String username) {

        Query query = entityManager.createQuery("from User where username = :username").setParameter("username", username);
        List result = query.getResultList();
        return !result.isEmpty();

    }

}
