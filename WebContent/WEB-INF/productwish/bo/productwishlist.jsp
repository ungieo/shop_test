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

	function dataEdit( r_prwseq ){
		$( '#r_prwseq' ).val( r_prwseq );
		handling.submit( '', 'productwishedit' );
	}

	function dataIn(){
		handling.submit( '', 'productwishin' );
	}

	function dataView( r_prwseq ){
		$( '#r_prwseq' ).val( r_prwseq );
		handling.submit( '', 'productwishview' );
	}

	function dataList(){
		handling.submit( '', 'productwishlist' );
	}

	function dataListDel(){
		handling.submit( '', 'productwishlist' );
	}

	function dataListUp(){
		handling.submit( '', 'productwishlist' );
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
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

	<form action="productwishlist" id="frm" name="frm" method="post" >

		<input name="r_page" type="hidden" value="${ model.r_page }" />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />

		<input id="r_prwseq" name="r_prwseq" type="hidden" value="" />

		<table class="table table-hover">
			<caption>productwishList</caption>
			<thead>
				<tr>
					<th>고유값</th>
					<th>상품고유값</th>
					<th>옵션고유번호</th>
					<th></th>
					<th>레벨</th>
					<th>타입</th>
					<th>사용여부</th>
					<th>수정아이디</th>
					<th>등록아이디</th>
					<th>수정일</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ model.productwishList}" var="productwish" varStatus="status" >
				<tr>
					<td><c:out value='${ productwish.PRW_SEQ }' /></td>
					<td><c:out value='${ productwish.PRW_PRSEQ }' /></td>
					<td><c:out value='${ productwish.PRW_PROSEQ }' /></td>
					<td><c:out value='${ productwish.PRW_MBID }' /></td>
					<td><c:out value='${ productwish.PRW_LEVEL }' /></td>
					<td><c:out value='${ productwish.PRW_TYPE }' /></td>
					<td><c:out value='${ productwish.PRW_USE }' /></td>
					<td><c:out value='${ productwish.PRW_MOID }' /></td>
					<td><c:out value='${ productwish.PRW_INID }' /></td>
					<td>${ fn:substring( productwish.PRW_MODATE, 0, 16 ) }</td>
					<td>${ fn:substring( productwish.PRW_INDATE, 0, 16 ) }</td>
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