<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<!-- HEAD-->
<jsp:include page="layout/head.jsp" />

<body>
	<!-- HEADER-->
	<jsp:include page="layout/header.jsp" />
	<!-- END HEADER-->

	<main id="maincontent" class="page-main">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<ol class="breadcrumb">
						<li><a href="HomeServlet" target="_self">Home</a></li>
						<li><span>/</span></li>
						<li class="active"><span>Order Information</span></li>
					</ol>
				</div>
			</div>
			<div class="row">
				<aside class="col-md-6 cart-checkout">
					<c:forEach var="item" items="${cart}" varStatus="status">
						<div class="row">
							<div class="col-xs-2">
								<img class="img-responsive" src="${item.value.image}"
									alt="${item.value.name }" />
							</div>
							<div class="col-xs-7">
								<a class="product-name" href="productDetail?id=${item.value.id}">${item.value.name }
									euro</a> <br> <span>2</span> x <span>${item.value.price }</span>
							</div>
							<div class="col-xs-3 text-right">
								<span>subprice</span>
							</div>
						</div>
						<hr>
					</c:forEach>
					<div class="row">
						<div class="col-xs-6">product price</div>
						<div class="col-xs-6 text-right">1000 euro</div>
					</div>
					<div class="row">
						<div class="col-xs-6">Delivery</div>
						<div class="col-xs-6 text-right">
							<span class="shipping-fee" data="">3.9 euro</span>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-xs-6">Total</div>
						<div class="col-xs-6 text-right">
							<span class="payment-total" data="1230000">500 euro</span>
						</div>
					</div>
				</aside>
				<div class="ship-checkout col-md-6">
					<h4>Customer Information</h4>				
					<br>
					<form action="cartServlet?command=SUBMIT_CART" method="POST">
						<div class="row">
							<div class="form-group col-sm-6">
								<input type="text" value="${sessionScope.username}"
									class="form-control" name="username" placeholder="username"
									required=""
									oninvalid="this.setCustomValidity('type your username')"
									oninput="this.setCustomValidity('')">
							</div>
							<div class="form-group col-sm-6">
								<input type="text" value="${sessionScope.mobile}"
									class="form-control" name="mobile" placeholder="mobile phone"
									required="" pattern="[0][0-9]{9,}"
									oninvalid="this.setCustomValidity('type your mobile phone')"
									oninput="this.setCustomValidity('')">
							</div>
							<div class="form-group col-sm-6">
								<input type="text" value="${sessionScope.address}"
									class="form-control" name="address" placeholder="address"
									required=""
									oninvalid="this.setCustomValidity('type your address')"
									oninput="this.setCustomValidity('')">
							</div>

						</div>
						<h4>Payment</h4>
						<div class="form-group">
							<label> <input type="radio" name="payment_method"
								checked="" value="0"> Visa cart
							</label>
							<div></div>
						</div>
						<div class="form-group">
							<label> <input type="radio" name="payment_method"
								checked="" value="0"> Swish
							</label>
							<div></div>
						</div>

						<div>
							<button type="submit" class="btn btn-sm btn-primary pull-right">Pay</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>


	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->

</body>
</html>
