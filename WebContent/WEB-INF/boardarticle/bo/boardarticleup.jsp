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

	function dataDown(){
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

	function pageMove(  ){
		handling.pageMove(url,param);
	}

</script>
</head>
<body>

	<div class="container">

	<%@ include file="/include/jsp/header.jsp" %>

	<form action="boardarticlein" method="post" id="frm" name="frm">

		bdaseq<input name="r_bdaseq" placeholder="아이디" type="text" value="${ model.boardarticle.BDA_SEQ }"  /><br/>
		bdabdid<input name="r_bdabdid" placeholder="게시판아이디" type="text" value="${ model.boardarticle.BDA_BDID }"  /><br/>
		bdabdcseq<input name="r_bdabdcseq" placeholder="게시글분류" type="text" value="${ model.boardarticle.BDA_BDCSEQ }"  /><br/>
		bdacontent<input name="r_bdacontent" placeholder="내용" type="text" value="${ model.boardarticle.BDA_CONTENT }"  /><br/>
		bdafilenum<input name="r_bdafilenum" placeholder="파일개수" type="text" value="${ model.boardarticle.BDA_FILENUM }"  /><br/>
		bdagroupnum<input name="r_bdagroupnum" placeholder="그룹번호" type="text" value="${ model.boardarticle.BDA_GROUPNUM }"  /><br/>
		bdalevelnum<input name="r_bdalevelnum" placeholder="레벨번호" type="text" value="${ model.boardarticle.BDA_LEVELNUM }"  /><br/>
		bdastepnum<input name="r_bdastepnum" placeholder="스텝번호" type="text" value="${ model.boardarticle.BDA_STEPNUM }"  /><br/>
		bdambid<input name="r_bdambid" placeholder="작성자아이디" type="text" value="${ model.boardarticle.BDA_MBID }"  /><br/>
		bdaname<input name="r_bdaname" placeholder="제목" type="text" value="${ model.boardarticle.BDA_NAME }"  /><br/>
		bdaownername<input name="r_bdaownername" placeholder="작성자명" type="text" value="${ model.boardarticle.BDA_OWNERNAME }"  /><br/>
		bdapswd<input name="r_bdapswd" placeholder="비밀문자" type="text" value="${ model.boardarticle.BDA_PSWD }"  /><br/>
		bdareadcnt<input name="r_bdareadcnt" placeholder="조회수" type="text" value="${ model.boardarticle.BDA_READCNT }"  /><br/>
		bdarecommendcnt<input name="r_bdarecommendcnt" placeholder="추천수" type="text" value="${ model.boardarticle.BDA_RECOMMENDCNT }"  /><br/>
		bdastatus<input name="r_bdastatus" placeholder="상태값" type="text" value="${ model.boardarticle.BDA_STATUS }"  /><br/>
		bdalevel<input name="r_bdalevel" placeholder="레벨" type="text" value="${ model.boardarticle.BDA_LEVEL }"  /><br/>
		bdatype<input name="r_bdatype" placeholder="타입" type="text" value="${ model.boardarticle.BDA_TYPE }"  /><br/>
		bdause<input name="r_bdause" placeholder="사용여부" type="text" value="${ model.boardarticle.BDA_USE }"  /><br/>
		bdamoid<input name="r_bdamoid" placeholder="수정아이디" type="text" value="${ model.boardarticle.BDA_MOID }"  /><br/>
		bdainid<input name="r_bdainid" placeholder="등록아이디" type="text" value="${ model.boardarticle.BDA_INID }"  /><br/>
<!--		<input name="r_bdamodate" placeholder="수정일" type="text" value="${ fn:substring( model.boardarticle.BDA_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_bdaindate" placeholder="등록일" type="text" value="${ fn:substring( model.boardarticle.BDA_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

	</div>

</body>
</html>