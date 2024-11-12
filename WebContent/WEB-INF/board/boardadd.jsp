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
		handling.submit( '', 'boardadd' );
	}

	function dataEdit(){
		handling.submit( '', 'boardedit' );
	}

	function dataDel(){
		handling.submit( '', 'boarddel' );
	}

	function dataDown(){
		handling.submit( '', 'boarddel' );
	}

	function dataIn(){
		handling.submit( '', 'boardin' );
	}

	function dataView(){
		handling.submit( '', 'boardview' );
	}

	function dataList(){
		handling.submit( '', 'boardlist' );
	}

	function dataSort(){
		handling.submit( '', 'boardlist' );
	}

	function dataUp(){
		handling.submit( '', 'boardup' );
	}

	function formSubmit( fName, url ){
		handling.submit( fName, url );
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

	<form action="boardin" method="post" name="frm">

		<fieldset>
			<legend>boardadd</legend>
			<p>
				<label for="r_bdid">아이디</label>
				<input name="r_bdid" type="text" value="" required />
			</p>
			<p>
				<label for="r_bdname">게시판명</label>
				<input name="r_bdname" type="text" value="" />
			</p>
			<p>
				<label for="r_bdcommentuse">코멘트사용여부</label>
				<input name="r_bdcommentuse" type="text" value="" />
			</p>
			<p>
				<label for="r_bddescription">설명</label>
				<input name="r_bddescription" type="text" value="" />
			</p>
			<p>
				<label for="r_bdfilemaxsize">파일최대사이즈</label>
				<input name="r_bdfilemaxsize" type="text" value="" />
			</p>
			<p>
				<label for="r_bdfileuse">파일사용여부</label>
				<input name="r_bdfileuse" type="text" value="" />
			</p>
			<p>
				<label for="r_bdimage">이미지</label>
				<input name="r_bdimage" type="text" value="" />
			</p>
			<p>
				<label for="r_bdip">보드아이피</label>
				<input name="r_bdip" type="text" value="" />
			</p>
			<p>
				<label for="r_bdipuse">아이피사용여부</label>
				<input name="r_bdipuse" type="text" value="" />
			</p>
			<p>
				<label for="r_bdpswduse">암호사용여부</label>
				<input name="r_bdpswduse" type="text" value="" />
			</p>
			<p>
				<label for="r_bdreplyuse">답글여부</label>
				<input name="r_bdreplyuse" type="text" value="" />
			</p>
			<p>
				<label for="r_bdsorttype">정렬타입</label>
				<input name="r_bdsorttype" type="text" value="" />
			</p>
			<p>
				<label for="r_bdviewtype">뷰타입</label>
				<input name="r_bdviewtype" type="text" value="" />
			</p>
			<p>
				<label for="r_bdlevel">레벨</label>
				<input name="r_bdlevel" type="text" value="" />
			</p>
			<p>
				<label for="r_bdtype">타입</label>
				<input name="r_bdtype" type="text" value="" />
			</p>
			<p>
				<label for="r_bduse">사용여부</label>
				<input name="r_bduse" type="text" value="" />
			</p>
			<p>
				<label for="r_bdmoid">수정아이디</label>
				<input name="r_bdmoid" type="text" value="" />
			</p>
			<p>
				<label for="r_bdinid">등록아이디</label>
				<input name="r_bdinid" type="text" value="" />
			</p>
			<!--<p>
				<label for="r_bdmodate">수정일</label>
				<input name="r_bdmodate" type="text" value="" required />
			</p>-->
			<!--<p>
				<label for="r_bdindate">등록일</label>
				<input name="r_bdindate" type="text" value="" required />
			</p>-->
		</fieldset>
		<a href="#" onclick="dataIn()">저장</a><br/>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>