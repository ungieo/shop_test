<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/jsp/commonimport.jsp"%>
<!DOCTYPE html>
<html lang="ko">
	<head>

	<%@include file="/include/jsp/commonhead.jsp"%>

	
	<script type="text/javascript">
		$(function(){
			$( '#table1 > thead > tr > th > input[type=checkbox]' ).on( 'click', function(){
				$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', $( this ).prop( 'checked' ) );
				totalMoney();
			});
		});
		
		function dataAjax(option){
			$.ajax(option);			
		}
		function dataDel(obj, r_prbseq){
			if( !confirm('삭제하시겠습니까?' ) ){
				return false;
			}
			var option = {
				async : false,
				data : 'r_prbseq='+r_prbseq,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( true == data.result ){
						location.reload();
					}else{
						alert(data.msg);
					}
				},
				type : 'POST',
				url : '${cpath}/productbasket/productbasketdelajax'
			}
			dataAjax(option)
		}
		
		function dataListDel(){
			var r_prbseq = [];
			var checkObj = []
			
			$( '#table1 > tbody > tr > td > input:checked' ).each(function(i,e){
				r_prbseq[i] = $(this).val();
				checkObj[i] = e;
			});
			
			if( r_prbseq.length > 0 ){
				
				if( !confirm( '삭제 처리를 진행하시겠습니까?' ) ){
					return;
				}
				var option = {
					async : false,
					data : 'r_prbseq='+r_prbseq.join(','),
					dataType : 'json',	
					cache : false,
					error : function( xhr, textStatus, error ){
						alert( error );
					},
					success : function(data){
						if( true == data.result ){
							location.reload();
						}else{
							alert(data.msg);
						}
					},
					type : 'POST',
					url : '${cpath}/productbasket/productbasketlistdelajax'
				}
				dataAjax(option)
				
			}else{
				alert('선택 후 진행해주십시오');
			}
		}
		
		function eaChange(obj){
			var v_prea = $(obj).parent().find('input[name="r_prbea"]').val();
			if( /[^\d]/.test( v_prea ) || 1 > v_prea ){
				alert("수량은 1이상의 숫자만 입력됩니다.");
				$(obj).val(1);
				v_prea = 1;
			}
			var r_prbseq = $(obj).parent().parent().find(':checkbox').val();
			var option = {
				async : false,
				data : 'r_prbseq='+r_prbseq+'&r_prbea='+v_prea,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( false == data.result ){
						alert('처리에 오류가 발생했습니다.');
					}else{
						location.reload();
					}
				},
				type : 'POST',
				url : '${cpath}/productbasket/productbasketupajax'
			}
			dataAjax(option);
			
			
		}
		
		function orderAdd(type){
			
			if( 'A' == type ){
				$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', true );
			}else{
				if( $( '#table1 > tbody > tr > td > input:checked' ).length < 1 ){
					alert('선택 된 상품이 없습니다.');
					return false;
				}
			}
			
			var optionNullCnt = 0;
			$( '#table1 > tbody > tr > td > input:checked' ).each(function(){
				var r_procnt = $(this).parent().parent().find('input[name="r_procnt"]').val();
				var r_prbproseq = $(this).parent().parent().find('input[name="r_prbproseq"]').val();
				if( 0 < r_procnt && 1 > r_prbproseq ){
					optionNullCnt++;
				}
			})
			
			if( 0 < optionNullCnt ){
				alert('옵션을 선택해주십시오');
				return false;
			}
			totalMoney();
			handling.submit('','${cpath}/ordermain/ordermainadd')
		}
		
		function orderCheck(obj){
			$( '#table1 > tbody > tr > td > input[type=checkbox]' ).prop( 'checked', false );
			$(obj).parent().parent().find('input[type="checkbox"]').prop('checked',true);
			orderAdd('C');
		}
		
		function totalMoney(){
			var totalMoney = 0;
			$('#table1 > tbody > tr').each(function(i,e){
				if( $(e).find('input[type=checkbox]').is(":checked") ){
					totalMoney += parseInt( $(e).find('span').text().replace(/,/g,'') );
				}
			});
			$('#totalMoney').text(totalMoney.toLocaleString());
		}
		
		function wishIn(r_prseq){
			
			var option = {
				async : false,
				data : 'r_prseq='+r_prseq,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( false == data.result ){
						alert( data.msg );
					}else{
						alert( data.msg );
					}
				},
				type : 'POST',
				url : '${cpath}/productwish/productwishinajax'
			}
			dataAjax( option );
			
		}
		
		function optionChice(r_prseq,r_prbseq){
			var option = {
					async : false,
					data : 'r_proprseq='+r_prseq,
					dataType : 'json',	
					cache : false,
					error : function( xhr, textStatus, error ){
						alert( error );
					},
					success : function(data){
						if( true == data.result ){
							$('#pro_select option:gt(0)').remove();
							var optionStr = '';
							for( var i = 0; i < data.productoptionList.length; i++ ){
								optionStr += '<option value="'+data.productoptionList[i].pro_seq+'">'+data.productoptionList[i].pro_gname+'/'+data.productoptionList[i].pro_name+'</option>';
							}
							$('#pro_select').append(optionStr);
							$('#pro-modal .modal-footer').html('<button onclick="optionSet('+r_prbseq+');" type="button">확인</button>');
							$('#pro-modal').modal('show');
						}else{
							alert( data.msg );
						}
					},
					type : 'POST',
					url : '${cpath}/productoption/productoptionlistajax'
			}
			dataAjax(option);
			
		}
		
		function optionSet(r_prbseq){
			var r_proseq = $('#pro_select').val();
			if( '' == r_proseq ){
				alert('옵션을 선택해주십시오');
				return false;
			}
			var option = {
				async : false,
				data : 'r_prbseq='+r_prbseq+'&r_prbproseq='+r_proseq,
				dataType : 'json',	
				cache : false,
				error : function( xhr, textStatus, error ){
					alert( error );
				},
				success : function(data){
					if( true == data.result ){
						location.reload();
					}else{
						alert( data.msg );
					}
				},
				type : 'POST',
				url : '${cpath}/productbasket/productbasketupajax'
			}
			dataAjax(option);
			
		}
	</script>
	
	</head>
	<body>
   
	<%@include file="/include/jsp/header.jsp"%>

	<!-- catg header banner section -->
	<section id="aa-catg-head-banner">
		<img src="${cpath}/include/dailyshop/img/fashion/fashion-header-bg-8.jpg" alt="fashion img">
		<div class="aa-catg-head-banner-area">
			<div class="container">
				<div class="aa-catg-head-banner-content">
					<h2>Cart Page</h2>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">Cart</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- / catg header banner section -->

	<!-- Cart view section -->
	<section id="cart-view">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="cart-view-area">
						<div class="cart-view-table">
							<form action="">
								<div class="table-responsive">
									<table class="table">
										<thead>
											<tr>
												<th></th>
												<th></th>
												<th>Product</th>
												<th>Price</th>
												<th>Quantity</th>
												<th>Total</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><a class="remove" href="#"><fa
															class="fa fa-close"></fa></a></td>
												<td><a href="#"><img src="${cpath}/include/dailyshop/img/man/polo-shirt-1.png"
														alt="${cpath}/include/dailyshop/img"></a></td>
												<td><a class="aa-cart-title" href="#">Polo T-Shirt</a></td>
												<td>$250</td>
												<td><input class="aa-cart-quantity" type="number"
													value="1"></td>
												<td>$250</td>
											</tr>
											<tr>
												<td><a class="remove" href="#"><fa
															class="fa fa-close"></fa></a></td>
												<td><a href="#"><img src="${cpath}/include/dailyshop/img/man/polo-shirt-2.png"
														alt="${cpath}/include/dailyshop/img"></a></td>
												<td><a class="aa-cart-title" href="#">Polo T-Shirt</a></td>
												<td>$150</td>
												<td><input class="aa-cart-quantity" type="number"
													value="1"></td>
												<td>$150</td>
											</tr>
											<tr>
												<td><a class="remove" href="#"><fa
															class="fa fa-close"></fa></a></td>
												<td><a href="#"><img src="${cpath}/include/dailyshop/img/man/polo-shirt-3.png"
														alt="${cpath}/include/dailyshop/img"></a></td>
												<td><a class="aa-cart-title" href="#">Polo T-Shirt</a></td>
												<td>$50</td>
												<td><input class="aa-cart-quantity" type="number"
													value="1"></td>
												<td>$50</td>
											</tr>
											<tr>
												<td colspan="6" class="aa-cart-view-bottom">
													<div class="aa-cart-coupon">
														<input class="aa-coupon-code" type="text"
															placeholder="Coupon"> <input
															class="aa-cart-view-btn" type="submit"
															value="Apply Coupon">
													</div> <input class="aa-cart-view-btn" type="submit"
													value="Update Cart">
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</form>
							<!-- Cart Total view -->
							<div class="cart-view-total">
								<h4>Cart Totals</h4>
								<table class="aa-totals-table">
									<tbody>
										<tr>
											<th>Subtotal</th>
											<td>$450</td>
										</tr>
										<tr>
											<th>Total</th>
											<td>$450</td>
										</tr>
									</tbody>
								</table>
								<a href="#" class="aa-cart-view-btn">Proced to Checkout</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- / Cart view section -->






	<%@include file="/include/jsp/footer.jsp"%>

	<!-- To Slider JS -->
	<script src="${cpath}/include/dailyshop/js/sequence.js"></script>
	<script src="${cpath}/include/dailyshop/js/sequence-theme.modern-slide-in.js"></script>

</body>
</html>