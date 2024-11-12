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

	function dataEdit( r_prbseq ){
		$( '#r_prbseq' ).val( r_prbseq );
		handling.submit( '', 'productbasketedit' );
	}

	function dataIn(){
		handling.submit( '', 'productbasketin' );
	}

	function dataView( r_prbseq ){
		$( '#r_prbseq' ).val( r_prbseq );
		handling.submit( '', 'productbasketview' );
	}

	function dataList(){
		handling.submit( '', 'productbasketlist' );
	}

	function dataListDel(){
		handling.submit( '', 'productbasketlist' );
	}

	function dataListUp(){
		handling.submit( '', 'productbasketlist' );
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
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

	<form action="productbasketlist" id="frm" name="frm" method="post" >

		<input name="r_page" type="hidden" value="${ model.r_page }" />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />

		<input id="r_prbseq" name="r_prbseq" type="hidden" value="" />

		<table class="table table-hover">
			<caption>productbasketList</caption>
			<thead>
				<tr>
					<th>아이디</th>
					<th>상품코드</th>
					<th>회원아이디</th>
					<th>상품옵션</th>
					<th>수량</th>
					<th>타입</th>
					<th>수정아이디</th>
					<th>등록아이디</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ model.productbasketList}" var="productbasket" varStatus="status" >
				<tr>
					<td><c:out value='${ productbasket.PRB_SEQ }' /></td>
					<td><c:out value='${ productbasket.PRB_PRSEQ }' /></td>
					<td><c:out value='${ productbasket.PRB_MBID }' /></td>
					<td><c:out value='${ productbasket.PRB_PROSEQ }' /></td>
					<td><c:out value='${ productbasket.PRB_EA }' /></td>
					<td><c:out value='${ productbasket.PRB_TYPE }' /></td>
					<td><c:out value='${ productbasket.PRB_MOID }' /></td>
					<td><c:out value='${ productbasket.PRB_INID }' /></td>
					<td>${ fn:substring( productbasket.PRB_INDATE, 0, 16 ) }</td>
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