package Controller;


import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.RegistrationManager;
import Object.Registration;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegistrationManager rM;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() throws ClassNotFoundException, SQLException {
		super();
		rM = new RegistrationManager();
		rM.openConnection();

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
			addRegistration(request, response);
		} else if (action.equals("delete")) {
			deleteRegistration(request, response);
		} else if (action.equals("update")) {
			updateRegistration(request, response);
		} else if (action.equals("Delete")) {
			deleteChecked(request, response);
		}

	}

	private void deleteChecked(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// List<Registration> lstRegistration = qM.getList();
		//
		// String[] checked = new String[lstRegistration.size()];
		//
		// for (int i = 0; i < checked.length; i++) {
		// checked[i] = request.getParameter(String.valueOf(i));
		// }
		//
		// for (int i = 0; i < checked.length; i++) {
		// if (checked[i] != null) {
		// Registration s = lstRegistration.get(i);
		// qM.delete(s.getCodeQuest());
		// }
		// }
		//
		// response.sendRedirect("Registration.jsp");
	}

	private void updateRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// int codeRegistration = Integer.parseInt(request.getParameter("id"));
		// int codeExam = Integer.parseInt(request.getParameter("codeExam"));
		// String Registration = request.getParameter("Registration");
		// String qA = request.getParameter("qA");
		// String qB = request.getParameter("qB");
		// String qC = request.getParameter("qC");
		// String qD = request.getParameter("qD");
		// String answer = request.getParameter("answer");
		// Registration q = new Registration(codeExam, Registration, qA, qB, qC,
		// qD, answer);
		// q.setCodeQuest(codeRegistration);
		//
		// qM.update(q);
		// // PrintWriter out = response.getWriter();
		// //
		// // out.println(Registration);
		// response.sendRedirect("Registration.jsp");
	}

	private void deleteRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
				int id = Integer.parseInt(request.getParameter("idregis"));
				 rM.delete(id);
				 response.sendRedirect("myregistration.jsp");

			
	}

	private void addRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int codeExam = Integer.parseInt(request.getParameter("idexam"));
		int codeStudent = Integer.parseInt(request.getParameter("idstudent"));
		Registration r = new Registration(codeStudent, codeExam, false);
		rM.add(r);
		response.sendRedirect("myregistration.jsp");
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
