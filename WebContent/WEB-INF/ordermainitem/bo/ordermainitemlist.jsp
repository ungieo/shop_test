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

	function dataAdd(  ){
		handling.submit( '', 'ordermainitemadd' );
	}

	function dataDel( r_omiseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omiseq').val( r_omiseq );
		handling.submit( '', 'ordermainitemdel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermainitemdown' );
	}

	function dataEdit( r_omiseq ){
		handling.submit( '', 'ordermainitemedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainitemin' );
	}

	function dataView( r_omiseq ){
		$( '#r_omiseq' ).val( r_omiseq );
		handling.submit( '', 'ordermainitemview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainitemlist' );
	}

	function dataListDel(){
		handling.submit( '', 'ordermainitemlist' );
	}

	function dataListUp(){
		handling.submit( '', 'ordermainitemlist' );
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
		handling.submit( '', 'ordermainitemlist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainitemlist' );
	}

	function dataUp( r_omiseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omiseq').val( r_omiseq );
		handling.submit( '', 'ordermainitemup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( fName, r_url );
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

	<form action="ordermainitemlist" id="frm" name="frm" method="post" >

		<input name="r_page" type="hidden" value="${ model.r_page }" />
		<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
		<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />

		<input id="r_omiseq" name="r_omiseq" type="hidden" value="" />

		<table class="table table-hover">
			<caption>ordermainitemList</caption>
			<thead>
				<tr>
					<th>아이디</th>
					<th>주문번호</th>
					<th>상품고유번호</th>
					<th>상품옵션고유번호</th>
					<th>비밀문자</th>
					<th>주문자아이디</th>
					<th>주문자명</th>
					<th>결제타입</th>
					<th>계좌이체</th>
					<th>카드</th>
					<th>쿠폰</th>
					<th>후불</th>
					<th>포인트</th>
					<th>적립금</th>
					<th>가상계좌</th>
					<th>잔여계좌이체</th>
					<th>잔여카드</th>
					<th>잔여쿠폰</th>
					<th>잔여후불</th>
					<th>잔여포인트</th>
					<th>잔여적립금</th>
					<th>잔여가상계좌</th>
					<th>발생적립금</th>
					<th>원가</th>
					<th>원가합</th>
					<th>판매가</th>
					<th>판매가합</th>
					<th>배송타입</th>
					<th>배송메모</th>
					<th>배송비</th>
					<th>배송번호</th>
					<th>주문메모</th>
					<th>배송사SEQ</th>
					<th>에스크로여부</th>
					<th>부분취소가능여부</th>
					<th>주문수량</th>
					<th>출고수량</th>
					<th>취소수량</th>
					<th>주문상태값</th>
					<th>스탭</th>
					<th>타입</th>
					<th>수정아이디</th>
					<th>등록아이디</th>
					<th>수정일</th>
					<th>등록일</th>
				</tr>
			</thead>
		<c:forEach items="${ model.ordermainitemList}" var="ordermainitem" varStatus="status" >
			<tbody>
				<tr>
					<td><c:out value='${ ordermainitem.OMI_SEQ }' /></td>
					<td><c:out value='${ ordermainitem.OMI_OMSEQ }' /></td>
					<td><c:out value='${ ordermainitem.OMI_PRSEQ }' /></td>
					<td><c:out value='${ ordermainitem.OMI_PROSEQ }' /></td>
					<td><c:out value='${ ordermainitem.OMI_PSWD }' /></td>
					<td><c:out value='${ ordermainitem.OMI_MBID }' /></td>
					<td><c:out value='${ ordermainitem.OMI_MBNAME }' /></td>
					<td><c:out value='${ ordermainitem.OMI_PAYTYPE }' /></td>
					<td><c:out value='${ ordermainitem.OMI_ACCOUNTMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_CARDMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_COUPONMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_LATERMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_POINTMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_SAVEMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_VIRTUALACCOUNTMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_RACCOUNTMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_RCARDMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_RCOUPONMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_RLATERMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_RPOINTMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_RSAVEMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_RVIRTUALACCOUNTMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_NEWSAVEMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_ORIGNALMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_TOTORIGNALMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_SALEMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_TOTSALEMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_DELITYPE }' /></td>
					<td><c:out value='${ ordermainitem.OMI_DELIMEMO }' /></td>
					<td><c:out value='${ ordermainitem.OMI_DELIMONEY }' /></td>
					<td><c:out value='${ ordermainitem.OMI_DELINUM }' /></td>
					<td><c:out value='${ ordermainitem.OMI_MEMO }' /></td>
					<td><c:out value='${ ordermainitem.OMI_PCCSEQ }' /></td>
					<td><c:out value='${ ordermainitem.OMI_ESCROWYN }' /></td>
					<td><c:out value='${ ordermainitem.OMI_PARTCANCELYN }' /></td>
					<td><c:out value='${ ordermainitem.OMI_EA }' /></td>
					<td><c:out value='${ ordermainitem.OMI_OUTEA }' /></td>
					<td><c:out value='${ ordermainitem.OMI_INEA }' /></td>
					<td><c:out value='${ ordermainitem.OMI_STATUS }' /></td>
					<td><c:out value='${ ordermainitem.OMI_STEP }' /></td>
					<td><c:out value='${ ordermainitem.OMI_TYPE }' /></td>
					<td><c:out value='${ ordermainitem.OMI_MOID }' /></td>
					<td><c:out value='${ ordermainitem.OMI_INID }' /></td>
					<td>${ fn:substring( ordermainitem.OMI_MODATE, 0, 16 ) }</td>
					<td>${ fn:substring( ordermainitem.OMI_INDATE, 0, 16 ) }</td>
				</tr>
			</tbody>
		</c:forEach>
		</table>

		<a href="#" onclick="dataAdd(  )">등록</a>
	<div class="">
		<%@ include file="/include/jsp/pager.jsp" %>
	</div>

	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>