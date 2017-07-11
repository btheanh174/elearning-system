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

import Database.QuestionManager;
import Object.Question;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestionManager qM;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public QuestionServlet() throws ClassNotFoundException, SQLException {
		super();
		qM = new QuestionManager();
		qM.openConnection();

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
			addQuestion(request, response);
		} else if (action.equals("delete")) {
			deleteQuestion(request, response);
		} else if (action.equals("update")) {
			updateQuestion(request, response);
		} else if (action.equals("Delete")) {
			deleteChecked(request, response);
		}

	}

	private void deleteChecked(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Question> lstQuesTion = qM.getList();
		
		String[] checked = new String[lstQuesTion.size()];
		
		for (int i = 0; i < checked.length; i++) {
			checked[i] = request.getParameter(String.valueOf(i));
		}

		for (int i = 0; i < checked.length; i++) {
			if (checked[i] != null) {
				Question s = lstQuesTion.get(i);
				qM.delete(s.getCodeQuest());
			}
		}

		response.sendRedirect("question.jsp");
	}

	private void updateQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int codequestion = Integer.parseInt(request.getParameter("id"));
		int codeExam = Integer.parseInt(request.getParameter("codeExam"));
		String question = request.getParameter("question");
		String qA = request.getParameter("qA");
		String qB = request.getParameter("qB");
		String qC = request.getParameter("qC");
		String qD = request.getParameter("qD");
		String answer = request.getParameter("answer");
		Question q = new Question(codeExam, question, qA, qB, qC, qD, answer);
		q.setCodeQuest(codequestion);

		qM.update(q);
		// PrintWriter out = response.getWriter();
		//
		// out.println(question);
		response.sendRedirect("question.jsp");
	}

	private void deleteQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	}

	private void addQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int codeExam = Integer.parseInt(request.getParameter("codeExam"));
		String question = request.getParameter("question");
		String qA = request.getParameter("qA");
		String qB = request.getParameter("qB");
		String qC = request.getParameter("qC");
		String qD = request.getParameter("qD");
		String answer = request.getParameter("answer");

		Question q = new Question(codeExam, question, qA, qB, qC, qD, answer);

		PrintWriter out = response.getWriter();

		out.println(question);
		qM.add(q);

		response.sendRedirect("question.jsp");

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
