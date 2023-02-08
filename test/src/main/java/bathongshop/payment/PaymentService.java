package bathongshop.payment;

import java.util.*;

import com.paypal.api.payments.*;
import com.paypal.base.rest.*;
import bathongshop.constant.ConstantDoubleEnum;
import bathongshop.constant.PublicConstant;
import bathongshop.model.CheckOutDetail;
import bathongshop.model.ProductModel;

public class PaymentService {
	public String authorizePayment(CheckOutDetail checkoutDetail, String firstName, String email,
			List<ProductModel> orderList) throws PayPalRESTException {
		Payer payer = getPayerInformation(firstName, email);
		RedirectUrls redirectUrls = getRedirectURLs();
		List<Transaction> listTransaction = getTransactionInformation(checkoutDetail, orderList);
		Payment requestPayment = new Payment();
		requestPayment.setTransactions(listTransaction);
		requestPayment.setRedirectUrls(redirectUrls);
		requestPayment.setPayer(payer);
		requestPayment.setIntent("authorize");
		APIContext apiContext = new APIContext(PublicConstant.CLIENT_ID, PublicConstant.CLIENT_SECRET,
				PublicConstant.MODE);
		Payment approvedPayment = requestPayment.create(apiContext);
		return getApprovalLink(approvedPayment);
	}

	private Payer getPayerInformation(String firstName, String email) {
		Payer payer = new Payer();
		payer.setPaymentMethod(PublicConstant.PAYPAL);
		PayerInfo payerInfo = new PayerInfo();
		payerInfo.setFirstName(PublicConstant.FIRSTNAME).setEmail(PublicConstant.EMAIL);
		payer.setPayerInfo(payerInfo);
		return payer;
	}

	private RedirectUrls getRedirectURLs() {
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(PublicConstant.CANCLE_URL);
		redirectUrls.setReturnUrl(PublicConstant.RETURN_URL);
		return redirectUrls;
	}

	private List<Transaction> getTransactionInformation(CheckOutDetail checkoutDetail, List<ProductModel> orderList) {
		Details details = new Details();
		details.setShipping(String.valueOf(checkoutDetail.getShippingFee()));
		details.setSubtotal(String.valueOf(checkoutDetail.getSubTotal()));
		Amount amount = new Amount();
		amount.setCurrency(PublicConstant.EUR);
		double itemAmount = ConstantDoubleEnum.CONSTANT_0.getValue();
		for (ProductModel product : orderList) {
			if (product.getDiscountPrice() != ConstantDoubleEnum.CONSTANT_0.getValue()) {
				itemAmount = itemAmount + (product.getDiscountPrice() * product.getInputQuantity());
			} else {
				itemAmount = itemAmount + (product.getPrice() * product.getInputQuantity());
			}
		}
		amount.setTotal(String.valueOf(checkoutDetail.getTotal()));
		amount.setDetails(details);
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription(PublicConstant.SET_DESCRIPTION);
		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<>();
		for (ProductModel product : orderList) {
			Item item = new Item();
			item.setCurrency(PublicConstant.EUR);
			item.setName(product.getName());
			if (product.getDiscountPrice() != ConstantDoubleEnum.CONSTANT_0.getValue()) {
				item.setPrice(String.valueOf(product.getDiscountPrice()));
			} else {
				item.setPrice(String.valueOf(product.getPrice()));
			}
			item.setQuantity(String.valueOf(product.getInputQuantity()));
			items.add(item);
			itemList.setItems(items);
			transaction.setItemList(itemList);
		}
		List<Transaction> listTransaction = new ArrayList<>();
		listTransaction.add(transaction);
		return listTransaction;
	}

	private String getApprovalLink(Payment approvedPayment) {
		List<Links> links = approvedPayment.getLinks();
		String approvalLink = null;
		for (Links link : links) {
			if (link.getRel().equalsIgnoreCase(PublicConstant.APPROVAL_URL)) {
				approvalLink = link.getHref();
				break;
			}
		}
		return approvalLink;
	}

	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(PublicConstant.CLIENT_ID, PublicConstant.CLIENT_SECRET,
				PublicConstant.MODE);
		return Payment.get(apiContext, paymentId);
	}

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);
		Payment payment = new Payment().setId(paymentId);
		APIContext apiContext = new APIContext(PublicConstant.CLIENT_ID, PublicConstant.CLIENT_SECRET,
				PublicConstant.MODE);
		return payment.execute(apiContext, paymentExecution);
	}
}