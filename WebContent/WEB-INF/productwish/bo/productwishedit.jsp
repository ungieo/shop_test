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
		handling.submit( '', 'productwishadd' );
	}

	function dataDel( r_prwseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prwseq').val( r_prwseq );
		handling.submit( '', 'productwishdel' );
	}

	function dataDown(){
		handling.submit( '', 'productwishdown' );
	}

	function dataEdit(){
		handling.submit( '', 'productwishedit' );
	}

	function dataIn(){
		handling.submit( '', 'productwishin' );
	}

	function dataView(){
		handling.submit( '', 'productwishview' );
	}

	function dataList(){
		handling.submit( '', 'productwishlist' );
	}

	function dataSort(){
		handling.submit( '', 'productwishlist' );
	}

	function dataUp( r_prwseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prwseq').val( r_prwseq );
		handling.submit( '', 'productwishup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
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

	<form action="productwishup" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>productwishedit</legend>
			<p>
				<label for="r_prwseq">고유값</label>
				<input id="r_prwseq" name="r_prwseq" placeholder="고유값" type="text" value="<c:out value='${ model.productwish.PRW_SEQ }' />" required />
			</p>
			<p>
				<label for="r_prwprseq">상품고유값</label>
				<input id="r_prwprseq" name="r_prwprseq" placeholder="상품고유값" type="text" value="<c:out value='${ model.productwish.PRW_PRSEQ }' />" required />
			</p>
			<p>
				<label for="r_prwproseq">옵션고유번호</label>
				<input id="r_prwproseq" name="r_prwproseq" placeholder="옵션고유번호" type="text" value="<c:out value='${ model.productwish.PRW_PROSEQ }' />" />
			</p>
			<p>
				<label for="r_prwmbid"></label>
				<input id="r_prwmbid" name="r_prwmbid" placeholder="" type="text" value="<c:out value='${ model.productwish.PRW_MBID }' />" />
			</p>
			<p>
				<label for="r_prwlevel">레벨</label>
				<input id="r_prwlevel" name="r_prwlevel" placeholder="레벨" type="text" value="<c:out value='${ model.productwish.PRW_LEVEL }' />" />
			</p>
			<p>
				<label for="r_prwtype">타입</label>
				<input id="r_prwtype" name="r_prwtype" placeholder="타입" type="text" value="<c:out value='${ model.productwish.PRW_TYPE }' />" />
			</p>
			<p>
				<label for="r_prwuse">사용여부</label>
				<input id="r_prwuse" name="r_prwuse" placeholder="사용여부" type="text" value="<c:out value='${ model.productwish.PRW_USE }' />" />
			</p>
			<p>
				<label for="r_prwmoid">수정아이디</label>
				<input id="r_prwmoid" name="r_prwmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.productwish.PRW_MOID }' />" />
			</p>
			<p>
				<label for="r_prwinid">등록아이디</label>
				<input id="r_prwinid" name="r_prwinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.productwish.PRW_INID }' />" />
			</p>
			<!--<p>
				<label for="r_prwmodate">수정일</label>
				<input id="r_prwmodate" name="r_prwmodate" placeholder="수정일" type="text" "${ fn:substring( model.productwish.PRW_MODATE, 0, 16 ) }" required />
			</p>-->
			<!--<p>
				<label for="r_prwindate">등록일</label>
				<input id="r_prwindate" name="r_prwindate" placeholder="등록일" type="text" "${ fn:substring( model.productwish.PRW_INDATE, 0, 16 ) }" required />
			</p>-->

		</fieldset>
		<a href="#" onclick="dataUp()">저장</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>