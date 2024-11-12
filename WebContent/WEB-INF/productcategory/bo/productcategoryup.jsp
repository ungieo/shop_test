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

	function dataDel(){
		handling.submit( '', 'productcategorydel' );
	}

	function dataDown(){
		handling.submit( '', 'productcategorydown' );
	}

	function dataEdit(){
		handling.submit( '', 'productcategoryedit' );
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

	<form action="productcategoryin" method="post" id="frm" name="frm">

		prcseq<input name="r_prcseq" placeholder="고유값" type="text" value="<c:out value='${ model.productcategory.PRC_SEQ }' />"  /><br/>
		prccode<input name="r_prccode" placeholder="카테고리코드" type="text" value="<c:out value='${ model.productcategory.PRC_CODE }' />"  /><br/>
		prcpid<input name="r_prcpid" placeholder="부모코드" type="text" value="<c:out value='${ model.productcategory.PRC_PID }' />"  /><br/>
		prcname<input name="r_prcname" placeholder="카테고리명" type="text" value="<c:out value='${ model.productcategory.PRC_NAME }' />"  /><br/>
		prcstep<input name="r_prcstep" placeholder="순서" type="text" value="<c:out value='${ model.productcategory.PRC_STEP }' />"  /><br/>
		prctitleimage<input name="r_prctitleimage" placeholder="타이틀이미지" type="text" value="<c:out value='${ model.productcategory.PRC_TITLEIMAGE }' />"  /><br/>
		prcgnum1<input name="r_prcgnum1" placeholder="" type="text" value="<c:out value='${ model.productcategory.PRC_GNUM1 }' />"  /><br/>
		prcgnum2<input name="r_prcgnum2" placeholder="" type="text" value="<c:out value='${ model.productcategory.PRC_GNUM2 }' />"  /><br/>
		prcgnum3<input name="r_prcgnum3" placeholder="" type="text" value="<c:out value='${ model.productcategory.PRC_GNUM3 }' />"  /><br/>
		prclevel<input name="r_prclevel" placeholder="레벨" type="text" value="<c:out value='${ model.productcategory.PRC_LEVEL }' />"  /><br/>
		prctype<input name="r_prctype" placeholder="타입" type="text" value="<c:out value='${ model.productcategory.PRC_TYPE }' />"  /><br/>
		prcuse<input name="r_prcuse" placeholder="사용여부" type="text" value="<c:out value='${ model.productcategory.PRC_USE }' />"  /><br/>
		prcmoid<input name="r_prcmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.productcategory.PRC_MOID }' />"  /><br/>
		prcinid<input name="r_prcinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.productcategory.PRC_INID }' />"  /><br/>
<!--		<input name="r_prcmodate" placeholder="수정일" type="text" value="${ fn:substring( model.productcategory.PRC_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_prcindate" placeholder="등록일" type="text" value="${ fn:substring( model.productcategory.PRC_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>