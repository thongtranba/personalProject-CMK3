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

	<div class="slideshow container-fluid">
		<div class="row">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1" class=""></li>
					<li data-target="#myCarousel" data-slide-to="2" class=""></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<div class="item active">
						<img
							src="https://www.badmintonalley.com/v/vspfiles/assets/images/banner_16377.jpg"
							height="70px" width="100%" alt="slider 1" />
					</div>

					<div class="item">
						<img
							src="https://www.playandtrack.com/wp-content/uploads/2022/05/280557229_425315666087922_7649860625679821842_n.jpg"
							width="100%" alt="slider 2" />
					</div>

					<div class="item">
						<img
							src="https://www.victorsport.com/files/en_us/collection/collection_106_banner_photo.jpg?v=1660117532"
							width="100%" alt="slider 3" />
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	<!-- END SLIDESHOW -->
	<!-- SERVICES -->

	<main id="maincontent" class="page-main">

		<div class="container">
			<div class="row equal">
				<div class="col-xs-12">
					<h4 class="home-title">popular products</h4>
				</div>
				<c:forEach var="product" items="${listPopularProduct}">
					<div class="col-xs-6 col-sm-3">
						<div class="product-container">
							<div class="image">
								<img class="img-responsive" src="${product.image }" alt="" />
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
			<div class="row equal">
				<div class="col-xs-12">
					<h4 class="home-title">Latest products</h4>
				</div>

				<c:forEach var="product" items="${listPopularProduct}">
					<div class="col-xs-6 col-sm-3">
						<div class="product-container">
							<div class="image">
								<img class="img-responsive" src="${product.image }" alt="" />
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
			<div class="row equal">
				<div class="col-xs-12">
					<h4 class="home-title">Services</h4>
				</div>
				<div class="col-xs-6 col-sm-3">
					<div class="product-container">
						<div class="image">
							<img class="img-responsive"
								src="https://www.racketstringers.com/wp-content/uploads/2016/08/tennisracket-bespannen-kosten.jpg"
								alt="services" />
						</div>
						<div class="product-meta">
							<h5 class="name">
								<a class="product-name" href="#" title="racket stringing">String
									your racket</a>
							</h5>
							<div class="product-item-price">
								<span class="product-item-price">23 euro</span>
							</div>
						</div>
						<div class="button-product-action clearfix">
							<div class="cart icon">
								<a class="btn btn-outline-inverse buy" product-id="2"
									href="javascript:void(0)" title="add to cart"> add to cart
									<i class="fa fa-shopping-cart"></i>
								</a>
							</div>
							<div class="quickview icon">
								<a class="btn btn-outline-inverse" href="#" title="quickview">
									details <i class="fa fa-eye"></i>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-6 col-sm-3">
					<div class="product-container">
						<div class="image">
							<img class="img-responsive"
								src="https://www.victorsport.com/files/en_us/product/more/2018052516305474717.jpg"
								alt="services" />
						</div>
						<div class="product-meta">
							<h5 class="name">
								<a class="product-name" href="#" title="string VBS-70 power">VBS-70
									power</a>
							</h5>
							<div class="product-item-price">
								<span class="product-item-price">17 euro</span>
							</div>
						</div>
						<div class="button-product-action clearfix">
							<div class="cart icon">
								<a class="btn btn-outline-inverse buy" product-id="2"
									href="javascript:void(0)" title="add to cart"> add to cart
									<i class="fa fa-shopping-cart"></i>
								</a>
							</div>
							<div class="quickview icon">
								<a class="btn btn-outline-inverse" href="#" title="quickview">
									details <i class="fa fa-eye"></i>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row equal">
				<div class="col-xs-12">
					<h4 class="home-title">Racket Buddy</h4>
				</div>
				<div class="col-xs-6 col-sm-3">
					<div class="product-container">
						<div class="image">
							<img class="img-responsive"
								src="https://www.playandtrack.com/wp-content/uploads/2022/06/Padel-package-2-1.png"
								alt="racketbuddy" />
						</div>
						<div class="product-meta">
							<h5 class="name">
								<a class="product-name" href="#" title="Racket Buddy">Racket
									Buddy V.5</a>
							</h5>
							<div class="product-item-price">
								<span class="product-item-price">100 euro</span>
							</div>
						</div>
						<div class="button-product-action clearfix">
							<div class="cart icon">
								<a class="btn btn-outline-inverse buy" product-id="2"
									href="javascript:void(0)" title="add to cart"> add to cart
									<i class="fa fa-shopping-cart"></i>
								</a>
							</div>
							<div class="quickview icon">
								<a class="btn btn-outline-inverse" href="#" title="quickview">
									details <i class="fa fa-eye"></i>
								</a>
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
