<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	
	<title>Welcome Soledot!</title>

	<!-- Bootstrap core CSS -->
	
	<link href="${cpath}/include/css/bootstrap.min.css" rel="stylesheet">
	<link href="${cpath}/include/fonts/css/font-awesome.min.css" rel="stylesheet">
	<!-- Custom styling plus plugins -->
	<link href="${cpath}/include/css/custom.css" rel="stylesheet">
	<!-- editor -->
	
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">			<!-- jquery ui css google cdn -->
	
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>	<!-- jquery cdn -->
	
	<script src="${ cpath }/include/soledot/js/soledot.js"></script>
	
	
	<!--[if lt IE 9]>
	<script src="../assets/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

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
	
	function dataReplyAdd(){
		handling.submit( '', 'boardarticlereplyadd' );
	}

	function dataDel(){
		if( confirm('삭제처리는 신중히해주십시오.') ){
			handling.submit( '', 'boardarticledel' );
		}
	}

	function dataDown( r_flsseq ){
		handling.pageMove( 'filedown', 'r_flsseq='+r_flsseq );
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
<body class="nav-md">
	
	<div class="container body">
		<div class="main_container">
		
			<%@include file="/include/jsp/bo/left.jsp"%>
			<!-- top navigation -->
			<%@include file="/include/jsp/bo/header.jsp" %>
			<!-- /top navigation -->
			
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					
					<div class="page-title">
						<div class="title_left">
							<h3>게시판 관리 <small>Board Manage</small></h3>
						</div>	
						<div class="title_right">
							<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Search for..." />
									<span class="input-group-btn"><button class="btn btn-default" type="button">Go!</button></span>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
	
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>게시글 내용 <small>Board View</small></h2>
<!-- 									<ul class="nav navbar-right panel_toolbox"> -->
<!-- 										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li> -->
<!-- 										<li class="dropdown"> -->
<!-- 											<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a> -->
<!-- 											<ul class="dropdown-menu" role="menu"> -->
<!-- 												<li><a href="#">Settings 1</a></li> -->
<!--                              						<li><a href="#">Settings 2</a></li> -->
<!--                            					</ul> -->
<!--                          					</li> -->
<!-- 										<li><a class="close-link"><i class="fa fa-close"></i></a></li> -->
<!--                        				</ul> -->
									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<form action="boardarticleview" id="frm" name="frm" method="post" >
										<input name="r_bdabdid" type="hidden" value="${ model.boardarticle.BDA_BDID }" />
										<input name="r_bdaseq" type="hidden" value="${ model.boardarticle.BDA_SEQ }" />
									
										<input name="r_bdaseq" type="hidden" value="${ model.boardarticle.BDA_SEQ }" />
										
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
														<a href="#" onclick="dataDown('${ filestorage.FLS_SEQ}');">${ filestorage.FLS_NAME }</a>
													</c:forEach>
												</td>
									   			<th class="active">조회수</th>
									   			<td><c:out value='${ model.boardarticle.BDA_READCNT }' /></td>
									   		</tr>
									   		
									   		<tr>
									   			<th class="active">내용</th>
									   			<td colspan="3">'${ model.boardarticle.BDA_CONTENT }'</td>
									   		</tr>
									   	</table>
								   		
								   		<div class="ln_solid"></div>
								   		
										<div class="form-group">
											<div class="col-xs-12">
										       <button type="button" class="btn btn-success btn-sm" onclick="dataAdd();"><i class="fa fa-pencil"></i> 등록</button>
										       <button type="button" class="btn btn-success btn-sm" onclick="dataReplyAdd();"><i class="fa fa-reply"></i> 답글</button>
										       <button type="button" class="btn btn-warning btn-sm" onclick="dataEdit();"><i class="fa fa-edit"></i> 수정</button>
										       <button type="button" class="btn btn-danger btn-sm" onclick="dataDel();"><i class="fa fa-trash"></i> 삭제</button>
										       <button type="button" class="btn btn-info btn-sm" onclick="dataList();"><i class="fa fa-list-ul"></i> 리스트</button>
											</div>
										</div>
										
									</form>

								</div>
							</div>
						</div>
						
						
					</div>
				</div>
	      </div>
	      <!-- /page content -->
			
			
			<!-- footer content -->
			<%@include file="/include/jsp/bo/footer.jsp" %>
			<!-- /footer content -->
			
		</div>
	</div>
	

	<div id="custom_notifications" class="custom-notifications dsp_none">
		<ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group"></ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>
	
	<script src="${cpath}/include/js/bootstrap.min.js"></script>
	<script src="${cpath}/include/js/custom.js"></script>	
	
	
	<!-- pace -->
	<script src="${cpath}/include/js/pace/pace.min.js"></script>

</body>
</html>