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
	
<!-- 	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">			jquery ui css google cdn -->
	
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>	<!-- jquery cdn -->
	
<%-- 	<script src="${ cpath }/include/soledot/js/jquery-validation/jquery.validate.js"></script>  --%>
<%-- 	<script src="${ cpath }/include/soledot/js/jquery-validation/additional-methods.js"></script> --%>
<%-- 	<script src="${ cpath }/include/soledot/js/jquery-validation/localization/messages_ko.js"></script> --%>
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
// 		$('form[name="frm"]').validate();
		$( '#table1 > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
			$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', $( this ).prop( 'checked' ) );
		});
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

	function dataAdd(  ){
		handling.submit( '', 'boardadd' );
	}

	function dataDel( r_bdid ){
		if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
			return;
		}
		$( 'input[name="r_bdid"]' ).val( r_bdid );
		handling.submit( '', 'boarddel' );
	}

	function dataDown(){
		handling.submit( '', 'boarddel' );
	}

	function dataEdit( r_bdid ){
		$( 'input[name="r_bdid"]' ).val( r_bdid );
		handling.submit( '', 'boardedit' );
	}

	function dataIn(){
		handling.submit( '', 'boardin' );
	}

	function dataView( r_bdid ){
		$( 'input[name="r_bdid"]' ).val( r_bdid );
		handling.submit( '', 'boardview' );
	}

	function dataList(){
		handling.submit( '', 'boardlist' );
	}
	
	function dataListDel(  ){
		var r_bdidarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_bdidarr[idx] = $(this).val();
				idx++;
			}
		});
		if( r_bdidarr.length > 0 ){
			
			if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
				return;
			}
			
			$('input[name="r_bdidarr"]').val(r_bdidarr.join(','));
	 		handling.submit( '', 'boardlistdel' );
		}else{
			alert('선택 후 진행해주십시오');
		}
	}
	
	function dataListUp( r_column, r_columnvalue ){
		var r_bdidarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_bdidarr[idx] = "'"+$(this).val()+"'";
				idx++;
			}
		});
		if( r_bdidarr.length > 0 ){
			if( !confirm( '변경 처리를 진행하시겠습니까?' ) ){
				return;
			}
			$('input[name="r_bdidarr"]').val(r_bdidarr.join(','));
			$('input[name="r_column"]').val(r_column);
			$('input[name="r_columnvalue"]').val(r_columnvalue);
	 		handling.submit( '', 'boardlistup' );
		}else{
			alert('선택 후 진행해주십시오');
		}
		
	}
	
	function dataSort(){
		handling.submit( '', 'boardlist' );
	}

	function dataUp( r_bdid ){
		handling.submit( '', 'boardup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
	}

	function pager( fName, r_url, r_page ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( fName, r_url );
	}

	function pageMove( r_bdid ){
		handling.pageMove( '${cpath}/boardarticle/bo/boardarticlelist', 'sc_bdabdid='+r_bdid );
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
					
					<form action="boardlist" class="form-horizontal" method="post" name="frm">
								
					<input name="r_page" type="hidden" value="${ model.r_page }" />
					<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
					<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />
			
					<input name="r_bdid" type="hidden" value="" />
					<input name="r_bdidarr" type="hidden" value="" />
					
					<input name="r_column" type="hidden" value=""/>
					<input name="r_columnvalue" type="hidden" value=""/>
					
	
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>게시판 리스트 <small>Board List</small></h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
											<li><a class="close-link"><i class="fa fa-close"></i></a></li>
	                       				</ul>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
	
										<div class="table-responsive">
										
										<table class="table table-hover " id="table1">
											<thead>
												<tr>
													<th>
														<input type="checkbox" />
													</th>
													<th>아이디</th>
													<th>게시판명</th>
													<th>코멘트사용여부</th>
<!-- 													<th>설명</th> -->
													<th>파일최대사이즈</th>
													<th>파일사용여부</th>
<!-- 													<th>이미지</th> -->
<!-- 													<th>보드아이피</th> -->
<!-- 													<th>아이피사용여부</th> -->
													<th>암호사용여부</th>
													<th>답글여부</th>
<!-- 													<th>정렬타입</th> -->
<!-- 													<th>뷰타입</th> -->
<!-- 													<th>레벨</th> -->
<!-- 													<th>타입</th> -->
													<th>승인여부</th>
<!-- 													<th>수정아이디</th> -->
<!-- 													<th>등록아이디</th> -->
<!-- 													<th>수정일</th> -->
													<th>등록일</th>
													<th>관리</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach items="${ model.boardList}" var="board" varStatus="status" >
												<tr>
													<td>
														<input type="checkbox" value="${ board.BD_ID }"/>
													</td>
													<td><a href="javascript:dataView('${ board.BD_ID}')" >${ board.BD_ID }</a></td>
													<td><a href="javascript:pageMove('${ board.BD_ID}')" >${ board.BD_NAME }</a></td>
													<td>${ board.BD_COMMENTUSE }</td>
<%-- 													<td>${ board.BD_DESCRIPTION }</td> --%>
													<td>${ board.BD_FILEMAXSIZE }</td>
													<td>${ board.BD_FILEUSE }</td>
<%-- 													<td>${ board.BD_IMAGE }</td> --%>
<%-- 													<td>${ board.BD_IP }</td> --%>
<%-- 													<td>${ board.BD_IPUSE }</td> --%>
													<td>${ board.BD_PSWDUSE }</td>
													<td>${ board.BD_REPLYUSE }</td>
<%-- 													<td>${ board.BD_SORTTYPE }</td> --%>
<%-- 													<td>${ board.BD_VIEWTYPE }</td> --%>
<%-- 													<td>${ board.BD_LEVEL }</td> --%>
<%-- 													<td>${ board.BD_TYPE }</td> --%>
													<td>${ board.BD_USE }</td>
<%-- 													<td>${ board.BD_MOID }</td> --%>
<%-- 													<td>${ board.BD_INID }</td> --%>
<%-- 													<td>${ fn:substring( board.BD_MODATE, 0, 16 ) }</td> --%>
													<td>${ fn:substring( board.BD_INDATE, 0, 16 ) }</td>
													<td>
														<button type="button" class="btn btn-info btn-xs" onclick="dataView('${ board.BD_ID }')"><i class="fa fa-folder"></i></button>
														<button type="button" class="btn btn-warning btn-xs" onclick="dataEdit('${ board.BD_ID }')"><i class="fa fa-edit"></i></button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataDel('${ board.BD_ID }')"><i class="fa fa-trash"></i></button>
													</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
										</div>
								
										<div class="form-group">
											<div class="col-md-6 col-sm-6 col-xs-12">
												<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( 'BD_USE', 'Y' )">선택승인</button>
												<button type="button" class="btn btn-warning btn-xs" onclick="dataListUp( 'BD_USE', 'N' )">선택미승인</button>
												<button type="button" class="btn btn-danger btn-xs" onclick="dataListDel()"><i class="fa fa-trash-o"></i> 선택삭제</button>
											</div>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<div class="pull-right">
												<%@ include file="/include/jsp/bo/pager.jsp" %>
												</div>
											</div>
										</div>
									
										<div class="ln_solid"></div>
										
										<div class="form-group">
											<div class="col-xs-12">
												<button type="button" class="btn btn-success btn-sm" onclick="dataAdd()"><i class="fa fa-plus"></i> 등록</button>
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