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

	function pageMove( fName, url ){
		handling.pageMove(url,param);
	}

</script>
</head>
<body>

	<%@ include file="/include/jsp/header.jsp" %>

	<form action="boardarticlein" method="post" name="frm">

		<fieldset>
			<legend>boardarticlein</legend>
			<p>
				<label for="r_bdaseq">아이디</label>
				<input name="r_bdaseq" type="text" value="${ model.boardarticle.BDA_SEQ }" required />
			</p>
			<p>
				<label for="r_bdabdid">게시판아이디</label>
				<input name="r_bdabdid" type="text" value="${ model.boardarticle.BDA_BDID }" required />
			</p>
			<p>
				<label for="r_bdabdcseq">게시글분류</label>
				<input name="r_bdabdcseq" type="text" value="${ model.boardarticle.BDA_BDCSEQ }" />
			</p>
			<p>
				<label for="r_bdacontent">내용</label>
				<input name="r_bdacontent" type="text" value="${ model.boardarticle.BDA_CONTENT }" />
			</p>
			<p>
				<label for="r_bdafilenum">파일개수</label>
				<input name="r_bdafilenum" type="text" value="${ model.boardarticle.BDA_FILENUM }" />
			</p>
			<p>
				<label for="r_bdagroupnum">그룹번호</label>
				<input name="r_bdagroupnum" type="text" value="${ model.boardarticle.BDA_GROUPNUM }" />
			</p>
			<p>
				<label for="r_bdalevelnum">레벨번호</label>
				<input name="r_bdalevelnum" type="text" value="${ model.boardarticle.BDA_LEVELNUM }" />
			</p>
			<p>
				<label for="r_bdastepnum">스텝번호</label>
				<input name="r_bdastepnum" type="text" value="${ model.boardarticle.BDA_STEPNUM }" />
			</p>
			<p>
				<label for="r_bdambid">작성자아이디</label>
				<input name="r_bdambid" type="text" value="${ model.boardarticle.BDA_MBID }" />
			</p>
			<p>
				<label for="r_bdaname">제목</label>
				<input name="r_bdaname" type="text" value="${ model.boardarticle.BDA_NAME }" />
			</p>
			<p>
				<label for="r_bdaownername">작성자명</label>
				<input name="r_bdaownername" type="text" value="${ model.boardarticle.BDA_OWNERNAME }" />
			</p>
			<p>
				<label for="r_bdapswd">비밀문자</label>
				<input name="r_bdapswd" type="text" value="${ model.boardarticle.BDA_PSWD }" />
			</p>
			<p>
				<label for="r_bdareadcnt">조회수</label>
				<input name="r_bdareadcnt" type="text" value="${ model.boardarticle.BDA_READCNT }" />
			</p>
			<p>
				<label for="r_bdarecommendcnt">추천수</label>
				<input name="r_bdarecommendcnt" type="text" value="${ model.boardarticle.BDA_RECOMMENDCNT }" />
			</p>
			<p>
				<label for="r_bdastatus">상태값</label>
				<input name="r_bdastatus" type="text" value="${ model.boardarticle.BDA_STATUS }" />
			</p>
			<p>
				<label for="r_bdalevel">레벨</label>
				<input name="r_bdalevel" type="text" value="${ model.boardarticle.BDA_LEVEL }" />
			</p>
			<p>
				<label for="r_bdatype">타입</label>
				<input name="r_bdatype" type="text" value="${ model.boardarticle.BDA_TYPE }" />
			</p>
			<p>
				<label for="r_bdause">사용여부</label>
				<input name="r_bdause" type="text" value="${ model.boardarticle.BDA_USE }" />
			</p>
			<p>
				<label for="r_bdamoid">수정아이디</label>
				<input name="r_bdamoid" type="text" value="${ model.boardarticle.BDA_MOID }" />
			</p>
			<p>
				<label for="r_bdainid">등록아이디</label>
				<input name="r_bdainid" type="text" value="${ model.boardarticle.BDA_INID }" />
			</p>
			<!--<p>
				<label for="r_bdamodate">수정일</label>
				<input name="r_bdamodate" type="text" "${ fn:substring( model.boardarticle.BDA_MODATE, 0, 16 ) }" required />
			</p>-->
			<!--<p>
				<label for="r_bdaindate">등록일</label>
				<input name="r_bdaindate" type="text" "${ fn:substring( model.boardarticle.BDA_INDATE, 0, 16 ) }" required />
			</p>-->

		<a href="#" onclick="dataList()">리스트</a><br/>
	</form>
	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>