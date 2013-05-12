package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import service.UserService;
import service.UserServiceImpl;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

import constant.ProfileServiceConstants;


@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements SessionAware {

    private String name;
    private String password;
    private Map session;
    private UserService userService;


public String execute() {

    /*if (UserService.getInstance().authenticateUser(getName(), getPassword())) {
        return SUCCESS;
    }*/

    // injected by spring
    User user = userService.getUserData(getName(), getPassword());

    if (user == null) {
        return INPUT;
    } else {
        session.put(ProfileServiceConstants.USER, user);
    }
    return SUCCESS;
    //return ERROR;
}

public void validate() {
    if (getPassword().length() == 0) {
        addFieldError("password", "Password is required");
    }
    if (getName().length() == 0) {
        addFieldError("name", "Username is required");
    }
    if(getName().equals("root")) {
        addActionError("Don't try to hack me!");
    }
    addActionMessage("You are a Valid User");
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@Override
public void setSession(Map<String, Object> session) {
    this.session = session;
}

public UserService getUserService() {
    return userService;
}

public void setUserService(UserService userService) {
    this.userService = userService;
}

}
