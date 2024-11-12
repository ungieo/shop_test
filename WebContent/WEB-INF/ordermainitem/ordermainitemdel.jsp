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

	<form action="ordermainitemdel" id="frm" name="frm" method="post" >

		<fieldset>
			<legend>ordermainitemdel</legend>
			<p>
				<label for="r_omiseq">아이디</label>
				<input id="r_omiseq" name="r_omiseq" placeholder="아이디" type="text" value="" required />
			</p>
			<p>
				<label for="r_omiomseq">주문번호</label>
				<input id="r_omiomseq" name="r_omiomseq" placeholder="주문번호" type="text" value="" required />
			</p>
			<p>
				<label for="r_omiprseq">상품고유번호</label>
				<input id="r_omiprseq" name="r_omiprseq" placeholder="상품고유번호" type="text" value="" required />
			</p>
			<p>
				<label for="r_omiproseq">상품옵션고유번호</label>
				<input id="r_omiproseq" name="r_omiproseq" placeholder="상품옵션고유번호" type="text" value="" />
			</p>
			<p>
				<label for="r_omipswd">비밀문자</label>
				<input id="r_omipswd" name="r_omipswd" placeholder="비밀문자" type="text" value="" required />
			</p>
			<p>
				<label for="r_omimbid">주문자아이디</label>
				<input id="r_omimbid" name="r_omimbid" placeholder="주문자아이디" type="text" value="" required />
			</p>
			<p>
				<label for="r_omimbname">주문자명</label>
				<input id="r_omimbname" name="r_omimbname" placeholder="주문자명" type="text" value="" />
			</p>
			<p>
				<label for="r_omipaytype">결제타입</label>
				<input id="r_omipaytype" name="r_omipaytype" placeholder="결제타입" type="text" value="" />
			</p>
			<p>
				<label for="r_omiaccountmoney">계좌이체</label>
				<input id="r_omiaccountmoney" name="r_omiaccountmoney" placeholder="계좌이체" type="text" value="" />
			</p>
			<p>
				<label for="r_omicardmoney">카드</label>
				<input id="r_omicardmoney" name="r_omicardmoney" placeholder="카드" type="text" value="" />
			</p>
			<p>
				<label for="r_omicouponmoney">쿠폰</label>
				<input id="r_omicouponmoney" name="r_omicouponmoney" placeholder="쿠폰" type="text" value="" />
			</p>
			<p>
				<label for="r_omilatermoney">후불</label>
				<input id="r_omilatermoney" name="r_omilatermoney" placeholder="후불" type="text" value="" />
			</p>
			<p>
				<label for="r_omipointmoney">포인트</label>
				<input id="r_omipointmoney" name="r_omipointmoney" placeholder="포인트" type="text" value="" />
			</p>
			<p>
				<label for="r_omisavemoney">적립금</label>
				<input id="r_omisavemoney" name="r_omisavemoney" placeholder="적립금" type="text" value="" />
			</p>
			<p>
				<label for="r_omivirtualaccountmoney">가상계좌</label>
				<input id="r_omivirtualaccountmoney" name="r_omivirtualaccountmoney" placeholder="가상계좌" type="text" value="" />
			</p>
			<p>
				<label for="r_omiraccountmoney">잔여계좌이체</label>
				<input id="r_omiraccountmoney" name="r_omiraccountmoney" placeholder="잔여계좌이체" type="text" value="" />
			</p>
			<p>
				<label for="r_omircardmoney">잔여카드</label>
				<input id="r_omircardmoney" name="r_omircardmoney" placeholder="잔여카드" type="text" value="" />
			</p>
			<p>
				<label for="r_omircouponmoney">잔여쿠폰</label>
				<input id="r_omircouponmoney" name="r_omircouponmoney" placeholder="잔여쿠폰" type="text" value="" />
			</p>
			<p>
				<label for="r_omirlatermoney">잔여후불</label>
				<input id="r_omirlatermoney" name="r_omirlatermoney" placeholder="잔여후불" type="text" value="" />
			</p>
			<p>
				<label for="r_omirpointmoney">잔여포인트</label>
				<input id="r_omirpointmoney" name="r_omirpointmoney" placeholder="잔여포인트" type="text" value="" />
			</p>
			<p>
				<label for="r_omirsavemoney">잔여적립금</label>
				<input id="r_omirsavemoney" name="r_omirsavemoney" placeholder="잔여적립금" type="text" value="" />
			</p>
			<p>
				<label for="r_omirvirtualaccountmoney">잔여가상계좌</label>
				<input id="r_omirvirtualaccountmoney" name="r_omirvirtualaccountmoney" placeholder="잔여가상계좌" type="text" value="" />
			</p>
			<p>
				<label for="r_ominewsavemoney">발생적립금</label>
				<input id="r_ominewsavemoney" name="r_ominewsavemoney" placeholder="발생적립금" type="text" value="" />
			</p>
			<p>
				<label for="r_omiorignalmoney">원가</label>
				<input id="r_omiorignalmoney" name="r_omiorignalmoney" placeholder="원가" type="text" value="" />
			</p>
			<p>
				<label for="r_omitotorignalmoney">원가합</label>
				<input id="r_omitotorignalmoney" name="r_omitotorignalmoney" placeholder="원가합" type="text" value="" />
			</p>
			<p>
				<label for="r_omisalemoney">판매가</label>
				<input id="r_omisalemoney" name="r_omisalemoney" placeholder="판매가" type="text" value="" />
			</p>
			<p>
				<label for="r_omitotsalemoney">판매가합</label>
				<input id="r_omitotsalemoney" name="r_omitotsalemoney" placeholder="판매가합" type="text" value="" />
			</p>
			<p>
				<label for="r_omidelitype">배송타입</label>
				<input id="r_omidelitype" name="r_omidelitype" placeholder="배송타입" type="text" value="" />
			</p>
			<p>
				<label for="r_omidelimemo">배송메모</label>
				<input id="r_omidelimemo" name="r_omidelimemo" placeholder="배송메모" type="text" value="" />
			</p>
			<p>
				<label for="r_omidelimoney">배송비</label>
				<input id="r_omidelimoney" name="r_omidelimoney" placeholder="배송비" type="text" value="" />
			</p>
			<p>
				<label for="r_omidelinum">배송번호</label>
				<input id="r_omidelinum" name="r_omidelinum" placeholder="배송번호" type="text" value="" />
			</p>
			<p>
				<label for="r_omimemo">주문메모</label>
				<input id="r_omimemo" name="r_omimemo" placeholder="주문메모" type="text" value="" />
			</p>
			<p>
				<label for="r_omipccseq">배송사SEQ</label>
				<input id="r_omipccseq" name="r_omipccseq" placeholder="배송사SEQ" type="text" value="" />
			</p>
			<p>
				<label for="r_omiescrowyn">에스크로여부</label>
				<input id="r_omiescrowyn" name="r_omiescrowyn" placeholder="에스크로여부" type="text" value="" />
			</p>
			<p>
				<label for="r_omipartcancelyn">부분취소가능여부</label>
				<input id="r_omipartcancelyn" name="r_omipartcancelyn" placeholder="부분취소가능여부" type="text" value="" />
			</p>
			<p>
				<label for="r_omiea">주문수량</label>
				<input id="r_omiea" name="r_omiea" placeholder="주문수량" type="text" value="" required />
			</p>
			<p>
				<label for="r_omioutea">출고수량</label>
				<input id="r_omioutea" name="r_omioutea" placeholder="출고수량" type="text" value="" />
			</p>
			<p>
				<label for="r_omiinea">취소수량</label>
				<input id="r_omiinea" name="r_omiinea" placeholder="취소수량" type="text" value="" />
			</p>
			<p>
				<label for="r_omistatus">주문상태값</label>
				<input id="r_omistatus" name="r_omistatus" placeholder="주문상태값" type="text" value="" />
			</p>
			<p>
				<label for="r_omistep">스탭</label>
				<input id="r_omistep" name="r_omistep" placeholder="스탭" type="text" value="" />
			</p>
			<p>
				<label for="r_omitype">타입</label>
				<input id="r_omitype" name="r_omitype" placeholder="타입" type="text" value="" />
			</p>
			<p>
				<label for="r_omimoid">수정아이디</label>
				<input id="r_omimoid" name="r_omimoid" placeholder="수정아이디" type="text" value="" />
			</p>
			<p>
				<label for="r_omiinid">등록아이디</label>
				<input id="r_omiinid" name="r_omiinid" placeholder="등록아이디" type="text" value="" />
			</p>
			<!--<p>
				<label for="r_omimodate">수정일</label>
				<input id="r_omimodate" name="r_omimodate" placeholder="수정일" type="text" value="" required />
			</p>-->
			<!--<p>
				<label for="r_omiindate">등록일</label>
				<input id="r_omiindate" name="r_omiindate" placeholder="등록일" type="text" value="" required />
			</p>-->

		<a href="#" onclick="dataDel()">삭제</a><br/>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>