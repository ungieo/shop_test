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
		handling.submit( '', 'productcategoryadd' );
	}

	function dataDel(){
		handling.submit( '', 'productcategorydel' );
	}

	function dataDown(){
		handling.submit( '', 'productcategorydown' );
	}

	function dataEdit(){
		handling.submit( '', 'productcategoryedit' );
	}

	function dataIn(){
		handling.submit( '', 'productcategoryin' );
	}

	function dataView(){
		handling.submit( '', 'productcategoryview' );
	}

	function dataList(){
		handling.submit( '', 'productcategorylist' );
	}

	function dataSort(){
		handling.submit( '', 'productcategorylist' );
	}

	function dataUp(){
		handling.submit( '', 'productcategoryup' );
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

	<form action="productcategoryview" id="frm" name="frm" method="post" >

	<input name="r_prcseq" type="hidden" value="${ model.productcategory.PRC_SEQ }" />
	<c:if test="${ !empty model.productcategory }">
		고유값=<c:out value='${ model.productcategory.PRC_SEQ }' /><br/>
		카테고리코드=<c:out value='${ model.productcategory.PRC_CODE }' /><br/>
		부모코드=<c:out value='${ model.productcategory.PRC_PID }' /><br/>
		카테고리명=<c:out value='${ model.productcategory.PRC_NAME }' /><br/>
		순서=<c:out value='${ model.productcategory.PRC_STEP }' /><br/>
		타이틀이미지=<c:out value='${ model.productcategory.PRC_TITLEIMAGE }' /><br/>
		=<c:out value='${ model.productcategory.PRC_GNUM1 }' /><br/>
		=<c:out value='${ model.productcategory.PRC_GNUM2 }' /><br/>
		=<c:out value='${ model.productcategory.PRC_GNUM3 }' /><br/>
		레벨=<c:out value='${ model.productcategory.PRC_LEVEL }' /><br/>
		타입=<c:out value='${ model.productcategory.PRC_TYPE }' /><br/>
		사용여부=<c:out value='${ model.productcategory.PRC_USE }' /><br/>
		수정아이디=<c:out value='${ model.productcategory.PRC_MOID }' /><br/>
		등록아이디=<c:out value='${ model.productcategory.PRC_INID }' /><br/>
<!--		수정일=${ fn:substring( model.productcategory.PRC_MODATE, 0, 16 ) }--><br/>
<!--		등록일=${ fn:substring( model.productcategory.PRC_INDATE, 0, 16 ) }--><br/>
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