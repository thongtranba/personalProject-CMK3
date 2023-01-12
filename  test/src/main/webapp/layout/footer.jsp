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
								<li><a href="category?command=rackets&categoryId=1">
										Rackets </a></li>
								<li><a href="category?command=bags&categoryId=2">Bags</a></li>
								<li><a href="category?command=clothing&categoryId=3">Clothing</a></li>
								<li><a href="category?command=shoes&categoryId=4">Shoes</a></li>
								<li><a href="category?command=strings&categoryId=5">Strings</a></li>
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
<div class="modal fade" id="modal-register" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 class="modal-title text-center">Register</h3>
			</div>
			<form action="register" method="POST" role="form">
				<div class="modal-body">
					<div class="form-group">
						<input type="text" class="form-control" id="username"
							name="username" placeholder="Username" required
							oninvalid="this.setCustomValidity('type your name')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<input type="tel" class="form-control" id="mobile" name="mobile"
							placeholder="Mobile phone" required pattern="[0][0-9]{9,}"
							oninvalid="this.setCustomValidity('type your mobile phone')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<input type="email" class="form-control" id="email" name="email"
							placeholder="Email" required
							oninvalid="this.setCustomValidity('type your email')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="password"
							placeholder="Password" required
							pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$"
							oninvalid="this.setCustomValidity('at least 8 letters: number, up case, low case')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="re-password" placeholder="Re-password" required
							autocomplete="off" autosave="off"
							pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$"
							oninvalid="this.setCustomValidity('at least 8 letters: number, up case, low case')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<input type="address" class="form-control" id="address"
							name="address" placeholder="Address" required />
					</div>

					<div class="text-left">
						<a href="javascript:void(0)" data-dismiss="modal"
							class="btn-login">You are already a member? Sign in!</a>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Cancle</button>
					<button type="submit" class="btn btn-primary">Register</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- END REGISTER DIALOG -->
<!-- LOGIN DIALOG -->
<div class="modal fade" id="modal-login" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 class="modal-title text-center">Login</h3>
				<!-- Google login -->
				<br />
			</div>
			<form action="login" method="GET" role="form">
				<div class="modal-body">
					<div class="form-group">
						<input type="email" name="email" id="email" class="form-control"
							placeholder="Email" required />
					</div>
					<div class="form-group">
						<input type="password" name="password" id="password"
							class="form-control" placeholder="Password" required />
					</div>
					<input type="hidden" name="reference" value="" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Cancle</button>
					<button type="submit" class="btn btn-primary">Login</button>
					<br />
					<div class="text-left">
						<a href="javascript:void(0)" class="btn-register">Are you a
							member? Register now!</a> <a href="javascript:void(0)"
							class="btn-forgot-password">Forgot password?</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- END LOGIN DIALOG -->
<!-- LOGOUT DIALOG -->
<div class="modal fade" id="modal-logout" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 class="modal-title text-center">Hi,${sessionScope.username}</h3>
				<br />
			</div>

			<div class="modal-body">
				<div class="form-group">
					<a href="myInformation.jsp">My information</a>
				</div>
				<div class="form-group">
					<a href="myPurchase?command=MY_ORDER&id=${sessionScope.customerId}">My
						purchase</a>

				</div>
				<div class="form-group">
					<a href="contact.jsp">Contact us</a>

				</div>

			</div>
			<div class="modal-footer">

				<a href="logoutServlet">Logout</a>

			</div>

		</div>
	</div>
</div>
<!-- END LOGOUT DIALOG -->
<!-- FORTGOT PASSWORD DIALOG -->
<div class="modal fade" id="modal-forgot-password" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 class="modal-title text-center">Forgot password</h3>
			</div>
			<form action="#" method="POST" role="form">
				<div class="modal-body">
					<div class="form-group">
						<input name="email" type="email" class="form-control"
							placeholder="Email" required />
					</div>
				</div>
				<div class="modal-footer">
					<input type="hidden" name="reference" value="" />
					<button type="submit" class="btn btn-primary">Send</button>
					<br />
				</div>
			</form>
		</div>
	</div>
</div>
<!-- END FORTGOT PASSWORD DIALOG -->
<!-- CART DIALOG -->
<div class="modal fade" id="modal-cart-detail" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 class="modal-title text-center">Cart</h3>
			</div>
			<div class="modal-body">
				<div class="page-content">
					<div class="clearfix hidden-sm hidden-xs">
						<div class="col-xs-1"></div>
						<div class="col-xs-2">
							<div class="header">Image</div>
						</div>
						<div class="col-xs-2">
							<div class="header">Product</div>
						</div>
						<div class="col-xs-2">
							<div class="header">Price</div>
						</div>
						<div class="label_item col-xs-2">
							<div class="header">Quantity</div>
						</div>
						<div class="col-xs-2">
							<div class="header">Total price</div>
						</div>
						<div class="lcol-xs-1"></div>
					</div>
					<div class="cart-product">
						<hr />
						<c:if test="${not empty cart }">
							<c:forEach var="item" items="${cart}" varStatus="status">
								<div class="clearfix text-left">
									<div class="row">
										<div class="col-sm-6 col-md-1">
											<div>${ status.count}.</div>
										</div>
										<div class="col-sm-6 col-md-2">
											<div>
												<img class="img-responsive" src="${item.value.image}"
													alt="${item.value.name }" />
											</div>
										</div>
										<div class="col-sm-6 col-md-2">
											<a class="product-name"
												href="productDetail?id=${item.value.id}">${item.value.name }</a>
										</div>
										<div class="col-sm-6 col-md-2">
											<span class="product-item-discount">${item.value.price }</span>
										</div>
										<div class="col-sm-6 col-md-2">
											<input type="hidden" value="1" /><input type="number"
												onchange="updateProductInCart(this,2)" min="1" value="1" />
										</div>
										<div class="col-sm-6 col-md-2">
											<span>230 euro</span>
										</div>
										<div class="col-sm-6 col-md-1">

											<a class="remove-product"
												href="addToCartServlet?command=REMOVE&productId=${item.key }"><span
												class="glyphicon glyphicon-trash"></span></a>
										</div>
									</div>
								</div>
								<hr />
							</c:forEach>
						</c:if>
						<c:if test="${ empty cart }">
							<h4 style="text-align: center; color: gray">Empty</h4>
						</c:if>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<div class="clearfix">
					<div class="col-xs-12 text-right">
						<p>
							<span>Total</span> <span class="price-total">420 euro</span>
						</p>
						<input type="button" data-dismiss="modal" class="btn btn-default"
							value="Continue shopping" />

						<c:if test="${sessionScope.username != null && !empty cart }">
							<input type="button" name="checkout" class="btn btn-primary"
								value="Check out" />
						</c:if>
						<c:if test="${sessionScope.username == null && !empty cart }">
							<input type="button" data-dismiss="modal"
								class="btn btn-primary btn-login" value="Check out" />
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END CART DIALOG -->
