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
		handling.submit( '', 'ordermainitemadd' );
	}

	function dataDel(){
		handling.submit( '', 'ordermainitemdel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainitemdown' );
	}

	function dataEdit(){
		handling.submit( '', 'ordermainitemedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainitemin' );
	}

	function dataView(){
		handling.submit( '', 'ordermainitemview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainitemlist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainitemlist' );
	}

	function dataUp(){
		handling.submit( '', 'ordermainitemup' );
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

	<form action="ordermainitemin" method="post" id="frm" name="frm">

		omiseq<input name="r_omiseq" placeholder="아이디" type="text" value="<c:out value='${ model.ordermainitem.OMI_SEQ }' />"  /><br/>
		omiomseq<input name="r_omiomseq" placeholder="주문번호" type="text" value="<c:out value='${ model.ordermainitem.OMI_OMSEQ }' />"  /><br/>
		omiprseq<input name="r_omiprseq" placeholder="상품고유번호" type="text" value="<c:out value='${ model.ordermainitem.OMI_PRSEQ }' />"  /><br/>
		omiproseq<input name="r_omiproseq" placeholder="상품옵션고유번호" type="text" value="<c:out value='${ model.ordermainitem.OMI_PROSEQ }' />"  /><br/>
		omipswd<input name="r_omipswd" placeholder="비밀문자" type="text" value="<c:out value='${ model.ordermainitem.OMI_PSWD }' />"  /><br/>
		omimbid<input name="r_omimbid" placeholder="주문자아이디" type="text" value="<c:out value='${ model.ordermainitem.OMI_MBID }' />"  /><br/>
		omimbname<input name="r_omimbname" placeholder="주문자명" type="text" value="<c:out value='${ model.ordermainitem.OMI_MBNAME }' />"  /><br/>
		omipaytype<input name="r_omipaytype" placeholder="결제타입" type="text" value="<c:out value='${ model.ordermainitem.OMI_PAYTYPE }' />"  /><br/>
		omiaccountmoney<input name="r_omiaccountmoney" placeholder="계좌이체" type="text" value="<c:out value='${ model.ordermainitem.OMI_ACCOUNTMONEY }' />"  /><br/>
		omicardmoney<input name="r_omicardmoney" placeholder="카드" type="text" value="<c:out value='${ model.ordermainitem.OMI_CARDMONEY }' />"  /><br/>
		omicouponmoney<input name="r_omicouponmoney" placeholder="쿠폰" type="text" value="<c:out value='${ model.ordermainitem.OMI_COUPONMONEY }' />"  /><br/>
		omilatermoney<input name="r_omilatermoney" placeholder="후불" type="text" value="<c:out value='${ model.ordermainitem.OMI_LATERMONEY }' />"  /><br/>
		omipointmoney<input name="r_omipointmoney" placeholder="포인트" type="text" value="<c:out value='${ model.ordermainitem.OMI_POINTMONEY }' />"  /><br/>
		omisavemoney<input name="r_omisavemoney" placeholder="적립금" type="text" value="<c:out value='${ model.ordermainitem.OMI_SAVEMONEY }' />"  /><br/>
		omivirtualaccountmoney<input name="r_omivirtualaccountmoney" placeholder="가상계좌" type="text" value="<c:out value='${ model.ordermainitem.OMI_VIRTUALACCOUNTMONEY }' />"  /><br/>
		omiraccountmoney<input name="r_omiraccountmoney" placeholder="잔여계좌이체" type="text" value="<c:out value='${ model.ordermainitem.OMI_RACCOUNTMONEY }' />"  /><br/>
		omircardmoney<input name="r_omircardmoney" placeholder="잔여카드" type="text" value="<c:out value='${ model.ordermainitem.OMI_RCARDMONEY }' />"  /><br/>
		omircouponmoney<input name="r_omircouponmoney" placeholder="잔여쿠폰" type="text" value="<c:out value='${ model.ordermainitem.OMI_RCOUPONMONEY }' />"  /><br/>
		omirlatermoney<input name="r_omirlatermoney" placeholder="잔여후불" type="text" value="<c:out value='${ model.ordermainitem.OMI_RLATERMONEY }' />"  /><br/>
		omirpointmoney<input name="r_omirpointmoney" placeholder="잔여포인트" type="text" value="<c:out value='${ model.ordermainitem.OMI_RPOINTMONEY }' />"  /><br/>
		omirsavemoney<input name="r_omirsavemoney" placeholder="잔여적립금" type="text" value="<c:out value='${ model.ordermainitem.OMI_RSAVEMONEY }' />"  /><br/>
		omirvirtualaccountmoney<input name="r_omirvirtualaccountmoney" placeholder="잔여가상계좌" type="text" value="<c:out value='${ model.ordermainitem.OMI_RVIRTUALACCOUNTMONEY }' />"  /><br/>
		ominewsavemoney<input name="r_ominewsavemoney" placeholder="발생적립금" type="text" value="<c:out value='${ model.ordermainitem.OMI_NEWSAVEMONEY }' />"  /><br/>
		omiorignalmoney<input name="r_omiorignalmoney" placeholder="원가" type="text" value="<c:out value='${ model.ordermainitem.OMI_ORIGNALMONEY }' />"  /><br/>
		omitotorignalmoney<input name="r_omitotorignalmoney" placeholder="원가합" type="text" value="<c:out value='${ model.ordermainitem.OMI_TOTORIGNALMONEY }' />"  /><br/>
		omisalemoney<input name="r_omisalemoney" placeholder="판매가" type="text" value="<c:out value='${ model.ordermainitem.OMI_SALEMONEY }' />"  /><br/>
		omitotsalemoney<input name="r_omitotsalemoney" placeholder="판매가합" type="text" value="<c:out value='${ model.ordermainitem.OMI_TOTSALEMONEY }' />"  /><br/>
		omidelitype<input name="r_omidelitype" placeholder="배송타입" type="text" value="<c:out value='${ model.ordermainitem.OMI_DELITYPE }' />"  /><br/>
		omidelimemo<input name="r_omidelimemo" placeholder="배송메모" type="text" value="<c:out value='${ model.ordermainitem.OMI_DELIMEMO }' />"  /><br/>
		omidelimoney<input name="r_omidelimoney" placeholder="배송비" type="text" value="<c:out value='${ model.ordermainitem.OMI_DELIMONEY }' />"  /><br/>
		omidelinum<input name="r_omidelinum" placeholder="배송번호" type="text" value="<c:out value='${ model.ordermainitem.OMI_DELINUM }' />"  /><br/>
		omimemo<input name="r_omimemo" placeholder="주문메모" type="text" value="<c:out value='${ model.ordermainitem.OMI_MEMO }' />"  /><br/>
		omipccseq<input name="r_omipccseq" placeholder="배송사SEQ" type="text" value="<c:out value='${ model.ordermainitem.OMI_PCCSEQ }' />"  /><br/>
		omiescrowyn<input name="r_omiescrowyn" placeholder="에스크로여부" type="text" value="<c:out value='${ model.ordermainitem.OMI_ESCROWYN }' />"  /><br/>
		omipartcancelyn<input name="r_omipartcancelyn" placeholder="부분취소가능여부" type="text" value="<c:out value='${ model.ordermainitem.OMI_PARTCANCELYN }' />"  /><br/>
		omiea<input name="r_omiea" placeholder="주문수량" type="text" value="<c:out value='${ model.ordermainitem.OMI_EA }' />"  /><br/>
		omioutea<input name="r_omioutea" placeholder="출고수량" type="text" value="<c:out value='${ model.ordermainitem.OMI_OUTEA }' />"  /><br/>
		omiinea<input name="r_omiinea" placeholder="취소수량" type="text" value="<c:out value='${ model.ordermainitem.OMI_INEA }' />"  /><br/>
		omistatus<input name="r_omistatus" placeholder="주문상태값" type="text" value="<c:out value='${ model.ordermainitem.OMI_STATUS }' />"  /><br/>
		omistep<input name="r_omistep" placeholder="스탭" type="text" value="<c:out value='${ model.ordermainitem.OMI_STEP }' />"  /><br/>
		omitype<input name="r_omitype" placeholder="타입" type="text" value="<c:out value='${ model.ordermainitem.OMI_TYPE }' />"  /><br/>
		omimoid<input name="r_omimoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermainitem.OMI_MOID }' />"  /><br/>
		omiinid<input name="r_omiinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermainitem.OMI_INID }' />"  /><br/>
<!--		<input name="r_omimodate" placeholder="수정일" type="text" value="${ fn:substring( model.ordermainitem.OMI_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_omiindate" placeholder="등록일" type="text" value="${ fn:substring( model.ordermainitem.OMI_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>