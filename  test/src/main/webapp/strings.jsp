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
						<li class="active"><span>Strings</span></li>
					</ol>
				</div>
				<div class="col-xs-3 hidden-lg hidden-md">
					<a class="hidden-lg pull-right btn-aside-mobile"
						href="javascript:void(0)">Sort <i
						class="fa fa-angle-double-right"></i></a>
				</div>
				<div class="clearfix"></div>
				<aside class="col-md-3">
					<div class="inner-aside">
						<jsp:include page="layout/asideMenu.jsp" />
					</div>
				</aside>
				<div class="col-md-9 products">
					<div class="row equal">
						<div class="col-xs-6">
							<h4 class="home-title">String & Services</h4>
						</div>
						<div class="col-xs-6 sort-by">
							<jsp:include page="layout/sort.jsp" />
						</div>
						<div class="clearfix"></div>
						<c:forEach var="string" items="${listStrings}">
							<div class="col-xs-6 col-sm-4">
								<div class="product-container">
									<div class="image">
										<img class="img-responsive" src="${string.image}" alt="" />
									</div>
									<div class="product-meta">
										<h5 class="name">
											<a class="product-name"
												href="productDetail?id=<c:out value='${string.id}' />"
												title="${string.name}">${string.name}</a>
										</h5>
										<div class="product-item-price">
											<span class="product-item-regular">${string.price}
												euro</span> <span class="product-item-discount">108 euro</span>
										</div>
									</div>
									<div class="button-product-action clearfix">

										<div class="quickview icon">
											<a class="btn btn-outline-inverse"
												href="productDetail?id=<c:out value='${string.id}' />"
												title="quick view"> detail <i
												class="fa fa-eye"></i>
											</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

						<!-- Paging -->
						<ul class="pagination pull-right">
							<li class="active"><a href="javascript:void(0)"
								onclick="goToPage(1)">1</a></li>
							<li class=""><a href="javascript:void(0)"
								onclick="goToPage(2)">2</a></li>
							<li class=""><a href="javascript:void(0)"
								onclick="goToPage(3)">3</a></li>
							<li><a href="javascript:void(0)" onclick="goToPage(2)">&raquo;</a>
							</li>
						</ul>
						<!-- End paging -->
					</div>
				</div>
			</div>
	</main>
	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->
</body>
</html>
