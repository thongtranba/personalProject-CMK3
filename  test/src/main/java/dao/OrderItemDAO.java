package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import JDBCUtil.JDBCUtil;
import model.OrderItem;


public class OrderItemDAO {
	private static final String INSERT_ORDER_ITEM = "INSERT orderItem (orderId, productId) VALUES (?, ?)";

	public void addOrderItem(OrderItem orderItem) throws SQLException {

		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_ITEM)) {
			System.out.println(preparedStatement);
			preparedStatement.setInt(1, orderItem.getOrderId());
			preparedStatement.setInt(2, orderItem.getProductId());
			preparedStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
