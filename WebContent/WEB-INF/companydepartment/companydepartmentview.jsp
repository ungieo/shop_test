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
		handling.submit( '', 'companydepartmentadd' );
	}

	function dataDel( r_cpdseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_cpdseq').val( r_cpdseq );
		handling.submit( '', 'companydepartmentdel' );
	}

	function dataDown(){
		handling.submit( '', 'companydepartmentdown' );
	}

	function dataEdit(){
		handling.submit( '', 'companydepartmentedit' );
	}

	function dataIn(){
		handling.submit( '', 'companydepartmentin' );
	}

	function dataView(){
		handling.submit( '', 'companydepartmentview' );
	}

	function dataList(){
		handling.submit( '', 'companydepartmentlist' );
	}

	function dataSort(){
		handling.submit( '', 'companydepartmentlist' );
	}

	function dataUp( r_cpdseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_cpdseq').val( r_cpdseq );
		handling.submit( '', 'companydepartmentup' );
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

	<form action="companydepartmentview" id="frm" name="frm" method="post" >

	<input name="r_cpdseq" type="hidden" value="${ model.companydepartment.CPD_SEQ }" />
	<c:if test="${ !empty model.companydepartment }">
		고유번호=<c:out value='${ model.companydepartment.CPD_SEQ }' /><br/>
		회사아이디=<c:out value='${ model.companydepartment.CPD_CPID }' /><br/>
		부서아이디=<c:out value='${ model.companydepartment.CPD_ID }' /><br/>
		부서명=<c:out value='${ model.companydepartment.CPD_NAME }' /><br/>
		결제타입=<c:out value='${ model.companydepartment.CPD_PAYTYPE }' /><br/>
		이메일=<c:out value='${ model.companydepartment.CPD_EMAIL }' /><br/>
		전화=<c:out value='${ model.companydepartment.CPD_TEL }' /><br/>
		휴대전화=<c:out value='${ model.companydepartment.CPD_PHONE }' /><br/>
		팩스=<c:out value='${ model.companydepartment.CPD_FAX }' /><br/>
		레벨=<c:out value='${ model.companydepartment.CPD_LEVEL }' /><br/>
		타입 N=일반=<c:out value='${ model.companydepartment.CPD_TYPE }' /><br/>
		승인여부=<c:out value='${ model.companydepartment.CPD_USE }' /><br/>
		수정아이디=<c:out value='${ model.companydepartment.CPD_MOID }' /><br/>
		등록아이디=<c:out value='${ model.companydepartment.CPD_INID }' /><br/>
<!--		수정일=${ fn:substring( model.companydepartment.CPD_MODATE, 0, 16 ) }--><br/>
<!--		등록일=${ fn:substring( model.companydepartment.CPD_INDATE, 0, 16 ) }--><br/>
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