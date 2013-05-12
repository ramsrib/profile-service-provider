package result;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

@SuppressWarnings("serial")
public class JSONResult implements Result {

    public static final String DEFAULT_PARAMS = "classAlias";

    String classAlias;

    public String getClassAlias() {
        return classAlias;
    }

    public void setClassAlias(String classAlias) {
        this.classAlias = classAlias;
    }

    @Override
    public void execute(ActionInvocation invocation) throws Exception {
        ServletActionContext.getResponse().setContentType("text/plain");
        PrintWriter responseStream = ServletActionContext.getResponse().getWriter();
        ValueStack valueStack = invocation.getStack();

        Object jsonModel = valueStack.findValue("jsonModel");
        XStream xstream = new XStream(new JettisonMappedXmlDriver());

        if (classAlias == null) {
                classAlias = "object";
        }

        xstream.alias(classAlias, jsonModel.getClass());
        responseStream.println(xstream.toXML(jsonModel));

    }

}
