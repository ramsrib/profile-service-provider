package chapterTwo;

import com.opensymphony.xwork2.ActionSupport;

//@Result(value="/chapterTwo/test.jsp")
public class HelloWorldAction extends ActionSupport {

    private static final String GREETING = "Hello ";
    
    public String execute() {
        if (getName()!=null) {
            setCustomGreeting(GREETING + getName());
            return "success";    
        } else {
            return "error";
        }
        
    }
    
    private String name;
    private String customGreeting;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) { 
        this.name = name;
    }
    
    public String getCustomGreeting() {
        return customGreeting;
    }
    
    public void setCustomGreeting(String customGreeting) {
        this.customGreeting = customGreeting;
    }
    
}
