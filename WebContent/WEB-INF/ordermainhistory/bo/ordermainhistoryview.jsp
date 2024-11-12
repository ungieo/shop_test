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
			//dataType : 'json',
			complete: function( xhr, textStatus ){
				//응답처리
			},
			error : function( xhr, textStatus, erroThrown ){
				alert( '처리 중 오류가 발생되었습니다. '+textStatus );
			},
			success : function( data, textStatus ){
			},
			type : 'POST',
			url : '${cpath}/'
		});
	}

	function dataAdd(){
		handling.submit( '', 'ordermainhistoryadd' );
	}

	function dataDel( r_omhseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omhseq').val( r_omhseq );
		handling.submit( '', 'ordermainhistorydel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainhistorydown' );
	}

	function dataEdit(){
		handling.submit( '', 'ordermainhistoryedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainhistoryin' );
	}

	function dataView(){
		handling.submit( '', 'ordermainhistoryview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainhistorylist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainhistorylist' );
	}

	function dataUp( r_omhseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omhseq').val( r_omhseq );
		handling.submit( '', 'ordermainhistoryup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
	}

	function pager( r_page ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( '', '' );
	}

	function pageMove(  ){
		handling.pageMove( r_url, param);
	}

</script>
</head>
<body>

	<%@ include file="/include/jsp/header.jsp" %>

	<div class="container">

	<form action="ordermainhistoryview" id="frm" name="frm" method="post" >

	<input name="r_omhseq" type="hidden" value="${ model.ordermainhistory.OMH_SEQ }" />
	<c:if test="${ !empty model.ordermainhistory }">
		고유값=<c:out value='${ model.ordermainhistory.OMH_SEQ }' /><br/>
		주문일련번호=<c:out value='${ model.ordermainhistory.OMH_OMSEQ }' /><br/>
		주문상태값=<c:out value='${ model.ordermainhistory.OMH_OMSTATUS }' /><br/>
		주문스탭=<c:out value='${ model.ordermainhistory.OMH_OMSTEP }' /><br/>
		상태변경메모=<c:out value='${ model.ordermainhistory.OMH_MEMO }' /><br/>
		레벨=<c:out value='${ model.ordermainhistory.OMH_LEVEL }' /><br/>
		타입=<c:out value='${ model.ordermainhistory.OMH_TYPE }' /><br/>
		수정아이디=<c:out value='${ model.ordermainhistory.OMH_MOID }' /><br/>
		등록아이디=<c:out value='${ model.ordermainhistory.OMH_INID }' /><br/>
<!--		수정일=${ fn:substring( model.ordermainhistory.OMH_MODATE, 0, 16 ) }--><br/>
<!--		등록일=${ fn:substring( model.ordermainhistory.OMH_INDATE, 0, 16 ) }--><br/>
	</c:if>

		<a href="#" onclick="dataAdd(  )">등록</a>
		<a href="#" onclick="dataEdit(  )">수정</a>
		<a href="#" onclick="dataDel(  )">삭제</a>
		<a href="#" onclick="dataList(  )">리스트</a>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>