<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>

	<%@include file="/include/jsp/commonhead.jsp"%>
	
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
	//	 				alert( data.ss_mbid );
	//	 				alert('success='+data.msg);
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

	<%@include file="/include/jsp/header.jsp"%>

	<!-- catg header banner section -->
	<section id="aa-catg-head-banner">
		<img src="${cpath}/include/dailyshop/img/fashion/fashion-header-bg-8.jpg" alt="fashion img">
		<div class="aa-catg-head-banner-area">
			<div class="container">
				<div class="aa-catg-head-banner-content">
					<h2>${ model.productcategory.PRC_NAME }</h2>
					<ol class="breadcrumb">
<!-- 						<li><a href="index.html">Home</a></li> -->
						<li><a href="#">${ model.productcategory.PRC_NAME1 }</a></li>
						<li><a href="#">${ model.productcategory.PRC_NAME2 }</a></li>
						<li><a href="#">${ model.productcategory.PRC_NAME3 }</a></li>
						<li class="active">${ model.productcategory.PRC_NAME }</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- / catg header banner section -->

	<!-- product category -->
	<section id="aa-product-details">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-product-details-area">
						<div class="aa-product-details-content">
							<div class="row">
								<!-- Modal view slider -->
								<div class="col-md-5 col-sm-5 col-xs-12">
									<div class="aa-product-view-slider">
										<div id="demo-1" class="simpleLens-gallery-container">
											<div class="simpleLens-container">
												<div class="simpleLens-big-image-container">
													<a data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-1.png" class="simpleLens-lens-image">
														<img src="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-1.png" class="simpleLens-big-image">
<%-- 														<img src="${cpath}/data/up/product/${model.product.PR_IMAGE1}" /> --%>
													</a>
												</div>
											</div>
											<div class="simpleLens-thumbnails-container">
												<a data-big-image="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-1.png" data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-1.png" class="simpleLens-thumbnail-wrapper" href="#"> 
													<img src="${cpath}/include/dailyshop/img/view-slider/thumbnail/polo-shirt-1.png">
<%-- 													<img src="${cpath}/data/up/product/${model.product.PR_IMAGE2}" /> --%>
												</a> 
												<a data-big-image="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-3.png" data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-3.png" class="simpleLens-thumbnail-wrapper" href="#"> 
													<img src="${cpath}/include/dailyshop/img/view-slider/thumbnail/polo-shirt-3.png">
<%-- 													<img src="${cpath}/data/up/product/${model.product.PR_IMAGE3}" /> --%>
												</a> 
												<a data-big-image="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-4.png" data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-4.png" class="simpleLens-thumbnail-wrapper" href="#"> 
													<img src="${cpath}/include/dailyshop/img/view-slider/thumbnail/polo-shirt-4.png">
<%-- 													<img src="${cpath}/data/up/product/${model.product.PR_IMAGE4}" /> --%>
												</a>
											</div>
										</div>
									</div>
								</div>
								<!-- Modal view content -->
								<div class="col-md-7 col-sm-7 col-xs-12">
									<div class="aa-product-view-content">
										<h3>${model.product.PR_NAME }</h3>
										<div class="aa-price-block">
											<span class="aa-product-view-price">${model.product.PR_PRICE }</span>
											<p class="aa-product-avilability">Avilability: <span>In stock</span></p>
										</div>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit. Officiis animi, veritatis quae repudiandae quod nulla
											porro quidem, itaque quis quaerat!</p>
										<h4>Size</h4>
										<div class="aa-prod-view-size">
											<a href="#">S</a> 
											<a href="#">M</a> 
											<a href="#">L</a> 
											<a href="#">XL</a>
										</div>
										<h4>Color</h4>
										<div class="aa-color-tag">
											<a href="#" class="aa-color-green"></a> 
											<a href="#" class="aa-color-yellow"></a> 
											<a href="#" class="aa-color-pink"></a> 
											<a href="#" class="aa-color-black"></a> 
											<a href="#" class="aa-color-white"></a>
										</div>
										<div class="aa-prod-quantity">
											<form action="">
												<select id="" name="">
													<option selected="1" value="0">1</option>
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
											<a class="aa-add-to-cart-btn" href="basketIn('${ model.product.PR_SEQ }');return false;">Add To Cart</a> 
											<a class="aa-add-to-cart-btn" href="wishIn('${ model.product.PR_SEQ }');return false;">Wishlist</a> 
<!-- 											<a class="aa-add-to-cart-btn" href="#">Compare</a> -->
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="aa-product-details-bottom">
							<ul class="nav nav-tabs" id="myTab2">
								<li><a href="#description" data-toggle="tab">Description</a></li>
								<li><a href="#review" data-toggle="tab">Reviews</a></li>
							</ul>

							<!-- Tab panes -->
							<div class="tab-content">
								<div class="tab-pane fade in active" id="description">${model.product.PR_CONTENT }</div>
								<div class="tab-pane fade " id="review">
									<div class="aa-product-review-area">
										<h4>2 Reviews for T-Shirt</h4>
										<ul class="aa-review-nav">
											<li>
												<div class="media">
													<div class="media-left">
														<a href="#">
															<img class="media-object" src="${cpath}/include/dailyshop/img/testimonial-img-3.jpg" alt="girl image">
														</a>
													</div>
													<div class="media-body">
														<h4 class="media-heading">
															<strong>Marla Jobs</strong> - <span>March 26, 2016</span>
														</h4>
														<div class="aa-product-rating">
															<span class="fa fa-star"></span> <span class="fa fa-star"></span>
															<span class="fa fa-star"></span> <span class="fa fa-star"></span>
															<span class="fa fa-star-o"></span>
														</div>
														<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
													</div>
												</div>
											</li>
											<li>
												<div class="media">
													<div class="media-left">
														<a href="#"> 
															<img class="media-object" src="${cpath}/include/dailyshop/img/testimonial-img-3.jpg" alt="girl image">
														</a>
													</div>
													<div class="media-body">
														<h4 class="media-heading">
															<strong>Marla Jobs</strong> - <span>March 26, 2016</span>
														</h4>
														<div class="aa-product-rating">
															<span class="fa fa-star"></span> <span class="fa fa-star"></span>
															<span class="fa fa-star"></span> <span class="fa fa-star"></span>
															<span class="fa fa-star-o"></span>
														</div>
														<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
													</div>
												</div>
											</li>
										</ul>
										<h4>Add a review</h4>
										<div class="aa-your-rating">
											<p>Your Rating</p>
											<a href="#"><span class="fa fa-star-o"></span></a> 
											<a href="#"><span class="fa fa-star-o"></span></a> 
											<a href="#"><span class="fa fa-star-o"></span></a> 
											<a href="#"><span class="fa fa-star-o"></span></a> 
											<a href="#"><span class="fa fa-star-o"></span></a>
										</div>
										<!-- review form -->
										<form action="" class="aa-review-form">
											<div class="form-group">
												<label for="message">Your Review</label>
												<textarea class="form-control" rows="3" id="message"></textarea>
											</div>
											<div class="form-group">
												<label for="name">Name</label> <input type="text"
													class="form-control" id="name" placeholder="Name">
											</div>
											<div class="form-group">
												<label for="email">Email</label> 
												<input type="email" class="form-control" id="email" placeholder="example@gmail.com">
											</div>
											<button type="submit" class="btn btn-default aa-review-submit">Submit</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						<!-- Related product -->
						<div class="aa-product-related-item">
							<h3>Related Products</h3>
							<ul class="aa-product-catg aa-related-item-slider">
								<!-- start single product item -->
								<li>
									<figure>
										<a class="aa-product-img" href="#">
											<img src="${cpath}/include/dailyshop/img/man/polo-shirt-2.png" alt="polo shirt img">
										</a>
										<a class="aa-add-card-btn" href="#">
											<span class="fa fa-shopping-cart"></span>Add To Cart
										</a>
										<figcaption>
											<h4 class="aa-product-title">
												<a href="#">Polo T-Shirt</a>
											</h4>
											<span class="aa-product-price">$45.50</span>
											<span class="aa-product-price"><del>$65.50</del></span>
										</figcaption>
									</figure>
									<div class="aa-product-hvr-content">
										<a href="#" data-toggle="tooltip" data-placement="top" title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
										<a href="#" data-toggle="tooltip" data-placement="top" title="Compare"><span class="fa fa-exchange"></span></a> 
										<a href="#" data-toggle2="tooltip" data-placement="top" title="Quick View" data-toggle="modal" data-target="#quick-view-modal">
											<span class="fa fa-search"></span>
										</a>
									</div> <!-- product badge --> <span class="aa-badge aa-sale" href="#">SALE!</span>
								</li>
								<!-- start single product item -->
								<li>
									<figure>
										<a class="aa-product-img" href="#"><img src="${cpath}/include/dailyshop/img/women/girl-2.png" alt="polo shirt img"></a>
										<a class="aa-add-card-btn" href="#"><span class="fa fa-shopping-cart"></span>Add To Cart</a>
										<figcaption>
											<h4 class="aa-product-title">
												<a href="#">Lorem ipsum doller</a>
											</h4>
											<span class="aa-product-price">$45.50</span>
										</figcaption>
									</figure>
									<div class="aa-product-hvr-content">
										<a href="#" data-toggle="tooltip" data-placement="top" title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
										<a href="#" data-toggle="tooltip" data-placement="top" title="Compare"><span class="fa fa-exchange"></span></a> 
										<a href="#" data-toggle2="tooltip" data-placement="top" title="Quick View" data-toggle="modal" data-target="#quick-view-modal">
										<span class="fa fa-search"></span></a>
									</div> <!-- product badge --> 
									<span class="aa-badge aa-sold-out" href="#">Sold Out!</span>
								</li>
								<!-- start single product item -->
								<li>
									<figure>
										<a class="aa-product-img" href="#"><img
											src="${cpath}/include/dailyshop/img/man/t-shirt-1.png"
											alt="polo shirt img"></a>
										<a class="aa-add-card-btn" href="#"><span
											class="fa fa-shopping-cart"></span>Add To Cart</a>
									</figure>
									<figcaption>
										<h4 class="aa-product-title">
											<a href="#">T-Shirt</a>
										</h4>
										<span class="aa-product-price">$45.50</span>
									</figcaption>
									<div class="aa-product-hvr-content">
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Compare"><span class="fa fa-exchange"></span></a> <a
											href="#" data-toggle2="tooltip" data-placement="top"
											title="Quick View" data-toggle="modal"
											data-target="#quick-view-modal"><span
											class="fa fa-search"></span></a>
									</div> <!-- product badge --> <span class="aa-badge aa-hot" href="#">HOT!</span>
								</li>
								<!-- start single product item -->
								<li>
									<figure>
										<a class="aa-product-img" href="#"><img
											src="${cpath}/include/dailyshop/img/women/girl-3.png"
											alt="polo shirt img"></a>
										<a class="aa-add-card-btn" href="#"><span
											class="fa fa-shopping-cart"></span>Add To Cart</a>
										<figcaption>
											<h4 class="aa-product-title">
												<a href="#">Lorem ipsum doller</a>
											</h4>
											<span class="aa-product-price">$45.50</span><span
												class="aa-product-price"><del>$65.50</del></span>
										</figcaption>
									</figure>
									<div class="aa-product-hvr-content">
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Compare"><span class="fa fa-exchange"></span></a> <a
											href="#" data-toggle2="tooltip" data-placement="top"
											title="Quick View" data-toggle="modal"
											data-target="#quick-view-modal"><span
											class="fa fa-search"></span></a>
									</div>
								</li>
								<!-- start single product item -->
								<li>
									<figure>
										<a class="aa-product-img" href="#"><img
											src="${cpath}/include/dailyshop/img/man/polo-shirt-1.png"
											alt="polo shirt img"></a>
										<a class="aa-add-card-btn" href="#"><span
											class="fa fa-shopping-cart"></span>Add To Cart</a>
										<figcaption>
											<h4 class="aa-product-title">
												<a href="#">Polo T-Shirt</a>
											</h4>
											<span class="aa-product-price">$45.50</span><span
												class="aa-product-price"><del>$65.50</del></span>
										</figcaption>
									</figure>
									<div class="aa-product-hvr-content">
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Compare"><span class="fa fa-exchange"></span></a> <a
											href="#" data-toggle2="tooltip" data-placement="top"
											title="Quick View" data-toggle="modal"
											data-target="#quick-view-modal"><span
											class="fa fa-search"></span></a>
									</div>
								</li>
								<!-- start single product item -->
								<li>
									<figure>
										<a class="aa-product-img" href="#"><img
											src="${cpath}/include/dailyshop/img/women/girl-4.png"
											alt="polo shirt img"></a>
										<a class="aa-add-card-btn" href="#"><span
											class="fa fa-shopping-cart"></span>Add To Cart</a>
										<figcaption>
											<h4 class="aa-product-title">
												<a href="#">Lorem ipsum doller</a>
											</h4>
											<span class="aa-product-price">$45.50</span><span
												class="aa-product-price"><del>$65.50</del></span>
										</figcaption>
									</figure>
									<div class="aa-product-hvr-content">
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Compare"><span class="fa fa-exchange"></span></a> <a
											href="#" data-toggle2="tooltip" data-placement="top"
											title="Quick View" data-toggle="modal"
											data-target="#quick-view-modal"><span
											class="fa fa-search"></span></a>
									</div> <!-- product badge --> <span class="aa-badge aa-sold-out"
									href="#">Sold Out!</span>
								</li>
								<!-- start single product item -->
								<li>
									<figure>
										<a class="aa-product-img" href="#"><img
											src="${cpath}/include/dailyshop/img/man/polo-shirt-4.png"
											alt="polo shirt img"></a>
										<a class="aa-add-card-btn" href="#"><span
											class="fa fa-shopping-cart"></span>Add To Cart</a>
										<figcaption>
											<h4 class="aa-product-title">
												<a href="#">Polo T-Shirt</a>
											</h4>
											<span class="aa-product-price">$45.50</span><span
												class="aa-product-price"><del>$65.50</del></span>
										</figcaption>
									</figure>
									<div class="aa-product-hvr-content">
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Compare"><span class="fa fa-exchange"></span></a> <a
											href="#" data-toggle2="tooltip" data-placement="top"
											title="Quick View" data-toggle="modal"
											data-target="#quick-view-modal"><span
											class="fa fa-search"></span></a>
									</div> <!-- product badge --> <span class="aa-badge aa-hot" href="#">HOT!</span>
								</li>
								<!-- start single product item -->
								<li>
									<figure>
										<a class="aa-product-img" href="#"><img
											src="${cpath}/include/dailyshop/img/women/girl-1.png"
											alt="polo shirt img"></a>
										<a class="aa-add-card-btn" href="#"><span
											class="fa fa-shopping-cart"></span>Add To Cart</a>
										<figcaption>
											<h4 class="aa-product-title">
												<a href="#">This is Title</a>
											</h4>
											<span class="aa-product-price">$45.50</span><span
												class="aa-product-price"><del>$65.50</del></span>
										</figcaption>
									</figure>
									<div class="aa-product-hvr-content">
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
										<a href="#" data-toggle="tooltip" data-placement="top"
											title="Compare"><span class="fa fa-exchange"></span></a> <a
											href="#" data-toggle2="tooltip" data-placement="top"
											title="Quick View" data-toggle="modal"
											data-target="#quick-view-modal"><span
											class="fa fa-search"></span></a>
									</div> <!-- product badge --> <span class="aa-badge aa-sale" href="#">SALE!</span>
								</li>
							</ul>
							<!-- quick view modal -->
							<div class="modal fade" id="quick-view-modal" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-body">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<div class="row">
												<!-- Modal view slider -->
												<div class="col-md-6 col-sm-6 col-xs-12">
													<div class="aa-product-view-slider">
														<div class="simpleLens-gallery-container" id="demo-1">
															<div class="simpleLens-container">
																<div class="simpleLens-big-image-container">
																	<a class="simpleLens-lens-image"
																		data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-1.png">
																		<img
																		src="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-1.png"
																		class="simpleLens-big-image">
																	</a>
																</div>
															</div>
															<div class="simpleLens-thumbnails-container">
																<a href="#" class="simpleLens-thumbnail-wrapper"
																	data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-1.png"
																	data-big-image="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-1.png">
																	<img
																	src="${cpath}/include/dailyshop/img/view-slider/thumbnail/polo-shirt-1.png">
																</a> <a href="#" class="simpleLens-thumbnail-wrapper"
																	data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-3.png"
																	data-big-image="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-3.png">
																	<img
																	src="${cpath}/include/dailyshop/img/view-slider/thumbnail/polo-shirt-3.png">
																</a> <a href="#" class="simpleLens-thumbnail-wrapper"
																	data-lens-image="${cpath}/include/dailyshop/img/view-slider/large/polo-shirt-4.png"
																	data-big-image="${cpath}/include/dailyshop/img/view-slider/medium/polo-shirt-4.png">
																	<img
																	src="${cpath}/include/dailyshop/img/view-slider/thumbnail/polo-shirt-4.png">
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
															<a href="#">S</a> <a href="#">M</a> <a href="#">L</a> <a
																href="#">XL</a>
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
															<a href="#" class="aa-add-to-cart-btn"><span
																class="fa fa-shopping-cart"></span>Add To Cart</a> <a
																href="#" class="aa-add-to-cart-btn">View Details</a>
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