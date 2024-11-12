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

	<form action="memberin" method="post" name="frm">

		mbid<input name="r_mbid" type="text" value="${ model.member.MB_ID }"  /><br/>
		mbname<input name="r_mbname" type="text" value="${ model.member.MB_NAME }"  /><br/>
		mbpswd<input name="r_mbpswd" type="text" value="${ model.member.MB_PSWD }"  /><br/>
<!--		<input name="r_mbpswdchdate" type="text" value="${ fn:substring( model.member.MB_PSWDCHDATE, 0, 16 ) }"  />--><br/>
		mbpswdfailcnt<input name="r_mbpswdfailcnt" type="text" value="${ model.member.MB_PSWDFAILCNT }"  /><br/>
		mbcpid<input name="r_mbcpid" type="text" value="${ model.member.MB_CPID }"  /><br/>
		mbdpid<input name="r_mbdpid" type="text" value="${ model.member.MB_DPID }"  /><br/>
		mbaddr1<input name="r_mbaddr1" type="text" value="${ model.member.MB_ADDR1 }"  /><br/>
		mbaddr2<input name="r_mbaddr2" type="text" value="${ model.member.MB_ADDR2 }"  /><br/>
		mbemail<input name="r_mbemail" type="text" value="${ model.member.MB_EMAIL }"  /><br/>
		mbmobile<input name="r_mbphone" type="text" value="${ model.member.MB_PHONE }"  /><br/>
		mbtel<input name="r_mbtel" type="text" value="${ model.member.MB_TEL }"  /><br/>
		mbzipcode<input name="r_mbzipcode" type="text" value="${ model.member.MB_ZIPCODE }"  /><br/>
		mbbirth<input name="r_mbbirth" type="text" value="${ model.member.MB_BIRTH }"  /><br/>
		mbemailuse<input name="r_mbemailuse" type="text" value="${ model.member.MB_EMAILUSE }"  /><br/>
		mbsmsyuse<input name="r_mbsmsuse" type="text" value="${ model.member.MB_SMSUSE }"  /><br/>
		mblevel<input name="r_mblevel" type="text" value="${ model.member.MB_LEVEL }"  /><br/>
		mbtype<input name="r_mbtype" type="text" value="${ model.member.MB_TYPE }"  /><br/>
		mbuse<input name="r_mbuse" type="text" value="${ model.member.MB_USE }"  /><br/>
		mbmoid<input name="r_mbmoid" type="text" value="${ model.member.MB_MOID }"  /><br/>
		mbinid<input name="r_mbinid" type="text" value="${ model.member.MB_INID }"  /><br/>
<!--		<input name="r_mbmodate" type="text" value="${ fn:substring( model.member.MB_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_mbindate" type="text" value="${ fn:substring( model.member.MB_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>