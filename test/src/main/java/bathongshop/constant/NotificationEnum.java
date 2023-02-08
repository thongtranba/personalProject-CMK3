package bathongshop.constant;

public enum NotificationEnum {
	REGISTER_NOTIFICATION("registerNotification"), REGISTER_NOTIFICATION_MESSAGE("Registered Successfully!"),
	REGISTER_DUPLICATED_NOTIFICATION("duplicatedNotification"),
	REGISTER_DUPLICATED_NOTIFICATION_MESSAGE("Your email or mobile has been used! Please, try a new one"),
	REGISTER_FAIL_NOTIFICATION("registerFailNotification"),
	REGISTER_FAIL_NOTIFICATION_MESSAGE("Register Fail! Please try again or contact to our customer service"),
	LOGIN_NOTIFICATION("loginNotification"), LOGIN_NOTIFICATION_MESSAGE("Login fail!!"),
	UPDATE_NOTIFICATION("updateNotification"), UPDATE_NOTIFICATION_MESSAGE("Updated Successfully!"),
	UPDATE_DUPLICATED_NOTIFICATION("updateDuplicatedNotification"),
	UPDATE_DUPLICATED_NOTIFICATION_MESSAGE(
			"Your email or mobile has been used! Please, try a new one to update your account"),
	UPDATE_FAIL_NOTIFICATION("updateFAILNotification"),
	UPDATE_FAIL_NOTIFICATION_MESSAGE("Update Fail! Please try again or contact to our customer service"),
	ORDER_FAIL_NOTIFICATION("orderFailNotification"),
	ORDER_FAIL_NOTIFICATION_MESSAGE("Your order has been FAIL! Please try again or contact to our customer services"),
	ADD_TO_CART_NOTIFICATION("notification"), ADD_TO_CART_NOTIFICATION_MESSAGE("you added to cart! check your cart.");

	private String value;

	private NotificationEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
