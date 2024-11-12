<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script type="text/javascript">
		function pager( r_page ){
			$('input[name="r_page"]').val( r_page );
			handling.submit( '', '' );
		}
	</script>
	
	<span class="pageNum">
<!-- 	<span class="center-block" style="width:200px"> 가운데 정렬 -->
	
		<c:forEach begin="${ model.startPage }" end="${ model.endPage }" varStatus="status" >
		
			<!-- * 처음이전처리 -->
			<c:if test="${ status.first }">
				<c:if test="${ model.r_page ne 1 }">
					<button type="button" class="btn btn-info btn-xs" onclick="pager( 1 )">처음</button>
					<button type="button" class="btn btn-default btn-xs" onclick="pager( ${ model.r_page - 1 } )">이전</button></a>
				</c:if>
				<c:if test="${ model.r_page eq 1 }">
					<button type="button" class="btn btn-info btn-xs">처음</button>
					<button type="button" class="btn btn-default btn-xs">이전</button>
				</c:if>
			</c:if>
			<!-- 처음이전처리 -->
			
			<c:if test="${ model.r_page eq status.index }">
<%-- 				<span><strong><mark>${ status.index }</mark></strong></span> --%>
				<button class="btn btn-default btn-xs active" type="button" >${ status.index }</button>
			</c:if>
			<c:if test="${ model.r_page ne status.index }">
<%-- 				<a href="#" onclick="pager( ${ status.index } )"><span>${ status.index }</span></a> --%>
				<button class="btn btn-default btn-xs" type="button" onclick="pager( ${ status.index } )">${ status.index }</button>
			</c:if>
			
			<!-- * 다음 끝처리 -->
			<c:if test="${ status.last }">
				<c:if test="${ model.totPage ne model.r_page }">
					<button type="button" class="btn btn-default btn-xs" onclick="pager( ${ model.r_page + 1 } )">다음</button></a>
					<button type="button" class="btn btn-info btn-xs" onclick="pager( ${ model.totPage } )">끝</button></a>
				</c:if>
				<c:if test="${ model.totPage eq model.r_page }">
					<button type="button" class="btn btn-default btn-xs">다음</button>
					<button type="button" class="btn btn-info btn-xs">끝</button>
				</c:if>
			</c:if>
			<!-- 다음 끝처리 -->
			
		</c:forEach>
		
	</span>
	
