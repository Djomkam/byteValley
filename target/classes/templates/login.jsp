<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link href='../static/css/core.css' rel='stylesheet'/>
     	<link href='../static/css/login.css'  rel='stylesheet'/>
     	<link href='http://cdn.jsdelivr.net/webjars/bootstrap/3.3.2/css/bootstrap.min.css' rel='stylesheet' media='screen' />
	</head>
	<body>
		<div class='wrapper'>
      
      <!-- login box -->
      <div class='login_boxes login_box'>
       	<p class='sign_in_message'>Sign in</p>
       	
       	<!-- login box content -->
        <div class='login_boxes login_box_content'>
	       
	       	<!-- failed login error message 
	       	<div class='alert alert-danger' th:if='${param.error}'>
	            <p th:text='#{login.error.message}'>Invalid username and password</p>
	        </div>-->
	        
	        <!-- logout message 
	        <div class='alert alert-success' th:if='${param.logout}'>
	            <p th:text='#{logout.message}'>You have been logged out</p>
	        </div>-->
	        
	        <form method='post' action='/login'>
	          <div class='form-group has-feedback'>
	            <input type='text' class='form-control' name='username' placeholder='Username' />
	            <span class='glyphicon glyphicon-user form-control-feedback'></span>
	          </div>
	          <div class='form-group has-feedback'>
	            <input type='password' class='form-control' placeholder='Password' name='password' />
	            <span class='glyphicon glyphicon-lock form-control-feedback'></span>
	          </div>
	          <div class='row'>
	            <div class='col-xs-4'>
	              <button type='submit' class='btn btn-primary btn-block btn-flat'>Sign In</button>
	            </div>
	           	<div class='col-xs-8'>
	              <div class='checkbox icheck'>
	                <label><input type='checkbox' name='_spring_security_remember_me' />Remember Me</label>
	              </div>
	            </div>
	          </div>
	          <input type='hidden' name='${_csrf.parameterName}' value='${_csrf.token}' />
	        </form>
			<hr/>
	        <a href='/forgot' style='margin-bottom:10px;display: block;'>Forgot your password?</a>
	        <a href='/register' class='text-center'>Not a Member? Sign Up</a>
		</div>
		<!-- end- login box content -->
		
      </div>
      <!-- end- login-box -->
      
      <div class="footer">
	  		<p>This is the footer</p>
	  </div>
    </div>
    
    <script src='http://cdn.jsdelivr.net/webjars/bootstrap/3.3.2/bootstrap.min.js'></script>
    <script src='http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js'></script>
	</body>
</html>