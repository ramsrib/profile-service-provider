package service;

import java.util.List;

import bean.User;

public interface UserService {

    public abstract void createUser(User user);

    public abstract void deleteUser(User user);

    public abstract List<User> listUser();

    public abstract boolean authenticateUser(String username, String password);

    public abstract User getUserData(String username, String password);

    public abstract boolean isUserExists(String username);

}