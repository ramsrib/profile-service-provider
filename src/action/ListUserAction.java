package action;

import interfaces.UserAware;

import java.util.Arrays;
import java.util.List;

import service.UserService;
import service.UserServiceImpl;
import bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class ListUserAction implements Action, ModelDriven, UserAware {
/*
    public ListUserAction() {

    }*/

    private User user = null;

    private UserService userService;

    // injected by spring (throws exception, analyze this case)
    //private List<User> users = userService.listUser();
    private List<User> users;

    @Override
    public String execute() throws Exception {

        //List<User> users = UserService.getInstance().listUser();
        users = userService.listUser();

        if (user == null) {
            return LOGIN;
        }

        return SUCCESS;
    }

    @Override
    public Object getModel() {
        //get model runs before execute method, so move that execute part here
        //List<User> users = UserService.getInstance().listUser();
        //users = userService.listUser();
        return users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(User users) {
        //This is buggy, here List<User> object or User object?
        this.users = Arrays.asList(users);
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
