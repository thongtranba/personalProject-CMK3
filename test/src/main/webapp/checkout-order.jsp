<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
				<div class="col-xs-12">
					<ol class="breadcrumb">
						<jsp:include page="layout/home-navigation.jsp" />
						<li><span>/</span></li>
						<li class="active"><span>Order Information</span></li>
					</ol>
				</div>
			</div>
			<div class="row">
				<jsp:include page="layout/view-checkout-order.jsp" />
			</div>
		</div>
	</main>
	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->
</body>
</html>
