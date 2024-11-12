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
		handling.submit( '', 'companyadd' );
	}

	function dataDel(){
		handling.submit( '', 'companydel' );
	}

	function dataDown(){
		handling.submit( '', 'companydown' );
	}

	function dataEdit(){
		handling.submit( '', 'companyedit' );
	}

	function dataIn(){
		handling.submit( '', 'companyin' );
	}

	function dataView(){
		handling.submit( '', 'companyview' );
	}

	function dataList(){
		handling.submit( '', 'companylist' );
	}

	function dataSort(){
		handling.submit( '', 'companylist' );
	}

	function dataUp(){
		handling.submit( '', 'companyup' );
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

	<form action="companyview" id="frm" name="frm" method="post" >

	<input name="r_cpseq" type="hidden" value="${ model.company.CP_SEQ }" />
	<c:if test="${ !empty model.company }">
		고유번호=<c:out value='${ model.company.CP_SEQ }' /><br/>
		회사아이디=<c:out value='${ model.company.CP_ID }' /><br/>
		회사명=<c:out value='${ model.company.CP_NAME }' /><br/>
		사업자번호=<c:out value='${ model.company.CP_BIZNUM }' /><br/>
		업태=<c:out value='${ model.company.CP_UPTAI }' /><br/>
		업종=<c:out value='${ model.company.CP_UPJONG }' /><br/>
		대표명=<c:out value='${ model.company.CP_CEONAME }' /><br/>
		우편번호=<c:out value='${ model.company.CP_ZIPCODE }' /><br/>
		기본주소=<c:out value='${ model.company.CP_ADDR1 }' /><br/>
		상세주소=<c:out value='${ model.company.CP_ADDR2 }' /><br/>
		파일=<c:out value='${ model.company.CP_FILE }' /><br/>
		배송비=<c:out value='${ model.company.CP_DELIVERYMONEY }' /><br/>
		결제타입=<c:out value='${ model.company.CP_PAYTYPE }' /><br/>
		회사타입=<c:out value='${ model.company.CP_BIZTYPE }' /><br/>
		통신사업자=<c:out value='${ model.company.CP_TONGSINBIZNUM }' /><br/>
		이메일=<c:out value='${ model.company.CP_EMAIL }' /><br/>
		전화=<c:out value='${ model.company.CP_TEL }' /><br/>
		휴대전화=<c:out value='${ model.company.CP_PHONE }' /><br/>
		팩스=<c:out value='${ model.company.CP_FAX }' /><br/>
		레벨=<c:out value='${ model.company.CP_LEVEL }' /><br/>
		타입=<c:out value='${ model.company.CP_TYPE }' /><br/>
		사용여부=<c:out value='${ model.company.CP_USE }' /><br/>
		수정아이디=<c:out value='${ model.company.CP_MOID }' /><br/>
		등록아이디=<c:out value='${ model.company.CP_INID }' /><br/>
<!--		수정일=${ fn:substring( model.company.CP_MODATE, 0, 16 ) }--><br/>
<!--		등록일=${ fn:substring( model.company.CP_INDATE, 0, 16 ) }--><br/>
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