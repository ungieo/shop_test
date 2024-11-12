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
		handling.submit( '', 'ordermainaddressadd' );
	}

	function dataDel( r_omaseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omaseq').val( r_omaseq );
		handling.submit( '', 'ordermainaddressdel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainaddressdown' );
	}

	function dataEdit( r_omaseq ){
		handling.submit( '', 'ordermainaddressedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainaddressin' );
	}

	function dataView( r_omaseq ){
		$( '#r_omaseq' ).val( r_omaseq );
		handling.submit( '', 'ordermainaddressview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainaddresslist' );
	}

	function dataListDel(){
		handling.submit( '', 'ordermainaddresslist' );
	}

	function dataListUp(){
		handling.submit( '', 'ordermainaddresslist' );
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
		handling.submit( '', 'ordermainaddresslist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainaddresslist' );
	}

	function dataUp( r_omaseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omaseq').val( r_omaseq );
		handling.submit( '', 'ordermainaddressup' );
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

	<form action="ordermainaddresslist" id="frm" name="frm" method="post" >

		<input name="r_page" type="hidden" value="${ model.r_page }" />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />

		<input id="r_omaseq" name="r_omaseq" type="hidden" value="" />

		<table class="table table-hover">
			<caption>ordermainaddressList</caption>
			<thead>
				<tr>
					<th>고유값</th>
					<th>주문번호</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>휴대폰</th>
					<th>이메일</th>
					<th>우편번호</th>
					<th>주소1</th>
					<th>주소2</th>
					<th>타입(S=보내는자 R=받는자)</th>
					<th>수정아이디</th>
					<th>등록아이디</th>
					<th>수정일</th>
					<th>등록일</th>
				</tr>
			</thead>
		<c:forEach items="${ model.ordermainaddressList}" var="ordermainaddress" varStatus="status" >
			<tbody>
				<tr>
					<td><c:out value='${ ordermainaddress.OMA_SEQ }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_OMSEQ }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_NAME }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_TEL }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_PHONE }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_EMAIL }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_ZIPCODE }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_ADDR1 }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_ADDR2 }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_TYPE }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_MOID }' /></td>
					<td><c:out value='${ ordermainaddress.OMA_INID }' /></td>
					<td>${ fn:substring( ordermainaddress.OMA_MODATE, 0, 16 ) }</td>
					<td>${ fn:substring( ordermainaddress.OMA_INDATE, 0, 16 ) }</td>
				</tr>
			</tbody>
		</c:forEach>
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