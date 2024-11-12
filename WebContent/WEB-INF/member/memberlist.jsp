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
		handling.submit( '', 'memberadd' );
	}

	function dataDel( r_mbid ){
		handling.submit( '', 'memberdel' );
	}

	function dataDown(){
		handling.submit( '', 'memberdel' );
	}

	function dataEdit( r_mbid ){
		handling.submit( '', 'memberedit' );
	}

	function dataIn(){
		handling.submit( '', 'memberin' );
	}

	function dataView( r_mbid ){
		handling.submit( '', 'memberview' );
	}

	function dataList(){
		handling.submit( '', 'memberlist' );
	}

	function dataSort(){
		handling.submit( '', 'memberlist' );
	}

	function dataUp( r_mbid ){
		handling.submit( '', 'memberup' );
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

	<form action="memberlist" method="post" name="frm">

		<input name="r_page" type="hidden" value="${ model.r_page } " />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit } " />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit } " />

		<input name="r_mbid" type="hidden" value="" />

		<table>
			<caption>memberList</caption>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>비밀문자</th>
					<th>비밀문자변경일자</th>
					<th>비밀문자오류횟수</th>
					<th>회사코드</th>
					<th>부서코드</th>
					<th>기본주소</th>
					<th>상세주소</th>
					<th>이메일</th>
					<th>휴대폰</th>
					<th>전화번호</th>
					<th>우편번호</th>
					<th>생년월일</th>
					<th>이메일수신여부</th>
					<th>문자수신여부</th>
					<th>레벨</th>
					<th>타입</th>
					<th>사용여부</th>
					<th>수정아이디</th>
					<th>등록아이디</th>
					<th>수정일</th>
					<th>등록일</th>
				</tr>
			</thead>
		<c:forEach items="${ model.memberList}" var="member" varStatus="status" >
			<tbody>
				<tr>
					<td>${ member.MB_ID }</td>
					<td>${ member.MB_NAME }</td>
					<td>${ member.MB_PSWD }</td>
					<td>${ fn:substring( member.MB_PSWDCHDATE, 0, 16 ) }</td>
					<td>${ member.MB_PSWDFAILCNT }</td>
					<td>${ member.MB_CPID }</td>
					<td>${ member.MB_DPID }</td>
					<td>${ member.MB_ADDR1 }</td>
					<td>${ member.MB_ADDR2 }</td>
					<td>${ member.MB_EMAIL }</td>
					<td>${ member.MB_PHONE }</td>
					<td>${ member.MB_TEL }</td>
					<td>${ member.MB_ZIPCODE }</td>
					<td>${ member.MB_BIRTH }</td>
					<td>${ member.MB_EMAILUSE }</td>
					<td>${ member.MB_SMSUSE }</td>
					<td>${ member.MB_LEVEL }</td>
					<td>${ member.MB_TYPE }</td>
					<td>${ member.MB_USE }</td>
					<td>${ member.MB_MOID }</td>
					<td>${ member.MB_INID }</td>
					<td>${ fn:substring( member.MB_MODATE, 0, 16 ) }</td>
					<td>${ fn:substring( member.MB_INDATE, 0, 16 ) }</td>
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