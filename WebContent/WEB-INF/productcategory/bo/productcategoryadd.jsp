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
		handling.submit( '', 'productcategoryadd' );
	}

	function dataEdit(){
		handling.submit( '', 'productcategoryedit' );
	}

	function dataDel(){
		handling.submit( '', 'productcategorydel' );
	}

	function dataDown(){
		handling.submit( '', 'productcategorydown' );
	}

	function dataIn(){
		handling.submit( '', 'productcategoryin' );
	}

	function dataView(){
		handling.submit( '', 'productcategoryview' );
	}

	function dataList(){
		handling.submit( '', 'productcategorylist' );
	}

	function dataSort(){
		handling.submit( '', 'productcategorylist' );
	}

	function dataUp(){
		handling.submit( '', 'productcategoryup' );
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

	<form action="productcategoryin" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>productcategoryadd</legend>
			<p>
				<label for="r_prcseq">고유값</label>
				<input id="r_prcseq" name="r_prcseq" placeholder="고유값" type="text" value="<c:out value='${ model.productcategory.PRC_SEQ }' />" required />
			</p>
			<p>
				<label for="r_prccode">카테고리코드</label>
				<input id="r_prccode" name="r_prccode" placeholder="카테고리코드" type="text" value="<c:out value='${ model.productcategory.PRC_CODE }' />" />
			</p>
			<p>
				<label for="r_prcpid">부모코드</label>
				<input id="r_prcpid" name="r_prcpid" placeholder="부모코드" type="text" value="<c:out value='${ model.productcategory.PRC_PID }' />" required />
			</p>
			<p>
				<label for="r_prcname">카테고리명</label>
				<input id="r_prcname" name="r_prcname" placeholder="카테고리명" type="text" value="<c:out value='${ model.productcategory.PRC_NAME }' />" required />
			</p>
			<p>
				<label for="r_prcstep">순서</label>
				<input id="r_prcstep" name="r_prcstep" placeholder="순서" type="text" value="<c:out value='${ model.productcategory.PRC_STEP }' />" required />
			</p>
			<p>
				<label for="r_prctitleimage">타이틀이미지</label>
				<input id="r_prctitleimage" name="r_prctitleimage" placeholder="타이틀이미지" type="text" value="<c:out value='${ model.productcategory.PRC_TITLEIMAGE }' />" />
			</p>
			<p>
				<label for="r_prcgnum1"></label>
				<input id="r_prcgnum1" name="r_prcgnum1" placeholder="" type="text" value="<c:out value='${ model.productcategory.PRC_GNUM1 }' />" required />
			</p>
			<p>
				<label for="r_prcgnum2"></label>
				<input id="r_prcgnum2" name="r_prcgnum2" placeholder="" type="text" value="<c:out value='${ model.productcategory.PRC_GNUM2 }' />" required />
			</p>
			<p>
				<label for="r_prcgnum3"></label>
				<input id="r_prcgnum3" name="r_prcgnum3" placeholder="" type="text" value="<c:out value='${ model.productcategory.PRC_GNUM3 }' />" required />
			</p>
			<p>
				<label for="r_prclevel">레벨</label>
				<input id="r_prclevel" name="r_prclevel" placeholder="레벨" type="text" value="<c:out value='${ model.productcategory.PRC_LEVEL }' />" required />
			</p>
			<p>
				<label for="r_prctype">타입</label>
				<input id="r_prctype" name="r_prctype" placeholder="타입" type="text" value="<c:out value='${ model.productcategory.PRC_TYPE }' />" />
			</p>
			<p>
				<label for="r_prcuse">사용여부</label>
				<input id="r_prcuse" name="r_prcuse" placeholder="사용여부" type="text" value="<c:out value='${ model.productcategory.PRC_USE }' />" required />
			</p>
			<p>
				<label for="r_prcmoid">수정아이디</label>
				<input id="r_prcmoid" name="r_prcmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.productcategory.PRC_MOID }' />" required />
			</p>
			<p>
				<label for="r_prcinid">등록아이디</label>
				<input id="r_prcinid" name="r_prcinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.productcategory.PRC_INID }' />" required />
			</p>
			<!--<p>
				<label for="r_prcmodate">수정일</label>
				<input id="r_prcmodate" name="r_prcmodate" placeholder="수정일"  type="text" "${ fn:substring( model.productcategory.PRC_MODATE, 0, 16 ) }" required />
			</p>-->
			<!--<p>
				<label for="r_prcindate">등록일</label>
				<input id="r_prcindate" name="r_prcindate" placeholder="등록일"  type="text" "${ fn:substring( model.productcategory.PRC_INDATE, 0, 16 ) }" required />
			</p>-->
		</fieldset>
		<a href="#" onclick="dataIn()">저장</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>