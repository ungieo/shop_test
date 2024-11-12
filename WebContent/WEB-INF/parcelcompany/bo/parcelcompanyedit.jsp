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
	
	<title>Welcome SoleDot!</title>

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
		handling.submit( '', 'parcelcompanyadd' );
	}

	function dataDel( r_pcseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_pcseq').val( r_pcseq );
		handling.submit( '', 'parcelcompanydel' );
	}

	function dataDown(){
		handling.submit( '', 'parcelcompanydown' );
	}

	function dataEdit(){
		handling.submit( '', 'parcelcompanyedit' );
	}

	function dataIn(){
		handling.submit( '', 'parcelcompanyin' );
	}

	function dataView(){
		handling.submit( '', 'parcelcompanyview' );
	}

	function dataList(){
		handling.submit( '', 'parcelcompanylist' );
	}

	function dataSort(){
		handling.submit( '', 'parcelcompanylist' );
	}

	function dataUp( r_pcseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?") ){;
			return;
		}
		$('#r_pcseq').val( r_pcseq );
		handling.submit( '', 'parcelcompanyup' );
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
							<h3>기본정보관리 <small>Default Infomation Manage</small></h3>
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
									<h2>배송업체 검색 <small>Parcel Company Search</small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a></li>
                       				</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<form action="parcelcompanyup" class="form-horizontal" id="frm" name="frm" method="post" >
										<input type="hidden" name="r_pcseq" id="r_pcseq" />
							
<!-- 										<div class="form-group"> -->
<!-- 											<label class="control-label col-sm-2"class="control-label col-sm-2" for="r_pcseq">고유값</label> -->
<!-- 											<div class="col-sm-6"> -->
<%-- 												<input class="form-control" class="form-control" id="r_pcseq" name="r_pcseq" placeholder="고유값" type="text" value="<c:out value='${ model.parcelcompany.PC_SEQ }' />" required /> --%>
<!-- 											</div> -->
<!-- 										</div> -->
										<div class="form-group">
											<label class="control-label col-sm-2"for="r_pcname">택배사명</label>
											<div class="col-sm-6">
												<input class="form-control" id="r_pcname" name="r_pcname" placeholder="택배사명" type="text" value="<c:out value='${ model.parcelcompany.PC_NAME }' />" required />
											</div>
										</div>
<!-- 										<div class="form-group"> -->
<!-- 											<label class="control-label col-sm-2"for="r_pccpid">회사설정</label> -->
<!-- 											<div class="col-sm-6"> -->
<%-- 												<input class="form-control" id="r_pccpid" name="r_pccpid" placeholder="회사설정" type="text" value="<c:out value='${ model.parcelcompany.PC_CPID }' />" required /> --%>
<!-- 											</div> -->
<!-- 										</div> -->
										<div class="form-group">
											<label class="control-label col-sm-2"for="r_pcurl">택배사URL</label>
											<div class="col-sm-6">
												<input class="form-control" id="r_pcurl" name="r_pcurl" placeholder="택배사URL" type="text" value="<c:out value='${ model.parcelcompany.PC_URL }' />" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2"for="r_pclevel">레벨</label>
											<div class="col-sm-6">
												<input class="form-control" id="r_pclevel" name="r_pclevel" placeholder="레벨" type="text" value="<c:out value='${ model.parcelcompany.PC_LEVEL }' />" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2"for="r_pctype">타입</label>
											<div class="col-sm-6">
<%-- 												<input class="form-control" id="r_pctype" name="r_pctype" placeholder="타입" type="text" value="<c:out value='${ model.parcelcompany.PC_TYPE }' />" /> --%>
												<label class="radio-inline">
													<input name="r_pctype" type="radio" value="M" <c:if test="${ model.parcelcompany.PC_TYPE eq 'M' }">checked="checked"</c:if> />관리자
												</label>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2"for="r_pcuse">사용여부</label>
											<div class="col-sm-6">
<%-- 												<input class="form-control" id="r_pcuse" name="r_pcuse" placeholder="사용여부" type="text" value="<c:out value='${ model.parcelcompany.PC_USE }' />" /> --%>
												<label class="radio-inline">
													<input name="r_pcuse" type="radio" value="M" <c:if test="${ model.parcelcompany.PC_USE eq 'Y' }">checked="checked"</c:if> />YES
												</label>
												<label class="radio-inline">
													<input name="r_pcuse" type="radio" value="M" <c:if test="${ model.parcelcompany.PC_USE eq 'N' }">checked="checked"</c:if> />NO
												</label>
											</div>
										</div>
<!-- 										<div class="form-group"> -->
<!-- 											<label class="control-label col-sm-2"for="r_pcinid">등록아이디</label> -->
<!-- 											<div class="col-sm-6"> -->
<%-- 												<input class="form-control" id="r_pcinid" name="r_pcinid" placeholder="등록아이디" type="text" value="<c:out value='${ model.parcelcompany.PC_INID }' />" /> --%>
<!-- 											</div> -->
<!-- 										</div> -->
										<!--<div class="form-group">
											<label class="control-label col-sm-2"for="r_pcindate">등록일</label>
											<input class="form-control" id="r_pcindate" name="r_pcindate" placeholder="등록일" type="text" "${ fn:substring( model.parcelcompany.PC_INDATE, 0, 16 ) }" required />
										</div>-->
								
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-10 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-2">
												<button type="button" class="btn btn-success btn-sm" onclick="dataUp('${ model.parcelcompany.PC_SEQ }')" ><i class="fa fa-save"></i> 저장</button>
												<button type="button" class="btn btn-primary btn-sm" onclick="dataList()"><i class="fa fa-list-ul"></i> 리스트</button>
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