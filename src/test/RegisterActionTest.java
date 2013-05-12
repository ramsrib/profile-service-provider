package test;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import service.UserServiceImpl;
import action.RegisterAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionProxy;

public class RegisterActionTest extends StrutsSpringTestCase {

    @Test
    public void testValidRegistration() throws Exception {

        // Valid request
        request.setParameter("name", "sriram");
        request.setParameter("password", "123#123gp");
        request.setParameter("email", "sriram@collab.net");

        ActionProxy proxy = getActionProxy("/RegisterAction");
        RegisterAction action = (RegisterAction) proxy.getAction();

        action.setUserService(UserServiceImpl.getInstance());

        String result = proxy.execute();

        System.out.println("Action ERROR : " + action.getActionErrors());
        System.out.println("Action Field ERROR : " + action.getFieldErrors());
        System.out.println("Action Message : " + action.getActionMessages());

        assertEquals("Incorrect result", Action.SUCCESS, result);
        assertTrue("There should not be any field errors.", action.getFieldErrors().size() == 0);
        assertTrue("There should not be any action errors.", action.getActionErrors().size() == 0);

    }

    @Test
    public void testInValidRegistration() throws Exception {

        // Invalid request
        request.setParameter("name", "sri");
        request.setParameter("password", "123");
        request.setParameter("email", "sriram");

        ActionProxy proxy = getActionProxy("/RegisterAction");

        RegisterAction action = (RegisterAction) proxy.getAction();
        action.setUserService(UserServiceImpl.getInstance());

        String result = proxy.execute();

        System.out.println("Action ERROR : " + action.getActionErrors());
        System.out.println("Action Field ERROR : " + action.getFieldErrors());
        System.out.println("Action Message : " + action.getActionMessages());

        assertEquals("Incorrect result", Action.INPUT, result);
        assertTrue("There should not be any field errors.", action.getFieldErrors().size() == 3);
    }


}
