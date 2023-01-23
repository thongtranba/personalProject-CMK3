<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="modal-forgot-password" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 class="modal-title text-center">Forgot password</h3>
			</div>
			<form action="#" method="POST" role="form">
				<div class="modal-body">
					<div class="form-group">
						<input name="email" type="email" class="form-control"
							placeholder="Email" required />
					</div>
				</div>
				<div class="modal-footer">
					<input type="hidden" name="reference" value="" />
					<button type="submit" class="btn btn-primary">Send</button>
					<br />
				</div>
			</form>
		</div>
	</div>
</div>