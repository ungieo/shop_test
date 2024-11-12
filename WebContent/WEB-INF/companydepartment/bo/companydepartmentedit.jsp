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
// 		$('form[name="frm"]').validate();
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
									<form action="companydepartmentin" class="form-horizontal" id="frm" name="frm" method="post" >
								
										<fieldset>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdcpid">회사아이디</label>
												<div class="col-sm-10">
													<select class="form-control" name="r_cpdcpid" >
														<c:forEach var="company" items="${ model.companyList }">
															<option value="${ company.CP_ID }" <c:if test="${ company.CP_ID eq model.companydepartment.CPD_CPID }">selected="selected"</c:if> >${ company.CP_NAME }</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdid">부서아이디</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdid" name="r_cpdid" placeholder="부서아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_ID }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdname">부서명</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdname" name="r_cpdname" placeholder="부서명" type="text" value="<c:out value='${ model.companydepartment.CPD_NAME }' />" required />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdpaytype">결제타입</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdpaytype" name="r_cpdpaytype" placeholder="결제타입" type="text" value="<c:out value='${ model.companydepartment.CPD_PAYTYPE }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdemail">이메일</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdemail" name="r_cpdemail" placeholder="이메일" type="text" value="<c:out value='${ model.companydepartment.CPD_EMAIL }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdtel">전화</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdtel" name="r_cpdtel" placeholder="전화" type="text" value="<c:out value='${ model.companydepartment.CPD_TEL }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdphone">휴대전화</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdphone" name="r_cpdphone" placeholder="휴대전화" type="text" value="<c:out value='${ model.companydepartment.CPD_PHONE }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdfax">팩스</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdfax" name="r_cpdfax" placeholder="팩스" type="text" value="<c:out value='${ model.companydepartment.CPD_FAX }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdlevel">레벨</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdlevel" name="r_cpdlevel" placeholder="레벨" type="text" value="<c:out value='${ model.companydepartment.CPD_LEVEL }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdtype">타입</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdtype" name="r_cpdtype" placeholder="타입 N=일반" type="text" value="<c:out value='${ model.companydepartment.CPD_TYPE }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpduse">승인여부</label>
												<div class="col-sm-10">
													<label class="radio-inline"><input name="r_cpduse" type="radio" value="Y" placeholder="승인여부" <c:if test="${ model.companydepartment.CPD_USE eq 'Y' }">checked="checked"</c:if> />YES</label>
													<label class="radio-inline"><input name="r_cpduse" type="radio" value="N" placeholder="승인여부" <c:if test="${ model.companydepartment.CPD_USE eq 'N' }">checked="checked"</c:if> />NO</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdmoid">수정아이디</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdmoid" name="r_cpdmoid" placeholder="수정아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_MOID }' />" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label"  for="r_cpdinid">등록아이디</label>
												<div class="col-sm-10">
													<input class="form-control" id="r_cpdinid" name="r_cpdinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.companydepartment.CPD_INID }' />" />
												</div>
											</div>
										</fieldset>
										
										<div class="ln_solid"></div>
										
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="button" class="btn btn-success btn-sm" onclick="dataIn()"><i class="fa fa-save"></i> 저장</button>
												<button type="submit" class="btn btn-primary btn-sm" onclick="dataList()"><i class="fa fa-list-ul"></i> 리스트</button>
									    	</div>
										</div>
										
									</form>
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