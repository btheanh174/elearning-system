<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import = "Database.*" %>
<%@page import = "Object.*"   %>
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
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
 <%
 	QuestionManager qM = new QuestionManager();
 	qM.openConnection();
 	
 	ExamManager eM = new ExamManager();
 	eM.openConnection();
 %>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Quản lý</a> 
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;"> Last access : 30 May 2014 &nbsp; <a href="login.html" class="btn btn-danger square-btn-adjust">Logout</a> </div>
        </nav>   
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="assets/img/find_user.png" class="user-image img-responsive"/>
					</li>
				
					
                    <li>
                        <a href="index.html"><i class="fa fa-dashboard fa-3x"></i> Thống kê</a>
                    </li>
                     <li  >
                        <a href="#"><i class="fa fa-laptop fa-3x"></i>Học sinh<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
							<li>
                            	<a href="#">Quản lý học sinh</a> 
                            	<a href="#">Thêm học sinh</a>
                            </li>
						</ul>
                    </li>	
                     <li>
                        <a  href="#"><i class="fa fa-table fa-3x"></i> Khóa học<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
							<li>
                            	<a href="#">Quản lý khóa học</a> 
                            	<a href="#">Thêm khóa học</a>
                            </li>
						</ul>
                    </li>
                    <li>
                        <a  href="#"><i class="fa fa-qrcode fa-3x"></i> Đề thi<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
							<li>
                            	<a href="#">Quản lý đề thi</a> 
                            	<a href="#">Thêm đề thi</a>
                            </li>
						</ul>
                        
                    </li>
						   <li  >
                        <a class="active-menu" href="#"><i class="fa fa-bar-chart-o fa-3x"></i> Câu hỏi<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
							<li>
                            	<a class="active-menu" href="#">Quản lý câu hỏi</a> 
                            	<a href="#">Thêm câu hỏi</a>
                            </li>
						</ul>0
                    </li>	                         
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Thêm học sinh</h2>   
                        <h5>Thêm</h5>
                       
                    </div>
                </div>
                 <!-- /. ROW  -->
                 <hr />
                 <div class="row">
                <div class="col-md-2">
                           <label>Đề</label><select class="form-control" name= "codeExam">
                                                <%
                                                List<Exam> lstExam = eM.getList();
                                                for(Exam ex: lstExam)
                                                {
                                					out.write("<option>" + ex.getCodeExam() + "</option>");
                                                }
                                                %>
                                            </select>
                                            </div>   
                <div class="col-md-12">
             <!-- /. PAGE INNER  -->
            <div class="panel panel-default">
                        <div class="panel-heading">
                            Danh sách câu hỏi
                        </div>
                        
                       
                        <div class="panel-body">
                       
                            <div class="table-responsive">
                                                        
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Câu hỏi</th>
                                            <th>Câu A</th>
                                            <th>Câu B</th>
                                            <th>Câu C</th>
                                            <th>Câu D</th>
                                            <th>Câu trả lời</th>
                                            <th> </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Hai phương trình được gọi là tương đương khi :</td>
                                            <td>Có cùng dạng phương trình  </td>
                                            <td>Có cùng tập xác định </td>
                                            <td>Có cùng tập hợp nghiệm </td>
                                            <td>Cả a, b, c đều đúng </td>
                                            <td>D </td>
                                            <td>Edit|Detele</td>
                                        </tr>
                                        <%
                                        int codeExam =  Integer.parseInt(request.getParameter("codeExam"));
                                        List<Question> lstQuestion = qM.getListbyExam(codeExam);
                                        for(Question q : lstQuestion){
                                        out.write("\t<tr>\n");
                                        out.write("\t\t<td>" + q.getCodeQuest()  + "</td>\n");
                                        out.write("\t\t<td>" + q.getQuest()  + "</td>\n");
                                        out.write("\t\t<td>" + q.getQA()  + "</td>\n");
                                        out.write("\t\t<td>" + q.getQB()  + "</td>\n");
                                        out.write("\t\t<td>" + q.getQC()  + "</td>\n");
                                        out.write("\t\t<td>" + q.getQD()  + "</td>\n");
                                        out.write("\t\t<td>" + q.getAnswer()  + "</td>\n");
                                        out.write("\t\t<td>Edit|Detele</td>\n");
                                        out.write("\t</tr>\n");
                                        }
                                        %>              
                                    </tbody>
                                </table>
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
