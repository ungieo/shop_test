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
		handling.submit( '', 'ordermainhistoryadd' );
	}

	function dataDel( r_omhseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omhseq').val( r_omhseq );
		handling.submit( '', 'ordermainhistorydel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainhistorydown' );
	}

	function dataEdit( r_omhseq ){
		handling.submit( '', 'ordermainhistoryedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainhistoryin' );
	}

	function dataView( r_omhseq ){
		$( '#r_omhseq' ).val( r_omhseq );
		handling.submit( '', 'ordermainhistoryview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainhistorylist' );
	}

	function dataListDel(){
		handling.submit( '', 'ordermainhistorylist' );
	}

	function dataListUp(){
		handling.submit( '', 'ordermainhistorylist' );
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
		handling.submit( '', 'ordermainhistorylist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainhistorylist' );
	}

	function dataUp( r_omhseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omhseq').val( r_omhseq );
		handling.submit( '', 'ordermainhistoryup' );
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

	<form action="ordermainhistorylist" id="frm" name="frm" method="post" >

		<input name="r_page" type="hidden" value="${ model.r_page }" />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />

		<input id="r_omhseq" name="r_omhseq" type="hidden" value="" />

		<table class="table table-hover">
			<caption>ordermainhistoryList</caption>
			<thead>
				<tr>
					<th>고유값</th>
					<th>주문일련번호</th>
					<th>주문상태값</th>
					<th>주문스탭</th>
					<th>상태변경메모</th>
					<th>레벨</th>
					<th>타입</th>
					<th>수정아이디</th>
					<th>등록아이디</th>
					<th>수정일</th>
					<th>등록일</th>
				</tr>
			</thead>
		<c:forEach items="${ model.ordermainhistoryList}" var="ordermainhistory" varStatus="status" >
			<tbody>
				<tr>
					<td><c:out value='${ ordermainhistory.OMH_SEQ }' /></td>
					<td><c:out value='${ ordermainhistory.OMH_OMSEQ }' /></td>
					<td><c:out value='${ ordermainhistory.OMH_OMSTATUS }' /></td>
					<td><c:out value='${ ordermainhistory.OMH_OMSTEP }' /></td>
					<td><c:out value='${ ordermainhistory.OMH_MEMO }' /></td>
					<td><c:out value='${ ordermainhistory.OMH_LEVEL }' /></td>
					<td><c:out value='${ ordermainhistory.OMH_TYPE }' /></td>
					<td><c:out value='${ ordermainhistory.OMH_MOID }' /></td>
					<td><c:out value='${ ordermainhistory.OMH_INID }' /></td>
					<td>${ fn:substring( ordermainhistory.OMH_MODATE, 0, 16 ) }</td>
					<td>${ fn:substring( ordermainhistory.OMH_INDATE, 0, 16 ) }</td>
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