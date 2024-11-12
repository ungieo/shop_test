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
		
		$( '#r_mbid' ).attr( 'readonly', 'readonly' );
		$( '#r_mbname' ).attr( 'readonly', 'readonly' );
		$( '#r_mbzipcode' ).attr( 'readonly', 'readonly' );
		$( '#r_mbaddr1' ).attr( 'readonly', 'readonly' );
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

	function dataAdd(){
		handling.submit( '', 'memberadd' );
	}

	function dataDel(){
		handling.submit( '', 'memberdel' );
	}

	function dataDown(){
		handling.submit( '', 'memberdel' );
	}

	function dataEdit(){
		handling.submit( '', 'memberedit' );
	}

	function dataIn(){
		handling.submit( '', 'memberin' );
	}

	function dataView(){
		handling.submit( '', 'memberview' );
	}

	function dataList(){
		handling.submit( '', 'memberlist' );
	}

	function dataSort(){
		handling.submit( '', 'memberlist' );
	}

	function dataUp(){
		handling.submit( '', 'memberup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
	}

	function pager( fName, r_url ){
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

	<form action="memberup" method="post" name="frm">

		<fieldset>
			<legend>memberedit</legend>
						<p>
			<label for="r_mbid">아이디</label>
				<input id="r_mbid" name="r_mbid" type="text" value="${ model.member.MB_ID }" />
			</p>
			<p>
				<label for="r_mbname">이름</label>
				<input id="r_mbname" name="r_mbname" type="text" value="${ model.member.MB_NAME }" required />
			</p>
<!-- 			<p> -->
<!-- 				<label for="r_mbcpid">회사코드</label> -->
<%-- 				<input name="r_mbcpid" type="text" value="${ model.member.MB_CPID }" /> --%>
<!-- 			</p> -->
<!-- 			<p> -->
<!-- 				<label for="r_mbdpid">부서코드</label> -->
<%-- 				<input name="r_mbdpid" type="text" value="${ model.member.MB_DPID }" /> --%>
<!-- 			</p> -->
			<p>
				<input id="r_mbzipcode" name="r_mbzipcode" type="text" value="${ model.member.MB_ZIPCODE }" required />
				<input type="button" onclick="getZipcode();" value="우편번호검색" />
			</p>
			<p>
				<label for="r_mbaddr1">기본주소</label>
				<input id="r_mbaddr1" name="r_mbaddr1" type="text" value="${ model.member.MB_ADDR1 }" required/>
			</p>
			<p>
				<label for="r_mbaddr2">상세주소</label>
				<input name="r_mbaddr2" type="text" value="${ model.member.MB_ADDR2 }" required />
			</p>
			<p>
				<label for="r_mbemail">이메일</label>
				<input name="r_mbemail" type="text" value="${ model.member.MB_EMAIL }" required email="true"/>
			</p>
			<p>
				<label for="r_mbphone">휴대폰</label>
				<input name="r_mbphone" type="text" value="${ model.member.MB_PHONE }" required mobile="true" />
			</p>
			<p>
				<label for="r_mbtel">전화번호</label>
				<input name="r_mbtel" type="text" value="${ model.member.MB_TEL }" />
			</p>
			<p>
				<label for="r_mbbirth">생년월일</label>
				<input name="r_mbbirth" type="text" value="${ model.member.MB_BIRTH }" required/>
			</p>
			<p>
				<label for="r_mbemailuse">이메일수신여부</label>
				YES<input name="r_mbemailuse" type="radio" value="Y" <c:if test="${ model.member.MB_EMAILUSE eq 'Y' }">checked="checked"</c:if> />
				NO<input name="r_mbemailuse" type="radio" value="N" <c:if test="${ model.member.MB_EMAILUSE eq 'N' }">checked="checked"</c:if>/>
			</p>
			<p>
				<label for="r_mbsmsuse">문자수신여부</label>
				YES<input name="r_mbsmsuse" type="radio" value="Y" <c:if test="${ model.member.MB_SMSUSE eq 'Y' }">checked="checked"</c:if> />
				NO<input name="r_mbsmsuse" type="radio" value="N" <c:if test="${ model.member.MB_SMSUSE eq 'N' }">checked="checked"</c:if>/>
			</p>
		<a href="#" onclick="dataUp( 'memberup' )">저장</a><br/>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>