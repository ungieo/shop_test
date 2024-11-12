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

	<form action="ordermainitemaddressin" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>ordermainitemaddressin</legend>
			<p>
				<label for="r_omiaseq">고유값</label>
				<input id="r_omiaseq" name="r_omiaseq" placeholder="고유값" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_SEQ }' />" required />
			</p>
			<p>
				<label for="r_omiaomiseq">주문일련번호</label>
				<input id="r_omiaomiseq" name="r_omiaomiseq" placeholder="주문일련번호" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_OMISEQ }' />" required />
			</p>
			<p>
				<label for="r_omianame">이름</label>
				<input id="r_omianame" name="r_omianame" placeholder="이름" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_NAME }' />" />
			</p>
			<p>
				<label for="r_omiatel">전화번호</label>
				<input id="r_omiatel" name="r_omiatel" placeholder="전화번호" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_TEL }' />" />
			</p>
			<p>
				<label for="r_omiaphone">휴대폰</label>
				<input id="r_omiaphone" name="r_omiaphone" placeholder="휴대폰" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_PHONE }' />" required />
			</p>
			<p>
				<label for="r_omiaemail">이메일</label>
				<input id="r_omiaemail" name="r_omiaemail" placeholder="이메일" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_EMAIL }' />" />
			</p>
			<p>
				<label for="r_omiazipcode">우편번호</label>
				<input id="r_omiazipcode" name="r_omiazipcode" placeholder="우편번호" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_ZIPCODE }' />" required />
			</p>
			<p>
				<label for="r_omiaaddr1">주소1</label>
				<input id="r_omiaaddr1" name="r_omiaaddr1" placeholder="주소1" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_ADDR1 }' />" required />
			</p>
			<p>
				<label for="r_omiaaddr2">주소2</label>
				<input id="r_omiaaddr2" name="r_omiaaddr2" placeholder="주소2" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_ADDR2 }' />" />
			</p>
			<p>
				<label for="r_omiatype">타입(S=보내는자 R=받는자)</label>
				<input id="r_omiatype" name="r_omiatype" placeholder="타입(S=보내는자 R=받는자)" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_TYPE }' />" />
			</p>
			<p>
				<label for="r_omiamoid">수정아이디</label>
				<input id="r_omiamoid" name="r_omiamoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_MOID }' />" />
			</p>
			<p>
				<label for="r_omiainid">등록아이디</label>
				<input id="r_omiainid" name="r_omiainid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermainitemaddress.OMIA_INID }' />" />
			</p>
			<!--<p>
				<label for="r_omiamodate">수정일</label>
				<input id="r_omiamodate" name="r_omiamodate" placeholder="수정일" type="text" "${ fn:substring( model.ordermainitemaddress.OMIA_MODATE, 0, 16 ) }" required />
			</p>-->
			<!--<p>
				<label for="r_omiaindate">등록일</label>
				<input id="r_omiaindate" name="r_omiaindate" placeholder="등록일" type="text" "${ fn:substring( model.ordermainitemaddress.OMIA_INDATE, 0, 16 ) }" required />
			</p>-->

		<a href="#" onclick="dataList()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>