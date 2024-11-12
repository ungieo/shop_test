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

	function dataAdd(  ){
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

	function dataEdit( r_prdseq ){
		$( '#r_prdseq' ).val( r_prdseq );
		handling.submit( '', 'productdisplayedit' );
	}

	function dataIn(){
		handling.submit( '', 'productdisplayin' );
	}

	function dataView( r_prdseq ){
		$( '#r_prdseq' ).val( r_prdseq );
		handling.submit( '', 'productdisplayview' );
	}

	function dataList(){
		handling.submit( '', 'productdisplaylist' );
	}

	function dataListDel(){
		handling.submit( '', 'productdisplaylist' );
	}

	function dataListUp(){
		handling.submit( '', 'productdisplaylist' );
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
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
		handling.submit( fName, r_url );
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

	<form action="productdisplaylist" id="frm" name="frm" method="post" >

		<input name="r_page" type="hidden" value="${ model.r_page }" />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />

		<input id="r_prdseq" name="r_prdseq" type="hidden" value="" />

		<table class="table table-hover">
			<caption>productdisplayList</caption>
			<thead>
				<tr>
					<th>고유번호</th>
					<th>브랜드명</th>
					<th>타입 B=BEST N=NEW P=POPULAR H=HOT R=RECOMMEND</th>
					<th>승인여부</th>
					<th>등록아이디</th>
					<th>등록일</th>
				</tr>
			</thead>
		<tbody>
		<c:forEach items="${ model.productdisplayList}" var="productdisplay" varStatus="status" >
				<tr>
					<td><c:out value='${ productdisplay.PRD_SEQ }' /></td>
					<td><c:out value='${ productdisplay.PRD_PRSEQ }' /></td>
					<td><c:out value='${ productdisplay.PRD_TYPE }' /></td>
					<td><c:out value='${ productdisplay.PRD_USE }' /></td>
					<td><c:out value='${ productdisplay.PRD_INID }' /></td>
					<td>${ fn:substring( productdisplay.PRD_INDATE, 0, 16 ) }</td>
				</tr>
		</c:forEach>
		</tbody>
		</table>

		<a href="#" onclick="dataAdd(  )">등록</a>
	<div class="">
		<%@ include file="/include/jsp/pager.jsp" %>
	</div>

	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>