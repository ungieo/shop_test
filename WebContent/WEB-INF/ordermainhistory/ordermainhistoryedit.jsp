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
		handling.submit( '', 'ordermainhistoryadd' );
	}

	function dataDel( r_omhseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omhseq').val( r_omhseq );
		handling.submit( '', 'ordermainhistorydel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainhistorydown' );
	}

	function dataEdit(){
		handling.submit( '', 'ordermainhistoryedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainhistoryin' );
	}

	function dataView(){
		handling.submit( '', 'ordermainhistoryview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainhistorylist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainhistorylist' );
	}

	function dataUp( r_omhseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omhseq').val( r_omhseq );
		handling.submit( '', 'ordermainhistoryup' );
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

	<form action="ordermainhistoryup" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>ordermainhistoryedit</legend>
			<p>
				<label for="r_omhseq">고유값</label>
				<input id="r_omhseq" name="r_omhseq" placeholder="고유값" type="text" value="<c:out value='${ model.ordermainhistory.OMH_SEQ }' />" required />
			</p>
			<p>
				<label for="r_omhomseq">주문일련번호</label>
				<input id="r_omhomseq" name="r_omhomseq" placeholder="주문일련번호" type="text" value="<c:out value='${ model.ordermainhistory.OMH_OMSEQ }' />" required />
			</p>
			<p>
				<label for="r_omhomstatus">주문상태값</label>
				<input id="r_omhomstatus" name="r_omhomstatus" placeholder="주문상태값" type="text" value="<c:out value='${ model.ordermainhistory.OMH_OMSTATUS }' />" />
			</p>
			<p>
				<label for="r_omhomstep">주문스탭</label>
				<input id="r_omhomstep" name="r_omhomstep" placeholder="주문스탭" type="text" value="<c:out value='${ model.ordermainhistory.OMH_OMSTEP }' />" />
			</p>
			<p>
				<label for="r_omhmemo">상태변경메모</label>
				<input id="r_omhmemo" name="r_omhmemo" placeholder="상태변경메모" type="text" value="<c:out value='${ model.ordermainhistory.OMH_MEMO }' />" />
			</p>
			<p>
				<label for="r_omhlevel">레벨</label>
				<input id="r_omhlevel" name="r_omhlevel" placeholder="레벨" type="text" value="<c:out value='${ model.ordermainhistory.OMH_LEVEL }' />" />
			</p>
			<p>
				<label for="r_omhtype">타입</label>
				<input id="r_omhtype" name="r_omhtype" placeholder="타입" type="text" value="<c:out value='${ model.ordermainhistory.OMH_TYPE }' />" />
			</p>
			<p>
				<label for="r_omhmoid">수정아이디</label>
				<input id="r_omhmoid" name="r_omhmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermainhistory.OMH_MOID }' />" />
			</p>
			<p>
				<label for="r_omhinid">등록아이디</label>
				<input id="r_omhinid" name="r_omhinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermainhistory.OMH_INID }' />" />
			</p>
			<!--<p>
				<label for="r_omhmodate">수정일</label>
				<input id="r_omhmodate" name="r_omhmodate" placeholder="수정일" type="text" "${ fn:substring( model.ordermainhistory.OMH_MODATE, 0, 16 ) }" required />
			</p>-->
			<!--<p>
				<label for="r_omhindate">등록일</label>
				<input id="r_omhindate" name="r_omhindate" placeholder="등록일" type="text" "${ fn:substring( model.ordermainhistory.OMH_INDATE, 0, 16 ) }" required />
			</p>-->

		</fieldset>
		<a href="#" onclick="dataUp()">저장</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>