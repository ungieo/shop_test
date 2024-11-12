<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@include file="/include/jsp/commonhead.jsp"%>

<script type="text/javascript">

	function dataAdd(){
		formSubmit( 'frm' );
	}

	function dataEdit(){
		formSubmit( 'frm' );
	}

	function dataDel(){
		formSubmit( 'frm' );
	}

	function dataIn(){
		formSubmit( 'frm' );
	}

	function dataOne(){
		formSubmit( 'frm' );
	}

	function dataList(){
		formSubmit( 'frm' );
	}

	function dataUp(){
		formSubmit( 'frm' );
	}
	
	function formSubmit( obj ){
		$( 'form[name="'+obj+'"]' ).submit();
	}

</script>
</head>
<body>

	<%@ include file="/include/jsp/header.jsp" %>

	<form action="membercheck" method="post" name="frm">
		로그인 실패
		아이디<input name="r_mbid" type="text" /><br/>
		암호<input name="r_mbpswd" type="password" /><br/>
		<a href="#" onclick="formSubmit('frm')" >보내기</a>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>