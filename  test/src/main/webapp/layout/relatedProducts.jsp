<div class="row product-related equal">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="col-md-12">
		<div class="owl-carousel owl-theme">
			<c:forEach var="product" items="${relatedProduct}">
				<div class="item thumbnail">
					<div class="product-container">
						<div class="image">
							<img class="img-responsive" src="${product.image}"
								alt="${product.name}" />
						</div>
						<div class="product-meta">
							<h5 class="name">
								<a class="product-name"
									href="productDetail?id=<c:out value="${product.id}" />"
									title="${product.name}">${product.name}</a>
							</h5>
								<div class="product-item-price">
								<c:if test="${product.discountPrice == 0.0}">
									<span>Price: </span>
									<span class="product-item-price">${product.price} euro</span>

								</c:if>
								<c:if test="${product.discountPrice != 0.0}">
									<span>Price: </span>
									<span class="product-item-regular">${product.price} euro</span>
									<span class="product-item-discount">${product.discountPrice}
										euro</span>
								</c:if>
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
</div>