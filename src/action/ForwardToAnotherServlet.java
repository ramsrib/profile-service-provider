package action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class ForwardToAnotherServlet extends ActionSupport implements RequestAware {

    private Map request;

    public Map getRequest() {
        return request;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public String execute() {
        getRequest().put("something", "Something from Struts Action");
        return SUCCESS;
    }

    public String getTestProperty() {
        return "I'm Test Property";
    }

}
