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

	<form action="ordermainin" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>ordermainin</legend>
			<p>
				<label for="r_omseq">고유번호</label>
				<input id="r_omseq" name="r_omseq" placeholder="고유번호" type="text" value="<c:out value='${ model.ordermain.OM_SEQ }' />" required />
			</p>
			<p>
				<label for="r_omid">주문번호</label>
				<input id="r_omid" name="r_omid" placeholder="주문번호" type="text" value="<c:out value='${ model.ordermain.OM_ID }' />" />
			</p>
			<p>
				<label for="r_ompgid">PG결제번호</label>
				<input id="r_ompgid" name="r_ompgid" placeholder="PG결제번호" type="text" value="<c:out value='${ model.ordermain.OM_PGID }' />" />
			</p>
			<p>
				<label for="r_ompswd">비밀문자</label>
				<input id="r_ompswd" name="r_ompswd" placeholder="비밀문자" type="text" value="<c:out value='${ model.ordermain.OM_PSWD }' />" required />
			</p>
			<p>
				<label for="r_ommbid">주문자아이디</label>
				<input id="r_ommbid" name="r_ommbid" placeholder="주문자아이디" type="text" value="<c:out value='${ model.ordermain.OM_MBID }' />" required />
			</p>
			<p>
				<label for="r_ommbname">주문자명</label>
				<input id="r_ommbname" name="r_ommbname" placeholder="주문자명" type="text" value="<c:out value='${ model.ordermain.OM_MBNAME }' />" />
			</p>
			<p>
				<label for="r_omprname">상품이름(개수포함)</label>
				<input id="r_omprname" name="r_omprname" placeholder="상품이름(개수포함)" type="text" value="<c:out value='${ model.ordermain.OM_PRNAME }' />" required />
			</p>
			<p>
				<label for="r_ompaytype">결제타입</label>
				<input id="r_ompaytype" name="r_ompaytype" placeholder="결제타입" type="text" value="<c:out value='${ model.ordermain.OM_PAYTYPE }' />" />
			</p>
			<p>
				<label for="r_omaccountmoney">계좌이체</label>
				<input id="r_omaccountmoney" name="r_omaccountmoney" placeholder="계좌이체" type="text" value="<c:out value='${ model.ordermain.OM_ACCOUNTMONEY }' />" required />
			</p>
			<p>
				<label for="r_omcardmoney">카드</label>
				<input id="r_omcardmoney" name="r_omcardmoney" placeholder="카드" type="text" value="<c:out value='${ model.ordermain.OM_CARDMONEY }' />" required />
			</p>
			<p>
				<label for="r_omcouponmoney">쿠폰</label>
				<input id="r_omcouponmoney" name="r_omcouponmoney" placeholder="쿠폰" type="text" value="<c:out value='${ model.ordermain.OM_COUPONMONEY }' />" required />
			</p>
			<p>
				<label for="r_omlatermoney">후불</label>
				<input id="r_omlatermoney" name="r_omlatermoney" placeholder="후불" type="text" value="<c:out value='${ model.ordermain.OM_LATERMONEY }' />" required />
			</p>
			<p>
				<label for="r_ompointmoney">포인트</label>
				<input id="r_ompointmoney" name="r_ompointmoney" placeholder="포인트" type="text" value="<c:out value='${ model.ordermain.OM_POINTMONEY }' />" required />
			</p>
			<p>
				<label for="r_omsavemoney">적립금</label>
				<input id="r_omsavemoney" name="r_omsavemoney" placeholder="적립금" type="text" value="<c:out value='${ model.ordermain.OM_SAVEMONEY }' />" required />
			</p>
			<p>
				<label for="r_omvirtualaccountmoney">가상계좌</label>
				<input id="r_omvirtualaccountmoney" name="r_omvirtualaccountmoney" placeholder="가상계좌" type="text" value="<c:out value='${ model.ordermain.OM_VIRTUALACCOUNTMONEY }' />" required />
			</p>
			<p>
				<label for="r_omraccountmoney">잔여계좌이체</label>
				<input id="r_omraccountmoney" name="r_omraccountmoney" placeholder="잔여계좌이체" type="text" value="<c:out value='${ model.ordermain.OM_RACCOUNTMONEY }' />" required />
			</p>
			<p>
				<label for="r_omrcardmoney">잔여카드</label>
				<input id="r_omrcardmoney" name="r_omrcardmoney" placeholder="잔여카드" type="text" value="<c:out value='${ model.ordermain.OM_RCARDMONEY }' />" required />
			</p>
			<p>
				<label for="r_omrcouponmoney">잔여쿠폰</label>
				<input id="r_omrcouponmoney" name="r_omrcouponmoney" placeholder="잔여쿠폰" type="text" value="<c:out value='${ model.ordermain.OM_RCOUPONMONEY }' />" required />
			</p>
			<p>
				<label for="r_omrlatermoney">잔여후불</label>
				<input id="r_omrlatermoney" name="r_omrlatermoney" placeholder="잔여후불" type="text" value="<c:out value='${ model.ordermain.OM_RLATERMONEY }' />" required />
			</p>
			<p>
				<label for="r_omrpointmoney">잔여포인트</label>
				<input id="r_omrpointmoney" name="r_omrpointmoney" placeholder="잔여포인트" type="text" value="<c:out value='${ model.ordermain.OM_RPOINTMONEY }' />" required />
			</p>
			<p>
				<label for="r_omrsavemoney">잔여적립금</label>
				<input id="r_omrsavemoney" name="r_omrsavemoney" placeholder="잔여적립금" type="text" value="<c:out value='${ model.ordermain.OM_RSAVEMONEY }' />" required />
			</p>
			<p>
				<label for="r_omrvirtualaccountmoney">잔여가상계좌</label>
				<input id="r_omrvirtualaccountmoney" name="r_omrvirtualaccountmoney" placeholder="잔여가상계좌" type="text" value="<c:out value='${ model.ordermain.OM_RVIRTUALACCOUNTMONEY }' />" required />
			</p>
			<p>
				<label for="r_omnewsavemoney">발생적립금</label>
				<input id="r_omnewsavemoney" name="r_omnewsavemoney" placeholder="발생적립금" type="text" value="<c:out value='${ model.ordermain.OM_NEWSAVEMONEY }' />" required />
			</p>
			<p>
				<label for="r_omorignalmoney">원가</label>
				<input id="r_omorignalmoney" name="r_omorignalmoney" placeholder="원가" type="text" value="<c:out value='${ model.ordermain.OM_ORIGNALMONEY }' />" required />
			</p>
			<p>
				<label for="r_omsalemoney">판매가</label>
				<input id="r_omsalemoney" name="r_omsalemoney" placeholder="판매가" type="text" value="<c:out value='${ model.ordermain.OM_SALEMONEY }' />" required />
			</p>
			<p>
				<label for="r_omdelitype">배송타입</label>
				<input id="r_omdelitype" name="r_omdelitype" placeholder="배송타입" type="text" value="<c:out value='${ model.ordermain.OM_DELITYPE }' />" />
			</p>
			<p>
				<label for="r_omdelimemo">배송메모</label>
				<input id="r_omdelimemo" name="r_omdelimemo" placeholder="배송메모" type="text" value="<c:out value='${ model.ordermain.OM_DELIMEMO }' />" />
			</p>
			<p>
				<label for="r_omdelimoney">배송비</label>
				<input id="r_omdelimoney" name="r_omdelimoney" placeholder="배송비" type="text" value="<c:out value='${ model.ordermain.OM_DELIMONEY }' />" />
			</p>
			<p>
				<label for="r_omdelinum">배송번호</label>
				<input id="r_omdelinum" name="r_omdelinum" placeholder="배송번호" type="text" value="<c:out value='${ model.ordermain.OM_DELINUM }' />" />
			</p>
			<p>
				<label for="r_ommemo">주문메모</label>
				<input id="r_ommemo" name="r_ommemo" placeholder="주문메모" type="text" value="<c:out value='${ model.ordermain.OM_MEMO }' />" />
			</p>
			<p>
				<label for="r_ompccseq">배송사SEQ</label>
				<input id="r_ompccseq" name="r_ompccseq" placeholder="배송사SEQ" type="text" value="<c:out value='${ model.ordermain.OM_PCCSEQ }' />" />
			</p>
			<p>
				<label for="r_omescrowyn">에스크로여부</label>
				<input id="r_omescrowyn" name="r_omescrowyn" placeholder="에스크로여부" type="text" value="<c:out value='${ model.ordermain.OM_ESCROWYN }' />" />
			</p>
			<p>
				<label for="r_ompartcancelyn">부분취소가능여부</label>
				<input id="r_ompartcancelyn" name="r_ompartcancelyn" placeholder="부분취소가능여부" type="text" value="<c:out value='${ model.ordermain.OM_PARTCANCELYN }' />" />
			</p>
			<p>
				<label for="r_omstatus">상태값</label>
				<input id="r_omstatus" name="r_omstatus" placeholder="상태값" type="text" value="<c:out value='${ model.ordermain.OM_STATUS }' />" />
			</p>
			<p>
				<label for="r_omstep">스탭</label>
				<input id="r_omstep" name="r_omstep" placeholder="스탭" type="text" value="<c:out value='${ model.ordermain.OM_STEP }' />" />
			</p>
			<p>
				<label for="r_omtype">타입</label>
				<input id="r_omtype" name="r_omtype" placeholder="타입" type="text" value="<c:out value='${ model.ordermain.OM_TYPE }' />" />
			</p>
			<p>
				<label for="r_ommoid">수정아이디</label>
				<input id="r_ommoid" name="r_ommoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.ordermain.OM_MOID }' />" />
			</p>
			<p>
				<label for="r_ominid">등록아이디</label>
				<input id="r_ominid" name="r_ominid" placeholder="등록아이디" type="text" value="<c:out value='${ model.ordermain.OM_INID }' />" />
			</p>
			<!--<p>
				<label for="r_ommodate">수정일</label>
				<input id="r_ommodate" name="r_ommodate" placeholder="수정일" type="text" "${ fn:substring( model.ordermain.OM_MODATE, 0, 16 ) }" required />
			</p>-->
			<!--<p>
				<label for="r_omindate">등록일</label>
				<input id="r_omindate" name="r_omindate" placeholder="등록일" type="text" "${ fn:substring( model.ordermain.OM_INDATE, 0, 16 ) }" required />
			</p>-->

		<a href="#" onclick="dataList()">리스트</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>