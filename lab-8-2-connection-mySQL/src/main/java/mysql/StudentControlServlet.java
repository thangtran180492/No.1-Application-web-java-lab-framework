package mysql;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControlServlet
 */
@WebServlet("/StudentControlServlet")
public class StudentControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// create StudentDbUtil
    private StudentDbUtil studentDbUtil;
    
    // create connect jdbc context.xml
    @Resource(name="jdbc/web_student_tracker")
    private DataSource dataSource;
    
    
    @Override
	public void init() throws ServletException {
		super.init();
		try {
		studentDbUtil = new StudentDbUtil(dataSource);
		}catch(Exception exc) {
			throw new ServletException(exc);
		}
	}

	public StudentControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 
		try {
			lisStudent(request, response);
		} catch (Exception e) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("Error : " + e.toString());
		}
		
	}

	private void lisStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// step 6: get list student
		List<Student> students = studentDbUtil.getStudents();
		
		// step 7: add attrbute
		request.setAttribute("STUDENT_LIST", students);
		
		// step 8: send page jsp
		RequestDispatcher resquestDispatcher = request.getRequestDispatcher("/list_student.jsp");
		resquestDispatcher.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
