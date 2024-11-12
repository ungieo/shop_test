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
	});

	function dataAjax(){
	var param = '';

		$.ajax({
			async : false,
			data : param,
			//dataType : 'json',
			complete: function( xhr, textStatus ){
				//응답처리
			},
			error : function( xhr, textStatus, erroThrown ){
				alert( '처리 중 오류가 발생되었습니다. '+textStatus );
			},
			success : function( data, textStatus ){
			},
			type : 'POST',
			url : '${cpath}/'
		});
	}

	function dataAdd(){
		handling.submit( '', 'companyadd' );
	}

	function dataDel(){
		handling.submit( '', 'companydel' );
	}

	function dataDown( r_flsseq ){
		handling.pageMove( '${cpath}/system/filedown', 'r_flsseq='+r_flsseq );
	}

	function dataEdit(){
		handling.submit( '', 'companyedit' );
	}

	function dataIn(){
		handling.submit( '', 'companyin' );
	}

	function dataView(){
		handling.submit( '', 'companyview' );
	}

	function dataList(){
		handling.pageMove( 'companylist', '' );
	}

	function dataSort(){
		handling.submit( '', 'companylist' );
	}

	function dataUp(){
		handling.submit( '', 'companyup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
	}

	function pager( r_page ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( '', '' );
	}

	function pageMove(  ){
		handling.pageMove( r_url, param);
	}
	
	function getZipcode(){
		daum.postcode.load(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	            	document.getElementsByName( "r_cpzipcode" )[0].value = data.zonecode;
		        	document.getElementsByName( "r_cpaddr1" )[0].value = data.roadAddress;
	            }
	        }).open();
	    });
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
							<h3>협력사 관리 <small>Company Manage</small></h3>
						</div>	
						<div class="title_right">
							<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input class="form-control"  type="text" class="form-control" placeholder="Search for..." />
									<span class="input-group-btn"><button class="btn btn-default" type="button">Go!</button></span>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
	
					<form action="companyup" class="form-horizontal form-label-left" id="frm" name="frm" method="post" enctype="multipart/form-data">
						<input name="r_cpseq" type="hidden" value="${ model.company.CP_SEQ }" />
					
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>협력사 등록 <small>Company Add</small></h2>
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
										
										<fieldset>
<!-- 											<legend>companyadd</legend> -->
								<!-- 			<div class="form-group"> -->
								<!-- 				<label class="col-sm-2 control-label" for="r_cpseq">고유번호</label> -->
								<%-- 				<input class="form-control"  id="r_cpseq" name="r_cpseq" placeholder="고유번호" type="text" value="<c:out value='${ model.company.CP_SEQ }' />" required /> --%>
								<!-- 			</div> -->
											<div class="form-group">
												<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_cpid">회사아이디</label>
												<div class="col-md-3 col-sm-3 col-xs-12">
													<input class="form-control"  id="r_cpid" name="r_cpid" placeholder="회사아이디" type="text" readonly="readonly" value="<c:out value='${ model.company.CP_ID }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_cpname">회사명</label>
												<div class="col-md-3 col-sm-3 col-xs-12">
													<input class="form-control"  id="r_cpname" name="r_cpname" placeholder="회사명" type="text" value="<c:out value='${ model.company.CP_NAME }' />" required />
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_cpbiznum">사업자번호</label>
												<div class="col-md-3 col-sm-3 col-xs-12">
													<input class="form-control"  id="r_cpbiznum" name="r_cpbiznum" placeholder="사업자번호" type="text" value="<c:out value='${ model.company.CP_BIZNUM }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_cpuptai">업태</label>
												<div class="col-md-3 col-sm-3 col-xs-12">
													<input class="form-control"  id="r_cpuptai" name="r_cpuptai" placeholder="업태" type="text" value="<c:out value='${ model.company.CP_UPTAI }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_cpupjong">업종</label>
												<div class="col-md-3 col-sm-3 col-xs-12">
													<input class="form-control"  id="r_cpupjong" name="r_cpupjong" placeholder="업종" type="text" value="<c:out value='${ model.company.CP_UPJONG }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_cpceoname">대표명</label>
												<div class="col-md-3 col-sm-3 col-xs-12">
													<input class="form-control"  id="r_cpceoname" name="r_cpceoname" placeholder="대표명" type="text" value="<c:out value='${ model.company.CP_CEONAME }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 col-xs-12 control-label" for="r_cpzipcode">우편번호</label>
												<div class="col-sm-3 col-xs-12">
													<input class="form-control"  id="r_cpzipcode" name="r_cpzipcode"  type="text" value="<c:out value='${ model.company.CP_ZIPCODE }' />" readonly="readonly" required />
												</div>
												<div class="col-sm-3 col-xs-12">
													<button type="button" class="btn btn-round btn-info" onclick="getZipcode();">우편번호 검색</button>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cpaddr1">기본주소</label>
												<div class="col-sm-10">
													<input class="form-control"  id="r_cpaddr1" name="r_cpaddr1" placeholder="기본주소" type="text" value="<c:out value='${ model.company.CP_ADDR1 }' />" readonly="readonly" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cpaddr2">상세주소</label>
												<div class="col-sm-10">
													<input class="form-control"  id="r_cpaddr2" name="r_cpaddr2" placeholder="상세주소" type="text" value="<c:out value='${ model.company.CP_ADDR2 }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cpfile">파일</label>
												<div class="col-sm-10">
													<input class="form-control"  id="r_cpfile" name="r_cpfile" placeholder="파일" type="file" value="<c:out value='${ model.company.CP_FILE }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cpdeliverymoney">배송비</label>
												<div class="col-sm-10">
													<input class="form-control"  id="r_cpdeliverymoney" name="r_cpdeliverymoney" placeholder="배송비" type="text" value="<c:out value='${ model.company.CP_DELIVERYMONEY }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cppaytype">결제타입</label>
												<div class="col-sm-10">
													<label class="radio-inline"><input name="r_cppaytype" type="radio" value="1" <c:if test="${ model.company.CP_PAYTYPE eq 1 }">checked="checked"</c:if>  />현금</label>
													<label class="radio-inline"><input name="r_cppaytype" type="radio" value="2" <c:if test="${ model.company.CP_PAYTYPE eq 2 }">checked="checked"</c:if> />카드</label>
													<label class="radio-inline"><input name="r_cppaytype" type="radio" value="3" <c:if test="${ model.company.CP_PAYTYPE eq 3 }">checked="checked"</c:if> />예산</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cpbiztype">회사타입</label>
												<div class="col-sm-10">
													<input class="form-control"  id="r_cpbiztype" name="r_cpbiztype" placeholder="회사타입" type="text" value="<c:out value='${ model.company.CP_BIZTYPE }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cptongsinbiznum">통신사업자</label>
												<div class="col-sm-10">
													<input class="form-control"  id="r_cptongsinbiznum" name="r_cptongsinbiznum" placeholder="통신사업자" type="text" value="<c:out value='${ model.company.CP_TONGSINBIZNUM }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cpemail">이메일</label>
												<div class="col-sm-10">
													<input class="form-control"  id="r_cpemail" name="r_cpemail" placeholder="이메일" type="text" value="<c:out value='${ model.company.CP_EMAIL }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cptel">전화</label>
												<div class="col-sm-10">
													<input class="form-control"  id="r_cptel" name="r_cptel" placeholder="전화" type="text" value="<c:out value='${ model.company.CP_TEL }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cpphone">휴대전화</label>
												<div class="col-sm-10">
													<input class="form-control"  id="r_cpphone" name="r_cpphone" placeholder="휴대전화" type="text" value="<c:out value='${ model.company.CP_PHONE }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cpfax">팩스</label>
												<div class="col-sm-10">
													<input class="form-control"  id="r_cpfax" name="r_cpfax" placeholder="팩스" type="text" value="<c:out value='${ model.company.CP_FAX }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cplevel">레벨</label>
												<div class="col-sm-10">
													<label class="radio-inline"><input name="r_cplevel" type="radio" value="N" <c:if test="${ model.company.CP_LEVEL eq 'N' }">checked="checked"</c:if> />일반</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cptype">타입</label>
												<div class="col-sm-10">
													<label class="radio-inline"><input name="r_cptype" type="radio" value="N" <c:if test="${ model.company.CP_TYPE eq 'N' }">checked="checked"</c:if> />일반</label>
													<label class="radio-inline"><input name="r_cptype" type="radio" value="S" <c:if test="${ model.company.CP_TYPE eq 'S' }">checked="checked"</c:if> />공급사</label>
													<label class="radio-inline"><input name="r_cptype" type="radio" value="P" <c:if test="${ model.company.CP_TYPE eq 'P' }">checked="checked"</c:if> />구매사</label>
													<label class="radio-inline"><input name="r_cptype" type="radio" value="M" <c:if test="${ model.company.CP_TYPE eq 'M' }">checked="checked"</c:if>  />운영사</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label" for="r_cpuse">사용여부</label>
												<div class="col-sm-10">
													<label class="radio-inline"><input name="r_cpuse" type="radio" value="Y" <c:if test="${ model.company.CP_USE eq 'Y' }">checked="checked"</c:if> />YES</label>
													<label class="radio-inline"><input name="r_cpuse" type="radio" value="N" <c:if test="${ model.company.CP_USE eq 'N' }">checked="checked"</c:if> />NO</label>
												</div>
											</div>
										</fieldset>
										
										<div class="ln_solid"></div>
										
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="button" class="btn btn-success btn-sm" onclick="dataUp()"><i class="fa fa-save"></i> 저장</button>
												<button type="button" class="btn btn-primary btn-sm" onclick="dataList();"><i class="fa fa-list-ul"></i> 리스트</button>
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