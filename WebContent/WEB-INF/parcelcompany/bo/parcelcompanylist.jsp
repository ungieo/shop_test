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
		$( '#table1 > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
			$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', $( this ).prop( 'checked' ) );
		});
	});

	function dataAjax(option){
		$.ajax(option)
	}

	function dataAdd(  ){
// 		$('#pcAddModal').modal('show');
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

	function dataEdit( r_pcseq ){
		$( '#r_pcseq' ).val( r_pcseq );
		handling.submit( '', 'parcelcompanyedit' );
	}

	function dataIn(){
		handling.submit( '', 'parcelcompanyin' );
	}

	function dataView( r_pcseq ){
		$( '#r_pcseq' ).val( r_pcseq );
		handling.submit( '', 'parcelcompanyview' );
	}

	function dataList(){
		handling.submit( '', 'parcelcompanylist' );
	}

	function dataListDel(){
		handling.submit( '', 'parcelcompanylist' );
	}
	
	function dataListDel(  ){
		var r_pcseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input:checked' );
		var idx = 0;
		$(checkarr).each(function(){
			r_pcseqarr[idx] = $(this).val();
			idx++;
		});
		if( r_pcseqarr.length > 0 ){
			if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
				return;
			}
			$('#r_pcseqarr').val(r_pcseqarr.join(','))
	 		handling.submit( '', 'parcelcompanylistdel' );
		}else{
			alert('선택 후 진행해주십시오');
		}
	}

	function dataListUp(){
		handling.submit( '', 'parcelcompanylist' );
	}
	
	function dataListUp( r_column, r_columnvalue ){
		var r_pcseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input:checked' );
		var idx = 0;
		$(checkarr).each(function(){
			r_pcseqarr[idx] = $(this).val();
			idx++;
		});
		if( r_pcseqarr.length > 0 ){
			if( !confirm( '변경 처리를 진행하시겠습니까?' ) ){
				return;
			}
			$('input[name="r_column"]').val(r_column);
			$('input[name="r_columnvalue"]').val(r_columnvalue);
			$('#r_pcseqarr').val(r_pcseqarr.join(','))
	 		handling.submit( '', 'parcelcompanylistup' );
		}else{
			alert('선택 후 진행해주십시오');
		}
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
		handling.submit( '', 'parcelcompanylist' );
	}

	function dataSort(){
		handling.submit( '', 'parcelcompanylist' );
	}

	function dataUp( r_pcseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_pcseq').val( r_pcseq );
		handling.submit( '', 'parcelcompanyup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( fName, r_url );
	}

	function pager( r_page ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( '', '' );
	}

	function pageMove(  ){
		handling.pageMove( r_url, param);
	}

	function modalDataIn(){
		var option = {
				async : false,
				data : $('#modal_frm').serialize() ,
				error : function( xhr, textStatus, error ){
					alert(error);
				},
				success : function( data ){
					if( data.result ){
						alert( '정상처리되었습니다.' );
						location.reload();
					}else{
						alert( '처리 중 오류가 발생되었습니다.' );
					}
				},
				type : 'POST',
				url : 'parcelcompanyinajax'
		}
		dataAjax(option);
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
									<input type="text" class="form-control" placeholder="Search for..." />
									<span class="input-group-btn"><button class="btn btn-default" type="button">Go!</button></span>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
					
					<form action="parcelcompanylist" class="form-horizontal" id="frm" name="frm" method="post" >
								
						<input name="r_page" type="hidden" value="${ model.r_page }" />
						<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
						<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />
				
						<input id="r_pcseq" name="r_pcseq" type="hidden" value="" />
						<input name="r_pcseqarr" id="r_pcseqarr" type="hidden"/>
						<input name="r_column" type="hidden" value=""/>
						<input name="r_columnvalue" type="hidden" value=""/>
					
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
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_type">검색분류</label>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" name="sc_type">
													<option value="" >선택</option>
													<option value="pc_name" <c:if test="${ param.sc_type eq 'pr_name' }">selected="selected"</c:if> >업체명</option>
												</select>
											</div>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_word" name="sc_word" placeholder="검색어" type="text" value="${ param.sc_word }" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>배송업체리스트 <small>Parcel Company</small></h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
											<li><a class="close-link"><i class="fa fa-close"></i></a></li>
	                       				</ul>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										<div class="table-responsive">
											<table class="table table-hover" id="table1">
												<thead>
													<tr>
														<th>
															<input type="checkbox" />
														</th>
														<th>고유값</th>
														<th>택배사명</th>
<!-- 														<th>회사설정</th> -->
														<th>택배사URL</th>
														<th>레벨</th>
														<th>타입</th>
														<th>승인여부</th>
														<th>등록아이디</th>
														<th>등록일</th>
														<th>관리</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${ model.parcelcompanyList}" var="parcelcompany" varStatus="status" >
														<tr>
															<td>
																<input type="checkbox" value="${parcelcompany.PC_SEQ}"/>
															</td>
															<td><c:out value='${ parcelcompany.PC_SEQ }' /></td>
															<td><c:out value='${ parcelcompany.PC_NAME }' /></td>
<%-- 															<td><c:out value='${ parcelcompany.PC_CPID }' /></td> --%>
															<td><c:out value='${ parcelcompany.PC_URL }' /></td>
															<td><c:out value='${ parcelcompany.PC_LEVEL }' /></td>
															<td><c:out value='${ parcelcompany.PC_TYPE }' /></td>
															<td><c:out value='${ parcelcompany.PC_USE }' /></td>
															<td><c:out value='${ parcelcompany.PC_INID }' /></td>
															<td>${ fn:substring( parcelcompany.PC_INDATE, 0, 10 ) }</td>
															<td>
																<button type="button" class="btn btn-info btn-xs" onclick="dataView('${ parcelcompany.PC_SEQ }')"><i class="fa fa-folder"></i></button>
																<button type="button" class="btn btn-warning btn-xs" onclick="dataEdit('${ parcelcompany.PC_SEQ }')"><i class="fa fa-edit"></i></button>
																<button type="button" class="btn btn-danger btn-xs" onclick="dataDel('${ parcelcompany.PC_SEQ }')"><i class="fa fa-trash"></i></button>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									
										<div class="form-group">
											<div class="col-md-6 col-sm-6 col-xs-12">
												<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( 'PC_USE', 'Y' )">선택승인</button>
												<button type="button" class="btn btn-warning btn-xs" onclick="dataListUp( 'PC_USE', 'N' )">선택미승인</button>
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
												<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#pcAddModal"><i class="fa fa-plus"></i> 등록</button>
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
	
	<div class="modal fade" id="pcAddModal" tabindex="-1" role="dialog" aria-labelledby="pcAddModalLavel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">배송업체 등록</h4>
				</div>
				<div class="modal-body">
				
					<form class="form-horizontal" name="modal_frm" id="modal_frm" method="post">
						<input type="hidden" value="M" name="r_pctype" />
						<div class="form-group">
							<label class="col-sm-3 control-label" for="r_pcname">배송업체명</label>
							<div class="col-sm-9">
								<input class="form-control" name="r_pcname" placeholder="배송업체명" />							
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="r_pcurl">배송조회 URL</label>
							<div class="col-sm-9">
								<input class="form-control" name="r_pcurl" placeholder="배송조회 URL" />							
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label" for="r_pcuse">승인여부</label>
							<div class="col-sm-9">
								<label class="radio-inline">
									<input name="r_pcuse" placeholder="승인여부YES" type="radio" value="Y" checked="checked"/>YES
								</label>
								<label class="radio-inline">
									<input name="r_pcuse" placeholder="승인여부NO" type="radio" value="N"/>NO
								</label>
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default btn-sm" data-dismiss="modal"><i class="fa fa-close"></i> 닫기</button>
					<button type="button" class="btn btn-success btn-sm" onclick="modalDataIn();" style="margin-left:0px;"><i class="fa fa-save"></i> 저장</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
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
									