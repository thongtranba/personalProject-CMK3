<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="row">
	<div class="col-xs-6">
		<h4 class="home-title">Order number: #${orderId}</h4>
	</div>
	<aside class="col-md-12 cart-checkout">
		<c:set var="total" value="0" />
		<c:forEach var="product" items="${productList}">
			<div class="row">
				<div class="col-md-4 col-xs-2">
					<img class="img-responsive" src="${product.image}"
						alt="${product.name}" />
				</div>
				<div class="col-md-6 col-xs-7">
					<a class="product-name" href="product?id=${product.id}">${product.name}</a>
					<br>
					<c:set var="inputQuantity" value="${product.inputQuantity}" />
					<span>${product.inputQuantity}</span> x
					<c:if test="${product.discountPrice == 0.0}">
						<c:set var="price" value="${product.price}" />
						<span class="cart-price">${product.price} </span>
						<span>euro</span>
					</c:if>
					<c:if test="${product.discountPrice != 0.0}">
						<c:set var="price" value="${product.discountPrice}" />
						<span class="cart-price">${product.discountPrice} </span>
						<span>euro</span>
					</c:if>
				</div>
				<div class="col-md-2 col-xs-3 text-right">
					<c:set var="subtotal" value="${inputQuantity * price}" />
					<span> <fmt:formatNumber type="number"    groupingUsed = "false"
							value="${subtotal}" /> euro
					</span>
				</div>
			</div>
			<hr>
			<c:set var="total" value="${subtotal + total}" />
		</c:forEach>
		<div class="row">
			<div class="col-xs-6">Goods</div>
			<div class="col-xs-6 text-right">
				<fmt:formatNumber type="number"   groupingUsed = "false"
					value="${total}" />
				euro
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6">Delivery</div>
			<div class="col-xs-6 text-right">39,0 euro</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-xs-6">Total</div>
			<div class="col-xs-6 text-right">
				<c:set var="paymentTotal" value="${total + 39}" />
				<fmt:formatNumber type="number"  groupingUsed = "false"
					value="${paymentTotal}" />
				euro
			</div>
		</div>
	</aside>

</div>