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

    <link rel="shortcut icon" href="favicon.png">



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
                        <li>주문내역</li>
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
                                <li class="active">
                                    <a href="${cpath}/ordermain/ordermainlist"><i class="fa fa-list"></i> 주문내역</a>
                                </li>
                                <li>
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

                <div class="col-md-9" id="customer-orders">
                    <div class="box">
                        <h1>My orders</h1>

                        <p class="lead">Your orders on one place.</p>
                        <p class="text-muted">If you have any questions, please feel free to <a href="contact.html">contact us</a>, our customer service center is working for you 24/7.</p>

                        <hr>

                        <div class="table-responsive">
                            <table class="table table-hover">
								<thead>
									<tr>
<!-- 										<th>고유번호</th> -->
										<th>주문번호</th>
<!-- 										<th>PG결제번호</th> -->
<!-- 										<th>비밀문자</th> -->
<!-- 										<th>주문자아이디</th> -->
<!-- 										<th>주문자명</th> -->
										<th>상품명</th>
<!-- 										<th>결제타입</th> -->
<!-- 										<th>계좌이체</th> -->
<!-- 										<th>카드</th> -->
<!-- 										<th>쿠폰</th> -->
<!-- 										<th>후불</th> -->
<!-- 										<th>포인트</th> -->
<!-- 										<th>적립금</th> -->
<!-- 										<th>가상계좌</th> -->
<!-- 										<th>잔여계좌이체</th> -->
<!-- 										<th>잔여카드</th> -->
<!-- 										<th>잔여쿠폰</th> -->
<!-- 										<th>잔여후불</th> -->
<!-- 										<th>잔여포인트</th> -->
<!-- 										<th>잔여적립금</th> -->
<!-- 										<th>잔여가상계좌</th> -->
<!-- 										<th>발생적립금</th> -->
<!-- 										<th>원가</th> -->
										<th>판매가</th>
<!-- 										<th>배송타입</th> -->
<!-- 										<th>배송메모</th> -->
<!-- 										<th>배송비</th> -->
<!-- 										<th>배송번호</th> -->
<!-- 										<th>주문메모</th> -->
<!-- 										<th>배송사SEQ</th> -->
<!-- 										<th>에스크로여부</th> -->
<!-- 										<th>부분취소가능여부</th> -->
										<th>상태값</th>
<!-- 										<th>스탭</th> -->
<!-- 										<th>타입</th> -->
<!-- 										<th>수정아이디</th> -->
<!-- 										<th>등록아이디</th> -->
<!-- 										<th>수정일</th> -->
										<th>등록일</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${ model.ordermainList}" var="ordermain" varStatus="status" >
										<tr>
<%-- 											<td><c:out value='${ ordermain.OM_SEQ }' /></td> --%>
											<td><c:out value='${ ordermain.OM_ID }' /></td>
<%-- 											<td><c:out value='${ ordermain.OM_PGID }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_PSWD }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_MBID }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_MBNAME }' /></td> --%>
											<td><c:out value='${ ordermain.OM_PRNAME }' /></td>
<%-- 											<td><c:out value='${ ordermain.OM_PAYTYPE }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_ACCOUNTMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_CARDMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_COUPONMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_LATERMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_POINTMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_SAVEMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_VIRTUALACCOUNTMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_RACCOUNTMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_RCARDMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_RCOUPONMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_RLATERMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_RPOINTMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_RSAVEMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_RVIRTUALACCOUNTMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_NEWSAVEMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_ORIGNALMONEY }' /></td> --%>
											<td><c:out value='${ ordermain.OM_SALEMONEY }' /></td>
<%-- 											<td><c:out value='${ ordermain.OM_DELITYPE }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_DELIMEMO }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_DELIMONEY }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_DELINUM }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_MEMO }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_PCCSEQ }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_ESCROWYN }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_PARTCANCELYN }' /></td> --%>
											<td><c:out value='${ ordermain.OM_STATUS }' /></td>
<%-- 											<td><c:out value='${ ordermain.OM_STEP }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_TYPE }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_MOID }' /></td> --%>
<%-- 											<td><c:out value='${ ordermain.OM_INID }' /></td> --%>
<%-- 											<td>${ fn:substring( ordermain.OM_MODATE, 0, 16 ) }</td> --%>
											<td>${ fn:substring( ordermain.OM_INDATE, 0, 16 ) }</td>
										</tr>
								</c:forEach>
								</tbody>
							</table>
                        </div>
                        
						<%@ include file="/include/jsp/pager.jsp" %>
					
                    </div>
                    

					
				</div>

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
