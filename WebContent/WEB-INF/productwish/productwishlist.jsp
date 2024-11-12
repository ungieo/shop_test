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

</head>

<body>

	<%@include file="/include/jsp/header.jsp" %>

    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">

                    <ul class="breadcrumb">
                        <li><a href="index.html">Home</a>
                        </li>
                        <li>관심상품</li>
                    </ul>

                </div>

                <div class="col-md-3">
                    <!-- *** CUSTOMER MENU ***
 _________________________________________________________ -->
                    <div class="panel panel-default sidebar-menu">

                        <div class="panel-heading">
                            <h3 class="panel-title">마이페이지</h3>
                        </div>

                        <div class="panel-body">

                            <ul class="nav nav-pills nav-stacked">
                                <li>
                                    <a href="${cpath}/ordermain/ordermainlist"><i class="fa fa-list"></i> 주문내역</a>
                                </li>
                                <li class="active">
                                    <a href="${cpath}/productwish/productwishlist"><i class="fa fa-heart"></i> 관심상품</a>
                                </li>
                                <li>
                                    <a href="${cpath}/member/memberedit"><i class="fa fa-user"></i> 내 정보수정</a>
                                </li>
                                <li>
                                    <a href="${cpath}/login/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                                </li>
                            </ul>
                            
                        </div>

                    </div>
                    <!-- /.col-md-3 -->
                    
                    
                                        <!-- 회원전용 게시판 -->
<%--                     <c:if test="${ !empty model.boardList }"> --%>
<!-- 						<div class="panel panel-default sidebar-menu"> -->
<!-- 	                        <div class="panel-heading"> -->
<!-- 	                            <h3 class="panel-title">전체게시판</h3> -->
<!-- 	                        </div> -->
	
<!-- 	                        <div class="panel-body"> -->
<!-- 	                            <ul class="nav nav-pills nav-stacked"> -->
<%-- 	                            	<c:forEach var="bd" items="${ model.boardList }" varStatus="status"> --%>
<%-- 		                            	<li <c:if test="${ param.r_bdabdid eq bd.BD_ID }">class="active"</c:if> > --%>
<%-- 		                                    <a href="${cpath}/boardarticle/boardarticlelist?r_bdabdid=${bd.BD_ID}">${ bd.BD_NAME }</a> --%>
<!-- 		                                </li> -->
<%-- 	                            	</c:forEach> --%>
<!-- 	                            </ul> -->
<!-- 	                        </div> -->
<!-- 	                    </div> -->
<%--                     </c:if> --%>
                    <!-- 회원전용 게시판 -->
                    
                    <!-- *고객센터 -->
                    <div class="panel panel-default sidebar-menu">
                        <div class="panel-heading">
                            <h3 class="panel-title">고객센터</h3>
                        </div>

                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                            	<li>
                                    <a href="${cpath}/boardarticle/boardarticlefaqlist?r_bdabdid=faq">FAQ</a>
                                </li>
                            	<li <c:if test="${ 'notice' eq param.r_bdabdid }">class="active"</c:if>>
                                    <a href="${cpath}/boardarticle/boardarticlelist?r_bdabdid=notice">공지사항</a>
                                </li>
                                <li <c:if test="${ 'question' eq param.r_bdabdid }">class="active"</c:if>>
                                    <a href="${cpath}/boardarticle/boardarticlelist?r_bdabdid=question">Q&A</a>
                                </li>
                                <li <c:if test="${ 'oneone' eq param.r_bdabdid }">class="active"</c:if>>
                                    <a href="${cpath}/boardarticle/boardarticlelist?r_bdabdid=oneone">1:1 문의</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!-- 고객센터 -->
                    

                    <!-- *** CUSTOMER MENU END *** -->
                </div>

                <div class="col-md-9" id="wishlist">

                    <div class="box">
                        <h1>My wishlist</h1>
                        <p class="lead">Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                    </div>

                    <div class="row products">
                    
                    	<c:forEach var="prw" items="${ model.productwishMap.productwishList }" varStatus="status">
                    	<c:set var="pr" value="${ model.productwishMap.productList[status.index] }" />

                        <div class="col-md-3 col-sm-4">
                            <div class="product">
                                <div class="flip-container">
                                    <div class="flipper">
                                        <div class="front">
                                            <a href="${cpath}/product/productview?r_prseq=${pr.PR_SEQ}">
                                                <img src="${cpath}/include/obaju/img/product1.jpg" alt="" class="img-responsive">
                                            </a>
                                        </div>
                                        <div class="back">
                                            <a href="${cpath}/product/productview?r_prseq=${pr.PR_SEQ}">
                                                <img src="${cpath}/include/obaju/img/product1_2.jpg" alt="" class="img-responsive">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <a href="detail.html" class="invisible">
                                    <img src="${cpath}/include/obaju/img/product1.jpg" alt="" class="img-responsive">
                                </a>
                                <div class="text">
                                    <h3><a href="detail.html">${pr.PR_NAME}</a></h3>
                                    <p class="price">${ pr.PR_PRICE }</p>
                                    <p class="buttons">
                                        <a href="${cpath}/product/prodctview?r_prseq=${pr.PR_SEQ}" class="btn btn-default">View detail</a>
                                        <a href="javascript:basketIn('${pr.PR_SEQ}');" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </p>
                                </div>
                                <!-- /.text -->
                            </div>
                            <!-- /.product -->
                        </div>
                        
                    	</c:forEach>

<!--                         <div class="col-md-3 col-sm-4"> -->
<!--                             <div class="product"> -->
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
<!--                                     <h3><a href="detail.html">White Blouse Armani</a></h3> -->
<!--                                     <p class="price"><del>$280</del> $143.00</p> -->
<!--                                     <p class="buttons"> -->
<!--                                         <a href="detail.html" class="btn btn-default">View detail</a> -->
<!--                                         <a href="basket.html" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
<!--                                     </p> -->
<!--                                 </div> -->
<!--                                 /.text -->

<!--                                 <div class="ribbon sale"> -->
<!--                                     <div class="theribbon">SALE</div> -->
<!--                                     <div class="ribbon-background"></div> -->
<!--                                 </div> -->
<!--                                 /.ribbon -->

<!--                                 <div class="ribbon new"> -->
<!--                                     <div class="theribbon">NEW</div> -->
<!--                                     <div class="ribbon-background"></div> -->
<!--                                 </div> -->
<!--                                 /.ribbon -->

<!--                                 <div class="ribbon gift"> -->
<!--                                     <div class="theribbon">GIFT</div> -->
<!--                                     <div class="ribbon-background"></div> -->
<!--                                 </div> -->
<!--                                 /.ribbon -->
<!--                             </div> -->
<!--                             /.product -->
<!--                         </div> -->

<!--                         <div class="col-md-3 col-sm-4"> -->
<!--                             <div class="product"> -->
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
<!--                                     <h3><a href="detail.html">Black Blouse Versace</a></h3> -->
<!--                                     <p class="price">$143.00</p> -->
<!--                                     <p class="buttons"> -->
<!--                                         <a href="detail.html" class="btn btn-default">View detail</a> -->
<!--                                         <a href="basket.html" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
<!--                                     </p> -->

<!--                                 </div> -->
<!--                                 /.text -->
<!--                             </div> -->
<!--                             /.product -->
<!--                         </div> -->

<!--                         <div class="col-md-3 col-sm-4"> -->
<!--                             <div class="product"> -->
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
<!--                                     <h3><a href="detail.html">Black Blouse Versace</a></h3> -->
<!--                                     <p class="price">$143.00</p> -->
<!--                                     <p class="buttons"> -->
<!--                                         <a href="detail.html" class="btn btn-default">View detail</a> -->
<!--                                         <a href="basket.html" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
<!--                                     </p> -->

<!--                                 </div> -->
<!--                                 /.text -->
<!--                             </div> -->
<!--                             /.product -->
<!--                         </div> -->

<!--                         <div class="col-md-3 col-sm-4"> -->
<!--                             <div class="product"> -->
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
<!--                                     <h3><a href="detail.html">White Blouse Versace</a></h3> -->
<!--                                     <p class="price">$143.00</p> -->
<!--                                     <p class="buttons"> -->
<!--                                         <a href="detail.html" class="btn btn-default">View detail</a> -->
<!--                                         <a href="basket.html" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
<!--                                     </p> -->

<!--                                 </div> -->
<!--                                 /.text -->

<!--                                 <div class="ribbon new"> -->
<!--                                     <div class="theribbon">NEW</div> -->
<!--                                     <div class="ribbon-background"></div> -->
<!--                                 </div> -->
<!--                                 /.ribbon -->
<!--                             </div> -->
<!--                             /.product -->
<!--                         </div> -->

<!--                         <div class="col-md-3 col-sm-4"> -->
<!--                             <div class="product"> -->
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
<!--                                     <h3><a href="detail.html">Fur coat</a></h3> -->
<!--                                     <p class="price">$143.00</p> -->
<!--                                     <p class="buttons"> -->
<!--                                         <a href="detail.html" class="btn btn-default">View detail</a> -->
<!--                                         <a href="basket.html" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
<!--                                     </p> -->

<!--                                 </div> -->
<!--                                 /.text -->

<!--                                 <div class="ribbon gift"> -->
<!--                                     <div class="theribbon">GIFT</div> -->
<!--                                     <div class="ribbon-background"></div> -->
<!--                                 </div> -->
<!--                                 /.ribbon -->

<!--                             </div> -->
<!--                             /.product -->
<!--                         </div> -->
<!--                         /.col-md-4 -->

<!--                         <div class="col-md-3 col-sm-4"> -->
<!--                             <div class="product"> -->
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
<!--                                     <h3><a href="detail.html">White Blouse Armani</a></h3> -->
<!--                                     <p class="price"><del>$280</del> $143.00</p> -->
<!--                                     <p class="buttons"> -->
<!--                                         <a href="detail.html" class="btn btn-default">View detail</a> -->
<!--                                         <a href="basket.html" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
<!--                                     </p> -->
<!--                                 </div> -->
<!--                                 /.text -->

<!--                                 <div class="ribbon sale"> -->
<!--                                     <div class="theribbon">SALE</div> -->
<!--                                     <div class="ribbon-background"></div> -->
<!--                                 </div> -->
<!--                                 /.ribbon -->

<!--                                 <div class="ribbon new"> -->
<!--                                     <div class="theribbon">NEW</div> -->
<!--                                     <div class="ribbon-background"></div> -->
<!--                                 </div> -->
<!--                                 /.ribbon -->

<!--                                 <div class="ribbon gift"> -->
<!--                                     <div class="theribbon">GIFT</div> -->
<!--                                     <div class="ribbon-background"></div> -->
<!--                                 </div> -->
<!--                                 /.ribbon -->
<!--                             </div> -->
<!--                             /.product -->
<!--                         </div> -->

<!--                         <div class="col-md-3 col-sm-4"> -->
<!--                             <div class="product"> -->
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
<!--                                     <h3><a href="detail.html">Black Blouse Versace</a></h3> -->
<!--                                     <p class="price">$143.00</p> -->
<!--                                     <p class="buttons"> -->
<!--                                         <a href="detail.html" class="btn btn-default">View detail</a> -->
<!--                                         <a href="basket.html" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a> -->
<!--                                     </p> -->

<!--                                 </div> -->
<!--                                 /.text -->
<!--                             </div> -->
<!--                             /.product -->
<!--                         </div> -->

                    </div>
                    <!-- /.products -->

<%--                     <%@ include file="/include/jsp/pager.jsp" %> --%>

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
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>
    <script src="${cpath}/include/obaju/js/bootstrap.min.js"></script>
    <script src="${cpath}/include/obaju/js/jquery.cookie.js"></script>
    <script src="${cpath}/include/obaju/js/waypoints.min.js"></script>
    <script src="${cpath}/include/obaju/js/modernizr.js"></script>
    <script src="${cpath}/include/obaju/js/bootstrap-hover-dropdown.js"></script>
    <script src="${cpath}/include/obaju/js/owl.carousel.min.js"></script>
    <script src="${cpath}/include/obaju/js/front.js"></script>



</body>

</html>