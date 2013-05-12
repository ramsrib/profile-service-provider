package action;

import java.io.File;
import java.util.Arrays;

import service.UserService;
import service.UserServiceImpl;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport{

    private String name;

    private String password;

    private String email;

    private File profilePicture;

    private UserService userService;


    public String execute() throws Exception {

        User user = new User();

        user.setUsername(getName());
        user.setPassword(getPassword());
        user.setEmailId(getEmail());
        user.setProfilePicture(getProfilePicture());

        /*if (true) {
            System.out.println("Throwing exception...");
            throw new Exception();
        }*/

        // injected by spring
        userService.createUser(user);
        return SUCCESS;

    }

    public void validate() {
        if (getPassword().length() == 0) {
            addFieldError("password", getText("password.required"));
        }
        if (getName().length() == 0) {
            addFieldError("name", getText("username.required"));
        }
        if (getEmail().length() == 0) {
            addFieldError("email", getText("email.required"));
        }

        // injected by spring
        if(userService.isUserExists(getName())) {
            addFieldError("name", getText("user.exists", Arrays.asList(getName())));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public File getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(File profilePicture) {
        this.profilePicture = profilePicture;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
