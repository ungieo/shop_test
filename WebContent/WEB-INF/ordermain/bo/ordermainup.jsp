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
		handling.submit( '', 'ordermainadd' );
	}

	function dataDel(){
		handling.submit( '', 'ordermaindel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermaindown' );
	}

	function dataEdit(){
		handling.submit( '', 'ordermainedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainin' );
	}

	function dataView(){
		handling.submit( '', 'ordermainview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainlist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainlist' );
	}

	function dataUp(){
		handling.submit( '', 'ordermainup' );
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

	<form action="ordermainin" method="post" id="frm" name="frm">

		omseq<input name="r_omseq" placeholder="고유번호" type="text" value="<c:out value='${ model.ordermain.OM_SEQ }' />"  /><br/>
		omid<input name="r_omid" placeholder="주문번호" type="text" value="<c:out value='${ model.ordermain.OM_ID }' />"  /><br/>
		ompgid<input name="r_ompgid" placeholder="PG결제번호" type="text" value="<c:out value='${ model.ordermain.OM_PGID }' />"  /><br/>
		ompswd<input name="r_ompswd" placeholder="비밀문자" type="text" value="<c:out value='${ model.ordermain.OM_PSWD }' />"  /><br/>
		ommbid<input name="r_ommbid" placeholder="주문자아이디" type="text" value="<c:out value='${ model.ordermain.OM_MBID }' />"  /><br/>
		ommbname<input name="r_ommbname" placeholder="주문자명" type="text" value="<c:out value='${ model.ordermain.OM_MBNAME }' />"  /><br/>
		omprname<input name="r_omprname" placeholder="상품이름(개수포함)" type="text" value="<c:out value='${ model.ordermain.OM_PRNAME }' />"  /><br/>
		ompaytype<input name="r_ompaytype" placeholder="결제타입" type="text" value="<c:out value='${ model.ordermain.OM_PAYTYPE }' />"  /><br/>
		omaccountmoney<input name="r_omaccountmoney" placeholder="계좌이체" type="text" value="<c:out value='${ model.ordermain.OM_ACCOUNTMONEY }' />"  /><br/>
		omcardmoney<input name="r_omcardmoney" placeholder="카드" type="text" value="<c:out value='${ model.ordermain.OM_CARDMONEY }' />"  /><br/>
		omcouponmoney<input name="r_omcouponmoney" placeholder="쿠폰" type="text" value="<c:out value='${ model.ordermain.OM_COUPONMONEY }' />"  /><br/>
		omlatermoney<input name="r_omlatermoney" placeholder="후불" type="text" value="<c:out value='${ model.ordermain.OM_LATERMONEY }' />"  /><br/>
		ompointmoney<input name="r_ompointmoney" placeholder="포인트" type="text" value="<c:out value='${ model.ordermain.OM_POINTMONEY }' />"  /><br/>
		omsavemoney<input name="r_omsavemoney" placeholder="적립금" type="text" value="<c:out value='${ model.ordermain.OM_SAVEMONEY }' />"  /><br/>
		omvirtualaccountmoney<input name="r_omvirtualaccountmoney" placeholder="가상계좌" type="text" value="<c:out value='${ model.ordermain.OM_VIRTUALACCOUNTMONEY }' />"  /><br/>
		omraccountmoney<input name="r_omraccountmoney" placeholder="잔여계좌이체" type="text" value="<c:out value='${ model.ordermain.OM_RACCOUNTMONEY }' />"  /><br/>
		omrcardmoney<input name="r_omrcardmoney" placeholder="잔여카드" type="text" value="<c:out value='${ model.ordermain.OM_RCARDMONEY }' />"  /><br/>
		omrcouponmoney<input name="r_omrcouponmoney" placeholder="잔여쿠폰" type="text" value="<c:out value='${ model.ordermain.OM_RCOUPONMONEY }' />"  /><br/>
		omrlatermoney<input name="r_omrlatermoney" placeholder="잔여후불" type="text" value="<c:out value='${ model.ordermain.OM_RLATERMONEY }' />"  /><br/>
		omrpointmoney<input name="r_omrpointmoney" placeholder="잔여포인트" type="text" value="<c:out value='${ model.ordermain.OM_RPOINTMONEY }' />"  /><br/>
		omrsavemoney<input name="r_omrsavemoney" placeholder="잔여적립금" type="text" value="<c:out value='${ model.ordermain.OM_RSAVEMONEY }' />"  /><br/>
		omrvirtualaccountmoney<input name="r_omrvirtualaccountmoney" placeholder="잔여가상계좌" type="text" value="<c:out value='${ model.ordermain.OM_RVIRTUALACCOUNTMONEY }' />"  /><br/>
		omnewsavemoney<input name="r_omnewsavemoney" placeholder="발생적립금" type="text" value="<c:out value='${ model.ordermain.OM_NEWSAVEMONEY }' />"  /><br/>
		omorignalmoney<input name="r_omorignalmoney" placeholder="원가" type="text" value="<c:out value='${ model.ordermain.OM_ORIGNALMONEY }' />"  /><br/>
		omsalemoney<input name="r_omsalemoney" placeholder="판매가" type="text" value="<c:out value='${ model.ordermain.OM_SALEMONEY }' />"  /><br/>
		omdelitype<input name="r_omdelitype" placeholder="배송타입" type="text" value="<c:out value='${ model.ordermain.OM_DELITYPE }' />"  /><br/>
		omdelimemo<input name="r_omdelimemo" placeholder="배송메모" type="text" value="<c:out value='${ model.ordermain.OM_DELIMEMO }' />"  /><br/>
		omdelimoney<input name="r_omdelimoney" placeholder="배송비" type="text" value="<c:out value='${ model.ordermain.OM_DELIMONEY }' />"  /><br/>
		omdelinum<input name="r_omdelinum" placeholder="배송번호" type="text" value="<c:out value='${ model.ordermain.OM_DELINUM }' />"  /><br/>
		ommemo<input name="r_ommemo" placeholder="주문메모" type="text" value="<c:out value='${ model.ordermain.OM_MEMO }' />"  /><br/>
		ompccseq<input name="r_ompccseq" placeholder="배송사SEQ" type="text" value="<c:out value='${ model.ordermain.OM_PCCSEQ }' />"  /><br/>
		omescrowyn<input name="r_omescrowyn" placeholder="에스크로여부" type="text" value="<c:out value='${ model.ordermain.OM_ESCROWYN }' />"  /><br/>
		ompartcancelyn<input name="r_ompartcancelyn" placeholder="부분취소가능여부" type="text" value="<c:out value='${ model.ordermain.OM_PARTCANCELYN }' />"  /><br/>
		omstatus<input name="r_omstatus" placeholder="상태값" type="text" value="<c:out value='${ model.ordermain.OM_STATUS }' />"  /><br/>
		omstep<input name="r_omstep" placeholder="스탭" type="text" value="<c:out value='${ model.ordermain.OM_STEP }' />"  /><br/>
		omtype<input name="r_omtype" placeholder="타입" type="text" value="<c:out value='${ model.ordermain.OM_TYPE }' />"  /><br/>
		ommoid<input name="r_ommoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermain.OM_MOID }' />"  /><br/>
		ominid<input name="r_ominid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermain.OM_INID }' />"  /><br/>
<!--		<input name="r_ommodate" placeholder="수정일" type="text" value="${ fn:substring( model.ordermain.OM_MODATE, 0, 16 ) }"  />--><br/>
<!--		<input name="r_omindate" placeholder="등록일" type="text" value="${ fn:substring( model.ordermain.OM_INDATE, 0, 16 ) }"  />--><br/>

		<a href="#" onclick="dataUp()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>