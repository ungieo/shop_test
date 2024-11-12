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

    <script src="${cpath}/include/obaju/js/respond.min.js"></script>

    <link rel="shortcut icon" href="favicon.png">


	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>
	<script type="text/javascript" src="//cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
	
	<script src="${ cpath }/include/soledot/js/soledot.js"></script>
	
	<script type="text/javascript">
		$(function(){
// 			CKEDITOR.replace('editor1', {
// 				toolbar : [],
// 				width : '100%', //---넓이값
// 				height : '200' //---높이값
// 			});
// 			CKEDITOR.replace('editor2', {
// 				toolbar : [],
// 				width : '100%', //---넓이값
// 				height : '200' //---높이값
// 			});
		})
		
		function nextPage(){
			
			var result = true;
			$(':checkbox').each(function(i){
				$(this).is(":checked");
				if( !$(this).is(":checked") ){
					alert('약관에 동의해 주십시오.');
					$(this).focus();
					result = false;
					return result;
				}
			});
			if( result ){
				handling.submit( '', 'memberadd2' );				
			}
		}
	</script>

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
                        <li>New account</li>
                    </ul>

                </div>

                <div class="col-md-12">
                    <div class="box">
                        <h1>신규 회원가입</h1>
                        <hr />
                        <form name="frm" id="frm" method="post">
                        
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <h3><label for="firstname">이용약관</label></h3>
                                        <textarea id="editor1" class="form-control" readonly="readonly" rows="15">${ model.agreementtext.CMT_VALUE }</textarea>
                                    </div>
                                    <div class="checkbox pull-right">
                                    	<label>
                                    		<input name="r_agreement" type="checkbox" /> 이용약관에 동의하십니까?
                                    	</label>
                                    </div>
                                </div>
                            </div>
                            <!-- /.row -->

                            <div class="row">
                            	<div class="col-sm-12">
                                    <div class="form-group">
                                        <h3><label for="lastname">개인정보처리방침</label></h3>
                                        <textarea id="editor2" class="form-control" readonly="readonly" rows="15">${ model.privacytext.CMT_VALUE }</textarea>
                                    </div>
                                     <div class="checkbox pull-right">
                                    	<label>
                                    		<input name="r_privacy" type="checkbox" /> 개인정보처리방침에 동의하십니까?
                                    	</label>
                                    </div>
                                </div>
                            </div>
                            <!-- /.row -->
                            <hr/>
                            <div class="row">
                            	<div class="col-sm-12" >
                            		<div class="pull-right">
                            		<button type="button" class="btn btn-primary" onclick="nextPage()">회원가입 계속</button>
									<button type="button" class="btn btn-info" onclick="history.back();">취소</button>
									</div>
                            	</div>
                            </div>

                        </form>
                    </div>
                </div>

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



</body>

</html>