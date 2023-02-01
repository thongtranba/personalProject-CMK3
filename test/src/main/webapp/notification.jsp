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
						<jsp:include page="layout/home-navigation.jsp" />
						<li><span>/</span></li>
						<li class="active"><span>Notification</span></li>
					</ol>
				</div>
			</div>

			<div class="row">
				<c:if test="${registerNotification != null}">
					<div class="col-md-12 col-xs-12 ">

						${registerNotification}. To continue shopping,
						<button class="btn btn-primary btn-login">Login</button>
					</div>
					<div class="col-md-12 col-xs-12 ">
						<img
							src="https://www.iiba.org/contentassets/a77b7d7258614d758252b46f26728dda/member-card-768x432.jpg"
							height="70%" width="70%" />
					</div>
				</c:if>
				<c:if test="${loginNotification != null}">
					<div class="col-md-12 col-xs-12 ">

						${loginNotification}. Try again,
						<button class="btn btn-primary btn-login">Login</button>
					</div>

				</c:if>

			</div>
		</div>
	</main>

	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->

</body>
</html>
