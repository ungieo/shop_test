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
		handling.submit( '', 'productwishadd' );
	}

	function dataDel( r_prwseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prwseq').val( r_prwseq );
		handling.submit( '', 'productwishdel' );
	}

	function dataDown(){
		handling.submit( '', 'productwishdown' );
	}

	function dataEdit(){
		handling.submit( '', 'productwishedit' );
	}

	function dataIn(){
		handling.submit( '', 'productwishin' );
	}

	function dataView(){
		handling.submit( '', 'productwishview' );
	}

	function dataList(){
		handling.submit( '', 'productwishlist' );
	}

	function dataSort(){
		handling.submit( '', 'productwishlist' );
	}

	function dataUp( r_prwseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prwseq').val( r_prwseq );
		handling.submit( '', 'productwishup' );
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

	<form action="productwishview" id="frm" name="frm" method="post" >

	<input name="r_prwseq" type="hidden" value="${ model.productwish.PRW_SEQ }" />
	<c:if test="${ !empty model.productwish }">
		고유값=<c:out value='${ model.productwish.PRW_SEQ }' /><br/>
		상품고유값=<c:out value='${ model.productwish.PRW_PRSEQ }' /><br/>
		옵션고유번호=<c:out value='${ model.productwish.PRW_PROSEQ }' /><br/>
		=<c:out value='${ model.productwish.PRW_MBID }' /><br/>
		레벨=<c:out value='${ model.productwish.PRW_LEVEL }' /><br/>
		타입=<c:out value='${ model.productwish.PRW_TYPE }' /><br/>
		사용여부=<c:out value='${ model.productwish.PRW_USE }' /><br/>
		수정아이디=<c:out value='${ model.productwish.PRW_MOID }' /><br/>
		등록아이디=<c:out value='${ model.productwish.PRW_INID }' /><br/>
<!--		수정일=${ fn:substring( model.productwish.PRW_MODATE, 0, 16 ) }--><br/>
<!--		등록일=${ fn:substring( model.productwish.PRW_INDATE, 0, 16 ) }--><br/>
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