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

import Database.ExamManager;
import Object.Exam;

/**
 * Servlet implementation class ExamServlet
 */
@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ExamManager eM;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public ExamServlet() throws ClassNotFoundException, SQLException {
		super();
		eM = new ExamManager();
		eM.openConnection();

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
			addExam(request, response);
		} else if (action.equals("delete")) {
			deleteExam(request, response);
		} else if (action.equals("update")) {
			updateExam(request, response);
		} else if (action.equals("Delete")) {
			deleteChecked(request, response);
		}

	}

	private void deleteChecked(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Exam> lstExam = eM.getList();
		
		String[] checked = new String[lstExam.size()];
		
		for (int i = 0; i < checked.length; i++) {
			checked[i] = request.getParameter(String.valueOf(i));
		}

		for (int i = 0; i < checked.length; i++) {
			if (checked[i] != null) {
				Exam e = lstExam.get(i);
				eM.delete(e.getCodeExam());
			}
		}

		response.sendRedirect("exam.jsp");
	}

	private void updateExam(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int codeExam = Integer.parseInt(request.getParameter("id"));
		int codeCourse = Integer.parseInt(request.getParameter("codeCourse"));
		String Exam = request.getParameter("exam");
		
		Exam e= new Exam(Exam, codeCourse);
		e.setCodeExam(codeExam);

		eM.update(e);
		// PrintWriter out = response.getWriter();
		//
		// out.println(Exam);
		response.sendRedirect("exam.jsp");
	}

	private void deleteExam(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// response.setCharacterEncoding("utf-8");
		// response.setContentType("text/plain;");
		int id = Integer.parseInt(request.getParameter("id"));
		// qM.delete(id);
		// response.sendRedirect("Exam.jsp");

		PrintWriter out = response.getWriter();
		out.println(id);

	}

	private void addExam(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int codeCourse = Integer.parseInt(request.getParameter("codeCourse"));
		String Exam = request.getParameter("exam");

		Exam e = new Exam(Exam, codeCourse);
		eM.add(e);

		response.sendRedirect("exam.jsp");

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
