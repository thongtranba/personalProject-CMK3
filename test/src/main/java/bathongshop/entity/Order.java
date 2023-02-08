package bathongshop.entity;

import java.sql.Date;

public class Order {
	private int id;
	private int customerId;
	private Date createdDate;
	private static Order order = null;

	public static Order getOrderByCustomerId(int id, Date createdDate) {
		if (order == null) {
			order = new Order(id, createdDate);
		}
		return order;
	}

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

	public Order() {

	}

	public Order(int id, Date createdDate) {
		super();
		this.id = id;
		this.createdDate = createdDate;
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

}
