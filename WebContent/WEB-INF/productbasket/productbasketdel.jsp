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
		handling.submit( '', 'productbasketadd' );
	}

	function dataDel(){
		handling.submit( '', 'productbasketdel' );
	}

	function dataDown(){
		handling.submit( '', 'productbasketdown' );
	}

	function dataEdit(){
		handling.submit( '', 'productbasketedit' );
	}

	function dataIn(){
		handling.submit( '', 'productbasketin' );
	}

	function dataView(){
		handling.submit( '', 'productbasketview' );
	}

	function dataList(){
		handling.submit( '', 'productbasketlist' );
	}

	function dataSort(){
		handling.submit( '', 'productbasketlist' );
	}

	function dataUp(){
		handling.submit( '', 'productbasketup' );
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

	<form action="productbasketdel" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>productbasketdel</legend>
			<p>
				<label for="r_prbseq">아이디</label>
				<input id="r_prbseq" name="r_prbseq" placeholder="아이디" type="text" value="" required />
			</p>
			<p>
				<label for="r_prbprseq">상품코드</label>
				<input id="r_prbprseq" name="r_prbprseq" placeholder="상품코드" type="text" value="" required />
			</p>
			<p>
				<label for="r_prbmbid">회원아이디</label>
				<input id="r_prbmbid" name="r_prbmbid" placeholder="회원아이디" type="text" value="" required />
			</p>
			<p>
				<label for="r_prbproseq">상품옵션</label>
				<input id="r_prbproseq" name="r_prbproseq" placeholder="상품옵션" type="text" value="" />
			</p>
			<p>
				<label for="r_prbea">수량</label>
				<input id="r_prbea" name="r_prbea" placeholder="수량" type="text" value="" required />
			</p>
			<p>
				<label for="r_prbtype">타입</label>
				<input id="r_prbtype" name="r_prbtype" placeholder="타입" type="text" value="" />
			</p>
			<p>
				<label for="r_prbmoid">수정아이디</label>
				<input id="r_prbmoid" name="r_prbmoid" placeholder="수정아이디" type="text" value="" />
			</p>
			<p>
				<label for="r_prbinid">등록아이디</label>
				<input id="r_prbinid" name="r_prbinid" placeholder="등록아이디" type="text" value="" />
			</p>
			<!--<p>
				<label for="r_prbindate">등록일</label>
				<input id="r_prbindate" name="r_prbindate" placeholder="등록일" type="text" value="" required />
			</p>-->

		<a href="#" onclick="dataDel()">삭제</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>