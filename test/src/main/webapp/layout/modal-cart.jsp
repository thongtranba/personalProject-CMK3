<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="modal-cart-detail" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 class="modal-title text-center">Cart</h3>
			</div>
			<div class="modal-body">
				<form action="cart?command=SUBMIT_CART" method="POST">
					<div class="page-content">
						<div class="clearfix hidden-sm hidden-xs">
							<div class="col-xs-1">
								<div class="header">No</div>
							</div>
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
					</div>
					<div class="cart-product  ">
						<hr />
						<input class="totalItem" type="hidden"
							value="${sessionScope.cart.size()}">
						<c:if test="${not empty cart }">
							<c:forEach var="item" items="${cart}" varStatus="status">
								<div class="clearfix text-left">
									<div class="row-cart ">
										<div class="col-sm-6 col-md-1">
											<span class="no">${status.count}.</span>
										</div>
										<div class="col-sm-6 col-md-2">
											<div>
												<img class="img-responsive" src="${item.value.image}"
													alt="${item.value.name }" />
											</div>
										</div>
										<div class="col-sm-6 col-md-2">
											<input class="productId" type="hidden"
												value="${item.value.id}"> <a class="product-name"
												href="category?command=PRODUCT_DETAIL&id=${item.value.id}">${item.value.name }</a>
										</div>
										<div class="col-sm-6 col-md-2">
											<c:if test="${item.value.discountPrice == 0.0}">
												<span class="cart-price">${item.value.price} </span>
												<span>EUR</span>
											</c:if>
											<c:if test="${item.value.discountPrice != 0.0}">
												<span class="cart-price">${item.value.discountPrice}
												</span>
												<span>EUR</span>
											</c:if>
										</div>
										<div class="col-sm-6 col-md-2">

											<input type="number" name="inputQty" id="inputQty"
												class="cartQtyInput" value="0" min="1"
												max="${item.value.inventoryQuantity}">
										</div>
										<div class="col-sm-6 col-md-2">
											<span class="subTotal"></span>
										</div>
										<div class="col-sm-6 col-md-1">
											<a class="remove-product"
												href="cart?command=REMOVE&productId=${item.key}"><span
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
				</form>
			</div>
			<div class="modal-footer">
				<div class="clearfix">
					<div class="col-xs-12 text-right">
						<p>
							<span>Total</span> <span class="price-total"></span>
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