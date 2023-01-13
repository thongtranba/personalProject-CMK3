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
				<div class="col-xs-12">
					<ol class="breadcrumb">
						<li><a href="HomeServlet" target="_self">Home</a></li>
						<li><span>/</span></li>
						<li class="active"><span>Order successful</span></li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 ">
					<h4>You have completed your order. To continue shopping, click</h4> <a
						href="HomeServlet">Here</a>
						<br>
						<h5>Check your purchase, click</h5> <a
						href="myPurchase?command=MY_ORDER&id=${sessionScope.customerId}">Here</a>
				</div>
			</div>
		</div>
	</main>

	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->

</body>
</html>
