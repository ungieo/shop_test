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
	<link rel="stylesheet" href="${cpath}/include/soledot/css/jstree/themes/default/style.css" />
	
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>	<!-- jquery cdn -->
	
	<script src="${ cpath }/include/soledot/js/jquery-validation/jquery.validate.js"></script> 
	<script src="${ cpath }/include/soledot/js/jquery-validation/additional-methods.js"></script>
	<script src="${ cpath }/include/soledot/js/jquery-validation/localization/messages_ko.js"></script>

	<script src="${ cpath }/include/soledot/js/soledot.js"></script>
	<script type="text/javascript" src="${cpath}/include/soledot/js/jstree/jstree.js"></script>

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

	function dataAjax( options ){
		$.ajax(options);
	}

	function dataAdd(  ){
		handling.submit( '', 'productcategoryadd' );
	}

	function dataDel( r_prcseq ){
		handling.submit( '', 'productcategorydel' );
	}

	function dataDown(){
		handling.submit( '', 'productcategorydown' );
	}

	function dataEdit( r_prcseq ){
		handling.submit( '', 'productcategoryedit' );
	}

	function dataIn(){
		handling.submit( '', 'productcategoryin' );
	}

	function dataView( r_prcseq ){
		$( '#r_prcseq' ).val( r_prcseq );
		handling.submit( '', 'productcategoryview' );
	}

	function dataList(){
		handling.submit( '', 'productcategorylist' );
	}

	function dataSort(){
		handling.submit( '', 'productcategorylist' );
	}

	function dataUp( r_prcseq ){
		handling.submit( '', 'productcategoryup' );
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
	
					<div class="row">
						<div class="col-md-6 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>카테고리 관리 <small>Category Manage</small></h2>
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

									<form action="productcategorylist" id="frm" name="frm" method="post" >
										<div id="categoryview" class="demo"></div>
									</form>

								</div>
							</div>
						</div>
						
						<div class="col-md-6 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>카테고리 관리 <small>Category Manage</small></h2>
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
	

	<script type="text/javascript">
	$('#categoryview').jstree({
		'core' : {
			"animation" : 0,
			"check_callback" : true,
			"themes" : { "stripes" : true },				//---한칸띄어서 줄무늬
			'data' : {
				"url" : "productcategorylisttree",
				"dataType" : "json" // needed only if you do not supply JSON headers
			}
		},
		'contextmenu' : {
			'items' : {
				"create" : {
					"separator_before"	: false,
					"separator_after"	: true,
					"_disabled"			: false, //(this.check("create_node", data.reference, {}, "last")),
					"label"				: "추가",
					"icon"					: "glyphicon glyphicon-plus",
					"action"			: function (data) {
						var inst = $.jstree.reference(data.reference), obj = inst.get_node(data.reference);
						inst.create_node(obj, {}, "last", function (new_node) {
							setTimeout(function () { inst.edit(new_node); },0);
						});
					}
				},
				"rename" : {
					"separator_before"	: false,
					"separator_after"	: false,
					"_disabled"			: false, 
					"label"				: "수정",
					"icon"					: "glyphicon glyphicon-edit",
					"action"			: function (data) {
						var inst = $.jstree.reference(data.reference),
						obj = inst.get_node(data.reference);
						inst.edit(obj);
					}
				},
				"remove" : {
					"separator_before"	: false,
					"icon"				: false,
					"separator_after"	: false,
					"_disabled"			: false, 
					"label"				: "삭제",
					"icon"					: "glyphicon glyphicon-trash",
					"action"			: function (data) {
						if( !confirm('삭제하시면 복구가 불가능합니다.') ){
							return;
						}
						if( !confirm('해당 카테고리 상품이 없는지 확인 해주십시오.') ){
							return;
						}
						if( !confirm('해당 카테고리 하위 카테고리가 모두 삭제 됩니다.')){
							return;
						}
						var inst = $.jstree.reference(data.reference),
							obj = inst.get_node(data.reference);
						if(inst.is_selected(obj)) {
							inst.delete_node(inst.get_selected());
						}
						else {
							inst.delete_node(obj);
						}
					}
				},
			}
		},
		'types' : {
			"#" : {
				"max_depth" : 5
			}
		},
		'plugins' : [
			"contextmenu","types","state"
		]
	}).on('create_node.jstree',function(e,data){		//---생성 될 때 호출됨.
		var prc_seq = 0;
		var r_prcseq = data.node.parent;
		var param = '';
		param += 'r_prcseq='+r_prcseq;
	
		$.ajax({
 			async : false,
 			data : param,
 			error : function( xhr, textStatus, errorThrown ){
 				alert( '처리중 오류가 발생되었습니다.'+xhr.status+' ' +textStatus );
 				data.instance.refresh();
 			},
 			success : function( ajaxData ){
 				data.instance.set_id( data.node, ajaxData.prc_seq );
 			},
 			type : 'POST',
 			url : 'productcategoryin'
		});
	 	
	}).on('rename_node.jstree', function (e, data) {

	 	if( data.old == data.text ){
	 		return;
	 	}
	 	
	 	var r_prcseq = data.node.id;
	 	var r_prcname = data.text;
	 	var param = '';
	 	param += 'r_prcseq='+r_prcseq+'&r_prcname='+r_prcname;
	 	
		var options = {
			async : false,
			data : param,
			error : function( xhr, textStatus, errorThrown ){
				alert( '처리중 오류가 발생되었습니다.' );
				data.instance.refresh();
			},
			type : 'POST',
			url : 'productcategoryup'
		}
		dataAjax(options);
	}).on('delete_node.jstree', function( e, data){
		var r_prcseq = data.node.id;
		var param = '';
		param += 'r_prcseq='+r_prcseq;
		var options = {
			async : false,
			data : param,
			error : function( xhr, textStatus, errorThrown ){
				alert( '처리중 오류가 발생되었습니다.' );
				data.instance.refresh();
			},
			type : 'POST',
			url : 'productcategorydel'
		}
		dataAjax(options);
	})
	</script>
	
	<script src="${cpath}/include/js/bootstrap.min.js"></script>
	<script src="${cpath}/include/js/custom.js"></script>	
	
	
	<!-- pace -->
	<script src="${cpath}/include/js/pace/pace.min.js"></script>
</body>
</html>