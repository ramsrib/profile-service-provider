package test;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import service.UserService;
import service.UserServiceImpl;
import action.LoginAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;

public class LoginActionStrutsTest extends StrutsSpringTestCase {

    LoginAction action;


    @Test
    public void testLogin() throws Exception {
        request.setParameter("name", "sriram");
        request.setParameter("password", "123");

        ActionProxy proxy = getActionProxy("/LoginAction");
        LoginAction action = (LoginAction) proxy.getAction();

        UserService userService = UserServiceImpl.getInstance();
        //userService.createUser(user);
        action.setUserService(userService);

        String result = proxy.execute();

        assertEquals("Incorrect result", Action.SUCCESS, result);
        assertTrue("Problem There were no errors present in fieldErrors but there should have been one error present", action.getFieldErrors().size() == 1);
        assertTrue("Problem field name not present in fieldErrors but it should have been",
                        action.getFieldErrors().containsKey("name") );
    }

}
