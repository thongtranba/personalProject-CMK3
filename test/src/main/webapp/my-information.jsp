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
				<div class="col-xs-9">
					<ol class="breadcrumb">
						<jsp:include page="layout/home-navigation.jsp" />
						<li><span>/</span></li>
						<li class="active"><span>Customer Information</span></li>
					</ol>
				</div>
				<div class="clearfix"></div>
				<aside class="col-md-3">
					<div class="inner-aside">
						<div class="category">
							<ul>
								<li class="active"><a href="my-information.jsp"
									title="my information" target="_self">My information</a></li>
								<li><a title="my purchase"
									href="cart?command=MY_ORDER&id=${sessionScope.customerId}"
									target="_self">My purchase </a></li>
							</ul>
						</div>
					</div>
				</aside>
				<div class="col-md-9 account">
					<div class="row">
						<div class="col-xs-6">
							<h4 class="home-title">My Information</h4>
						</div>
						<div class="clearfix"></div>
						<div class="col-md-6">
							<jsp:include page="layout/view-my-information.jsp" />
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
