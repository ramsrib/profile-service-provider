package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;

/**
 * Servlet implementation class AnotherServlet
 */
@WebServlet("/anotherServlet")
public class AnotherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnotherServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    ServletOutputStream out = response.getOutputStream();
	    out.println("<html><head></head><body>");
	    out.println("<p>Hello from another Servlet post() method</p>");
	    // below thing (request attribute - something) comes from the struts action (where we manually
	    // set the value of this attribute)
	    out.println("Attribute from Struts Action : " + request.getAttribute("something"));
	    out.println();
	    // below thing (request parameter - something1) comes from the form that was submitted.
	    out.println("Request Parameter : " + request.getParameter("param"));
	    out.println();
	    // this from Struts 2 valueStack (from the ActionContext)
	    String propertyFromAction = (String) ActionContext.getContext().getValueStack().findValue("testProperty");
	    out.println("\nProperty From Action : " + propertyFromAction );
	    out.println("</body></html>");
	}

}
