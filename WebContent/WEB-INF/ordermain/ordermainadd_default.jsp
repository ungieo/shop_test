<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%   
	response.setHeader("cache-control","no-cache, no-store, must-revalidate");
	response.setHeader("expires","0");
	response.setHeader("pragma","no-cache");
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
                                                <th><fmt:formatNumber value="${ totalMoney }" pattern="#,###"/></th>
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
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="box payment-method">

                                            <h4>계좌이체</h4>

                                            <p>We like it all.</p>

                                            <div class="box-footer text-center">
                                                <input type="radio" name="payment" value="payment1" checked="checked">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="box payment-method">

                                            <h4>신용카드</h4>

                                            <p>VISA and Mastercard only.</p>

                                            <div class="box-footer text-center">
                                                <input type="radio" name="payment" value="payment2">
                                            </div>
                                        </div>
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