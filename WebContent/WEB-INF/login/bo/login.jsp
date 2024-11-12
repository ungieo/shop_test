<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<title>Welcome Soledot!</title>

	<!-- Bootstrap core CSS -->
	
	<link href="${cpath}/include/css/bootstrap.min.css" rel="stylesheet" />
	
	<link href="${cpath}/include/fonts/css/font-awesome.min.css" rel="stylesheet" />
	<link href="${cpath}/include/css/animate.min.css" rel="stylesheet" />
	
	<!-- Custom styling plus plugins -->
	<link href="${cpath}/include/css/custom.css" rel="stylesheet" />
	<link href="${cpath}/include/css/icheck/flat/green.css" rel="stylesheet" />
	
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>	<!-- jquery cdn -->
<%-- 	<script src="${cpath}/include/js/validator/validator.js"></script> --%>

	<script src="${ cpath }/include/soledot/js/jquery-validation/jquery.validate.js"></script> 
	<script src="${ cpath }/include/soledot/js/jquery-validation/additional-methods.js"></script>
	<script src="${ cpath }/include/soledot/js/jquery-validation/localization/messages_ko.js"></script>
	<script src="${ cpath }/include/soledot/js/soledot.js"></script>

	<!--[if lt IE 9]>
	<script src="../assets/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

<script type="text/javascript">
	
	$(function(){
// 		$( 'input[name="r_mbid"]' ).focus();
		$( '#frm' ).validate();
	});
	
	function formSubmit(){
		if( '' == $('#r_mbid').val() || '' == $('#r_mbpswd').val() ){
			alert( '로그인 정보를 입력해주십시오' );
			return;
		}
		handling.submit();
	}
	
	function keyCheck(event){
		if( event.keyCode == 13 ){
			formSubmit();
		}
	}
	
</script>
</head>
<body style="background:#F7F7F7;">

	<div class="">
<!-- 	    <a class="hiddenanchor" id="toregister"></a> -->
<!-- 	    <a class="hiddenanchor" id="tologin"></a> -->

		<div id="wrapper">
			<div id="login" class="animate form">
				<section class="login_content">
					<form name="frm" id="frm" action="membercheck" method="post" >
						<h1>Login Form</h1>
						<div>
							<input id="r_mbid" name="r_mbid" onkeypress="keyCheck(event)" type="text" class="form-control" placeholder="Username" required autofocus />
						</div>
						<div>
							<input id="r_mbpswd" name="r_mbpswd" onkeypress="keyCheck(event)" type="password" class="form-control" placeholder="Password" required />
						</div>
						<div>
							<a class="btn btn-default submit" onclick="formSubmit();">Log in</a>
<!-- 							<a class="reset_pass" href="#">Lost your password?</a> -->
						</div>
						<div class="clearfix"></div>
						<div class="separator">
<!-- 							<p class="change_link">New to site?<a href="#toregister" class="to_register"> Create Account </a></p> -->
							<div class="clearfix"></div>
							<br />
							<div>
								<h1><i class="fa fa-paw" style="font-size: 26px;"></i>Soledot</h1>
							<p>©2016 All Rights Reserved.</p>
							</div>
						</div>
					</form>
					<!-- form -->
				</section>
				<!-- content -->
			</div>
		
<!-- 			<div id="register" class="animate form"> -->
<!-- 				<section class="login_content"> -->
<!-- 					<form> -->
<!-- 						<h1>Create Account</h1> -->
<!-- 						<div> -->
<!-- 							<input type="text" class="form-control" placeholder="Username" required="" /> -->
<!-- 						</div> -->
<!-- 						<div> -->
<!-- 							<input type="email" class="form-control" placeholder="Email" required="" /> -->
<!-- 						</div> -->
<!-- 						<div> -->
<!-- 							<input type="password" class="form-control" placeholder="Password" required="" /> -->
<!-- 						</div> -->
<!-- 						<div> -->
<!-- 							<a class="btn btn-default submit" href="index.html">Submit</a> -->
<!-- 						</div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 						<div class="separator"> -->
<!-- 							<p class="change_link">Already a member ?<a href="#tologin" class="to_register"> Log in </a></p> -->
<!-- 							<div class="clearfix"></div> -->
<!-- 							<br /> -->
<!-- 							<div> -->
<!-- 								<h1><i class="fa fa-paw" style="font-size: 26px;"></i>Gentelella Alela!</h1> -->
<!-- 								<p>©2015 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</form> -->
<!-- 					form -->
<!-- 				</section> -->
<!-- 				content -->
<!-- 			</div> -->
			
		</div>
		
	</div>
  
<!-- 	<div class="container"> -->

<%-- 		<%@ include file="/include/jsp/header.jsp" %> --%>
	
<!-- 		<form action="membercheck" class="form-signin" name="frm" method="post"> -->
<!-- 			<h2 class="form-signin-heading">Please sign in</h2> -->
			
<!-- 			<label for="r_mbid" class="sr-only">아이디</label> -->
<!-- 			<input type="text" id="r_mbid" name="r_mbid" class="form-control" onkeypress="keyCheck(event)" placeholder="ID" required autofocus /> -->
			
<!-- 			<label for="r_mbpswd" class="sr-only">비밀번호</label> -->
<!-- 			<input type="password" id="r_mbpswd" name="r_mbpswd" class="form-control" onkeypress="keyCheck(event)" placeholder="Password" required /> -->
			
<!-- 			<div class="checkbox"> -->
<!-- 				<label> -->
<!-- 					<input type="checkbox" value="remember-me" /> Remember me -->
<!-- 				</label> -->
<!-- 			</div> -->
<!-- 			<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="formSubmit()">로그인</button> -->
<!-- 		</form> -->
	
<%-- 		<%@ include file="/include/jsp/footer.jsp" %> --%>
	
<!-- 	</div> -->
	
</body>
</html>