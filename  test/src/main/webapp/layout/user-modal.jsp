<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="modal-user" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 class="modal-title text-center">Hi,${sessionScope.username}</h3>
				<br />
			</div>
			<form action="authentication?command=LOGOUT" method="POST"
				role="form">
				<div class="modal-body">
					<div class="form-group">
						<a href="myInformation.jsp">My information</a>
					</div>
					<div class="form-group">
						<a href="cart?command=MY_ORDER&id=${sessionScope.customerId}">My
							purchase</a>

					</div>
					<div class="form-group">
						<a href="contact.jsp">Contact us</a>

					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Cancle</button>
					<button type="submit" class="btn btn-primary">Logout</button>

				</div>
			</form>
		</div>

	</div>
</div>