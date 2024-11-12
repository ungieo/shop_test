<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>Welcome NRZB!</title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

    <!-- styles -->
    <link href="${cpath}/include/obaju/css/font-awesome.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/bootstrap.min.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/animate.min.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/owl.carousel.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/owl.theme.css" rel="stylesheet">

    <!-- theme stylesheet -->
    <link href="${cpath}/include/obaju/css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- your stylesheet with modifications -->
    <link href="${cpath}/include/obaju/css/custom.css" rel="stylesheet">

    <script src="${cpath}/include/obaju/jsrespond.min.js"></script>

    <link rel="shortcut icon" href="favicon.png">



</head>

<body>

	<%@include file="/include/jsp/header.jsp" %>

    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">

                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li>New account / Sign in</li>
                    </ul>

                </div>

                <div class="col-md-12">
                    <div class="box">
                        <h1>New account</h1>

                        <p class="lead">Not our registered customer yet?</p>
                        <p>With registration with us new world of fashion, fantastic discounts and much more opens to you! The whole process will not take you more than a minute!</p>
                        <p class="text-muted">If you have any questions, please feel free to <a href="contact.html">contact us</a>, our customer service center is working for you 24/7.</p>

                        <hr>

                        <form action="customer-orders.html" method="post">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" id="name">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" class="form-control" id="email">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-user-md"></i> Register</button>
                            </div>
                        </form>
                    </div>
                </div>

<!--                 <div class="col-md-6"> -->
<!--                     <div class="box"> -->
<!--                         <h1>Login</h1> -->

<!--                         <p class="lead">Already our customer?</p> -->
<!--                         <p class="text-muted">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies -->
<!--                             mi vitae est. Mauris placerat eleifend leo.</p> -->

<!--                         <hr> -->

<!--                         <form action="customer-orders.html" method="post"> -->
<!--                             <div class="form-group"> -->
<!--                                 <label for="email">Email</label> -->
<!--                                 <input type="text" class="form-control" id="email"> -->
<!--                             </div> -->
<!--                             <div class="form-group"> -->
<!--                                 <label for="password">Password</label> -->
<!--                                 <input type="password" class="form-control" id="password"> -->
<!--                             </div> -->
<!--                             <div class="text-center"> -->
<!--                                 <button type="submit" class="btn btn-primary"><i class="fa fa-sign-in"></i> Log in</button> -->
<!--                             </div> -->
<!--                         </form> -->
<!--                     </div> -->
<!--                 </div> -->


            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

		<!-- footer content -->
		<%@include file="/include/jsp/footer.jsp" %>
		<!-- /footer content -->

    </div>
    <!-- /#all -->


    

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>
    <script src="${cpath}/include/obaju/jsbootstrap.min.js"></script>
    <script src="${cpath}/include/obaju/jsjquery.cookie.js"></script>
    <script src="${cpath}/include/obaju/jswaypoints.min.js"></script>
    <script src="${cpath}/include/obaju/jsmodernizr.js"></script>
    <script src="${cpath}/include/obaju/jsbootstrap-hover-dropdown.js"></script>
    <script src="${cpath}/include/obaju/jsowl.carousel.min.js"></script>
    <script src="${cpath}/include/obaju/jsfront.js"></script>



</body>

</html>