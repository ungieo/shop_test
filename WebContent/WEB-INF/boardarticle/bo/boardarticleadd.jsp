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
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
    
<script type="text/javascript">

	$(function(){
		$('form[name="frm"]').validate();
		
		CKEDITOR.replace('editor1', {
			toolbar : 'Basic',
			filebrowserImageUploadUrl : '/soledot_boardarticle/include/imgupload.jsp?type=Images', //파일업로드시 사용
			width : '100%', //---넓이값
			height : '200' //---높이값
		});
		
// 		$('#r_bdabdid').attr('readonly','readonly');
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

	function dataEdit(){
		handling.submit( '', 'boardarticleedit' );
	}

	function dataDel(){
		handling.submit( '', 'boardarticledel' );
	}

	function dataDown(){
		handling.submit( '', 'boardarticledel' );
	}

	function dataIn(){
		$('input[name="r_bdacontent"]').val(CKEDITOR.instances.editor1.getData());
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

	function formSubmit( fName, url ){
		handling.submit( fName, url );
	}

	function pager( fName, url ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( fName, url );
	}

	function pageMove(  ){
		handling.pageMove(url,param);
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
									<h2>게시글 등록 <small>BoardArticle Add</small></h2>
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

									<form action="boardarticlein" class="form-horizontal" id="frm" name="frm" method="post" enctype="multipart/form-data">
<%-- 										<input name="r_bdabdid" type="hidden" value="${ param.r_bdabdid }" /> --%>
										<input name="r_bdacontent" type="hidden" />
										
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdabdid">게시판아이디</label>
											<div class="col-sm-3">
<%-- 													<input id="r_bdabdid" name="r_bdabdid" placeholder="게시판아이디" class="form-control" type="text" value="${ param.r_bdabdid }" required /> --%>
												<select class="form-control" name="r_bdabdid" >
													<c:forEach var="board" items="${ model.boardList }">
														<option value="${board.BD_ID }" <c:if test="${ board.BD_ID eq param.r_bdabdid }">selected="selected"</c:if> >${board.BD_NAME }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdabdcseq">게시글분류</label>
											<div class="col-sm-10">
												<input id="r_bdabdcseq" name="r_bdabdcseq" placeholder="게시글분류" class="form-control" type="text" value="${ model.boardarticle.BDA_BDCSEQ }" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdaname">제목</label>
											<div class="col-sm-10">
												<input id="r_bdaname" name="r_bdaname" placeholder="제목" class="form-control" type="text" value="${ model.boardarticle.BDA_NAME }" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="editor1">내용</label>
											<div class="col-sm-10">
												<input id="editor1" name="editor1" placeholder="내용" class="form-control" type="text" value="${ model.boardarticle.BDA_CONTENT }" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdafilenum">파일첨부</label>
											<div class="col-sm-10">
												<input id="r_flsname" name="r_flsname" placeholder="파일개수" class="form-control" type="file" value="${ model.boardarticle.BDA_FILENUM }" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdambid">작성자아이디</label>
											<div class="col-sm-10">
												<input id="r_bdambid" name="r_bdambid" placeholder="작성자아이디" class="form-control" type="text" value="${ sessionScope.ss_mbid }" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdaownername">작성자명</label>
											<div class="col-sm-10">
												<input id="r_bdaownername" name="r_bdaownername" placeholder="작성자명" class="form-control" type="text" value="${ sessionScope.ss_mbname }" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdapswd">비밀문자</label>
											<div class="col-sm-10">
												<input id="r_bdapswd" name="r_bdapswd" placeholder="비밀문자" class="form-control" type="text" value="${ model.boardarticle.BDA_PSWD }" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdareadcnt">조회수</label>
											<div class="col-sm-10">
												<input id="r_bdareadcnt" name="r_bdareadcnt" placeholder="조회수" class="form-control" type="text" value="${ model.boardarticle.BDA_READCNT }" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdarecommendcnt">추천수</label>
											<div class="col-sm-10">
												<input id="r_bdarecommendcnt" name="r_bdarecommendcnt" placeholder="추천수" class="form-control" type="text" value="${ model.boardarticle.BDA_RECOMMENDCNT }" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdastatus">상태값</label>
											<div class="col-sm-10">
<%-- 												<input id="r_bdastatus" name="r_bdastatus" placeholder="상태값" class="form-control" type="text" value="${ model.boardarticle.BDA_STATUS }" /> --%>
												<label class="radio-inline"><input name="r_bdastatus" type="radio" value="0" checked="checked"/>일반</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdalevel">레벨</label>
											<div class="col-sm-10">
<%-- 												<input id="r_bdalevel" name="r_bdalevel" placeholder="레벨" class="form-control" type="text" value="${ model.boardarticle.BDA_LEVEL }" /> --%>
												<label class="radio-inline"><input name="r_bdalevel" type="radio" value="N" checked="checked"/>일반</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="r_bdatype">타입</label>
											<div class="col-sm-10">
<%-- 												<input id="r_bdatype" name="r_bdatype" placeholder="타입" class="form-control" type="text" value="${ model.boardarticle.BDA_TYPE }" /> --%>
												<label class="radio-inline"><input name="r_bdatype" type="radio" value="N" checked="checked"/>일반</label>
											</div>
										</div>
										
										<div class="form-group">
											<label for="r_bdause" class="col-sm-2 control-label">사용여부</label>
											<div class="col-sm-10">
												<label class="radio-inline"><input name="r_bdause" type="radio" value="Y" checked="checked" />YES</label>
												<label class="radio-inline"><input name="r_bdause" type="radio" value="N" />NO</label>
											</div>
										</div>
										
										
										<div class="ln_solid"></div>
										
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="button" class="btn btn-success btn-sm" onclick="dataIn()"><i class="fa fa-save"></i> 저장</button>
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
