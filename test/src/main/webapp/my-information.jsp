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
							<form class="info-account" action="#" method="POST" role="form">
								<div class="form-group">
									<input type="text" value="${sessionScope.username}"
										class="form-control" name="username" placeholder="username"
										required=""
										oninvalid="this.setCustomValidity('type your username')"
										oninput="this.setCustomValidity('')">
								</div>
								<div class="form-group">
									<input type="text" value="${sessionScope.mobile}"
										class="form-control" name="mobile" placeholder="mobile phone"
										required="" pattern="[0][0-9]{9,}"
										oninvalid="this.setCustomValidity('type your mobile phone')"
										oninput="this.setCustomValidity('')">
								</div>
								<div class="form-group">
									<input type="text" value="${sessionScope.address}"
										class="form-control" name="address" placeholder="address"
										required=""
										oninvalid="this.setCustomValidity('type your address')"
										oninput="this.setCustomValidity('')">
								</div>
								<div class="form-group">
									<input type="password" class="form-control" name="password"
										placeholder="New password"
										pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$"
										oninvalid="this.setCustomValidity('type your new password')"
										oninput="this.setCustomValidity('')">
								</div>
								<div class="form-group">
									<input type="password" class="form-control" name="re-password"
										placeholder="re-password" autocomplete="off" autosave="off"
										pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$"
										oninvalid="this.setCustomValidity('re-password')"
										oninput="this.setCustomValidity('')">
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary pull-right">Update</button>
								</div>
							</form>
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
