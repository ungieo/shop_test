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

	function formSubmit( fName, url ){
		handling.submit( '', url );
	}

	function pager( fName, url ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( fName, url );
	}

	function pageMove( fName, url ){
		handling.pageMove(url,param);
	}

</script>
</head>
<body>

	<%@ include file="/include/jsp/header.jsp" %>

	<form action="memberdel" method="post" name="frm">

		<fieldset>
			<legend>memberdel</legend>
			<p>
				<label for="r_mbid">아이디</label>
				<input name="r_mbid" type="text" value="" required />
			</p>
			<p>
				<label for="r_mbname">이름</label>
				<input name="r_mbname" type="text" value="" />
			</p>
			<p>
				<label for="r_mbpswd">비밀문자</label>
				<input name="r_mbpswd" type="text" value="" required />
			</p>
			<!--<p>
				<label for="r_mbpswdchdate">비밀문자변경일자</label>
				<input name="r_mbpswdchdate" type="text" value="" required />
			</p>-->
			<p>
				<label for="r_mbpswdfailcnt">비밀문자오류횟수</label>
				<input name="r_mbpswdfailcnt" type="text" value="" />
			</p>
			<p>
				<label for="r_mbcpid">회사코드</label>
				<input name="r_mbcpid" type="text" value="" />
			</p>
			<p>
				<label for="r_mbdpid">부서코드</label>
				<input name="r_mbdpid" type="text" value="" />
			</p>
			<p>
				<label for="r_mbaddr1">기본주소</label>
				<input name="r_mbaddr1" type="text" value="" />
			</p>
			<p>
				<label for="r_mbaddr2">상세주소</label>
				<input name="r_mbaddr2" type="text" value="" />
			</p>
			<p>
				<label for="r_mbemail">이메일</label>
				<input name="r_mbemail" type="text" value="" />
			</p>
			<p>
				<label for="r_mbphone">휴대폰</label>
				<input name="r_mbphone" type="text" value="" />
			</p>
			<p>
				<label for="r_mbtel">전화번호</label>
				<input name="r_mbtel" type="text" value="" />
			</p>
			<p>
				<label for="r_mbzipcode">우편번호</label>
				<input name="r_mbzipcode" type="text" value="" />
			</p>
			<p>
				<label for="r_mbbirth">생년월일</label>
				<input name="r_mbbirth" type="text" value="" />
			</p>
			<p>
				<label for="r_mbemailuse">이메일수신여부</label>
				<input name="r_mbemailuse" type="text" value="" />
			</p>
			<p>
				<label for="r_mbsmsuse">문자수신여부</label>
				<input name="r_mbsmsuse" type="text" value="" />
			</p>
			<p>
				<label for="r_mblevel">레벨</label>
				<input name="r_mblevel" type="text" value="" />
			</p>
			<p>
				<label for="r_mbtype">타입</label>
				<input name="r_mbtype" type="text" value="" />
			</p>
			<p>
				<label for="r_mbuse">사용여부</label>
				<input name="r_mbuse" type="text" value="" />
			</p>
			<p>
				<label for="r_mbmoid">수정아이디</label>
				<input name="r_mbmoid" type="text" value="" />
			</p>
			<p>
				<label for="r_mbinid">등록아이디</label>
				<input name="r_mbinid" type="text" value="" />
			</p>
			<!--<p>
				<label for="r_mbmodate">수정일</label>
				<input name="r_mbmodate" type="text" value="" required />
			</p>-->
			<!--<p>
				<label for="r_mbindate">등록일</label>
				<input name="r_mbindate" type="text" value="" required />
			</p>-->

		<a href="#" onclick="dataDel()">삭제</a><br/>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>