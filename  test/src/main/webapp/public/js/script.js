function openMenuMobile() {
	$(".menu-mb").width("250px");
	$(".btn-menu-mb").hide("slow");
}

function closeMenuMobile() {
	$(".menu-mb").width(0);
	$(".btn-menu-mb").show("slow");
}

$(function() {
	$(".product-container").hover(function() {
		$(this).children(".button-product-action").toggle(400);
	});

	// Display or hidden button back to top
	$(window).scroll(function() {
		if ($(this).scrollTop()) {
			$(".back-to-top").fadeIn();
		} else {
			$(".back-to-top").fadeOut();
		}
	});


	$(".back-to-top").click(function() {
		$("html").animate({ scrollTop: 0 }, 800);
	});


	$(".btn-register").click(function() {
		$("#modal-login").modal("hide");
		$("#modal-register").modal("show");
	});
	
	$(".btn-user").click(function() {
		$("#modal-user").modal("show");
	});


	$(".btn-forgot-password").click(function() {
		$("#modal-login").modal("hide");
		$("#modal-forgot-password").modal("show");
	});

	$(".btn-login").click(function() {
		$("#modal-notification").modal("hide");
		$("#modal-login").modal("show");
	});

	$(".btn-notification").click(function() {
		$("#modal-register").modal("hide");
		$("#modal-notification").modal("show");
	});


	$(".modal").on("hide.bs.modal", function(e) {
		e.stopPropagation();
		$("body").css("padding-right", 0);
	});


	$(".btn-cart-detail").click(function() {
		$("#modal-cart-detail").modal("show");
	});

	$(".btn-aside-mobile").click(function() {
		$("main aside .inner-aside").toggle();
	});


	$(
		"main .product-detail .product-detail-carousel-slider .owl-carousel"
	).owlCarousel({
		margin: 10,
		nav: true,
	});

	$("main .product-detail .product-detail-carousel-slider img").click(function(
		event
	) {
		/* Act on the event */
		$("main .product-detail .main-image-thumbnail").attr(
			"src",
			$(this).attr("src")
		);
		var image_path = $("main .product-detail .main-image-thumbnail").attr(
			"src"
		);
		$(".zoomWindow").css("background-image", "url('" + image_path + "')");
	});

	$("main .product-detail .product-description .rating-input").rating({
		min: 0,
		max: 5,
		step: 1,
		size: "md",
		stars: "5",
		showClear: false,
		showCaption: false,
	});

	$("main .product-detail .product-description .answered-rating-input").rating({
		min: 0,
		max: 5,
		step: 1,
		size: "md",
		stars: "5",
		showClear: false,
		showCaption: false,
		displayOnly: false,
		hoverEnabled: true,
	});

	$("main .ship-checkout[name=payment_method]").click(function(event) {
		/* Act on the event */
	});

	$("input[name=checkout]").click(function(event) {
		/* Act on the event */
		window.location.href = "order.jsp";
	});


	$("input[name=back-shopping]").click(function(event) {
		/* Act on the event */
		window.location.href = "HomeServlet";
	});


	$("main .product-detail .product-related .owl-carousel").owlCarousel({
		loop: true,
		margin: 10,
		nav: true,
		dots: false,
		responsive: {
			0: {
				items: 2,
			},
			600: {
				items: 4,
			},
			1000: {
				items: 5,
			},
		},
	});
});
