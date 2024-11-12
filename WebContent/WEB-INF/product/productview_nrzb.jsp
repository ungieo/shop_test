<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    
    <script src="${ cpath }/include/soledot/js/soledot.js"></script>



	<script type="text/javascript">
	
		function dataAjax( option ){
			$.ajax(option);
		}
		function basketIn(r_prseq){
			
			var v_proseq = $('#v_proseq').val();
			var v_prea = $('#v_prea').val();
			if( v_proseq != undefined && '' == v_proseq ){
				alert('옵션을 선택해주십시오.');
				return false;
			}
			if( num_reg.test( v_prea ) || 1 > v_prea ){
				alert("수량은 1이상의 숫자만 입력됩니다.");
				$(obj).val(1);
				return false;
			}
			
			if( v_proseq == undefined ){
				v_proseq = '';
			}
			
			var param = 'r_prbprseq='+r_prseq+'&r_prbproseq='+v_proseq+'&r_prbea='+v_prea;
			
			var option = {
				async : false,
				data : param,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( false == data.result ){
						alert('처리에 오류가 발생했습니다.');
//		 				alert( data.ss_mbid );
//		 				alert('success='+data.msg);
					}else{
						alert( data.msg );
						$('#basketCnt').text(data.basketCnt);
					}
				},
				type : 'POST',
				url : '${cpath}/productbasket/productbasketinajax'
			}
			dataAjax( option );
			
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
						alert(data.msg);
					}else{
						alert(data.msg);
					}
				},
				type : 'POST',
				url : '${cpath}/productwish/productwishinajax'
			}
			dataAjax( option );
			
		}
		
		var num_reg = /[^\d]/;
		
		function ordermainAdd(){
			var v_proseq = $('#v_proseq').val();
			var v_prea = $('#v_prea').val();
			if( v_proseq != undefined && '' == v_proseq ){
				alert('옵션을 선택해주십시오.');
				return false;
			}
			if( num_reg.test( v_prea ) || 1 > v_prea ){
				alert("수량은 1이상의 숫자만 입력됩니다.");
				$('#v_prea').val(1);
				return false;
			}
			$('#r_proseq').val();
			$('#r_prea').val();
			
			handling.submit('','${cpath}/ordermain/ordermainadd')
		}
		
		function eaCheck(obj){
			if( num_reg.test( $(obj).val() ) ){
				alert("수량은 숫자만 입력됩니다.");
				$(obj).val(1);
				return false;
			}
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
                        <li><a href="${cpath}/nrzb/index">Home</a></li>
                        <li><a href="productlist?r_prcseq=${ model.productcategory.PRC_GNUM1 }&r_prclevel=1">${ model.productcategory.PRC_NAME1 }</a></li>
                        <c:if test="${ model.productcategory.PRC_LEVEL > 1 }">
                        	<li><a href="productlist?r_prcseq=${ model.productcategory.PRC_GNUM2 }&r_prclevel=2">${ model.productcategory.PRC_NAME2 }</a></li>
                        </c:if>
                        <c:if test="${ model.productcategory.PRC_LEVEL > 2 }">
							<li><a href="productlist?r_prcseq=${ model.productcategory.PRC_GNUM3 }&r_prclevel=3">${ model.productcategory.PRC_NAME3 }</a></li>
                        </c:if>
                        <c:if test="${ model.productcategory.PRC_LEVEL > 3 }">
							<li><a href="productlist?r_prcseq=${ model.productcategory.PRC_GNUM4 }&r_prclevel=4">${ model.productcategory.PRC_NAME }</a></li>
                        </c:if>
                    </ul>

                </div>


                <div class="col-md-12">
                
                	<form action="" id="frm" name="frm" method="post">
                		<input name="r_prseq" type="hidden" />
                		<input name="r_proseq" type="hidden" />
                	</form> 

                    <div class="row" id="productMain">
                        <div class="col-sm-6">
                            <div id="mainImage">
                                <img src="${cpath}/data/up/product/${model.product.PR_IMAGE1}" alt="" class="img-responsive">
                            </div>

<!--                             <div class="ribbon sale"> -->
<!--                                 <div class="theribbon">SALE</div> -->
<!--                                 <div class="ribbon-background"></div> -->
<!--                             </div> -->

                            <!-- /.ribbon -->
                            <%
                            	Calendar cal = Calendar.getInstance();
                            	cal.add( Calendar.DATE, -7 );
                            	java.util.Date date1 = cal.getTime();
                            %>
                            <fmt:formatDate var="preWeek" value="<%=date1%>" pattern="yyyy-MM-dd" />
							<c:if test="${ preWeek <= fn:substring( model.product.PR_INDATE, 0, 10 ) }">
                            <div class="ribbon new">
                                <div class="theribbon">NEW</div>
                                <div class="ribbon-background"></div>
                            </div>
                            </c:if>
                            <!-- /.ribbon -->

                        </div>
                        <div class="col-sm-6">
                            <div class="box">
                                <h2 class="text-center"><strong>${ model.product.PR_NAME }</strong></h2>
<!--                                 <p class="goToDescription"><a href="#details" class="scroll-to">Scroll to product details, material & care and sizing</a></p> -->
								<hr />
<!--                                 <div class="col-sm-4"> -->
<!--                                 	<p>상품가격</p> -->
<!--                                 	<p>상품코드</p> -->
<!--                                 	<p>상품가격</p> -->
<!--                                 </div> -->
<!--                                 <div class="col-sm-8"> -->
<%--                                 	<p><fmt:formatNumber value="${ model.product.PR_PRICE }" pattern="#,###"/></p> --%>
<%--                                 	<p>${ model.product.PR_CODE }</p> --%>
<%--                                 	<p><fmt:formatNumber value="${ model.product.PR_PRICE }" pattern="#,###"/></p> --%>
<!--                                 </div> -->
                                
                                <div class="col-sm-4"><h5><strong>판매가</strong></h5></div>
                                <div class="col-sm-8"><h5><fmt:formatNumber value="${ model.product.PR_PRICE }" pattern="#,###"/></h5></div>
                                <div class="col-sm-4"><h5><strong>상품코드</strong></h5></div>
                                <div class="col-sm-8"><h5>${ model.product.PR_CODE }</h5></div>
<!--                                 <div class="col-sm-4"><h5>브랜드</h5></div> -->
<%--                                 <div class="col-sm-8"><h5>${ model.product.PR_BRAND }</h5></div> --%>
                                <div class="col-sm-4"><h5><strong>모델명</strong></h5></div>
                                <div class="col-sm-8"><h5>${ model.product.PR_MODEL }</h5></div>
                                
<!--                                 <div class="col-sm-4"><h5>단위</h5></div> -->
<%--                                 <div class="col-sm-8"><h5>${ model.product.PR_MODEL }</h5></div> --%>
<!--                                 <div class="col-sm-4"><h5>사이즈</h5></div> -->
<%--                                 <div class="col-sm-8"><h5>${ model.product.PR_MODEL }</h5></div> --%>
                                
                                <c:if test="${ !empty model.productoptionList }">
	                                <div class="col-sm-4"><h5><strong>${ model.productoptionList[0].PRO_GNAME }</strong></h5></div>
	                                <div class="col-sm-8">
	                                	<select class="form-control" name="v_proseq" id="v_proseq">
	                                		<option value="">선택</option>
	                                		<c:forEach var="pro" items="${ model.productoptionList }">
	                                			<option value="${ pro.PRO_SEQ }">${ pro.PRO_NAME }</option>
	                                		</c:forEach>
	                                	</select>
	                                </div>
                                </c:if>
                                <div class="clearfix"></div>
                                
                                <div class="col-sm-4"><h5><strong>수량</strong></h5></div>
                                <div class="col-sm-8"><input class="form-control" name="v_prea" id="v_prea" type="number" value="1" onchange="eaCheck(this);"/></div>
                                
                                <div class="clearfix"></div>
                                <hr />
                                
                                <p class="text-center buttons">
                                	<a href="#" onclick="ordermainAdd('${ model.product.PR_SEQ }');return false;" class="btn btn-success"><i class="fa fa-share"></i> <small>바로구매</small></a>
                                    <a href="#" onclick="basketIn('${ model.product.PR_SEQ }');return false;" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> <small>장바구니담기</small></a> 
                                    <a href="#" onclick="wishIn('${ model.product.PR_SEQ }');return false;" class="btn btn-info"><i class="fa fa-heart"></i> <small>관심상품담기</small></a>
                                    <a href="javascript:history.back();;" class="btn btn-warning"><i class="fa fa-reply"></i> <small>상품목록</small></a>
                                </p>


                            </div>

                            <div class="row" id="thumbs">
                                <div class="col-xs-4">
                                    <a href="${cpath}/data/up/product/${model.product.PR_IMAGE1}" class="thumb">
                                        <img src="${cpath}/data/up/product/${model.product.PR_IMAGE1}" alt="" class="img-responsive">
                                    </a>
                                </div>
                                <div class="col-xs-4">
                                    <a href="${cpath}/data/up/product/${model.product.PR_IMAGE2}" class="thumb">
                                        <img src="${cpath}/data/up/product/${model.product.PR_IMAGE2}" alt="" class="img-responsive">
                                    </a>
                                </div>
                                <div class="col-xs-4">
                                    <a href="${cpath}/data/up/product/${model.product.PR_IMAGE3}" class="thumb">
                                        <img src="${cpath}/data/up/product/${model.product.PR_IMAGE3}" alt="" class="img-responsive">
                                    </a>
                                </div>
                            </div>
                        </div>

                    </div>


                    <div class="box" id="details">
                        <p>
                            ${ model.product.PR_CONTENT }

                            <hr>
                            <div class="social">
                                <h4>Show it to your friends</h4>
                                <p>
                                    <a href="#" class="external facebook" data-animate-hover="pulse"><i class="fa fa-facebook"></i></a>
                                    <a href="#" class="external gplus" data-animate-hover="pulse"><i class="fa fa-google-plus"></i></a>
                                    <a href="#" class="external twitter" data-animate-hover="pulse"><i class="fa fa-twitter"></i></a>
<!--                                     <a href="#" class="email" data-animate-hover="pulse"><i class="fa fa-envelope"></i></a> -->
                                </p>
                            </div>
                    </div>

					<c:if test="${ !empty model.productgroupMap1.productList }">
					
                    <div class="row same-height-row">
                        <div class="col-md-3 col-sm-6">
                            <div class="box same-height">
                                <h3>You may also like these products</h3>
                            </div>
                        </div>
                        
                        <c:forEach var="prg1" items="${ model.productgroupMap1.productList }">

                        <div class="col-md-3 col-sm-6">
                            <div class="product same-height">
                                <div class="flip-container">
                                    <div class="flipper">
                                        <div class="front">
                                            <a href="detail.html">
                                                <img src="${cpath}/data/up/product/${prg1.PR_IMAGE1}" alt="" class="img-responsive">
                                            </a>
                                        </div>
                                        <div class="back">
                                            <a href="${cpath}/product/productview?r_prseq=${prg1.PR_SEQ}">
                                                <img src="${cpath}/data/up/product/${prg1.PR_IMAGE2}" alt="" class="img-responsive">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <a href="${cpath}/product/productview?r_prseq=${prg1.PR_SEQ}" class="invisible">
                                    <img src="${cpath}/data/up/product/${prg1.PR_IMAGE1}" alt="" class="img-responsive">
                                </a>
                                <div class="text">
                                    <h3>${ prg1.PR_NAME }</h3>
                                    <p class="price"><fmt:formatNumber value="${ prg1.PR_PRICE }" pattern="#,###"/></p>
                                </div>
                            </div>
                            <!-- /.product -->
                        </div>
                        
                        </c:forEach>

                    </div>
                    
                    </c:if>

					<c:if test="${ !empty model.productgroupMap2.productList }">
					
                    <div class="row same-height-row">
                        <div class="col-md-3 col-sm-6">
                            <div class="box same-height">
                                <h3>Products viewed recently</h3>
                            </div>
                        </div>

						<c:forEach var="prg2" items="${ model.productgroupMap2.productList }">
						
                        <div class="col-md-3 col-sm-6">
                            <div class="product same-height">
                                <div class="flip-container">
                                    <div class="flipper">
                                        <div class="front">
                                            <a href="${cpath}/product/productview?r_prseq=${prg2.PR_SEQ}">
                                                <img src="${cpath}/data/up/product/${prg2.PR_IMAGE1}" alt="" class="img-responsive">
                                            </a>
                                        </div>
                                        <div class="back">
                                            <a href="${cpath}/product/productview?r_prseq=${prg2.PR_SEQ}">
                                                <img src="${cpath}/data/up/product/${prg2.PR_IMAGE2}" alt="" class="img-responsive">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <a href="${cpath}/product/productview?r_prseq=${prg2.PR_SEQ}" class="invisible">
                                    <img src="${cpath}/data/up/product/${prg2.PR_IMAGE1}" alt="" class="img-responsive">
                                </a>
                                <div class="text">
                                    <h3>${ prg2.PR_NAME }</h3>
                                    <p class="price"><fmt:formatNumber value="${ prg2.PR_PRICE }" pattern="#,###"/></p>
                                </div>
                            </div>
                            <!-- /.product -->
                        </div>

						</c:forEach>

                    </div>
                    
                    </c:if>

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
    <script src="${cpath}/include/obaju/js/jquery-1.11.0.min.js"></script>
    <script src="${cpath}/include/obaju/js/bootstrap.min.js"></script>
    <script src="${cpath}/include/obaju/js/jquery.cookie.js"></script>
    <script src="${cpath}/include/obaju/js/waypoints.min.js"></script>
    <script src="${cpath}/include/obaju/js/modernizr.js"></script>
    <script src="${cpath}/include/obaju/js/bootstrap-hover-dropdown.js"></script>
    <script src="${cpath}/include/obaju/js/owl.carousel.min.js"></script>
    <script src="${cpath}/include/obaju/js/front.js"></script>


</body>

</html>