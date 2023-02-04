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
						<li class="active"><span>Delivery</span></li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<h4>Delivery</h4>
					<div class="content-page border-page">
						<p>
							<span>We offer free shipping when purchasing goods for
								over Euro 40 . This applies to all orders delivered to your
								nearest agent.</span> <span>Please note : Some products that
								weigh less than 20kg are sent as home delivery due to their
								size, this according to the regulations of DHL, Bring and
								Postnord. If you are unsure about your delivery options, this
								will be shown at checkout when you buy your product, if shipping
								is added.</span>
						</p>
						<br />
						<p>
							<b>DELIVERY TIME</b>
						</p>
						<ul>
							<li><span>Many of you shop with us now and we work
									day and night to pack and send all your packages on time.
									Despite that, there may be delays in our delivery to you, up to
									2-4 days more than you intended.</span><span><br /> <br /></span></li>
							<li><span>Once we have confirmed your order, an order
									confirmation will be sent to your provided email address.
									Contact our customer service if you do not receive a
									confirmation shortly after your order. The delivery time
									(including the forwarder's time to deliver your order) normally
									takes no more than 1-7 days nationwide when we send your order
									to the nearest delivery point. It may occasionally take a few
									extra days during major campaigns and department store
									openings. You can trust that we will do everything we can to
									deliver your order as quickly as possible!</span></li>
						</ul>
						<p>
							<b>SOLD OUT ITEMS IN YOUR ORDER</b>
						</p>
						<ul>
							<li><span> Sometimes, unfortunately, you can order
									goods that for one reason or another (incorrect stock status)
									are not available in our central warehouse or on our internet
									warehouse. You will then of course receive notification from us
									via e-mail. </span></li>
						</ul>
						<p>
							<br />
						</p>
						<p>
							<b>UNRELEASED PACKAGES/SHIPMENTS</b>
						</p>
						<ul>
							<li><span>Remember to pick up your order within 7
									days (Postnord) or within 14 days (Bring). Packages that are
									not picked up are automatically returned. (Unredeemed packages
									are not covered by the right of withdrawal)</span></li>
						</ul>
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