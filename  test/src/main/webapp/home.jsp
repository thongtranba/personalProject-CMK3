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
	<!-- SLIDESHOW -->
	<jsp:include page="layout/carousel.jsp" />
	<!-- END SLIDESHOW -->

	<main id="maincontent" class="page-main">
		<div class="container">
			<div class="row equal">
				<div class="col-xs-12">
					<h4 class="home-title">popular products</h4>
				</div>
				<jsp:include page="layout/view-popular-products.jsp" />
			</div>
			<div class="row equal">
				<div class="col-xs-12">
					<h4 class="home-title">Latest products</h4>
				</div>
				<jsp:include page="layout/view-latest-products.jsp" />

			</div>
			<div class="row equal">
				<div class="col-xs-12">
					<h4 class="home-title">Services</h4>
				</div>
			<jsp:include page="layout/view-service-products.jsp" />
			</div>
		</div>
	</main>
	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->

</body>
</html>
