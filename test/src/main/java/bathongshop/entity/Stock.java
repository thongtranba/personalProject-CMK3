package bathongshop.entity;

public class Stock {
	private int productId;
	private int warehouseId;
	private int quantity;

	public Stock(int productId, int warehouseId, int quantity) {
		super();
		this.productId = productId;
		this.warehouseId = warehouseId;
		this.quantity = quantity;
	}

	public Stock() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
