package action;

import com.opensymphony.xwork2.Action;

public class GoogleSearch implements Action {

    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String execute() throws Exception {
        setParam("ramsrib");
        return SUCCESS;
    }

}
