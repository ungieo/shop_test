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
	<link href="${cpath}/include/css/animate.min.css" rel="stylesheet" />
	<!-- Custom styling plus plugins -->
	<link href="${cpath}/include/css/custom.css" rel="stylesheet">
	<!-- editor -->
	
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">			<!-- jquery ui css google cdn -->
	
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>	<!-- jquery cdn -->
		<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>		<!-- 우편번호 검색 서비스 -->
	
	<script src="${ cpath }/include/soledot/js/jquery-validation/jquery.validate.js"></script> 
	<script src="${ cpath }/include/soledot/js/jquery-validation/additional-methods.js"></script>
	<script src="${ cpath }/include/soledot/js/jquery-validation/localization/messages_ko.js"></script>
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
		$('form[name="frm"]').validate();
		
		$('#r_bdid').attr( 'readonly', 'readonly' );
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
		handling.submit( '', 'boarddel' );
	}

	function dataDown(){
		handling.submit( '', 'boarddel' );
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
		handling.submit( '', 'boardup' );
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
									<h2>게시판 수정 <small>Board Edit</small></h2>
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

									<form action="boardup" class="form-horizontal" method="post" name="frm" enctype="multipart/form-data">
								
										<fieldset>
											<legend>boardedit</legend>
											<div class="form-group">
												<label for="r_bdid" class="col-sm-2 control-label">아이디</label>
												<div class="col-sm-10">
													<input id="r_bdid" name="r_bdid" class="form-control" type="text" value="${ model.board.BD_ID }" required rangelength="1, 40"/>
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdname" class="col-sm-2 control-label">게시판명</label>
												<div class="col-sm-10">
													<input name="r_bdname" class="form-control" type="text" value="${ model.board.BD_NAME }" required rangelength="1, 100"/>
												</div>
											</div>
											<div class="form-group">
												<label for="r_bddescription" class="col-sm-2 control-label">설명</label>
												<div class="col-sm-10">
													<input name="r_bddescription" class="form-control" type="text" value="${ model.board.BD_DESCRIPTION }" />
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdfilemaxsize" class="col-sm-2 control-label">파일최대사이즈(mb)</label>
												<div class="col-sm-10">
													<input name="r_bdfilemaxsize" class="form-control" type="text" value="${ model.board.BD_FILEMAXSIZE }" required  max="99" />
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdimage" class="col-sm-2 control-label">이미지</label>
												<div class="col-sm-10">
													<input name="r_bdimage" class="form-control" type="file" value="${ model.board.BD_IMAGE }"  accept="image/*" extension="gif|png|jpg|jpeg"/>
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdip" class="col-sm-2 control-label">보드아이피</label>
												<div class="col-sm-10">
													<input name="r_bdip" class="form-control" type="text" value="${ model.board.BD_IP }" />
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdfileuse" class="col-sm-2 control-label">파일사용여부</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdfileuse" type="radio" value="Y" <c:if test="${ model.board.BD_FILEUSE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bdfileuse" type="radio" value="N" <c:if test="${ model.board.BD_FILEUSE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdadduse" class="col-sm-2 control-label">글쓰기사용여부</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdadduse" type="radio" value="Y" <c:if test="${ model.board.BD_ADDUSE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bdadduse" type="radio" value="N" <c:if test="${ model.board.BD_ADDUSE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>
											</div>
											
											<div class="form-group">
												<label for="r_bddeluse" class="col-sm-2 control-label">삭제사용여부</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bddeluse" type="radio" value="Y" <c:if test="${ model.board.BD_DELUSE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bddeluse" type="radio" value="N" <c:if test="${ model.board.BD_DELUSE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>
											</div>
											
											<div class="form-group">
												<label for="r_bdedituse" class="col-sm-2 control-label">수정사용여부</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdedituse" type="radio" value="Y" <c:if test="${ model.board.BD_EDITUSE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bdedituse" type="radio" value="N" <c:if test="${ model.board.BD_EDITUSE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>
											</div>
											
											<div class="form-group">
												<label for="r_bdcommentuse" class="col-sm-2 control-label">코멘트사용여부</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdcommentuse" type="radio" value="Y" <c:if test="${ model.board.BD_COMMENTUSE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bdcommentuse" type="radio" value="N" <c:if test="${ model.board.BD_COMMENTUSE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>				
											</div>
											<div class="form-group">
												<label for="bd_secretuse" class="col-sm-2 control-label">비밀글사용여부</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdsecretuse" type="radio" value="Y" <c:if test="${ model.board.BD_SECRETUSE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bdsecretuse" type="radio" value="N" <c:if test="${ model.board.BD_SECRETUSE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>				
											</div>
											<div class="form-group">
												<label for="r_bdipuse" class="col-sm-2 control-label">아이피사용여부</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdipuse" type="radio" value="Y" <c:if test="${ model.board.BD_IPUSE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bdipuse" type="radio" value="N" <c:if test="${ model.board.BD_IPUSE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdselfviewuse" class="col-sm-2 control-label">본인글만보기</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdselfviewuse" type="radio" value="Y" <c:if test="${ model.board.BD_SELFVIEWUSE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bdselfviewuse" type="radio" value="N" <c:if test="${ model.board.BD_SELFVIEWUSE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdpswduse" class="col-sm-2 control-label">암호사용여부</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdpswduse" type="radio" value="Y" <c:if test="${ model.board.BD_PSWDUSE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bdpswduse" type="radio" value="N" <c:if test="${ model.board.BD_PSWDUSE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdreplyuse" class="col-sm-2 control-label">답글여부</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdreplyuse" type="radio" value="Y" <c:if test="${ model.board.BD_REPLYUSE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bdreplyuse" type="radio" value="N" <c:if test="${ model.board.BD_REPLYUSE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>
											</div>
											<div class="form-group" class="col-sm-2 control-label">
												<label for="r_bdsorttype" class="col-sm-2 control-label">정렬타입</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdsorttype" type="radio" value="1" <c:if test="${ model.board.BD_SORTTYPE eq 1 }">checked="checked"</c:if>/>1
													</label>
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdviewtype" class="col-sm-2 control-label">뷰타입</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdviewtype" type="radio" value="1" <c:if test="${ model.board.BD_VIEWTYPE eq 1 }">checked="checked"</c:if> />1
													</label>
												</div>
											</div>
											<div class="form-group">
												<label for="r_bdtype" class="col-sm-2 control-label">타입</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bdtype" type="radio" value="M" <c:if test="${ model.board.BD_TYPE eq 'M' }">checked="checked"</c:if> />관리자 전용
													</label>
													<label class="radio-inline">
														<input name="r_bdtype" type="radio" value="N" <c:if test="${ model.board.BD_TYPE eq 'N' }">checked="checked"</c:if> />일반
													</label>
												</div>
											</div>
											<div class="form-group">
												<label for="r_bduse" class="col-sm-2 control-label">승인여부</label>
												<div class="col-sm-10">
													<label class="radio-inline">
														<input name="r_bduse" type="radio" value="Y" <c:if test="${ model.board.BD_USE eq 'Y' }">checked="checked"</c:if> />YES
													</label>
													<label class="radio-inline">
														<input name="r_bduse" type="radio" value="N" <c:if test="${ model.board.BD_USE eq 'N' }">checked="checked"</c:if> />NO
													</label>
												</div>
											</div>
											
										</fieldset>
								
										<div class="ln_solid"></div>
										
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="button" class="btn btn-success btn-sm" onclick="dataUp()"><i class="fa fa-save"></i> 저장</button>
												<button type="submit" class="btn btn-primary btn-sm" onclick="dataList()"><i class="fa fa-list-ul"></i> 리스트</button>
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