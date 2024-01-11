package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestParamServlet
 */
@WebServlet("/TestParamServlet")
public class TestParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// step 1 :
		response.setContentType("text/html");
		
		// step 2 :
		PrintWriter out = response.getWriter();
		
		// step 3 : get parameter of file web.xml
		ServletContext servlet = getServletContext();
		String maxCartSize = servlet.getInitParameter("max-shopphing-cart-size");
		String teamProject = servlet.getInitParameter("project-team-name");
		
		// step 4 :
		out.println("<html><body>");
		
		out.println("Max Cart : " + maxCartSize);
		out.println("<br>");
		out.println("Team name : " + teamProject);
		
		out.println("<html><body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
