<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Otp </title>
</head>
<body>
<section class="vh-100" style="background-color: #eee;">
<%
	PrintWriter pw = response.getWriter();
	String email=(String)session.getAttribute("email");  
%>
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-12 col-xl-5 order-2 order-lg-1">

       
                <div class="container d-flex justify-content-center align-items-center">

						 <div class="card text-center">
						
							<div class="card-header p-5">
								<img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                  class="img-fluid" alt="Sample image">
								<h5 class="mb-2">OTP VERIFICATION</h5>
								<div>
									<small>code has been send to ******1258</small>
								</div>
							</div>
						<form action="otp" method="post">
							<input type="text" hidden="true" name="email" value="<%= session.getAttribute("email") %>">
							<div class="input-container d-flex flex-row justify-content-center mt-2">
								<input type="text" class="m-1 text-center form-control rounded" maxlength="1" name="d1">
								<input type="text" class="m-1 text-center form-control rounded" maxlength="1" name="d2">
								<input type="text" class="m-1 text-center form-control rounded" maxlength="1" name="d3">
								<input type="text" class="m-1 text-center form-control rounded" maxlength="1" name="d4">
								<input type="text" class="m-1 text-center form-control rounded" maxlength="1" name="d5">
								<input type="text" class="m-1 text-center form-control rounded" maxlength="1" name="d6">
							</div>
						
						 <div>
						 	<small>
						 		didn't get the otp
								<a href="#" class="text-decoration-none">Resend</a>
						 	</small>
						 </div>
						
						 <div class="mt-3 mb-5">
						 	<input type="submit" class="btn btn-primary btn-lg"
												name="submit" value="Submit">
						 </div>
						 
						 	</form>
						
						 </div>

</div>

             
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>