<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="modal-login" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 class="modal-title text-center">Login</h3>
				<!-- Google login -->
				<br />
			</div>
			<form action="authentication?command=LOGIN" method="POST" role="form">
				<div class="modal-body">
					<div class="form-group">
						<input type="email" name="email" id="email" class="form-control"
							placeholder="Email" required />
					</div>
					<div class="form-group">
						<input type="password" name="password" id="password"
							class="form-control" placeholder="Password" required />
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Cancle</button>
					<button type="submit" class="btn btn-primary">Login</button>
					<br />
					<div class="text-left">
						<a href="javascript:void(0)" class="btn-register">Are you a
							member? Register now!</a> <a href="javascript:void(0)"
							class="btn-forgot-password">Forgot password?</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>