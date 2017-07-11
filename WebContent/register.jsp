<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
	
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel='stylesheet prefetch' href='css/gcss.css'>
	<link rel='stylesheet prefetch' href='css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/style.css">
  </head>

  <body>   
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Hệ thống thi trắc nghiệm toán Online</h1>
</div>
	<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Đăng kí</h1>
    <form method="post" action="RegisterServlet">
     <div class="input-container">
        <input type="text" id="Username" name="name" required/>
        <label for="Username">Tên học viên</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="text" id="Username" name="user" required/>
        <label for="Username">Tên tài khoản</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" id="Password" name="pass" required/>
        <label for="Password">Mật khẩu</label>
        <div class="bar"></div>
      </div>
     <div class="input-container">
        <input type="text" id="Username" name="age" required/>
        <label for="Username">Tuổi</label>
        <div class="bar"></div>
      </div>
        <div class="input-container">
        <input type="text" id="Username" name="adress" required/>
        <label for="Username">Địa chỉ</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="text" id="Username" name="email" required/>
        <label for="Username">Email</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
        <button type="submit"><span>Đăng kí</span></button>
      </div>
      <div class="footer">Math © 2016. All Rights Reserved.</a></div>
    </form>
  </div>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
    
  </body>
</html>
