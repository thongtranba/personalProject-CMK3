<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-6">
		<h4 class="home-title">My Purchase</h4>
	</div>
	<div class="clearfix"></div>
	<div class="col-md-12">
		<c:forEach var="order" items="${orderList}">
			<div class="row">
				<div class="col-md-12">
					<h5 class="date">Date: ${order.createdDate}</h5>
					<span> <a
						href="cart?command=MY_ORDER_DETAILS&orderId=${order.id}">Order
							number: #${order.id}</a>
					</span>
					<hr>
				</div>
			</div>
		</c:forEach>
	</div>
</div>