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
						<li class="active"><span>Payment</span></li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<h4 id="payment">Payment</h4>
					<jsp:include page="layout/view-payment-policy.jsp" />
				</div>
			</div>
		</div>
	</main>
	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->
</body>
</html>
