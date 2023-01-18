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
				<div class="col-xs-9">
					<ol class="breadcrumb">
						<li><a href="HomeServlet" target="_self">Home</a></li>
						<li><span>/</span></li>
						<li class="active"><span>Customer Information</span></li>
					</ol>
				</div>
				<div class="clearfix"></div>
				<aside class="col-md-3">
					<div class="inner-aside">
						<div class="category">
							<ul>
								<li><a href="myInformation.jsp" title="my information"
									target="_self">My information</a></li>
								<li class="active"><a title="my purchase"
									href="cartServlet?command=MY_ORDER&id=${sessionScope.customerId}"
									target="_self">My purchase </a></li>
							</ul>
						</div>
					</div>
				</aside>
				<div class="col-md-9 order-info">
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
										<a class="product-name" href="productDetail?id=${product.id}">${product.name}</a>
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
				</div>
			</div>
		</div>
	</main>


	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->

</body>
</html>
