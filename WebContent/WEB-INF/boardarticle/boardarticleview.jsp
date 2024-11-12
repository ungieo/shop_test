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
    
    <script src="${cpath}/include/soledot/js/soledot.js"></script>

	<script type="text/javascript">
	
		$(function(){
		});
	
		function dataAjax(){
		var param = '';
	
			$.ajax({
				async : false,
				data : param,
				error : function(){
					alert( '처리 중 오류가 발생되었습니다.' );
					errorCnt += 1;
					checkYn = 'N';
					return false;
				},
				success : function( data ){
				},
				type : 'POST',
				url : '${cpath}/'
			});
		}
	
		function dataAdd(){
			handling.submit( '', 'boardarticleadd' );
		}
	
		function dataDel(){
			handling.submit( '', 'boardarticledel' );
		}
	
		function dataDown( r_flsseq ){
			handling.pageMove( '${cpath}/system/filedown', 'r_flsseq='+r_flsseq );
		}
	
		function dataEdit(){
			handling.submit( '', 'boardarticleedit' );
		}
	
		function dataIn(){
			handling.submit( '', 'boardarticlein' );
		}
	
		function dataView(){
			handling.submit( '', 'boardarticleview' );
		}
	
		function dataList(){
			handling.submit( '', 'boardarticlelist' );
		}
	
		function dataSort(){
			handling.submit( '', 'boardarticlelist' );
		}
	
		function dataUp(){
			handling.submit( '', 'boardarticleup' );
		}
		
		function dataReplyAdd(){
			handling.submit('','boardarticlereplyadd');
		}
	
		function formSubmit( fName, r_url ){
			handling.submit( '', r_url );
		}
	
		function pager( fName, r_url ){
			$('input[name="r_page"]').val( r_page );
			handling.submit( fName, r_url );
		}
	
		function pageMove(  ){
			handling.pageMove( r_url, param);
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


                <div class="col-md-9">
                    <div class="box">
			
						<form action="boardarticleview" id="frm" name="frm" method="post" >
							<input name="r_bdabdid" type="hidden" value="${ param.r_bdabdid }" />
							<input name="r_bdaseq" type="hidden" value="${ param.r_bdaseq }" />
						
						   	<table class="table">
						   		<colgroup>
						   			<col width="17%" />
						   			<col width="33%" />
						   			<col width="17%" />
						   			<col width="33%" />
						   		</colgroup>
						   		<tr>
						   			<th class="active">제목</th>
						   			<td colspan="3"><c:out value="${ model.boardarticle.BDA_NAME }" /></td>
						   		</tr>
						   		<tr>
						   			<th class="active">작성자</th>
						   			<td><c:out value='${ model.boardarticle.BDA_OWNERNAME }' /></td>
						   			<th class="active">등록일</th>
						   			<td>${ fn:substring( model.boardarticle.BDA_INDATE, 0, 16 ) }</td>
						   		</tr>
						   		<tr>
						   			<th class="active">파일</th>
						   			<td>
										<c:forEach var="filestorage" items="${ model.filestorageList }">
											<div><a href="#" onclick="dataDown('${ filestorage.FLS_SEQ}');"><c:out value="${ filestorage.FLS_NAME }" /></a></div>
										</c:forEach>
									</td>
						   			<th class="active">조회수</th>
						   			<td><c:out value='${ model.boardarticle.BDA_READCNT }' /></td>
						   		</tr>
						   		
						   		<tr>
						   			<th class="active">내용</th>
						   			<td colspan="3">${ model.boardarticle.BDA_CONTENT }</td>
						   		</tr>
						   	</table>


							<hr/>
							
							<c:if test="${ 'Y' eq model.board.BD_ADDUSE }">
								<div class="row">
									<div class="col-sm-12">
										<c:if test="${ 'Y' eq model.board.BD_ADDUSE }">
											<button class="btn btn-success btn-sm" type="button" onclick="dataAdd();"><i class="fa fa-pencil"></i>글쓰기</button>
										</c:if>
										<c:if test="${ 'Y' eq model.board.BD_REPLYUSE }">
											<button class="btn btn-success btn-sm" type="button" onclick="dataReplyAdd();"><i class="fa fa-reply"></i>답글</button>
										</c:if>
										<c:if test="${ 'Y' eq model.board.BD_EDITUSE }">
											<button class="btn btn-warning btn-sm" type="button" onclick="dataEdit();"><i class="fa fa-edit"></i>수정</button>
										</c:if>
										<c:if test="${ 'Y' eq model.board.BD_DELUSE }">
											<button class="btn btn-danger btn-sm" type="button" onclick="dataDel();"><i class="fa fa-trash-o"></i>삭제</button>
										</c:if>
										<button class="btn btn-info btn-sm" type="button" onclick="dataList();"><i class="fa fa-list"></i>목록</button>
									</div>
								</div>
							</c:if>
												   	
<!-- 						    <div class="btn-group"> -->
<%-- 						    	<c:if test="${ 'Y' eq model.board.BD_REPLYUSE  }"> --%>
<!-- 									<button type="button" class="btn btn-primary" onclick="dataAdd();">답글</button> -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${ 'Y' eq model.board.BD_EDITUSE  }"> --%>
<!-- 									<button type="button" class="btn btn-warning" onclick="dataEdit();">수정</button> -->
<%-- 								</c:if> --%>
<%-- 								<c:if test="${ 'Y' eq model.board.BD_DELUSE  }"> --%>
<!-- 									<button type="button" class="btn btn-danger" onclick="dataDel();">삭제</button> -->
<%-- 								</c:if> --%>
<!-- 								<button type="button" class="btn btn-info" onclick="dataList();">리스트</button> -->
<!-- 						    </div>    -->
						   	
						</form>
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