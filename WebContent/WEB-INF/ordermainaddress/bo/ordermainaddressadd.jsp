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

	function dataEdit(){
		handling.submit( '', 'ordermainaddressedit' );
	}

	function dataDel(){
		handling.submit( '', 'ordermainaddressdel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainaddressdown' );
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
		handling.submit( fName, url );
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

	<form action="ordermainaddressin" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>ordermainaddressadd</legend>
			<p>
				<label for="r_omaseq">고유값</label>
				<input id="r_omaseq" name="r_omaseq" placeholder="고유값" type="text" value="<c:out value='${ model.ordermainaddress.OMA_SEQ }' />" required />
			</p>
			<p>
				<label for="r_omaomseq">주문번호</label>
				<input id="r_omaomseq" name="r_omaomseq" placeholder="주문번호" type="text" value="<c:out value='${ model.ordermainaddress.OMA_OMSEQ }' />" required />
			</p>
			<p>
				<label for="r_omaname">이름</label>
				<input id="r_omaname" name="r_omaname" placeholder="이름" type="text" value="<c:out value='${ model.ordermainaddress.OMA_NAME }' />" />
			</p>
			<p>
				<label for="r_omatel">전화번호</label>
				<input id="r_omatel" name="r_omatel" placeholder="전화번호" type="text" value="<c:out value='${ model.ordermainaddress.OMA_TEL }' />" />
			</p>
			<p>
				<label for="r_omaphone">휴대폰</label>
				<input id="r_omaphone" name="r_omaphone" placeholder="휴대폰" type="text" value="<c:out value='${ model.ordermainaddress.OMA_PHONE }' />" required />
			</p>
			<p>
				<label for="r_omaemail">이메일</label>
				<input id="r_omaemail" name="r_omaemail" placeholder="이메일" type="text" value="<c:out value='${ model.ordermainaddress.OMA_EMAIL }' />" />
			</p>
			<p>
				<label for="r_omazipcode">우편번호</label>
				<input id="r_omazipcode" name="r_omazipcode" placeholder="우편번호" type="text" value="<c:out value='${ model.ordermainaddress.OMA_ZIPCODE }' />" required />
			</p>
			<p>
				<label for="r_omaaddr1">주소1</label>
				<input id="r_omaaddr1" name="r_omaaddr1" placeholder="주소1" type="text" value="<c:out value='${ model.ordermainaddress.OMA_ADDR1 }' />" required />
			</p>
			<p>
				<label for="r_omaaddr2">주소2</label>
				<input id="r_omaaddr2" name="r_omaaddr2" placeholder="주소2" type="text" value="<c:out value='${ model.ordermainaddress.OMA_ADDR2 }' />" />
			</p>
			<p>
				<label for="r_omatype">타입(S=보내는자 R=받는자)</label>
				<input id="r_omatype" name="r_omatype" placeholder="타입(S=보내는자 R=받는자)" type="text" value="<c:out value='${ model.ordermainaddress.OMA_TYPE }' />" />
			</p>
			<p>
				<label for="r_omamoid">수정아이디</label>
				<input id="r_omamoid" name="r_omamoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermainaddress.OMA_MOID }' />" />
			</p>
			<p>
				<label for="r_omainid">등록아이디</label>
				<input id="r_omainid" name="r_omainid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermainaddress.OMA_INID }' />" />
			</p>
			<!--<p>
				<label for="r_omamodate">수정일</label>
				<input id="r_omamodate" name="r_omamodate" placeholder="수정일"  type="text" "${ fn:substring( model.ordermainaddress.OMA_MODATE, 0, 16 ) }" required />
			</p>-->
			<!--<p>
				<label for="r_omaindate">등록일</label>
				<input id="r_omaindate" name="r_omaindate" placeholder="등록일"  type="text" "${ fn:substring( model.ordermainaddress.OMA_INDATE, 0, 16 ) }" required />
			</p>-->
		</fieldset>
		<a href="#" onclick="dataIn()">저장</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>