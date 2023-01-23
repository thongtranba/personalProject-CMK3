<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-6">
		<h4 class="home-title">Order number: #${orderId}</h4>
	</div>

	<aside class="col-md-12 cart-checkout">
		<c:forEach var="product" items="${productList}">
			<div class="row">
				<div class="col-md-4 col-xs-2">
					<img class="img-responsive" src="${product.image}"
						alt="${product.name}" />
				</div>
				<div class="col-md-6 col-xs-7">
					<a class="product-name" href="product?id=${product.id}">${product.name}</a>
					<br> <span>2</span> x <span>${product.price} euro</span>
				</div>
				<div class="col-md-2 col-xs-3 text-right">
					<span>subprice</span>
				</div>
			</div>
			<hr>
		</c:forEach>
		<div class="row">
			<div class="col-xs-6">good</div>
			<div class="col-xs-6 text-right">500 euro</div>
		</div>
		<div class="row">
			<div class="col-xs-6">delivery</div>
			<div class="col-xs-6 text-right">3.9 euro</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-xs-6">Total</div>
			<div class="col-xs-6 text-right">600 euro</div>
		</div>
	</aside>

</div>