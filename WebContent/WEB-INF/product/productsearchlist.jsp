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
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>Welcome NRZB!</title>

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
    
    <script src="${ cpath }/include/soledot/js/soledot.js"></script>

    <link rel="shortcut icon" href="favicon.png">

	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>
	
	<script type="text/javascript">
		$(function(){
			$('#sc_order').on('change',function(e){
				$('input[name="r_page"]').val( 1 );
				handling.submit('','productsearchlist');
			});
		})
		
		function dataAjax( option ){
			$.ajax(option);
		}
		function basketIn(r_prseq){
				
			var option = {
				async : false,
				data : 'r_prseq='+r_prseq,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( false == data.success ){
						alert('처리에 오류가 발생했습니다.');
//		 				alert( data.ss_mbid );
//		 				alert('success='+data.msg);
					}else{
						$('#basketCnt').text(data.basketCnt+' in cart' );
					}
				},
				type : 'POST',
				url : '${cpath}/productbasket/productbasketinajax'
			}
			dataAjax( option );
			
		}
		
		function setInput( r_input, value ){
			$('input[name="'+r_input+'"]').val(value);
			dataHandling.submit('','productsearchlist');
		}
		
		function setRowLimit( obj ){
			$('input[name="r_rowlimit"]').val( $(obj).text() );
			$(obj).addClass('btn-primary');
			$(obj).siblings('a').removeClass('btn-primary');
			
			$('input[name="r_page"]').val( 1 );
			handling.submit('','productsearchlist');
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
                        <li>상품검색</li>
                    </ul>

                    <div class="box">
                    	<h2>Product Search</h2>
                    </div>

                    <div class="box info-bar">
                        <div class="row">
                            <div class="col-sm-12 col-md-4 products-showing">
<%--                                 Showing <strong>${ model.r_page * fn:length(model.productMap.productList) }</strong> of  --%>
                                Total <strong>${model.totCnt }</strong> products
                            </div>

                            <div class="col-sm-12 col-md-8  products-number-sort">
                                <div class="row">
                                    <form action="productsearchlist" class="form-inline" name="frm" method="post" >
                                    	<input name="r_page" type="hidden" value="${ model.r_page }" />
										<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
										<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />
								
										<input id="r_prseq" name="r_prseq" type="hidden" value="" />
										<input name="r_prseqarr" type="hidden" />
										<input name="r_prcseq" type="hidden" value="${ param.r_prcseq }"/>
										<input name="r_prclevel" type="hidden" value="${ param.r_prclevel }"/>
										
										<input name="sc_column" type="hidden" value="${ param.sc_column }"/>
										<input name="sc_word" type="hidden" value="${param.sc_word}"/>
										
                                        <div class="col-md-6 col-sm-6">
                                            <div class="products-number">
                                                <strong>Show</strong>  
                                                <a href="#" class="btn btn-default btn-sm <c:if test='${ 12 == model.r_rowlimit }'>btn-primary</c:if>" onclick="setRowLimit(this);return false;">12</a>  
                                                <a href="#" class="btn btn-default btn-sm <c:if test='${ 24 == model.r_rowlimit }'>btn-primary</c:if>" onclick="setRowLimit(this);return false;">24</a> products  
<!--                                                 <a href="#" class="btn btn-default btn-sm">All</a> -->
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-sm-6">
                                            <div class="products-sort-by">
                                                <strong>정렬</strong>
                                                <select class="form-control" name="sc_order" id="sc_order">
                                                    <option value="pr_seq desc" <c:if test="${ param.sc_order eq 'pr_seq desc' }">selected="selected"</c:if> >신상품순</option>
                                                    <option value="pr_price desc" <c:if test="${ param.sc_order eq 'pr_price desc' }">selected="selected"</c:if> >가격높은순</option>
                                                    <option value="pr_price" <c:if test="${ param.sc_order eq 'pr_price' }">selected="selected"</c:if> >가격낮은순</option>
                                                    <option value="pr_name" <c:if test="${ param.sc_order eq 'pr_name' }">selected="selected"</c:if> >상품명</option>
<%--                                                     <option value="pr_name" <c:if test="${ param.sc_order eq 'pr_seq desc' }"></c:if> >판매순위</option> --%>
<!--                                                     <option value="pr_name asc">상품평</option> -->
                                                </select>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row products">
                    
                    
                    	<c:forEach var="pr" items="${ model.productMap.productList }" varStatus="status">
                        <div class="col-md-3 col-sm-4">
                            <div class="product">
                                <div class="flip-container">
                                    <div class="flipper">
                                        <div class="front">
                                            <a href="productview?r_prseq=${pr.PR_SEQ}">
                                                <img src="${cpath}/data/up/product/${pr.PR_IMAGE1}" alt="" class="img-responsive">
                                            </a>
                                        </div>
                                        <div class="back">
                                            <a href="productview?r_prseq=${pr.PR_SEQ}">
                                                <img src="${cpath}/data/up/product/${pr.PR_IMAGE2}" alt="" class="img-responsive">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <a href="productview?r_prseq=${pr.PR_SEQ}" class="invisible">
                                    <img src="${cpath}/data/up/product/${pr.PR_IMAGE1}" alt="" class="img-responsive">
                                </a>
                                <div class="text">
                                    <h3><a href="productview?r_prseq=${pr.PR_SEQ}">${pr.PR_NAME}</a></h3>
                                    <p class="price">${pr.PR_PRICE}</p>
                                    <p class="buttons">
                                        <a href="productview?r_prseq=${pr.PR_SEQ}" class="btn btn-default">View detail</a>
                                        <a href="javascript:basketIn('${pr.PR_SEQ}')" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </p>
                                </div>
                                <!-- /.text -->
                            </div>
                            <!-- /.product -->
                        </div>
                    	</c:forEach>


                    </div>
                    <!-- /.products -->

                    <%@ include file="/include/jsp/pager.jsp" %>

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
<%--     <script src="${cpath}/include/obaju/js/jquery-1.11.0.min.js"></script> --%>
    <script src="${cpath}/include/obaju/js/bootstrap.min.js"></script>
    <script src="${cpath}/include/obaju/js/jquery.cookie.js"></script>
    <script src="${cpath}/include/obaju/js/waypoints.min.js"></script>
    <script src="${cpath}/include/obaju/js/modernizr.js"></script>
    <script src="${cpath}/include/obaju/js/bootstrap-hover-dropdown.js"></script>
    <script src="${cpath}/include/obaju/js/owl.carousel.min.js"></script>
    <script src="${cpath}/include/obaju/js/front.js"></script>


</body>

</html>