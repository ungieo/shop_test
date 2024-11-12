<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

	
	function basketDel(obj, r_prbseq){
		
// 		var topbasketmoney = $('#topbasketmoney').text();
		var topbasketmoney = 0;
		
		var param = '';
		param += 'r_prbseq='+r_prbseq;
		
		var option = {
				async : false,
				data : param,
				dataType : 'json',	
				error : function( xhr, textStatus, error ){alert( error );},
				success : function(data){
					if( data.result ){
						if( 2 < $(obj).parent().parent().find('li').length ){
							$(obj).parent().remove();
							
							$('input[name="t_prbrowmoney"]').each(function(index){
								topbasketmoney += parseInt( $(this).val() );
							});
							$('#topbasketmoney').text(topbasketmoney);
							
						}else{
							$(obj).parent().parent().parent().remove();
						}
						$('#v_prbcnt').text($('#v_prbcnt').text()-1);
					}else{
						alert('처리에 오류가 발생했습니다.');
					}
					
				},
				type : 'POST',
				url : '${cpath}/productbasket/productbasketdelajax'
			}
		dataAjax(option);
		
	}
</script>

	<!-- wpf loader Two -->
	<div id="wpf-loader-two">
		<div class="wpf-loader-two-inner">
			<span>Loading</span>
		</div>
	</div>
	<!-- / wpf loader Two -->
	<!-- SCROLL TOP BUTTON -->
	<a class="scrollToTop" href="#"><i class="fa fa-chevron-up"></i></a>
	<!-- END SCROLL TOP BUTTON -->
	
	
	<!-- Start header section -->
	<header id="aa-header">
		<!-- start header top  -->
		<div class="aa-header-top">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="aa-header-top-area">
							<!-- start header top left -->
<!-- 							<div class="aa-header-top-left"> -->
								<!-- start language -->
<!-- 								<div class="aa-language"> -->
<!-- 									<div class="dropdown"> -->
<!-- 										<a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> -->
<!-- 											<img src="img/flag/english.jpg" alt="english flag">ENGLISH <span class="caret"></span> -->
<!-- 										</a> -->
<!-- 										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1"> -->
<!-- 											<li><a href="#"><img src="img/flag/french.jpg" alt="">FRENCH</a></li> -->
<!-- 											<li><a href="#"><img src="img/flag/english.jpg" alt="">ENGLISH</a></li> -->
<!-- 										</ul> -->
<!-- 									</div> -->
<!-- 								</div> -->
								<!-- / language -->
	
								<!-- start currency -->
<!-- 								<div class="aa-currency"> -->
<!-- 									<div class="dropdown"> -->
<!-- 										<a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">  -->
<!-- 											<i class="fa fa-usd"></i>USD <span class="caret"></span> -->
<!-- 										</a> -->
<!-- 										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1"> -->
<!-- 											<li><a href="#"><i class="fa fa-euro"></i>EURO</a></li> -->
<!-- 											<li><a href="#"><i class="fa fa-jpy"></i>YEN</a></li> -->
<!-- 										</ul> -->
<!-- 									</div> -->
<!-- 								</div> -->
								<!-- / currency -->
								<!-- start cellphone -->
<!-- 								<div class="cellphone hidden-xs"> -->
<!-- 									<p> -->
<!-- 										<span class="fa fa-phone"></span>00-62-658-658 -->
<!-- 									</p> -->
<!-- 								</div> -->
								<!-- / cellphone -->
<!-- 							</div> -->
							<!-- / header top left -->
							<div class="aa-header-top-right">
								<ul class="aa-head-top-nav-right">
									<c:if test="${ empty sessionScope.ss_mbid or sessionScope.ss_mbtype ne 'N' }">
										<li class="hidden-xs"><a href="cart.html">Register</a></li>
										<li class="hidden-xs"><a href="cart.html">My Cart</a></li>
										<li class="hidden-xs"><a href="checkout.html">Checkout</a></li>
										<li><a href="" data-toggle="modal" data-target="#login-modal">Login</a></li>
									</c:if>
									<c:if test="${ !empty sessionScope.ss_mbid and sessionScope.ss_mbtype eq 'N' }">
										<li><a href="account.html">My Account</a></li>
										<li class="hidden-xs"><a href="wishlist.html">Wishlist</a></li>
										<li class="hidden-xs"><a href="cart.html">My Cart</a></li>
										<li class="hidden-xs"><a href="checkout.html">Checkout</a></li>
										<li><a href="${cpath}/member/memberlogout" >Logout</a></li>
									</c:if>
									
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- / header top  -->
	
		<!-- start header bottom  -->
		<div class="aa-header-bottom">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="aa-header-bottom-area">
							<!-- logo  -->
							<div class="aa-logo">
								<!-- Text based logo -->
								<a href="index.html">
									<span class="fa fa-shopping-cart"></span>
									<p>SoleDot<strong>Shop</strong> <span>Your Shopping Partner</span></p>
								</a>
								<!-- img based logo -->
								<!-- <a href="index.html"><img src="img/logo.jpg" alt="logo img"></a> -->
							</div>
							<!-- / logo  -->
							<!-- cart box -->
							<div class="aa-cartbox">
								<a class="aa-cart-link" href="${cpath}/productbasket/productbasketlist">
									<span class="fa fa-shopping-basket"></span> <span class="aa-cart-title">SHOPPING CART</span> 
									<span class="aa-cart-notify" id="v_prbcnt">${ fn:length(model.topPrbList.productbasketList) }</span>
								</a>
								
								<c:if test="${ !empty model.topPrbList.productbasketList }">
									<div class="aa-cartbox-summary">
										<ul id="basketul"><!-- 장바구니 등록시 동적처리... -->
											
											<c:forEach var="prb" items="${model.topPrbList.productbasketList}" varStatus="status" >
												<c:set var="pr" value="${ model.topPrbList.productList[status.index] }"  />
												<c:set var="topPrbMoney" value="${ topPrbMoney + ( pr.PR_PRICE * prb.PRB_EA ) }"/>
												
												<li>
													<a class="aa-cartbox-img" href="${cpath}/product/productview?r_prseq=${pr.PR_SEQ}"><img src="${cpath}/data/up/product/${pr.PR_IMAGE1}" alt="img"></a>
													<div class="aa-cartbox-info">
														<h4>
															<a href="${cpath}/product/productview?r_prseq=${pr.PR_SEQ}">${pr.PR_NAME}</a>
														</h4>
														<p>${prb.PRB_EA} x ${pr.PR_PRICE}원</p>
													</div> 
													<input type="text" name="t_prbrowmoney" value="${prb.PRB_EA * pr.PR_PRICE}" />
													<a class="aa-remove-product" href="#" onclick="basketDel(this,${prb.PRB_SEQ});"><span class="fa fa-times"></span></a>
												</li>
											</c:forEach>
											
											<li>
												<span class="aa-cartbox-total-title"> Total </span> <span class="aa-cartbox-total-price" ><span id="topbasketmoney">${ topPrbMoney }</span>원</span>
											</li>
										</ul>
										<a class="aa-cartbox-checkout aa-primary-btn" href="checkout.html">Checkout</a>
									</div>
								</c:if>
								
							</div>
							<!-- / cart box -->
							<!-- search box -->
							<div class="aa-search-box">
								<form action="">
									<input type="text" name="" id="" placeholder="Search here ex. 'man' ">
									<button type="submit">
										<span class="fa fa-search"></span>
									</button>
								</form>
							</div>
							<!-- / search box -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- / header bottom  -->
	</header>
	<!-- / header section -->


	<section id="menu">
		<div class="container">
			<div class="menu-area">
				<!-- Navbar -->
				<div class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
					</div>
					<div class="navbar-collapse collapse">
						<!-- Left nav -->
						<ul class="nav navbar-nav">
							<li><a href="${cpath}/home/index">Home</a></li>
							
							<c:forEach var="prc" items="${ model.prcList1 }">
								<li>
									<a href="#">${prc.PRC_NAME }
										<c:if test="${ !empty prc.prcList2 }">
											<span class="caret"></span>
										</c:if>
									</a>
								
									<c:if test="${ !empty prc.prcList2 }">
										<ul class="dropdown-menu">
											<c:forEach var="prc2" items="${ prc.prcList2 }">
												<li>
													<a href="#">${prc2.PRC_NAME}
														<c:if test="${ !empty prc2.prcList3 }">
															<span class="caret"></span>
														</c:if>
													</a>
													
													<c:if test="${ !empty prc2.prcList3 }">
														<ul class="dropdown-menu">
															<c:forEach var="prc3" items="${ prc2.prcList3 }">
																<li>
																	<a href="${cpath}/product/productlist?r_prcseq=${prc3.PRC_SEQ}&r_prclevel=${prc3.PRC_LEVEL}">
																		${ prc3.PRC_NAME }
																		<c:if test="${ !empty prc3.prcList4 }">
																			<span class="caret"></span>
																		</c:if>
																	</a>
																	<c:if test="${ !empty prc3.prcList4 }">
																		<ul class="dropdown-menu">
																			<c:forEach var="prc4" items="${ prc3.prcList4 }">
																				<li>
																					<a href="${cpath}/product/productlist?r_prcseq=${prc4.PRC_SEQ}&r_prclevel=${prc4.PRC_LEVEL}">${ prc4.PRC_NAME }</a>
																				</li>
																			</c:forEach>
																			
																		</ul>
																	</c:if>
																</li>
															</c:forEach>
														</ul>
													</c:if>
												</li>
											</c:forEach>
											
<!-- 											<li><a href="#">Sports</a></li> -->
<!-- 											<li><a href="#">Formal</a></li> -->
<!-- 											<li><a href="#">Standard</a></li> -->
<!-- 											<li><a href="#">T-Shirts</a></li> -->
<!-- 											<li><a href="#">Shirts</a></li> -->
<!-- 											<li><a href="#">Jeans</a></li> -->
<!-- 											<li><a href="#">Trousers</a></li> -->
<!-- 											<li> -->
<!-- 												<a href="#">And more.. <span class="caret"></span></a> -->
<!-- 												<ul class="dropdown-menu"> -->
<!-- 													<li><a href="#">Sleep Wear</a></li> -->
<!-- 													<li><a href="#">Sandals</a></li> -->
<!-- 													<li><a href="#">Loafers</a></li> -->
<!-- 													<li> -->
<!-- 														<a href="#">And more.. <span class="caret"></span></a> -->
<!-- 														<ul class="dropdown-menu"> -->
<!-- 															<li><a href="#">Sleep Wear</a></li> -->
<!-- 															<li><a href="#">Sandals</a></li> -->
<!-- 															<li><a href="#">Loafers</a></li> -->
<!-- 															<li><a href="#">Loafers</a></li> -->
<!-- 														</ul> -->
<!-- 													</li> -->
<!-- 												</ul> -->
<!-- 											</li> -->
										</ul>
									</c:if>
									
								</li>
							</c:forEach>
							
						</ul>
						
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
	</section>
	<!-- / menu -->