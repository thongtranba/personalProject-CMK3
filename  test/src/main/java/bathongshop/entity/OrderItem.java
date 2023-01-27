package bathongshop.entity;

public class OrderItem {
	private int id;
	private int productId;
	private int quantity;
	private int orderId;

	public OrderItem(int id, int productId, int quantity, int orderId) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public OrderItem(int productId, int quantity, int orderId) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
