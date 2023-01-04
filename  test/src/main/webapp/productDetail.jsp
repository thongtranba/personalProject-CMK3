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
						<li><a href="homeServlet" target="_self">Home</a></li>
						<li><span>/</span></li>
						<li><a href="rackets.jsp" target="_self">Rackets</a></li>
						<li><span>/</span></li>
						<li class="active"><span><c:out
									value="${product.name}" /></span></li>
					</ol>
				</div>
				<div class="col-xs-3 hidden-lg hidden-md">
					<a class="hidden-lg pull-right btn-aside-mobile"
						href="javascript:void(0)">Sort <i
						class="fa fa-angle-double-right"></i></a>
				</div>
				<div class="clearfix"></div>
				<!-- <aside class="col-md-3">
                        <div class="inner-aside">
                            
                        </div>
                    </aside> -->
				<div class="col-md-10 product-detail">
					<div class="row product-info">
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
								<span>Status: </span> <span class="label-warning"><c:out
										value="${product.inventory_quantity}" /></span>
							</div>
							<div class="product-item-price">
								<span>Price: </span> <span class="product-item-regular"></span>
								<c:out value="${product.price}" />
								<span class="product-item-discount">240 eur</span>
							</div>

							<div>
								<input type="button" value="Add to cart"
									onclick="window.location.href='addToCartServlet?command=ADD_TO_CART&productId=<c:out value="${product.id}" />'" />
								<i class="fa fa-shopping-cart"></i>

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
											aria-controls="home" role="tab" data-toggle="tab">Technology</a>
										</li>
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
											<img
												src="https://www.yonex.com/media/yonex/technology/B_Namd.jpg" />
											<p>Namd</p>
											<p>A world-first, new dimension graphite material, Namd,
												greatly improves the adhesion of the graphite fibers and
												resin by attaching nanomaterial directly to the graphite
												fiber.In high performance racquets, it is common to combine
												nanomaterials with resin that connects graphite fibers, but
												in Namd, nanomaterials are directly adhered to the graphite
												fibers and resin is greatly increased. This major
												improvement produces a shaft that flexes and stores energy,
												delivering explosive force on impact with the shuttle.</p>
										</div>
										<div role="tabpanel" class="tab-pane" id="product-comment">
											<form class="form-comment" action="" method="POST"
												role="form">
												<label>Rating</label>
												<div class="form-group">
													<input type="hidden" name="product_id" value="3" /> <input
														class="rating-input" name="rating" type="text" title=""
														value="4" /> <input type="text" class="form-control"
														id="" name="fullname" placeholder="Name *" required /> <input
														type="email" name="email" class="form-control" id=""
														placeholder="Email *" required />
													<textarea name="description" id="input"
														class="form-control" rows="3" required
														placeholder="Your comment *"></textarea>
												</div>
												<button type="submit" class="btn btn-primary">Send</button>
											</form>
											<div class="comment-list">
												<hr />
												<span class="date pull-right">2022-11-25 16:11:07</span> <input
													class="answered-rating-input" name="rating" type="text"
													title="" value="4" readonly /> <span class="by">Ba
													Thong</span>
												<p>Good</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- } -->
						<div class="row product-related equal">
							<div class="col-md-12">
								<div class="owl-carousel owl-theme">
								
										<div class="item thumbnail">
											<div class="product-container">
												<div class="image">
													<img class="img-responsive"
														src="https://badmintonshoppen.se/wp-content/uploads/2022/09/Victor-BR9610-Ceramic-Blue-896x896-jpg.webp"
														alt="" />
												</div>
												<div class="product-meta">
													<h5 class="name">
														<a class="product-name" href="#"
															title="Lining racket backpack">Lining racket backpack</a>
													</h5>
													<div class="product-item-price">
														<span class="product-item-regular">120 euro</span> <span
															class="product-item-discount">108 euro</span>
													</div>
												</div>
												<div class="button-product-action clearfix">
													<div class="cart icon">
														<a class="btn btn-outline-inverse buy" product-id="5"
															href="javascript:void(0)" title="add to cart"> cart <i
															class="fa fa-shopping-cart"></i>
														</a>
													</div>
													<div class="quickview icon">
														<a class="btn btn-outline-inverse" href="#"
															title="quick view"> details <i class="fa fa-eye"></i>
														</a>
													</div>
												</div>
											</div>
										</div>
									

									<div class="item thumbnail">
										<div class="product-container">
											<div class="image">
												<img class="img-responsive"
													src="https://badmintonshoppen.se/wp-content/uploads/2022/10/Yonex-Astrox-99-Tour-2-896x896-jpg.webp"
													alt="" />
											</div>
											<div class="product-meta">
												<h5 class="name">
													<a class="product-name" href="#"
														title="Yonex astrox 99 tour">Yonex astrox 99 tour</a>
												</h5>
												<div class="product-item-price">
													<span class="product-item-regular">120 euro</span> <span
														class="product-item-discount">108 euro</span>
												</div>
											</div>
											<div class="button-product-action clearfix">
												<div class="cart icon">
													<a class="btn btn-outline-inverse buy" product-id="5"
														href="javascript:void(0)" title="add to cart"> cart <i
														class="fa fa-shopping-cart"></i>
													</a>
												</div>
												<div class="quickview icon">
													<a class="btn btn-outline-inverse" href="#"
														title="quick view"> details <i class="fa fa-eye"></i>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="item thumbnail">
										<div class="product-container">
											<div class="image">
												<img class="img-responsive"
													src="https://badmintonshoppen.se/wp-content/uploads/2022/10/Yonex-Astrox-99-Tour-2-896x896-jpg.webp"
													alt="" />
											</div>
											<div class="product-meta">
												<h5 class="name">
													<a class="product-name" href="#"
														title="Yonex astrox 88D Pro">Yonex astrox 88D Pro</a>
												</h5>
												<div class="product-item-price">
													<span class="product-item-regular">120 euro</span> <span
														class="product-item-discount">108 euro</span>
												</div>
											</div>
											<div class="button-product-action clearfix">
												<div class="cart icon">
													<a class="btn btn-outline-inverse buy" product-id="5"
														href="javascript:void(0)" title="add to cart"> cart <i
														class="fa fa-shopping-cart"></i>
													</a>
												</div>
												<div class="quickview icon">
													<a class="btn btn-outline-inverse" href="#"
														title="quick view"> details <i class="fa fa-eye"></i>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="item thumbnail">
										<div class="product-container">
											<div class="image">
												<img class="img-responsive"
													src="https://badmintonshoppen.se/wp-content/uploads/2022/09/Li-Ning-Ranger-VI-Lite-Black-badmintonsko-1-224x224-jpg.webp"
													alt="" />
											</div>
											<div class="product-meta">
												<h5 class="name">
													<a class="product-name" href="#" title="Lining ranger IV">Lining
														ranger IV</a>
												</h5>
												<div class="product-item-price">
													<span class="product-item-regular">120 euro</span> <span
														class="product-item-discount">108 euro</span>
												</div>
											</div>
											<div class="button-product-action clearfix">
												<div class="cart icon">
													<a class="btn btn-outline-inverse buy" product-id="5"
														href="javascript:void(0)" title="add to cart"> cart <i
														class="fa fa-shopping-cart"></i>
													</a>
												</div>
												<div class="quickview icon">
													<a class="btn btn-outline-inverse" href="#"
														title="quick view"> details <i class="fa fa-eye"></i>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="item thumbnail">
										<div class="product-container">
											<div class="image">
												<img class="img-responsive"
													src="https://badmintonshoppen.se/wp-content/uploads/2021/09/Yonex-Crew-Neck-Womens-Tshirt-20645EX-Sunshine-Orange-p-183x224-jpg.webp"
													alt="" />
											</div>
											<div class="product-meta">
												<h5 class="name">
													<a class="product-name" href="#" title="Yonex women tshirt">Yonex
														women tshirt</a>
												</h5>
												<div class="product-item-price">
													<span class="product-item-regular">120 euro</span> <span
														class="product-item-discount">108 euro</span>
												</div>
											</div>
											<div class="button-product-action clearfix">
												<div class="cart icon">
													<a class="btn btn-outline-inverse buy" product-id="5"
														href="javascript:void(0)" title="add to cart"> cart <i
														class="fa fa-shopping-cart"></i>
													</a>
												</div>
												<div class="quickview icon">
													<a class="btn btn-outline-inverse" href="#"
														title="quick view"> details <i class="fa fa-eye"></i>
													</a>
												</div>
											</div>
										</div>
									</div>
									<div class="item thumbnail">
										<div class="product-container">
											<div class="image">
												<img class="img-responsive"
													src="https://badmintonshoppen.se/wp-content/uploads/2022/11/Yonex-T-shirt-225101-White-224x224-jpg.webp"
													alt="" />
											</div>
											<div class="product-meta">
												<h5 class="name">
													<a class="product-name" href="#" title="Yonex Tshirt">Yonex
														Tshirt</a>
												</h5>
												<div class="product-item-price">
													<span class="product-item-regular">120 euro</span> <span
														class="product-item-discount">108 euro</span>
												</div>
											</div>
											<div class="button-product-action clearfix">
												<div class="cart icon">
													<a class="btn btn-outline-inverse buy" product-id="5"
														href="javascript:void(0)" title="add to cart"> cart <i
														class="fa fa-shopping-cart"></i>
													</a>
												</div>
												<div class="quickview icon">
													<a class="btn btn-outline-inverse" href="#"
														title="quick view"> details <i class="fa fa-eye"></i>
													</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
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