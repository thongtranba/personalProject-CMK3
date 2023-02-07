<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${registerNotification != null}">
	<div class="col-md-12 col-xs-12 ">
		${registerNotification}. To continue shopping,
		<button class="btn btn-primary btn-login">Login</button>
	</div>
	<div class="col-md-12 col-xs-12 ">
		<img
			src="https://www.iiba.org/contentassets/a77b7d7258614d758252b46f26728dda/member-card-768x432.jpg"
			height="70%" width="70%" />
	</div>
</c:if>
<c:if test="${duplicatedNotification != null}">
	<div class="col-md-12 col-xs-12 ">
		${duplicatedNotification}. To register,
		<button class="btn btn-primary btn-register">Register</button>
	</div>
	<div class="col-md-12 col-xs-12 ">
		<img
			src="https://cdn4.iconfinder.com/data/icons/seo-and-marketing-43/68/Error_Message-512.png"
			height="70%" width="70%" />
	</div>
</c:if>
<c:if test="${registerFailNotification != null}">
	<div class="col-md-12 col-xs-12 ">
		${registerFailNotification}.
		<button class="btn btn-primary btn-register">Register</button>
	</div>
	<div class="col-md-12 col-xs-12 ">
		<img
			src="https://buildfire.com/wp-content/uploads/2018/03/what-is-a-push-notification-and-why-it-matters-1200x900.jpg"
			height="70%" width="70%" />
	</div>
</c:if>
<c:if test="${loginNotification != null}">
	<div class="col-md-12 col-xs-12 ">
		${loginNotification}. Try again,
		<button class="btn btn-primary btn-login">Login</button>
	</div>
</c:if>
<c:if test="${orderFailNotification != null}">
	<div class="col-md-12 col-xs-12 ">${orderFailNotification}</div>
</c:if>

<c:if test="${updateDuplicatedNotification != null}">
	<div class="col-md-12 col-xs-12 ">
		${updateDuplicatedNotification}</div>
</c:if>

<c:if test="${updateNotification != null}">
	<div class="col-md-12 col-xs-12 ">
		${updateNotification}. Login again
		<button class="btn btn-primary btn-login">Login</button>
	</div>
</c:if>
<c:if test="${updateFAILNotification != null}">
	<div class="col-md-12 col-xs-12 ">${updateFAILNotification}</div>
</c:if>