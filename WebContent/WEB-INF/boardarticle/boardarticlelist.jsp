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
    
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>
    
    <script src="${cpath}/include/soledot/js/soledot.js"></script>

	<script>
	
		function dataAdd(){
			handling.submit('','boardarticleadd');
		}
		
		function dataView(r_bdaseq){
			$('#r_bdaseq').val(r_bdaseq);
			handling.submit('','boardarticleview');
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
                        <li>${ model.board.BD_NAME }</li>
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
                        <h1>${ model.board.BD_NAME }</h1>

<!--                         <p class="lead">Your orders on one place.</p> -->
<!--                         <p class="text-muted">If you have any questions, please feel free to <a href="contact.html">contact us</a>, our customer service center is working for you 24/7.</p> -->

                        <hr>
                        
                        <form action="boardarticlelist" name="frm" id="frm" method="post">
                        	
                        	<input name="r_page" type="hidden" value="${ model.r_page }" />
							<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
							<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />
                        	
                        	<input name="r_bdaseq" id="r_bdaseq" type="hidden" value="" />
                        	<input name="r_bdabdid" id="r_bdabdid" type="hidden" value="${ param.r_bdabdid }" />
                        
	                        <div class="table-responsive">
	                            <table class="table table-hover">
	                            	<colgroup>
	                            		<col style="width: 10%"/>
	                            		<col style="width: 50%"/>
	                            		<col style="width: 20%"/>
<!-- 	                            		<col style="width: 10%"/> -->
	                            		<col style="width: 20%"/>
	                            	</colgroup>
									<thead>
										<tr>
											<th>#</th>
											<th>제목</th>
	<!-- 										<th>작성자아이디</th> -->
											<th>작성자</th>
<!-- 											<th>조회수</th> -->
	<!-- 										<th>추천수</th> -->
											<th>등록일</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${ model.boardarticleList}" var="boardarticle" varStatus="status" >
										<tr>
											<td>${ boardarticle.BDA_SEQ }</td>
											<td>
												<c:if test="${ boardarticle.BDA_LEVELNUM > 1 }">
													<c:forEach begin="2" end="${ boardarticle.BDA_LEVELNUM }"><i class="fa fa-hand-o-right"></i></c:forEach>
												</c:if>
												<a href="#" onclick="dataView('${boardarticle.BDA_SEQ}');" ><c:out value="${ boardarticle.BDA_NAME }" /></a>
											</td>
	<%-- 										<td><c:out value='${ boardarticle.BDA_MBID }' /></td> --%>
											<td><c:out value='${ boardarticle.BDA_OWNERNAME }' /></td>
<%-- 											<td><c:out value='${ boardarticle.BDA_READCNT }' /></td> --%>
	<%-- 										<td><c:out value='${ boardarticle.BDA_RECOMMENDCNT }' /></td> --%>
											<td>${ fn:substring( boardarticle.BDA_INDATE, 0, 10 ) }</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
	                        </div>
                        
                        </form>
                        
						<%@ include file="/include/jsp/pager.jsp" %>
						
						<hr/>
						
						<c:if test="${ 'Y' eq model.board.BD_ADDUSE }">
							<div class="row">
								<div class="col-sm-12">
									<button class="btn btn-success btn-sm" type="button" onclick="dataAdd();"><i class="fa fa-pencil"></i>글쓰기</button>
								</div>
							</div>
						</c:if>
						
					
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
    
    <script src="${cpath}/include/obaju/js/bootstrap.min.js"></script>
    <script src="${cpath}/include/obaju/js/jquery.cookie.js"></script>
    <script src="${cpath}/include/obaju/js/waypoints.min.js"></script>
    <script src="${cpath}/include/obaju/js/modernizr.js"></script>
    <script src="${cpath}/include/obaju/js/bootstrap-hover-dropdown.js"></script>
    <script src="${cpath}/include/obaju/js/owl.carousel.min.js"></script>
    <script src="${cpath}/include/obaju/js/front.js"></script>



</body>

</html>