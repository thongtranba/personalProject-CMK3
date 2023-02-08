<div align="center">
	<h1>Your Order Has been Paid Successfully!</h1>
	<br />
	<div>
		<form action="home" method="GET">
			<input type="submit" class="btn btn-primary"
				value="Continue Shopping">
		</form>
	</div>
	<h2>Receipt Details:</h2>
	<table>
		<tr>
			<td><b>Merchant:</b></td>
			<td>BaThong Shop</td>
		</tr>
		<tr>
			<td><b>Payer:</b></td>
			<td>${payer.firstName}</td>
		</tr>
		<tr>
			<td><b>Description:</b></td>
			<td>${transaction.description}</td>
		</tr>
		<tr>
			<td><b>Subtotal:</b></td>
			<td>${transaction.amount.details.subtotal}EUR</td>
		</tr>
		<tr>
			<td><b>Shipping:</b></td>
			<td>${transaction.amount.details.shipping}EUR</td>
		</tr>
		<tr>
			<td><b>Total:</b></td>
			<td>${transaction.amount.total}EUR</td>
		</tr>
	</table>
</div>