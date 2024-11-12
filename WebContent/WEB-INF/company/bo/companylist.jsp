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
	<script type="text/javascript" src="${cpath }/include/js/datepicker/jquery.ui.datepicker-ko.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>	<!-- jquery ui cdn -->
	
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
		
		$( 'input[name="sc_cpindates"]' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,     
			dateFormat: "yy-mm-dd",  //---출력format
			numberOfMonths : 3,       //---출력되는 달의 범위
			onClose : function ( selectedDate ){          //---종료일 달력설정
				$( 'input[name="sc_cpindatee"]' ).datepicker( 'option', 'minDate', selectedDate ); 
			}
		});

		$( 'input[name="sc_cpindatee"]' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,
			dateFormat: "yy-mm-dd",
			numberOfMonths : 3, 
			onClose : function ( selectedDate ){         //--- 시작일 달력 설정
				$( 'input[name="sc_cpindates"]' ).datepicker( 'option', 'maxDate', selectedDate );
			}
		});
		
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
		handling.submit( '', 'companyadd' );
	}
	
	function dataChildAdd( r_cpid ){
		$('#r_cpid').val(r_cpid)
		handling.submit( '', '${cpath}/companydepartment/bo/companydepartmentadd' );
	}

	function dataDel( r_cpseq ){
		if( confirm( "정말 삭제하시겠습니까?" ) ){
			handling.submit( '', 'companydel' );
		}
	}

	function dataDown(){
		handling.submit( '', 'companydown' );
	}

	function dataEdit( r_cpseq ){
		handling.submit( '', 'companyedit' );
	}

	function dataIn(){
		handling.submit( '', 'companyin' );
	}

	function dataView( r_cpseq ){
		$( '#r_cpseq' ).val( r_cpseq );
		handling.submit( '', 'companyview' );
	}

	function dataList(){
		handling.submit( '', 'companylist' );
	}
	
	function dataListDel(  ){
		var r_cpseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_cpseqarr[idx] = $(this).val();
				idx++;
			}
		});
		if( r_cpseqarr.length > 0 ){
			
			if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
				return;
			}
			
			$('input[name="r_cpseqarr"]').val(r_cpseqarr.join(','));
	 		handling.submit( '', 'companylistdel' );
		}else{
			alert('선택 후 진행해주십시오');
		}
	}
	
	function dataListUp( r_column, r_columnvalue ){
		var r_cpseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_cpseqarr[idx] = $(this).val();
				idx++;
			}
		});
		if( r_cpseqarr.length > 0 ){
			if( !confirm( '변경 처리를 진행하시겠습니까?' ) ){
				return;
			}
			$('input[name="r_cpseqarr"]').val(r_cpseqarr.join(','));
			$('input[name="r_column"]').val(r_column);
			$('input[name="r_columnvalue"]').val(r_columnvalue);
	 		handling.submit( '', 'companylistup' );
		}else{
			alert('선택 후 진행해주십시오');
		}
		
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
		handling.submit( '', 'companylist' );
	}
	function dataSort(){
		handling.submit( '', 'companylist' );
	}

	function dataUp( r_cpseq ){
		handling.submit( '', 'companyup' );
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
									<input type="text" class="form-control" placeholder="Search for..." />
									<span class="input-group-btn"><button class="btn btn-default" type="button">Go!</button></span>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
	
					<form action="companylist" class="form-horizontal" id="frm" name="frm" method="post" >
								
					<input name="r_page" type="hidden" value="${ model.r_page }" />
					<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
					<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />
			
					<input id="r_cpseq" name="r_cpseq" type="hidden" value="" />
					<input id="r_cpseqarr" name="r_cpseqarr" type="hidden" value="" />
					<input id="r_cpid" name="r_cpid" type="hidden"/>

					
					<input name="r_column" type="hidden" value=""/>
					<input name="r_columnvalue" type="hidden" value=""/>
					
					
					<div class="row">
						
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>협력사 검색 <small>Company Search</small></h2>
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
						<div class="col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>협력사 리스트 <small>Company List</small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a></li>
                       				</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<div class="table-responsive">								
										<table id="table1" class="table table-hover">
											<thead>
												<tr>
													<th>
														<input type="checkbox" />
													</th>
<!-- 													<th>고유번호</th> -->
													<th>회사아이디</th>
													<th>회사명</th>
<!-- 													<th>사업자번호</th> -->
<!-- 													<th>업태</th> -->
<!-- 													<th>업종</th> -->
													<th>대표명</th>
<!-- 													<th>우편번호</th> -->
<!-- 													<th>기본주소</th> -->
<!-- 													<th>상세주소</th> -->
<!-- 													<th>파일</th> -->
<!-- 													<th>배송비</th> -->
<!-- 													<th>결제타입</th> -->
<!-- 													<th>회사타입</th> -->
<!-- 													<th>통신사업자</th> -->
													<th>이메일</th>
													<th>전화</th>
													<th>휴대전화</th>
													<th>팩스</th>
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
											<c:forEach items="${ model.companyList}" var="company" varStatus="status" >
												<tr>
													<td>
														<input type="checkbox" value="${ company.CP_SEQ }"/>
													</td>
<%-- 													<td><c:out value='${ company.CP_SEQ }' /></td> --%>
													<td><c:out value='${ company.CP_ID }' /></td>
													<td><c:out value='${ company.CP_NAME }' /></td>
<%-- 													<td><c:out value='${ company.CP_BIZNUM }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_UPTAI }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_UPJONG }' /></td> --%>
													<td><c:out value='${ company.CP_CEONAME }' /></td>
<%-- 													<td><c:out value='${ company.CP_ZIPCODE }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_ADDR1 }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_ADDR2 }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_FILE }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_DELIVERYMONEY }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_PAYTYPE }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_BIZTYPE }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_TONGSINBIZNUM }' /></td> --%>
													<td><c:out value='${ company.CP_EMAIL }' /></td>
													<td><c:out value='${ company.CP_TEL }' /></td>
													<td><c:out value='${ company.CP_PHONE }' /></td>
													<td><c:out value='${ company.CP_FAX }' /></td>
<%-- 													<td><c:out value='${ company.CP_LEVEL }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_TYPE }' /></td> --%>
													<td><c:out value='${ company.CP_USE }' /></td>
<%-- 													<td><c:out value='${ company.CP_MOID }' /></td> --%>
<%-- 													<td><c:out value='${ company.CP_INID }' /></td> --%>
<%-- 													<td>${ fn:substring( company.CP_MODATE, 0, 16 ) }</td> --%>
													<td>${ fn:substring( company.CP_INDATE, 0, 16 ) }</td>
													<td>
														<button type="button" class="btn btn-info btn-xs" onclick="dataView('${ company.CP_SEQ }')"><i class="fa fa-folder"></i></button>
														<button type="button" class="btn btn-warning btn-xs" onclick="dataEdit('${ company.CP_SEQ }')"><i class="fa fa-edit"></i></button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataDel('${ company.CP_SEQ }')"><i class="fa fa-trash"></i></button>
														<button type="button" class="btn btn-success btn-xs" onclick="dataChildAdd('${ company.CP_ID }')"><i class="fa fa-plus"></i></button>
													</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
							
									<div class="form-group">
										<div class="col-md-6 col-sm-6 col-xs-12">
											<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( 'CP_USE', 'Y' )">선택승인</button>
											<button type="button" class="btn btn-warning btn-xs" onclick="dataListUp( 'CP_USE', 'N' )">선택미승인</button>
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
	
	
	