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

	function dataUp( r_omiseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omiseq').val( r_omiseq );
		handling.submit( '', 'ordermainitemup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
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

	<form action="ordermainitemview" id="frm" name="frm" method="post" >

	<input name="r_omiseq" type="hidden" value="${ model.ordermainitem.OMI_SEQ }" />
	<c:if test="${ !empty model.ordermainitem }">
		아이디=<c:out value='${ model.ordermainitem.OMI_SEQ }' /><br/>
		주문번호=<c:out value='${ model.ordermainitem.OMI_OMSEQ }' /><br/>
		상품고유번호=<c:out value='${ model.ordermainitem.OMI_PRSEQ }' /><br/>
		상품옵션고유번호=<c:out value='${ model.ordermainitem.OMI_PROSEQ }' /><br/>
		비밀문자=<c:out value='${ model.ordermainitem.OMI_PSWD }' /><br/>
		주문자아이디=<c:out value='${ model.ordermainitem.OMI_MBID }' /><br/>
		주문자명=<c:out value='${ model.ordermainitem.OMI_MBNAME }' /><br/>
		결제타입=<c:out value='${ model.ordermainitem.OMI_PAYTYPE }' /><br/>
		계좌이체=<c:out value='${ model.ordermainitem.OMI_ACCOUNTMONEY }' /><br/>
		카드=<c:out value='${ model.ordermainitem.OMI_CARDMONEY }' /><br/>
		쿠폰=<c:out value='${ model.ordermainitem.OMI_COUPONMONEY }' /><br/>
		후불=<c:out value='${ model.ordermainitem.OMI_LATERMONEY }' /><br/>
		포인트=<c:out value='${ model.ordermainitem.OMI_POINTMONEY }' /><br/>
		적립금=<c:out value='${ model.ordermainitem.OMI_SAVEMONEY }' /><br/>
		가상계좌=<c:out value='${ model.ordermainitem.OMI_VIRTUALACCOUNTMONEY }' /><br/>
		잔여계좌이체=<c:out value='${ model.ordermainitem.OMI_RACCOUNTMONEY }' /><br/>
		잔여카드=<c:out value='${ model.ordermainitem.OMI_RCARDMONEY }' /><br/>
		잔여쿠폰=<c:out value='${ model.ordermainitem.OMI_RCOUPONMONEY }' /><br/>
		잔여후불=<c:out value='${ model.ordermainitem.OMI_RLATERMONEY }' /><br/>
		잔여포인트=<c:out value='${ model.ordermainitem.OMI_RPOINTMONEY }' /><br/>
		잔여적립금=<c:out value='${ model.ordermainitem.OMI_RSAVEMONEY }' /><br/>
		잔여가상계좌=<c:out value='${ model.ordermainitem.OMI_RVIRTUALACCOUNTMONEY }' /><br/>
		발생적립금=<c:out value='${ model.ordermainitem.OMI_NEWSAVEMONEY }' /><br/>
		원가=<c:out value='${ model.ordermainitem.OMI_ORIGNALMONEY }' /><br/>
		원가합=<c:out value='${ model.ordermainitem.OMI_TOTORIGNALMONEY }' /><br/>
		판매가=<c:out value='${ model.ordermainitem.OMI_SALEMONEY }' /><br/>
		판매가합=<c:out value='${ model.ordermainitem.OMI_TOTSALEMONEY }' /><br/>
		배송타입=<c:out value='${ model.ordermainitem.OMI_DELITYPE }' /><br/>
		배송메모=<c:out value='${ model.ordermainitem.OMI_DELIMEMO }' /><br/>
		배송비=<c:out value='${ model.ordermainitem.OMI_DELIMONEY }' /><br/>
		배송번호=<c:out value='${ model.ordermainitem.OMI_DELINUM }' /><br/>
		주문메모=<c:out value='${ model.ordermainitem.OMI_MEMO }' /><br/>
		배송사SEQ=<c:out value='${ model.ordermainitem.OMI_PCCSEQ }' /><br/>
		에스크로여부=<c:out value='${ model.ordermainitem.OMI_ESCROWYN }' /><br/>
		부분취소가능여부=<c:out value='${ model.ordermainitem.OMI_PARTCANCELYN }' /><br/>
		주문수량=<c:out value='${ model.ordermainitem.OMI_EA }' /><br/>
		출고수량=<c:out value='${ model.ordermainitem.OMI_OUTEA }' /><br/>
		취소수량=<c:out value='${ model.ordermainitem.OMI_INEA }' /><br/>
		주문상태값=<c:out value='${ model.ordermainitem.OMI_STATUS }' /><br/>
		스탭=<c:out value='${ model.ordermainitem.OMI_STEP }' /><br/>
		타입=<c:out value='${ model.ordermainitem.OMI_TYPE }' /><br/>
		수정아이디=<c:out value='${ model.ordermainitem.OMI_MOID }' /><br/>
		등록아이디=<c:out value='${ model.ordermainitem.OMI_INID }' /><br/>
<!--		수정일=${ fn:substring( model.ordermainitem.OMI_MODATE, 0, 16 ) }--><br/>
<!--		등록일=${ fn:substring( model.ordermainitem.OMI_INDATE, 0, 16 ) }--><br/>
	</c:if>

		<a href="#" onclick="dataAdd(  )">등록</a>
		<a href="#" onclick="dataEdit(  )">수정</a>
		<a href="#" onclick="dataDel(  )">삭제</a>
		<a href="#" onclick="dataList(  )">리스트</a>
	</form>
	</div>

	<%@ include file="/include/jsp/footer.jsp" %>

</body>
</html>