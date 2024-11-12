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

	<form action="companydel" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>companydel</legend>
			<p>
				<label for="r_cpseq">고유번호</label>
				<input id="r_cpseq" name="r_cpseq" placeholder="고유번호" type="text" value="" required />
			</p>
			<p>
				<label for="r_cpid">회사아이디</label>
				<input id="r_cpid" name="r_cpid" placeholder="회사아이디" type="text" value="" />
			</p>
			<p>
				<label for="r_cpname">회사명</label>
				<input id="r_cpname" name="r_cpname" placeholder="회사명" type="text" value="" required />
			</p>
			<p>
				<label for="r_cpbiznum">사업자번호</label>
				<input id="r_cpbiznum" name="r_cpbiznum" placeholder="사업자번호" type="text" value="" />
			</p>
			<p>
				<label for="r_cpuptai">업태</label>
				<input id="r_cpuptai" name="r_cpuptai" placeholder="업태" type="text" value="" />
			</p>
			<p>
				<label for="r_cpupjong">업종</label>
				<input id="r_cpupjong" name="r_cpupjong" placeholder="업종" type="text" value="" />
			</p>
			<p>
				<label for="r_cpceoname">대표명</label>
				<input id="r_cpceoname" name="r_cpceoname" placeholder="대표명" type="text" value="" />
			</p>
			<p>
				<label for="r_cpzipcode">우편번호</label>
				<input id="r_cpzipcode" name="r_cpzipcode" placeholder="우편번호" type="text" value="" />
			</p>
			<p>
				<label for="r_cpaddr1">기본주소</label>
				<input id="r_cpaddr1" name="r_cpaddr1" placeholder="기본주소" type="text" value="" />
			</p>
			<p>
				<label for="r_cpaddr2">상세주소</label>
				<input id="r_cpaddr2" name="r_cpaddr2" placeholder="상세주소" type="text" value="" />
			</p>
			<p>
				<label for="r_cpfile">파일</label>
				<input id="r_cpfile" name="r_cpfile" placeholder="파일" type="text" value="" />
			</p>
			<p>
				<label for="r_cpdeliverymoney">배송비</label>
				<input id="r_cpdeliverymoney" name="r_cpdeliverymoney" placeholder="배송비" type="text" value="" />
			</p>
			<p>
				<label for="r_cppaytype">결제타입</label>
				<input id="r_cppaytype" name="r_cppaytype" placeholder="결제타입" type="text" value="" />
			</p>
			<p>
				<label for="r_cpbiztype">회사타입</label>
				<input id="r_cpbiztype" name="r_cpbiztype" placeholder="회사타입" type="text" value="" />
			</p>
			<p>
				<label for="r_cptongsinbiznum">통신사업자</label>
				<input id="r_cptongsinbiznum" name="r_cptongsinbiznum" placeholder="통신사업자" type="text" value="" />
			</p>
			<p>
				<label for="r_cpemail">이메일</label>
				<input id="r_cpemail" name="r_cpemail" placeholder="이메일" type="text" value="" />
			</p>
			<p>
				<label for="r_cptel">전화</label>
				<input id="r_cptel" name="r_cptel" placeholder="전화" type="text" value="" />
			</p>
			<p>
				<label for="r_cpphone">휴대전화</label>
				<input id="r_cpphone" name="r_cpphone" placeholder="휴대전화" type="text" value="" />
			</p>
			<p>
				<label for="r_cpfax">팩스</label>
				<input id="r_cpfax" name="r_cpfax" placeholder="팩스" type="text" value="" />
			</p>
			<p>
				<label for="r_cplevel">레벨</label>
				<input id="r_cplevel" name="r_cplevel" placeholder="레벨" type="text" value="" />
			</p>
			<p>
				<label for="r_cptype">타입</label>
				<input id="r_cptype" name="r_cptype" placeholder="타입" type="text" value="" />
			</p>
			<p>
				<label for="r_cpuse">사용여부</label>
				<input id="r_cpuse" name="r_cpuse" placeholder="사용여부" type="text" value="" />
			</p>
			<p>
				<label for="r_cpmoid">수정아이디</label>
				<input id="r_cpmoid" name="r_cpmoid" placeholder="수정아이디" type="text" value="" />
			</p>
			<p>
				<label for="r_cpinid">등록아이디</label>
				<input id="r_cpinid" name="r_cpinid" placeholder="등록아이디" type="text" value="" />
			</p>
			<!--<p>
				<label for="r_cpmodate">수정일</label>
				<input id="r_cpmodate" name="r_cpmodate" placeholder="수정일" type="text" value="" required />
			</p>-->
			<!--<p>
				<label for="r_cpindate">등록일</label>
				<input id="r_cpindate" name="r_cpindate" placeholder="등록일" type="text" value="" required />
			</p>-->

		<a href="#" onclick="dataDel()">삭제</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>