<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>

<%@include file="/include/jsp/commonhead.jsp"%>

<script type="text/javascript">
		$(function(){
			$('#sc_order').on('change',function(e){
				$('input[name="r_page"]').val( 1 );
				handling.submit('','productlist');
			});
		})
		
		function dataAjax(option){
			$.ajax(option);
		}
		
		function basketIn(r_prseq){
			var option = {
				async : false,
				data : 'r_prbprseq='+r_prseq,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( false == data.result ){
						alert('처리에 오류가 발생했습니다.');
					}else{
						alert('장바구니에 등록되었습니다.')
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
			dataHandling.submit('','productlist');
		}
		
		function setRowLimit( obj ){
			$('input[name="r_rowlimit"]').val( $(obj).val() );
			
			$('input[name="r_page"]').val( 1 );
			handling.submit('','productlist');
		}
		
		function productModal(r_prseq){
			
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
						alert('처리에 오류가 발생했습니다.');
					}
				},
				type : 'POST',
				url : '${cpath}/product/productviewajax'
			}
			
			$('#quick-view-modal').modal('show');
		}
	</script>
</head>

<body class="productPage">

	<%@include file="/include/jsp/header.jsp"%>

	<!-- catg header banner section -->
	<section id="aa-catg-head-banner">
		<img
			src="${cpath}/include/dailyshop/img/fashion/fashion-header-bg-8.jpg"
			alt="fashion img">
		<div class="aa-catg-head-banner-area">
			<div class="container">
				<div class="aa-catg-head-banner-content">
					<h2>Fashion</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">Women</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- / catg header banner section -->


	<!-- product category -->
	<section id="aa-product-category">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="aa-product-catg-content">

						<div class="aa-product-catg-head">
							<div class="aa-product-catg-head-left">
								<form action="" class="aa-sort-form">
									<label for="">Sort by</label> <select name="">
										<option value="1" selected="Default">Default</option>
										<option value="2">Name</option>
										<option value="3">Price</option>
										<option value="4">Date</option>
									</select>
								</form>
								<form action="" class="aa-show-form">
									<label for="">Show</label> 
									<select name="" onchange="setRowLimit(this)">
										<option value="3" <c:if test='${ 3 == model.r_rowlimit }'>selected="selected"</c:if> >3</option>
										<option value="12" <c:if test='${ 12 == model.r_rowlimit }'>selected="selected"</c:if> >12</option>
										<option value="24" <c:if test='${ 24 == model.r_rowlimit }'>selected="selected"</c:if> >24</option>
										<option value="36" <c:if test='${ 36 == model.r_rowlimit }'>selected="selected"</c:if> >36</option>
									</select>
								</form>
							</div>
							<div class="aa-product-catg-head-right">
								<a id="grid-catg" href="#"><span class="fa fa-th"></span></a> <a
									id="list-catg" href="#"><span class="fa fa-list"></span></a>
							</div>
						</div>

						<div class="aa-product-catg-body">
							<ul class="aa-product-catg">

								<c:forEach var="pr" items="${ model.productMap.productList }" varStatus="status">
									<!-- start single product item -->
									<li>
										<figure>
											<a class="aa-product-img" href="productview?r_prseq=${pr.PR_SEQ}">
												<img src="${cpath}/include/dailyshop/img/women/girl-1.png" alt="polo shirt img">
											</a>
											<a class="aa-add-card-btn" href="javascript:basketIn('${pr.PR_SEQ}')"><span class="fa fa-shopping-cart"></span>Add To Cart</a>
											<figcaption>
												<h4 class="aa-product-title">
													<a href="#">${ pr.PR_NAME }</a>
												</h4>
												<span class="aa-product-price"><fmt:formatNumber value="${ pr.PR_PRICE }" pattern="#,###" /></span> 
												<span class="aa-product-price"><del>$65.50</del></span>
												<p class="aa-product-descrip">Lorem ipsum dolor sit
													amet, consectetur adipisicing elit. Numquam accusamus
													facere iusto, autem soluta amet sapiente ratione inventore
													nesciunt a, maxime quasi consectetur, rerum illum.</p>
											</figcaption>
										</figure>
										<div class="aa-product-hvr-content">
											<a href="#" data-toggle="tooltip" data-placement="top" title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
											<a href="#" data-toggle="tooltip" data-placement="top" title="Compare"><span class="fa fa-exchange"></span></a> 
<!-- 											<a href="#" data-toggle2="tooltip" data-placement="top" title="Quick View" data-toggle="modal" data-target="#quick-view-modal"> -->
											<a href="#" data-toggle2="tooltip" data-placement="top" title="Quick View" data-toggle="modal" onclick="productModal('${pr.PR_SEQ}');return false;">
											<span class="fa fa-search"></span></a>
										</div> 
										<!-- product badge --> 
										<span class="aa-badge aa-sale" href="#">SALE!</span>
<!-- 										<span class="aa-badge aa-sold-out" href="#">Sold Out!</span> -->
<!-- 										<span class="aa-badge aa-hot" href="#">HOT!</span> -->
									</li>
								</c:forEach>

							</ul>
							<!-- quick view modal -->
							<div class="modal fade" id="quick-view-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-body">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
											<div class="row">
												<!-- Modal view slider -->
												<div class="col-md-6 col-sm-6 col-xs-12">
													<div class="aa-product-view-slider">
														<div class="simpleLens-gallery-container" id="demo-1">
															<div class="simpleLens-container">
																<div class="simpleLens-big-image-container">
																	<a class="simpleLens-lens-image" data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-1.png">
																		<img src="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-1.png" class="simpleLens-big-image">
																	</a>
																</div>
															</div>
															<div class="simpleLens-thumbnails-container">
																<a href="#" class="simpleLens-thumbnail-wrapper" data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-1.png" data-big-image="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-1.png">
																	<img src="${cpath}/include/dailyshop/img/view-slider/thumbnail/polo-shirt-1.png">
																</a>
																<a href="#" class="simpleLens-thumbnail-wrapper" data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-3.png" data-big-image="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-3.png">
																	<img src="${cpath}/include/dailyshop/img/view-slider/thumbnail/polo-shirt-3.png">
																</a> 
																<a href="#" class="simpleLens-thumbnail-wrapper" data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-4.png" data-big-image="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-4.png">
																	<img src="${cpath}/include/dailyshop/img/view-slider/thumbnail/polo-shirt-4.png">
																</a>
															</div>
														</div>
													</div>
												</div>
												<!-- Modal view content -->
												<div class="col-md-6 col-sm-6 col-xs-12">
													<div class="aa-product-view-content">
														<h3>T-Shirt</h3>
														<div class="aa-price-block">
															<span class="aa-product-view-price">$34.99</span>
															<p class="aa-product-avilability">
																Avilability: <span>In stock</span>
															</p>
														</div>
														<p>Lorem ipsum dolor sit amet, consectetur adipisicing
															elit. Officiis animi, veritatis quae repudiandae quod
															nulla porro quidem, itaque quis quaerat!</p>
														<h4>Size</h4>
														<div class="aa-prod-view-size">
															<a href="#">S</a> <a href="#">M</a> <a href="#">L</a> 
															<a href="#">XL</a>
														</div>
														<div class="aa-prod-quantity">
															<form action="">
																<select name="" id="">
																	<option value="0" selected="1">1</option>
																	<option value="1">2</option>
																	<option value="2">3</option>
																	<option value="3">4</option>
																	<option value="4">5</option>
																	<option value="5">6</option>
																</select>
															</form>
															<p class="aa-prod-category">
																Category: <a href="#">Polo T-Shirt</a>
															</p>
														</div>
														<div class="aa-prod-view-bottom">
															<a href="#" class="aa-add-to-cart-btn"><span class="fa fa-shopping-cart"></span>Add To Cart</a> 
															<a href="#" class="aa-add-to-cart-btn">View Details</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- / quick view modal -->
						</div>
						
						<%@ include file="/include/jsp/pager.jsp" %>
						
					</div>
				</div>


			</div>
		</div>
	</section>
	<!-- / product category -->

	<%@include file="/include/jsp/footer.jsp"%>

	<!-- To Slider JS -->
	<script src="${cpath}/include/dailyshop/js/sequence.js"></script>
	<script src="${cpath}/include/dailyshop/js/sequence-theme.modern-slide-in.js"></script>

</body>
</html>