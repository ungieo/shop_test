<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="system.svc.PgInfo" %>

<%   
	response.setHeader("cache-control","no-cache, no-store, must-revalidate");
	response.setHeader("expires","0");
	response.setHeader("pragma","no-cache");
	
	PgInfo pginfo = new PgInfo();
%> 
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="SoleDot e-commerce">
    <meta name="author" content="raon">
    <meta name="keywords" content="">

    <title>Welcome nrzb!</title>

    <title>
        Obaju : e-commerce template
    </title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

    <!-- styles -->
    <link href="${cpath}/include/obaju/css/font-awesome.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/bootstrap.min.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/animate.min.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/owl.carousel.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/owl.theme.css" rel="stylesheet">

    <!-- theme stylesheet -->
    <link href="${cpath}/include/obaju/css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- your stylesheet with modifications -->
    <link href="${cpath}/include/obaju/css/custom.css" rel="stylesheet">

    <script src="${cpath}/include/obaju/js/respond.min.js"></script>

    <link rel="shortcut icon" href="favicon.png">

    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>

	<script src="${ cpath }/include/soledot/js/jquery-validation/jquery.validate.js"></script>
	<script src="${ cpath }/include/soledot/js/jquery-validation/localization/messages_ko.js"></script>
	
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>

	<script src="${ cpath }/include/soledot/js/soledot.js"></script>

	<script type="text/javascript">
	
		$(function(){
			
			
			
			jQuery.validator.addMethod("phone", function(value, element) {
				return this.optional(element) || /^01[\d]{1}-[\d]{3,4}-[\d]{4}$/.test(value);
				}, "유효하지 않은 휴대전화번호 입니다."
			);
			
			jQuery.validator.addMethod("tel", function(value, element) {
				return this.optional(element) || /^0[\d]{1,2}-[\d]{3,4}-[\d]{4}$/.test(value);
				}, "유효하지 않은 전화번호 입니다."
			);
			
			$('#frm').validate({
				rules: {
					'r_omaname': { required: true },
					'r_omazipcode': { required: true },
					'r_omaaddr1': { required: true },
					'r_omaaddr2': { required: true },
					'r_omatel': { tel: true },
					'r_omaphone': { required: true, phone: true },
					'r_omaemail': { required: true, email: true },
					'r_omaname1': { required: true },
					'r_omazipcode1': { required: true },
					'r_omaaddr11': { required: true },
					'r_omaaddr21': { required: true },
					'r_omatel1': { tel: true },
					'r_omaphone1': { required: true, phone: true },
					'r_omaemail1': { required: true, email: true },
					'payment': { required: true }
				},
			});
		});
		
		function dataIn(){
			handling.submit('','');
		}
		
		function getZipcode(type){
			daum.postcode.load(function(){
		        new daum.Postcode({
		            oncomplete: function(data) {
		            	if( 'S' == type ){
			            	document.getElementsByName( "r_omazipcode" )[0].value = data.zonecode;
				        	document.getElementsByName( "r_omaaddr1" )[0].value = data.roadAddress;
		            	}else{
		            		document.getElementsByName( "r_omazipcode1" )[0].value = data.zonecode;
				        	document.getElementsByName( "r_omaaddr11" )[0].value = data.roadAddress;
		            	}
		            }
		        }).open();
		    });
		}
		
		
		
        /* 플러그인 설치(확인) */
        StartSmartUpdate();
        
        /*  해당 스크립트는 타브라우져에서 적용이 되지 않습니다.
        if( document.Payplus.object == null )
        {
            openwin = window.open( "chk_plugin.html", "chk_plugin", "width=420, height=100, top=300, left=300" );
        }
        */

        /* Payplus Plug-in 실행 */
        function  jsf__pay( form )
        {
            var RetVal = false;

            /* Payplus Plugin 실행 */
            if ( MakePayMessage( form ) == true )
            {
			    alert("결제 승인 요청 전,\n\n반드시 결제창에서 고객님이 결제 인증 완료 후\n\n리턴 받은 ordr_chk 와 업체 측 주문정보를\n\n다시 한번 검증 후 결제 승인 요청하시기 바랍니다."); //업체 연동 시 필수 확인 사항.
                openwin = window.open( "proc_win.html", "proc_win", "width=449, height=209, top=300, left=300" );
                RetVal = true ;
            }
            
            else
            {
                /*  res_cd와 res_msg변수에 해당 오류코드와 오류메시지가 설정됩니다.
                    ex) 고객이 Payplus Plugin에서 취소 버튼 클릭시 res_cd=3001, res_msg=사용자 취소
                    값이 설정됩니다.
                */
                res_cd  = document.order_info.res_cd.value ;
                res_msg = document.order_info.res_msg.value ;

            }

            return RetVal ;
        }

        // Payplus Plug-in 설치 안내 
        function init_pay_button()
        {
            if ((navigator.userAgent.indexOf('MSIE') > 0) || (navigator.userAgent.indexOf('Trident/7.0') > 0))
            {
                try
                {
                    if( document.Payplus.object == null )
                    {
                        document.getElementById("display_setup_message").style.display = "block" ;
                    }
                    else{
                        document.getElementById("display_pay_button").style.display = "block" ;
                    }
                }
                catch (e)
                {
                    document.getElementById("display_setup_message").style.display = "block" ;
                }
            }
            else
            {
                try
                {
                    if( Payplus == null )
                    {
                        document.getElementById("display_setup_message").style.display = "block" ;
                    }
                    else{
                        document.getElementById("display_pay_button").style.display = "block" ;
                    }
                }
                catch (e)
                {
                    document.getElementById("display_setup_message").style.display = "block" ;
                }
            }
        }

        /* 주문번호 생성 예제 */
        function init_orderid()
        {
            var today = new Date();
            var year  = today.getFullYear();
            var month = today.getMonth() + 1;
            var date  = today.getDate();
            var time  = today.getTime();

            if(parseInt(month) < 10) {
                month = "0" + month;
            }

            if(parseInt(date) < 10) {
                date = "0" + date;
            }

            var order_idxx = "TEST" + year + "" + month + "" + date + "" + time;

            document.order_info.ordr_idxx.value = order_idxx;

            /*
             * 인터넷 익스플로러와 파이어폭스(사파리, 크롬.. 등등)는 javascript 파싱법이 틀리기 때문에 object 가 인식 전에 실행 되는 문제
             * 기존에는 onload 부분에 추가를 했지만 setTimeout 부분에 추가
             * setTimeout 300의 의미는 플러그인 인식속도에 따른 여유시간 설정
             * - 20101018 -
             */
            setTimeout("init_pay_button();",300);
        }

        /* onLoad 이벤트 시 Payplus Plug-in이 실행되도록 구성하시려면 다음의 구문을 onLoad 이벤트에 넣어주시기 바랍니다. */
        function onload_pay()
        {
             if( jsf__pay(document.order_info) )
                document.order_info.submit();
        }

        /*에스크로 결제시 필요한 장바구니 샘플예제 입니다.*/
        function create_goodInfo()
        {
            var chr30 = String.fromCharCode(30);	// ASCII 코드값 30
            var chr31 = String.fromCharCode(31);	// ASCII 코드값 31

            var good_info = "seq=1" + chr31 + "ordr_numb=20060310_0001" + chr31 + "good_name=양말" + chr31 + "good_cntx=2" + chr31 + "good_amtx=1000" + chr30 +
                            "seq=2" + chr31 + "ordr_numb=20060310_0002" + chr31 + "good_name=신발" + chr31 + "good_cntx=1" + chr31 + "good_amtx=1500" + chr30 +
                            "seq=3" + chr31 + "ordr_numb=20060310_0003" + chr31 + "good_name=바지" + chr31 + "good_cntx=1" + chr31 + "good_amtx=1000";

          document.order_info.good_info.value = good_info;
        }

		
	</script>
</head>

<body>

	<%@include file="/include/jsp/header.jsp" %>

    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">
                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li>Checkout - Address</li>
                    </ul>
                </div>

                <div class="col-md-12" id="checkout">

                    <div class="box">
                        <form action="${cpath}/ordermain/ordermainin" class="form-horizontal" method="post" id="frm" name="frm" >
                            <h2 class="text-success">주문서 작성</h2>
                            
                            <hr/>
                            
                            <h3>상품정보</h3>
                            
<!--                             <ul class="nav nav-pills nav-justified"> -->
<!--                                 <li class="active"><a href="#"><i class="fa fa-map-marker"></i><br>Address</a> -->
<!--                                 </li> -->
<!--                                 <li class="disabled"><a href="#"><i class="fa fa-truck"></i><br>Delivery Method</a> -->
<!--                                 </li> -->
<!--                                 <li class="disabled"><a href="#"><i class="fa fa-money"></i><br>Payment Method</a> -->
<!--                                 </li> -->
<!--                                 <li class="disabled"><a href="#"><i class="fa fa-eye"></i><br>Order Review</a> -->
<!--                                 </li> -->
<!--                             </ul> -->

							<div class="content">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th colspan="2">상품</th>
                                                <th>수량</th>
                                                <th>가격</th>
<!--                                                 <th>Discount</th> -->
                                                <th>합계</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach var="prb" items="${ model.productbasketMap.productbasketList }" varStatus="status">
	                                        	<c:set var="pr" value="${ model.productbasketMap.productList[status.index] }" />
	                                        	<c:set var="totalMoney" value="${ totalMoney + (pr.PR_PRICE * prb.PRB_EA) }"/>
	                                            <tr>
	                                                <td>
	                                                    <a href="#">
	                                                        <img src="${cpath}/data/up/product/${pr.PR_IMAGE1}" alt="${pr.PR_NAME}">
	                                                    </a>
	                                                </td>
	                                                <td><a href="${cpath}/product/productview?r_prseq=${pr.PR_SEQ}" >${ pr.PR_NAME }</a>
	                                                </td>
	                                                <td>${ prb.PRB_EA }</td>
	                                                <td><fmt:formatNumber value="${ pr.PR_PRICE }" pattern="#,###"/></td>
	<!--                                                 <td>$0.00</td> -->
	                                                <td><fmt:formatNumber value="${ pr.PR_PRICE * prb.PRB_EA }" pattern="#,###"/></td>
	                                            </tr>
                                            </c:forEach>
<!--                                             <tr> -->
<!--                                                 <td> -->
<!--                                                     <a href="#"> -->
<%--                                                         <img src="${cpath}/include/obaju/img/basketsquare.jpg" alt="Black Blouse Armani"> --%>
<!--                                                     </a> -->
<!--                                                 </td> -->
<!--                                                 <td><a href="#">Black Blouse Armani</a> -->
<!--                                                 </td> -->
<!--                                                 <td>1</td> -->
<!--                                                 <td>$200.00</td> -->
<!--                                                 <td>$0.00</td> -->
<!--                                                 <td>$200.00</td> -->
<!--                                             </tr> -->
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th colspan="4">Total</th>
                                                <th>
                                                	<fmt:formatNumber value="${ totalMoney }" pattern="#,###"/>
                                                	
                                                	
                                                	<input type="hidden" name="ordr_idxx" class="w200" value="" maxlength="40"/>	<!-- 주문번호 -->
                                                	<input type="hidden" name="good_name" value="${prTotName }"/>						<!-- 상품명 -->
                                                	<input type="hidden" name="good_mny" value="${ totalMoney }" maxlength="9"/>	<!-- 결제 금액 -->
<!--                                                 	<input type="text" name="buyr_name" class="w100" value="홍길동"/>					주문자명 -->
<!--                                                 	<input type="text" name="buyr_mail" class="w200" value="test@test.co.kr" maxlength="30" />	이메일 -->
<!--                                                 	<input type="text" name="buyr_tel1" class="w100" value="02-2108-1000"/>			전화번호 -->
<!--                                                 	<input type="text" name="buyr_tel2" class="w100" value="010-0000-0000"/>			휴대전화번호  -->



<%
 	/* ============================================================================== */
      		/* =   1-2. 에스크로 정보                                                       = */
 	/* = -------------------------------------------------------------------------- = */
 	/* =   에스크로 사용업체에 적용되는 정보입니다.                                 = */
 	/* = -------------------------------------------------------------------------- = */
%> 
													<input type="text" name="rcvr_name" class="w100" value="홍길순" />				<!-- 수취인명 -->
													<input type="text" name="rcvr_tel1" class="w100" value="02-2108-1000" />		<!-- 수취인 전화번호 -->
													<input type="text" name="rcvr_tel2" class="w100" value="010-0000-0000" />	<!-- 수취인 휴대폰번호 -->
													<input type="text" name="rcvr_mail" class="w200" value="honggilsoon@kcp.co.kr" size="30" maxlength="30" />		<!-- 수취인 E-mail -->
													<input type="text" name="rcvr_zipx" class="w100" value="157864" />				<!-- 수취인 우편번호 -->
													<input type="text" name="rcvr_add1" class="w200" value="서울시 구로구" />		<!-- 수취인 주소 -->
													<input type="text" name="rcvr_add2" class="w200" value="170-5 우림E-biz센터" />	<!-- 수취인 상세주소 -->
<%
 	/* = -------------------------------------------------------------------------- = */
 	/* =   1-2. 에스크로 정보  END													 = */
 	/* ============================================================================== */
%>


<%
    /* ============================================================================== */
    /* =   2. 가맹점 필수 정보 설정                                                 = */
    /* = -------------------------------------------------------------------------- = */
    /* =   ※ 필수 - 결제에 반드시 필요한 정보입니다.                               = */
    /* =   site_conf_inc.jsp 파일을 참고하셔서 수정하시기 바랍니다.                 = */
    /* = -------------------------------------------------------------------------- = */
    // 요청종류 : 승인(pay)/취소,매입(mod) 요청시 사용
%>

                                               	    <input type="hidden" name="req_tx"          value="pay" />
												    <input type="hidden" name="site_cd"         value="<%= pginfo.getG_conf_site_cd()   %>" />
												    <input type="hidden" name="site_name"       value="<%= pginfo.getG_conf_site_name() %>" />
												    
												    
<%
    /*
       할부옵션 : Payplus Plug-in에서 카드결제시 최대로 표시할 할부개월 수를 설정합니다.(0 ~ 18 까지 설정 가능)
       ※ 주의  - 할부 선택은 결제금액이 50,000원 이상일 경우에만 가능, 50000원 미만의 금액은 일시불로만 표기됩니다
                  예) value 값을 "5" 로 설정했을 경우 => 카드결제시 결제창에 일시불부터 5개월까지 선택가능
    */
%>												    
										        	<input type="hidden" name="quotaopt"        value="12"/>
   													<input type="hidden" name="currency"        value="WON"/>
   													
<%
    /* ============================================================================== */
    /* =   3. Payplus Plugin 필수 정보(변경 불가)                                   = */
    /* = -------------------------------------------------------------------------- = */
    /* =   결제에 필요한 주문 정보를 입력 및 설정합니다.                            = */
    /* = -------------------------------------------------------------------------- = */
%>   													
   													    <!-- PLUGIN 설정 정보입니다(변경 불가) -->
												    <input type="hidden" name="module_type"     value="<%= pginfo.getModule_type() %>"/>
												    
												    
												    
<%
    /* ============================================================================== */
    /* =   3-1. Payplus Plugin 에스크로결제 사용시 필수 정보                        = */
    /* = -------------------------------------------------------------------------- = */
    /* =   결제에 필요한 주문 정보를 입력 및 설정합니다.                            = */
    /* = -------------------------------------------------------------------------- = */
%>
													<!-- 에스크로 사용 여부 : 반드시 Y 로 설정 -->
													<input type="hidden" name="escw_used"       value="Y"/>
													<!-- 에스크로 결제처리 모드 : 에스크로: Y, 일반: N, KCP 설정 조건: O  -->
													<input type="hidden" name="pay_mod"         value="Y"/>
													<!-- 배송 소요일 : 예상 배송 소요일을 입력 -->
													<input type="hidden"  name="deli_term" value="03"/>
													<!-- 장바구니 상품 개수 : 장바구니에 담겨있는 상품의 개수를 입력(good_info의 seq값 참조) -->
													<input type="hidden"  name="bask_cntx" value="3"/>
													<!-- 장바구니 상품 상세 정보 (자바 스크립트 샘플 create_goodInfo()가 온로드 이벤트시 설정되는 부분입니다.) -->
													<input type="hidden" name="good_info"       value=""/>
<%
    /* = -------------------------------------------------------------------------- = */
    /* =   3-1. Payplus Plugin 에스크로결제 사용시 필수 정보  END                   = */
    /* ============================================================================== */
%>

								
												    
												    
<!--
      ※ 필 수
          필수 항목 : Payplus Plugin에서 값을 설정하는 부분으로 반드시 포함되어야 합니다
          값을 설정하지 마십시오
-->
													<input type="hidden" name="res_cd"          value=""/>
													<input type="hidden" name="res_msg"         value=""/>
													<input type="hidden" name="tno"             value=""/>
													<input type="hidden" name="trace_no"        value=""/>
													<input type="hidden" name="enc_info"        value=""/>
													<input type="hidden" name="enc_data"        value=""/>
													<input type="hidden" name="ret_pay_method"  value=""/>
													<input type="hidden" name="tran_cd"         value=""/>
													<input type="hidden" name="bank_name"       value=""/>
													<input type="hidden" name="bank_issu"       value=""/>
													<input type="hidden" name="use_pay_method"  value=""/>
													
													<!-- 주문정보 검증 관련 정보 : Payplus Plugin 에서 설정하는 정보입니다 -->
													<input type="hidden" name="ordr_chk"        value=""/>
													
												   <!--  현금영수증 관련 정보 : Payplus Plugin 에서 설정하는 정보입니다 -->
													<input type="hidden" name="cash_tsdtime"    value=""/>
													<input type="hidden" name="cash_yn"         value=""/>
													<input type="hidden" name="cash_authno"     value=""/>
													<input type="hidden" name="cash_tr_code"    value=""/>
													<input type="hidden" name="cash_id_info"    value=""/>
													
													<!-- 2012년 8월 18일 정자상거래법 개정 관련 설정 부분 -->
													<!-- 제공 기간 설정 0:일회성 1:기간설정(ex 1:2012010120120131)  -->
													<input type="hidden" name="good_expr" value="0">
													
													<!-- 가맹점에서 관리하는 고객 아이디 설정을 해야 합니다.(필수 설정) -->
													<input type="hidden" name="shop_user_id"    value=""/>
													<!-- 복지포인트 결제시 가맹점에 할당되어진 코드 값을 입력해야합니다.(필수 설정) -->
													<input type="hidden" name="pt_memcorp_cd"   value=""/>

<%
    /* = -------------------------------------------------------------------------- = */
    /* =   3. Payplus Plugin 필수 정보 END                                          = */
    /* ============================================================================== */
%>

<%
    /* ============================================================================== */
    /* =   4. 옵션 정보                                                             = */
    /* = -------------------------------------------------------------------------- = */
    /* =   ※ 옵션 - 결제에 필요한 추가 옵션 정보를 입력 및 설정합니다.             = */
    /* = -------------------------------------------------------------------------- = */

	/* 사용카드 설정 여부 파라미터 입니다.(통합결제창 노출 유무)
	<input type="hidden" name="used_card_YN"        value="Y"/> */
	/* 사용카드 설정 파라미터 입니다. (해당 카드만 결제창에 보이게 설정하는 파라미터입니다. used_card_YN 값이 Y일때 적용됩니다.
	/<input type="hidden" name="used_card"        value="CCBC:CCKM:CCSS"/> */

    /* 신용카드 결제시 OK캐쉬백 적립 여부를 묻는 창을 설정하는 파라미터 입니다
         포인트 가맹점의 경우에만 창이 보여집니다
        <input type="hidden" name="save_ocb"        value="Y"/> */

	/* 고정 할부 개월 수 선택
	       value값을 "7" 로 설정했을 경우 => 카드결제시 결제창에 할부 7개월만 선택가능
    <input type="hidden" name="fix_inst"        value="07"/> */

    /*  무이자 옵션
            ※ 설정할부    (가맹점 관리자 페이지에 설정 된 무이자 설정을 따른다)                             - "" 로 설정
            ※ 일반할부    (KCP 이벤트 이외에 설정 된 모든 무이자 설정을 무시한다)                           - "N" 로 설정
            ※ 무이자 할부 (가맹점 관리자 페이지에 설정 된 무이자 이벤트 중 원하는 무이자 설정을 세팅한다)   - "Y" 로 설정
    <input type="hidden" name="kcp_noint"       value=""/> */

    /*  무이자 설정
            ※ 주의 1 : 할부는 결제금액이 50,000 원 이상일 경우에만 가능
            ※ 주의 2 : 무이자 설정값은 무이자 옵션이 Y일 경우에만 결제 창에 적용
            예) 전 카드 2,3,6개월 무이자(국민,비씨,엘지,삼성,신한,현대,롯데,외환) : ALL-02:03:04
            BC 2,3,6개월, 국민 3,6개월, 삼성 6,9개월 무이자 : CCBC-02:03:06,CCKM-03:06,CCSS-03:06:04
    <input type="hidden" name="kcp_noint_quota" value="CCBC-02:03:06,CCKM-03:06,CCSS-03:06:09"/> */


	/* 해외카드 구분하는 파라미터 입니다.(해외비자, 해외마스터, 해외JCB로 구분하여 표시)
	<input type="hidden" name="used_card_CCXX"        value="Y"/> */

    /*  가상계좌 은행 선택 파라미터
         ※ 해당 은행을 결제창에서 보이게 합니다.(은행코드는 매뉴얼을 참조)
    <input type="hidden" name="wish_vbank_list" value="05:03:04:07:11:23:26:32:34:81:71"/> */

    /*  가상계좌 입금 기한 설정하는 파라미터 - 발급일 + 3일
    <input type="hidden" name="vcnt_expire_term" value="3"/> */

    /*  가상계좌 입금 시간 설정하는 파라미터
         HHMMSS형식으로 입력하시기 바랍니다
         설정을 안하시는경우 기본적으로 23시59분59초가 세팅이 됩니다
         <input type="hidden" name="vcnt_expire_term_time" value="120000"/> */

    /* 포인트 결제시 복합 결제(신용카드+포인트) 여부를 결정할 수 있습니다.- N 일경우 복합결제 사용안함
        <input type="hidden" name="complex_pnt_yn" value="N"/>    */

    /* 현금영수증 등록 창을 출력 여부를 설정하는 파라미터 입니다
         ※ Y : 현금영수증 등록 창 출력
         ※ N : 현금영수증 등록 창 출력 안함 
	※ 주의 : 현금영수증 사용 시 KCP 상점관리자 페이지에서 현금영수증 사용 동의를 하셔야 합니다
        <input type="hidden" name="disp_tax_yn"     value="Y"/> */

    /* 결제창에 가맹점 사이트의 로고를 플러그인 좌측 상단에 출력하는 파라미터 입니다
       업체의 로고가 있는 URL을 정확히 입력하셔야 하며, 최대 150 X 50  미만 크기 지원

	※ 주의 : 로고 용량이 150 X 50 이상일 경우 site_name 값이 표시됩니다.
        <input type="hidden" name="site_logo"       value="" /> */

	/* 결제창 영문 표시 파라미터 입니다. 영문을 기본으로 사용하시려면 Y로 세팅하시기 바랍니다
		2010-06월 현재 신용카드와 가상계좌만 지원됩니다
	    <input type='hidden' name='eng_flag'      value='Y'> */

	/* KCP는 과세상품과 비과세상품을 동시에 판매하는 업체들의 결제관리에 대한 편의성을 제공해드리고자, 
	   복합과세 전용 사이트코드를 지원해 드리며 총 금액에 대해 복합과세 처리가 가능하도록 제공하고 있습니다
	   복합과세 전용 사이트 코드로 계약하신 가맹점에만 해당이 됩니다
       상품별이 아니라 금액으로 구분하여 요청하셔야 합니다
	   총결제 금액은 과세금액 + 부과세 + 비과세금액의 합과 같아야 합니다. 
	   (good_mny = comm_tax_mny + comm_vat_mny + comm_free_mny)
	
	    <input type="hidden" name="tax_flag"       value="TG03">  <!-- 변경불가	   -->
	    <input type="hidden" name="comm_tax_mny"   value=""    >  <!-- 과세금액	   --> 
        <input type="hidden" name="comm_vat_mny"   value=""    >  <!-- 부가세	   -->
	    <input type="hidden" name="comm_free_mny"  value=""    >  <!-- 비과세 금액 --> */

	/* skin_indx 값은 스킨을 변경할 수 있는 파라미터이며 총 7가지가 지원됩니다. 
	   변경을 원하시면 1부터 7까지 값을 넣어주시기 바랍니다. 

		<input type='hidden' name='skin_indx'      value='1'> */

	/* 상품코드 설정 파라미터 입니다.(상품권을 따로 구분하여 처리할 수 있는 옵션기능입니다.)
	    <input type='hidden' name='good_cd'      value=''> */

    /* = -------------------------------------------------------------------------- = */
    /* =   4. 옵션 정보 END                                                         = */
    /* ============================================================================== */
%>
												    






												</th>
                                            </tr>
                                        </tfoot>
                                    </table>

                                </div>
                                <!-- /.table-responsive -->
                            </div>
                            <!-- /.content -->

                            <hr/>
                            
                            <h3>주문자 정보</h3>
                             
                            <div class="content">
                            	<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="buyr_name">보내시는 분</label>
									<div class="col-sm-4">
										<input type="text" class="form-control " placeholder="주문자명" name="buyr_name" value="${ model.member.MB_NAME }">
									</div>
								</div>
								
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_omazipcode">우편번호</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" readonly="readonly" placeholder="우편번호" name="r_omazipcode" value="${ model.member.MB_ZIPCODE }">
									</div>
									<div class="col-sm-3">
										<input type="button" class="form-control btn btn-round btn-info" onclick="getZipcode('S');" value="우편번호 검색">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_omaaddr1">기본주소</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" readonly="readonly" placeholder="기본주소" name="r_omaaddr1" value="${ model.member.MB_ADDR1 }">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2 " for="r_omaaddr2">상세주소</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="상세주소" name="r_omaaddr2" value="${ model.member.MB_ADDR2 }">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_omaphone">휴대전화</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="휴대전화" name="r_omaphone" value="${ model.member.MB_PHONE }">
									</div>
								</div>
								
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_omatel">전화번호</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="전화번호" name="r_omatel" value="${ model.member.MB_TEL }">
									</div>
								</div>
								
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="buyr_mail">이메일</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="이메일" name="buyr_mail" value="${ model.member.MB_EMAIL }" />
									</div>
								</div>
								
                            </div>

                            <hr/>
                            
                            
							<h3>배송지 정보</h3>
                             
                            <div class="content">
                            	<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_delivery">배송지 선택</label>
									<div class="col-sm-10">
										<label class="radio-inline"><input name="r_delivery" type="radio" value="1" />주문자 동일</label>
										<label class="radio-inline"><input name="r_delivery" type="radio" value="2" />여성</label>
										<label class="radio-inline"><input name="r_delivery" type="radio" value="2" />여성</label>
										<label class="radio-inline"><input name="r_delivery" type="radio" value="2" />여성</label>
									</div>
								</div>
								
                            	<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_omaname1">받는분</label>
									<div class="col-sm-4">
										<input type="text" class="form-control " placeholder="받는분"  name="r_omaname1" value="${ model.member.MB_NAME }">
									</div>
								</div>
								
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_omazipcode1">우편번호</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" readonly="readonly" placeholder="우편번호" name="r_omazipcode1" value="${ model.member.MB_ZIPCODE }">
									</div>
									<div class="col-sm-3">
										<input type="button" class="form-control btn btn-round btn-info" onclick="getZipcode('R');" value="우편번호 검색">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_omaaddr11">기본주소</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" readonly="readonly" placeholder="기본주소" name="r_omaaddr11" value="${ model.member.MB_ADDR1 }">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2 " for="r_omaaddr21">상세주소</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="상세주소" name="r_omaaddr21" value="${ model.member.MB_ADDR2 }">
									</div>
								</div>
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_omaphone1">휴대폰</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="휴대폰" name="r_omaphone1" value="${ model.member.MB_PHONE }">
									</div>
								</div>
								
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_omatel1">전화번호</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="전화번호" name="r_omatel1" value="${ model.member.MB_TEL }">
									</div>
								</div>
								
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_omaemail1">이메일</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="이메일" name="r_omaemail1" value="${ model.member.MB_EMAIL }" />
									</div>
								</div>
								
                            </div>

                            <hr/>
                            
                            <h3>결제정보</h3>
                            
                            <div class="content">
                                <div class="form-group">
										<div class="col-sm-4">
											<select class="form-control" name="pay_method">
												<option value="100000000000">신용카드</option>
												<option value="010000000000">계좌이체</option>
											</select>
										</div>
									</div>
                                <!-- /.row -->

                            </div>
                            <!-- /.content -->

                            <div class="box-footer">
                                <div class="pull-left">
                                    <a href="basket.html" class="btn btn-default"><i class="fa fa-chevron-left"></i>쇼핑 계속하기</a>
                                </div>
                                <div class="pull-right">
                                    <button type="button" class="btn btn-primary" onclick="dataIn()">결제<i class="fa fa-chevron-right"></i>
                                    </button>
                                </div>
                            </div>
                            
                            
                        </form>
                    </div>
                    <!-- /.box -->


                </div>
                <!-- /.col-md-9 -->

<!--                 <div class="col-md-3"> -->

<!--                     <div class="box" id="order-summary"> -->
<!--                         <div class="box-header"> -->
<!--                             <h3>Order summary</h3> -->
<!--                         </div> -->
<!--                         <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.</p> -->

<!--                         <div class="table-responsive"> -->
<!--                             <table class="table"> -->
<!--                                 <tbody> -->
<!--                                     <tr> -->
<!--                                         <td>Order subtotal</td> -->
<!--                                         <th>$446.00</th> -->
<!--                                     </tr> -->
<!--                                     <tr> -->
<!--                                         <td>Shipping and handling</td> -->
<!--                                         <th>$10.00</th> -->
<!--                                     </tr> -->
<!--                                     <tr> -->
<!--                                         <td>Tax</td> -->
<!--                                         <th>$0.00</th> -->
<!--                                     </tr> -->
<!--                                     <tr class="total"> -->
<!--                                         <td>Total</td> -->
<!--                                         <th>$456.00</th> -->
<!--                                     </tr> -->
<!--                                 </tbody> -->
<!--                             </table> -->
<!--                         </div> -->

<!--                     </div> -->

<!--                 </div> -->
<!--                 /.col-md-3 -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

		<!-- footer content -->
		<%@include file="/include/jsp/footer.jsp" %>
		<!-- /footer content -->

    </div>
    <!-- /#all -->


    

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
    <script src="${cpath}/include/obaju/js/bootstrap.min.js"></script>
    <script src="${cpath}/include/obaju/js/jquery.cookie.js"></script>
    <script src="${cpath}/include/obaju/js/waypoints.min.js"></script>
    <script src="${cpath}/include/obaju/js/modernizr.js"></script>
    <script src="${cpath}/include/obaju/js/bootstrap-hover-dropdown.js"></script>
    <script src="${cpath}/include/obaju/js/owl.carousel.min.js"></script>
    <script src="${cpath}/include/obaju/js/front.js"></script>






</body>

</html>