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
	
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">			<!-- jquery ui css google cdn -->
	
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>	<!-- jquery cdn -->
	<script type="text/javascript" src="${cpath }/include/js/datepicker/jquery.ui.datepicker-ko.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>	<!-- jquery ui cdn -->
	
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
		
		$('#ctgr1' ).on( 'change', { r_prclevel : 2, objId : '#ctgr2' }, selHandling );
		$('#ctgr2' ).on( 'change', { r_prclevel : 3, objId : '#ctgr3' }, selHandling );
		$('#ctgr3' ).on( 'change', { r_prclevel : 4, objId : '#ctgr4' }, selHandling );
		
		
		$( 'input[name="sc_prindates"]' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,     
			dateFormat: "yy-mm-dd",  //---출력format
			numberOfMonths : 3,       //---출력되는 달의 범위
			onClose : function ( selectedDate ){          //---종료일 달력설정
				$( 'input[name="sc_prindatee"]' ).datepicker( 'option', 'minDate', selectedDate ); 
			}
		});

		$( 'input[name="sc_prindatee"]' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,
			dateFormat: "yy-mm-dd",
			numberOfMonths : 3, 
			onClose : function ( selectedDate ){         //--- 시작일 달력 설정
				$( 'input[name="sc_prindates"]' ).datepicker( 'option', 'maxDate', selectedDate );
			}
		});
		  
		
// 		$('#table1 > tbody > tr' ).click(function(){
// 			var r_prseq = $(this).attr('value');
// 			handling.pageMove( 'productview', 'r_prseq='+r_prseq);
// 		});
		
		$( '#table1 > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
			$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', $( this ).prop( 'checked' ) );
		});
		
	});

	function selHandling( e ){
		
		var r_prcseq = $( this ).val();
		var param = '';
		var objId = e.data.objId;
		var r_prclevel = e.data.r_prclevel;
		
		if( 2 == r_prclevel ){
			$( '#ctgr2 option:gt(0)' ).remove();
			$( '#ctgr3 option:gt(0)' ).remove();
			$( '#ctgr4 option:gt(0)' ).remove();
			param = 'r_prcgnum1='+r_prcseq+'&r_prclevel='+r_prclevel;
		}else if ( 3 == r_prclevel ){
			$( '#ctgr3 option:gt(0)' ).remove();
			$( '#ctgr4 option:gt(0)' ).remove();
			param = 'r_prcgnum2='+r_prcseq+'&r_prclevel='+r_prclevel;
		}else if ( 4 == r_prclevel ){
			$( '#ctgr4 option:gt(0)' ).remove();
			param = 'r_prcgnum3='+r_prcseq+'&r_prclevel='+r_prclevel;
		}
		
		var options = {
			data : param,
			error : function( xhr, textStatus, error ){
				alert(error);
			},
			success : function( data ){
				for( var i = 0,n=data.length; i < n; i++){
					$( objId ).append('<option value="'+data[i].prc_seq+'">'+data[i].prc_name+'</option>');
				}
			},
			type : 'POST',
			url : '${cpath}/productcategory/bo/productcategorylistjson'
		}
		dataAjax( options );
	}
	
	function dataAjax( options ){
		$.ajax(options);
	}

	function dataAdd(  ){
		handling.submit( '', 'productadd' );
	}

	function dataDel( r_prseq ){
		if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
			return;
		}
		$('#r_prseq').val(r_prseq);
		handling.submit( '', 'productdel' );
	}
	
	function dataDown(){
		handling.submit( '', 'productdown' );
	}

	function dataEdit( r_prseq ){
		$('#r_prseq').val(r_prseq);
		handling.submit( '', 'productedit' );
	}

	function dataIn(){
		handling.submit( '', 'productin' );
	}

	function dataView( r_prseq ){
		$( '#r_prseq' ).val( r_prseq );
		handling.submit( '', 'productview' );
	}

	function dataList(){
		handling.submit( '', 'productlist' );
	}
	
	function dataListDel(  ){
		var r_prseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_prseqarr[idx] = $(this).val();
				idx++;
			}
		});
		if( r_prseqarr.length > 0 ){
			
			if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
				return;
			}
			
			$('input[name="r_prseqarr"]').val(r_prseqarr.join(','));
	 		handling.submit( '', 'productlistdel' );
		}else{
			alert('선택 후 진행해주십시오');
		}
	}
	
	function dataListUp( r_column, r_columnvalue ){
		var r_prseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_prseqarr[idx] = $(this).val();
				idx++;
			}
		});
		if( r_prseqarr.length > 0 ){
			if( !confirm( '변경 처리를 진행하시겠습니까?' ) ){
				return;
			}
			$('input[name="r_prseqarr"]').val(r_prseqarr.join(','));
			$('input[name="r_column"]').val(r_column);
			$('input[name="r_columnvalue"]').val(r_columnvalue);
	 		handling.submit( '', 'productlistup' );
		}else{
			alert('선택 후 진행해주십시오');
		}
		
	}
	
	
	function dataSearch(){
		$('input[name="r_page"]').val(1);
		handling.submit( '', 'productlist' );
	}

	function dataSort(){
		handling.submit( '', 'productlist' );
	}
	
	function dataUp(){
		handling.submit( '', 'productup' );
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
							<h3>상품 관리 <small>Product Manage</small></h3>
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
					
					<form action="productlist" class="form-horizontal" id="frm" name="frm" method="post" >
					
					<input name="r_page" type="hidden" value="${ model.r_page }" />
					<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
					<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />
			
					<input id="r_prseq" name="r_prseq" type="hidden" value="" />
					<input name="r_prseqarr" type="hidden" />
					<input name="r_column" type="hidden" value=""/>
					<input name="r_columnvalue" type="hidden" value=""/>
					
					
					
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>검색 <small>Search</small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
<!-- 										<li class="dropdown"> -->
<!-- 											<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a> -->
<!-- 											<ul class="dropdown-menu" role="menu"> -->
<!-- 												<li><a href="#">Settings 1</a></li> -->
<!--                              						<li><a href="#">Settings 2</a></li> -->
<!--                            					</ul> -->
<!--                        					</li> -->
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
													<option value="pr_name" <c:if test="${ param.sc_type eq 'pr_name' }">selected="selected"</c:if> >상품명</option>
													<option value="pr_code" <c:if test="${ param.sc_type eq 'pr_code' }">selected="selected"</c:if> >상품코드</option>
													<option value="pr_codes" <c:if test="${ param.sc_type eq 'pr_codes' }">selected="selected"</c:if> >공급사상품코드</option>
													<option value="pr_codeb" <c:if test="${ param.sc_type eq 'pr_codeb' }">selected="selected"</c:if> >구매사상품코드</option>
													<option value="pr_standard" <c:if test="${ param.sc_type eq 'pr_standard' }">selected="selected"</c:if> >규격</option>
													<option value="pr_model" <c:if test="${ param.sc_type eq 'pr_model' }">selected="selected"</c:if> >모델</option>
													<option value="pr_manufacture" <c:if test="${ param.sc_type eq 'pr_manufacture' }">selected="selected"</c:if> >제조사</option>
													<option value="pr_country" <c:if test="${ param.sc_type eq 'pr_country' }">selected="selected"</c:if> >원산지</option>
<%-- 													<option value="pr_status" <c:if test="${ param.sc_type eq 'pr_status' }">selected="selected"</c:if> >상품상태</option> --%>
												</select>
											</div>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_word" name="sc_word" placeholder="검색어" type="text" value="${ param.sc_word }" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="ctgr1">상품분류</label>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" id="ctgr1" name="ctgr1">
													<option value="">대분류선택</option>
													<c:forEach var="ctgr" items="${ model.productcategoryList1 }">
														<option value="${ ctgr.PRC_SEQ }" <c:if test="${ param.ctgr1 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" id="ctgr2" name="ctgr2">
													<option value="">중분류선택</option>
													<c:forEach var="ctgr" items="${ model.productcategoryList2 }">
														<option value="${ ctgr.PRC_SEQ }" <c:if test="${ param.ctgr2 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" id="ctgr3" name="ctgr3">
													<option value="">소분류선택</option>
													<c:forEach var="ctgr" items="${ model.productcategoryList3 }">
														<option value="${ ctgr.PRC_SEQ }" <c:if test="${ param.ctgr3 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" id="ctgr4" name="ctgr4" >
													<option value="">상세분류선택</option>
													<c:forEach var="ctgr" items="${ model.productcategoryList4 }">
														<option value="${ ctgr.PRC_SEQ }" <c:if test="${ param.ctgr4 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_prindates">상품등록일</label>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_prindates" name="sc_prindates" placeholder="상품등록일시작" type="text" value="${param.sc_prindates}" />
											</div>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_prindatee" name="sc_prindatee" placeholder="상품등록일끝" type="text" value="${param.sc_prindatee}" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_pruse">전시여부</label>
											<div class="col-sm-10 col-xs-12">
												<label class="radio-inline">
													<input name="sc_pruse" type="radio" value="Y" <c:if test="${ param.sc_pruse eq 'Y' }">checked="checked"</c:if> />YES
												</label>
												<label class="radio-inline">
													<input name="sc_pruse" type="radio" value="N" <c:if test="${ param.sc_pruse eq 'N' }">checked="checked"</c:if> />NO
												</label>
												<label class="radio-inline">
													<input name="sc_pruse" type="radio" value="" <c:if test="${ param.sc_pruse eq '' }">checked="checked"</c:if> />선택안함
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
									<h2>상품 리스트 <small>Product List</small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
<!-- 										<li class="dropdown"> -->
<!-- 											<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a> -->
<!-- 											<ul class="dropdown-menu" role="menu"> -->
<!-- 												<li><a href="#">Settings 1</a></li> -->
<!--                              						<li><a href="#">Settings 2</a></li> -->
<!--                            					</ul> -->
<!--                        					</li> -->
										<li><a class="close-link"><i class="fa fa-close"></i></a></li>
                       				</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<div class="table-responsive">
										<table class="table table-hover" id="table1" >
											<thead>
												<tr>
													<th>
														<input type="checkbox" />
													</th>
<!-- 													<th>고유번호</th> -->
													<th>상품카테고리</th>
													<th>상품코드</th>
<!-- 													<th>구매사상품코드</th> -->
<!-- 													<th>공급사상품코드</th> -->
													<th>상품명</th>
													<th>상품가격</th>
													<th>상품이미지</th>
													<th>공급사아이디</th>
<!-- 													<th>구매사아이디</th> -->
<!-- 													<th>바코드</th> -->
<!-- 													<th>부가세여부</th> -->
<!-- 													<th>적립금</th> -->
<!-- 													<th>규격</th> -->
<!-- 													<th>브랜드고유값</th> -->
<!-- 													<th>모델</th> -->
<!-- 													<th>단위</th> -->
<!-- 													<th>제조사</th> -->
<!-- 													<th>원산지</th> -->
<!-- 													<th>최소구매수량</th> -->
													<th>재고</th>
<!-- 													<th>무게</th> -->
								<!-- 					<th>내용</th> -->
<!-- 													<th>배송소요일</th> -->
<!-- 													<th>배송정책</th> -->
<!-- 													<th>상품상태</th> -->
<!-- 													<th>레벨</th> -->
<!-- 													<th>타입</th> -->
													<th>사용여부</th>
<!-- 													<th>수정아이디</th> -->
<!-- 													<th>등록아이디</th> -->
<!-- 													<th>수정일</th> -->
													<th>등록일</th>
													<th>관리</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach items="${ model.productMap.productList }" var="product" varStatus="status" >
												<tr>
													<td>
														<input type="checkbox" value="${ product.PR_SEQ }"/>
													</td>
<%-- 													<td><c:out value='${ product.PR_SEQ }' /></td> --%>
													<td><c:out value='${ product.PR_PRCSEQ }' /></td>
													<td><c:out value='${ product.PR_CODE }' /></td>
<%-- 													<td><c:out value='${ product.PR_CODEB }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_CODES }' /></td> --%>
													<td><c:out value='${ product.PR_NAME }' /></td>
													<td><c:out value="${ product.PR_PRICE }" /></td>
													<td><img style="width:50px;height:50px;" src="${cpath}/data/up/product/<c:out value='${ product.PR_IMAGE1 }'/>" /></td>
													<td><c:out value='${ product.PR_CPIDS }' /></td>
<%-- 													<td><c:out value='${ product.PR_CPIDB }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_BARCODE }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_VATUSE }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_SAVEMONEY }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_STANDARD }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_BRSEQ }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_MODEL }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_UNIT }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_MANUFACTURE }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_COUNTRY }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_MINBUYEA }' /></td> --%>
													<td><c:out value='${ product.PR_STOCK }' /></td>
<%-- 													<td><c:out value='${ product.PR_WEIGHT }' /></td> --%>
								<%-- 					<td>${ product.PR_CONTENT }</td> --%>
<%-- 													<td><c:out value='${ product.PR_DELITERM }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_DELIPOLICY }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_STATUS }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_LEVEL }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_TYPE }' /></td> --%>
													<td><c:out value='${ product.PR_USE }' /></td>
<%-- 													<td><c:out value='${ product.PR_MOID }' /></td> --%>
<%-- 													<td><c:out value='${ product.PR_INID }' /></td> --%>
<%-- 													<td>${ fn:substring( product.PR_MODATE, 0, 16 ) }</td> --%>
													<td>${ fn:substring( product.PR_INDATE, 0, 16 ) }</td>
													<td>
														<button type="button" class="btn btn-info btn-xs" onclick="dataView('${ product.PR_SEQ }')"><i class="fa fa-folder"></i></button>
														<button type="button" class="btn btn-warning btn-xs" onclick="dataEdit('${ product.PR_SEQ }')"><i class="fa fa-edit"></i></button>
														<button type="button" class="btn btn-danger btn-xs" onclick="dataDel('${ product.PR_SEQ }')"><i class="fa fa-trash"></i></button>
<%-- 														<button type="button" class="btn btn-success btn-xs" onclick="dataDel('${ product.PR_SEQ }')"><i class="fa fa-envelope-o"></i></button> --%>
<%-- 														<button type="button" class="btn btn-success btn-xs" onclick="dataDel('${ product.PR_SEQ }')"><i class="fa fa-tablet"></i></button> --%>
													</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
									
									<div class="form-group">
										<div class="col-md-6 col-sm-6 col-xs-12">
											<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( 'PR_USE', 'Y' )">선택승인</button>
											<button type="button" class="btn btn-warning btn-xs" onclick="dataListUp( 'PR_USE', 'N' )">선택미승인</button>
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