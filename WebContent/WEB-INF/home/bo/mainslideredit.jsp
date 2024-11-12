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
	function dataUp(){
		handling.submit( '', 'mainsliderup' );
	}
	
	function getZipcode(){
		daum.postcode.load(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	            	document.getElementsByName( "zipcode" )[0].value = data.zonecode;
		        	document.getElementsByName( "addr1" )[0].value = data.roadAddress;
	            }
	        }).open();
	    });
	}
	
</script>

</head>
<body class="nav-md">
<%-- <fmt:setBundle var="shopinfo" basename="system.resource.prop.shopinfo" /> --%>
	
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
	
					<form action="mainsliderup" class="form-horizontal" id="frm" name="frm" method="post" enctype="multipart/form-data">
					
						<div class="row">
							<div class="col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>메인 슬라이더 관리 <small>Main Slider Manage</small></h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
	<!-- 										<li class="dropdown"> -->
	<!-- 											<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a> -->
	<!-- 											<ul class="dropdown-menu" role="menu"> -->
	<!-- 												<li><a href="#">Settings 1</a></li> -->
	<!--                              						<li><a href="#">Settings 2</a></li> -->
	<!--                            					</ul> -->
	<!--                        					</li> -->
											<li><a class="close-link"><i class="fa fa-close"></i></a></li>
	                       				</ul>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
									
										<c:forEach begin="0" end="3" varStatus="status">
											<div class="form-group">
												<label class="control-label col-sm-3 col-xs-12" for="r_mainslider${status.count}">슬라이드 기존이미지${status.count}</label>
												<div class="col-sm-9 col-xs-12">
													<img class="img-responsive" src="${cpath}/data/up/shopinfo/${model.filestorageList[status.index].FLS_NAME}"/>
													<input name="r_mainsliderfile${status.count}" type="hidden" value="${model.filestorageList[status.index].FLS_NAME}"/>
												</div>
											</div>
											
											<div class="form-group">
												<label class="control-label col-sm-3 col-xs-12" for="r_mainslider${status.count}">변경 이미지</label>
												<div class="col-sm-9 col-xs-12">
													<input class="form-control" id="r_mainslider${status.count}" name="r_mainslider${status.count}" placeholder="변경이미지" type="file" accept="image/*" />
												</div>
											</div>
											
											<div class="form-group">
												<label class="control-label col-sm-3 col-xs-12" for="r_mainsliderlink${status.count}">링크</label>
												<div class="col-sm-9 col-xs-12">
													<input class="form-control" name="r_mainsliderlink${status.count}" type="text" placeholder="링크"  value="${ model.filestorageList[status.index].FLS_LINK }"/>
												</div>
											</div>
													
										</c:forEach>
									
										<div class="ln_solid"></div>
										
										<div class="form-group">
											<div class="col-sm-12 text-center">
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