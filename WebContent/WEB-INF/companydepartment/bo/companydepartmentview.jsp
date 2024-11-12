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
	<link href="${cpath}/include/css/bootstrap.min.css" rel="stylesheet" />
	
	<link href="${cpath}/include/fonts/css/font-awesome.min.css" rel="stylesheet" />
	<link href="${cpath}/include/css/animate.min.css" rel="stylesheet" />
	
	<!-- Custom styling plus plugins -->
	<link href="${cpath}/include/css/custom.css" rel="stylesheet" />
	
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>	<!-- jquery cdn -->
	
	<script src="${ cpath }/include/soledot/js/soledot.js"></script>

	<!--[if lt IE 9]>
	<script src="../assets/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->

<script type="text/javascript">

	$(function(){
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
		handling.submit( '', 'companydepartmentadd' );
	}

	function dataDel( r_cpdseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_cpdseq').val( r_cpdseq );
		handling.submit( '', 'companydepartmentdel' );
	}

	function dataDown(){
		handling.submit( '', 'companydepartmentdown' );
	}

	function dataEdit(){
		handling.submit( '', 'companydepartmentedit' );
	}

	function dataIn(){
		handling.submit( '', 'companydepartmentin' );
	}

	function dataView(){
		handling.submit( '', 'companydepartmentview' );
	}

	function dataList(){
		handling.submit( '', 'companydepartmentlist' );
	}

	function dataSort(){
		handling.submit( '', 'companydepartmentlist' );
	}

	function dataUp( r_cpdseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_cpdseq').val( r_cpdseq );
		handling.submit( '', 'companydepartmentup' );
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
									<input class="form-control" type="text" class="form-control" placeholder="Search for..." />
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
									<h2>협력사부서 등록 <small>Company Department Add</small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a></li>
                       				</ul>
									<div class="clearfix"></div>
								</div>
								
								<div class="x_content">

									<form action="companydepartmentview" id="frm" name="frm" method="post" >
										<input name="r_cpdseq" type="hidden" value="${ model.companydepartment.CPD_SEQ }" />
									</form>
								
									<c:if test="${ !empty model.companydepartment }">
										고유번호=<c:out value='${ model.companydepartment.CPD_SEQ }' /><br/>
										회사아이디=<c:out value='${ model.companydepartment.CPD_CPID }' /><br/>
										부서아이디=<c:out value='${ model.companydepartment.CPD_ID }' /><br/>
										부서명=<c:out value='${ model.companydepartment.CPD_NAME }' /><br/>
										결제타입=<c:out value='${ model.companydepartment.CPD_PAYTYPE }' /><br/>
										이메일=<c:out value='${ model.companydepartment.CPD_EMAIL }' /><br/>
										전화=<c:out value='${ model.companydepartment.CPD_TEL }' /><br/>
										휴대전화=<c:out value='${ model.companydepartment.CPD_PHONE }' /><br/>
										팩스=<c:out value='${ model.companydepartment.CPD_FAX }' /><br/>
										레벨=<c:out value='${ model.companydepartment.CPD_LEVEL }' /><br/>
										타입 N=일반=<c:out value='${ model.companydepartment.CPD_TYPE }' /><br/>
										승인여부=<c:out value='${ model.companydepartment.CPD_USE }' /><br/>
										수정아이디=<c:out value='${ model.companydepartment.CPD_MOID }' /><br/>
										등록아이디=<c:out value='${ model.companydepartment.CPD_INID }' /><br/>
								<!--		수정일=${ fn:substring( model.companydepartment.CPD_MODATE, 0, 16 ) }--><br/>
								<!--		등록일=${ fn:substring( model.companydepartment.CPD_INDATE, 0, 16 ) }--><br/>
									</c:if>
								
									<div class="ln_solid"></div>
									
									<div class="form-group">
										<div class="col-xs-12">
									       <button type="button" class="btn btn-success btn-sm" onclick="dataAdd();"><i class="fa fa-plus"></i> 등록</button>
									       <button type="button" class="btn btn-warning btn-sm" onclick="dataEdit();"><i class="fa fa-edit"></i> 수정</button>
									       <button type="button" class="btn btn-danger btn-sm" onclick="dataDel();"><i class="fa fa-trash"></i> 삭제</button>
									       <button type="button" class="btn btn-primary btn-sm" onclick="dataList();"><i class="fa fa-list-ul"></i> 리스트</button>
										</div>
									</div>
									
	
								</div> <!-- xcontent end -->
							</div>
						</div>
					</div> <!-- row end -->
					
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
	<script src="${cpath}/include/js/pace/pace.min.js"></script>
	
</body>
</html>