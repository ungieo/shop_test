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
	
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">			<!-- jquery ui css google cdn -->
	
	<!-- Custom styling plus plugins -->
	<link href="${cpath}/include/css/custom.css" rel="stylesheet" />
	
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>	<!-- jquery cdn -->
	<script type="text/javascript" src="${cpath }/include/js/datepicker/jquery.ui.datepicker-ko.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>	<!-- jquery ui cdn -->
	
	<script src="${ cpath }/include/soledot/js/soledot.js"></script>

	<!--[if lt IE 9]>
	<script src="../assets/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->


<script type="text/javascript">

	$(function(){
		
		$( '#sc_omindates' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,     
			dateFormat: "yy-mm-dd",  //---출력format
			numberOfMonths : 3,       //---출력되는 달의 범위
			onClose : function ( selectedDate ){          //---종료일 달력설정
				$( '#sc_omindatee' ).datepicker( 'option', 'minDate', selectedDate ); 
			}
		});

		$( '#sc_omindatee' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,
			dateFormat: "yy-mm-dd",
			numberOfMonths : 3, 
			onClose : function ( selectedDate ){         //--- 시작일 달력 설정
				$( '#sc_omindates' ).datepicker( 'option', 'maxDate', selectedDate );
			}
		});
		
		$( '#table1 > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
			$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', $( this ).prop( 'checked' ) );
		});
	});

	function dataAjax(option){
		$.ajax(option);
	}

	function dataAdd(  ){
		handling.submit( '', 'ordermainadd' );
	}

	function dataDel( r_omseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_omseq').val( r_omseq );
		handling.submit( '', 'ordermaindel' );
	}

	function dataDown(){
		handling.submit( '', 'ordermaindown' );
	}

	function dataEdit( r_omseq ){
		$('#r_omseq').val(r_omseq);
		handling.submit( '', 'ordermainedit' );
	}

	function dataIn(){
		handling.submit( '', 'ordermainin' );
	}

	function dataView( r_omseq ){
		$( '#r_omseq' ).val( r_omseq );
		handling.submit( '', 'ordermainview' );
	}

	function dataList(){
		handling.submit( '', 'ordermainlist' );
	}

	function dataListDel(){
		handling.submit( '', 'ordermainlist' );
	}

	function dataListUp(r_omstatus){
		var r_omseq = [];
		
		$( '#table1 > tbody > tr > td > input:checked' ).each(function(i,e){
			r_omseq[i] = $(this).val();
		});
		
		if( r_omseq.length > 0 ){
			
			if( !confirm( '주문상태 변경처리를 진행하시겠습니까?' ) ){
				return;
			}
			var param = '';
			param += 'r_omseqarr='+r_omseq.join(',')+'&r_omstatus='+r_omstatus;
			var option = {
				async : false,
				data : param,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( true == data.result ){
						location.reload();
					}else{
						alert(data.msg);
					}
				},
				type : 'POST',
				url : '${cpath}/ordermain/bo/ordermainlistupajax'
			}
			dataAjax(option)
			
		}else{
			alert('선택 후 진행해주십시오');
		}
		
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
		handling.submit( '', 'ordermainlist' );
	}

	function dataSort(){
		handling.submit( '', 'ordermainlist' );
	}

	function dataUp( obj, r_omstatus ){
		if( !confirm("주문상태 변경처리를 진행하시겠습니까?")){;
			return;
		};
		var r_omseq = $(obj).parent().parent().find(':checkbox').val();
		
		var param = '';
		
		param += 'r_omseqarr='+r_omseq+'&r_omstatus='+r_omstatus;
		
		var option = {
			async : false,
			data : param,
			dataType : 'json',	
			cache : false,
			error : function( xhr, textStatus, error ){
				alert( error );
			},
			success : function(data){
				if( true == data.result ){
					location.reload();
				}else{
					alert(data.msg);
				}
			},
			type : 'POST',
			url : '${cpath}/ordermain/bo/ordermainlistupajax'
		}
		dataAjax(option);
		
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
							<h3>주문 관리 <small>Order Manage</small></h3>
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
					
					<form action="ordermainlist" class="form-horizontal" id="frm" name="frm" method="post" >

						<input name="r_page" type="hidden" value="${ model.r_page }" />
						<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
						<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />
				
						<input id="r_omseq" name="r_omseq" type="hidden" value="" />
						
						<input name="r_column" type="hidden" value=""/>
						<input name="r_columnvalue" type="hidden" value=""/>
					
						<div class="row">
							
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>전체 주문 검색 <small>Total Order Search</small></h2>
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
													<option value="cp_id" <c:if test="${ param.sc_column eq 'cp_id' }">selected="selected"</c:if> >주문번호</option>
													<option value="cp_biznum" <c:if test="${ param.sc_column eq 'cp_biznum' }">selected="selected"</c:if> >주문자아이디</option>
													<option value="cp_uptai" <c:if test="${ param.sc_column eq 'cp_uptai' }">selected="selected"</c:if> >주문자명</option>
													<option value="cp_upjong" <c:if test="${ param.sc_column eq 'cp_upjong' }">selected="selected"</c:if> >상품명</option>
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
											<label class="col-sm-2 col-xs-12 control-label" for="sc_mbtype">결제타입</label>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" name="sc_cptype" id="sc_cptype">
													<option value="">선택</option>
<!-- 													<option value="N">일반</option> -->
													<option value="P" <c:if test="${ param.sc_cptype eq 'P' }">selected="selected"</c:if> >카드</option>
													<option value="S" <c:if test="${ param.sc_cptype eq 'S' }">selected="selected"</c:if> >계좌이체</option>
													<option value="M" <c:if test="${ param.sc_cptype eq 'M' }">selected="selected"</c:if> >가상계좌</option>
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_prindates">주문일</label>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_omindates" name="sc_omindates" placeholder="주문일시작" type="text" />
											</div>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_omindatee" name="sc_omindatee" placeholder="주문일끝" type="text" />
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
<!-- 												<caption>ordermainList</caption> -->
												<thead>
													<tr>
														<th>
															<input type="checkbox" />
														</th>
<!-- 														<th>고유번호</th> -->
														<th>주문번호</th>
<!-- 														<th>PG결제번호</th> -->
<!-- 														<th>비밀문자</th> -->
														<th>주문자아이디</th>
														<th>주문자명</th>
														<th>상품이름(개수포함)</th>
														<th>결제타입</th>
<!-- 														<th>계좌이체</th> -->
<!-- 														<th>카드</th> -->
<!-- 														<th>쿠폰</th> -->
<!-- 														<th>후불</th> -->
<!-- 														<th>포인트</th> -->
<!-- 														<th>적립금</th> -->
<!-- 														<th>가상계좌</th> -->
<!-- 														<th>잔여계좌이체</th> -->
<!-- 														<th>잔여카드</th> -->
<!-- 														<th>잔여쿠폰</th> -->
<!-- 														<th>잔여후불</th> -->
<!-- 														<th>잔여포인트</th> -->
<!-- 														<th>잔여적립금</th> -->
<!-- 														<th>잔여가상계좌</th> -->
<!-- 														<th>발생적립금</th> -->
														<th>원가</th>
														<th>판매가</th>
														<th>배송타입</th>
<!-- 														<th>배송메모</th> -->
														<th>배송비</th>
														<th>송장번호</th>
<!-- 														<th>주문메모</th> -->
<!-- 														<th>배송사SEQ</th> -->
<!-- 														<th>에스크로여부</th> -->
<!-- 														<th>부분취소가능여부</th> -->
														<th>주문상태</th>
<!-- 														<th>스탭</th> -->
<!-- 														<th>타입</th> -->
<!-- 														<th>수정아이디</th> -->
<!-- 														<th>등록아이디</th> -->
<!-- 														<th>수정일</th> -->
														<th>주문일</th>
														<th>주문처리</th>
														<th>관리</th>
													</tr>
												</thead>
											<c:forEach items="${ model.ordermainList}" var="ordermain" varStatus="status" >
												<tbody>
													<tr>
														<td>
															<input type="checkbox" value="${ ordermain.OM_SEQ }"/>
														</td>
<%-- 														<td><c:out value='${ ordermain.OM_SEQ }' /></td> --%>
														<td><c:out value='${ ordermain.OM_ID }' /></td>
<%-- 														<td><c:out value='${ ordermain.OM_PGID }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_PSWD }' /></td> --%>
														<td><c:out value='${ ordermain.OM_MBID }' /></td>
														<td><c:out value='${ ordermain.OM_MBNAME }' /></td>
														<td><c:out value='${ ordermain.OM_PRNAME }' /></td>
														<td><c:out value='${ ordermain.OM_PAYTYPE }' /></td>
<%-- 														<td><c:out value='${ ordermain.OM_ACCOUNTMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_CARDMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_COUPONMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_LATERMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_POINTMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_SAVEMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_VIRTUALACCOUNTMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_RACCOUNTMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_RCARDMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_RCOUPONMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_RLATERMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_RPOINTMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_RSAVEMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_RVIRTUALACCOUNTMONEY }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_NEWSAVEMONEY }' /></td> --%>
														<td><c:out value='${ ordermain.OM_ORIGNALMONEY }' /></td>
														<td><c:out value='${ ordermain.OM_SALEMONEY }' /></td>
														<td><c:out value='${ ordermain.OM_DELITYPE }' /></td>
<%-- 														<td><c:out value='${ ordermain.OM_DELIMEMO }' /></td> --%>
														<td><c:out value='${ ordermain.OM_DELIMONEY }' /></td>
														<td><c:out value='${ ordermain.OM_DELINUM }' /></td>
<%-- 														<td><c:out value='${ ordermain.OM_MEMO }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_PCCSEQ }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_ESCROWYN }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_PARTCANCELYN }' /></td> --%>
														<td>
<%-- 															<c:out value='${ ordermain.OM_STATUS }' /> --%>
<%-- 															<c:set var="omstatus" value="${ordermain.OM_STATUS}${ordermain.OM_STEP}" /> --%>
															${ odc:status( ordermain.OM_STATUS ) }
														</td>
<%-- 														<td><c:out value='${ ordermain.OM_STEP }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_TYPE }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_MOID }' /></td> --%>
<%-- 														<td><c:out value='${ ordermain.OM_INID }' /></td> --%>
<%-- 														<td>${ fn:substring( ordermain.OM_MODATE, 0, 16 ) }</td> --%>
														<td>${ fn:substring( ordermain.OM_INDATE, 0, 16 ) }</td>
														<td>
															<c:choose>
																<c:when test="${ param.r_omstatus eq 'B1' }">
																	<a class="text-success" href="" onclick="dataUp( this, '${odc:status('결제완료')}' );return false"><strong>결제완료</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('취소신청')}' );return false"><strong>취소신청</strong></a><br/>
																</c:when>
																<c:when test="${ param.r_omstatus eq 'C1' }">
																	<a class="text-success" href="" onclick="dataUp( this, '${odc:status('배송준비')}' );return false"><strong>배송준비</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('취소신청')}' );return false"><strong>취소신청</strong></a><br/>
																</c:when>
																<c:when test="${ param.r_omstatus eq 'D1' }">
																	<a class="text-success" href="" onclick="dataUp( this, '${odc:status('배송중')}' );return false"><strong>배송중</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('취소신청')}' );return false"><strong>취소신청</strong></a><br/>
																</c:when>
																<c:when test="${ param.r_omstatus eq 'E1' }">
																	<a class="text-success" href="" onclick="dataUp( this, '${odc:status('배송완료')}' );return false"><strong>배송완료</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('취소신청')}' );return false"><strong>취소신청</strong></a><br/>
																</c:when>
																<c:when test="${ param.r_omstatus eq 'F1' }">
																	<a class="text-success" href="" onclick="dataUp( this, '${odc:status('구매확정')}' );return false"><strong>구매확정</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('반품신청')}' );return false"><strong>반품신청</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('교환신청')}' );return false"><strong>교환신청</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('환불신청')}' );return false"><strong>환불신청</strong></a><br/>
																</c:when>
																<c:when test="${ param.r_omstatus eq 'H1' }">
																	<a class="text-success" href="" onclick="dataUp( this, '${odc:status('취소완료')}' );return false"><strong>취소완료</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('취소신청취소')}' );return false"><strong>취소신청취소</strong></a><br/>
																</c:when>
																<c:when test="${ param.r_omstatus eq 'I1' }">
																	<a class="text-success" href="" onclick="dataUp( this, '${odc:status('반품완료')}' );return false"><strong>반품완료</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('반품신청취소')}' );return false"><strong>반품신청취소</strong></a><br/>
																</c:when>
																<c:when test="${ param.r_omstatus eq 'J1' }">
																	<a class="text-success" href="" onclick="dataUp( this, '${odc:status('교환완료')}' );return false"><strong>교환완료</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('교환신청취소')}' );return false"><strong>교환신청취소</strong></a><br/>
																</c:when>
																<c:when test="${ param.r_omstatus eq 'J2' }">
																	<a class="text-success" href="" onclick="dataUp( this, '${odc:status('구매확정')}' );return false"><strong>구매확정</strong></a><br/>
																</c:when>
																<c:when test="${ param.r_omstatus eq 'K1' }">
																	<a class="text-success" href="" onclick="dataUp( this, '${odc:status('환불완료')}' );return false"><strong>환불완료</strong></a><br/>
																	<a class="text-danger" href="" onclick="dataUp( this, '${odc:status('환불신청취소')}' );return false"><strong>환불신청취소</strong></a><br/>
																</c:when>
															</c:choose>
														</td>
														<td>
															<button type="button" class="btn btn-info btn-xs" onclick="dataView('${ ordermain.OM_SEQ }')"><i class="fa fa-folder"></i></button>
															<button type="button" class="btn btn-warning btn-xs" onclick="dataEdit('${ ordermain.OM_SEQ }')"><i class="fa fa-edit"></i></button>
<%-- 															<button type="button" class="btn btn-danger btn-xs" onclick="dataDel('${ product.PR_SEQ }')"><i class="fa fa-trash"></i></button> --%>
														</td>
													</tr>
												</tbody>
											</c:forEach>
											</table>
										</div>

										<div class="form-group">
											<div class="col-md-6 col-sm-6 col-xs-12">
												<c:choose>
													<c:when test="${ param.r_omstatus eq 'B1' }">
														<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( '${odc:status('결제완료')}' )">결제완료</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('취소신청')}' )">취소신청</button>
													</c:when>
													<c:when test="${ param.r_omstatus eq 'C1' }">
														<button type="button" class="btn btn-default btn-xs" onclick="dataListUp( '${odc:status('배송준비')}' )">배송준비</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('취소신청')}' )">취소신청</button>
													</c:when>
													<c:when test="${ param.r_omstatus eq 'D1' }">
														<button type="button" class="btn btn-default btn-xs" onclick="dataListUp( '${odc:status('배송중')}' )">배송중</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('취소신청')}' )">취소신청</button>
													</c:when>
													<c:when test="${ param.r_omstatus eq 'E1' }">
														<button type="button" class="btn btn-default btn-xs" onclick="dataListUp( '${odc:status('배송완료')}' )">배송완료</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('취소신청')}' )">취소신청</button>
													</c:when>
													<c:when test="${ param.r_omstatus eq 'F1' }">
														<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( '${odc:status('구매확정')}' )">구매확정</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('반품신청')}' )">반품신청</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('교환신청')}' )">교환신청</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('환불신청')}' )">환불신청</button>
													</c:when>
													<c:when test="${ param.r_omstatus eq 'H1' }">
														<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( '${odc:status('취소완료')}' )">취소완료</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('취소신청취소')}' )">취소신청취소</button>
													</c:when>
													<c:when test="${ param.r_omstatus eq 'I1' }">
														<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( '${odc:status('반품완료')}' )">반품완료</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('반품신청취소')}' )">반품신청취소</button>
													</c:when>
													<c:when test="${ param.r_omstatus eq 'J1' }">
														<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( '${odc:status('교환완료')}' )">교환완료</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('교환신청취소')}' )">교환신청취소</button>
													</c:when>
													<c:when test="${ param.r_omstatus eq 'J2' }">
														<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( '${odc:status('구매확정')}' )">구매확정</button>
													</c:when>
													<c:when test="${ param.r_omstatus eq 'K1' }">
														<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( '${odc:status('환불완료')}' )">환불완료</button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataListUp( '${odc:status('환불신청취소')}' )">환불신청취소</button>
													</c:when>
													
													
												</c:choose>
											</div>
											
											<div class="col-md-6 col-sm-6 col-xs-12">
												<div class="pull-right">
												<%@ include file="/include/jsp/pager.jsp" %>
												</div>
											</div>
										</div>
									
<!-- 										<div class="ln_solid"></div> -->
<!-- 										<div class="form-group"> -->
<!-- 											<div class="col-xs-12"> -->
<!-- 												<button type="button" class="btn btn-success" onclick="dataAdd()"><i class="fa fa-plus"></i> 등록</button> -->
<!-- 											</div> -->
<!-- 										</div> -->
										
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