package model;

public class OrderItem {
	private int productId;
	private int orderId;
	private int quantity;
	private double unitPrice;
	private double subTotalPrice;

	public OrderItem(int productId, int orderId, int quantity, double unitPrice, double subTotalPrice) {
		super();
		this.productId = productId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.subTotalPrice = subTotalPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getSubTotalPrice() {
		return subTotalPrice;
	}

	public void setSubTotalPrice(double subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}

	public OrderItem() {
		super();
	}

}
