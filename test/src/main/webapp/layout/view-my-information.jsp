<form class="info-account" action="authentication?command=UPDATE"
	method="POST" role="form">
	<div class="form-group">
		<input type="text" value="${sessionScope.username}"
			class="form-control" id="username" name="username"
			placeholder="Username" required
			oninvalid="this.setCustomValidity('type your name')"
			oninput="this.setCustomValidity('')" />
	</div>
	<div class="form-group">
		<input type="tel" value="${sessionScope.mobile}" class="form-control"
			id="mobile" name="mobile" placeholder="Mobile phone" required
			pattern="[0][0-9]{9,}"
			oninvalid="this.setCustomValidity('type your mobile phone')"
			oninput="this.setCustomValidity('')" />
	</div>
	<div class="form-group">
		<input type="email" value="${sessionScope.email}" class="form-control"
			id="email" name="email" placeholder="Email" required
			oninvalid="this.setCustomValidity('type your email')"
			oninput="this.setCustomValidity('')" />
	</div>
	<div class="form-group">
		<input type="text" value="${sessionScope.address}"
			class="form-control" id="address" name="address"
			placeholder="Address" required />
	</div>
	<div class="form-group">
		<input type="password" class="form-control" name="password"
			placeholder="Password" required
			pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$"
			oninvalid="this.setCustomValidity('at least 8 letters: number, up case, low case')"
			oninput="this.setCustomValidity('')" />
	</div>
	<div class="form-group">
		<input type="password" class="form-control" id="password"
			name="re-password" placeholder="Re-password" required
			autocomplete="off" autosave="off"
			pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$"
			oninvalid="this.setCustomValidity('at least 8 letters: number, up case, low case')"
			oninput="this.setCustomValidity('')" />
	</div>

	<div class="form-group">
		<button type="submit" class="btn btn-primary pull-right">Update</button>
	</div>
</form>