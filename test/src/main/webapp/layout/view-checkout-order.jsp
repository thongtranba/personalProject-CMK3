<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="payment?command=PAY" method="POST">
<aside class="col-md-6 cart-checkout">
	<c:forEach var="item" items="${cart}" varStatus="status">
		<div class="row">
			<div class="col-xs-2">
				<img class="img-responsive" src="${item.value.image}"
					alt="${item.value.name }" />
			</div>
			<div class="col-xs-7">
				<input type="hidden" name="productName" value="${item.value.name }" />
				<a class="product-name" href="product?id=${item.value.id}">${item.value.name }
					euro</a> <br> <span class="qty"></span> x
				<c:if test="${item.value.discountPrice == 0.0}">
					<span class="cart-price">${item.value.price} </span>
					<span>euro</span>
				</c:if>
				<c:if test="${item.value.discountPrice != 0.0}">
					<span class="cart-price">${item.value.discountPrice} </span>
					<span>euro</span>
				</c:if>
			</div>
			<div class="col-xs-3 text-right">
				<input type="hidden" name="subTotal" /> <span class="subTotal"></span>
			</div>
			<input type="hidden" name="JSONString" />
		</div>
		<hr>
	</c:forEach>
	<div class="row">
		<div class="col-xs-6">Goods</div>
		<div class="col-xs-6 text-right">
			<span class="price-total"></span>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">Delivery</div>
		<div class="col-xs-6 text-right">
			<input type="hidden" name="delivery" /> <span class="delivery-fee"></span>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-xs-6">Total</div>
		<div class="col-xs-6 text-right">
			<input type="hidden" name="total" /> <span class="payment-total"></span>
		</div>
	</div>
</aside>
<div class="ship-checkout col-md-6">
	<h4>Customer Information</h4>
	<br>
	<div class="row">
		<div class="form-group col-sm-6">
			<label for="username">Name:</label> <input type="text"
				value="${sessionScope.username}" class="form-control"
				name="username" placeholder="username"
				oninvalid="this.setCustomValidity('type your username')"
				oninput="this.setCustomValidity('')">
		</div>
		<div class="form-group col-sm-6">
			<label for="mobile">Mobile phone:</label> <input type="text"
				value="${sessionScope.mobile}" class="form-control" name="mobile"
				placeholder="mobile phone" pattern="[0][0-9]{9,}"
				oninvalid="this.setCustomValidity('type your mobile phone')"
				oninput="this.setCustomValidity('')">
		</div>
		<div class="form-group col-sm-6">
			<label for="address">Address:</label> <input type="text"
				value="${sessionScope.address}" class="form-control" name="address"
				placeholder="address"
				oninvalid="this.setCustomValidity('type your address')"
				oninput="this.setCustomValidity('')">
		</div>
	</div>
	<h4>Payment</h4>
	<div class="form-group">
		<label> <input type="radio" name="payment_method" checked
			value="0"> Visa cart
		</label>
		<div></div>
	</div>
	<div class="form-group">
		<label> <input type="radio" name="payment_method" value="0">
			Swish
		</label>
		<div></div>
	</div>
	<div>
		<button type="submit" class="btn btn-sm btn-primary pull-right ">Pay</button>
	</div>
</div>
</form>
