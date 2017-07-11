<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Database.*"%>
<%@page import="Object.*"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Admin CP</title>
<!-- BOOTSTRAP STYLES-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<%
		Admin ad = (Admin) session.getAttribute("currentSessionAdmin");

		QuestionManager qM = new QuestionManager();
		qM.openConnection();
		
		ExamManager eM = new ExamManager();
		eM.openConnection();
		
	%>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="admincp.jsp">Quản lý</a>
			</div>
			<div
				style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">

				<form method="post" action="LogoutServlet">
					<%
					if (session.getAttribute("currentSessionAdmin") == null) {
						response.sendRedirect("login.jsp");
					} else {
						out.write(ad.getIDAdmin());
					}
					%>
					<button href="./LogoutServlet"
						class="btn btn-danger square-btn-adjust">Đăng xuất</Button>

				</form>
			</div>
		</nav>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><img src="assets/img/find_user.png"
						class="user-image img-responsive" /></li>


					<li><a href="admincp.jsp"><i
							class="fa fa-dashboard fa-3x"></i> Thống kê</a></li>
					<li><a href="#"><i class="fa fa-laptop fa-3x"></i>Học sinh<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="student.jsp">Quản lý học sinh</a> <a
								href="addstudent.jsp">Thêm học sinh</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-table fa-3x"></i> Khóa học<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="course.jsp">Quản lý khóa học</a> <a
								href="addcourse.jsp">Thêm khóa học</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-qrcode fa-3x"></i> Đề thi<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="exam.jsp">Quản lý đề thi</a> <a
								href="addexam.jsp">Thêm đề thi</a></li>
						</ul></li>
					<li><a class="active-menu" href="#"><i class="fa fa-bar-chart-o fa-3x"></i>
							Câu hỏi<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="active-menu" href="question.jsp">Quản lý câu hỏi</a> <a
								href="addquestion.jsp">Thêm câu hỏi</a></li>
						</ul>0</li>
			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Quản lý Câu hỏi</h2>
						<h5>Xóa, sữa câu hỏi</h5>

					</div>
				</div>
				<!-- /. ROW  -->
				<hr />
				<div class="row">

					<div class="col-md-12">
						<!-- /. PAGE INNER  -->
						<div class="panel panel-default">
							<div class="panel-heading">Danh sách câu hỏi</div>


							<div class="panel-body">

								<div class="table-responsive">
									<form action="QuestionServlet" method="post">
										<table class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>#</th>
													<th>Đề</th>
													<th>Câu hỏi</th>
													<th>Câu A</th>
													<th>Câu B</th>
													<th>Câu C</th>
													<th>Câu D</th>
													<th>Câu trả lời</th>
													<th></th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<%
													//String codeE = (String)request.getParameter("exam");

													//out.write(codeE);
													List<Question> lstQuestion = qM.getList();
													int id = 0;
													for (int i = 0; i < lstQuestion.size(); i++) {
														
														Question q = lstQuestion.get(i);
														Exam e = eM.getbyID(q.getCodeExam());
														out.write("\t<tr>\n");
														out.write("\t\t<td>" + q.getCodeQuest() + "</td>\n");
														out.write("\t\t<td>" + e.getNameExam() + "</td>\n");
														out.write("\t\t<td>" + q.getQuest() + "</td>\n");
														out.write("\t\t<td>" + q.getQA() + "</td>\n");
														out.write("\t\t<td>" + q.getQB() + "</td>\n");
														out.write("\t\t<td>" + q.getQC() + "</td>\n");
														out.write("\t\t<td>" + q.getQD() + "</td>\n");
														out.write("\t\t<td>" + q.getAnswer() + "</td>\n");
														out.write("\t\t<td><input type='checkbox' name='" + i + "'></td>\n");
														out.write("\t\t<td><a href='editquestion.jsp?ID=" + q.getCodeQuest()
																+ "' class='btn btn-info btn-sm'><span class='glyphicon glyphicon-edit'></span></a>");
														//out.write("\t\t <button type='submit' name='delete' class='btn btn-default btn-sm'><span class='glyphicon glyphicon-remove'></span></button></td>\n");
														//out.write("<input type='hidden' name='action' value='delete' class='btn btn-info btn-lg'>\n");
														out.write("<input type='hidden' name='id' value='" + q.getCodeQuest() + "'>\n");
														//out.write("\t\t<td><input type='checkbox' name='" + q.getCodeQuest() + "'></td>\n");
														//out.write("<td>Delete</>");
														out.write("\t</tr>\n");
													}
												%>
												<tr>
													<td colspan="12" align="right"><button type='submit'
															name='Delete' value='Xóa' class='btn btn-info btn-sm'>
															<span class='glyphicon glyphicon-remove'></span> Xóa
														</button></td>
												</tr>
											</tbody>
										</table>
										<input type="hidden" name="action" value="Delete">
									</form>
								</div>
							</div>
						</div>
						<!-- /. PAGE WRAPPER  -->
					</div>
					<!-- /. WRAPPER  -->
					<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
					<!-- JQUERY SCRIPTS -->
					<script src="assets/js/jquery-1.10.2.js"></script>
					<!-- BOOTSTRAP SCRIPTS -->
					<script src="assets/js/bootstrap.min.js"></script>
					<!-- METISMENU SCRIPTS -->
					<script src="assets/js/jquery.metisMenu.js"></script>
					<!-- CUSTOM SCRIPTS -->
					<script src="assets/js/custom.js"></script>
</body>
</html>
