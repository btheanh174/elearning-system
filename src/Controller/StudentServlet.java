package Controller;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.StudentManager;
import Object.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentManager sM;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() throws ClassNotFoundException, SQLException {
		super();
		sM = new StudentManager();
		sM.openConnection();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action == null) {
			return;
		}

		if (action.equals("add")) {
			addStudent(request, response);
		} else if (action.equals("delete")) {
			deleteStudent(request, response);
		} else if (action.equals("update")) {
			updateStudent(request, response);
		} else if (action.equals("Delete")) {
			deleteChecked(request, response);
		}

	}

	private void deleteChecked(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Student> lstStudent = sM.getList();
		
		String[] checked = new String[lstStudent.size()];
		
		for (int i = 0; i < checked.length; i++) {
			checked[i] = request.getParameter(String.valueOf(i));
		}

		for (int i = 0; i < checked.length; i++) {
			if (checked[i] != null) {
				Student s = lstStudent.get(i);
				sM.delete(s.getIDStudent());
			}
		}

		response.sendRedirect("student.jsp");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id =  Integer.parseInt(request.getParameter("id"));
		String user =  request.getParameter("user");
		String name =  request.getParameter("name");
		String pass =  request.getParameter("pass");
		int age =  Integer.parseInt(request.getParameter("age"));
		String adress =  request.getParameter("adress");
		String email =  request.getParameter("email");
		Student s = new Student(user, name, pass, age, adress, email);
		s.setIDStudent(id);
		
		sM.update(s);
		
		response.sendRedirect("student.jsp");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PrintWriter out = response.getWriter();
		out.println(id);

	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		

		String user =  request.getParameter("user");
		String name =  request.getParameter("name");
		String pass =  request.getParameter("pass");
		int age =  Integer.parseInt(request.getParameter("age"));
		String adress =  request.getParameter("adress");
		String email =  request.getParameter("email");
		Student s = new Student(user, name, pass, age, adress, email);


		sM.add(s);

		response.sendRedirect("student.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
