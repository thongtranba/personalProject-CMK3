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
				<div class="col-xs-9">
					<ol class="breadcrumb">
						<jsp:include page="layout/home-navigation.jsp" />
						<li><span>/</span></li>
						<li class="active"><span>Search</span></li>
					</ol>
				</div>
				<div class="col-xs-12">
					<h4 class="home-title">
						Search Result : <span class="text-success">"${searchString}"</span>
					</h4>
				</div>
				<jsp:include page="layout/view-search-products.jsp" />
			</div>
		</div>
	</main>
	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->

</body>
</html>
