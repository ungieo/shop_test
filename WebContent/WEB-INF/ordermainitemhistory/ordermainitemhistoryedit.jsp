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

	function dataDel( r_omihseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omihseq').val( r_omihseq );
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

	function dataUp( r_omihseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omihseq').val( r_omihseq );
		handling.submit( '', 'ordermainitemhistoryup' );
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

	<form action="ordermainitemhistoryup" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>ordermainitemhistoryedit</legend>
			<p>
				<label for="r_omihseq">고유값</label>
				<input id="r_omihseq" name="r_omihseq" placeholder="고유값" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_SEQ }' />" required />
			</p>
			<p>
				<label for="r_omihomiseq">주문일련번호</label>
				<input id="r_omihomiseq" name="r_omihomiseq" placeholder="주문일련번호" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_OMISEQ }' />" required />
			</p>
			<p>
				<label for="r_omihomistatus">주문상태값</label>
				<input id="r_omihomistatus" name="r_omihomistatus" placeholder="주문상태값" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_OMISTATUS }' />" />
			</p>
			<p>
				<label for="r_omihomistep">스탭</label>
				<input id="r_omihomistep" name="r_omihomistep" placeholder="스탭" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_OMISTEP }' />" />
			</p>
			<p>
				<label for="r_omihmemo">상태변경메모</label>
				<input id="r_omihmemo" name="r_omihmemo" placeholder="상태변경메모" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_MEMO }' />" />
			</p>
			<p>
				<label for="r_omihlevel">레벨</label>
				<input id="r_omihlevel" name="r_omihlevel" placeholder="레벨" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_LEVEL }' />" />
			</p>
			<p>
				<label for="r_omihtype">타입</label>
				<input id="r_omihtype" name="r_omihtype" placeholder="타입" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_TYPE }' />" />
			</p>
			<p>
				<label for="r_omihmoid">수정아이디</label>
				<input id="r_omihmoid" name="r_omihmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_MOID }' />" />
			</p>
			<p>
				<label for="r_omihinid">등록아이디</label>
				<input id="r_omihinid" name="r_omihinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermainitemhistory.OMIH_INID }' />" />
			</p>
			<!--<p>
				<label for="r_omihmodate">수정일</label>
				<input id="r_omihmodate" name="r_omihmodate" placeholder="수정일" type="text" "${ fn:substring( model.ordermainitemhistory.OMIH_MODATE, 0, 16 ) }" required />
			</p>-->
			<!--<p>
				<label for="r_omihindate">등록일</label>
				<input id="r_omihindate" name="r_omihindate" placeholder="등록일" type="text" "${ fn:substring( model.ordermainitemhistory.OMIH_INDATE, 0, 16 ) }" required />
			</p>-->

		</fieldset>
		<a href="#" onclick="dataUp()">저장</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>