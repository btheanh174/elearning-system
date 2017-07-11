<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Database.*"%>
<%@page import="Object.*"%>
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
</head>
<body>
	<%
		Student s = (Student) session.getAttribute("currentSessionUser");
		Admin ad = (Admin) session.getAttribute("currentSessionAdmin");

		ExamManager eM = new ExamManager();
		eM.openConnection();

		CourseManager cM = new CourseManager();
		cM.openConnection();

		int idCourse = Integer.parseInt(request.getParameter("course"));
		int idExam = Integer.parseInt(request.getParameter("exam"));

		Course c = cM.getbyID(idCourse);
		Exam e = eM.getbyID(idExam);
		
		if (session.getAttribute("currentSessionUser") == null){
			
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
					<h1>Phiếu đăng ký</h1>
				</div>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>
					<strong>Đăng ký</strong>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<form action="RegistrationServlet" method="post">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>Khóa học</th>
								<th>Đề thi</th>
							</tr>
						</thead>
						<tbody>
							<%
								out.write("\t<tr>\n");
								out.write("\t\t<td>" + c.getNameCourse() + "</td>\n");
								out.write("\t\t<td>" + e.getNameExam() + "</td>\n");
								if (session.getAttribute("currentSessionUser") != null) {
								out.write("<input type='hidden' name='idstudent' value='" + s.getIDStudent() + "'>\n");
								}
								out.write("<input type='hidden' name='idcourse' value='" + c.getIdCourse() + "'>\n");
								out.write("<input type='hidden' name='idexam' value='" + e.getCodeExam() + "'>\n");

							%>
							<tr>
								<td colspan="12" align="center"><button type='submit'
										name='add' value='add' class='btn btn-info btn-lg'>
										 Đăng kí
									</button></td>
							</tr>
						</tbody>
					</table>
					<input type="hidden" name="action" value="add">
				</form>
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
