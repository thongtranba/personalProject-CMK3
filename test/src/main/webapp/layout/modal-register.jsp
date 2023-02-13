<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="modal-register" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-color">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">x</button>
				<h3 class="modal-title text-center">Register</h3>
			</div>
			<form action="authentication?command=REGISTER" method="POST"
				role="form">
				<div class="modal-body">
					<div class="form-group">
						<input type="text" class="form-control" id="username"
							name="username" placeholder="Username" required
							oninvalid="this.setCustomValidity('type your name')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<input type="tel" class="form-control" id="mobile" name="mobile"
							placeholder="Mobile phone" required pattern="[0][0-9]{9,}"
							oninvalid="this.setCustomValidity('type your mobile phone')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<input type="email" class="form-control" id="email" name="email"
							placeholder="Email" required
							oninvalid="this.setCustomValidity('type your email')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="password"
							placeholder="Password" required
							pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$"
							oninvalid="this.setCustomValidity('at least 8 letters: number, upper case, lower case')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="re-password" placeholder="Re-password" required
							autocomplete="off" 
							pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$"
							oninvalid="this.setCustomValidity('at least 8 letters: number, upper case, lower case')"
							oninput="this.setCustomValidity('')" />
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="address"
							name="address" placeholder="Address" required />
					</div>
					<div class="form-group">
						<input type="hidden" class="form-control" id="notification"
							name="notification" value="${notification}" />
					</div>

					<div class="text-left">
						<a href="javascript:void(0)" data-dismiss="modal"
							class="btn-login">You are already a member? Sign in!</a>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Cancle</button>
					<button type="submit" class="btn btn-primary ">Register</button>
				</div>
			</form>
		</div>
	</div>
</div>