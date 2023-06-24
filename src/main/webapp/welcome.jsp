<%@page import="org.hibernate.Session"%>
<%@page import="com.unique.app.main.Login"%>
<%@page import="org.hibernate.Transaction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Login</title>
    <script>
        function toggleImage() {
            var image = document.getElementById("myImage");
            if (image.style.display === "none") {
                image.style.display = "block";
                document.getElementById("showImage").value = "true";
            } else {
                image.style.display = "none";
                document.getElementById("showImage").value = "false";
            }
        }
    </script>
</head>
<body>
<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <div>
                                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Welcome</p>
                                </div>
                                <div>
                                    <h3 align="center"><%=  session.getAttribute("email") %></h3>
                                </div>
                                <div align="center">
                                    <form action="process" method="post">
                                        <input type="hidden" id="showImage" name="showImage" value="false">
                                        <input class="form-check-input me-2" type="checkbox" value="true" id="toggle" onchange="toggleImage()" name="qr" />
                                        <label class="form-check-label" for="form2Example3">Add Security</label>
                                        <div class="d-flex justify-content-left mx-4 mb-3 mb-lg-4">
                                            <input type="submit" class="btn btn-primary btn-lg" name="submit">
                                        </div>
                                    </form>
                                </div>
                                <img id="myImage" src="QRCode.png" style="display: none;" height="100px">
                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">
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
