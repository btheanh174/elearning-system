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

import Database.CourseManager;
import Object.Course;
/**
 * Servlet implementation class courseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CourseManager cM;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseServlet() throws ClassNotFoundException, SQLException {
		super();
		cM = new CourseManager();
		cM.openConnection();

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
			addcourse(request, response);
		} else if (action.equals("delete")) {
			deletecourse(request, response);
		} else if (action.equals("update")) {
			updatecourse(request, response);
		} else if (action.equals("Delete")) {
			deleteChecked(request, response);
		}

	}

	private void deleteChecked(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Course> lstCourse = cM.getList();
		
		String[] checked = new String[lstCourse.size()];
		
		for (int i = 0; i < checked.length; i++) {
			checked[i] = request.getParameter(String.valueOf(i));
		}

		for (int i = 0; i < checked.length; i++) {
			if (checked[i] != null) {
				Course c = lstCourse.get(i);
				cM.delete(c.getIdCourse());
			}
		}

		response.sendRedirect("course.jsp");
	}

	private void updatecourse(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int codeCourse = Integer.parseInt(request.getParameter("id"));
		String nameCourse = request.getParameter("name");
		String contentCourse = request.getParameter("content");
		
		Course c= new Course(nameCourse, contentCourse);
		c.setIdCourse(codeCourse);

		cM.update(c);
		// PrintWriter out = response.getWriter();
		//
		// out.println(course);
		response.sendRedirect("course.jsp");
	}

	private void deletecourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// response.setCharacterEncoding("utf-8");
		// response.setContentType("text/plain;");
		int id = Integer.parseInt(request.getParameter("id"));
		// qM.delete(id);
		// response.sendRedirect("course.jsp");

		PrintWriter out = response.getWriter();
		out.println(id);

	}

	private void addcourse(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String nameCourse = request.getParameter("name");
		String contentCourse = request.getParameter("content");
		
		Course c= new Course(nameCourse, contentCourse);
		cM.add(c);

		response.sendRedirect("course.jsp");

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
