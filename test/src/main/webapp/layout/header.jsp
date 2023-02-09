<header>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- use for ajax -->
	<input type="hidden" id="reference" value="" />
	<!-- Top Navbar -->
	<div class="top-navbar container-fluid">
		<div class="menu-mb">
			<ul>
				<jsp:include page="menu-bar-navigation.jsp" />
			</ul>
		</div>
		<div class="row">
			<div class="hidden-lg hidden-md col-sm-2 col-xs-1">
				<span class="btn-menu-mb" onclick="openMenuMobile()"><i
					class="glyphicon glyphicon-menu-hamburger"></i></span>
			</div>
			<div class="col-md-6 hidden-sm hidden-xs">
				<ul class="list-inline">
					<li><a href="https://www.instagram.com"><i
							class="fab fa-instagram"></i></a></li>
				</ul>
			</div>
			<div class="col-md-6 col-sm-10 col-xs-11 top-right">
				<ul class="list-inline pull-right">

					<li><a href="category?command=SALEOFF">>> Outlet products
							up to 60%</a></li>

				</ul>
			</div>
		</div>
	</div>
	<!-- End top navbar -->
	<!-- Header -->
	<div class="container-fluid banner">
		<div class="row">
			<!-- LOGO -->
			<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 logo">
				<a href="home"><img src="public/images/bathongLogo.png"
					height="100px" width="120px" class="img-responsive" /></a>
			</div>

			<!-- SERCH -->
			<div class="col-lg-6 col-md-6 col-sm-10 hotline-search">
				<form class="header-form" action="category?command=SEARCH" method="POST">
					<div class="input-group">
						<input type="search" class="form-control search" required
							placeholder="Search your products" name="search"
							autocomplete="off" value="" />
						<div class="input-group-btn">
							<button class="btn bt-search bg-color" type="submit">
								<i class="fa fa-search" style="color: #fff"></i>
							</button>
						</div>

					</div>
					<div class="search-result"></div>
				</form>
			</div>
		</div>
	</div>
	<!-- End header -->
</header>
<!-- NAVBAR DESKTOP-->
<nav class="navbar navbar-default desktop-menu">
	<div class="container">
		<ul class="nav navbar-nav navbar-left hidden-sm hidden-xs">
				<jsp:include page="menu-bar-navigation.jsp" />
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${sessionScope.username == null}">

				<li><a href="javascript:void(0)" class="fa fa-user btn-login"></a>
				</li>

			</c:if>
			<c:if test="${sessionScope.username != null}">

				<li><a href="javascript:void(0)"
					class="fa fa-user-check btn-user"></a></li>

			</c:if>

			<li class="cart"><a href="javascript:void(0)"
				class="btn-cart-detail" title="Cart"> <i
					class="fa fa-shopping-cart"></i> <span class="number-total-product">${empty sessionScope.cart? 0 : sessionScope.cart.size() }</span></a></li>
		</ul>
	</div>
</nav>