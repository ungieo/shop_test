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
		
		$('#ctgr1' ).on( 'change', { r_prclevel : 2, objId : '#ctgr2' }, selHandling );
		$('#ctgr2' ).on( 'change', { r_prclevel : 3, objId : '#ctgr3' }, selHandling );
		$('#ctgr3' ).on( 'change', { r_prclevel : 4, objId : '#ctgr4' }, selHandling );
		
		$('#ctgr1d' ).on( 'change', { r_prclevel : 2, objId : '#ctgr2d' }, selHandling2 );
		$('#ctgr2d' ).on( 'change', { r_prclevel : 3, objId : '#ctgr3d' }, selHandling2 );
		$('#ctgr3d' ).on( 'change', { r_prclevel : 4, objId : '#ctgr4d' }, selHandling2 );
		
		
		$( 'input[name="sc_prdindates"]' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,     
			dateFormat: "yy-mm-dd",  //---출력format
			numberOfMonths : 3,       //---출력되는 달의 범위
			onClose : function ( selectedDate ){          //---종료일 달력설정
				$( 'input[name="sc_prdindatee"]' ).datepicker( 'option', 'minDate', selectedDate ); 
			}
		});

		$( 'input[name="sc_prdindatee"]' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,
			dateFormat: "yy-mm-dd",
			numberOfMonths : 3, 
			onClose : function ( selectedDate ){         //--- 시작일 달력 설정
				$( 'input[name="sc_prdindates"]' ).datepicker( 'option', 'maxDate', selectedDate );
			}
		});
		
		$( 'input[name="sc_prindatesd"]' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,     
			dateFormat: "yy-mm-dd",  //---출력format
			numberOfMonths : 3,       //---출력되는 달의 범위
			onClose : function ( selectedDate ){          //---종료일 달력설정
				$( 'input[name="sc_prindateed"]' ).datepicker( 'option', 'minDate', selectedDate ); 
			}
		});

		$( 'input[name="sc_prindateed"]' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,
			dateFormat: "yy-mm-dd",
			numberOfMonths : 3, 
			onClose : function ( selectedDate ){         //--- 시작일 달력 설정
				$( 'input[name="sc_prindatesd"]' ).datepicker( 'option', 'maxDate', selectedDate );
			}
		});
		
		
		$( '#table1 > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
			$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', $( this ).prop( 'checked' ) );
		});
		
		$( '#table2 > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
			$( '#table2 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', $( this ).prop( 'checked' ) );
		});
		
		$('#productsearch-modal').on( 'hidden.bs.modal', function(event){
			location.reload();
		})
		
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
	
	function selHandling2( e ){
		var param = '';
		var objId = e.data.objId;
		var r_prcseq = $( this ).val();
		var r_prclevel = e.data.r_prclevel;
		
		if( 2 == r_prclevel ){
			$( '#ctgr2d option:gt(0)' ).remove();
			$( '#ctgr3d option:gt(0)' ).remove();
			$( '#ctgr4d option:gt(0)' ).remove();
			param = 'r_prcgnum1='+r_prcseq+'&r_prclevel='+r_prclevel;
		}else if ( 3 == r_prclevel ){
			$( '#ctgr3d option:gt(0)' ).remove();
			$( '#ctgr4d option:gt(0)' ).remove();
			param = 'r_prcgnum2='+r_prcseq+'&r_prclevel='+r_prclevel;
		}else if ( 4 == r_prclevel ){
			$( '#ctgr4d option:gt(0)' ).remove();
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
		handling.submit( '', 'productdisplayadd' );
	}

	function dataDel( r_prdseq ){
		if( !confirm("삭제 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prdseq').val( r_prdseq );
		handling.submit( '', 'productdisplaydel' );
	}

	function dataDown(){
		handling.submit( '', 'productdisplaydown' );
	}

	function dataEdit( r_prdseq ){
		$( '#r_prdseq' ).val( r_prdseq );
		handling.submit( '', 'productdisplayedit' );
	}

	function dataIn(){
		handling.submit( '', 'productdisplayin' );
	}

	function dataView( r_prdseq ){
		$( '#r_prdseq' ).val( r_prdseq );
		handling.submit( '', 'productdisplayview' );
	}

	function dataList(){
		handling.submit( '', 'productdisplaylist' );
	}

	function dataListDel(){
		var r_prdseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_prdseqarr[idx] = $(this).val();
				idx++;
			}
		});
		if( r_prdseqarr.length > 0 ){
			
			if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
				return;
			}
			
			$('input[name="r_prdseqarr"]').val(r_prdseqarr.join(','));
			handling.submit( '', 'productdisplaylistdel' );
		}else{
			alert('선택 후 진행해주십시오');
		}
	}

	function dataListUp( r_column, r_columnvalue ){
		var r_prdseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_prdseqarr[idx] = $(this).val();
				idx++;
			}
		});
		if( r_prdseqarr.length > 0 ){
			if( !confirm( '변경 처리를 진행하시겠습니까?' ) ){
				return;
			}
			$('input[name="r_prdseqarr"]').val(r_prdseqarr.join(','));
			$('input[name="r_column"]').val(r_column);
			$('input[name="r_columnvalue"]').val(r_columnvalue);
			handling.submit( '', 'productdisplaylistup' );
		}else{
			alert('선택 후 진행해주십시오');
		}
	}

	function dataSearch(){
		$('input[name="r_page"]').val(1);
		handling.submit( '', 'productdisplaylist' );
	}

	function dataSort(){
		handling.submit( '', 'productdisplaylist' );
	}

	function dataUp( r_prdseq ){
		if( !confirm("수정 처리를 진행하시겠습니까?")){;
			return;
		};
		$('#r_prdseq').val( r_prdseq );
		handling.submit( '', 'productdisplayup' );
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

	
	
	
	function modalListIn(){
		var r_prdprseqarr = [];
		var checkarr = $( '#table2 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_prdprseqarr[idx] = $(this).val();
				idx++;
			}
		});
		if( r_prdprseqarr.length > 0 ){
// 			if( !confirm( '등록 처리를 진행하시겠습니까?' ) ){
// 				return;
// 			}
			var param='';
			var r_prdtype = $('select[name="r_prdtype"]').val();
			param += 'r_prdprseqarr='+r_prdprseqarr.join(',')+'&r_prdtype='+r_prdtype;
			var option = {
				data : param,
				error : function( xhr, textStatus, error ){
					alert(error);
				},
				success : function( data ){
					
					if( data.result ){
						$( '#table2 > thead > tr > th > input[type=checkbox]' ).prop('checked',false);
						$( '#table2 > tbody > tr > td > input[type=checkbox]' ).prop('checked',false);
						alert('정상 등록되었습니다.');
					}else{
						alert('처리에 오류가 발생했습니다.');
					}
				},
				type : 'POST',
				url : '${cpath}/productdisplay/bo/productdisplaylistinajax'
			}
			dataAjax( option );
			
		}else{
			alert('선택 후 진행해주십시오');
		}
	}
	function modalpager( r_page ){
		$('#r_paged').val(r_page);
		modalSearch();
	}
	
	function modalSearch(){
		var param = '';
		
		var sc_type = $('#sc_typed').val();
		var sc_word = $('#sc_wordd').val();
		var ctgr1 = $('#ctgr1d').val();
		var ctgr2 = $('#ctgr2d').val();
		var ctgr3 = $('#ctgr3d').val();
		var ctgr4 = $('#ctgr4d').val();
		var sc_prindates = $('#sc_prindatesd').val();
		var sc_prindatee = $('#sc_prindateed').val();
		var sc_pruse = $('input[name="sc_prused"]:checked').val();
		var r_page = $('#r_paged').val();
		var r_pagelimit = $('#r_pagelimitd').val();
		var r_rowlimit = $('#r_rowlimitd').val();
		
		param += 'sc_type='+sc_type+'&sc_word='+sc_word+'&sc_prindates='+sc_prindates+'&sc_prindatee='+sc_prindatee+'&sc_pruse='+sc_pruse;
		param += '&ctgr1='+ctgr1+'&ctgr2='+ctgr2+'&ctgr3='+ctgr3+'&ctgr4='+ctgr4
		param += '&r_page='+r_page+'&r_pagelimit='+r_pagelimit+'&r_rowlimit='+r_rowlimit;
		
		var option = {
			data : param,
			error : function( xhr, textStatus, error ){
				alert(error);
			},
			success : function( data ){
				$('#table2 > tbody').html('');
				$('#modal_paging').html('');
				var rowHtml = '';
				var pageHtml = '';
				
				for( var i = 0, n=data.productList.length; i < n; i++ ){
					
					rowHtml = '<tr>';
					rowHtml += '<td><input type="checkbox" value="'+data.productList[i].pr_seq+'" /></td>';
					rowHtml += '<td>'+data.productList[i].pr_prcseq+'</td>';
					rowHtml += '<td>'+data.productList[i].pr_code+'</td>';
					rowHtml += '<td>'+data.productList[i].pr_name+'</td>';
					rowHtml += '<td>'+data.productList[i].pr_price+'</td>';
					rowHtml += '<td><img src="${cpath}/data/up/product/'+data.productList[i].pr_image1+'" style="width:50px;height:50px;" /></td>';
					rowHtml += '<td>'+data.productList[i].pr_cpids+'</td>';
					rowHtml += '<td>'+data.productList[i].pr_stock+'</td>';
					rowHtml += '<td>'+data.productList[i].pr_use+'</td>';
					rowHtml += '<td>'+data.productList[i].pr_indate+'</td>';
// 					rowHtml += '<td>관리</td>';
					rowHtml += '</tr>';
					
					$('#table2 > tbody').append(rowHtml);
				}
				for( var i = data.startPage, n = data.endPage+1; i < n; i++ ){
					if( i == data.startPage ){
						if( data.r_page != 1 ){
							pageHtml += '<button type="button" class="btn btn-info btn-xs" onclick="modalpager( 1 )">처음</button>';
							pageHtml += '<button type="button" class="btn btn-default btn-xs" onclick="modalpager( '+(data.r_page-1)+' )">이전</button></a>';
						}else if( data.r_page == 1 ){
							pageHtml += '<button type="button" class="btn btn-info btn-xs">처음</button>';
							pageHtml += '<button type="button" class="btn btn-default btn-xs">이전</button>';
						}
					}
					
					if( data.r_page == i ){
// 						pageHtml += '<span><strong><mark>'+i+'</mark></strong></span>';
						pageHtml += '<button class="btn btn-default btn-xs active" >'+i+'</button>';	
					}else if( data.r_page != i ){
// 						pageHtml += '<a href="#" onclick="modalpager( '+i+' )"><span>'+i+'</span></a>';
						pageHtml += '<button type="button" class="btn btn-default btn-xs" onclick="modalpager( '+i+' )">'+i+'</button>';
					}
					
					if( i == data.endPage ){
						if( data.totPage != data.r_page ){
							pageHtml += '<button type="button" class="btn btn-default btn-xs" onclick="modalpager( '+(data.r_page+1)+' )" >다음</button></a>';
							pageHtml += '<button type="button" class="btn btn-info btn-xs" onclick="modalpager( '+data.totPage+' )">끝</button></a>';
						}else if( data.totPage == data.r_page ){
							pageHtml += '<button type="button" class="btn btn-default btn-xs">다음</button>';
							pageHtml += '<button type="button" class="btn btn-info btn-xs">끝</button>';
						}
					}
					
				}
				$('#modal_paging').html( pageHtml );
			},
			type : 'POST',
			url : '${cpath}/product/bo/productlistajax'
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

					<form action="productdisplaylist" class="form-horizontal" id="frm" name="frm" method="post" >
				
						<input name="r_page" type="hidden" value="${ model.r_page }" />
						<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
						<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />
				
						<input id="r_prdseq" name="r_prdseq" type="hidden" value="" />
						<input id="r_prdseqarr" name="r_prdseqarr" type="hidden" value="" />
						<input name="r_column" type="hidden" value=""/>
						<input name="r_columnvalue" type="hidden" value=""/>
						
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>상품 진열 리스트 검색 <small>Search</small></h2>
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
													<option value="pr_name" <c:if test="${ param.sc_type eq 'pr_name' }">selected="selected"</c:if> >상품명</option>
													<option value="pr_code" <c:if test="${ param.sc_type eq 'pr_code' }">selected="selected"</c:if> >상품코드</option>
<%-- 													<option value="pr_codes" <c:if test="${ param.sc_type eq 'pr_codes' }">selected="selected"</c:if> >공급사상품코드</option> --%>
<%-- 													<option value="pr_codeb" <c:if test="${ param.sc_type eq 'pr_codeb' }">selected="selected"</c:if> >구매사상품코드</option> --%>
<%-- 													<option value="pr_standard" <c:if test="${ param.sc_type eq 'pr_standard' }">selected="selected"</c:if> >규격</option> --%>
<%-- 													<option value="pr_model" <c:if test="${ param.sc_type eq 'pr_model' }">selected="selected"</c:if> >모델</option> --%>
<%-- 													<option value="pr_manufacture" <c:if test="${ param.sc_type eq 'pr_manufacture' }">selected="selected"</c:if> >제조사</option> --%>
<%-- 													<option value="pr_country" <c:if test="${ param.sc_type eq 'pr_country' }">selected="selected"</c:if> >원산지</option> --%>
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
											<label class="col-sm-2 col-xs-12 control-label" for="sc_prdindates">등록일</label>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_prdindates" name="sc_prdindates" placeholder="상품등록일시작" type="text" value="${param.sc_prdindates}" />
											</div>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_prdindatee" name="sc_prdindatee" placeholder="상품등록일끝" type="text" value="${param.sc_prdindatee}" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_prduse">승인여부</label>
											<div class="col-sm-10 col-xs-12">
												<label class="radio-inline">
													<input name="sc_prduse" type="radio" value="Y" <c:if test="${ param.sc_prduse eq 'Y' }">checked="checked"</c:if> />YES
												</label>
												<label class="radio-inline">
													<input name="sc_prduse" type="radio" value="N" <c:if test="${ param.sc_prduse eq 'N' }">checked="checked"</c:if> />NO
												</label>
												<label class="radio-inline">
													<input name="sc_prduse" type="radio" value="" <c:if test="${ param.sc_prduse eq '' }">checked="checked"</c:if> />선택안함
												</label>
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_prdtype">진열타입</label>
											<div class="col-sm-10 col-xs-12">
												<label class="radio-inline">
													<input name="sc_prdtype" type="radio" value="B" <c:if test="${ param.sc_prdtype eq 'B' }">checked="checked"</c:if> />베스트상품(B)
												</label>
												<label class="radio-inline">
													<input name="sc_prdtype" type="radio" value="H" <c:if test="${ param.sc_prdtype eq 'H' }">checked="checked"</c:if> />HOT상품(H)
												</label>
												<label class="radio-inline">
													<input name="sc_prdtype" type="radio" value="N" <c:if test="${ param.sc_prdtype eq 'N' }">checked="checked"</c:if> />신상품(N)
												</label>
												<label class="radio-inline">
													<input name="sc_prdtype" type="radio" value="P" <c:if test="${ param.sc_prdtype eq 'P' }">checked="checked"</c:if> />인기상품(P)
												</label>
												<label class="radio-inline">
													<input name="sc_prdtype" type="radio" value="R" <c:if test="${ param.sc_prdtype eq 'R' }">checked="checked"</c:if> />추천상품(R)
												</label>
												<label class="radio-inline">
													<input name="sc_prdtype" type="radio" value="" <c:if test="${ param.sc_prdtype eq '' }">checked="checked"</c:if> />선택안함
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
										<h2>상품 진열 리스트 <small>Product Display List</small></h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
											<li><a class="close-link"><i class="fa fa-close"></i></a></li>
	                       				</ul>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										<div class="table-responsive">
				
											<table class="table table-striped" id="table1">
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
														<th>진열타입</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${ model.productdisplayMap.productList}" var="pr" varStatus="status" >
													<c:set var="prd" value="${ model.productdisplayMap.productdisplayList[status.index] }" />
													<c:set var="prc" value="${ model.productdisplayMap.productcategoryList[status.index] }" />
													<tr>
														<td>
															<input type="checkbox" value="${ prd.PRD_SEQ }"/>
														</td>
	<%-- 													<td><c:out value='${ pr.PR_SEQ }' /></td> --%>
														<td><c:out value='${ prc.PRC_NAME }' /></td>
														<td><c:out value='${ pr.PR_CODE }' /></td>
	<%-- 													<td><c:out value='${ pr.PR_CODEB }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_CODES }' /></td> --%>
														<td><c:out value='${ pr.PR_NAME }' /></td>
														<td><c:out value="${ pr.PR_PRICE }" /></td>
														<td><img style="width:50px;height:50px;" src="${cpath}/data/up/product/<c:out value='${ pr.PR_IMAGE1 }'/>" /></td>
														<td><c:out value='${ pr.PR_CPIDS }' /></td>
	<%-- 													<td><c:out value='${ pr.PR_CPIDB }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_BARCODE }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_VATUSE }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_SAVEMONEY }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_STANDARD }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_BRSEQ }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_MODEL }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_UNIT }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_MANUFACTURE }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_COUNTRY }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_MINBUYEA }' /></td> --%>
														<td><c:out value='${ pr.PR_STOCK }' /></td>
	<%-- 													<td><c:out value='${ pr.PR_WEIGHT }' /></td> --%>
									<%-- 					<td>${ pr.PR_CONTENT }</td> --%>
	<%-- 													<td><c:out value='${ pr.PR_DELITERM }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_DELIPOLICY }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_STATUS }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_LEVEL }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_TYPE }' /></td> --%>
														<td><c:out value='${ prd.PRD_USE }' /></td>
	<%-- 													<td><c:out value='${ pr.PR_MOID }' /></td> --%>
	<%-- 													<td><c:out value='${ pr.PR_INID }' /></td> --%>
	<%-- 													<td>${ fn:substring( pr.PR_MODATE, 0, 16 ) }</td> --%>
														<td>${ fn:substring( prd.PRD_INDATE, 0, 10 ) }</td>
														<td>
															<button type="button" class="btn btn-success btn-xs" onclick="dataDel('${ pr.PR_SEQ }')">${prd.PRD_TYPE}</button>
														</td>
													</tr>
													</c:forEach>
												</tbody>
											</table>
										
										</div>
										
										
										<div class="form-group">
											<div class="col-md-6 col-sm-6 col-xs-12">
												<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( 'PRD_USE', 'Y' )">선택승인</button>
												<button type="button" class="btn btn-warning btn-xs" onclick="dataListUp( 'PRD_USE', 'N' )">선택미승인</button>
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
												<button type="button" class="btn btn-success" data-toggle="modal" data-target="#productsearch-modal"><i class="fa fa-plus"></i> 상품진열등록</button>
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


	<!-- *product search modal -->
	<div class="modal fade" id="productsearch-modal" tabindex="-1" role="dialog" aria-labelledby="productsearch" aria-hidden="true">
		<div class="modal-dialog modal-lg">

			<div class="modal-content">
				<div class="modal-header" style="background-color:#4fbfa8">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title text-center" id="Login"><strong>상품 검색</strong></h4>
				</div>
				<div class="modal-body">
					<form action="#" class="form-horizontal" method="post" name="frm_modal" id="frm_modal">
						<input name="r_paged" id="r_paged" type="hidden" value="" />
						<input name="r_pagelimitd" id="r_pagelimitd" type="hidden" value="" />
						<input name="r_rowlimitd" id="r_rowlimitd" type="hidden" value="" />
						
						<input id="r_prdprseqarr" name="r_prdprseqarr" type="hidden" value="" />
					
						<div class="form-group">
							<label class="col-sm-2 col-xs-12 control-label" for="sc_typed">검색분류</label>
							<div class="col-sm-2 col-xs-12">
								<select class="form-control" name="sc_typed" id="sc_typed">
									<option value="" >선택</option>
									<option value="pr_name" <c:if test="${ param.sc_type eq 'pr_name' }">selected="selected"</c:if> >상품명</option>
									<option value="pr_code" <c:if test="${ param.sc_type eq 'pr_code' }">selected="selected"</c:if> >상품코드</option>
<%-- 									<option value="pr_codes" <c:if test="${ param.sc_type eq 'pr_codes' }">selected="selected"</c:if> >공급사상품코드</option> --%>
<%-- 									<option value="pr_codeb" <c:if test="${ param.sc_type eq 'pr_codeb' }">selected="selected"</c:if> >구매사상품코드</option> --%>
<%-- 									<option value="pr_standard" <c:if test="${ param.sc_type eq 'pr_standard' }">selected="selected"</c:if> >규격</option> --%>
									<option value="pr_model" <c:if test="${ param.sc_type eq 'pr_model' }">selected="selected"</c:if> >모델</option>
									<option value="pr_manufacture" <c:if test="${ param.sc_type eq 'pr_manufacture' }">selected="selected"</c:if> >제조사</option>
									<option value="pr_country" <c:if test="${ param.sc_type eq 'pr_country' }">selected="selected"</c:if> >원산지</option>
								</select>
							</div>
							<div class="col-sm-2 col-xs-12">
								<input class="form-control" id="sc_wordd" name="sc_wordd" placeholder="검색어" type="text" value="${ param.sc_word }" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 col-xs-12 control-label" for="ctgr1d">상품분류</label>
							<div class="col-sm-2 col-xs-12">
								<select class="form-control" id="ctgr1d" name="ctgr1d">
									<option value="">대분류선택</option>
									<c:forEach var="ctgr" items="${ model.productcategoryList1 }">
										<option value="${ ctgr.PRC_SEQ }" <c:if test="${ param.ctgr1 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2 col-xs-12">
								<select class="form-control" id="ctgr2d" name="ctgr2d">
									<option value="">중분류선택</option>
									<c:forEach var="ctgr" items="${ model.productcategoryList2 }">
										<option value="${ ctgr.PRC_SEQ }" <c:if test="${ param.ctgr2 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2 col-xs-12">
								<select class="form-control" id="ctgr3d" name="ctgr3d">
									<option value="">소분류선택</option>
									<c:forEach var="ctgr" items="${ model.productcategoryList3 }">
										<option value="${ ctgr.PRC_SEQ }" <c:if test="${ param.ctgr3 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2 col-xs-12">
								<select class="form-control" id="ctgr4d" name="ctgr4d" >
									<option value="">상세분류선택</option>
									<c:forEach var="ctgr" items="${ model.productcategoryList4 }">
										<option value="${ ctgr.PRC_SEQ }" <c:if test="${ param.ctgr4 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 col-xs-12 control-label" for="sc_prindatesd">상품등록일</label>
							<div class="col-sm-2 col-xs-12">
								<input class="form-control" id="sc_prindatesd" name="sc_prindatesd" placeholder="상품등록일시작" type="text"  />
							</div>
							<div class="col-sm-2 col-xs-12">
								<input class="form-control" id="sc_prindateed" name="sc_prindateed" placeholder="상품등록일끝" type="text" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 col-xs-12 control-label" for="sc_prused">승인여부</label>
							<div class="col-sm-10 col-xs-12">
								<label class="radio-inline">
									<input name="sc_prused" type="radio" value="Y" />YES
								</label>
								<label class="radio-inline">
									<input name="sc_prused" type="radio" value="N" />NO
								</label>
								<label class="radio-inline">
									<input name="sc_prused" type="radio" value="" checked="checked"/>선택안함
								</label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-xs-12">
								<button type="button" class="btn btn-info btn-lg btn-block" onclick="modalpager(1)">검색</button>
							</div>
						</div>
						
						<hr/>
						
						<div class="table-responsive">
							<table class="table table-hover" id="table2">
								<thead>
									<tr>
										<th>
											<input type="checkbox" />
										</th>
										<th>카테고리</th>
										<th>코드</th>
										<th>상품명</th>
										<th>가격</th>
										<th>이미지</th>
										<th>공급사아이디</th>
										<th>재고</th>
										<th>승인여부</th>
										<th>등록일</th>
<!-- 										<th>관리</th> -->
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="text-center" colspan="11"><strong>상품을 검색해주세요.</strong></td>
									</tr>
								</tbody>
							</table>
						</div>
						
						<div class="form-group">
							<div class="col-sm-12">
								<div class="pull-right" id="modal_paging">
									
								</div>
							</div>
						</div>
					</form>

<!-- 					<p class="text-center text-muted">회원이 아니시라면?</p> -->
<!-- 					<p class="text-center text-muted"> -->
<%-- 						<a href="${cpath}/member/memberadd"><strong>회원가입 바로가기</strong></a>! 고객님을 위한 다양한 이벤트가 준비되어 있습니다. --%>
<!-- 					</p> -->

				</div>
				<div class="modal-footer">
					<div class="col-sm-10">
						<select name="r_prdtype" class="form-control">
							<option value="B">베스트상품</option>
							<option value="H">HOT상품</option>
							<option value="N">신상품</option>
							<option value="P">인기상품</option>
							<option value="R">추천상품</option>
						</select>
					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-success btn-block" onclick="modalListIn()">등록</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- product search modal -->

</body>
</html>