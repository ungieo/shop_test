<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

	function login(){
		
	//		var param = $('#login_frm').serialize();
		var i_mbid = $('#i_modalmbid').val();
		var i_mbpswd = $('#i_modalmbpswd').val();
		var option = {
			async : false,
			data : 'i_mbid='+i_mbid+'&i_mbpswd='+i_mbpswd,
			dataType : 'json',	
			cache : false,
			error : function( xhr, textStatus, error ){
				alert( error );
			},
			success : function(data){
				if( true == data.result ){
					$('#login-modal').modal('hide');
					location.reload();
				}else{
					alert(data.msg);
				}
			},
			type : 'POST',
			url : '${cpath}/member/memberloginajax'
		}
		dataAjax( option );
		
	}
	
</script>


<!-- footer -->
<footer id="aa-footer">
	<!-- footer bottom -->
	<div class="aa-footer-top">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-footer-top-area">
						<div class="row">
							<div class="col-md-3 col-sm-6">
								<div class="aa-footer-widget">
									<h3>Main Menu</h3>
									<ul class="aa-footer-nav">
										<li><a href="#">Home</a></li>
										<li><a href="#">Our Services</a></li>
										<li><a href="#">Our Products</a></li>
										<li><a href="#">About Us</a></li>
										<li><a href="#">Contact Us</a></li>
									</ul>
								</div>
							</div>
							<div class="col-md-3 col-sm-6">
								<div class="aa-footer-widget">
									<div class="aa-footer-widget">
										<h3>Knowledge Base</h3>
										<ul class="aa-footer-nav">
											<li><a href="#">Delivery</a></li>
											<li><a href="#">Returns</a></li>
											<li><a href="#">Services</a></li>
											<li><a href="#">Discount</a></li>
											<li><a href="#">Special Offer</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-md-3 col-sm-6">
								<div class="aa-footer-widget">
									<div class="aa-footer-widget">
										<h3>Useful Links</h3>
										<ul class="aa-footer-nav">
											<li><a href="#">Site Map</a></li>
											<li><a href="#">Search</a></li>
											<li><a href="#">Advanced Search</a></li>
											<li><a href="#">Suppliers</a></li>
											<li><a href="#">FAQ</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-md-3 col-sm-6">
								<div class="aa-footer-widget">
									<div class="aa-footer-widget">
										<h3>Contact Us</h3>
										<address>
											<p><%= Cvt.toStr( props.getProperty("addr1") ) %></p>
											<p>
												<span class="fa fa-phone"></span><%= Cvt.toStr( props.getProperty("tel") ) %>
											</p>
											<p>
												<span class="fa fa-envelope"></span><%= Cvt.toStr( props.getProperty("email") ) %>
											</p>
										</address>
										<div class="aa-footer-social">
											<a href="#"><span class="fa fa-facebook"></span></a> 
											<a href="#"><span class="fa fa-twitter"></span></a> 
											<a href="#"><span class="fa fa-google-plus"></span></a> 
											<a href="#"><span class="fa fa-youtube"></span></a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- footer-bottom -->
	<div class="aa-footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-footer-bottom-area">
						<p>
							Designed by <a href="http://www.markups.io/">MarkUps.io</a>
						</p>
						<div class="aa-footer-payment">
							<span class="fa fa-cc-mastercard"></span> <span class="fa fa-cc-visa"></span> <span class="fa fa-paypal"></span>
							<span class="fa fa-cc-discover"></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
<!-- / footer -->

<!-- Login Modal -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4>Login</h4>
				<form class="aa-login-form" action="">
					<label for="i_modalmbid">Username or Email address<span>*</span></label> 
					<input name="i_modalmbid" id="i_modalmbid" type="text" placeholder="Username or email" />
					<label for="i_modalmbpswd">Password<span>*</span></label>
					<input name="i_modalmbpswd" id="i_modalmbpswd" type="password" placeholder="Password" />
					<button class="aa-browse-btn" type="button" onclick="login();">Login</button>
					<label for="rememberme" class="rememberme">
						<input type="checkbox" id="rememberme"> Remember me 
					</label>
					<p class="aa-lost-password">
						<a href="#">Lost your password?</a>
					</p>
					<div class="aa-register-now">
						Don't have an account?<a href="${cpath}/member/memberadd1">Register now!</a>
					</div>
				</form>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- Login Modal -->
