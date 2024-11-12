<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<div class="col-md-3 left_col">
		<div class="left_col scroll-view">

			<div class="navbar nav_title" style="border: 0;">
				<a href="${cpath}/home/bo/index" class="site_title">
					<i class="fa fa-paw"></i><span>Soledot Commerce!</span>
				</a>
			</div>
			<div class="clearfix"></div>

			<!-- menu prile quick info -->
			<div class="profile">
				<div class="profile_pic">
					<img src="${cpath}/data/up/siteinfo/<%= Cvt.toStr( props.getProperty("managerphoto") ) %>" alt="..." class="img-circle profile_img" />
				</div>
				<div class="profile_info">
					<span>Welcome,</span>
					<h2>${ sessionScope.ss_mbname }</h2>
				</div>
			</div>
			<!-- /menu prile quick info -->

			<br />

			<!-- sidebar menu -->
			<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

				<div class="menu_section">
					<h3>General</h3>
					<ul class="nav side-menu">
						<li>
							<a><i class="fa fa-home"></i>기본정보관리<span class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu" style="display: none">
								<li><a href="${cpath}/home/bo/siteinfoedit">사이트 정보</a></li>
<%-- 								<li><a href="${cpath}/home/bo/paymentedit">결제정보 설정</a></li> --%>
<%-- 								<li><a href="${cpath}/home/bo/paymentedit">비밀번호 설정</a></li> --%>
								<li>
									<a><span class="fa fa-chevron-down"></span>보안관리</a>
									<ul class="nav child_menu" style="display: none">
										<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=K2">IP 접속제한설정</a></li>
										<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=K2">로그인보안설정</a></li>
									</ul>								
								</li>
								<li><a href="${cpath}/home/bo/agreementedit">이용약관 관리</a></li>
								<li><a href="${cpath}/home/bo/privacyedit">개인정보취급방침 관리</a></li>
								<li><a href="${cpath}/home/bo/nonmbprivacyedit">비회원 개인정보취급방침 관리</a></li>
								<li><a href="${cpath}/home/bo/mainslideredit">메인 슬라이더 관리</a></li>
								<li><a href="${cpath}/parcelcompany/bo/parcelcompanylist">배송업체 관리</a></li>
							</ul>
						</li>
						
						<li>
							<a><i class="fa fa-shopping-cart"></i>주문관리<span class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu" style="display: none">
								<li><a href="${cpath}/ordermain/bo/ordermainlist">전체주문리스트</a></li>
<%-- 								<li><a href="${cpath}/ordermain/bo/ordermainitemlist">전체주문상품리스트</a></li> --%>
<%-- 								<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=A0">승인대기</a></li> --%>
								<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=B1">입금대기</a></li>
								<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=C1">결제완료</a></li>
								<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=D1">배송준비</a></li>
								<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=E1">배송중</a></li>
								<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=F1">배송완료</a></li>
								<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=G1">구매확정</a></li>
								<li><a>취소 | 교환 | 반품 | 환불<span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu" style="display: none">
										<li class="sub_menu"><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=H1">취소신청</a></li>
										<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=H2">취소완료</a></li>
										<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=I1">반품신청</a></li>
										<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=I2">반품완료</a></li>
										<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=J1">교환신청</a></li>
										<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=J2">교환완료</a></li>
										<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=K1">환불신청</a></li>
										<li><a href="${cpath}/ordermain/bo/ordermainlist?r_omstatus=K2">환불완료</a></li>
<%-- 										<li><a href="${cpath}/ordermainitem/bo/ordermainitemlist">부분취소신청</a></li> --%>										
<%-- 										<li><a href="${cpath}/ordermainitem/bo/ordermainitemlist">부분취소완료</a></li> --%>
<%-- 										<li><a href="${cpath}/ordermainitem/bo/ordermainitemlist">부분반품신청</a></li> --%>
<%-- 										<li><a href="${cpath}/ordermainitem/bo/ordermainitemlist">부분반품완료</a></li> --%>
<%-- 										<li><a href="${cpath}/ordermainitem/bo/ordermainitemlist">부분교환신청</a></li> --%>
<%-- 										<li><a href="${cpath}/ordermainitem/bo/ordermainitemlist">부분교환완료</a></li> --%>
<%-- 										<li><a href="${cpath}/ordermainitem/bo/ordermainitemlist">부분환불신청</a></li> --%>
<%-- 										<li><a href="${cpath}/ordermainitem/bo/ordermainitemlist">부분환불완료</a></li> --%>
									</ul>
								</li>
							</ul>
						</li>
						
						<li>
							<a><i class="fa fa-gift"></i>상품관리<span class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu" style="display: none">
								<li><a href="${cpath}/productcategory/bo/productcategoryview">카테고리 관리</a></li>
								<li><a href="${cpath}/product/bo/productlist">상품 리스트</a></li>
								<li><a href="${cpath}/product/bo/productadd">상품 등록</a></li>
								<li><a href="${cpath}/product/bo/productaddexceladd">상품 대량 등록</a></li>
								<li><a href="${cpath}/productdisplay/bo/productdisplaylist">상품 진열 관리</a></li>
								<li><a href="${cpath}/productstock/bo/productstocklist">상품 재고관리</a></li>
								<li><a href="${cpath}/productbrand/bo/productbrandlist">상품 브랜드 관리</a></li>
								<li><a href="${cpath}/productunit/bo/productunitlist">삼품 단위 관리</a></li>
								<li><a href="${cpath}/productwish/bo/productwishlist">관심 상품 관리</a></li>
							</ul>
						</li>
						
						
						<li>
							<a><i class="fa fa-user"></i>회원관리<span class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu" style="display: none">
<%-- 								<li><a href="${cpath}/member/bo/adminmemberlist">관리자 리스트</a></li> --%>
								<li><a href="${cpath}/member/bo/memberlist">회원 리스트</a></li>
								<li><a href="${cpath}/member/bo/memberadd">회원 등록</a></li>
								<li><a href="${cpath}/member/bo/memberaddexceladd">회원 대량 등록</a></li>
								<li><a href="${cpath}/member/bo/membergradelist">회원 등급 관리</a></li>
<%-- 								<li><a href="${cpath}/member/bo/membergradelist">EMAIL 전송</a></li> --%>
<%-- 								<li><a href="${cpath}/member/bo/membergradelist">SMS 전송</a></li> --%>
							</ul>
						</li>
						
						<li>
							<a><i class="fa fa-pencil-square-o"></i>게시판관리<span class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu" style="display: none">
								<li><a href="${cpath}/board/bo/boardlist">게시판 리스트</a></li>
								<li><a href="${cpath}/board/bo/boardadd">게시판 등록</a></li>
								<li><a href="${cpath}/boardarticle/bo/boardarticlelist">게시글 리스트</a></li>
								<li><a href="${cpath}/boardarticle/bo/boardarticleadd">게시글 등록</a></li>
							</ul>
						</li>
						
						<li>
							<a><i class="fa fa-building"></i>협력사관리<span class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu" style="display: none">
								<li><a href="${cpath}/company/bo/companylist">협력사 리스트</a></li>
								<li><a href="${cpath}/company/bo/companyadd">협력사 등록</a></li>
								<li><a href="${cpath}/companydepartment/bo/companydepartmentlist">협력사 부서 리스트</a></li>
								<li><a href="${cpath}/companydepartment/bo/companydepartmentadd">협력사 부서 등록</a></li>
							</ul>
						</li>
						
<!-- 						<li> -->
<!-- 							<a><i class="fa fa-desktop"></i>공급사관리<span class="fa fa-chevron-down"></span></a> -->
<!-- 							<ul class="nav child_menu" style="display: none"> -->
<%-- 								<li><a href="${cpath}/company/bo/companylist">공급사 리스트</a></li> --%>
<%-- 								<li><a href="${cpath}/company/bo/companyadd">공급사 등록</a></li> --%>
<%-- 								<li><a href="${cpath}/company/bo/companyadd">공급사 부서등록</a></li> --%>
<!-- 							</ul> -->
<!-- 						</li> -->
						
<!-- 						<li> -->
<!-- 							<a><i class="fa fa-desktop"></i>구매사관리<span class="fa fa-chevron-down"></span></a> -->
<!-- 							<ul class="nav child_menu" style="display: none"> -->
<%-- 								<li><a href="${cpath}/company/bo/companylist">구매사 리스트</a></li> --%>
<%-- 								<li><a href="${cpath}/company/bo/companyadd">구매사 등록</a></li> --%>
<%-- 								<li><a href="${cpath}/company/bo/companyadd">구매사 부서등록</a></li> --%>
<!-- 							</ul> -->
<!-- 						</li> -->
						
						<li>
							<a><i class="fa fa-calculator"></i>정산관리<span class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu" style="display: none">
								<li><a href="chartjs.html">매출</a></li>
								<li><a href="chartjs.html">공급사 정산</a></li>
								<li><a href="chartjs2.html">구매사 정산</a></li>
							</ul>
						</li>
						
						<li>
							<a><i class="fa fa-bar-chart-o"></i>Statistics<span class="fa fa-chevron-down"></span></a>
							<ul class="nav child_menu" style="display: none">
								<li><a href="${cpath}/statistics/bo/orderstatistics">주문통계</a></li>
								<li><a href="${cpath}/statistics/bo/memberstatistics">회원통계</a></li>
								<li><a href="${cpath}/statistics/bo/weekjoinmember">회원가입통계</a></li>
								<li><a href="${cpath}/statistics/bo/boardstatistics">게시글통계</a></li>
								<li><a href="${cpath}/statistics/bo/productstatistics">상품통계</a></li>
							</ul>
						</li>
						
						
					</ul>
				</div>

			</div>
			<!-- /sidebar menu -->

			<!-- /menu footer buttons -->
			<div class="sidebar-footer hidden-small">
				<a data-toggle="tooltip" data-placement="top" title="Settings"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></a> 
				<a data-toggle="tooltip" data-placement="top" title="FullScreen"><span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span></a> 
				<a data-toggle="tooltip" data-placement="top" title="Lock"> <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span></a>
				<a data-toggle="tooltip" data-placement="top" title="Logout" href="${cpath}/login/bo/logout"><span class="glyphicon glyphicon-off" aria-hidden="true"></span></a>
			</div>
			<!-- /menu footer buttons -->
		</div>
	</div>

