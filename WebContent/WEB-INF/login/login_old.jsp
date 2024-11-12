<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="" />
    <meta name="author" content="" />
    
    <link rel="stylesheet" href="${ cpath }/include/style/bootstrap/signin.css" />
<%@include file="/include/jsp/commonhead.jsp"%>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript">
	
	$(function(){
		$( 'input[name="r_mbid"]' ).focus();
	});
	
	function formSubmit(){
		if( '' == $('#rmbid').val() || '' == $('#r_mbpswd').val() ){
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
	
	function captcharReload(){
		$('img[name="captcha"]').attr('src','${cpath}/simpleCaptcha.png');
	}
	
</script>
</head>
<body>
	
	<div class="container">

	<%@ include file="/include/jsp/header.jsp" %>

	<form action="membercheck" class="form-signin" name="frm" method="post" >
		<h2 class="form-signin-heading">Please sign in</h2>
		
		<label for="r_mbid" class="sr-only">아이디</label>
		<input type="text" id="r_mbid" name="r_mbid" class="form-control" onkeypress="keyCheck(event)" placeholder="ID" required autofocus />
		
		<label for="r_mbpswd" class="sr-only">비밀번호</label>
		<input type="password" id="r_mbpswd" name="r_mbpswd" class="form-control" onkeypress="keyCheck(event)" placeholder="Password" required />
		
		<img name="captcha" src="<c:url value="/simpleCaptcha.png" />" /><a href="#" onclick="captcharReload();">새로고침</a>
		
		<label for="answer" class="sr-only">보안문자입력</label>
		<input class="form-control" placeholder="보안문자입력" name="answer" type="text" required />
		
		<div class="checkbox">
			<label>
				<input type="checkbox" value="remember-me" /> Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="formSubmit()">로그인</button>
	</form>

	<%@ include file="/include/jsp/footer.jsp" %>
	
	</div>
</body>
</html>