package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Database.AdminManager;
import Database.StudentManager;
import Object.Admin;
import Object.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminManager am = new AdminManager();
	StudentManager sm = new StudentManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			am.openConnection();
			sm.openConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String User = request.getParameter("userID");
		String Pass = request.getParameter("password");

		// response.getWriter().println(User);
		// response.getWriter().println(Pass);

		if (am.validate(User, Pass) == true) {
			Admin admin = am.getAdminbyID(User);
			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionAdmin", admin);
			response.sendRedirect("index.jsp"); // logged-in page admin
		}
		else if(sm.validate(User, Pass) == true){
			Student st = sm.getbyUser(User);
			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", st);
			response.sendRedirect("index.jsp"); // 
		}
		else {
			response.sendRedirect("invaild.jsp"); // error page
		}

	}

}
