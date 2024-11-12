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
    
    <script type="text/javascript" src="//cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
    
    <script src="${cpath}/include/soledot/js/soledot.js"></script>

	<script type="text/javascript">
	
		$(function(){
			CKEDITOR.replace('editor1', {
				toolbar : 'Basic',
				filebrowserImageUploadUrl : '/soledot_boardarticle/include/imgupload.jsp?type=Images', //파일업로드시 사용
				width : '100%', //---넓이값
				height : '200' //---높이값
			});
			$('#frm').submit(function(event){
				if( 'boardarticlereplyin' != $(this).attr('action') ){
					$(this).attr('enctype', '');
				}
			});
			
		})
	
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
	
		function dataEdit(){
			handling.submit( '', 'boardarticleedit' );
		}
	
		function dataDel(){
			handling.submit( '', 'boardarticledel' );
		}
	
		function dataIn(){
			$('input[name="r_bdacontent"]').val(CKEDITOR.instances.editor1.getData());
			
	// 		var fileVal = $('input[name="r_bdafile1"]').val();
	// 		if( '' != fileVal ){
	// 			$('form[name="frm"]').attr( "enctype", "multipart/form-data" );
	// 		}
			handling.submit( '', 'boardarticlereplyin' );
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
	
		function formSubmit( fName, url ){
			handling.submit( fName, url );
		}
	
		function pager( fName, url ){
			$('input[name="r_page"]').val( r_page );
			handling.submit( fName, url );
		}
	
		function pageMove( fName, url ){
			handling.pageMove(url,param);
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
                    
						<form action="boardarticlereplyin" class="form-horizontal"  method="post" id="frm" name="frm" enctype="multipart/form-data">
							<input name="r_bdabdid" type="hidden" value="${ param.r_bdabdid }" />
							<input name="r_bdaseq" type="hidden" value="${ param.r_bdaseq }" />
							<input name="r_bdacontent" type="hidden" />
					
					
							<div class="form-group">
								<label class="col-sm-2 control-label" for="r_bdaname">제목</label>
								<div class="col-sm-10">
									<input id="r_bdaname" name="r_bdaname" placeholder="제목" class="form-control" type="text" value="${ model.boardarticle.BDA_NAME }" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="r_bdacontent">내용</label>
								<div class="col-sm-10">
									<textarea id="editor1" name="editor1" placeholder="내용" class="form-control" >${ model.boardarticle.BDA_CONTENT }</textarea>
								</div>
							</div>
							
							<c:if test="${ 'Y' eq model.board.BD_FILEUSE }">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="r_bdafilenum">파일첨부</label>
								<div class="col-sm-10">
									<input id="r_bdafilenum" name="r_bdafilenum" placeholder="파일첨부" class="form-control" type="file" value="${ model.boardarticle.BDA_FILENUM }" />
								</div>
							</div>
							</c:if>
							
							<c:if test="${ 'Y' eq model.board.BD_PSWDUSE }">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="r_bdapswd">비밀문자</label>
								<div class="col-sm-10">
									<input id="r_bdapswd" name="r_bdapswd" placeholder="비밀문자" class="form-control" type="password" value="" />
								</div>
							</div>
							</c:if>
							
							<hr/>
							
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="button" class="btn btn-primary btn-sm" onclick="dataIn()"><i class="fa fa-save"></i>저장</button>
									<button type="button" class="btn btn-info btn-sm" onclick="dataList();"><i class="fa fa-list-ol"></i>목록</button>
								</div>
						    </div>
							
<!-- 							<div class="form-group"> -->
<!-- 								<div class="col-sm-offset-2 col-sm-10"> -->
<!-- 								    <div class="btn-group"> -->
<!-- 								       <button type="button" class="btn btn-primary" onclick="dataIn();">등록</button> -->
<!-- 								       <button type="button" class="btn btn-info" onclick="dataList();">리스트</button> -->
<!-- 								    </div> -->
<!-- 								</div> -->
<!-- 						    </div> -->
							
						
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
    
    <script src="${cpath}/include/obaju/js/bootstrap.min.js"></script>
    <script src="${cpath}/include/obaju/js/jquery.cookie.js"></script>
    <script src="${cpath}/include/obaju/js/waypoints.min.js"></script>
    <script src="${cpath}/include/obaju/js/modernizr.js"></script>
    <script src="${cpath}/include/obaju/js/bootstrap-hover-dropdown.js"></script>
    <script src="${cpath}/include/obaju/js/owl.carousel.min.js"></script>
    <script src="${cpath}/include/obaju/js/front.js"></script>



</body>

</html>