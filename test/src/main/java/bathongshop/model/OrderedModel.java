package bathongshop.model;

public class OrderedModel {
	private int productId;
	private int quantity;

//using to map from JSON data
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
