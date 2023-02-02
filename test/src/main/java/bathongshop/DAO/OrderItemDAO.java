package bathongshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bathongshop.JDBCUtil.JDBCUtil;
import bathongshop.constant.PublicConstant;
import bathongshop.entity.OrderItem;

public class OrderItemDAO {

	public void addOrderItem(OrderItem orderItem) throws SQLException {
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.INSERT_ORDER_ITEM)) {
			System.out.println(preparedStatement);
			preparedStatement.setInt(1, orderItem.getOrderId());
			preparedStatement.setInt(2, orderItem.getProductId());
			preparedStatement.setInt(3, orderItem.getQuantity());
			preparedStatement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
