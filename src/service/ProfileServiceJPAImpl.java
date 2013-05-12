package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import bean.Profile;

@Transactional
public class ProfileServiceJPAImpl implements ProfileService {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void save(Profile profile) {
        if (profile.getId() == null) {
            // new
            entityManager.persist(profile);
        } else {
            // update
            entityManager.merge(profile);
        }
    }

    public void persistProfile(Profile profile) {
        //entityManager.getTransaction().begin();
        entityManager.persist(profile);
        //entityManager.getTransaction().commit();
        //entityManager.flush();
    }

    @Override
    public List<Profile> getProfile(String username) {
        Query query = entityManager.createQuery("from Profile where username = :username").setParameter("username", username);
        return query.getResultList();
    }

    @Override
    public void createProfile(Profile profile) {
        persistProfile(profile);
    }

    @Override
    public void deleteProfile(Profile profile) {
           entityManager.remove(profile);
    }

    public void updateProfile(Profile profile) {
        entityManager.merge(profile);
    }

    public Profile getProfileById(Long Id) {
        Profile profile = entityManager.find(Profile.class, Id);
        return profile;
    }

    public void deleteProfileById(Long Id) {
        entityManager.remove(getProfileById(Id));
    }

    @Override
    public List<Profile> listProfile() {
        Query query = entityManager.createQuery("from Profile");
        return query.getResultList();
    }

    @Override
    public boolean isProfileExists(String profilename) {
        Query query = entityManager.createQuery("from Profile where profilename = :profilename").setParameter("profilename", profilename);
        List result = query.getResultList();
        return !result.isEmpty();
    }
    
    public void deleteProfileById2(Long Id) {
        Profile profile = findById(Id);
        if (profile != null) {
            entityManager.remove(profile);
        }
    }
    
    public Profile findById(Long id) {
        return entityManager.find(Profile.class, id);
    }

}
