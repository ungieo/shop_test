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
	
	<script type="text/javascript" src="//cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
	
	<script src="${ cpath }/include/soledot/js/jquery-validation/jquery.validate.js"></script> 
	<script src="${ cpath }/include/soledot/js/jquery-validation/additional-methods.js"></script>
	<script src="${ cpath }/include/soledot/js/jquery-validation/localization/messages_ko.js"></script>
	<script src="${ cpath }/include/soledot/js/soledot.js"></script>
	
	
	<!--[if lt IE 9]>
	<script src="../assets/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->

<script type="text/javascript">

	$(function(){
		$('form[name="frm"]').validate();
		
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
		handling.submit( '', 'boardadd' );
	}

	function dataDel(){
// 		handling.submit( '', 'boarddel' );
	}

	function dataDown( r_flsseq ){
		handling.pageMove( '${cpath}/system/filedown', 'r_flsseq='+r_flsseq );
	}
	

	function dataEdit(){
		handling.submit( '', 'boardedit' );
	}

	function dataIn(){
		handling.submit( '', 'boardin' );
	}

	function dataView(){
		handling.submit( '', 'boardview' );
	}

	function dataList(){
		handling.submit( '', 'boardlist' );
	}

	function dataSort(){
		handling.submit( '', 'boardlist' );
	}

	function dataUp(){
		alert('?')
// 		handling.submit( '', 'boardup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
	}

	function pager( fName, r_url ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( fName, r_url );
	}

	function pageMove( fName, r_url ){
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
									<h2>${ model.board.BD_NAME } 게시판 <small>Users</small></h2>
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

									<form action="boardview" class="form-horizontal" method="post" name="frm">
										<input type="hidden" name="r_bdid" value="${ model.board.BD_ID }" />
										
										<fieldset>
											<legend>boardview</legend>
											<div class="form-group has-success">
												<label for="r_bdid" class="col-sm-2 control-label">아이디</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_ID }</p>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bdname" class="col-sm-2 control-label">게시판명</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_NAME }</p>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bddescription" class="col-sm-2 control-label">설명</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_DESCRIPTION }</p>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bdfilemaxsize" class="col-sm-2 control-label">파일최대사이즈(mb)</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_FILEMAXSIZE }</p>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bdimage" class="col-sm-2 control-label">이미지</label>
												<div class="col-sm-10">
													<c:forEach var="filestorage" items="${ model.filestorageList }">
														<p class="form-control-static"><a href="#" onclick="dataDown('${ filestorage.FLS_SEQ}');">${ filestorage.FLS_NAME }</a></p>
													</c:forEach>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bdip" class="col-sm-2 control-label">보드아이피</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_IP }</p>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bdfileuse" class="col-sm-2 control-label">파일사용여부</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_FILEUSE }</p>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bdcommentuse" class="col-sm-2 control-label">코멘트사용여부</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_COMMENTUSE }</p>
												</div>				
											</div>
											<div class="form-group has-success">
												<label for="bd_secretuse" class="col-sm-2 control-label">비밀글사용여부</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_SECRETUSE }</p>
												</div>				
											</div>
											<div class="form-group has-success">
												<label for="r_bdipuse" class="col-sm-2 control-label">아이피사용여부</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_IPUSE }</p>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bdpswduse" class="col-sm-2 control-label">암호사용여부</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_PSWDUSE }</p>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bdreplyuse" class="col-sm-2 control-label">답글여부</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_REPLYUSE }</p>
												</div>
											</div>
											<div class="form-group has-success" class="col-sm-2 control-label">
												<label for="r_bdsorttype" class="col-sm-2 control-label">정렬타입</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_SORTTYPE }</p>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bdviewtype" class="col-sm-2 control-label">뷰타입</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_VIEWTYPE }</p>
												</div>
											</div>
											<div class="form-group has-success">
												<label for="r_bduse" class="col-sm-2 control-label">사용여부</label>
												<div class="col-sm-10">
													<p class="form-control-static">${ model.board.BD_USE }</p>
												</div>
											</div>
											
										</fieldset>
								
										<div class="ln_solid"></div>
										
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
											    <div class="btn-group">
											       <button type="button" class="btn btn-success btn-sm" onclick="dataAdd();"><i class="fa fa-plus"></i> 등록</button>
											       <button type="button" class="btn btn-warning btn-sm" onclick="dataEdit();"><i class="fa fa-edit"></i> 수정</button>
											       <button type="button" class="btn btn-danger btn-sm" onclick="dataDel();"><i class="fa fa-trash"></i> 삭제</button>
											       <button type="button" class="btn btn-primary btn-sm" onclick="dataList();"><i class="fa fa-list-ul"></i> 리스트</button>
											    </div>   
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