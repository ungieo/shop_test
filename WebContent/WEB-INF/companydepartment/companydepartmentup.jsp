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

	function dataDel(){
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

	function dataUp(){
		handling.submit( '', 'companydepartmentup' );
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

	<form action="companydepartmentin" method="post" id="frm" name="frm">

		cpdseq<input name="r_cpdseq" placeholder="고유번호" type="text" value="<c:out value='${ model.companydepartment.CPD_SEQ }' />"  /><br/>
		cpdcpid<input name="r_cpdcpid" placeholder="회사아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_CPID }' />"  /><br/>
		cpdid<input name="r_cpdid" placeholder="부서아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_ID }' />"  /><br/>
		cpdname<input name="r_cpdname" placeholder="부서명" type="text" value="<c:out value='${ model.companydepartment.CPD_NAME }' />"  /><br/>
		cpdpaytype<input name="r_cpdpaytype" placeholder="결제타입" type="text" value="<c:out value='${ model.companydepartment.CPD_PAYTYPE }' />"  /><br/>
		cpdemail<input name="r_cpdemail" placeholder="이메일" type="text" value="<c:out value='${ model.companydepartment.CPD_EMAIL }' />"  /><br/>
		cpdtel<input name="r_cpdtel" placeholder="전화" type="text" value="<c:out value='${ model.companydepartment.CPD_TEL }' />"  /><br/>
		cpdphone<input name="r_cpdphone" placeholder="휴대전화" type="text" value="<c:out value='${ model.companydepartment.CPD_PHONE }' />"  /><br/>
		cpdfax<input name="r_cpdfax" placeholder="팩스" type="text" value="<c:out value='${ model.companydepartment.CPD_FAX }' />"  /><br/>
		cpdlevel<input name="r_cpdlevel" placeholder="레벨" type="text" value="<c:out value='${ model.companydepartment.CPD_LEVEL }' />"  /><br/>
		cpdtype<input name="r_cpdtype" placeholder="타입 N=일반" type="text" value="<c:out value='${ model.companydepartment.CPD_TYPE }' />"  /><br/>
		cpduse<input name="r_cpduse" placeholder="승인여부" type="text" value="<c:out value='${ model.companydepartment.CPD_USE }' />"  /><br/>
		cpdmoid<input name="r_cpdmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_MOID }' />"  /><br/>
		cpdinid<input name="r_cpdinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_INID }' />"  /><br/>
<!--		<input name="r_cpdmodate" placeholder="수정일" type="text" value="${ fn:substring( model.companydepartment.CPD_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_cpdindate" placeholder="등록일" type="text" value="${ fn:substring( model.companydepartment.CPD_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>