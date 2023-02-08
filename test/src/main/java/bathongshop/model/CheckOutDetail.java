package bathongshop.model;

import java.util.Date;
import java.util.List;

public class CheckOutDetail {
	private List<ProductModel> orderList;
	private double subTotal;
	private double shippingFee;
	private double total;
	private Date checkOutDate;

	public CheckOutDetail() {
	}

	public List<ProductModel> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ProductModel> orderList) {
		this.orderList = orderList;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	};

}
