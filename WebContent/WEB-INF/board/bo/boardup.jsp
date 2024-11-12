<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@include file="/include/jsp/commonhead.jsp"%>

<script type="text/javascript">

	$(function(){
		$('form[name="frm"]').validate();
	});

	function dataAjax(){
	var param = '';

		$.ajax({
			async : false,
			data : param,
			error : function(){
				alert( '처리 중 오류가 발생되었습니다.' );
				errorCnt += 1;
				checkYn = 'N';
				return false;
			},
			success : function( data ){
			},
			type : 'POST',
			url : '${cpath}/'
		});
	}

	function dataAdd(){
		handling.submit( '', 'boardadd' );
	}

	function dataDel(){
		handling.submit( '', 'boarddel' );
	}

	function dataDown(){
		handling.submit( '', 'boarddel' );
	}

	function dataEdit(){
		handling.submit( '', 'boardedit' );
	}

	function dataIn(){
		handling.submit( '', 'boardin' );
	}

	function dataView(){
		handling.submit( '', 'boardview' );
	}

	function dataList(){
		handling.submit( '', 'boardlist' );
	}

	function dataSort(){
		handling.submit( '', 'boardlist' );
	}

	function dataUp(){
		handling.submit( '', 'boardup' );
	}

	function formSubmit( fName, url ){
		handling.submit( '', url );
	}

	function pager( fName, url ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( fName, url );
	}

	function pageMove( fName, url ){
		handling.pageMove(url,param);
	}

</script>
</head>
<body>

	<%@ include file="/include/jsp/header.jsp" %>

	<form action="boardin" method="post" name="frm">

		bdid<input name="r_bdid" type="text" value="${ model.board.BD_ID }"  /><br/>
		bdname<input name="r_bdname" type="text" value="${ model.board.BD_NAME }"  /><br/>
		bdcommentuse<input name="r_bdcommentuse" type="text" value="${ model.board.BD_COMMENTUSE }"  /><br/>
		bddescription<input name="r_bddescription" type="text" value="${ model.board.BD_DESCRIPTION }"  /><br/>
		bdfilemaxsize<input name="r_bdfilemaxsize" type="text" value="${ model.board.BD_FILEMAXSIZE }"  /><br/>
		bdfileuse<input name="r_bdfileuse" type="text" value="${ model.board.BD_FILEUSE }"  /><br/>
		bdimage<input name="r_bdimage" type="text" value="${ model.board.BD_IMAGE }"  /><br/>
		bdip<input name="r_bdip" type="text" value="${ model.board.BD_IP }"  /><br/>
		bdipuse<input name="r_bdipuse" type="text" value="${ model.board.BD_IPUSE }"  /><br/>
		bdpswduse<input name="r_bdpswduse" type="text" value="${ model.board.BD_PSWDUSE }"  /><br/>
		bdreplyuse<input name="r_bdreplyuse" type="text" value="${ model.board.BD_REPLYUSE }"  /><br/>
		bdsorttype<input name="r_bdsorttype" type="text" value="${ model.board.BD_SORTTYPE }"  /><br/>
		bdviewtype<input name="r_bdviewtype" type="text" value="${ model.board.BD_VIEWTYPE }"  /><br/>
		bdlevel<input name="r_bdlevel" type="text" value="${ model.board.BD_LEVEL }"  /><br/>
		bdtype<input name="r_bdtype" type="text" value="${ model.board.BD_TYPE }"  /><br/>
		bduse<input name="r_bduse" type="text" value="${ model.board.BD_USE }"  /><br/>
		bdmoid<input name="r_bdmoid" type="text" value="${ model.board.BD_MOID }"  /><br/>
		bdinid<input name="r_bdinid" type="text" value="${ model.board.BD_INID }"  /><br/>
<!--		<input name="r_bdmodate" type="text" value="${ fn:substring( model.board.BD_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_bdindate" type="text" value="${ fn:substring( model.board.BD_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>