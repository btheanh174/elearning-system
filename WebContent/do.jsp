<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Database.*"%>
<%@page import="Object.*"%>
<%@page import="Object.Registration"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>eLearning</title>
<link rel="favicon" href="css/images/favicon.png">
<link rel="stylesheet" href="css/css/bootstrap.min.css">
<link rel="stylesheet" href="css/css/font-awesome.min.css">
<!-- Custom styles for our template -->
<link rel="stylesheet" href="css/css/bootstrap-theme.css" media="screen">
<link rel="stylesheet" type="text/css" href="css/css/da-slider.css" />
<link rel="stylesheet" href="css/css/style.css">
<link rel="stylesheet" href="css/metro.css">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	<script src="css/js/html5shiv.js"></script>
	<script src="css/js/respond.min.js"></script>
	<![endif]-->
	<style type="text/css">
<!--

.question {
	font-size: 20px!important;
	font-family: "Segoe UI",Arial,sans-serif;
}
.answers {
	font-size: 20px!important;
	font-family: "Segoe UI",Arial,sans-serif;
}
input[type=radio] {
    padding: 0;
    margin-right: 5px;
}
-->
</style>
</head>
<body>
	<%
		Student s = (Student) session.getAttribute("currentSessionUser");
		Admin ad = (Admin) session.getAttribute("currentSessionAdmin");

		RegistrationManager rM = new RegistrationManager();
		rM.openConnection();
		QuestionManager qM = new QuestionManager();
		qM.openConnection();
		ExamManager eM = new ExamManager();
		eM.openConnection();

		CourseManager cM = new CourseManager();
		cM.openConnection();
		int idregis = Integer.parseInt(request.getParameter("regis"));

		Registration r = rM.getbyID(idregis);

		if (session.getAttribute("currentSessionUser") == null) {

			response.sendRedirect("login.jsp");
		}
		
	%>
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp"> <img
					src="css/images/logo.png" alt="Techro HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right mainNav">
					<li><a href="index.jsp">Trang chủ</a></li>
					<li><a href="about.jsp">Thông tin</a></li>
					<li class="active"><a href="regiscourses.jsp">Khóa học</a></li>
					<%
						if (session.getAttribute("currentSessionUser") == null
								&& session.getAttribute("currentSessionAdmin") == null) {
							out.write("<li><a href='login.jsp'>Đăng nhập</a></li>");
							out.write("<li><a href='register.jsp'>Đăng ký</a></li>");
						}
						if (session.getAttribute("currentSessionUser") != null) {
							out.write("<li><a href='myregistration.jsp'>Phiếu đăng ký</a></li>");
							out.write("<li><a href='./LogoutServlet'>Đăng xuất</a></li>");
							out.write("<li class='c3'><a>Chào " + s.getNameStudent() + "</a>");
						}

						if (session.getAttribute("currentSessionAdmin") != null) {
							out.write("<li><a href='admincp.jsp'>Admincp</a></li>");
							out.write("<li><a href='./LogoutServlet'>Đăng xuất</a></li>");
							out.write("<li class='c3'><a>Chào " + ad.getIDAdmin());
						}
					%>

				</ul>
			</div>
		</div>
	</div>
	<!-- /.navbar -->

	<header id="head" class="secondary">
		<div class="container">
			<div class="row">
				<div class="col-sm-8">
					<h1>Làm Bài<%out.write(" "+r.getCodeRegis()); %></h1>
				</div>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>
					<strong>Làm</strong>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<%
					List<Question> lstQuestion = qM.getListbyExam(r.getCodeExam());

					for (int i= 0;i<lstQuestion.size();i++) {
						Question q = lstQuestion.get(i);
						out.write("<div class='container'>");
						out.write("<div class='row'>");

						out.write("<div class='col-md-6 panel'>");

						out.write("<form method='post' action='PhepTinhServlet'>");
						out.write("<p class='question'>" +(i+1)+". "+ q.getQuest() + "</p><br/>");
						out.write("<ul class='answers'>");
						out.write("<input type='radio' name='Q' value='1' id='q1a'><label for='qA'>" + q.getQA()
								+ "</label><br/>");
						out.write("<input type='radio' name='Q' value='2' id='q1a'><label for='qB'>" + q.getQB()
								+ "</label><br/>");
						out.write("<input type='radio' name='Q' value='3' id='q1a'><label for='qC'>" + q.getQC()
								+ "</label><br/>");
						out.write("<input type='radio' name='Q' value='4' id='q1a'><label for='qD'>" + q.getQD()
								+ "</label><br/>");
						out.write("</ul>");
						
						//out.write("<input type='submit' value='Chọn'<br/>");

						out.write("</form>");

						out.write("</div>");
						out.write("</div>");
						out.write("</div>");

					}
					
					
				%>
				<a href="do.jsp?regis=" class="btn btn-info btn-sm">Chấm điểm</a>
			</div>

		</div>
	</div>

	<footer id="footer">
		<div class="container">
			<div class="social text-center">
				<a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
					class="fa fa-facebook"></i></a> <a href="#"><i
					class="fa fa-dribbble"></i></a> <a href="#"><i class="fa fa-flickr"></i></a>
				<a href="#"><i class="fa fa-github"></i></a>
			</div>

			<div class="clear"></div>
			<!--CLEAR FLOATS-->
		</div>
		<div class="footer2">
			<div class="container">
				<div class="row">

					<div class="col-md-6 panel">
						<div class="panel-body"></div>
					</div>

					<div class="col-md-6 panel">
						<div class="panel-body">
							<p class="text-right">Elearning &copy; 2016. All Rights
								Reserved.</p>
						</div>
					</div>

				</div>
				<!-- /row of panels -->
			</div>
		</div>
	</footer>




	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/custom.js"></script>
</body>
</html>
