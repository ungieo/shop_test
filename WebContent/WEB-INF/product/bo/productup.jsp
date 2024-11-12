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

	function dataDel(){
		handling.submit( '', 'productdel' );
	}

	function dataDown(){
		handling.submit( '', 'productdown' );
	}

	function dataEdit(){
		handling.submit( '', 'productedit' );
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

	<form action="productin" method="post" id="frm" name="frm">

		prseq<input name="r_prseq" placeholder="고유번호" type="text" value="<c:out value='${ model.product.PR_SEQ }' />"  /><br/>
		prprcseq<input name="r_prprcseq" placeholder="상품카테고리" type="text" value="<c:out value='${ model.product.PR_PRCSEQ }' />"  /><br/>
		prcode<input name="r_prcode" placeholder="상품코드" type="text" value="<c:out value='${ model.product.PR_CODE }' />"  /><br/>
		prcodeb<input name="r_prcodeb" placeholder="구매사상품코드" type="text" value="<c:out value='${ model.product.PR_CODEB }' />"  /><br/>
		prcodes<input name="r_prcodes" placeholder="공급사상품코드" type="text" value="<c:out value='${ model.product.PR_CODES }' />"  /><br/>
		prname<input name="r_prname" placeholder="상품명" type="text" value="<c:out value='${ model.product.PR_NAME }' />"  /><br/>
		prprice<input name="r_prprice" placeholder="상품가격" type="text" value="<c:out value='${ model.product.PR_PRICE }' />"  /><br/>
		prfilenum<input name="r_prfilenum" placeholder="파일개수" type="text" value="<c:out value='${ model.product.PR_FILENUM }' />"  /><br/>
		prcpids<input name="r_prcpids" placeholder="공급사아이디" type="text" value="<c:out value='${ model.product.PR_CPIDS }' />"  /><br/>
		prcpidb<input name="r_prcpidb" placeholder="구매사아이디" type="text" value="<c:out value='${ model.product.PR_CPIDB }' />"  /><br/>
		prbarcode<input name="r_prbarcode" placeholder="바코드" type="text" value="<c:out value='${ model.product.PR_BARCODE }' />"  /><br/>
		prvatuse<input name="r_prvatuse" placeholder="부가세여부" type="text" value="<c:out value='${ model.product.PR_VATUSE }' />"  /><br/>
		prsavemoney<input name="r_prsavemoney" placeholder="적립금" type="text" value="<c:out value='${ model.product.PR_SAVEMONEY }' />"  /><br/>
		prstandard<input name="r_prstandard" placeholder="규격" type="text" value="<c:out value='${ model.product.PR_STANDARD }' />"  /><br/>
		prbrseq<input name="r_prbrseq" placeholder="브랜드고유값" type="text" value="<c:out value='${ model.product.PR_BRSEQ }' />"  /><br/>
		prmodel<input name="r_prmodel" placeholder="모델" type="text" value="<c:out value='${ model.product.PR_MODEL }' />"  /><br/>
		prunit<input name="r_prunit" placeholder="단위" type="text" value="<c:out value='${ model.product.PR_UNIT }' />"  /><br/>
		prmanufacture<input name="r_prmanufacture" placeholder="제조사" type="text" value="<c:out value='${ model.product.PR_MANUFACTURE }' />"  /><br/>
		prcountry<input name="r_prcountry" placeholder="원산지" type="text" value="<c:out value='${ model.product.PR_COUNTRY }' />"  /><br/>
		prminbuyea<input name="r_prminbuyea" placeholder="최소구매수량" type="text" value="<c:out value='${ model.product.PR_MINBUYEA }' />"  /><br/>
		prstock<input name="r_prstock" placeholder="재고" type="text" value="<c:out value='${ model.product.PR_STOCK }' />"  /><br/>
		prweight<input name="r_prweight" placeholder="무게" type="text" value="<c:out value='${ model.product.PR_WEIGHT }' />"  /><br/>
		prcontent<input name="r_prcontent" placeholder="내용" type="text" value="<c:out value='${ model.product.PR_CONTENT }' />"  /><br/>
		prdeliterm<input name="r_prdeliterm" placeholder="배송소요일" type="text" value="<c:out value='${ model.product.PR_DELITERM }' />"  /><br/>
		prdelipolicy<input name="r_prdelipolicy" placeholder="배송정책" type="text" value="<c:out value='${ model.product.PR_DELIPOLICY }' />"  /><br/>
		prstatus<input name="r_prstatus" placeholder="상품상태" type="text" value="<c:out value='${ model.product.PR_STATUS }' />"  /><br/>
		prlevel<input name="r_prlevel" placeholder="레벨" type="text" value="<c:out value='${ model.product.PR_LEVEL }' />"  /><br/>
		prtype<input name="r_prtype" placeholder="타입" type="text" value="<c:out value='${ model.product.PR_TYPE }' />"  /><br/>
		pruse<input name="r_pruse" placeholder="사용여부" type="text" value="<c:out value='${ model.product.PR_USE }' />"  /><br/>
		prmoid<input name="r_prmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.product.PR_MOID }' />"  /><br/>
		prinid<input name="r_prinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.product.PR_INID }' />"  /><br/>
<!--		<input name="r_prmodate" placeholder="수정일" type="text" value="${ fn:substring( model.product.PR_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_prindate" placeholder="등록일" type="text" value="${ fn:substring( model.product.PR_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>