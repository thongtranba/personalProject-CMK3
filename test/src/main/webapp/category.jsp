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
						<li><a href="home" target="_self">Home</a></li>
						<li><span>/</span></li>
						<li class="active"><span>${categoryPage}</span></li>
					</ol>
				</div>
				<div class="col-xs-3 hidden-lg hidden-md">
					<a class="hidden-lg pull-right btn-aside-mobile"
						href="javascript:void(0)">Sort <i
						class="fa fa-angle-double-right"></i></a>
				</div>
				<div class="clearfix"></div>
				<aside class="col-md-2">
					<div class="inner-aside">
						<jsp:include page="layout/category-aside-menu.jsp" />
					</div>
				</aside>
				<div class="col-md-10 products">
					<div class="row equal">
						<div class="col-xs-6">
							<h4 class="home-title">${categoryPage}</h4>
						</div>
						<div class="col-xs-6 sort-by">
							<jsp:include page="layout/category-sort.jsp" />
						</div>
						<div class="clearfix"></div>
						<jsp:include page="layout/view-product-by-category.jsp" />
					</div>

					<!-- Paging -->
					<jsp:include page="layout/category-pagination.jsp" />
					<!-- End paging -->
				</div>
			</div>
		</div>
	</main>
	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->
</body>
</html>
