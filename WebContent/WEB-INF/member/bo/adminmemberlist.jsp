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
	<link href="${cpath}/include/css/icheck/flat/green.css" rel="stylesheet" />
	
	<link href="${cpath}/include/js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
	<link href="${cpath}/include/js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
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
		
		$('#datatable-responsive').DataTable({
			"searching" : false,				//---false로 하니 search 값이 입력 안 됨.
			"processing": true,
			"serverSide": true,
			"pageLength": 10,
			"lengthMenu": [ [10, 20, 50, 100, -1],[ 10, 20, 50, 100, "All" ] ],
			"ajax": {
				"url" : "${cpath}/member/bo/adminmemberlistjson",
				"dataSrc" : function( data ){
					return data.memberList;
				},
				"data" : function( d ){
					var sc_column = $( '#sc_column' ).val();
					d.sc_column = d.columns[sc_column].data
					d.sc_word = $( '#sc_word' ).val();
					d.sc_mbcpid = $( '#sc_mbcpid' ).val();
					d.sc_mbtype= $( '#sc_mbtype' ).val()
					d.sc_mbindates = $( '#sc_mbindates' ).val();
					d.sc_mbindatee = $( '#sc_mbindatee' ).val();
					d.sc_mbuse = $( 'input[name="sc_mbuse"]:checked' ).val();
				}
			},
			"pagingType": "full_numbers",
			"columnDefs": [
				{
					'targets': 0,
					'searchable':false,
					'orderable':false,
					'className': '',
					'render': function ( innerData, type, rowData, meta ){
	    				return '<input type="checkbox" value="'+rowData.mb_id+'">';
					}
				},
				{ "orderable": false, "targets": 1 },
				{ "orderable": false, "targets": 2 },
			],
			"columns":[
			     {
			    	 data:null
			     },
				{ 
					"data": "mb_id",
					"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
			            $(nTd).html( '<a href="adminmemberview?r_mbid='+oData.mb_id+'">'+oData.mb_id+'</a>');
			        }
// 					,"defaultContent" : 'Edit'		//---null일 경우 디폴트로 뿌려줌
// 					,render: function( data, type, row ){		//--- 화면 크기 변할 때마다 계속 호출 됨.
// 						return '<a href="">'+row.mb_id+'</a>';
// 					}
				},
				{ "data": "mb_name" },
// 				{ "data": "mb_pswd" },
// 				{ "data": "mb_pswdchdate" },
// 				{ "data": "mb_pswdfailcnt" },
// 				{ "data": "mb_cpid" },
// 				{ "data": "mb_dpid" },
// 				{ "data": "mb_zipcode" },
// 				{ "data": "mb_addr1" },
// 				{ "data": "mb_addr2" },
				{ "data": "mb_email" },
				{ "data": "MB_PHONE" },
				{ "data": "mb_tel" },
// 				{ "data": "mb_birth" },
// 				{ "data": "mb_emailuse" },
// 				{ "data": "mb_smsuse" },
// 				{ "data": "mb_level" },
// 				{ "data": "mb_type" },
				{ "data": "mb_use" },
// 				{ "data": "mb_moid" },
// 				{ "data": "mb_inid" },
// 				{ "data": "mb_modate" },
				{ "data": "mb_indate" },
				
			]
		});
		
		$('#datatable-responsive tbody').on('click', 'tr', function () {
	        var data = $( '#datatable-responsive' ).dataTable().api().row( this ).data()
// 	        alert( 'You clicked on '+data.mb_id+'\'s row' );
	    } );
		
		
		$( '#sc_mbindates' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,     
			dateFormat: "yy-mm-dd",  //---출력format
			numberOfMonths : 3,       //---출력되는 달의 범위
			onClose : function ( selectedDate ){          //---종료일 달력설정
				$( '#sc_mbindatee' ).datepicker( 'option', 'minDate', selectedDate ); 
			}
		});

		$( '#sc_mbindatee' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,
			dateFormat: "yy-mm-dd",
			numberOfMonths : 3, 
			onClose : function ( selectedDate ){         //--- 시작일 달력 설정
				$( '#sc_mbindates' ).datepicker( 'option', 'maxDate', selectedDate );
			}
		});
		
		$( '#datatable-responsive > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
			$( '#datatable-responsive > tbody > tr > td > input[type=checkbox] ' ).prop( 'checked', $(this).prop('checked') );
		});
	});
	
	
	function dataSearch(){
		$( '#datatable-responsive' ).dataTable().api().draw();	//table instance 가져옴.
	}


	function dataAjax(options){
		$.ajax(options);
	}

	function dataAdd(  ){
		handling.submit( '', 'adminmemberadd' );
	}

	function dataDel( r_mbid ){
		handling.submit( '', 'adminmemberdel' );
	}

	function dataDown(){
		handling.submit( '', 'adminmemberdel' );
	}

	function dataEdit( r_mbid ){
		handling.submit( '', 'adminmemberedit' );
	}

	function dataIn(){
		handling.submit( '', 'adminmemberin' );
	}

	function dataView( r_mbid ){
		$( '#r_mbid' ).val( r_mbid );
		handling.submit( '', 'adminmemberview' );
	}

	function dataList(){
		handling.submit( '', 'adminmemberlist' );
	}
	
	function dataListDel(  ){
		var r_mbidarr = [];
		var checkarr = $( '#datatable-responsive > tbody > tr > td > input[type=checkbox] ' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_mbidarr[idx] = "'"+$(this).val()+"'";
				idx++;
			}
		});
		if( r_mbidarr.length > 0 ){
			
			if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
				return;
			}
			
			var options = {
				data : 'r_mbidarr='+r_mbidarr.join(','),
				error : function( xhr, textStatus, error ){
					alert(error);
				},
				type : 'POST',
				url : 'memberlistdel'
			}
			dataAjax( options );
			$( '#datatable-responsive' ).dataTable().api().draw();	//table instance 가져옴.
			$( '#datatable-responsive > thead > tr > th > input[type=checkbox]' ).prop('checked', false);
		}else{
			alert('선택 후 진행해주십시오');
		}
	}
	
	function dataListUp( r_column, r_columnvalue ){
		var r_mbidarr = [];
		var checkarr = $( '#datatable-responsive > tbody > tr > td > input[type=checkbox] ' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_mbidarr[idx] = "'"+$(this).val()+"'";
				idx++;
			}
		});
		if( r_mbidarr.length > 0 ){
			if( !confirm( '변경 처리를 진행하시겠습니까?' ) ){
				return;
			}
			
			var param = '';
			param+= 'r_mbidarr='+r_mbidarr.join(',')+'&r_column='+r_column+'&r_columnvalue='+r_columnvalue;
			var options = {
				async : false,
				data : param,
				error : function( xhr, textStatus, error ){
					alert(error);
				},
				type : 'POST',
				url : 'memberlistup'
			}
			dataAjax( options );
			$( '#datatable-responsive' ).dataTable().api().draw();	//table instance 가져옴.
			$( '#datatable-responsive > thead > tr > th > input[type=checkbox]' ).prop('checked', false);
		}else{
			alert('선택 후 진행해주십시오');
		}
		
	}
	

	function dataSort(){
		handling.submit( '', 'adminmemberlist' );
	}

	function dataUp( r_mbid ){
		handling.submit( '', 'adminmemberup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
	}

	function pager( fName, r_url, r_page ){
		$('input[name="r_page"]').val( r_page );
		handling.submit( fName, r_url );
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
							<h3>회원관리 <small>Memeber Manage</small></h3>
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
					
					
					<form action="adminmemberlist" class="form-horizontal" id="frm" name="frm" method="post" >
					
					<div class="row">
						
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>관리자 검색 <small>AdminMember Search</small></h2>
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
											<label class="col-sm-2 col-xs-12 control-label" for="sc_column">검색분류</label>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" name="sc_column" id="sc_column">
													<option value="0">아이디</option>
													<option value="1">이름</option>
													<option value="5">회사코드</option>
													<option value="6">부서코드</option>
													<option value="7">우편번호</option>
													<option value="8">기본주소</option>
													<option value="9">이메일</option>
													<option value="10">휴대폰</option>
													<option value="11">전화번호</option>
												</select>
											</div>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_word" name="sc_word" placeholder="검색어" type="text" value="${ param.sc_word }" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_column">회원사</label>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" name="sc_mbcpid" id="sc_mbcpid">
													<option value="">선택</option>
													<option value="N">일반</option>
													<c:forEach var="scCompany" items="${ model.scCompanyList }">
														<option value="${ scCompany.CP_ID }" >${ scCompany.CP_NAME }</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_mbtype">회원타입</label>
											<div class="col-sm-2 col-xs-12">
												<select class="form-control" name="sc_mbtype" id="sc_mbtype">
													<option value="">선택</option>
													<option value="N">일반</option>
													<option value="P">구매사</option>
													<option value="S">공급사</option>
													<option value="M">운영사</option>
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_prindates">가입일</label>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_mbindates" name="sc_mbindates" placeholder="가입일시작" type="text" />
											</div>
											<div class="col-sm-2 col-xs-12">
												<input class="form-control" id="sc_mbindatee" name="sc_mbindatee" placeholder="가입일끝" type="text" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-2 col-xs-12 control-label" for="sc_mbuse">승인여부</label>
											<div class="col-sm-10 col-xs-12">
												<label class="radio-inline">
													<input name="sc_mbuse" type="radio" value="Y" <c:if test="${ param.sc_pruse eq 'Y' }">checked="checked"</c:if> />YES
												</label>
												<label class="radio-inline">
													<input name="sc_mbuse" type="radio" value="N" <c:if test="${ param.sc_pruse eq 'N' }">checked="checked"</c:if> />NO
												</label>
												<label class="radio-inline">
													<input name="sc_mbuse" type="radio" value="" <c:if test="${ param.sc_pruse eq '' }">checked="checked"</c:if> />선택안함
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
									<h2>관리자 리스트 <small>AdminMember List</small></h2>
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
<!-- 									<table> -->
<!-- 										<tr> -->
<!-- 											<td> -->
<!-- 												<select id="s_type"> -->
<!-- 													<option value="0">아이디</option> -->
<!-- 													<option value="1">이름</option> -->
<!-- 													<option value="5">회사코드</option> -->
<!-- 													<option value="6">부서코드</option> -->
<!-- 													<option value="7">우편번호</option> -->
<!-- 													<option value="8">기본주소</option> -->
<!-- 													<option value="10">이메일</option> -->
<!-- 													<option value="11">휴대폰</option> -->
<!-- 													<option value="12">전화번호</option> -->
<!-- 													<option value="13">생년월일</option>												 -->
<!-- 												</select> -->
<!-- 											</td>	 -->
<!-- 											<td> -->
<!-- 												<input id="s_word" type="text" /> -->
<!-- 											</td>									 -->
<!-- 											<td> -->
<!-- 												<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="dataSearch()">Go!</button></span> -->
<!-- 											</td> -->
<!-- 										</tr> -->
<!-- 									</table> -->
									<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>
													<input type="checkbox" name=""/>
												</th>												
												<th>아이디</th>
												<th>이름</th>
<!-- 												<th>비밀번호</th> -->
<!-- 												<th>비밀번호변경일</th> -->
<!-- 												<th>비밀문자오류횟수</th> -->
<!-- 												<th>회사코드</th> -->
<!-- 												<th>부서코드</th> -->
<!-- 												<th>우편번호</th> -->
<!-- 												<th>기본주소</th> -->
<!-- 												<th>상세주소</th> -->
												<th>이메일</th>
												<th>휴대폰</th>
												<th>전화번호</th>
<!-- 												<th>생년월일</th> -->
<!-- 												<th>이메일수신여부</th> -->
<!-- 												<th>문자수신여부</th> -->
<!-- 												<th>레벨</th> -->
<!-- 												<th>회원타입</th> -->
												<th>승인여부</th>
<!-- 												<th>수정아이디</th> -->
<!-- 												<th>등록아이디</th> -->
<!-- 												<th>수정일</th> -->
												<th>등록일</th>
											</tr>
										</thead>
									</table>
									
									<div class="ln_solid"></div>
									
									<div class="form-group">
										<div class="col-md-6 col-sm-6 col-xs-12">
											<button type="button" class="btn btn-success btn-sm" onclick="dataListUp( 'MB_USE', 'Y' )">선택승인</button>
											<button type="button" class="btn btn-warning btn-sm" onclick="dataListUp( 'MB_USE', 'N' )">선택미승인</button>
											<button type="button" class="btn btn-danger btn-sm" onclick="dataListDel()"><i class="fa fa-trash-o"></i> 선택삭제</button>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<div class="pull-right">
												<button type="button" class="btn btn-success btn-xs" onclick="dataAdd()"><i class="fa fa-plus"></i> 등록</button>
											</div>
										</div>
									</div>
									
<!-- 									<div class="form-group"> -->
<!-- 										<div class="col-xs-12"> -->
<!-- 											<button type="button" class="btn btn-success" onclick="dataAdd()">등록</button> -->
<!-- 								    	</div> -->
<!-- 									</div> -->
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
	<!-- bootstrap progress js -->
	<script src="${cpath}/include/js/progressbar/bootstrap-progressbar.min.js"></script>
	<!-- icheck -->
	<script src="${cpath}/include/js/icheck/icheck.min.js"></script>
	<script src="${cpath}/include/js/custom.js"></script>	
	
	
	<script src="${cpath}/include/js/datatables/jquery.dataTables.min.js"></script>
	<script src="${cpath}/include/js/datatables/dataTables.bootstrap.js"></script>
	<script src="${cpath}/include/js/datatables/dataTables.responsive.min.js"></script>
	<script src="${cpath}/include/js/datatables/responsive.bootstrap.min.js"></script>

	<!-- pace -->
	<script src="${cpath}/include/js/pace/pace.min.js"></script>
	
</body>
</html>