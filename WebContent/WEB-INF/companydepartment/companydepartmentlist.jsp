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
		handling.submit( '', 'companydepartmentadd' );
	}

	function dataDel( r_cpdseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_cpdseq').val( r_cpdseq );
		handling.submit( '', 'companydepartmentdel' );
	}

	function dataDown(){
		handling.submit( '', 'companydepartmentdown' );
	}

	function dataEdit( r_cpdseq ){
		handling.submit( '', 'companydepartmentedit' );
	}

	function dataIn(){
		handling.submit( '', 'companydepartmentin' );
	}

	function dataView( r_cpdseq ){
		$( '#r_cpdseq' ).val( r_cpdseq );
		handling.submit( '', 'companydepartmentview' );
	}

	function dataList(){
		handling.submit( '', 'companydepartmentlist' );
	}

	function dataListDel(){
		handling.submit( '', 'companydepartmentlist' );
	}

	function dataListUp(){
		handling.submit( '', 'companydepartmentlist' );
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
		handling.submit( '', 'companydepartmentlist' );
	}

	function dataSort(){
		handling.submit( '', 'companydepartmentlist' );
	}

	function dataUp( r_cpdseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_cpdseq').val( r_cpdseq );
		handling.submit( '', 'companydepartmentup' );
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

	<form action="companydepartmentlist" id="frm" name="frm" method="post" >

		<input name="r_page" type="hidden" value="${ model.r_page }" />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />

		<input id="r_cpdseq" name="r_cpdseq" type="hidden" value="" />

		<table class="table table-hover">
			<caption>companydepartmentList</caption>
			<thead>
				<tr>
					<th>고유번호</th>
					<th>회사아이디</th>
					<th>부서아이디</th>
					<th>부서명</th>
					<th>결제타입</th>
					<th>이메일</th>
					<th>전화</th>
					<th>휴대전화</th>
					<th>팩스</th>
					<th>레벨</th>
					<th>타입 N=일반</th>
					<th>승인여부</th>
					<th>수정아이디</th>
					<th>등록아이디</th>
					<th>수정일</th>
					<th>등록일</th>
				</tr>
			</thead>
		<c:forEach items="${ model.companydepartmentList}" var="companydepartment" varStatus="status" >
			<tbody>
				<tr>
					<td><c:out value='${ companydepartment.CPD_SEQ }' /></td>
					<td><c:out value='${ companydepartment.CPD_CPID }' /></td>
					<td><c:out value='${ companydepartment.CPD_ID }' /></td>
					<td><c:out value='${ companydepartment.CPD_NAME }' /></td>
					<td><c:out value='${ companydepartment.CPD_PAYTYPE }' /></td>
					<td><c:out value='${ companydepartment.CPD_EMAIL }' /></td>
					<td><c:out value='${ companydepartment.CPD_TEL }' /></td>
					<td><c:out value='${ companydepartment.CPD_PHONE }' /></td>
					<td><c:out value='${ companydepartment.CPD_FAX }' /></td>
					<td><c:out value='${ companydepartment.CPD_LEVEL }' /></td>
					<td><c:out value='${ companydepartment.CPD_TYPE }' /></td>
					<td><c:out value='${ companydepartment.CPD_USE }' /></td>
					<td><c:out value='${ companydepartment.CPD_MOID }' /></td>
					<td><c:out value='${ companydepartment.CPD_INID }' /></td>
					<td>${ fn:substring( companydepartment.CPD_MODATE, 0, 16 ) }</td>
					<td>${ fn:substring( companydepartment.CPD_INDATE, 0, 16 ) }</td>
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