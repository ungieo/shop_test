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
	<script type="text/javascript" src="//cdn.ckeditor.com/4.5.7/full/ckeditor.js"></script>
	
	<script src="${cpath }/include/js/datepicker/jquery.ui.datepicker-ko.js" type="text/javascript"></script>
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
		
		$('#ctgr1' ).on( 'change', { r_prclevel : 2, objId : '#ctgr2' }, selHandling );
		$('#ctgr2' ).on( 'change', { r_prclevel : 3, objId : '#ctgr3' }, selHandling );
		$('#ctgr3' ).on( 'change', { r_prclevel : 4, objId : '#ctgr4' }, selHandling );
		
		CKEDITOR.replace('editor1', {
			toolbar : 'Basic',
			filebrowserImageUploadUrl : '/soledot_product/include/imgupload.jsp?type=Images', //파일업로드시 사용
			width : '100%', //---넓이값
			height : '200' //---높이값
		});
		$('form[name="frm"]').validate();
		
		
		
		
		
		$('#ctgr1d' ).on( 'change', { r_prclevel : 2, objId : '#ctgr2d' }, selHandling2 );
		$('#ctgr2d' ).on( 'change', { r_prclevel : 3, objId : '#ctgr3d' }, selHandling2 );
		$('#ctgr3d' ).on( 'change', { r_prclevel : 4, objId : '#ctgr4d' }, selHandling2 );
		
		
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

	function dataAdd(){
		handling.submit( '', 'productadd' );
	}

	function dataEdit(){
		handling.submit( '', 'productedit' );
	}

	function dataDel(){
		handling.submit( '', 'productdel' );
	}

	function dataDown( r_flsseq ){
		handling.pageMove( '${cpath}/system/filedown', 'r_flsseq='+r_flsseq );
	}

	function dataIn(){
		$('#r_prcontent').val(CKEDITOR.instances.editor1.getData());
		handling.submit( '', 'productin' );
	}

	function dataView(){
		handling.submit( '', 'productview' );
	}

	function dataList(){
		handling.submit( '', 'productlist' );
	}

	function dataSort(){
		handling.submit( '', 'productlist' );
	}

	function dataUp(){
		$('#r_prcontent').val(CKEDITOR.instances.editor1.getData());
		handling.submit( '', 'productup' );
	}

	function formSubmit( fName, url ){
		handling.submit( fName, url );
	}

	function pager( r_page ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( '', '' );
	}

	function pageMove(  ){
		handling.pageMove( r_url, param);
	}
	
// 	function fileDel( obj, r_flsseq ){
// 		if( confirm( '주의! 확인을 클릭하시면, 서버에서 이미지가 바로 삭제처리 됩니다.' ) ){
// 	 		var options = {
// 				data : 'r_flsseq='+r_flsseq,
// 				error : function( xhr, textStatus, error ){
// 					alert(error);
// 				},
// 				success : function( data ){
// 					alert(data);
// 					$(obj).siblings('img').attr('src','');
// 				},
// 				type : 'POST',
// 				url : '${cpath}/product/bo/filestoragedeljson'
// 			}
// 			dataAjax( options );
// 		}
// 	}
	
// 	function fileChange( obj, r_flsseq ){
// 		if( $(obj).siblings(':file').val() == '' ){
// 			alert( '변경 할 이미지를 선택해주십시오' );
// 			return;
// 		}
		
// 		if( confirm( '주의! 확인을 클릭하시면, 서버에서 이미지가 바로 변경처리 됩니다.' ) ){
// 			var param = '';
// 			var r_prseq = $('#r_prseq').val();
// 			param += 'r_prseq='+r_prseq;
// 			if( r_flsseq != '' ){
// 				param += '&r_flsseq='+r_flsseq;
// 			}
// 	 		var options = {
// 				data : param,
// 				error : function( xhr, textStatus, error ){
// 					alert(error);
// 				},
// 				success : function( data ){
// 					$(obj).siblings('img').attr('src','${cpath}/data/up/product/'+data);
// 				},
// 				url : '${cpath}/product/bo/filestorageupjson'
// 			}
// 			dataAjax( options );
// 		}
		
// 	}
	
	
	
	var prgObj;
	
	function prgAdd( obj ){
		$('#productsearch-modal').modal('show');
		prgObj = obj;
// 		modalSearch()
	}
	
	function prgDel( obj ){
		$(obj).parent().parent().find(':text').val('');
		$(obj).parent().parent().find(':hidden').val('');
	}
	
	function prgSet( prgprseq, prgprname ){
		$(prgObj).parent().parent().find(':text').val(prgprname);
		$(prgObj).parent().parent().find(':hidden').val(prgprseq);
		$('#productsearch-modal').modal('hide');
	}
	
	function modalPager( r_page ){
		$('#r_paged').val(r_page);
		modalSearch();
	}
	
	function modalAjax(param){
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
						rowHtml += '<td>'+data.productList[i].pr_prcseq+'</td>';
						rowHtml += '<td>'+data.productList[i].pr_code+'</td>';
						rowHtml += '<td>'+data.productList[i].pr_name+'</td>';
						rowHtml += '<td>'+data.productList[i].pr_price+'</td>';
						rowHtml += '<td><img src="${cpath}/data/up/product/'+data.productList[i].pr_image1+'" style="width:50px;height:50px;" /></td>';
						rowHtml += '<td>'+data.productList[i].pr_cpids+'</td>';
						rowHtml += '<td>'+data.productList[i].pr_stock+'</td>';
						rowHtml += '<td>'+data.productList[i].pr_use+'</td>';
						rowHtml += '<td>'+data.productList[i].pr_indate+'</td>';
						rowHtml += '<td><a href="javascript:prgSet(\''+data.productList[i].pr_seq+'\',\''+data.productList[i].pr_name+'\');">선택</a></td>';
						rowHtml += '</tr>';
						
						$('#table2 > tbody').append(rowHtml);
					}
					for( var i = data.startPage, n = data.endPage+1; i < n; i++ ){
						if( i == data.startPage ){
							if( data.r_page != 1 ){
								pageHtml += '<a href="javascript:modalPager( 1 )"><button type="button" class="btn btn-info btn-xs">처음</button>';
								pageHtml += '<a href="javascript:modalPager( '+(data.r_page-1)+' )" ><button type="button" class="btn btn-default btn-xs">이전</button></a>';
							}else if( data.r_page == 1 ){
								pageHtml += '<button type="button" class="btn btn-info btn-xs">처음</button>';
								pageHtml += '<button type="button" class="btn btn-default btn-xs">이전</button>';
							}
						}
						
						if( data.r_page == i ){
//	 						pageHtml += '<span><strong><mark>'+i+'</mark></strong></span>';
							pageHtml += '<button class="btn btn-default btn-xs active" >'+i+'</button>';	
						}else if( data.r_page != i ){
//	 						pageHtml += '<a href="#" onclick="modalPager( '+i+' )"><span>'+i+'</span></a>';
							pageHtml += '<button type="button" class="btn btn-default btn-xs" onclick="modalPager( '+i+' )">'+i+'</button>';
						}
						
						if( i == data.endPage ){
							if( data.totPage != data.r_page ){
								pageHtml += '<a href="javascript:modalPager( '+(data.r_page+1)+' )" ><button type="button" class="btn btn-default btn-xs">다음</button></a>';
								pageHtml += '<a href="javascript:modalPager( '+data.totPage+' )" ><button type="button" class="btn btn-info btn-xs">끝</button></a>';
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
		
		modalAjax(param);
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
	
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>상품 등록 <small>Product Add</small></h2>
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

									<form action="productin" class="form-horizontal" id="frm" name="frm" method="post" enctype="multipart/form-data">
										<input id="r_prcontent" name="r_prcontent" type="hidden" />
										<input id="r_prseq" name="r_prseq" type="hidden" value="${ model.product.PR_SEQ }" />
										
								<!-- 		<input id="r_prprcseq" name="r_prcprseq" /> -->
										
<!-- 										<fieldset> -->
<!-- 											<legend>productadd</legend> -->
								<!-- 			<div class="form-group"> -->
								<!-- 				<label for="r_prseq">고유번호</label> -->
								<%-- 				<input id="r_prseq" name="r_prseq" placeholder="고유번호" type="text" value="<c:out value='${ model.product.PR_SEQ }' />" required /> --%>
								<!-- 			</div> -->
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="ctgr1">상품분류</label>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" id="ctgr1" name="ctgr1">
													<option value="">대분류선택</option>
													<c:forEach var="ctgr" items="${ model.productcategoryList1 }">
														<option value="${ ctgr.PRC_SEQ }" <c:if test="${ model.productcategory.PRC_GNUM1 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" id="ctgr2" name="ctgr2">
													<option value="">중분류선택</option>
													<c:forEach var="ctgr" items="${ model.productcategoryList2 }">
														<option value="${ ctgr.PRC_SEQ }" <c:if test="${ model.productcategory.PRC_GNUM2 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" id="ctgr3" name="ctgr3">
													<option value="">소분류선택</option>
													<c:forEach var="ctgr" items="${ model.productcategoryList3 }">
														<option value="${ ctgr.PRC_SEQ }" <c:if test="${ model.productcategory.PRC_GNUM3 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" id="ctgr4" name="r_prprcseq" >
													<option value="">상세분류선택</option>
													<c:forEach var="ctgr" items="${ model.productcategoryList4 }">
														<option value="${ ctgr.PRC_SEQ }" <c:if test="${ model.productcategory.PRC_GNUM4 eq ctgr.PRC_SEQ }">selected="selected"</c:if> >${ ctgr.PRC_NAME }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prcode">상품코드</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prcode" name="r_prcode" placeholder="상품코드" type="text" value="<c:out value='${ model.product.PR_CODE }' />" />
											</div>
										</div>
<!-- 										<div class="form-group"> -->
<!-- 											<label class="control-label col-sm-2 col-xs-12" for="r_prcodeb">구매사상품코드</label> -->
<!-- 											<div class="col-sm-3 col-xs-12"> -->
<%-- 												<input class="form-control" id="r_prcodeb" name="r_prcodeb" placeholder="구매사상품코드" type="text" value="<c:out value='${ model.product.PR_CODEB }' />" /> --%>
<!-- 											</div> -->
<!-- 										</div> -->
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prcodes">공급사상품코드</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prcodes" name="r_prcodes" placeholder="공급사상품코드" type="text" value="<c:out value='${ model.product.PR_CODES }' />" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prname">상품명</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prname" name="r_prname" placeholder="상품명" type="text" value="<c:out value='${ model.product.PR_NAME }' />" required />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prprice">상품가격</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prprice" name="r_prprice" placeholder="상품가격" type="text" value="<c:out value='${ model.product.PR_PRICE }' />" required digits="true" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_primage1">상품이미지1</label>
											<div class="col-sm-3 col-xs-12">
												<img style="width:100px;height:100px;" src="${cpath}/data/up/product/${model.product.PR_IMAGE1}"/>
												<input class="form-control" id="r_primage1" name="r_primage1" placeholder="상품이미지1" type="file" accept="image/*" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_primage2">상품이미지2</label>
											<div class="col-sm-3 col-xs-12">
												<img style="width:100px;height:100px;" src="${cpath}/data/up/product/${model.product.PR_IMAGE2}"/>
												<input class="form-control" id="r_primage2" name="r_primage2" placeholder="상품이미지2" type="file" accept="image/*" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_primage3">상품이미지3</label>
											<div class="col-sm-3 col-xs-12">
												<img style="width:100px;height:100px;" src="${cpath}/data/up/product/${model.product.PR_IMAGE3}"/>
												<input class="form-control" id="r_primage3" name="r_primage3" placeholder="상품이미지3" type="file" accept="image/*" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_primage4">상품이미지4</label>
											<div class="col-sm-3 col-xs-12">
												<img style="width:100px;height:100px;" src="${cpath}/data/up/product/${model.product.PR_IMAGE4}"/>
												<input class="form-control" id="r_primage4" name="r_primage4" placeholder="상품이미지4" type="file" accept="image/*" />
											</div>
										</div>	
										
										
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prcpids">공급사아이디</label>
											<div class="col-sm-3 col-xs-12">
												<select class="form-control" id="r_prcpids" name="r_prcpids" >
													<option value="N" <c:if test="${ scompany.CP_ID eq model.product.PR_CPIDS }">selected="selected"</c:if>>없음</option>
													<c:forEach var="scompany" items="${ model.scompanyList }">
														<option value="${ scompany.CP_ID }" <c:if test="${ scompany.CP_ID eq model.product.PR_CPIDS }">selected="selected"</c:if> >${ scompany.CP_NAME }</option>
													</c:forEach>
												</select>
											</div>
										</div>
<!-- 										<div class="form-group"> -->
<!-- 											<label class="control-label col-sm-2 col-xs-12" for="r_prcpidb">구매사아이디</label> -->
<!-- 											<div class="col-sm-3 col-xs-12"> -->
<%-- 												<input class="form-control" id="r_prcpidb" name="r_prcpidb" placeholder="구매사아이디" type="text" value="<c:out value='${ model.product.PR_CPIDB }' />" /> --%>
<!-- 											</div> -->
<!-- 										</div> -->
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prbarcode">바코드</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prbarcode" name="r_prbarcode" placeholder="바코드" type="text" value="<c:out value='${ model.product.PR_BARCODE }' />" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prvatuse">부가세여부</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prvatuse" name="r_prvatuse" placeholder="부가세여부" type="text" value="<c:out value='${ model.product.PR_VATUSE }' />" required />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prsavemoney">적립금</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prsavemoney" name="r_prsavemoney" placeholder="적립금" type="text" value="<c:out value='${ model.product.PR_SAVEMONEY }' />" digits="true" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prstandard">규격</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prstandard" name="r_prstandard" placeholder="규격" type="text" value="<c:out value='${ model.product.PR_STANDARD }' />" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prbrseq">브랜드고유값</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prbrseq" name="r_prbrseq" placeholder="브랜드고유값" type="text" value="<c:out value='${ model.product.PR_BRSEQ }' />" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prmodel">모델</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prmodel" name="r_prmodel" placeholder="모델" type="text" value="<c:out value='${ model.product.PR_MODEL }' />" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prunit">단위</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prunit" name="r_prunit" placeholder="단위" type="text" value="<c:out value='${ model.product.PR_UNIT }' />" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prmanufacture">제조사</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prmanufacture" name="r_prmanufacture" placeholder="제조사" type="text" value="<c:out value='${ model.product.PR_MANUFACTURE }' />" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prcountry">원산지</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prcountry" name="r_prcountry" placeholder="원산지" type="text" value="<c:out value='${ model.product.PR_COUNTRY }' />" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prminbuyea">최소구매수량</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prminbuyea" name="r_prminbuyea" placeholder="최소구매수량" type="text" value="<c:out value='${ model.product.PR_MINBUYEA }' />" required digits="true"/>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prstock">재고</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prstock" name="r_prstock" placeholder="재고" type="text" value="<c:out value='${ model.product.PR_STOCK }' />" required digits="true"/>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prweight">무게</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prweight" name="r_prweight" placeholder="무게" type="text" value="<c:out value='${ model.product.PR_WEIGHT }' />" />
											</div>
										</div>
										
										<c:forEach var="pro" items="${model.productoptionList}" varStatus="status">
											<c:if test="${ status.first }">
												<c:set var="pro_gname" value="${pro.PRO_GNAME}" />
												<c:set var="pro_name" value="${ pro.PRO_NAME }"/>
											</c:if>
											<c:if test="${ !status.first }">
												<c:set var="pro_name" value="${pro_name},${ pro.PRO_NAME }"/>
											</c:if>
										</c:forEach>
										<div class="form-group form-group-sm">
											<label class="control-label col-sm-2 col-xs-12" for="r_progname">옵션</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="r_progname" placeholder="옵션그룹명 예)색상" type="text" value="${pro_gname}" />
											</div>
											<div class="col-sm-7 col-xs-12">
												<input class="form-control" name="r_proname" placeholder="옵션명 예) 빨강,노랑,파랑,검정" type="text" value="${pro_name}" />
											</div>
										</div>
										
										
										<div class="form-group form-group-sm">
											<label class="control-label col-sm-2 col-xs-12" for="r_prgprname1">관련상품1</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="r_prgprname1" id="r_prgprname1" placeholder="관련상품1" readonly="readonly" type="text" value="${model.productgorupMap1.productList[0].PR_NAME}"/>
												<input type="hidden" name="r_prgprseq1" id="r_prgprseq1" value="${model.productgorupMap1.productList[0].PR_SEQ}"/>
											</div>
											<div class="col-sm-4 col-xs-12">
												<button class="btn btn-sm btn-info" type="button" onclick="prgAdd(this);">상품검색</button>
												<button class="btn btn-sm btn-danger" type="button" onclick="prgDel(this);">삭제</button>
											</div>
										</div>
										
										<div class="form-group form-group-sm">
											<label class="control-label col-sm-2 col-xs-12" for="r_prgprname2">관련상품2</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="r_prgprname2" id="r_prgprname2" placeholder="관련상품2" readonly="readonly" type="text" value="${model.productgorupMap1.productList[1].PR_NAME}"/>
												<input type="hidden" name="r_prgprseq2" id="r_prgprseq2" value="${model.productgorupMap1.productList[1].PR_SEQ}"/>
											</div>
											<div class="col-sm-2 col-xs-12">
												<button class="btn btn-sm btn-info" type="button" onclick="prgAdd(this);">상품검색</button>
												<button class="btn btn-sm btn-danger" type="button" onclick="prgDel(this);">삭제</button>
											</div>
										</div>
										
										<div class="form-group form-group-sm">
											<label class="control-label col-sm-2 col-xs-12" for="r_prgprname3">관련상품3</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="r_prgprname3" id="r_prgprname3" placeholder="관련상품3" readonly="readonly" type="text" value="${model.productgorupMap1.productList[2].PR_NAME}"/>
												<input type="hidden" name="r_prgprseq3" id="r_prgprseq3" value="${model.productgorupMap1.productList[2].PR_SEQ}"/>
											</div>
											<div class="col-sm-2 col-xs-12">
												<button class="btn btn-sm btn-info" type="button" onclick="prgAdd(this);">상품검색</button>
												<button class="btn btn-sm btn-danger" type="button" onclick="prgDel(this);">삭제</button>
											</div>
										</div>
										
										<div class="form-group form-group-sm">
											<label class="control-label col-sm-2 col-xs-12" for="r_prgprname4">추천상품1</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="r_prgprname4" id="r_prgprname4" placeholder="추천상품1" readonly="readonly" type="text" value="${model.productgorupMap2.productList[0].PR_NAME}"/>
												<input type="hidden" name="r_prgprseq4" id="r_prgprseq4" value="${model.productgorupMap2.productList[0].PR_SEQ}"/>
											</div>
											<div class="col-sm-2 col-xs-12">
												<button class="btn btn-sm btn-info" type="button" onclick="prgAdd(this);">상품검색</button>
												<button class="btn btn-sm btn-danger" type="button" onclick="prgDel(this);">삭제</button>
											</div>
										</div>
										
										<div class="form-group form-group-sm">
											<label class="control-label col-sm-2 col-xs-12" for="r_prgprname5">추천상품2</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="r_prgprname5" id="r_prgprname5" placeholder="추천상품2" readonly="readonly" type="text" value="${model.productgorupMap2.productList[1].PR_NAME}"/>
												<input type="hidden" name="r_prgprseq5" id="r_prgprseq5" value="${model.productgorupMap2.productList[1].PR_SEQ}"/>
											</div>
											<div class="col-sm-2 col-xs-12">
												<button class="btn btn-sm btn-info" type="button" onclick="prgAdd(this);">상품검색</button>
												<button class="btn btn-sm btn-danger" type="button" onclick="prgDel(this);">삭제</button>
											</div>
										</div>
										
										<div class="form-group form-group-sm">
											<label class="control-label col-sm-2 col-xs-12" for="r_prgprname6">추천상품3</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" name="r_prgprname6" id="r_prgprname6" placeholder="추천상품3" readonly="readonly" type="text" value="${model.productgorupMap2.productList[2].PR_NAME}"/>
												<input type="hidden" name="r_prgprseq6" id="r_prgprseq6" value="${model.productgorupMap2.productList[2].PR_SEQ}"/>
											</div>
											<div class="col-sm-2 col-xs-12">
												<button class="btn btn-sm btn-info" type="button" onclick="prgAdd(this);">상품검색</button>
												<button class="btn btn-sm btn-danger" type="button" onclick="prgDel(this);">삭제</button>
											</div>
										</div>
										
										
										
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="editor1">내용</label>
											<div class="col-sm-10 col-xs-12">
												<textarea id="editor1" name="editor1" placeholder="내용" >
													${ model.product.PR_CONTENT }
												</textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prdeliterm">배송소요일</label>
											<div class="col-sm-3 col-xs-12">
												<input class="form-control" id="r_prdeliterm" name="r_prdeliterm" placeholder="배송소요일" type="text" value="<c:out value='${ model.product.PR_DELITERM }' />" digits="true" />
											</div>
										</div>
<!-- 										<div class="form-group"> -->
<!-- 											<label class="control-label col-sm-2 col-xs-12" for="r_prdelipolicy">배송정책</label> -->
<!-- 											<div class="col-sm-3 col-xs-12"> -->
<%-- 												<input class="form-control" id="r_prdelipolicy" name="r_prdelipolicy" placeholder="배송정책" type="text" value="<c:out value='${ model.product.PR_DELIPOLICY }' />" /> --%>
<!-- 											</div> -->
<!-- 										</div> -->
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prstatus">상품상태</label>
											<div class="col-sm-3 col-xs-12">
<%-- 												<input class="form-control" id="r_prstatus" name="r_prstatus" placeholder="상품상태" type="text" value="<c:out value='${ model.product.PR_STATUS }' />" required /> --%>
												<label class="radio-inline">
													<input name="r_prstatus" placeholder="상품상태" type="radio" value="Y" <c:if test="${ model.product.PR_STATUS eq 'Y' }">checked="checked"</c:if>/>YES
												</label>
												<label class="radio-inline">
													<input name="r_prstatus" placeholder="상품상태" type="radio" value="N" <c:if test="${ model.product.PR_STATUS eq 'N' }">checked="checked"</c:if>/>NO
												</label>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prlevel">레벨</label>
											<div class="col-sm-3 col-xs-12">
<%-- 												<input class="form-control" id="r_prlevel" name="r_prlevel" placeholder="레벨" type="text" value="<c:out value='${ model.product.PR_LEVEL }' />" /> --%>
												<label class="radio-inline">
													<input name="r_prlevel" placeholder="상품레벨" type="radio" value="Y" <c:if test="${ model.product.PR_LEVEL eq 'Y' }">checked="checked"</c:if>/>Y
												</label>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_prtype">타입</label>
											<div class="col-sm-3 col-xs-12">
<%-- 												<input class="form-control" id="r_prtype" name="r_prtype" placeholder="타입" type="text" value="<c:out value='${ model.product.PR_TYPE }' />" /> --%>
												<label class="radio-inline">
													<input name="r_prtype" placeholder="상품타입" type="radio" value="Y" <c:if test="${ model.product.PR_TYPE eq 'Y' }">checked="checked"</c:if>/>Y
												</label>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-2 col-xs-12" for="r_pruse">승인여부</label>
											<div class="col-sm-10 col-xs-12">
												<label class="radio-inline">
													<input name="r_pruse" type="radio" value="Y" <c:if test="${ model.product.PR_USE eq 'Y' }">checked="checked"</c:if> />YES
												</label>
												<label class="radio-inline">
													<input name="r_pruse" type="radio" value="N" <c:if test="${ model.product.PR_USE eq 'N' }">checked="checked"</c:if> />NO
												</label>
											</div>
										</div>
<!-- 										</fieldset> -->
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-10 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-2">
												<button type="button" class="btn btn-success btn-sm" onclick="dataUp()" ><i class="fa fa-save"></i> 저장</button>
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
									<c:forEach var="ctgr" items="${ model.productcategoryList }">
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
								<button type="button" class="btn btn-info btn-lg btn-block" onclick="modalPager(1)">검색</button>
							</div>
						</div>
						
						<hr/>
						
						<div class="table-responsive">
							<table class="table table-hover" id="table2">
								<thead>
									<tr>
										<th>카테고리</th>
										<th>코드</th>
										<th>상품명</th>
										<th>가격</th>
										<th>이미지</th>
										<th>공급사아이디</th>
										<th>재고</th>
										<th>승인여부</th>
										<th>등록일</th>
										<th>관리</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="text-center" colspan="10"><strong>상품을 검색해주세요.</strong></td>
									</tr>
								</tbody>
							</table>
						</div>
						
						<div class="form-group">
							
							<div class="col-sm-6 col-sm-offset-3 text-center">
								<div id="modal_paging">
									
								</div>
							</div>
							
							
						</div>
					</form>

				</div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	<!-- product search modal -->
	
	
	
</body>
</html>											