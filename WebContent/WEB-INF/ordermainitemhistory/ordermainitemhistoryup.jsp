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
		handling.submit( '', 'ordermainitemhistoryadd' );
	}

	function dataDel(){
		handling.submit( '', 'ordermainitemhistorydel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainitemhistorydown' );
	}

	function dataEdit(){
		handling.submit( '', 'ordermainitemhistoryedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainitemhistoryin' );
	}

	function dataView(){
		handling.submit( '', 'ordermainitemhistoryview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainitemhistorylist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainitemhistorylist' );
	}

	function dataUp(){
		handling.submit( '', 'ordermainitemhistoryup' );
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

	<form action="ordermainitemhistoryin" method="post" id="frm" name="frm">

		omihseq<input name="r_omihseq" placeholder="고유값" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_SEQ }' />"  /><br/>
		omihomiseq<input name="r_omihomiseq" placeholder="주문일련번호" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_OMISEQ }' />"  /><br/>
		omihomistatus<input name="r_omihomistatus" placeholder="주문상태값" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_OMISTATUS }' />"  /><br/>
		omihomistep<input name="r_omihomistep" placeholder="스탭" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_OMISTEP }' />"  /><br/>
		omihmemo<input name="r_omihmemo" placeholder="상태변경메모" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_MEMO }' />"  /><br/>
		omihlevel<input name="r_omihlevel" placeholder="레벨" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_LEVEL }' />"  /><br/>
		omihtype<input name="r_omihtype" placeholder="타입" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_TYPE }' />"  /><br/>
		omihmoid<input name="r_omihmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_MOID }' />"  /><br/>
		omihinid<input name="r_omihinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_INID }' />"  /><br/>
<!--		<input name="r_omihmodate" placeholder="수정일" type="text" value="${ fn:substring( model.ordermainitemhistory.OMIH_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_omihindate" placeholder="등록일" type="text" value="${ fn:substring( model.ordermainitemhistory.OMIH_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>