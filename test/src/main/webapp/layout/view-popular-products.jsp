<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="product" items="${popularProduct}">
	<div class="col-xs-6 col-sm-3">
		<div class="product-container">
			<div class="image">
				<img class="img-responsive" src="${product.image }"
					alt="${product.name}" />
			</div>
			<div class="product-meta">
				<h5 class="name">
					<a class="product-name"
						href="category?command=PRODUCT_DETAIL&id=${product.id}"
						title="${product.name}">${product.name}</a>
				</h5>
				<div class="product-item-price">
					<c:if test="${product.discountPrice == 0.0}">
						<span>Price: </span>
						<span class="product-item-price">${product.price} EUR</span>
					</c:if>
					<c:if test="${product.discountPrice != 0.0}">
						<span>Price: </span>
						<span class="product-item-regular">${product.price} EUR</span>
						<span class="product-item-discount">${product.discountPrice}
							EUR</span>
					</c:if>
				</div>
			</div>
			<div class="button-product-action clearfix">
				<div class="quickview icon">
					<a class="btn btn-outline-inverse"
						href="category?command=PRODUCT_DETAIL&id=${product.id}"
						title="quick view"> details <i class="fa fa-eye"></i>
					</a>
				</div>
			</div>
		</div>
	</div>
</c:forEach>