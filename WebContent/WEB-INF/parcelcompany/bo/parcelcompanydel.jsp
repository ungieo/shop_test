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
		handling.submit( '', 'parcelcompanyadd' );
	}

	function dataDel(){
		handling.submit( '', 'parcelcompanydel' );
	}

	function dataDown(){
		handling.submit( '', 'parcelcompanydown' );
	}

	function dataEdit(){
		handling.submit( '', 'parcelcompanyedit' );
	}

	function dataIn(){
		handling.submit( '', 'parcelcompanyin' );
	}

	function dataView(){
		handling.submit( '', 'parcelcompanyview' );
	}

	function dataList(){
		handling.submit( '', 'parcelcompanylist' );
	}

	function dataSort(){
		handling.submit( '', 'parcelcompanylist' );
	}

	function dataUp(){
		handling.submit( '', 'parcelcompanyup' );
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

	<form action="parcelcompanydel" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>parcelcompanydel</legend>
			<p>
				<label for="r_pcseq">고유값</label>
				<input id="r_pcseq" name="r_pcseq" placeholder="고유값" type="text" value="" required />
			</p>
			<p>
				<label for="r_pcname">택배사명</label>
				<input id="r_pcname" name="r_pcname" placeholder="택배사명" type="text" value="" required />
			</p>
			<p>
				<label for="r_pccpid">회사설정</label>
				<input id="r_pccpid" name="r_pccpid" placeholder="회사설정" type="text" value="" required />
			</p>
			<p>
				<label for="r_pcurl">택배사URL</label>
				<input id="r_pcurl" name="r_pcurl" placeholder="택배사URL" type="text" value="" />
			</p>
			<p>
				<label for="r_pclevel">레벨</label>
				<input id="r_pclevel" name="r_pclevel" placeholder="레벨" type="text" value="" />
			</p>
			<p>
				<label for="r_pctype">타입</label>
				<input id="r_pctype" name="r_pctype" placeholder="타입" type="text" value="" />
			</p>
			<p>
				<label for="r_pcuse">사용여부</label>
				<input id="r_pcuse" name="r_pcuse" placeholder="사용여부" type="text" value="" />
			</p>
			<p>
				<label for="r_pcinid">등록아이디</label>
				<input id="r_pcinid" name="r_pcinid" placeholder="등록아이디" type="text" value="" />
			</p>
			<!--<p>
				<label for="r_pcindate">등록일</label>
				<input id="r_pcindate" name="r_pcindate" placeholder="등록일" type="text" value="" required />
			</p>-->

		<a href="#" onclick="dataDel()">삭제</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>