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
		handling.submit( '', 'productdisplayadd' );
	}

	function dataDel( r_prdseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prdseq').val( r_prdseq );
		handling.submit( '', 'productdisplaydel' );
	}

	function dataDown(){
		handling.submit( '', 'productdisplaydown' );
	}

	function dataEdit(){
		handling.submit( '', 'productdisplayedit' );
	}

	function dataIn(){
		handling.submit( '', 'productdisplayin' );
	}

	function dataView(){
		handling.submit( '', 'productdisplayview' );
	}

	function dataList(){
		handling.submit( '', 'productdisplaylist' );
	}

	function dataSort(){
		handling.submit( '', 'productdisplaylist' );
	}

	function dataUp( r_prdseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prdseq').val( r_prdseq );
		handling.submit( '', 'productdisplayup' );
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

	<form action="productdisplayup" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>productdisplayedit</legend>
			<p>
				<label for="r_prdseq">고유번호</label>
				<input id="r_prdseq" name="r_prdseq" placeholder="고유번호" type="text" value="<c:out value='${ model.productdisplay.PRD_SEQ }' />" required />
			</p>
			<p>
				<label for="r_prdprseq">브랜드명</label>
				<input id="r_prdprseq" name="r_prdprseq" placeholder="브랜드명" type="text" value="<c:out value='${ model.productdisplay.PRD_PRSEQ }' />" />
			</p>
			<p>
				<label for="r_prdtype">타입 B=BEST N=NEW P=POPULAR H=HOT R=RECOMMEND</label>
				<input id="r_prdtype" name="r_prdtype" placeholder="타입 B=BEST N=NEW P=POPULAR H=HOT R=RECOMMEND" type="text" value="<c:out value='${ model.productdisplay.PRD_TYPE }' />" />
			</p>
			<p>
				<label for="r_prduse">승인여부</label>
				<input id="r_prduse" name="r_prduse" placeholder="승인여부" type="text" value="<c:out value='${ model.productdisplay.PRD_USE }' />" />
			</p>
			<p>
				<label for="r_prdinid">등록아이디</label>
				<input id="r_prdinid" name="r_prdinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.productdisplay.PRD_INID }' />" />
			</p>
			<!--<p>
				<label for="r_prdindate">등록일</label>
				<input id="r_prdindate" name="r_prdindate" placeholder="등록일" type="text" "${ fn:substring( model.productdisplay.PRD_INDATE, 0, 16 ) }" required />
			</p>-->

		</fieldset>
		<a href="#" onclick="dataUp()">저장</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>