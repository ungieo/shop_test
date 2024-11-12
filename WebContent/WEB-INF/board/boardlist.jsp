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
			error : function(){
				alert( '처리 중 오류가 발생되었습니다.' );
				errorCnt += 1;
				checkYn = 'N';
				return false;
			},
			success : function( data ){
			},
			type : 'POST',
			url : '${cpath}/'
		});
	}

	function dataAdd(  ){
		handling.submit( '', 'boardadd' );
	}

	function dataDel( r_bdid ){
		handling.submit( '', 'boarddel' );
	}

	function dataDown(){
		handling.submit( '', 'boarddel' );
	}

	function dataEdit( r_bdid ){
		handling.submit( '', 'boardedit' );
	}

	function dataIn(){
		handling.submit( '', 'boardin' );
	}

	function dataView( r_bdid ){
		handling.submit( '', 'boardview' );
	}

	function dataList(){
		handling.submit( '', 'boardlist' );
	}

	function dataSort(){
		handling.submit( '', 'boardlist' );
	}

	function dataUp( r_bdid ){
		handling.submit( '', 'boardup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
	}

	function pager( fName, r_url, r_page ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( fName, r_url );
	}

	function pageMove( fName, r_url ){
		handling.pageMove( r_url, param);
	}

</script>
</head>

<body>

	<%@ include file="/include/jsp/header.jsp" %>

	<form action="boardlist" method="post" name="frm">

		<input name="r_page" type="hidden" value="${ model.r_page } " />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit } " />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit } " />

		<table>
			<caption>boardList</caption>
			<thead>
				<tr>
					<th>아이디</th>
					<th>게시판명</th>
					<th>코멘트사용여부</th>
					<th>설명</th>
					<th>파일최대사이즈</th>
					<th>파일사용여부</th>
					<th>이미지</th>
					<th>보드아이피</th>
					<th>아이피사용여부</th>
					<th>암호사용여부</th>
					<th>답글여부</th>
					<th>정렬타입</th>
					<th>뷰타입</th>
					<th>레벨</th>
					<th>타입</th>
					<th>사용여부</th>
					<th>수정아이디</th>
					<th>등록아이디</th>
					<th>수정일</th>
					<th>등록일</th>
				</tr>
			</thead>
		<c:forEach items="${ model.boardList}" var="board" varStatus="status" >
			<tbody>
				<tr>
					<td>${ board.BD_ID }</td>
					<td>${ board.BD_NAME }</td>
					<td>${ board.BD_COMMENTUSE }</td>
					<td>${ board.BD_DESCRIPTION }</td>
					<td>${ board.BD_FILEMAXSIZE }</td>
					<td>${ board.BD_FILEUSE }</td>
					<td>${ board.BD_IMAGE }</td>
					<td>${ board.BD_IP }</td>
					<td>${ board.BD_IPUSE }</td>
					<td>${ board.BD_PSWDUSE }</td>
					<td>${ board.BD_REPLYUSE }</td>
					<td>${ board.BD_SORTTYPE }</td>
					<td>${ board.BD_VIEWTYPE }</td>
					<td>${ board.BD_LEVEL }</td>
					<td>${ board.BD_TYPE }</td>
					<td>${ board.BD_USE }</td>
					<td>${ board.BD_MOID }</td>
					<td>${ board.BD_INID }</td>
					<td>${ fn:substring( board.BD_MODATE, 0, 16 ) }</td>
					<td>${ fn:substring( board.BD_INDATE, 0, 16 ) }</td>
				</tr>
			</tbody>
		</c:forEach>
		</table>

		<a href="#" onclick="dataAdd(  )">등록</a>
	<div class="">
		<%@ include file="/include/jsp/pager.jsp" %>
	</div>

	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>