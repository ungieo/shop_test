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
		handling.submit( '', 'ordermainitemhistoryadd' );
	}

	function dataDel( r_omihseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omihseq').val( r_omihseq );
		handling.submit( '', 'ordermainitemhistorydel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainitemhistorydown' );
	}

	function dataEdit( r_omihseq ){
		handling.submit( '', 'ordermainitemhistoryedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainitemhistoryin' );
	}

	function dataView( r_omihseq ){
		$( '#r_omihseq' ).val( r_omihseq );
		handling.submit( '', 'ordermainitemhistoryview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainitemhistorylist' );
	}

	function dataListDel(){
		handling.submit( '', 'ordermainitemhistorylist' );
	}

	function dataListUp(){
		handling.submit( '', 'ordermainitemhistorylist' );
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
		handling.submit( '', 'ordermainitemhistorylist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainitemhistorylist' );
	}

	function dataUp( r_omihseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omihseq').val( r_omihseq );
		handling.submit( '', 'ordermainitemhistoryup' );
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

	<form action="ordermainitemhistorylist" id="frm" name="frm" method="post" >

		<input name="r_page" type="hidden" value="${ model.r_page }" />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />

		<input id="r_omihseq" name="r_omihseq" type="hidden" value="" />

		<table class="table table-hover">
			<caption>ordermainitemhistoryList</caption>
			<thead>
				<tr>
					<th>고유값</th>
					<th>주문일련번호</th>
					<th>주문상태값</th>
					<th>스탭</th>
					<th>상태변경메모</th>
					<th>레벨</th>
					<th>타입</th>
					<th>수정아이디</th>
					<th>등록아이디</th>
					<th>수정일</th>
					<th>등록일</th>
				</tr>
			</thead>
		<c:forEach items="${ model.ordermainitemhistoryList}" var="ordermainitemhistory" varStatus="status" >
			<tbody>
				<tr>
					<td><c:out value='${ ordermainitemhistory.OMIH_SEQ }' /></td>
					<td><c:out value='${ ordermainitemhistory.OMIH_OMISEQ }' /></td>
					<td><c:out value='${ ordermainitemhistory.OMIH_OMISTATUS }' /></td>
					<td><c:out value='${ ordermainitemhistory.OMIH_OMISTEP }' /></td>
					<td><c:out value='${ ordermainitemhistory.OMIH_MEMO }' /></td>
					<td><c:out value='${ ordermainitemhistory.OMIH_LEVEL }' /></td>
					<td><c:out value='${ ordermainitemhistory.OMIH_TYPE }' /></td>
					<td><c:out value='${ ordermainitemhistory.OMIH_MOID }' /></td>
					<td><c:out value='${ ordermainitemhistory.OMIH_INID }' /></td>
					<td>${ fn:substring( ordermainitemhistory.OMIH_MODATE, 0, 16 ) }</td>
					<td>${ fn:substring( ordermainitemhistory.OMIH_INDATE, 0, 16 ) }</td>
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