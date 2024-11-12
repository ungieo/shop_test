<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script type="text/javascript">
		function pager( r_page ){
			$('input[name="r_page"]').val( r_page );
			handling.submit( '', '' );
		}
	</script>
	
	
						<div class="aa-product-catg-pagination">
							<nav>
								<ul class="pagination">
									<c:forEach begin="${ model.startPage }" end="${ model.endPage }" varStatus="status" >
		                   				<!-- * 처음이전처리 -->
										<c:if test="${ status.first }">
											<c:if test="${ model.r_page ne 1 }">
												<li><a href="javascript:pager( 1 )"><i class="fa fa-angle-double-left"></i></a></li>
												<li><a href="javascript:pager( ${ model.r_page - 1 } )" aria-label="Previous" ><i class="fa fa-angle-left"></i></a></li>
											</c:if>
											<c:if test="${ model.r_page eq 1 }">
												<li><a href="#"><i class="fa fa-angle-double-left"></i></a></li>
												<li><a href="#"><i class="fa fa-angle-left"></i></a></li>
											</c:if>
										</c:if>
										<!-- 처음이전처리 -->
										
										<c:if test="${ model.r_page eq status.index }">
											<li ><a href="#">${ status.index }</a></li>
										</c:if>
										<c:if test="${ model.r_page ne status.index }">
											<li><a href="#" onclick="pager( ${ status.index } )">${ status.index }</a></li>
										</c:if>
										
										<!-- * 다음 끝처리 -->
										<c:if test="${ status.last }">
											<c:if test="${ model.totPage ne model.r_page }">
												<li><a href="javascript:pager( ${ model.r_page + 1 } )" ><i class="fa fa-angle-right"></i></a></li>
												<li><a href="javascript:pager( ${ model.totPage } )" ><i class="fa fa-angle-double-right"></i></a></li>
											</c:if>
											<c:if test="${ model.totPage eq model.r_page }">
												<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
												<li><a href="#"><i class="fa fa-angle-double-right"></i></a></li>
											</c:if>
										</c:if>
										<!-- 다음 끝처리 -->
									</c:forEach>
								</ul>
							</nav>
						</div>
