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
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>Welcome nrzb!</title>

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

<!--     <link rel="shortcut icon" href="favicon.png"> -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>
    
    <script src="${ cpath }/include/soledot/js/soledot.js"></script>

	<script type="text/javascript">
		$(function(){
			$( '#table1 > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
				$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', $( this ).prop( 'checked' ) );
				totalMoney();
			});
		});
		
		function dataAjax(option){
			$.ajax(option);			
		}
		function dataDel(obj, r_prbseq){
			if( !confirm('삭제하시겠습니까?' ) ){
				return false;
			}
			var option = {
				async : false,
				data : 'r_prbseq='+r_prbseq,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( true == data.result ){
						location.reload();
// 						$(obj).parent().parent().remove();
// 						$('#basketCnt').text(data.basketCnt);
// 						totalMoney();
					}else{
						alert(data.msg);
					}
				},
				type : 'POST',
				url : '${cpath}/productbasket/productbasketdelajax'
			}
			dataAjax(option)
		}
		
		function dataListDel(){
			var r_prbseq = [];
			var checkObj = []
			
			$( '#table1 > tbody > tr > td > input:checked' ).each(function(i,e){
				r_prbseq[i] = $(this).val();
				checkObj[i] = e;
			});
			
			if( r_prbseq.length > 0 ){
				
				if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
					return;
				}
				var option = {
					async : false,
					data : 'r_prbseq='+r_prbseq.join(','),
					dataType : 'json',	
					cache : false,
					error : function( xhr, textStatus, error ){
						alert( error );
					},
					success : function(data){
						if( true == data.result ){
							location.reload();
// 							$( checkObj ).each(function(){
// 								$(this).parent().parent().remove();
// 							})
// 							$('#basketCnt').text(data.basketCnt);
							//--- 합계 계산...
// 							totalMoney();
						}else{
							alert(data.msg);
						}
					},
					type : 'POST',
					url : '${cpath}/productbasket/productbasketlistdelajax'
				}
				dataAjax(option)
				
			}else{
				alert('선택 후 진행해주십시오');
			}
		}
		
		function eaChange(obj){
			var v_prea = $(obj).parent().find('input[name="r_prbea"]').val();
			if( /[^\d]/.test( v_prea ) || 1 > v_prea ){
				alert("수량은 1이상의 숫자만 입력됩니다.");
				$(obj).val(1);
				v_prea = 1;
			}
			var r_prbseq = $(obj).parent().parent().find(':checkbox').val();
			var option = {
				async : false,
				data : 'r_prbseq='+r_prbseq+'&r_prbea='+v_prea,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( false == data.result ){
						alert('처리에 오류가 발생했습니다.');
					}else{
// 						var prmoney = $(obj).parent().next().text();
						
// 						prmoney = prmoney.replace(/,/g,'');
// 						var prRowSum = v_prea * prmoney;
// 						$(obj).parent().parent().find('span').text(prRowSum.toLocaleString());
						location.reload();
// 						totalMoney();
					}
				},
				type : 'POST',
				url : '${cpath}/productbasket/productbasketupajax'
			}
			dataAjax(option);
			
			
		}
		
		function orderAdd(type){
			
			if( 'A' == type ){
				$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', true );
			}else{
				if( $( '#table1 > tbody > tr > td > input:checked' ).length < 1 ){
					alert('선택 된 상품이 없습니다.');
					return false;
				}
			}
			
			var optionNullCnt = 0;
			$( '#table1 > tbody > tr > td > input:checked' ).each(function(){
				var r_procnt = $(this).parent().parent().find('input[name="r_procnt"]').val();
				var r_prbproseq = $(this).parent().parent().find('input[name="r_prbproseq"]').val();
				if( 0 < r_procnt && 1 > r_prbproseq ){
					optionNullCnt++;
				}
			})
			
			if( 0 < optionNullCnt ){
				alert('옵션을 선택해주십시오');
				return false;
			}
			totalMoney();
			handling.submit('','${cpath}/ordermain/ordermainadd')
		}
		
		function orderCheck(obj){
			$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', false );
			$(obj).parent().parent().find('input[type="checkbox"]').prop('checked',true);
			orderAdd('C');
		}
		
		function totalMoney(){
			var totalMoney = 0;
			$('#table1 > tbody > tr').each(function(i,e){
				if( $(e).find('input[type=checkbox]').is(":checked") ){
					totalMoney += parseInt( $(e).find('span').text().replace(/,/g,'') );
				}
			});
			$('#totalMoney').text(totalMoney.toLocaleString());
		}
		
		function wishIn(r_prseq){
			
			var option = {
				async : false,
				data : 'r_prseq='+r_prseq,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( false == data.result ){
						alert( data.msg );
					}else{
						alert( data.msg );
					}
				},
				type : 'POST',
				url : '${cpath}/productwish/productwishinajax'
			}
			dataAjax( option );
			
		}
		
// 		var optionButtonObj;
		function optionChice(r_prseq,r_prbseq){
// 			optionButtonObj = obj;
			var option = {
					async : false,
					data : 'r_proprseq='+r_prseq,
					dataType : 'json',	
					cache : false,
					error : function( xhr, textStatus, error ){
						alert( error );
					},
					success : function(data){
						if( true == data.result ){
							$('#pro_select option:gt(0)').remove();
							var optionStr = '';
							for( var i = 0; i < data.productoptionList.length; i++ ){
								optionStr += '<option value="'+data.productoptionList[i].pro_seq+'">'+data.productoptionList[i].pro_gname+'/'+data.productoptionList[i].pro_name+'</option>';
							}
							$('#pro_select').append(optionStr);
							$('#pro-modal .modal-footer').html('<button onclick="optionSet('+r_prbseq+');" type="button">확인</button>');
							$('#pro-modal').modal('show');
						}else{
							alert( data.msg );
						}
					},
					type : 'POST',
					url : '${cpath}/productoption/productoptionlistajax'
			}
			dataAjax(option);
			
		}
		
		function optionSet(r_prbseq){
			var r_proseq = $('#pro_select').val();
			if( '' == r_proseq ){
				alert('옵션을 선택해주십시오');
				return false;
			}
// 			var r_prbseq = '';
// 			r_prbseq = $(optionButtonObj).parent().parent().parent().find('input[name="r_prbseqarr"]').val();
			var option = {
				async : false,
				data : 'r_prbseq='+r_prbseq+'&r_prbproseq='+r_proseq,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( true == data.result ){
// 						$(optionButtonObj).parent().parent().find('input[name="r_prbproseq"]').val(r_proseq);
// 						var optionDivHtml = '';
// 						optionDivHtml += $('#pro_select :selected').text();
// 						optionDivHtml += '<button class="btn btn-info btn-xs" onclick="optionChice(this, \''+r_prseq+'\');" style="margin-left: 5px;" type="button" >변경</button>';
// 						$(optionButtonObj).parent().html(optionDivHtml);
// 						$('#pro-modal').modal('hide');
						location.reload();
					}else{
						alert( data.msg );
					}
				},
				type : 'POST',
				url : '${cpath}/productbasket/productbasketupajax'
			}
			dataAjax(option);
			
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
                        <li><a href="${cpath}/nrzb/index">Home</a>
                        </li>
                        <li>Shopping cart</li>
                    </ul>
                </div>

                <div class="col-md-12" id="basket">

                    <div class="box">

                        <form class="form-inline" name="frm" id="frm" method="post" action="${cpath}/ordermain/ordermainadd">

                            <h2>Shopping cart</h2>
<%--                             <p class="text-muted">Total ${cvt:toInt(model.prbCnt)} item(s) in your cart.</p> --%>
                            <div class="table-responsive">
                                <table class="table table-hover" id="table1">
                                    <thead>
                                        <tr>
                                        	<th class="text-center">
                                        		<input type="checkbox" checked="checked"/>
                                        	</th>
                                            <th colspan="2">상품</th>
                                            <th>옵션</th>
                                            <th>수량</th>
                                            <th>가격</th>
                                            <th colspan="2">합계</th>
<!--                                             <th >주문</th> -->
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="prb" items="${ model.productbasketMap.productbasketList }" varStatus="status">
                                    	<c:set var="pr" value="${ model.productbasketMap.productList[status.index] }" />
                                    	<c:set var="pro" value="${ model.productbasketMap.productoptionList[status.index] }" />
                                    	<c:set var="proCnt" value="${ model.productbasketMap.procntList[status.index] }" />
                                    	<c:set var="totMoney"  value="${totMoney+(pr.PR_PRICE*prb.PRB_EA)}" />
                                        <tr>
                                        	<td class="text-center" >
												<input name="r_prbseqarr" onchange="totalMoney();" type="checkbox" style="width:20px" value="${prb.PRB_SEQ}" checked="checked"/>
											</td>
                                            <td>
                                                <a href="${cpath}/product/productview?r_prseq=${pr.PR_SEQ}">
                                                    <img src="${cpath}/data/up/product/${pr.PR_IMAGE1}" alt="${ pr.PR_NAME }">
                                                </a>
                                            </td>
                                            <td >
                                            	<a href="${cpath}/product/productview?r_prseq=${pr.PR_SEQ}">${ pr.PR_NAME }</a>
                                            </td>
                                            <td>
                                            	<input name="r_prbproseq" type="hidden" value="${ prb.PRB_PROSEQ }"/>
                                            	<input name="r_procnt" type="hidden" value="${ proCnt }" />
                                            	<c:if test="${ 0 < proCnt }">
                                            		<c:if test="${ 0 < prb.PRB_PROSEQ }">
	                                            			${ pro.PRO_GNAME }/${ pro.PRO_NAME }
	                                            			<button class="btn btn-info btn-xs" onclick="optionChice('${pr.PR_SEQ}','${prb.PRB_SEQ}');" style="margin-left: 5px" type="button" >변경</button>
                                            		</c:if>
                                            		<c:if test="${ 1 > prb.PRB_PROSEQ }">
                                            			<button class="btn btn-info btn-xs" onclick="optionChice('${pr.PR_SEQ}','${prb.PRB_SEQ}');" type="button" >옵션선택</button>
                                            		</c:if>                                            		
                                            	</c:if>
                                            </td>
                                            <td>
                                                <input class="form-control input-sm" name="r_prbea" style="width:60px;" type="number" value="${prb.PRB_EA}" />
                                                <button class="btn btn-success btn-xs" type="button" onclick="eaChange(this);">변경</button>
                                            </td>
                                            <td>
                                            	<fmt:formatNumber value="${ pr.PR_PRICE }" pattern="#,###"/>
                                            </td>
                                            <td>
                                            	<span><fmt:formatNumber value="${ pr.PR_PRICE * prb.PRB_EA }" pattern="#,###"/></span>
                                            </td>
                                            <td>
<%--                                             	<button class="btn btn-primary btn-sm" onclick="dataAdd(this, '${prb.PRB_SEQ}');" style="margin: 3px;" type="button" > --%>
<!--                                             		<strong>상품주문 <i class="fa fa-chevron-right"></i></strong> -->
<!--                                             	</button> -->
<!--                                             	<div class="clear-fix" ></div> -->
<%--                                             	<button class="btn btn-success btn-sm" onclick="wishIn('${pr.PR_SEQ}');" style="margin: 3px;" type="button" > --%>
<!--                                             		<strong>관심상품 <i class="fa fa-heart-o"></i></strong> -->
<!--                                             	</button> -->
<!--                                             	<div class="clear-fix" ></div> -->
<%--                                             	<button class="btn btn-danger btn-sm" onclick="dataDel(this, '${prb.PRB_SEQ}');" style="margin: 3px;"  type="button"  > --%>
<!--                                             		<strong>상품삭제 <i class="fa fa-trash-o"></i></strong> -->
<!--                                             	</button> -->
                                            	<a href="#" onclick="orderCheck(this);return false;" style="color:#5cb85c;">
                                            		<strong><i class="fa fa-check-circle-o"></i>주문하기</strong>
                                            	</a>
                                            	<div class="clear-fix" style="margin: 5px"></div>
                                            	<a href="#" onclick="wishIn('${pr.PR_SEQ}');return false;" style="color:#5bc0de;">
                                            		<strong><i class="fa fa-heart-o"></i>관심상품등록</strong>
                                            	</a>
                                            	<div class="clear-fix" style="margin: 5px"></div>
                                            	<a href="#" onclick="dataDel(this, '${prb.PRB_SEQ}');return false;" style="color:#d9534f;">
                                            		<strong><i class="fa fa-trash-o"></i>삭제</strong>
                                            	</a>
                                            </td>
                                        </tr>
                                    	</c:forEach>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                        	<td></td>
                                            <th colspan="5">Total</th>
                                            <th colspan="2" ><span id="totalMoney"><fmt:formatNumber value="${totMoney}" pattern="#,###"/></span>원</th>
                                        </tr>
                                    </tfoot>
                                </table>

                            </div>
                            <!-- /.table-responsive -->

                            <div class="box-footer">
                                <div class="pull-left">
<!--                                     <a href="javascript:history.back();" class="btn btn-default"><i class="fa fa-chevron-left"></i> 쇼핑계속하기</a> -->
                                    <a href="#" onclick="dataListDel();return false;" class="btn btn-danger"><i class="fa fa-trash-o"></i> 선택상품삭제</a>
                                </div>
                                <div class="pull-right">
                                    <button class="btn btn-default" type="button" onclick="orderAdd('C');"><i class="fa fa-check-circle"></i> 선택상품주문</button>
                                    <button class="btn btn-primary" type="button" onclick="orderAdd('A');">전체상품주문 <i class="fa fa-chevron-right"></i></button>
                                </div>
                            </div>

                        </form>

                    </div>
                    <!-- /.box -->


<!--                     <div class="row same-height-row"> -->
<!--                         <div class="col-md-3 col-sm-6"> -->
<!--                             <div class="box same-height"> -->
<!--                                 <h3>You may also like these products</h3> -->
<!--                             </div> -->
<!--                         </div> -->

<!--                         <div class="col-md-3 col-sm-6"> -->
<!--                             <div class="product same-height"> -->
<!--                                 <div class="flip-container"> -->
<!--                                     <div class="flipper"> -->
<!--                                         <div class="front"> -->
<!--                                             <a href="detail.html"> -->
<%--                                                 <img src="${cpath}/include/obaju/img/product2.jpg" alt="" class="img-responsive"> --%>
<!--                                             </a> -->
<!--                                         </div> -->
<!--                                         <div class="back"> -->
<!--                                             <a href="detail.html"> -->
<%--                                                 <img src="${cpath}/include/obaju/img/product2_2.jpg" alt="" class="img-responsive"> --%>
<!--                                             </a> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                                 <a href="detail.html" class="invisible"> -->
<%--                                     <img src="${cpath}/include/obaju/img/product2.jpg" alt="" class="img-responsive"> --%>
<!--                                 </a> -->
<!--                                 <div class="text"> -->
<!--                                     <h3>Fur coat</h3> -->
<!--                                     <p class="price">$143</p> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                             /.product -->
<!--                         </div> -->

<!--                         <div class="col-md-3 col-sm-6"> -->
<!--                             <div class="product same-height"> -->
<!--                                 <div class="flip-container"> -->
<!--                                     <div class="flipper"> -->
<!--                                         <div class="front"> -->
<!--                                             <a href="detail.html"> -->
<%--                                                 <img src="${cpath}/include/obaju/img/product1.jpg" alt="" class="img-responsive"> --%>
<!--                                             </a> -->
<!--                                         </div> -->
<!--                                         <div class="back"> -->
<!--                                             <a href="detail.html"> -->
<%--                                                 <img src="${cpath}/include/obaju/img/product1_2.jpg" alt="" class="img-responsive"> --%>
<!--                                             </a> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                                 <a href="detail.html" class="invisible"> -->
<%--                                     <img src="${cpath}/include/obaju/img/product1.jpg" alt="" class="img-responsive"> --%>
<!--                                 </a> -->
<!--                                 <div class="text"> -->
<!--                                     <h3>Fur coat</h3> -->
<!--                                     <p class="price">$143</p> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                             /.product -->
<!--                         </div> -->


<!--                         <div class="col-md-3 col-sm-6"> -->
<!--                             <div class="product same-height"> -->
<!--                                 <div class="flip-container"> -->
<!--                                     <div class="flipper"> -->
<!--                                         <div class="front"> -->
<!--                                             <a href="detail.html"> -->
<%--                                                 <img src="${cpath}/include/obaju/img/product3.jpg" alt="" class="img-responsive"> --%>
<!--                                             </a> -->
<!--                                         </div> -->
<!--                                         <div class="back"> -->
<!--                                             <a href="detail.html"> -->
<%--                                                 <img src="${cpath}/include/obaju/img/product3_2.jpg" alt="" class="img-responsive"> --%>
<!--                                             </a> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                                 <a href="detail.html" class="invisible"> -->
<%--                                     <img src="${cpath}/include/obaju/img/product3.jpg" alt="" class="img-responsive"> --%>
<!--                                 </a> -->
<!--                                 <div class="text"> -->
<!--                                     <h3>Fur coat</h3> -->
<!--                                     <p class="price">$143</p> -->

<!--                                 </div> -->
<!--                             </div> -->
<!--                             /.product -->
<!--                         </div> -->

<!--                     </div> -->


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


<!--                     <div class="box"> -->
<!--                         <div class="box-header"> -->
<!--                             <h4>Coupon code</h4> -->
<!--                         </div> -->
<!--                         <p class="text-muted">If you have a coupon code, please enter it in the box below.</p> -->
<!--                         <form> -->
<!--                             <div class="input-group"> -->

<!--                                 <input type="text" class="form-control"> -->

<!--                                 <span class="input-group-btn"> -->

<!-- 					<button class="btn btn-primary" type="button"><i class="fa fa-gift"></i></button> -->

<!-- 				    </span> -->
<!--                             </div> -->
<!--                             /input-group -->
<!--                         </form> -->
<!--                     </div> -->

<!--                 </div> -->
                <!-- /.col-md-3 -->

            </div>
            <!-- /.container -->

        </div>
        <!-- /#content -->

		<!-- footer content -->
		<%@include file="/include/jsp/footer.jsp" %>
		<!-- /footer content -->

    </div>
    <!-- /#all -->



        <div class="modal fade" id="pro-modal" tabindex="-1" role="dialog" aria-labelledby="productoption" aria-hidden="true">
            <div class="modal-dialog modal-sm">

                <div class="modal-content">
                    <div class="modal-header" style="background:#4fbfa8">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">상품옵션선택</h4>
                    </div>
                    <div class="modal-body">
                        <form action="#" method="post" name="login_frm" id="login_frm">
                        	<select id="pro_select">
                        		<option value="">선택</option>
                        	</select>
                        </form>
                    </div>
                    <div class="modal-footer"></div>
                </div>
            </div>
        </div>
        
    

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