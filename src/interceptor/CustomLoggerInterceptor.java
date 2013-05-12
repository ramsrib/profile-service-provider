package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class CustomLoggerInterceptor implements Interceptor {

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        long startTime = System.currentTimeMillis();
        String result = invocation.invoke();
        long execTime = System.currentTimeMillis() - startTime;
        System.out.println("Action Name : " + invocation.getAction().toString());
        System.out.println("Action Result Code : " + invocation.getResultCode());
        System.out.println("Execution Time : " + execTime);
        return result;
    }

}
