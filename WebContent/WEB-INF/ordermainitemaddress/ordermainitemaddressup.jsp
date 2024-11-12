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
		handling.submit( '', 'ordermainitemaddressadd' );
	}

	function dataDel(){
		handling.submit( '', 'ordermainitemaddressdel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainitemaddressdown' );
	}

	function dataEdit(){
		handling.submit( '', 'ordermainitemaddressedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainitemaddressin' );
	}

	function dataView(){
		handling.submit( '', 'ordermainitemaddressview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainitemaddresslist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainitemaddresslist' );
	}

	function dataUp(){
		handling.submit( '', 'ordermainitemaddressup' );
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

	<form action="ordermainitemaddressin" method="post" id="frm" name="frm">

		omiaseq<input name="r_omiaseq" placeholder="고유값" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_SEQ }' />"  /><br/>
		omiaomiseq<input name="r_omiaomiseq" placeholder="주문일련번호" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_OMISEQ }' />"  /><br/>
		omianame<input name="r_omianame" placeholder="이름" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_NAME }' />"  /><br/>
		omiatel<input name="r_omiatel" placeholder="전화번호" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_TEL }' />"  /><br/>
		omiaphone<input name="r_omiaphone" placeholder="휴대폰" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_PHONE }' />"  /><br/>
		omiaemail<input name="r_omiaemail" placeholder="이메일" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_EMAIL }' />"  /><br/>
		omiazipcode<input name="r_omiazipcode" placeholder="우편번호" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_ZIPCODE }' />"  /><br/>
		omiaaddr1<input name="r_omiaaddr1" placeholder="주소1" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_ADDR1 }' />"  /><br/>
		omiaaddr2<input name="r_omiaaddr2" placeholder="주소2" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_ADDR2 }' />"  /><br/>
		omiatype<input name="r_omiatype" placeholder="타입(S=보내는자 R=받는자)" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_TYPE }' />"  /><br/>
		omiamoid<input name="r_omiamoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_MOID }' />"  /><br/>
		omiainid<input name="r_omiainid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_INID }' />"  /><br/>
<!--		<input name="r_omiamodate" placeholder="수정일" type="text" value="${ fn:substring( model.ordermainitemaddress.OMIA_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_omiaindate" placeholder="등록일" type="text" value="${ fn:substring( model.ordermainitemaddress.OMIA_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>