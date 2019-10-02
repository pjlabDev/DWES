

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class demoServlet2
 */
public class demoServlet2<E> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demoServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append("<b>" + request.getContextPath() + "</b>" + "<br>");
		response.getWriter().append("URL at: ").append("<b>" + request.getRequestURL() + "</b>" + "<br>");
		response.getWriter().append("Served at: ").append(request.getParameterNames().toString());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.write("!DOCTYPE html>\n");
		out.write("<html>\n");
		out.write("<body>\n");
		out.write("<h1>SERVLET 1 JSP</h1>\n");
		out.write("</body>\n");
		out.write("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
