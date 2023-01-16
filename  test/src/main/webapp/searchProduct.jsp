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
			<div class="row equal">
				<div class="col-xs-12">
					<h4 class="home-title">Search Result : <span class="text-success">"${searchString}"</span> </h4>
				</div>
				<c:forEach var="product" items="${searchProducts}">
					<div class="col-xs-6 col-sm-3">
						<div class="product-container">
							<div class="image">
								<img class="img-responsive" src="${product.image }" alt="${product.name}" />
							</div>
							<div class="product-meta">
								<h5 class="name">
									<a class="product-name"
										href="productDetail?id=<c:out value="${product.id}" />"
										title="${product.name}">${product.name}</a>
								</h5>
								<div class="product-item-price">
									<span class="product-item-regular">${product.price} euro</span>
									<span class="product-item-discount">230 euro</span>
								</div>
							</div>
							<div class="button-product-action clearfix">

								<div class="quickview icon">
									<a class="btn btn-outline-inverse"
										href="productDetail?id=<c:out value="${product.id}" />"
										title="quick view"> details <i class="fa fa-eye"></i>
									</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			
		</div>
	</main>
	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->

</body>
</html>