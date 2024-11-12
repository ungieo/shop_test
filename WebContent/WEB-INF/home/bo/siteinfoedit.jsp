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
	function dataIn(){
		handling.submit( '', 'siteinfoup' );
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
<fmt:setBundle var="siteinfo" basename="/WEB-INF/system/prop/siteinfo.properties" />
	
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
	
					<form action="infoin" class="form-horizontal" id="frm" name="frm" method="post" enctype="multipart/form-data">
					
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>사이트 정보 관리 <small>Site Infomation Manage</small></h2>
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
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="biznum">사업자등록번호</label>
											<div class="col-sm-3 col-xs-12">
<%-- 												<input class="form-control" name="biznum" placeholder="사업자등록번호" type="text" value="<fmt:message bundle="${siteinfo}" key="biznum"/>" /> --%>
												<input class="form-control" name="biznum" placeholder="사업자등록번호" type="text" value="<%= Cvt.toStr( props.getProperty("biznum") ) %>" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="name">상호</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="name" placeholder="상호" type="text" value="<%= Cvt.toStr( props.getProperty("name") ) %>" />
<%-- 												<input class="form-control" name="name" placeholder="상호" type="text" value="<fmt:message bundle="${siteinfo}" key="shop.name"/>" /> --%>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="ceoname">대표자 성명</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="ceoname" placeholder="대표자 성명" type="text" value="<%= Cvt.toStr( props.getProperty("ceoname") ) %>" />
<%-- 												<input class="form-control" name="ceoname" placeholder="대표자 성명" type="text" value="<fmt:message bundle="${siteinfo}" key="shop.ceoname"/>" /> --%>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="uptai">업태</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="uptai" placeholder="업태" type="text" value="<%= Cvt.toStr( props.getProperty("uptai") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="jongmok">종목</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="jongmok" placeholder="종목" type="text" value="<%= Cvt.toStr( props.getProperty("jongmok") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="zipcode">우편번호</label>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<input type="text" class="form-control" readonly="readonly" placeholder="우편번호" id="zipcode" name="zipcode" value="<%= Cvt.toStr( props.getProperty("zipcode") ) %>">
											</div>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<button type="button" class="btn btn-round btn-info" onclick="getZipcode();">우편번호 검색</button>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbaddr1">기본주소</label>
											<div class="col-md-8 col-sm-10 col-xs-12">
												<input type="text" class="form-control" readonly="readonly" placeholder="기본주소" id="addr1" name="addr1" value="<%= Cvt.toStr( props.getProperty("addr1") ) %>">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="addr2">상세주소</label>
											<div class="col-md-8 col-sm-10 col-xs-12">
												<input type="text" class="form-control" placeholder="상세주소" id="addr2" name="addr2" value="<%= Cvt.toStr( props.getProperty("addr2") ) %>">
											</div>
										</div>
										
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="tel">대표 전화</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="tel" placeholder="대표 전화" type="text" value="<%= Cvt.toStr( props.getProperty("tel") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="fax">대표 팩스</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="fax" placeholder="대표 팩스" type="text" value="<%= Cvt.toStr( props.getProperty("fax") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="email">대표 이메일</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="email" placeholder="대표 이메일" type="text" value="<%= Cvt.toStr( props.getProperty("email") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="domain">쇼핑몰 주소</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="domain" placeholder="쇼핑몰 주소" type="text" value="<%= Cvt.toStr( props.getProperty("domain") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="tongsinnum">통신판매업 신고</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="tongsinnum" placeholder="대표자 성명" type="text" value="<%= Cvt.toStr( props.getProperty("tongsinnum") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="cstel">고객센터 전화</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="cstel" placeholder="고객센터 전화" type="text" value="<%= Cvt.toStr( props.getProperty("cstel") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="csemail">고객센터 이메일</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="csemail" placeholder="고객센터 이메일" type="text" value="<%= Cvt.toStr( props.getProperty("csemail") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="csfax">고객센터 팩스번호</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="csfax" placeholder="대표자 성명" type="text" value="<%= Cvt.toStr( props.getProperty("csfax") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="cstime">고객센터 운영시간</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="cstime" placeholder="고객센터 운영시간" type="text" value="<%= Cvt.toStr( props.getProperty("cstime") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="securityname">개인정보보호 책임자</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="securityname" placeholder="개인정보보호 책임자" type="text" value="<%= Cvt.toStr( props.getProperty("securityname") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="securitydepart">책임자 부서</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="securitydepart" placeholder="책임자 부서" type="text" value="<%= Cvt.toStr( props.getProperty("securitydepart") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="securityposition">책임자 지위</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="securityposition" placeholder="대표자 지위" type="text" value="<%= Cvt.toStr( props.getProperty("securityposition") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="securityphone">책임자 연락처</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="securityphone" placeholder="책임자 연락처" type="text" value="<%= Cvt.toStr( props.getProperty("securityphone") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="securityemail">책임자 이메일</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="securityemail" placeholder="책임자 이메일" type="text" value="<%= Cvt.toStr( props.getProperty("securityemail") ) %>" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="managerphoto">관리자 사진</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="managerphoto" placeholder="관리자 이미지" type="file" value="" accept="image/*"/>
												<input name="managerphotofile" type="hidden" value="<%= Cvt.toStr( props.getProperty("managerphoto") ) %>"/>
											</div>
										</div>
										
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-10 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-2">
												<button type="submit" class="btn btn-success" onclick="dataIn()" >저장</button>
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