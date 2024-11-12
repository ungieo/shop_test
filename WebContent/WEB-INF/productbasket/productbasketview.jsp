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
		handling.submit( '', 'productbasketadd' );
	}

	function dataDel( r_prbseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prbseq').val( r_prbseq );
		handling.submit( '', 'productbasketdel' );
	}

	function dataDown(){
		handling.submit( '', 'productbasketdown' );
	}

	function dataEdit(){
		handling.submit( '', 'productbasketedit' );
	}

	function dataIn(){
		handling.submit( '', 'productbasketin' );
	}

	function dataView(){
		handling.submit( '', 'productbasketview' );
	}

	function dataList(){
		handling.submit( '', 'productbasketlist' );
	}

	function dataSort(){
		handling.submit( '', 'productbasketlist' );
	}

	function dataUp( r_prbseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prbseq').val( r_prbseq );
		handling.submit( '', 'productbasketup' );
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

	<form action="productbasketview" id="frm" name="frm" method="post" >

	<input name="r_prbseq" type="hidden" value="${ model.productbasket.PRB_SEQ }" />
	<c:if test="${ !empty model.productbasket }">
		아이디=<c:out value='${ model.productbasket.PRB_SEQ }' /><br/>
		상품코드=<c:out value='${ model.productbasket.PRB_PRSEQ }' /><br/>
		회원아이디=<c:out value='${ model.productbasket.PRB_MBID }' /><br/>
		상품옵션=<c:out value='${ model.productbasket.PRB_PROSEQ }' /><br/>
		수량=<c:out value='${ model.productbasket.PRB_EA }' /><br/>
		타입=<c:out value='${ model.productbasket.PRB_TYPE }' /><br/>
		수정아이디=<c:out value='${ model.productbasket.PRB_MOID }' /><br/>
		등록아이디=<c:out value='${ model.productbasket.PRB_INID }' /><br/>
<!--		등록일=${ fn:substring( model.productbasket.PRB_INDATE, 0, 16 ) }--><br/>
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