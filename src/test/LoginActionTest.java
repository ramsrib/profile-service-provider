package test;

import java.util.HashMap;

import junit.framework.TestCase;

import org.junit.Test;

import service.UserService;
import service.UserServiceImpl;
import action.LoginAction;
import bean.User;

public class LoginActionTest extends TestCase {

    LoginAction action;


    @Test
    public void testLogin() {

        User user = new User();
        user.setUsername("sriram");
        user.setPassword("password");

        action = new LoginAction();
        action.setName(user.getUsername());
        action.setPassword(user.getPassword());
        action.setSession(new HashMap<String,Object>());

        UserService userService = UserServiceImpl.getInstance();
        userService.createUser(user);

        action.setUserService(userService);
        assertEquals("success", action.execute());

    }

}
