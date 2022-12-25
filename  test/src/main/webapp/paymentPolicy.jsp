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
						<li><a href="homeServlet" target="_self">Home</a></li>
						<li><span>/</span></li>
						<li class="active"><span>Payment</span></li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<h4 id="payment">Payment</h4>
					<div class="content-page border-page">
						<p>
							<span>CARD PAYMENT </span>
						</p>

						<p>You can pay with credit or debit cards from VISA,
							Mastercard and American Express at website. Your card transaction
							is sent encrypted through Klarna, which is our provider of card
							payment solutions. When paying by card, the card number, the
							card's validity period, CVC code and, for some cards, also the 3D
							Secure code are entered. Card information is not stored by BT
							Shop after a completed transaction. The total amount of your
							order is reserved only in your account and we debit your account
							only when we ship your order. We only charge you for products we
							ship to you.</p>

						<p>
							<span>IF YOU CANNOT COMPLETE THE PAYMENT BY CARD</span>
						</p>
						<p>The following may be the reason why you cannot complete
							your order and sign with 3Dsecure/BankID:</p>
						<p>- Signing with 3D Secure/BankID usually
							requires Java to work on the device. If you do not have Java
							installed, you will get a white page without being able to
							complete your purchase.</p>
						<p>- You are using a device that does not
							support Java. Please try to complete your purchase from another
							device.</p>
						<p>- Also check that you have activated
							the option for online purchases with your card before paying.</p>
						</p>
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
