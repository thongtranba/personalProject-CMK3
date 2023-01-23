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
								<li><a href="myInformation.jsp" title="my information"
									target="_self">My information</a></li>
								<li class="active"><a
									href="cart?command=MY_ORDER&id=${sessionScope.customerId}"
									target="_self" title="my purchase">My purchase </a></li>
							</ul>
						</div>
					</div>
				</aside>
				<div class="col-md-9 order">
					<jsp:include page="layout/view-my-purchase.jsp" />
				</div>
			</div>
		</div>
	</main>

	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->

</body>
</html>
