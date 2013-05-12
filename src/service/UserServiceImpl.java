package service;

import java.util.ArrayList;
import java.util.List;

import bean.User;

public final class UserServiceImpl implements UserService {

    private static UserService instance = new UserServiceImpl();

    protected UserServiceImpl() {
    }

    private List<User> users = new ArrayList<User> ();


    public static UserService getInstance() {
        return instance;
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    public List<User> listUser() {
        return users;
    }

    @Override
    public boolean authenticateUser(String username, String password) {

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserData(String username, String password) {

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean isUserExists(String username) {

        for (User user : users) {

            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
