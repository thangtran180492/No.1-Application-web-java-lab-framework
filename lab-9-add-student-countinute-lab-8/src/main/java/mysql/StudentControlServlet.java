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
    
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
			}catch(Exception exc) {
				throw new ServletException(exc);
			}
	}

	// create connect jdbc context.xml
    @Resource(name="jdbc/web_student_tracker")
    private DataSource dataSource;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
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
				String theCommand = request.getParameter("command") + "";
				switch (theCommand) {
					case "ADD":
						addStudent(request, response);
						break;
					case "LOAD":
						loadStudent(request, response);
						break;
					case "UPDATE":
						updateStudent(request, response);
						break;
					case "DElETE":
						deleteStudent(request, response);
						break;
					default:
						listStudent(request, response);
						break;
				}
			} catch (Exception e) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("Error : " + e.toString());
			}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// delete step 1 : get params from request
		String studentId = request.getParameter("studentId");
		
		// delete step 2 : delete student from database
		studentDbUtil.deleteStudent(studentId);
		
		// delete step 3 : send to page list-student.jsp
		listStudent(request, response);
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// update step 1 : read parameter from request;
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("firstName");
		String email = request.getParameter("email");
		
		// update step 2 : create object student
		Student theStudent = new Student(studentId, firstname, lastname, email);
		
		// update step 3 : former update database
		studentDbUtil.updateStudent(theStudent);
		
		// update step 4 : send back page list student
		listStudent(request, response);
		
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// load step 1 : read student from form id
		String studentId =  request.getParameter("studentId");
		
		// load step 2 : get student from database(DB util)
		Student student = studentDbUtil.getStudent(studentId);
		
		// load step 3 : place student in the request Attribute
		request.setAttribute("THE_STUDENT", student);
		
		// load step 4 : send to page update-student.jsp
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		requestDispatcher.forward(request, response);
		
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// create step 1 : read parameter
		String firstName = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create step 2 : creat student
		Student student = new Student(firstName, lastname,email);
		
		// create step 3 : add student to the database
		studentDbUtil.addStudents(student);
		
		// create step  : go to page student_list
		listStudent(request, response);
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// read step 6: get list student
			List<Student> students = studentDbUtil.getStudents();
				
			// read step 7: add attrbute
			request.setAttribute("STUDENT_LIST", students);
				
			// read step 8: send page jsp
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
