<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<footer class="container-fluid">
	<div class="row">
		<div class="col-xs-12">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-3 col-xs-4 list">
						<div class="footerLink">
							<h4>Shop</h4>
							<ul class="list-unstyled">
								<jsp:include page="menu-bar-navigation.jsp" />
							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-3 col-xs-4 list">
						<div class="footerLink">
							<h4>Policy</h4>
							<ul class="list-unstyled">
								<li><a href="returnExchangePolicy.jsp">Return/Exchange</a></li>
								<li><a href="deliveryPolicy.jsp">Delivery</a></li>
								<li><a href="paymentPolicy.jsp">Payment </a></li>
								<li><a href="contact.jsp">Contact </a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-3 col-xs-4 list">
						<div class="footerLink">
							<h4>Customer service</h4>
							<ul class="list-unstyled">
								<li>Phone: +46 007 84 99</li>
								<li><a href="mailto:tranbathong93@gmail.com">Mail:
										service@btshop.se</a></li>
								<li>Mon-Fri: 9-18| Sat-Sun: 10-15</li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-3 col-xs-12 list">
						<div class="newsletter clearfix">
							<h4>Subscrible to the newsletter</h4>
							<p>To get more information about newest products!!</p>
							<form action="" method="POST">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="your email" name="email" />
									<button type="submit" class="btn btn-primary send pull-right">
										Send</button>

								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
<!-- END FOOTER -->
<!-- BACK TO TOP -->
<div class="back-to-top" class="bg-color">
	<i class="fa fa-chevron-up"></i>
</div>
<!-- END BACK TO TOP -->

<!-- REGISTER DIALOG -->
<jsp:include page="register-modal.jsp" />
<!-- END REGISTER DIALOG -->

<!-- LOGIN DIALOG -->
<jsp:include page="login-modal.jsp" />
<!-- END LOGIN DIALOG -->

<!-- USER DIALOG -->
<jsp:include page="user-modal.jsp" />
<!-- END USER DIALOG -->

<!-- FORTGOT PASSWORD DIALOG -->
<jsp:include page="forgot-password-modal.jsp" />
<!-- END FORTGOT PASSWORD DIALOG -->

<!-- CART DIALOG -->
<jsp:include page="cart-modal.jsp" />
<!-- END CART DIALOG -->
