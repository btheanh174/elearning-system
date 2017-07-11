package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Database.StudentManager;
import Object.Student;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentManager sm = new StudentManager();

	/**
	 * Default constructor.
	 */
	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			sm.openConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String User = request.getParameter("user");
		String Pass = request.getParameter("pass");
		String Name = request.getParameter("name");
		int Age = Integer.parseInt(request.getParameter("age"));
		String Adress = request.getParameter("adress");
		String Email  = request.getParameter("email");

		// response.getWriter().println(User);
		// response.getWriter().println(Pass);

		Student sv = new Student(User,Name, Pass,Age, Adress, Email);
		
		sm.add(sv);
		HttpSession session = request.getSession(true);
		session.setAttribute("currentSessionUser", sv);
		response.sendRedirect("success.jsp"); // logged-in page admin }

	}

}
