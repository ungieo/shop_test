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

	function pageMove(  ){
		handling.pageMove( r_url, param);
	}

</script>
</head>
<body>

	<%@ include file="/include/jsp/header.jsp" %>

	<form action="memberview" method="post" id="frm" name="frm">

	<input name="r_mbid" type="hidden" value="${ model.member.MB_ID }" />
	
	<c:if test="${ !empty model.member }">
		아이디=${ model.member.MB_ID }<br/>
		이름=${ model.member.MB_NAME }<br/>
<!--		비밀문자변경일자=${ fn:substring( model.member.MB_PSWDCHDATE, 0, 16 ) }--><br/>
<%-- 		회사코드=${ model.member.MB_CPID }<br/> --%>
<%-- 		부서코드=${ model.member.MB_DPID }<br/> --%>
		우편번호=${ model.member.MB_ZIPCODE }<br/>
		기본주소=${ model.member.MB_ADDR1 }<br/>
		상세주소=${ model.member.MB_ADDR2 }<br/>
		이메일=${ model.member.MB_EMAIL }<br/>
		휴대폰=${ model.member.MB_PHONE }<br/>
		전화번호=${ model.member.MB_TEL }<br/>
		생년월일=${ model.member.MB_BIRTH }<br/>
		이메일수신여부=${ model.member.MB_EMAILUSE }<br/>
		문자수신여부=${ model.member.MB_SMSUSE }<br/>
<%-- 		레벨=${ model.member.MB_LEVEL }<br/> --%>
<%-- 		회원타입=${ model.member.MB_TYPE }<br/> --%>
<%-- 		사용여부=${ model.member.MB_USE }<br/> --%>
<%-- 		수정아이디=${ model.member.MB_MOID }<br/> --%>
<%-- 		등록아이디=${ model.member.MB_INID }<br/> --%>
<!--		수정일=${ fn:substring( model.member.MB_MODATE, 0, 16 ) }--><br/>
<!--		등록일=${ fn:substring( model.member.MB_INDATE, 0, 16 ) }--><br/>
	</c:if>

	<a href="#" onclick="dataEdit(  )">수정</a>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>