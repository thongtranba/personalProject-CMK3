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
						<li class="active"><span>Customer Information</span></li>
					</ol>
				</div>
				<div class="clearfix"></div>
				<aside class="col-md-3">
					<div class="inner-aside">
						<div class="category">
							<ul>
								<li><a href="myInformation.jsp"
									title="my information" target="_self">My information</a></li>
								<li class="active"><a href="myPurchase?command=MY_ORDER&id=${sessionScope.customerId}" target="_self" title="my purchase">My
										purchase </a></li>
							</ul>
						</div>
					</div>
				</aside>
				<div class="col-md-9 order">
					<div class="row">
						<div class="col-xs-6">
							<h4 class="home-title">My Purchase</h4>
						</div>
						<div class="clearfix"></div>
						<div class="col-md-12">
							<c:forEach var="order" items="${orderList}">
								<div class="row">
									<div class="col-md-12">
										<h5 class="date">Date: ${order.createdDate}</h5>
										<span > <a href="myPurchase?command=MY_ORDER_DETAILS&orderId=${order.id}" >Order number: #${order.id}</a> </span>
										<hr>
									</div>
								</div>
							</c:forEach>
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
