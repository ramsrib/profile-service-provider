package interceptor;

import interfaces.UserAware;

import java.util.Map;

import bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import constant.ProfileServiceConstants;

@SuppressWarnings("serial")
public class AuthenticationInterceptor implements Interceptor {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map session = invocation.getInvocationContext().getSession();
        User user = (User) session.get(ProfileServiceConstants.USER);

        if (user == null) {
            return Action.LOGIN;
        } else {
            Action action = (Action) invocation.getAction();
            if (action instanceof UserAware) {
                ((UserAware) action).setUser(user);
            }
            return invocation.invoke();

        }
    }

}
