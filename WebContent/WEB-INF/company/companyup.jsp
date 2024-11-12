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

	<form action="companyin" method="post" id="frm" name="frm">

		cpseq<input name="r_cpseq" placeholder="고유번호" type="text" value="<c:out value='${ model.company.CP_SEQ }' />"  /><br/>
		cpid<input name="r_cpid" placeholder="회사아이디" type="text" value="<c:out value='${ model.company.CP_ID }' />"  /><br/>
		cpname<input name="r_cpname" placeholder="회사명" type="text" value="<c:out value='${ model.company.CP_NAME }' />"  /><br/>
		cpbiznum<input name="r_cpbiznum" placeholder="사업자번호" type="text" value="<c:out value='${ model.company.CP_BIZNUM }' />"  /><br/>
		cpuptai<input name="r_cpuptai" placeholder="업태" type="text" value="<c:out value='${ model.company.CP_UPTAI }' />"  /><br/>
		cpupjong<input name="r_cpupjong" placeholder="업종" type="text" value="<c:out value='${ model.company.CP_UPJONG }' />"  /><br/>
		cpceoname<input name="r_cpceoname" placeholder="대표명" type="text" value="<c:out value='${ model.company.CP_CEONAME }' />"  /><br/>
		cpzipcode<input name="r_cpzipcode" placeholder="우편번호" type="text" value="<c:out value='${ model.company.CP_ZIPCODE }' />"  /><br/>
		cpaddr1<input name="r_cpaddr1" placeholder="기본주소" type="text" value="<c:out value='${ model.company.CP_ADDR1 }' />"  /><br/>
		cpaddr2<input name="r_cpaddr2" placeholder="상세주소" type="text" value="<c:out value='${ model.company.CP_ADDR2 }' />"  /><br/>
		cpfile<input name="r_cpfile" placeholder="파일" type="text" value="<c:out value='${ model.company.CP_FILE }' />"  /><br/>
		cpdeliverymoney<input name="r_cpdeliverymoney" placeholder="배송비" type="text" value="<c:out value='${ model.company.CP_DELIVERYMONEY }' />"  /><br/>
		cppaytype<input name="r_cppaytype" placeholder="결제타입" type="text" value="<c:out value='${ model.company.CP_PAYTYPE }' />"  /><br/>
		cpbiztype<input name="r_cpbiztype" placeholder="회사타입" type="text" value="<c:out value='${ model.company.CP_BIZTYPE }' />"  /><br/>
		cptongsinbiznum<input name="r_cptongsinbiznum" placeholder="통신사업자" type="text" value="<c:out value='${ model.company.CP_TONGSINBIZNUM }' />"  /><br/>
		cpemail<input name="r_cpemail" placeholder="이메일" type="text" value="<c:out value='${ model.company.CP_EMAIL }' />"  /><br/>
		cptel<input name="r_cptel" placeholder="전화" type="text" value="<c:out value='${ model.company.CP_TEL }' />"  /><br/>
		cpphone<input name="r_cpphone" placeholder="휴대전화" type="text" value="<c:out value='${ model.company.CP_PHONE }' />"  /><br/>
		cpfax<input name="r_cpfax" placeholder="팩스" type="text" value="<c:out value='${ model.company.CP_FAX }' />"  /><br/>
		cplevel<input name="r_cplevel" placeholder="레벨" type="text" value="<c:out value='${ model.company.CP_LEVEL }' />"  /><br/>
		cptype<input name="r_cptype" placeholder="타입" type="text" value="<c:out value='${ model.company.CP_TYPE }' />"  /><br/>
		cpuse<input name="r_cpuse" placeholder="사용여부" type="text" value="<c:out value='${ model.company.CP_USE }' />"  /><br/>
		cpmoid<input name="r_cpmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.company.CP_MOID }' />"  /><br/>
		cpinid<input name="r_cpinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.company.CP_INID }' />"  /><br/>
<!--		<input name="r_cpmodate" placeholder="수정일" type="text" value="${ fn:substring( model.company.CP_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_cpindate" placeholder="등록일" type="text" value="${ fn:substring( model.company.CP_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>