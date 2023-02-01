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
						<li><a
							href="category?command=CATEGORY&category=${product.categoryName}&pageId=1"
							target="_self">${product.categoryName}</a></li>
						<li><span>/</span></li>
						<li class="active"><span><c:out
									value="${product.name}" /></span></li>
					</ol>
				</div>
				<div class="col-xs-3 hidden-lg hidden-md">
					<a class="hidden-lg pull-right btn-aside-mobile"
						href="javascript:void(0)">Sort <i
						class="fa fa-angle-double-right"></i></a>
				</div>
				<div class="clearfix"></div>
				<!-- <aside class="col-md-3">
                        <div class="inner-aside">
                            
                        </div>
                    </aside> -->
				<div class="col-md-10 product-detail">
					<div class="row product-info">
						<jsp:include page="layout/view-product-detail.jsp" />

						<!-- RELATED PRODUCTS -->
						<jsp:include page="layout/view-related-products.jsp" />
						<!-- END RELATED PRODUCTS -->
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