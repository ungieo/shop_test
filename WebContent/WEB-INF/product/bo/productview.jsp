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
		handling.submit( '', 'productadd' );
	}

	function dataDel(){
		handling.submit( '', 'productdel' );
	}

	function dataDown(){
		handling.submit( '', 'productdown' );
	}

	function dataEdit(){
		handling.submit( '', 'productedit' );
	}

	function dataIn(){
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
		handling.submit( '', 'productup' );
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
									<h2>상품 상세 <small>Product Detail</small></h2>
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

									<form action="productview" id="frm" name="frm" method="post" >
								
										<input name="r_prseq" type="hidden" value="${ model.product.PR_SEQ }" />
										<c:if test="${ !empty model.product }">
											고유번호=<c:out value='${ model.product.PR_SEQ }' /><br/>
											상품카테고리=<c:out value='${ model.product.PR_PRCSEQ }' /><br/>
											상품코드=<c:out value='${ model.product.PR_CODE }' /><br/>
											구매사상품코드=<c:out value='${ model.product.PR_CODEB }' /><br/>
											공급사상품코드=<c:out value='${ model.product.PR_CODES }' /><br/>
											상품명=<c:out value='${ model.product.PR_NAME }' /><br/>
											상품가격=<c:out value='${ model.product.PR_PRICE }' /><br/>
											파일개수=<c:out value='${ model.product.PR_FILENUM }' /><br/>
											공급사아이디=<c:out value='${ model.product.PR_CPIDS }' /><br/>
											구매사아이디=<c:out value='${ model.product.PR_CPIDB }' /><br/>
											바코드=<c:out value='${ model.product.PR_BARCODE }' /><br/>
											부가세여부=<c:out value='${ model.product.PR_VATUSE }' /><br/>
											적립금=<c:out value='${ model.product.PR_SAVEMONEY }' /><br/>
											규격=<c:out value='${ model.product.PR_STANDARD }' /><br/>
											브랜드고유값=<c:out value='${ model.product.PR_BRSEQ }' /><br/>
											모델=<c:out value='${ model.product.PR_MODEL }' /><br/>
											단위=<c:out value='${ model.product.PR_UNIT }' /><br/>
											제조사=<c:out value='${ model.product.PR_MANUFACTURE }' /><br/>
											원산지=<c:out value='${ model.product.PR_COUNTRY }' /><br/>
											최소구매수량=<c:out value='${ model.product.PR_MINBUYEA }' /><br/>
											재고=<c:out value='${ model.product.PR_STOCK }' /><br/>
											무게=<c:out value='${ model.product.PR_WEIGHT }' /><br/>
											내용=<c:out value='${ model.product.PR_CONTENT }' /><br/>
											배송소요일=<c:out value='${ model.product.PR_DELITERM }' /><br/>
											배송정책=<c:out value='${ model.product.PR_DELIPOLICY }' /><br/>
											상품상태=<c:out value='${ model.product.PR_STATUS }' /><br/>
											레벨=<c:out value='${ model.product.PR_LEVEL }' /><br/>
											타입=<c:out value='${ model.product.PR_TYPE }' /><br/>
											사용여부=<c:out value='${ model.product.PR_USE }' /><br/>
											수정아이디=<c:out value='${ model.product.PR_MOID }' /><br/>
											등록아이디=<c:out value='${ model.product.PR_INID }' /><br/>
									<!--		수정일=${ fn:substring( model.product.PR_MODATE, 0, 16 ) }--><br/>
									<!--		등록일=${ fn:substring( model.product.PR_INDATE, 0, 16 ) }--><br/>
										</c:if>
									
										<div class="ln_solid"></div>
										
										<div class="form-group">
											<div class="col-xs-12">
												<button type="button" class="btn btn-success btn-sm" onclick="dataAdd()"><i class="fa fa-plus"></i> 등록</button>
												<button type="button" class="btn btn-warning btn-sm" onclick="dataEdit()"><i class="fa fa-edit"></i> 수정</button>
												<button type="button" class="btn btn-danger btn-sm" onclick="dataDel()"><i class="fa fa-trash"></i> 삭제</button>
												<button type="submit" class="btn btn-primary btn-sm" onclick="dataList()"><i class="fa fa-list-ul"></i> 리스트</button>
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