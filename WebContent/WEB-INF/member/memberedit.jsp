<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>Welcome nrzb!</title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

    <!-- styles -->
    <link href="${cpath}/include/obaju/css/font-awesome.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/bootstrap.min.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/animate.min.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/owl.carousel.css" rel="stylesheet">
    <link href="${cpath}/include/obaju/css/owl.theme.css" rel="stylesheet">

    <!-- theme stylesheet -->
    <link href="${cpath}/include/obaju/css/style.default.css" rel="stylesheet" id="theme-stylesheet">

    <!-- your stylesheet with modifications -->
    <link href="${cpath}/include/obaju/css/custom.css" rel="stylesheet">

    <script src="${cpath}/include/obaju/js/respond.min.js"></script>

    <link rel="shortcut icon" href="favicon.png">
    
   	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">			<!-- jquery ui css google cdn -->
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" ></script>	<!-- jquery cdn -->
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>	<!-- jquery ui cdn -->
	<script type="text/javascript" src="${cpath }/include/js/datepicker/jquery.ui.datepicker-ko.js"></script>
	
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>		<!-- 우편번호 검색 서비스 -->
	
	<script src="${ cpath }/include/soledot/js/jquery-validation/jquery.validate.js"></script>
	<script src="${ cpath }/include/soledot/js/jquery-validation/localization/messages_ko.js"></script>
	
	<script src="${ cpath }/include/soledot/js/soledot.js"></script>

	<script type="text/javascript">
	
		$(function(){
			var r_result = '${param.r_result}';
			if( r_result ){
				alert('정상적으로 수정되었습니다');
			}
			$( 'input[name="r_mbbirth"]' ).datepicker({
				changeYear: true,
				yearRange : 'c-50:c+10',
				showButtonPanel: true,
			    dateFormat: "yy-mm-dd",
				maxDate : 0
			});
			
			jQuery.validator.addMethod("phone", function(value, element) {
				return this.optional(element) || /^01[\d]{1}-[\d]{3,4}-[\d]{4}$/.test(value);
				}, "유효하지 않은 휴대전화번호 입니다."
			);
			
			jQuery.validator.addMethod("tel", function(value, element) {
				return this.optional(element) || /^0[\d]{1,2}-[\d]{3,4}-[\d]{4}$/.test(value);
				}, "유효하지 않은 전화번호 입니다."
			);
			
			$('#frm').validate({
				rules: {
					r_mbname:{ required: true, minlength: 2 },
					r_mbpswd:{ minlength: 6 },
					r_mbpswd2:{ equalTo: "#r_mbpswd" },
					r_mbzipcode:{ required: true },
					r_mbaddr1:{ required: true },
					r_mbaddr2:{ required: true },
					r_mbemail:{ required: true, email: true },
					r_mbphone:{ required: true, phone: true },
					r_mbtel:{ tel: true }
				},
			});
			
		});
		
		
		function dataUp(){
			handling.submit('','memberup');
		}
		
		
		function getZipcode(){
			daum.postcode.load(function(){
		        new daum.Postcode({
		            oncomplete: function(data) {
		            	document.getElementsByName( "r_mbzipcode" )[0].value = data.zonecode;
			        	document.getElementsByName( "r_mbaddr1" )[0].value = data.roadAddress;
		            }
		        }).open();
		    });
		}
	
	</script>

</head>

<body>

	<%@include file="/include/jsp/header.jsp" %>

    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">

                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li>내 정보수정</li>
                    </ul>

                </div>

                <div class="col-md-3">
                    <!-- *** CUSTOMER MENU ***
 _________________________________________________________ -->
                    <div class="panel panel-default sidebar-menu">

                        <div class="panel-heading">
                            <h3 class="panel-title">마이페이지</h3>
                        </div>

                        <div class="panel-body">

                            <ul class="nav nav-pills nav-stacked">
                                <li>
                                    <a href="${cpath}/ordermain/ordermainlist"><i class="fa fa-list"></i> 주문내역</a>
                                </li>
                                <li>
                                    <a href="${cpath}/productwish/productwishlist"><i class="fa fa-heart"></i> 관심상품</a>
                                </li>
                                <li class="active">
                                    <a href="${cpath}/member/memberedit"><i class="fa fa-user"></i> 내 정보수정</a>
                                </li>
                                <li>
                                    <a href="${cpath}/login/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                                </li>
                            </ul>
                            
                        </div>

                    </div>
                    <!-- /.col-md-3 -->
                    
                    
                                        <!-- 회원전용 게시판 -->
<%--                     <c:if test="${ !empty model.boardList }"> --%>
<!-- 						<div class="panel panel-default sidebar-menu"> -->
<!-- 	                        <div class="panel-heading"> -->
<!-- 	                            <h3 class="panel-title">전체게시판</h3> -->
<!-- 	                        </div> -->
	
<!-- 	                        <div class="panel-body"> -->
<!-- 	                            <ul class="nav nav-pills nav-stacked"> -->
<%-- 	                            	<c:forEach var="bd" items="${ model.boardList }" varStatus="status"> --%>
<%-- 		                            	<li <c:if test="${ param.r_bdabdid eq bd.BD_ID }">class="active"</c:if> > --%>
<%-- 		                                    <a href="${cpath}/boardarticle/boardarticlelist?r_bdabdid=${bd.BD_ID}">${ bd.BD_NAME }</a> --%>
<!-- 		                                </li> -->
<%-- 	                            	</c:forEach> --%>
<!-- 	                            </ul> -->
<!-- 	                        </div> -->
<!-- 	                    </div> -->
<%--                     </c:if> --%>
                    <!-- 회원전용 게시판 -->
                    
                    <!-- *고객센터 -->
                    <div class="panel panel-default sidebar-menu">
                        <div class="panel-heading">
                            <h3 class="panel-title">고객센터</h3>
                        </div>

                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                            	<li>
                                    <a href="${cpath}/boardarticle/boardarticlefaqlist?r_bdabdid=faq">FAQ</a>
                                </li>
                            	<li <c:if test="${ 'notice' eq param.r_bdabdid }">class="active"</c:if>>
                                    <a href="${cpath}/boardarticle/boardarticlelist?r_bdabdid=notice">공지사항</a>
                                </li>
                                <li <c:if test="${ 'question' eq param.r_bdabdid }">class="active"</c:if>>
                                    <a href="${cpath}/boardarticle/boardarticlelist?r_bdabdid=question">Q&A</a>
                                </li>
                                <li <c:if test="${ 'oneone' eq param.r_bdabdid }">class="active"</c:if>>
                                    <a href="${cpath}/boardarticle/boardarticlelist?r_bdabdid=oneone">1:1 문의</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!-- 고객센터 -->

                    <!-- *** CUSTOMER MENU END *** -->
                </div>

                <div class="col-md-9">
                    <div class="box">
                        <h1>My account</h1>
                        
                        <hr/>

                        <form action="memberin" class="form-horizontal" name="frm" id="frm" method="post">
                        	<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbid">아이디</label>
								<div class="col-sm-3 col-xs-12">
									<input type="text" class="form-control" placeholder="아이디" id="r_mbid" name="r_mbid" readonly="readonly" value="${ model.member.MB_ID }" >
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbname">이름</label>
								<div class="col-sm-3 col-xs-12">
									<input type="text" class="form-control" placeholder="이름" id="r_mbname" name="r_mbname" readonly="readonly" value="${ model.member.MB_NAME }">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbpswd">비밀번호</label>
								<div class="col-sm-3 col-xs-12">
									<input type="password" class="form-control" placeholder="비밀번호" id="r_mbpswd" name="r_mbpswd" value="">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbpswd2">비밀번호확인</label>
								<div class="col-sm-3 col-xs-12">
									<input type="password" class="form-control" placeholder="비밀번호확인"  id="r_mbpswd2" name="r_mbpswd2" value="">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbzipcode">우편번호</label>
								<div class="col-sm-3 col-xs-12">
									<input type="text" class="form-control" readonly="readonly" placeholder="우편번호" id="r_mbzipcode" name="r_mbzipcode" value="${ model.member.MB_ZIPCODE }">
								</div>
								<div class="col-sm-3 col-xs-12">
									<button type="button" class="btn btn-round btn-info" onclick="getZipcode();">우편번호 검색</button>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbaddr1">기본주소</label>
								<div class="col-sm-10 col-xs-12">
									<input type="text" class="form-control" readonly="readonly" placeholder="기본주소" id="r_mbaddr1" name="r_mbaddr1" value="${ model.member.MB_ADDR1 }">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbaddr2">상세주소</label>
								<div class="col-sm-10 col-xs-12">
									<input type="text" class="form-control" placeholder="상세주소" id="r_mbaddr2" name="r_mbaddr2" value="${ model.member.MB_ADDR2 }">
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbemail">이메일</label>
								<div class="col-sm-10 col-xs-12">
									<input type="text" class="form-control" placeholder="이메일" id="r_mbemail" name="r_mbemail" value="${ model.member.MB_EMAIL }" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbphone">휴대폰</label>
								<div class="col-sm-10 col-xs-12">
									<input type="text" class="form-control" placeholder="휴대폰" id="r_mbphone" name="r_mbphone" value="${ model.member.MB_PHONE }">
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbtel">전화번호</label>
								<div class="col-sm-10 col-xs-12">
									<input type="text" class="form-control" placeholder="전화번호" id="r_mbtel" name="r_mbtel" value="${ model.member.MB_TEL }">
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbbirth">생년월일</label>
								<div class="col-sm-10 col-xs-12">
									<input type="text" class="form-control" placeholder="생년월일" id="r_mbbirth" name="r_mbbirth" readonly="readonly" value="${ model.member.MB_BIRTH }">
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbemailuse">이메일수신여부</label>
								<div class="col-sm-10 col-xs-12">
									<label class="radio-inline"><input name="r_mbemailuse" type="radio" value="Y" <c:if test="${ model.member.MB_EMAILUSE eq 'Y' }">checked="checked"</c:if> />YES</label>
									<label class="radio-inline"><input name="r_mbemailuse" type="radio" value="N" <c:if test="${ model.member.MB_EMAILUSE eq 'N' }">checked="checked"</c:if> />NO</label>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-2 col-xs-12" for="r_mbsmsuse">문자수신여부</label>
								<div class="col-sm-10 col-xs-12">
									<label class="radio-inline"><input name="r_mbsmsuse" type="radio" value="Y" <c:if test="${ model.member.MB_SMSUSE eq 'Y' }">checked="checked"</c:if> />YES</label>
									<label class="radio-inline"><input name="r_mbsmsuse" type="radio" value="N" <c:if test="${ model.member.MB_SMSUSE eq 'N' }">checked="checked"</c:if> />NO</label>
								</div>
							</div>
							
							<hr/>
							
							<div class="form-group">
								<div class="col-sm-12 text-center">
									<button type="submit" class="btn btn-success" onclick="dataUp()" >저장</button>
								</div>
							</div>
                                
                        </form>
                        
                    </div>
                </div>

			</div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

		<!-- footer content -->
		<%@include file="/include/jsp/footer.jsp" %>
		<!-- /footer content -->

    </div>
    <!-- /#all -->
    

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
    <script src="${cpath}/include/obaju/js/bootstrap.min.js"></script>
    <script src="${cpath}/include/obaju/js/jquery.cookie.js"></script>
    <script src="${cpath}/include/obaju/js/waypoints.min.js"></script>
    <script src="${cpath}/include/obaju/js/modernizr.js"></script>
    <script src="${cpath}/include/obaju/js/bootstrap-hover-dropdown.js"></script>
    <script src="${cpath}/include/obaju/js/owl.carousel.min.js"></script>
    <script src="${cpath}/include/obaju/js/front.js"></script>



</body>

</html>