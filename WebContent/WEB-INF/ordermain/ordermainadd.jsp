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

    <!-- pg -->
    <link href="${cpath}/include/kcp/css/style.css" rel="stylesheet" type="text/css" id="cssLink"/>
    
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

    <link rel="shortcut icon" href="favicon.png">
    
    
    
    
    <script src="${cpath}/include/obaju/js/respond.min.js"></script>

    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>

	<script src="${ cpath }/include/soledot/js/jquery-validation/jquery.validate.js"></script>
	<script src="${ cpath }/include/soledot/js/jquery-validation/localization/messages_ko.js"></script>
	
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>

	<script src="${ cpath }/include/soledot/js/soledot.js"></script>
	
	
	<script type="text/javascript" src="<%= pginfo.getG_conf_js_url() %>"></script>
	

	<script type="text/javascript">
	
		$(function(){
			
			init_orderid();
			
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
					'r_omaemail1': { required: true, email: true }
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
                openwin = window.open( "${cpath}/proc_win.html", "proc_win", "width=449, height=209, top=300, left=300" );
                RetVal = true ;
            }
            
            else
            {
                /*  res_cd와 res_msg변수에 해당 오류코드와 오류메시지가 설정됩니다.
                    ex) 고객이 Payplus Plugin에서 취소 버튼 클릭시 res_cd=3001, res_msg=사용자 취소
                    값이 설정됩니다.
                */
                res_cd  = document.frm.res_cd.value ;
                res_msg = document.frm.res_msg.value ;

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

            document.frm.ordr_idxx.value = order_idxx;

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
             if( jsf__pay(document.frm) )
                document.frm.submit();
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
	                                        	<c:if test="${ status.first }" >
	                                        		<c:set var="prTotName" value="${ pr.PR_NAME }" />
	                                        		<c:if test="${ fn:length(model.productbasketMap.productbasketList) > 1 }">
	                                        			<c:set var="prTotName" value="${prTotName} 외 ${ fn:length(model.productbasketMap.productbasketList) }개" />
	                                        		</c:if>
	                                        	</c:if>	                                        	
	                                        	
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
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th colspan="4">Total</th>
                                                <th>
                                                	<fmt:formatNumber value="${ totalMoney }" pattern="#,###"/>
                                                	
<!--                                                 	<select name="pay_method" style="display: none;"> -->
<!--                                                 		<option value="100000000000"></option> -->
<!--                                                 		<option value="010000000000"></option> -->
<!--                                                 	</select> -->
                                                	
                                                	<input type="hidden" name="ordr_idxx" class="w200" value="" maxlength="40"/>
                                                	<input type="hidden" name="good_name" value="${prTotName }"/>
                                                	<input type="hidden" name="good_mny" value="${ totalMoney }" maxlength="9"/>
                                                	
                                                	
                                                	
                                               	    <input type="hidden" name="req_tx"          value="pay" />
												    <input type="hidden" name="site_cd"         value="<%= pginfo.getG_conf_site_cd()   %>" />
												    <input type="hidden" name="site_name"       value="<%= pginfo.getG_conf_site_name() %>" />
										        	<input type="hidden" name="quotaopt"        value="12"/>
   													<input type="hidden" name="currency"        value="WON"/>
   													
   													    <!-- PLUGIN 설정 정보입니다(변경 불가) -->
												    <input type="hidden" name="module_type"     value="<%= pginfo.getModule_type() %>"/>
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
												
													<!-- 2012년 8월 18일 전자상거래법 개정 관련 설정 부분 -->
													<!-- 제공 기간 설정 0:일회성 1:기간설정(ex 1:2012010120120131)  -->
													<input type="hidden" name="good_expr" value="0">
												
													<!-- 가맹점에서 관리하는 고객 아이디 설정을 해야 합니다.(필수 설정) -->
													<input type="hidden" name="shop_user_id"    value=""/>
													<!-- 복지포인트 결제시 가맹점에 할당되어진 코드 값을 입력해야합니다.(필수 설정) -->
												    <input type="hidden" name="pt_memcorp_cd"   value=""/>
												    
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
									<label class="control-label col-sm-2" for="r_omaname">보내시는 분</label>
									<div class="col-sm-4">
										<input type="text" class="form-control " placeholder="주문자명" name="r_omaname" value="${ model.member.MB_NAME }">
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
									<label class="control-label col-sm-2" for="r_omaemail">이메일</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="이메일" name="r_omaemail" value="${ model.member.MB_EMAIL }" />
									</div>
								</div>
								
                            </div>

                            <hr/>
                            
                            
							<h3>배송지 정보</h3>
                             
                            <div class="content">
                            	<div class="form-group form-group-sm">
									<label class="control-label col-sm-2" for="r_delivery">배송지 선택</label>
									<div class="col-sm-10">
										<label class="radio-inline"><input name="r_delivery" type="radio" value="1" checked="checked"/>주문자 동일</label>
										<label class="radio-inline"><input name="r_delivery" type="radio" value="2" />새주소</label>
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
<!--                                 <div class="row"> -->
                                	<div class="form-group">
										<div class="col-sm-4">
											<select class="form-control" name="pay_method">
												<option value="100000000000">신용카드</option>
												<option value="010000000000">계좌이체</option>
											</select>
										</div>
									</div>
<!--                                     <div class="col-sm-6"> -->
<!--                                         <div class="box payment-method"> -->
<!--                                             <h4>계좌이체</h4> -->
<!--                                             <p>We like it all.</p> -->
<!--                                             <div class="box-footer text-center"> -->
<!--                                                 <input type="radio" name="payment" value="010000000000" checked="checked" onchange="paymentCh(this);"> -->
<!--                                             </div> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                     <div class="col-sm-6"> -->
<!--                                         <div class="box payment-method"> -->
<!--                                             <h4>신용카드</h4> -->
<!--                                             <p>VISA and Mastercard only.</p> -->
<!--                                             <div class="box-footer text-center"> -->
<!--                                                 <input type="radio" name="payment" value="100000000000" onchange="paymentCh(this);"> -->
<!--                                             </div> -->
<!--                                         </div> -->
<!--                                     </div> -->

<!--                                 </div> -->
                                <!-- /.row -->

                            </div>
                            <!-- /.content -->

                            <div class="box-footer">
                                <div class="pull-left">
                                    <a href="basket.html" class="btn btn-default"><i class="fa fa-chevron-left"></i>쇼핑 계속하기</a>
                                </div>
                                <div class="pull-right">
                                    <button type="submit" class="btn btn-primary" onclick="return jsf__pay(this.form);" id="display_pay_button">결제<i class="fa fa-chevron-right"></i>
                                    </button>
                                </div>
                                <div id="display_setup_message" style="display:none">
									<p class="txt">
										결제를 계속 하시려면 상단의 노란색 표시줄을 클릭 하시거나 <a href="http://pay.kcp.co.kr/plugin_new/file/KCPUXWizard.exe"><span>[수동설치]</span></a>를 눌러
										Payplus Plug-in을 설치하시기 바랍니다.[수동설치]를 눌러 설치하신 경우 새로고침(F5)키를 눌러 진행하시기 바랍니다.
			                       </p>
			                     </div>
                            </div>
                            
                            
                        </form>
                    </div>
                    <!-- /.box -->


                </div>
                <!-- /.col-md-9 -->


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