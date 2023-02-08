package bathongshop.entity;

import java.sql.Date;

public class Order {
	private int id;
	private int customerId;
	private Date createdDate;
	private String paymentStatus;
	private static Order order = null;

	public static Order newOrderByCustomerId(int customerId) {
		if (order == null) {
			order = new Order(customerId);
		}
		return order;
	}

	public Order(int id, int customerId, Date createdDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.createdDate = createdDate;

	}

	public Order(int customerId) {
		super();
		this.customerId = customerId;

	}

	public Order(int id, Date createdDate, String paymentStatus) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.paymentStatus = paymentStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
