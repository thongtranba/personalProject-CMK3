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

	$('main .product-detail .product-detail-carousel-slider img').click(function(event) {
		/* Act on the event */
		$('main .product-detail .main-image-thumbnail').attr("src", $(this).attr("src"));
		var image_path = $('main .product-detail .main-image-thumbnail').attr("src");
		$(".zoomWindow").css("background-image", "url('" + image_path + "')");

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

$(document).ready(function() {
	var cartItems = $(".totalItem").val();
	console.log("cart: " + cartItems);

	$(".btn-cart-detail").click(function(event) {
		event.preventDefault();
		$("#modal-cart-detail").modal("show");
		totalprice();
	});

	$("input[name=inputQty]").on("click", function(event) {
		event.preventDefault();
		var inputQty = $(".cartQtyInput").val();
		totalprice(inputQty);

	});

	function totalprice() {
		var total = 0;
		var inputQty = 0;
		var price = 0;
		var subtotal = 0;

		for (var i = 0; i < cartItems; i++) {
			var productId = $(".productId").eq(i).val();
			if ($(".cartQtyInput").eq(i).val() == 1 && localStorage.getItem(productId)) {
				inputQty = JSON.parse(localStorage.getItem(productId));
				$(".cartQtyInput").eq(i).val(inputQty)
			} else {
				inputQty = $(".cartQtyInput").eq(i).val();
			}
			console.log("inputQty: " + inputQty);
			price = $(".cart-price").eq(i).text();
			subtotal = Math.round((inputQty * price) * 100) / 100;
			console.log("subtotal: " + subtotal);
			var productId = $(".productId").eq(i).val();
			localStorage.setItem(productId, inputQty);
			$(".remove-product").eq(i).click(function() {
				localStorage.removeItem(productId);

			});
			$(".subTotal").eq(i).html(subtotal + " euro");
			total = total + (price * inputQty);
		}

		total = Math.round(total * 100) / 100;
		$(".price-total").html(total + " euro");
	}

	$("input[name=checkout]").on('click', function() {
		var cartList = [];

		for (var i = 0; i < cartItems; i++) {
			var productId = $(".productId").eq(i).val();
			var quantity = $(".cartQtyInput").eq(i).val();

			var cartItem = {
				productId: productId,
				quantity: quantity
			};
			cartList[i] = cartItem;
		}

		localStorage.setItem("cartList", JSON.stringify(cartList));
		checkout();
	});

	function checkout() {
		window.location.href = "checkout-order.jsp";
	}
	var total = 0;
	var products = [];
	if (localStorage.getItem('cartList')) {
		products = JSON.parse(localStorage.getItem('cartList'));

		console.log(products);
		for (var i = 0; i < cartItems; i++) {
			productId = products[i].productId;
			price = $(".cart-price").eq(i).text();
			inputQty = products[i].quantity;

			var subtotal = Math.round((inputQty * price) * 100) / 100;

			$(".qty").eq(i).html(inputQty);
			$(".subTotal").eq(i).html(subtotal + " euro");
			$("input[name=subTotal]").eq(i).val(subtotal);
			total = total + (inputQty * price);
		}

		total = Math.round(total * 100) / 100;
		$(".price-total").html(total + " euro");

		var deliveryFee = 3.9;
		$(".delivery-fee").html(deliveryFee + " euro");
		$("input[name=delivery]").val(deliveryFee);

		var paymentTotal = Math.round((total + 3.9)*100)/100;
		$(".payment-total").html(paymentTotal + " euro");
		$("input[name=total]").val(paymentTotal);

	};

	console.log(localStorage.getItem('cartList'));
	
	$("#pay-now").click(function() {
		localStorage.clear();
	})

	$("input[name=JSONString]").val(localStorage.getItem('cartList'));

})








