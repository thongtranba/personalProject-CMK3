<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-8">
	<img data-zoom-image=""
		class="img-responsive thumbnail main-image-thumbnail"
		src="${product.image}" alt="" />
	<div class="product-detail-carousel-slider">
		<div class="owl-carousel owl-theme">
			<div class="item thumbnail">
				<img src="${product.image}" alt="" />
			</div>
			<div class="item thumbnail">
				<img src="${product.image}" alt="" />
			</div>
			<div class="item thumbnail">
				<img src="${product.image}" alt="" />
			</div>
		</div>
	</div>
</div>
<div class="col-md-4">
	<h5 class="product-name">
		<c:out value="${product.name}" />
	</h5>
	<div class="brand">
		<span>Brand: </span>
		<c:out value="${product.brandName}" />
		<span></span>
	</div>
	<div class="product-status">
		<span>Stock: </span> <span class="label-warning"><c:out
				value="${product.inventoryQuantity}" /></span>
	</div>
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
	<div>
		<input type="button"
			style="background-color: #f0ad4e; border-style: none; border-radius: 5px; color: #ffffff;"
			value="Add to cart"
			onclick="window.location.href='cart?command=ADD_TO_CART&productId=${product.id}'">
		<i class="fa fa-shopping-cart"></i> <br>
		<h5
			style="background-color: #eea97e; color: #010111; border-radius: 5px; text-align: center">${notification}</h5>
	</div>


</div>
<div class="row product-description">
	<div class="col-xs-12">
		<div role="tabpanel">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a
					href="#product-description" aria-controls="home" role="tab"
					data-toggle="tab">Description</a></li>
				<li role="presentation"><a href="#product-technology"
					aria-controls="home" role="tab" data-toggle="tab">Technology</a></li>
				<li role="presentation"><a href="#product-comment"
					aria-controls="tab" role="tab" data-toggle="tab">Comment</a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active"
					id="product-description">
					<p>Specification</p>
					<c:out value="${product.description}" />
				</div>
				<div role="tabpanel" class="tab-pane" id="product-technology">
					<img src="https://www.yonex.com/media/yonex/technology/B_Namd.jpg" />
					<p>Namd</p>
					<p>A world-first, new dimension graphite material, Namd,
						greatly improves the adhesion of the graphite fibers and resin by
						attaching nanomaterial directly to the graphite fiber.In high
						performance racquets, it is common to combine nanomaterials with
						resin that connects graphite fibers, but in Namd, nanomaterials
						are directly adhered to the graphite fibers and resin is greatly
						increased. This major improvement produces a shaft that flexes and
						stores energy, delivering explosive force on impact with the
						shuttle.</p>
				</div>
				<div role="tabpanel" class="tab-pane" id="product-comment">
					<form class="form-comment" action="" method="POST" role="form">
						<label>Rating</label>
						<div class="form-group">
							<input type="hidden" name="product_id" value="3" /> <input
								class="rating-input" name="rating" type="text" title=""
								value="4" /> <input type="text" class="form-control" id=""
								name="fullname" placeholder="Name *" required /> <input
								type="email" name="email" class="form-control" id=""
								placeholder="Email *" required />
							<textarea name="description" id="input" class="form-control"
								rows="3" required placeholder="Your comment *"></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Send</button>
					</form>
					<div class="comment-list">
						<hr />
						<span class="date pull-right">2022-11-25 16:11:07</span> <input
							class="answered-rating-input" name="rating" type="text" title=""
							value="4" readonly /> <span class="by">Ba Thong</span>
						<p>Good</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>