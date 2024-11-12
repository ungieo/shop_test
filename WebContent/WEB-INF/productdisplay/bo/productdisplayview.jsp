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
		handling.submit( '', 'productdisplayadd' );
	}

	function dataDel( r_prdseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prdseq').val( r_prdseq );
		handling.submit( '', 'productdisplaydel' );
	}

	function dataDown(){
		handling.submit( '', 'productdisplaydown' );
	}

	function dataEdit(){
		handling.submit( '', 'productdisplayedit' );
	}

	function dataIn(){
		handling.submit( '', 'productdisplayin' );
	}

	function dataView(){
		handling.submit( '', 'productdisplayview' );
	}

	function dataList(){
		handling.submit( '', 'productdisplaylist' );
	}

	function dataSort(){
		handling.submit( '', 'productdisplaylist' );
	}

	function dataUp( r_prdseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prdseq').val( r_prdseq );
		handling.submit( '', 'productdisplayup' );
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

	<form action="productdisplayview" id="frm" name="frm" method="post" >

	<input name="r_prdseq" type="hidden" value="${ model.productdisplay.PRD_SEQ }" />
	<c:if test="${ !empty model.productdisplay }">
		고유번호=<c:out value='${ model.productdisplay.PRD_SEQ }' /><br/>
		브랜드명=<c:out value='${ model.productdisplay.PRD_PRSEQ }' /><br/>
		타입 B=BEST N=NEW P=POPULAR H=HOT R=RECOMMEND=<c:out value='${ model.productdisplay.PRD_TYPE }' /><br/>
		승인여부=<c:out value='${ model.productdisplay.PRD_USE }' /><br/>
		등록아이디=<c:out value='${ model.productdisplay.PRD_INID }' /><br/>
<!--		등록일=${ fn:substring( model.productdisplay.PRD_INDATE, 0, 16 ) }--><br/>
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