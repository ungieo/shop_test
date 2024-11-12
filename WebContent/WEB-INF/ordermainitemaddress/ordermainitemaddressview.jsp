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
		handling.submit( '', 'ordermainitemaddressadd' );
	}

	function dataDel( r_omiaseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omiaseq').val( r_omiaseq );
		handling.submit( '', 'ordermainitemaddressdel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainitemaddressdown' );
	}

	function dataEdit(){
		handling.submit( '', 'ordermainitemaddressedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainitemaddressin' );
	}

	function dataView(){
		handling.submit( '', 'ordermainitemaddressview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainitemaddresslist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainitemaddresslist' );
	}

	function dataUp( r_omiaseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omiaseq').val( r_omiaseq );
		handling.submit( '', 'ordermainitemaddressup' );
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

	<form action="ordermainitemaddressview" id="frm" name="frm" method="post" >

	<input name="r_omiaseq" type="hidden" value="${ model.ordermainitemaddress.OMIA_SEQ }" />
	<c:if test="${ !empty model.ordermainitemaddress }">
		고유값=<c:out value='${ model.ordermainitemaddress.OMIA_SEQ }' /><br/>
		주문일련번호=<c:out value='${ model.ordermainitemaddress.OMIA_OMISEQ }' /><br/>
		이름=<c:out value='${ model.ordermainitemaddress.OMIA_NAME }' /><br/>
		전화번호=<c:out value='${ model.ordermainitemaddress.OMIA_TEL }' /><br/>
		휴대폰=<c:out value='${ model.ordermainitemaddress.OMIA_PHONE }' /><br/>
		이메일=<c:out value='${ model.ordermainitemaddress.OMIA_EMAIL }' /><br/>
		우편번호=<c:out value='${ model.ordermainitemaddress.OMIA_ZIPCODE }' /><br/>
		주소1=<c:out value='${ model.ordermainitemaddress.OMIA_ADDR1 }' /><br/>
		주소2=<c:out value='${ model.ordermainitemaddress.OMIA_ADDR2 }' /><br/>
		타입(S=보내는자 R=받는자)=<c:out value='${ model.ordermainitemaddress.OMIA_TYPE }' /><br/>
		수정아이디=<c:out value='${ model.ordermainitemaddress.OMIA_MOID }' /><br/>
		등록아이디=<c:out value='${ model.ordermainitemaddress.OMIA_INID }' /><br/>
<!--		수정일=${ fn:substring( model.ordermainitemaddress.OMIA_MODATE, 0, 16 ) }--><br/>
<!--		등록일=${ fn:substring( model.ordermainitemaddress.OMIA_INDATE, 0, 16 ) }--><br/>
	</c:if>

		<a href="#" onclick="dataAdd(  )">등록</a>
		<a href="#" onclick="dataEdit(  )">수정</a>
		<a href="#" onclick="dataDel(  )">삭제</a>
		<a href="#" onclick="dataList(  )">리스트</a>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>