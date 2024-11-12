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

	function dataDel(){
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

	function dataUp(){
		handling.submit( '', 'ordermainhistoryup' );
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

	<form action="ordermainhistoryin" method="post" id="frm" name="frm">

		omhseq<input name="r_omhseq" placeholder="고유값" type="text" value="<c:out value='${ model.ordermainhistory.OMH_SEQ }' />"  /><br/>
		omhomseq<input name="r_omhomseq" placeholder="주문일련번호" type="text" value="<c:out value='${ model.ordermainhistory.OMH_OMSEQ }' />"  /><br/>
		omhomstatus<input name="r_omhomstatus" placeholder="주문상태값" type="text" value="<c:out value='${ model.ordermainhistory.OMH_OMSTATUS }' />"  /><br/>
		omhomstep<input name="r_omhomstep" placeholder="주문스탭" type="text" value="<c:out value='${ model.ordermainhistory.OMH_OMSTEP }' />"  /><br/>
		omhmemo<input name="r_omhmemo" placeholder="상태변경메모" type="text" value="<c:out value='${ model.ordermainhistory.OMH_MEMO }' />"  /><br/>
		omhlevel<input name="r_omhlevel" placeholder="레벨" type="text" value="<c:out value='${ model.ordermainhistory.OMH_LEVEL }' />"  /><br/>
		omhtype<input name="r_omhtype" placeholder="타입" type="text" value="<c:out value='${ model.ordermainhistory.OMH_TYPE }' />"  /><br/>
		omhmoid<input name="r_omhmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermainhistory.OMH_MOID }' />"  /><br/>
		omhinid<input name="r_omhinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermainhistory.OMH_INID }' />"  /><br/>
<!--		<input name="r_omhmodate" placeholder="수정일" type="text" value="${ fn:substring( model.ordermainhistory.OMH_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_omhindate" placeholder="등록일" type="text" value="${ fn:substring( model.ordermainhistory.OMH_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>