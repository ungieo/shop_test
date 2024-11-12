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
<%-- 	<link href="${cpath}/include/css/animate.min.css" rel="stylesheet"> --%>
	<!-- Custom styling plus plugins -->
	<link href="${cpath}/include/css/custom.css" rel="stylesheet">
<%-- 	<link href="${cpath}/include/css/icheck/flat/green.css" rel="stylesheet"> --%>
	<!-- editor -->
	
<%-- 	<link href="${cpath}/include/css/editor/external/google-code-prettify/prettify.css" rel="stylesheet"> --%>
<%-- 	<link href="${cpath}/include/css/editor/index.css" rel="stylesheet"> --%>
	<!-- select2 -->
<%-- 	<link href="${cpath}/include/css/select/select2.min.css" rel="stylesheet"> --%>
	<!-- switchery -->
<%-- 	<link href="${cpath}/include/css/switchery/switchery.min.css" rel="stylesheet" /> --%>


	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">			<!-- jquery ui css google cdn -->
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>	<!-- jquery cdn -->
	<script src="${ cpath }/include/soledot/js/soledot.js"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>		<!-- 우편번호 검색 서비스 -->
	
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
		$( 'input[name="r_mbbirth"]' ).datepicker({
			changeYear: true,
			yearRange : 'c-50:c+10',
			showButtonPanel: true,
		    dateFormat: "yy-mm-dd",
// 			showOn: 'button',
			maxDate : 0
// 			buttonImage : '',
// 			buttonImageOnly : true
		});
		$( '#dialog' ).dialog({
			autoOpen : false
		});
		
		$('#r_mbcpid' ).on( 'change', selHandling );
		
	});
	
	function selHandling( e ){
		var r_cpdcpid = $( this ).val();
		
		$( '#r_mbdpid option:gt(0)' ).remove();
		var param = 'r_cpdcpid='+r_cpdcpid;
		
		var options = {
			data : param,
			error : function( xhr, textStatus, error ){
				alert(error);
			},
			success : function( data ){
				for( var i = 0,n=data.length; i < n; i++){
					$( '#r_mbdpid' ).append('<option value="'+data[i].cpd_id+'">'+data[i].cpd_name+'</option>');
				}
			},
			type : 'POST',
			url : '${cpath}/companydepartment/bo/companydepartmentlistjson'
		}
		dataAjax( options );
	}
	
	function dataAdd(){
		handling.submit( '', 'adminmemberadd' );
	}
	
	function dataAjax( options ){
		$.ajax(options);
	}
	
	function dataEdit(){
		handling.submit( '', 'adminmemberedit' );
	}

	function dataDel(){
		handling.submit( '', 'adminmemberdel' );
	}

	function dataDown(){
		handling.submit( '', 'adminmemberdel' );
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
	
	
	function getZipcode(){
		daum.postcode.load(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	            	document.getElementsByName( "r_mbzipcode" )[0].value = data.zonecode;
		        	document.getElementsByName( "r_mbaddr1" )[0].value = data.roadAddress;
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


						<div class="col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										관리자 수정 <small>AdminMember Edit</small>
									</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
										<li class="dropdown">
											<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
											<ul class="dropdown-menu" role="menu">
												<li><a href="#">Settings 1</a></li>
												<li><a href="#">Settings 2</a></li>
											</ul>
										</li>
										<li><a class="close-link"><i class="fa fa-close"></i></a></li>
									</ul>
									<div class="clearfix"></div>
								</div>
								
								<div class="x_content">
								
									<form class="form-horizontal form-label-left" action="adminmemberup" method="post" name="frm" id="frm" >
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbid">아이디</label>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<input type="text" class="form-control" placeholder="아이디" id="r_mbid" name="r_mbid" readonly="readonly" value="${ model.member.MB_ID }">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbname">이름</label>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<input type="text" class="form-control" onclick="idreadonly(null)" placeholder="아이디" id="r_mbname" name="r_mbname" value="${ model.member.MB_NAME }">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbpswd">비밀번호</label>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<input type="password" class="form-control" placeholder="비밀번호" id="r_mbpswd" name="r_mbpswd" value="">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbpswd">암호확인</label>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<input type="password" class="form-control" placeholder="비밀번호확인"  id="r_mbpswd" name="r_mbpswd" value="">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbcpid">회사코드</label>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<select class="form-control" name="r_mbcpid" id="r_mbcpid" >
													<option value="N">일반회원</option>
													<c:forEach var="company" items="${ model.companyList }">
														<option value="${company.CP_ID }" <c:if test="${ company.CP_ID eq model.member.MB_CPID }">selected="selected"</c:if> >${ company.CP_NAME }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbdpid">부서코드</label>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<select class="form-control" name="r_mbdpid" id="r_mbdpid" >
													<option value="N">일반회원</option>
													<c:forEach var="companydepartment" items="${ model.companydepartmentList }">
														<option value="${ companydepartment.CPD_ID }" <c:if test="${ companydepartment.CPD_ID eq model.member.MB_DPID }">selected="selected"</c:if> >${ companydepartment.CPD_NAME }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbzipcode">우편번호</label>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<input type="text" class="form-control" readonly="readonly" placeholder="우편번호" id="r_mbzipcode" name="r_mbzipcode" value="${ model.member.MB_ZIPCODE }">
											</div>
											<div class="col-md-3 col-sm-3 col-xs-12">
												<button type="button" class="btn btn-round btn-info" onclick="getZipcode();">우편번호 검색</button>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbaddr1">기본주소</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<input type="text" class="form-control" readonly="readonly" placeholder="기본주소" id="r_mbaddr1" name="r_mbaddr1" value="${ model.member.MB_ADDR1 }">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbaddr2">상세주소</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<input type="text" class="form-control" placeholder="상세주소" id="r_mbaddr2" name="r_mbaddr2" value="${ model.member.MB_ADDR2 }">
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbemail">이메일</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<input type="text" class="form-control" placeholder="이메일" id="r_mbemail" name="r_mbemail" value="${ model.member.MB_EMAIL }">
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbphone">휴대폰</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<input type="text" class="form-control" placeholder="휴대폰" id="r_mbphone" name="r_mbphone" value="${ model.member.MB_PHONE }">
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbtel">전화번호</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<input type="text" class="form-control" placeholder="전화번호" id="r_mbtel" name="r_mbtel" value="${ model.member.MB_TEL }">
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbbirth">생년월일</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<input type="text" class="form-control" placeholder="생년월일" id="r_mbbirth" name="r_mbbirth" readonly="readonly" value="${ model.member.MB_BIRTH }">
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbsex">성별</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<label class="radio-inline"><input name="r_mbsex" type="radio" value="1" <c:if test="${ model.member.MB_SEX eq '1' }">checked="checked"</c:if> />남성</label>
												<label class="radio-inline"><input name="r_mbsex" type="radio" value="2" <c:if test="${ model.member.MB_SEX eq '2' }">checked="checked"</c:if> />여성</label>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbemailuse">이메일수신여부</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<label class="radio-inline"><input name="r_mbemailuse" type="radio" value="Y" <c:if test="${ model.member.MB_EMAILUSE eq 'Y' }">checked="checked"</c:if> />YES</label>
												<label class="radio-inline"><input name="r_mbemailuse" type="radio" value="N" <c:if test="${ model.member.MB_EMAILUSE eq 'N' }">checked="checked"</c:if> />NO</label>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbsmsuse">문자수신여부</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<label class="radio-inline"><input name="r_mbsmsuse" type="radio" value="Y" <c:if test="${ model.member.MB_SMSUSE eq 'Y' }">checked="checked"</c:if> />YES</label>
												<label class="radio-inline"><input name="r_mbsmsuse" type="radio" value="N" <c:if test="${ model.member.MB_SMSUSE eq 'N' }">checked="checked"</c:if> />NO</label>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mblevel">레벨</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<label class="radio-inline"><input name="r_mblevel" type="radio" value="N" <c:if test="${ model.member.MB_LEVEL eq 'N' }">checked="checked"</c:if> />일반</label>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbtype" >회원타입</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<label class="radio-inline"><input name="r_mbtype" type="radio" value="N" <c:if test="${ model.member.MB_TYPE eq 'N' }">checked="checked"</c:if> />일반</label>
												<label class="radio-inline"><input name="r_mbtype" type="radio" value="P" <c:if test="${ model.member.MB_TYPE eq 'P' }">checked="checked"</c:if> />구매사</label>
												<label class="radio-inline"><input name="r_mbtype" type="radio" value="S" <c:if test="${ model.member.MB_TYPE eq 'S' }">checked="checked"</c:if> />공급사</label>
												<label class="radio-inline"><input name="r_mbtype" type="radio" value="M" <c:if test="${ model.member.MB_TYPE eq 'M' }">checked="checked"</c:if> />관리자</label>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-2 col-sm-2 col-xs-12" for="r_mbuse">사용여부</label>
											<div class="col-md-10 col-sm-10 col-xs-12">
												<label class="radio-inline"><input name="r_mbuse" type="radio" value="Y" <c:if test="${ model.member.MB_USE eq 'Y' }">checked="checked"</c:if> />YES</label>
												<label class="radio-inline"><input name="r_mbuse" type="radio" value="N" <c:if test="${ model.member.MB_USE eq 'N' }">checked="checked"</c:if> />NO</label>
											</div>
										</div>
										
										<div class="ln_solid"></div>
										
										<div class="form-group">
											<div class="col-md-10 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-2">
												<button type="submit" class="btn btn-success btn-sm" onclick="dataUp()" ><i class="fa fa-save"></i> 저장</button>
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
		<ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
		</ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>



	<script src="${cpath }/include/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>	<!-- jquery ui cdn -->
	<script type="text/javascript" src="${cpath }/include/js/datepicker/jquery.ui.datepicker-ko.js"></script>
	<script>
//     autosize($('.resizable_textarea'));
  </script>
  
	<!-- pace -->
	<script src="${cpath }/include/js/pace/pace.min.js"></script>
	<script src="${cpath }/include/js/custom.js"></script>


  
<div id="dialog" title="아이디 중복 체크 결과" >
	</div>
</body>
</html>