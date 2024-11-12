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
		handling.submit( '', 'parcelcompanyadd' );
	}

	function dataDel( r_pcseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_pcseq').val( r_pcseq );
		handling.submit( '', 'parcelcompanydel' );
	}

	function dataDown(){
		handling.submit( '', 'parcelcompanydown' );
	}

	function dataEdit(){
		handling.submit( '', 'parcelcompanyedit' );
	}

	function dataIn(){
		handling.submit( '', 'parcelcompanyin' );
	}

	function dataView(){
		handling.submit( '', 'parcelcompanyview' );
	}

	function dataList(){
		handling.submit( '', 'parcelcompanylist' );
	}

	function dataSort(){
		handling.submit( '', 'parcelcompanylist' );
	}

	function dataUp( r_pcseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_pcseq').val( r_pcseq );
		handling.submit( '', 'parcelcompanyup' );
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

	<form action="parcelcompanyview" id="frm" name="frm" method="post" >

	<input name="r_pcseq" type="hidden" value="${ model.parcelcompany.PC_SEQ }" />
	<c:if test="${ !empty model.parcelcompany }">
		고유값=<c:out value='${ model.parcelcompany.PC_SEQ }' /><br/>
		택배사명=<c:out value='${ model.parcelcompany.PC_NAME }' /><br/>
		회사설정=<c:out value='${ model.parcelcompany.PC_CPID }' /><br/>
		택배사URL=<c:out value='${ model.parcelcompany.PC_URL }' /><br/>
		레벨=<c:out value='${ model.parcelcompany.PC_LEVEL }' /><br/>
		타입=<c:out value='${ model.parcelcompany.PC_TYPE }' /><br/>
		사용여부=<c:out value='${ model.parcelcompany.PC_USE }' /><br/>
		등록아이디=<c:out value='${ model.parcelcompany.PC_INID }' /><br/>
<!--		등록일=${ fn:substring( model.parcelcompany.PC_INDATE, 0, 16 ) }--><br/>
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