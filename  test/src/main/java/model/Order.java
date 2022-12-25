package model;

public class Order {
	private int id;
	private int userId;
	private String createdDate;
	private String productName;
	private double totalPrice;

	public Order(int id, int userId, String createdDate, String productName, double totalPrice) {
		super();
		this.id = id;
		this.userId = userId;
		this.createdDate = createdDate;
		this.productName = productName;
		this.totalPrice = totalPrice;
	}

	public Order() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
