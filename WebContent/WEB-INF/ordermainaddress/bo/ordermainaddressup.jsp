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

	function dataAdd(){
		handling.submit( '', 'ordermainaddressadd' );
	}

	function dataDel(){
		handling.submit( '', 'ordermainaddressdel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainaddressdown' );
	}

	function dataEdit(){
		handling.submit( '', 'ordermainaddressedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainaddressin' );
	}

	function dataView(){
		handling.submit( '', 'ordermainaddressview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainaddresslist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainaddresslist' );
	}

	function dataUp(){
		handling.submit( '', 'ordermainaddressup' );
	}

	function formSubmit( fName, url ){
		handling.submit( '', url );
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

	<form action="ordermainaddressin" method="post" id="frm" name="frm">

		omaseq<input name="r_omaseq" placeholder="고유값" type="text" value="<c:out value='${ model.ordermainaddress.OMA_SEQ }' />"  /><br/>
		omaomseq<input name="r_omaomseq" placeholder="주문번호" type="text" value="<c:out value='${ model.ordermainaddress.OMA_OMSEQ }' />"  /><br/>
		omaname<input name="r_omaname" placeholder="이름" type="text" value="<c:out value='${ model.ordermainaddress.OMA_NAME }' />"  /><br/>
		omatel<input name="r_omatel" placeholder="전화번호" type="text" value="<c:out value='${ model.ordermainaddress.OMA_TEL }' />"  /><br/>
		omaphone<input name="r_omaphone" placeholder="휴대폰" type="text" value="<c:out value='${ model.ordermainaddress.OMA_PHONE }' />"  /><br/>
		omaemail<input name="r_omaemail" placeholder="이메일" type="text" value="<c:out value='${ model.ordermainaddress.OMA_EMAIL }' />"  /><br/>
		omazipcode<input name="r_omazipcode" placeholder="우편번호" type="text" value="<c:out value='${ model.ordermainaddress.OMA_ZIPCODE }' />"  /><br/>
		omaaddr1<input name="r_omaaddr1" placeholder="주소1" type="text" value="<c:out value='${ model.ordermainaddress.OMA_ADDR1 }' />"  /><br/>
		omaaddr2<input name="r_omaaddr2" placeholder="주소2" type="text" value="<c:out value='${ model.ordermainaddress.OMA_ADDR2 }' />"  /><br/>
		omatype<input name="r_omatype" placeholder="타입(S=보내는자 R=받는자)" type="text" value="<c:out value='${ model.ordermainaddress.OMA_TYPE }' />"  /><br/>
		omamoid<input name="r_omamoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermainaddress.OMA_MOID }' />"  /><br/>
		omainid<input name="r_omainid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermainaddress.OMA_INID }' />"  /><br/>
<!--		<input name="r_omamodate" placeholder="수정일" type="text" value="${ fn:substring( model.ordermainaddress.OMA_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_omaindate" placeholder="등록일" type="text" value="${ fn:substring( model.ordermainaddress.OMA_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>