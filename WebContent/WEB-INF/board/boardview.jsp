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

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
	}

	function pager( fName, r_url ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( fName, r_url );
	}

	function pageMove( fName, r_url ){
		handling.pageMove( r_url, param);
	}

</script>
</head>
<body>

	<%@ include file="/include/jsp/header.jsp" %>

	<form action="boardview" method="post" name="frm">

	<input name="r_bdid" type="hidden" value="${ model.board.BD_ID }" />
	<c:if test="${ !empty model.board }">
		bd_id=${ model.board.BD_ID }<br/>
		bd_name=${ model.board.BD_NAME }<br/>
		bd_commentuse=${ model.board.BD_COMMENTUSE }<br/>
		bd_description=${ model.board.BD_DESCRIPTION }<br/>
		bd_filemaxsize=${ model.board.BD_FILEMAXSIZE }<br/>
		bd_fileuse=${ model.board.BD_FILEUSE }<br/>
		bd_image=${ model.board.BD_IMAGE }<br/>
		bd_ip=${ model.board.BD_IP }<br/>
		bd_ipuse=${ model.board.BD_IPUSE }<br/>
		bd_pswduse=${ model.board.BD_PSWDUSE }<br/>
		bd_replyuse=${ model.board.BD_REPLYUSE }<br/>
		bd_sorttype=${ model.board.BD_SORTTYPE }<br/>
		bd_viewtype=${ model.board.BD_VIEWTYPE }<br/>
		bd_level=${ model.board.BD_LEVEL }<br/>
		bd_type=${ model.board.BD_TYPE }<br/>
		bd_use=${ model.board.BD_USE }<br/>
		bd_moid=${ model.board.BD_MOID }<br/>
		bd_inid=${ model.board.BD_INID }<br/>
<!--		bd_modate=${ fn:substring( model.board.BD_MODATE, 0, 16 ) }--><br/>
<!--		bd_indate=${ fn:substring( model.board.BD_INDATE, 0, 16 ) }--><br/>
	</c:if>

		<a href="#" onclick="dataAdd(  )">등록</a>
		<a href="#" onclick="dataEdit(  )">수정</a>
		<a href="#" onclick="dataDel(  )">삭제</a>
		<a href="#" onclick="dataList(  )">리스트</a>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>