package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UrlRewriteFilter implements Filter {

    @Override
    public void destroy() {

    }

    /*
     * This filter rewrites the URL in the request, configure it in web.xml
     *
     * From URL :
     * http://nm-java.appspot.com/Check_License/Dir_My_App/Dir_ABC/My_Obj_123
     *
     * TO URL : http://nm-java.appspot.com/Check_License?Contact_Id=My_Obj_123
     *
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();
        System.out.println("Request URI : " + requestURI);

        if (requestURI.startsWith("/UserProfileService/TestServlet")) {
            // if (requestURI.startsWith("/UserProfileService/TestDest/")) {
            String toReplace = requestURI.substring(requestURI.indexOf("/TestServlet"), requestURI.lastIndexOf("/") + 1);
            String newURI = requestURI.replace(toReplace, "?Contact_Id=");
            System.out.println("Rewriting the URL in request to : " + newURI);
            req.getRequestDispatcher(newURI).forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }



}
