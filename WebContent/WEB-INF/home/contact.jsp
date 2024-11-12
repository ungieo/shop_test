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
    <meta name="description" content="soledot e-commerce">
    <meta name="author" content="soledot">
    <meta name="keywords" content="">

    <title>Welcome nrzb!</title>

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

    <script src="${cpath}/include/obaju/js/respond.min.js"></script>

    <link rel="shortcut icon" href="favicon.png">

	<script src="${cpath}/include/obaju/js/jquery-1.11.0.min.js"></script>

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
                        <li>Contact</li>
                    </ul>

                </div>

                <div class="col-md-3">
                    <!-- *** PAGES MENU ***
 _________________________________________________________ -->
                    <div class="panel panel-default sidebar-menu">

                        <div class="panel-heading">
                            <h3 class="panel-title">Pages</h3>
                        </div>

                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li>
<!--                                     <a href="text.html">Text page</a> -->
                                </li>
                                <li>
<!--                                     <a href="contact.html">Contact page</a> -->
                                </li>
                                <li>
                                    <a href="${cpath}/boardarticle/boardarticlefaqlist?r_bdabdid=faq">FAQ</a>
                                </li>

                            </ul>

                        </div>
                    </div>

                    <!-- *** PAGES MENU END *** -->


                    <div class="banner">
                        <a href="#">
                            <img src="${cpath}/include/obaju/img/banner.jpg" alt="sales 2014" class="img img-responsive">
                        </a>
                    </div>
                </div>

                <div class="col-md-9">


                    <div class="box" id="contact">
                        <h1>Contact</h1>

                        <p class="lead">Are you curious about something? Do you have some kind of problem with our products?</p>
                        <p>Please feel free to contact us, our customer service center is working for you 24/7.</p>

                        <hr>

                        <div class="row">
                            <div class="col-sm-4">
                                <h3><i class="fa fa-map-marker"></i> Address</h3>
                                <p>
									서울특별시 강동구<br/> 
									양재대로 115길<br/>
                                    <strong>대한민국</strong>
                                </p>
                            </div>
                            <!-- /.col-sm-4 -->
                            <div class="col-sm-4">
                                <h3><i class="fa fa-phone"></i> 고객센터</h3>
                                <p class="text-muted">This number is toll free if calling from Great Britain otherwise we advise you to use the electronic form of communication.</p>
                                <p><strong>070-8886-1979</strong>
                                </p>
                            </div>
                            <!-- /.col-sm-4 -->
                            <div class="col-sm-4">
                                <h3><i class="fa fa-envelope"></i> 기술지원</h3>
                                <p class="text-muted">시스템에 대한 문의 사항</p>
                                <ul>
                                    <li><strong><a href="mailto:">master@nrzb.com</a></strong></li>
                                </ul>
                            </div>
                            <!-- /.col-sm-4 -->
                        </div>
                        <!-- /.row -->

                        <hr>

                        <div id="map">

                        </div>

                        <hr>
                        <h2>Contact form</h2>

                        <form>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label for="firstname">Firstname</label>
                                        <input type="text" class="form-control" id="firstname">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label for="lastname">Lastname</label>
                                        <input type="text" class="form-control" id="lastname">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="text" class="form-control" id="email">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label for="subject">Subject</label>
                                        <input type="text" class="form-control" id="subject">
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <label for="message">Message</label>
                                        <textarea id="message" class="form-control"></textarea>
                                    </div>
                                </div>

                                <div class="col-sm-12 text-center">
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-envelope-o"></i> Send message</button>

                                </div>
                            </div>
                            <!-- /.row -->
                        </form>


                    </div>


                </div>
                <!-- /.col-md-9 -->
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
    <script src="${cpath}/include/obaju/js/bootstrap.min.js"></script>
    <script src="${cpath}/include/obaju/js/jquery.cookie.js"></script>
    <script src="${cpath}/include/obaju/js/waypoints.min.js"></script>
    <script src="${cpath}/include/obaju/js/modernizr.js"></script>
    <script src="${cpath}/include/obaju/js/bootstrap-hover-dropdown.js"></script>
    <script src="${cpath}/include/obaju/js/owl.carousel.min.js"></script>
    <script src="${cpath}/include/obaju/js/front.js"></script>




<!--     <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false"></script> -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDr5sHsrpVnCmPYVM0TFQ2-NrHv--twduA"></script>

    <script>
        function initialize() {
            var mapOptions = {
                zoom: 15,
                center: new google.maps.LatLng(37.537847, 127.139888),
                mapTypeId: google.maps.MapTypeId.ROAD
//                 ,scrollwheel: false		//스크롤 확대축소여부
            }
            var map = new google.maps.Map(document.getElementById('map'),
                mapOptions);

            var myLatLng = new google.maps.LatLng(37.537847, 127.139888);
            var marker = new google.maps.Marker({
                position: myLatLng,
                map: map
            });
        }

        google.maps.event.addDomListener(window, 'load', initialize);
    </script>


</body>

</html>
