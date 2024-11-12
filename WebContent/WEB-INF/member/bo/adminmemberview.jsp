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
		handling.submit( '', 'adminmemberadd' );
	}

	function dataDel(){
		if( confirm('삭제하시겠습니까?' ) ){
			handling.submit( '', 'adminmemberdel' );
		}
	}

	function dataDown(){
		handling.submit( '', 'adminmemberdel' );
	}

	function dataEdit(){
		handling.submit( '', 'adminmemberedit' );
	}

	function dataIn(){
		handling.submit( '', 'adminmemberin' );
	}

	function dataView(){
		handling.submit( '', 'adminmemberview' );
	}

	function dataList(){
		handling.submit( '', 'adminmemberlist' );
	}

	function dataSort(){
		handling.submit( '', 'adminmemberlist' );
	}

	function dataUp(){
		handling.submit( '', 'adminmemberup' );
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
							<h3>회원관리 <small>Memeber Manage</small></h3>
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
									<h2>관리자 리스트 <small>AdminMember List</small></h2>
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

									<form action="adminmemberview" method="post" id="frm" name="frm">
								
									<input name="r_mbid" type="hidden" value="${ model.member.MB_ID }" />
									<c:if test="${ !empty model.member }">
										아이디=${ model.member.MB_ID }<br/>
										이름=${ model.member.MB_NAME }<br/>
								<!--		비밀문자변경일자=${ fn:substring( model.member.MB_PSWDCHDATE, 0, 16 ) }--><br/>
										비밀문자오류횟수=${ model.member.MB_PSWDFAILCNT }<br/>
										회사코드=${ model.member.MB_CPID }<br/>
										부서코드=${ model.member.MB_DPID }<br/>
										우편번호=${ model.member.MB_ZIPCODE }<br/>
										기본주소=${ model.member.MB_ADDR1 }<br/>
										상세주소=${ model.member.MB_ADDR2 }<br/>
										이메일=${ model.member.MB_EMAIL }<br/>
										휴대폰=${ model.member.MB_PHONE }<br/>
										전화번호=${ model.member.MB_TEL }<br/>
										생년월일=${ model.member.MB_BIRTH }<br/>
										이메일수신여부=${ model.member.MB_EMAILUSE }<br/>
										문자수신여부=${ model.member.MB_SMSUSE }<br/>
										레벨=${ model.member.MB_LEVEL }<br/>
										회원타입=${ model.member.MB_TYPE }<br/>
										사용여부=${ model.member.MB_USE }<br/>
										수정아이디=${ model.member.MB_MOID }<br/>
										등록아이디=${ model.member.MB_INID }<br/>
								<!--		수정일=${ fn:substring( model.member.MB_MODATE, 0, 16 ) }--><br/>
								<!--		등록일=${ fn:substring( model.member.MB_INDATE, 0, 16 ) }--><br/>
									</c:if>
								
									
									</form>
									<div class="ln_solid"></div>
									
									<div class="form-group">
										<div class="col-xs-12">
											<button type="button" class="btn btn-success btn-sm" onclick="dataAdd()"><i class="fa fa-plus"></i> 등록</button>
											<button type="button" class="btn btn-warning btn-sm" onclick="dataEdit()"><i class="fa fa-edit"></i> 수정</button>
											<button type="button" class="btn btn-danger btn-sm" onclick="dataDel()"><i class="fa fa-trash"></i> 삭제</button>
											<button type="submit" class="btn btn-primary btn-sm" onclick="dataList()"><i class="fa fa-list-ul"></i> 리스트</button>
								    	</div>
									</div>
									
										
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