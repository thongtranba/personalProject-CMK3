<form class="info-account" action="#" method="POST" role="form">
	<div class="form-group">
		<input type="text" value="${sessionScope.username}"
			class="form-control" name="username" placeholder="username"
			required="" oninvalid="this.setCustomValidity('type your username')"
			oninput="this.setCustomValidity('')">
	</div>
	<div class="form-group">
		<input type="text" value="${sessionScope.mobile}" class="form-control"
			name="mobile" placeholder="mobile phone" required=""
			pattern="[0][0-9]{9,}"
			oninvalid="this.setCustomValidity('type your mobile phone')"
			oninput="this.setCustomValidity('')">
	</div>
	<div class="form-group">
		<input type="text" value="${sessionScope.address}"
			class="form-control" name="address" placeholder="address" required=""
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