<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="product" items="${searchProducts}">
	<div class="col-xs-6 col-sm-3">
		<div class="product-container">
			<div class="image">
				<img class="img-responsive" src="${product.image }"
					alt="${product.name}" />
			</div>
			<div class="product-meta">
				<h5 class="name">
					<a class="product-name" href="product?id=${product.id}"
						title="${product.name}">${product.name}</a>
				</h5>
				<div class="product-item-price">
					<span class="product-item-regular">${product.price} euro</span> <span
						class="product-item-discount">230 euro</span>
				</div>
			</div>
			<div class="button-product-action clearfix">

				<div class="quickview icon">
					<a class="btn btn-outline-inverse" href="product?id=${product.id}"
						title="quick view"> details <i class="fa fa-eye"></i>
					</a>
				</div>
			</div>
		</div>
	</div>
</c:forEach>