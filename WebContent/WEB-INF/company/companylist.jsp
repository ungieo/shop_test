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
		handling.submit( '', 'companyadd' );
	}

	function dataDel( r_cpseq ){
		handling.submit( '', 'companydel' );
	}

	function dataDown(){
		handling.submit( '', 'companydown' );
	}

	function dataEdit( r_cpseq ){
		handling.submit( '', 'companyedit' );
	}

	function dataIn(){
		handling.submit( '', 'companyin' );
	}

	function dataView( r_cpseq ){
		$( '#r_cpseq' ).val( r_cpseq );
		handling.submit( '', 'companyview' );
	}

	function dataList(){
		handling.submit( '', 'companylist' );
	}

	function dataSort(){
		handling.submit( '', 'companylist' );
	}

	function dataUp( r_cpseq ){
		handling.submit( '', 'companyup' );
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

	<form action="companylist" id="frm" name="frm" method="post" >

		<input name="r_page" type="hidden" value="${ model.r_page }" />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />

		<input id="r_cpseq" name="r_cpseq" type="hidden" value="" />

		<table class="table table-hover">
			<caption>companyList</caption>
			<thead>
				<tr>
					<th>고유번호</th>
					<th>회사아이디</th>
					<th>회사명</th>
					<th>사업자번호</th>
					<th>업태</th>
					<th>업종</th>
					<th>대표명</th>
					<th>우편번호</th>
					<th>기본주소</th>
					<th>상세주소</th>
					<th>파일</th>
					<th>배송비</th>
					<th>결제타입</th>
					<th>회사타입</th>
					<th>통신사업자</th>
					<th>이메일</th>
					<th>전화</th>
					<th>휴대전화</th>
					<th>팩스</th>
					<th>레벨</th>
					<th>타입</th>
					<th>사용여부</th>
					<th>수정아이디</th>
					<th>등록아이디</th>
					<th>수정일</th>
					<th>등록일</th>
				</tr>
			</thead>
		<c:forEach items="${ model.companyList}" var="company" varStatus="status" >
			<tbody>
				<tr>
					<td><c:out value='${ company.CP_SEQ }' /></td>
					<td><c:out value='${ company.CP_ID }' /></td>
					<td><c:out value='${ company.CP_NAME }' /></td>
					<td><c:out value='${ company.CP_BIZNUM }' /></td>
					<td><c:out value='${ company.CP_UPTAI }' /></td>
					<td><c:out value='${ company.CP_UPJONG }' /></td>
					<td><c:out value='${ company.CP_CEONAME }' /></td>
					<td><c:out value='${ company.CP_ZIPCODE }' /></td>
					<td><c:out value='${ company.CP_ADDR1 }' /></td>
					<td><c:out value='${ company.CP_ADDR2 }' /></td>
					<td><c:out value='${ company.CP_FILE }' /></td>
					<td><c:out value='${ company.CP_DELIVERYMONEY }' /></td>
					<td><c:out value='${ company.CP_PAYTYPE }' /></td>
					<td><c:out value='${ company.CP_BIZTYPE }' /></td>
					<td><c:out value='${ company.CP_TONGSINBIZNUM }' /></td>
					<td><c:out value='${ company.CP_EMAIL }' /></td>
					<td><c:out value='${ company.CP_TEL }' /></td>
					<td><c:out value='${ company.CP_PHONE }' /></td>
					<td><c:out value='${ company.CP_FAX }' /></td>
					<td><c:out value='${ company.CP_LEVEL }' /></td>
					<td><c:out value='${ company.CP_TYPE }' /></td>
					<td><c:out value='${ company.CP_USE }' /></td>
					<td><c:out value='${ company.CP_MOID }' /></td>
					<td><c:out value='${ company.CP_INID }' /></td>
					<td>${ fn:substring( company.CP_MODATE, 0, 16 ) }</td>
					<td>${ fn:substring( company.CP_INDATE, 0, 16 ) }</td>
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