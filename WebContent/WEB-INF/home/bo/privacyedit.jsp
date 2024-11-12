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
	
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>	<!-- jquery cdn -->

<!-- 	<script type="text/javascript" src="//cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script> -->
	
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
// 		CKEDITOR.replace('editor1', {
// 			toolbar : 'Basic',
// 			toolbarCanCollapse : true,
// 			filebrowserImageUploadUrl : '/soledot_product/include/imgupload.jsp?type=Images', //파일업로드시 사용
// 			height : 500
// 		});
	});
	function dataUp(){
// 		$('input[name="r_cmtvalue"]').val(CKEDITOR.instances.editor1.getData());
		handling.submit( '', 'privacyup' );
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
							<h3>기본정보 관리 <small>Default Infomation Manage</small></h3>
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
	
					<form action="privacyup" class="form-horizontal" id="frm" name="frm" method="post" >
						<input name="r_cmtseq" type="hidden" value="${ model.commontext.CMT_SEQ }" />
<!-- 						<input name="r_cmtvalue" type="hidden" />  -->
					
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>개인정보처리방침 관리<small>Persnal Infomation Securit Manage</small></h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
											<li><a class="close-link"><i class="fa fa-close"></i></a></li>
	                       				</ul>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="editor1">${ model.commontext.CMT_NAME }</label>
											<div class="col-sm-10 col-xs-12">
<%-- 												<textarea class="form-control" id="editor1" name="editor1" placeholder="개인정보처리방침">${ model.commontext.CMT_VALUE }</textarea> --%>
												<textarea class="form-control" name="r_cmtvalue" placeholder="${ model.commontext.CMT_NAME }" rows="20">${ model.commontext.CMT_VALUE }</textarea>
											</div>
										</div>
										
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-10 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-2">
												<button type="submit" class="btn btn-success" onclick="dataUp()" >저장</button>
											</div>
										</div>
										
										
									</div>
								</div>
							</div>
						</div>
					
					</form>
					
					
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