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
//		//alert('onload');
	});

	function dataAjax(){
	var param = '';

		$.ajax({
			async : false,
			data : param,
			error : function(){
				alert( '처리 중 오류가 발생되었습니다.' );
				errorCnt += 1;
				checkYn = 'N';
				return false;
			},
			success : function( data ){
			},
			type : 'POST',
			url : '${cpath}/'
		});
	}

	function dataAdd(){
		handling.submit( '', 'boardarticleadd' );
	}

	function dataDel(){
		handling.submit( '', 'boardarticledel' );
	}

	function dataEdit(){
		handling.submit( '', 'boardarticleedit' );
	}

	function dataIn(){
		handling.submit( '', 'boardarticlein' );
	}

	function dataView(){
		handling.submit( '', 'boardarticleview' );
	}

	function dataList(){
		handling.submit( '', 'boardarticlelist' );
	}

	function dataSort(){
		handling.submit( '', 'boardarticlelist' );
	}

	function dataUp(){
		handling.submit( '', 'boardarticleup' );
	}

	function formSubmit( fName, url ){
		handling.submit( '', url );
	}

	function pager( fName, url ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( fName, url );
	}

	function pageMove( fName, url ){
		handling.pageMove(url,param);
	}

</script>
</head>
<body>

	<%@ include file="/include/jsp/header.jsp" %>

	<form action="boardarticlein.do" method="post" name="frm">

		bdaseq<input name="r_bdaseq" type="text" value=""  /><br/>
		bdabdid<input name="r_bdabdid" type="text" value=""  /><br/>
		bdabdcseq<input name="r_bdabdcseq" type="text" value=""  /><br/>
		bdafile1<input name="r_bdafile1" type="text" value=""  /><br/>
		bdafile2<input name="r_bdafile2" type="text" value=""  /><br/>
		bdagroupnum<input name="r_bdagroupnum" type="text" value=""  /><br/>
		bdalevelnum<input name="r_bdalevelnum" type="text" value=""  /><br/>
		bdastepnum<input name="r_bdastepnum" type="text" value=""  /><br/>
		bdambid<input name="r_bdambid" type="text" value=""  /><br/>
		bdaname<input name="r_bdaname" type="text" value=""  /><br/>
		bdaownername<input name="r_bdaownername" type="text" value=""  /><br/>
		bdapswd<input name="r_bdapswd" type="text" value=""  /><br/>
		bdareadcnt<input name="r_bdareadcnt" type="text" value=""  /><br/>
		bdarecommendcnt<input name="r_bdarecommendcnt" type="text" value=""  /><br/>
		bdastatus<input name="r_bdastatus" type="text" value=""  /><br/>
		bdalevel<input name="r_bdalevel" type="text" value=""  /><br/>
		bdatype<input name="r_bdatype" type="text" value=""  /><br/>
		bdause<input name="r_bdause" type="text" value=""  /><br/>
		bdamoid<input name="r_bdamoid" type="text" value=""  /><br/>
		bdainid<input name="r_bdainid" type="text" value=""  /><br/>
<!--		<input name="r_bdamodate" type="text" value=""  />--><br/>
<!--		<input name="r_bdaindate" type="text" value=""  />--><br/>

	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>