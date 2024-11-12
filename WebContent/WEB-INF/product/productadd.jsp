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
		handling.submit( '', 'productadd' );
	}

	function dataEdit(){
		handling.submit( '', 'productedit' );
	}

	function dataDel(){
		handling.submit( '', 'productdel' );
	}

	function dataDown(){
		handling.submit( '', 'productdown' );
	}

	function dataIn(){
		handling.submit( '', 'productin' );
	}

	function dataView(){
		handling.submit( '', 'productview' );
	}

	function dataList(){
		handling.submit( '', 'productlist' );
	}

	function dataSort(){
		handling.submit( '', 'productlist' );
	}

	function dataUp(){
		handling.submit( '', 'productup' );
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

	<form action="productin" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>productadd</legend>
			<p>
				<label for="r_prseq">고유번호</label>
				<input id="r_prseq" name="r_prseq" placeholder="고유번호" type="text" value="<c:out value='${ model.product.PR_SEQ }' />" required />
			</p>
			<p>
				<label for="r_prprcseq">상품카테고리</label>
				<input id="r_prprcseq" name="r_prprcseq" placeholder="상품카테고리" type="text" value="<c:out value='${ model.product.PR_PRCSEQ }' />" required />
			</p>
			<p>
				<label for="r_prcode">상품코드</label>
				<input id="r_prcode" name="r_prcode" placeholder="상품코드" type="text" value="<c:out value='${ model.product.PR_CODE }' />" />
			</p>
			<p>
				<label for="r_prcodeb">구매사상품코드</label>
				<input id="r_prcodeb" name="r_prcodeb" placeholder="구매사상품코드" type="text" value="<c:out value='${ model.product.PR_CODEB }' />" />
			</p>
			<p>
				<label for="r_prcodes">공급사상품코드</label>
				<input id="r_prcodes" name="r_prcodes" placeholder="공급사상품코드" type="text" value="<c:out value='${ model.product.PR_CODES }' />" />
			</p>
			<p>
				<label for="r_prname">상품명</label>
				<input id="r_prname" name="r_prname" placeholder="상품명" type="text" value="<c:out value='${ model.product.PR_NAME }' />" required />
			</p>
			<p>
				<label for="r_prprice">상품가격</label>
				<input id="r_prprice" name="r_prprice" placeholder="상품가격" type="text" value="<c:out value='${ model.product.PR_PRICE }' />" required />
			</p>
			<p>
				<label for="r_prfilenum">파일개수</label>
				<input id="r_prfilenum" name="r_prfilenum" placeholder="파일개수" type="text" value="<c:out value='${ model.product.PR_FILENUM }' />" required />
			</p>
			<p>
				<label for="r_prcpids">공급사아이디</label>
				<input id="r_prcpids" name="r_prcpids" placeholder="공급사아이디" type="text" value="<c:out value='${ model.product.PR_CPIDS }' />" />
			</p>
			<p>
				<label for="r_prcpidb">구매사아이디</label>
				<input id="r_prcpidb" name="r_prcpidb" placeholder="구매사아이디" type="text" value="<c:out value='${ model.product.PR_CPIDB }' />" />
			</p>
			<p>
				<label for="r_prbarcode">바코드</label>
				<input id="r_prbarcode" name="r_prbarcode" placeholder="바코드" type="text" value="<c:out value='${ model.product.PR_BARCODE }' />" />
			</p>
			<p>
				<label for="r_prvatuse">부가세여부</label>
				<input id="r_prvatuse" name="r_prvatuse" placeholder="부가세여부" type="text" value="<c:out value='${ model.product.PR_VATUSE }' />" required />
			</p>
			<p>
				<label for="r_prsavemoney">적립금</label>
				<input id="r_prsavemoney" name="r_prsavemoney" placeholder="적립금" type="text" value="<c:out value='${ model.product.PR_SAVEMONEY }' />" />
			</p>
			<p>
				<label for="r_prstandard">규격</label>
				<input id="r_prstandard" name="r_prstandard" placeholder="규격" type="text" value="<c:out value='${ model.product.PR_STANDARD }' />" />
			</p>
			<p>
				<label for="r_prbrseq">브랜드고유값</label>
				<input id="r_prbrseq" name="r_prbrseq" placeholder="브랜드고유값" type="text" value="<c:out value='${ model.product.PR_BRSEQ }' />" />
			</p>
			<p>
				<label for="r_prmodel">모델</label>
				<input id="r_prmodel" name="r_prmodel" placeholder="모델" type="text" value="<c:out value='${ model.product.PR_MODEL }' />" />
			</p>
			<p>
				<label for="r_prunit">단위</label>
				<input id="r_prunit" name="r_prunit" placeholder="단위" type="text" value="<c:out value='${ model.product.PR_UNIT }' />" />
			</p>
			<p>
				<label for="r_prmanufacture">제조사</label>
				<input id="r_prmanufacture" name="r_prmanufacture" placeholder="제조사" type="text" value="<c:out value='${ model.product.PR_MANUFACTURE }' />" />
			</p>
			<p>
				<label for="r_prcountry">원산지</label>
				<input id="r_prcountry" name="r_prcountry" placeholder="원산지" type="text" value="<c:out value='${ model.product.PR_COUNTRY }' />" />
			</p>
			<p>
				<label for="r_prminbuyea">최소구매수량</label>
				<input id="r_prminbuyea" name="r_prminbuyea" placeholder="최소구매수량" type="text" value="<c:out value='${ model.product.PR_MINBUYEA }' />" required />
			</p>
			<p>
				<label for="r_prstock">재고</label>
				<input id="r_prstock" name="r_prstock" placeholder="재고" type="text" value="<c:out value='${ model.product.PR_STOCK }' />" required />
			</p>
			<p>
				<label for="r_prweight">무게</label>
				<input id="r_prweight" name="r_prweight" placeholder="무게" type="text" value="<c:out value='${ model.product.PR_WEIGHT }' />" />
			</p>
			<p>
				<label for="r_prcontent">내용</label>
				<input id="r_prcontent" name="r_prcontent" placeholder="내용" type="text" value="<c:out value='${ model.product.PR_CONTENT }' />" required />
			</p>
			<p>
				<label for="r_prdeliterm">배송소요일</label>
				<input id="r_prdeliterm" name="r_prdeliterm" placeholder="배송소요일" type="text" value="<c:out value='${ model.product.PR_DELITERM }' />" />
			</p>
			<p>
				<label for="r_prdelipolicy">배송정책</label>
				<input id="r_prdelipolicy" name="r_prdelipolicy" placeholder="배송정책" type="text" value="<c:out value='${ model.product.PR_DELIPOLICY }' />" />
			</p>
			<p>
				<label for="r_prstatus">상품상태</label>
				<input id="r_prstatus" name="r_prstatus" placeholder="상품상태" type="text" value="<c:out value='${ model.product.PR_STATUS }' />" required />
			</p>
			<p>
				<label for="r_prlevel">레벨</label>
				<input id="r_prlevel" name="r_prlevel" placeholder="레벨" type="text" value="<c:out value='${ model.product.PR_LEVEL }' />" />
			</p>
			<p>
				<label for="r_prtype">타입</label>
				<input id="r_prtype" name="r_prtype" placeholder="타입" type="text" value="<c:out value='${ model.product.PR_TYPE }' />" />
			</p>
			<p>
				<label for="r_pruse">사용여부</label>
				<input id="r_pruse" name="r_pruse" placeholder="사용여부" type="text" value="<c:out value='${ model.product.PR_USE }' />" />
			</p>
			<p>
				<label for="r_prmoid">수정아이디</label>
				<input id="r_prmoid" name="r_prmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.product.PR_MOID }' />" />
			</p>
			<p>
				<label for="r_prinid">등록아이디</label>
				<input id="r_prinid" name="r_prinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.product.PR_INID }' />" />
			</p>
			<!--<p>
				<label for="r_prmodate">수정일</label>
				<input id="r_prmodate" name="r_prmodate" placeholder="수정일"  type="text" "${ fn:substring( model.product.PR_MODATE, 0, 16 ) }" required />
			</p>-->
			<!--<p>
				<label for="r_prindate">등록일</label>
				<input id="r_prindate" name="r_prindate" placeholder="등록일"  type="text" "${ fn:substring( model.product.PR_INDATE, 0, 16 ) }" required />
			</p>-->
		</fieldset>
		<a href="#" onclick="dataIn()">저장</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>