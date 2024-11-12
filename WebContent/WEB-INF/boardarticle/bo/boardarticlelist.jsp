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
		
		$( 'input[name="sc_bdaindates"]' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,     
			dateFormat: "yy-mm-dd",  //---출력format
			numberOfMonths : 3,       //---출력되는 달의 범위
			onClose : function ( selectedDate ){          //---종료일 달력설정
				$( 'input[name="sc_bdaindatee"]' ).datepicker( 'option', 'minDate', selectedDate ); 
			}
		});

		$( 'input[name="sc_bdaindatee"]' ).datepicker({
			changeMonth: true,
			changeYear: true,
			showButtonPanel: true,
			dateFormat: "yy-mm-dd",
			numberOfMonths : 3, 
			onClose : function ( selectedDate ){         //--- 시작일 달력 설정
				$( 'input[name="sc_bdaindates"]' ).datepicker( 'option', 'maxDate', selectedDate );
			}
		});
		
// 		$( '#table1 > tbody > tr' ).click(function(){
// 			var r_bdaseq = $(this).attr('value');
// 			$( '#r_bdaseq' ).val( r_bdaseq );
// 			handling.submit( '', 'boardarticleview' );
// 		});

		$( '#table1 > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
			$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', $( this ).prop( 'checked' ) );
		});
		
	});

	function dataAjax(){
	var param = '';

		$.ajax({
			async : false,
			data : param,
			error : function(){
				alert( '처리 중 오류가 발생되었습니다.' );
				errorCnt += 1;
				checkYn = 'N';
				return false;
			},
			success : function( data ){
			},
			type : 'POST',
			url : '${cpath}/'
		});
	}

	function dataAdd(  ){
		handling.submit( '', 'boardarticleadd' );
	}

	function dataDel( r_bdaseq ){
		if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
			return;
		}
		$( 'input[name="r_bdaseq"]' ).val( r_bdaseq );
		handling.submit( '', 'boardarticledel' );
	}

	function dataDown(){
		handling.submit( '', 'boardarticledel' );
	}

	function dataEdit( r_bdaseq ){
		$( 'input[name="r_bdaseq"]' ).val( r_bdaseq );
		handling.submit( '', 'boardarticleedit' );
	}

	function dataIn(){
		handling.submit( '', 'boardarticlein' );
	}

	function dataView( r_bdaseq ){
		$( 'input[name="r_bdaseq"]' ).val( r_bdaseq );
		handling.submit( '', 'boardarticleview' );
// 		handling.pageMove( 'boardarticleview', 'r_bdaseq='+r_bdaseq );
	}

	function dataList(){
		handling.submit( '', 'boardarticlelist' );
	}

	
	function dataListDel(  ){
		var r_bdaseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_bdaseqarr[idx] = $(this).val();
				idx++;
			}
		});
		if( r_bdaseqarr.length > 0 ){
			
			if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
				return;
			}
			
			$('input[name="r_bdaseqarr"]').val(r_bdaseqarr.join(','));
	 		handling.submit( '', 'boardarticlelistdel' );
		}else{
			alert('선택 후 진행해주십시오');
		}
	}
	
	function dataListUp( r_column, r_columnvalue ){
		var r_bdaseqarr = [];
		var checkarr = $( '#table1 > tbody > tr > td > input[type=checkbox]' );
		var idx = 0;
		$(checkarr).each(function(){
			if( $(this).is(':checked') ){
				r_bdaseqarr[idx] = "'"+$(this).val()+"'";
				idx++;
			}
		});
		if( r_bdaseqarr.length > 0 ){
			if( !confirm( '변경 처리를 진행하시겠습니까?' ) ){
				return;
			}
			$('input[name="r_bdaseqarr"]').val(r_bdaseqarr.join(','));
			$('input[name="r_column"]').val(r_column);
			$('input[name="r_columnvalue"]').val(r_columnvalue);
	 		handling.submit( '', 'boardarticlelistup' );
		}else{
			alert('선택 후 진행해주십시오');
		}
		
	}
	
	function dataSort(){
		handling.submit( '', 'boardarticlelist' );
	}

	function dataUp( r_bdaseq ){
		handling.submit( '', 'boardarticleup' );
	}

	function formSubmit( fName, r_url ){
		handling.submit( '', r_url );
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
							<h3>게시판 관리 <small>Board Manage</small></h3>
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
					
					<form action="boardarticlelist" class="form-horizontal"  id="frm" name="frm" method="post" >
									
					<input name="r_page" type="hidden" value="${ model.r_page }" />
					<input name="r_pagelimit" type="hidden" value="${ model.r_pagelimit }" />
					<input name="r_rowlimit" type="hidden" value="${ model.r_rowlimit }" />
			
<%-- 			<input name="r_bdabdid" type="hidden" value="${ param.r_bdabdid }" /> --%>
					<input id="r_bdaseq" name="r_bdaseq" type="hidden" value="" />
					<input id="r_bdaseqarr" name="r_bdaseqarr" type="hidden" value="" />
					
					<input name="r_column" type="hidden" value=""/>
					<input name="r_columnvalue" type="hidden" value=""/>
					
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>검색 <small>Search</small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a></li>
                       				</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
								
									<div class="form-group">
										<label class="col-sm-2 col-xs-12 control-label" for="sc_bdabdid">게시판 선택</label>
										<div class="col-sm-2 col-xs-12">
											<select class="form-control" name="sc_bdabdid">
												<option value="" >선택</option>
												<c:forEach var="scBoard" items="${ model.scBoardList }">
													<option value="${ scBoard.BD_ID }" <c:if test="${ param.sc_bdabdid eq scBoard.BD_ID }">selected="selected"</c:if> >${ scBoard.BD_NAME }(${scBoard.BD_ID})</option>
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-2 col-xs-12 control-label" for="sc_column">검색분류</label>
										<div class="col-sm-2 col-xs-12">
											<select class="form-control" name="sc_column">
												<option value="" >선택</option>
												<option value="bda_name" <c:if test="${ param.sc_column eq 'bda_name' }">selected="selected"</c:if> >제목</option>
												<option value="bda_content" <c:if test="${ param.sc_column eq 'bda_content' }">selected="selected"</c:if> >내용</option>
												<option value="bda_mbid" <c:if test="${ param.sc_column eq 'bda_mbid' }">selected="selected"</c:if> >작성자아이디</option>
												<option value="bda_ownername" <c:if test="${ param.sc_column eq 'bda_ownername' }">selected="selected"</c:if> >작성자명</option>
											</select>
										</div>
										<div class="col-sm-2 col-xs-12">
											<input class="form-control" id="sc_word" name="sc_word" placeholder="검색어" type="text" value="${ param.sc_word }" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-2 col-xs-12 control-label" for="sc_bdaindates">상품등록일</label>
										<div class="col-sm-2 col-xs-12">
											<input class="form-control" id="sc_bdaindates" name="sc_bdaindates" placeholder="게시글등록일시작" type="text" value="${param.sc_bdaindates}" />
										</div>
										<div class="col-sm-2 col-xs-12">
											<input class="form-control" id="sc_bdaindatee" name="sc_bdaindatee" placeholder="게시글등록일끝" type="text" value="${param.sc_bdaindatee}" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-2 col-xs-12 control-label" for="sc_bdause">전시여부</label>
										<div class="col-sm-10 col-xs-12">
											<label class="radio-inline">
												<input name="sc_bdause" type="radio" value="Y" <c:if test="${ param.sc_bdause eq 'Y' }">checked="checked"</c:if> />YES
											</label>
											<label class="radio-inline">
												<input name="sc_bdause" type="radio" value="N" <c:if test="${ param.sc_bdause eq 'N' }">checked="checked"</c:if> />NO
											</label>
											<label class="radio-inline">
												<input name="sc_bdause" type="radio" value="" <c:if test="${ param.sc_bdause eq '' }">checked="checked"</c:if> />선택안함
											</label>
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-xs-12">
											<button type="button" class="btn btn-info btn-lg btn-block" onclick="dataList()">검색</button>
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
									<h2>게시글 리스트 <small>BoardArticle List</small></h2>
<!-- 									<ul class="nav navbar-right panel_toolbox"> -->
<!-- 										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li> -->
<!-- 										<li class="dropdown"> -->
<!-- 											<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a> -->
<!-- 											<ul class="dropdown-menu" role="menu"> -->
<!-- 												<li><a href="#">Settings 1</a></li> -->
<!--                              						<li><a href="#">Settings 2</a></li> -->
<!--                            					</ul> -->
<!--                          					</li> -->
<!-- 										<li><a class="close-link"><i class="fa fa-close"></i></a></li> -->
<!--                        				</ul> -->
									<div class="clearfix"></div>
								</div>
								<div class="x_content">

									<div class="table-responsive">
									<table id="table1" class="table table-hover">
<!-- 										<caption>boardarticleList</caption> -->
										<thead>
											<tr>
												<th>
													<input type="checkbox" />
												</th>
<!-- 												<th>고유번호</th> -->
												<th>게시판아이디</th>
<!-- 												<th>게시글분류</th> -->
												<th>제목</th>
<!-- 												<th>내용</th> -->
<!-- 												<th>파일개수</th> -->
<!-- 												<th>그룹번호</th> -->
<!-- 												<th>레벨번호</th> -->
<!-- 												<th>스텝번호</th> -->
												<th>작성자아이디</th>
												<th>작성자명</th>
<!-- 												<th>비밀문자</th> -->
												<th>조회수</th>
												<th>추천수</th>
<!-- 												<th>작성자IP</th> -->
<!-- 												<th>상태값</th> -->
												<th>비밀글여부</th>
<!-- 												<th>레벨</th> -->
<!-- 												<th>타입</th> -->
												<th>사용여부</th>
<!-- 												<th>수정아이디</th> -->
												<th>등록아이디</th>
<!-- 												<th>수정일</th> -->
												<th>등록일</th>
												<th>관리</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${ model.boardarticleList}" var="boardarticle" varStatus="status" >
											<tr >
												<td>
													<input type="checkbox" value="${ boardarticle.BDA_SEQ }"/>
												</td>
<%-- 												<td><c:out value='${ boardarticle.BDA_SEQ }' /></td> --%>
												<td><c:out value='${ boardarticle.BDA_BDID }' /></td>
<%-- 												<td><c:out value='${ boardarticle.BDA_BDCSEQ }' /></td> --%>
												<td>
													<c:if test="${ boardarticle.BDA_LEVELNUM > 1 }">
														<c:forEach begin="2" end="${ boardarticle.BDA_LEVELNUM }"><i class="fa fa-long-arrow-right"></i></c:forEach>
													</c:if>
													<a href="javascript:dataView('${ boardarticle.BDA_SEQ }');"><c:out value="${ boardarticle.BDA_NAME }" /></a>
												</td>
<%-- 												<td>${ boardarticle.BDA_CONTENT }</td> --%>
<%-- 												<td><c:out value='${ boardarticle.BDA_FILENUM }' /></td> --%>
<%-- 												<td><c:out value='${ boardarticle.BDA_GROUPNUM }' /></td> --%>
<%-- 												<td><c:out value='${ boardarticle.BDA_LEVELNUM }' /></td> --%>
<%-- 												<td><c:out value='${ boardarticle.BDA_STEPNUM }' /></td> --%>
												<td><c:out value='${ boardarticle.BDA_MBID }' /></td>
												<td><c:out value='${ boardarticle.BDA_OWNERNAME }' /></td>
<%-- 												<td><c:out value='${ boardarticle.BDA_PSWD }' /></td> --%>
												<td><c:out value='${ boardarticle.BDA_READCNT }' /></td>
												<td><c:out value='${ boardarticle.BDA_RECOMMENDCNT }' /></td>
<%-- 												<td><c:out value='${ boardarticle.BDA_IP }' /></td> --%>
<%-- 												<td><c:out value='${ boardarticle.BDA_STATUS }' /></td> --%>
												<td><c:out value='${ boardarticle.BDA_SECRETUSE }' /></td>
<%-- 												<td><c:out value='${ boardarticle.BDA_LEVEL }' /></td> --%>
<%-- 												<td><c:out value='${ boardarticle.BDA_TYPE }' /></td> --%>
												<td><c:out value='${ boardarticle.BDA_USE }' /></td>
<%-- 												<td><c:out value='${ boardarticle.BDA_MOID }' /></td> --%>
												<td><c:out value='${ boardarticle.BDA_INID }' /></td>
<%-- 												<td>${ fn:substring( boardarticle.BDA_MODATE, 0, 16 ) }</td> --%>
												<td>${ fn:substring( boardarticle.BDA_INDATE, 0, 16 ) }</td>
												<td>
													<button type="button" class="btn btn-info btn-xs" onclick="dataView('${ boardarticle.BDA_SEQ }')"><i class="fa fa-folder"></i></button>
													<button type="button" class="btn btn-warning btn-xs" onclick="dataEdit('${ boardarticle.BDA_SEQ }')"><i class="fa fa-edit"></i></button>
													<button type="button" class="btn btn-danger btn-xs" onclick="dataDel('${ boardarticle.BDA_SEQ }')"><i class="fa fa-trash"></i></button>
												</td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
									</div>
							
									<div class="form-group">
										<div class="col-md-6 col-sm-6 col-xs-12">
											<button type="button" class="btn btn-success btn-xs" onclick="dataListUp( 'BDA_USE', 'Y' )">선택승인</button>
											<button type="button" class="btn btn-warning btn-xs" onclick="dataListUp( 'BDA_USE', 'N' )">선택미승인</button>
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
												<button type="button" class="btn btn-success btn-sm" onclick="dataAdd()"><i class="fa fa-pencil"></i> 등록</button>
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