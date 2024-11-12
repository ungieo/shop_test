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

	function dataEdit(){
		handling.submit( '', 'companydepartmentedit' );
	}

	function dataDel(){
		handling.submit( '', 'companydepartmentdel' );
	}

	function dataDown(){
		handling.submit( '', 'companydepartmentdown' );
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
		handling.submit( fName, url );
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

	<form action="companydepartmentin" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>companydepartmentadd</legend>
			<p>
				<label for="r_cpdseq">고유번호</label>
				<input id="r_cpdseq" name="r_cpdseq" placeholder="고유번호" type="text" value="<c:out value='${ model.companydepartment.CPD_SEQ }' />" required />
			</p>
			<p>
				<label for="r_cpdcpid">회사아이디</label>
				<input id="r_cpdcpid" name="r_cpdcpid" placeholder="회사아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_CPID }' />" required />
			</p>
			<p>
				<label for="r_cpdid">부서아이디</label>
				<input id="r_cpdid" name="r_cpdid" placeholder="부서아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_ID }' />" />
			</p>
			<p>
				<label for="r_cpdname">부서명</label>
				<input id="r_cpdname" name="r_cpdname" placeholder="부서명" type="text" value="<c:out value='${ model.companydepartment.CPD_NAME }' />" required />
			</p>
			<p>
				<label for="r_cpdpaytype">결제타입</label>
				<input id="r_cpdpaytype" name="r_cpdpaytype" placeholder="결제타입" type="text" value="<c:out value='${ model.companydepartment.CPD_PAYTYPE }' />" />
			</p>
			<p>
				<label for="r_cpdemail">이메일</label>
				<input id="r_cpdemail" name="r_cpdemail" placeholder="이메일" type="text" value="<c:out value='${ model.companydepartment.CPD_EMAIL }' />" />
			</p>
			<p>
				<label for="r_cpdtel">전화</label>
				<input id="r_cpdtel" name="r_cpdtel" placeholder="전화" type="text" value="<c:out value='${ model.companydepartment.CPD_TEL }' />" />
			</p>
			<p>
				<label for="r_cpdphone">휴대전화</label>
				<input id="r_cpdphone" name="r_cpdphone" placeholder="휴대전화" type="text" value="<c:out value='${ model.companydepartment.CPD_PHONE }' />" />
			</p>
			<p>
				<label for="r_cpdfax">팩스</label>
				<input id="r_cpdfax" name="r_cpdfax" placeholder="팩스" type="text" value="<c:out value='${ model.companydepartment.CPD_FAX }' />" />
			</p>
			<p>
				<label for="r_cpdlevel">레벨</label>
				<input id="r_cpdlevel" name="r_cpdlevel" placeholder="레벨" type="text" value="<c:out value='${ model.companydepartment.CPD_LEVEL }' />" />
			</p>
			<p>
				<label for="r_cpdtype">타입 N=일반</label>
				<input id="r_cpdtype" name="r_cpdtype" placeholder="타입 N=일반" type="text" value="<c:out value='${ model.companydepartment.CPD_TYPE }' />" />
			</p>
			<p>
				<label for="r_cpduse">승인여부</label>
				<input id="r_cpduse" name="r_cpduse" placeholder="승인여부" type="text" value="<c:out value='${ model.companydepartment.CPD_USE }' />" />
			</p>
			<p>
				<label for="r_cpdmoid">수정아이디</label>
				<input id="r_cpdmoid" name="r_cpdmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_MOID }' />" />
			</p>
			<p>
				<label for="r_cpdinid">등록아이디</label>
				<input id="r_cpdinid" name="r_cpdinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_INID }' />" />
			</p>
			<!--<p>
				<label for="r_cpdmodate">수정일</label>
				<input id="r_cpdmodate" name="r_cpdmodate" placeholder="수정일"  type="text" "${ fn:substring( model.companydepartment.CPD_MODATE, 0, 16 ) }" required />
			</p>-->
			<!--<p>
				<label for="r_cpdindate">등록일</label>
				<input id="r_cpdindate" name="r_cpdindate" placeholder="등록일"  type="text" "${ fn:substring( model.companydepartment.CPD_INDATE, 0, 16 ) }" required />
			</p>-->
		</fieldset>
		<a href="#" onclick="dataIn()">저장</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>