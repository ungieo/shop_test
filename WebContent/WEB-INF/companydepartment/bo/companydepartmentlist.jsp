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
			
		$( '#table1 > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
			$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', $( this ).prop( 'checked' ) );
		});
		
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

	function dataAdd(  ){
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

	function dataEdit( r_cpdseq ){
		$('#r_cpdseq').val( r_cpdseq );
		handling.submit( '', 'companydepartmentedit' );
	}

	function dataIn(){
		handling.submit( '', 'companydepartmentin' );
	}

	function dataView( r_cpdseq ){
		$( '#r_cpdseq' ).val( r_cpdseq );
		handling.submit( '', 'companydepartmentview' );
	}

	function dataList(){
		handling.submit( '', 'companydepartmentlist' );
	}

	function dataListDel(  ){
		var r_cpdseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_cpdseqarr[idx] = $(this).val();
				idx++;
			}
		});
		if( r_cpdseqarr.length > 0 ){
			
			if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
				return;
			}
			
			$('input[name="r_cpdseqarr"]').val(r_cpdseqarr.join(','));
	 		handling.submit( '', 'companydepartmentlistdel' );
		}else{
			alert('선택 후 진행해주십시오');
		}
	}
	
	function dataListUp( r_column, r_columnvalue ){
		var r_cpdseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_cpdseqarr[idx] = "'"+$(this).val()+"'";
				idx++;
			}
		});
		if( r_cpdseqarr.length > 0 ){
			if( !confirm( '변경 처리를 진행하시겠습니까?' ) ){
				return;
			}
			$('input[name="r_cpdseqarr"]').val(r_cpdseqarr.join(','));
			$('input[name="r_column"]').val(r_column);
			$('input[name="r_columnvalue"]').val(r_columnvalue);
	 		handling.submit( '', 'companydepartmentlistup' );
		}else{
			alert('선택 후 진행해주십시오');
		}
		
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
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
		handling.submit( fName, r_url );
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
					
					<form action="companydepartmentlist" class="form-horizontal" id="frm" name="frm" method="post" >
						<input name="r_page" type="hidden" value="${ model.r_page }" />
						<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
						<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />
						<input id="r_cpdseq" name="r_cpdseq" type="hidden" value="" />
						<input id="r_cpdseqarr" name="r_cpdseqarr" type="hidden" value="" />
						
						<input name="r_column" type="hidden" value=""/>
						<input name="r_columnvalue" type="hidden" value=""/>
					
						<div class="row">
							
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>협력사 부서 검색 <small>Company Department Search</small></h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
											<li><a class="close-link"><i class="fa fa-close"></i></a></li>
	                       				</ul>
										<div class="clearfix"></div>
									</div>
									
									<div class="x_content">
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_column">검색분류</label>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" name="sc_column" id="sc_column">
													<option value="">선택</option>
													<option value="cp_id" <c:if test="${ param.sc_column eq 'cp_id' }">selected="selected"</c:if> >회사아이디</option>
													<option value="cp_biznum" <c:if test="${ param.sc_column eq 'cp_biznum' }">selected="selected"</c:if> >사업자번호</option>
													<option value="cp_uptai" <c:if test="${ param.sc_column eq 'cp_uptai' }">selected="selected"</c:if> >업태</option>
													<option value="cp_upjong" <c:if test="${ param.sc_column eq 'cp_upjong' }">selected="selected"</c:if> >업종</option>
													<option value="cp_ceo" <c:if test="${ param.sc_column eq 'cp_ceo' }">selected="selected"</c:if> >대표명</option>
													<option value="cp_zipcode" <c:if test="${ param.sc_column eq 'cp_zipcode' }">selected="selected"</c:if> >우편번호</option>
													<option value="cp_addr1" <c:if test="${ param.sc_column eq 'cp_addr1' }">selected="selected"</c:if> >주소</option>
													<option value="cp_email" <c:if test="${ param.sc_column eq 'cp_email' }">selected="selected"</c:if> >이메일</option>
													<option value="cp_tel" <c:if test="${ param.sc_column eq 'cp_tel' }">selected="selected"</c:if> >전화번호</option>
													<option value="cp_phone" <c:if test="${ param.sc_column eq 'cp_phone' }">selected="selected"</c:if> >휴대폰</option>
												</select>
											</div>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_word" name="sc_word" placeholder="검색어" type="text" value="${ param.sc_word }" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_mbtype">회사타입</label>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" name="sc_cptype" id="sc_cptype">
													<option value="">선택</option>
<!-- 													<option value="N">일반</option> -->
													<option value="P" <c:if test="${ param.sc_cptype eq 'P' }">selected="selected"</c:if> >구매사</option>
													<option value="S" <c:if test="${ param.sc_cptype eq 'S' }">selected="selected"</c:if> >공급사</option>
													<option value="M" <c:if test="${ param.sc_cptype eq 'M' }">selected="selected"</c:if> >운영사</option>
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_cpindates">가입일</label>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_cpindates" name="sc_cpindates" placeholder="가입일시작" type="text" value="${ param.sc_cpindates }" />
											</div>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_cpindatee" name="sc_cpindatee" placeholder="가입일끝" type="text" value="${ param.sc_cpindatee }" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_cpuse">사용여부</label>
											<div class="col-sm-10 col-xs-12">
												<label class="radio-inline">
													<input name="sc_cpuse" type="radio" value="Y" <c:if test="${ param.sc_cpuse eq 'Y' }">checked="checked"</c:if> />YES
												</label>
												<label class="radio-inline">
													<input name="sc_cpuse" type="radio" value="N" <c:if test="${ param.sc_cpuse eq 'N' }">checked="checked"</c:if> />NO
												</label>
												<label class="radio-inline">
													<input name="sc_cpuse" type="radio" value="" <c:if test="${ param.sc_cpuse eq '' }">checked="checked"</c:if> />선택안함
												</label>
											</div>
										</div>
										
										<div class="form-group">
											<div class="col-xs-12">
												<button type="button" class="btn btn-info btn-lg btn-block" onclick="dataSearch()">검색</button>
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
										<h2>협력사부서 등록 <small>Company Department Add</small></h2>
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
		<!-- 												<th>고유번호</th> -->
														<th>회사아이디</th>
														<th>부서아이디</th>
														<th>부서명</th>
		<!-- 												<th>결제타입</th> -->
														<th>이메일</th>
														<th>전화</th>
														<th>휴대전화</th>
														<th>팩스</th>
		<!-- 												<th>레벨</th> -->
		<!-- 												<th>타입 N=일반</th> -->
														<th>승인여부</th>
		<!-- 												<th>수정아이디</th> -->
		<!-- 												<th>등록아이디</th> -->
		<!-- 												<th>수정일</th> -->
														<th>등록일</th>
														<th>관리</th>
													</tr>
												</thead>
													<tbody>
													<c:forEach items="${ model.companydepartmentList}" var="companydepartment" varStatus="status" >
														<tr>
															<td>
																<input type="checkbox" value="${ companydepartment.CPD_SEQ }"/>
															</td>
		<%-- 													<td><c:out value='${ companydepartment.CPD_SEQ }' /></td> --%>
															<td><c:out value='${ companydepartment.CPD_CPID }' /></td>
															<td><c:out value='${ companydepartment.CPD_ID }' /></td>
															<td><c:out value='${ companydepartment.CPD_NAME }' /></td>
		<%-- 													<td><c:out value='${ companydepartment.CPD_PAYTYPE }' /></td> --%>
															<td><c:out value='${ companydepartment.CPD_EMAIL }' /></td>
															<td><c:out value='${ companydepartment.CPD_TEL }' /></td>
															<td><c:out value='${ companydepartment.CPD_PHONE }' /></td>
															<td><c:out value='${ companydepartment.CPD_FAX }' /></td>
		<%-- 													<td><c:out value='${ companydepartment.CPD_LEVEL }' /></td> --%>
		<%-- 													<td><c:out value='${ companydepartment.CPD_TYPE }' /></td> --%>
															<td><c:out value='${ companydepartment.CPD_USE }' /></td>
		<%-- 													<td><c:out value='${ companydepartment.CPD_MOID }' /></td> --%>
		<%-- 													<td><c:out value='${ companydepartment.CPD_INID }' /></td> --%>
		<%-- 													<td>${ fn:substring( companydepartment.CPD_MODATE, 0, 16 ) }</td> --%>
															<td>${ fn:substring( companydepartment.CPD_INDATE, 0, 16 ) }</td>
															<td>
																<button type="button" class="btn btn-info btn-xs" onclick="dataView('${ companydepartment.CPD_SEQ }')"><i class="fa fa-folder"></i></button>
																<button type="button" class="btn btn-warning btn-xs" onclick="dataEdit('${ companydepartment.CPD_SEQ }')"><i class="fa fa-edit"></i></button>
																<button type="button" class="btn btn-danger btn-xs" onclick="dataDel('${ companydepartment.CPD_SEQ }')"><i class="fa fa-trash"></i></button>
															</td>
														</tr>
													</c:forEach>
													</tbody>
											</table>
										</div>
								
										<div class="form-group">
											<div class="col-md-6 col-sm-6 col-xs-12">
												<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( 'CPD_USE', 'Y' )">선택승인</button>
												<button type="button" class="btn btn-warning btn-xs" onclick="dataListUp( 'CPD_USE', 'N' )">선택미승인</button>
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
										
									</div> <!-- xcontent end -->
								</div>
							</div>
						</div> <!-- row end -->
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
	<script src="${cpath}/include/js/pace/pace.min.js"></script>
	
</body>
</html>