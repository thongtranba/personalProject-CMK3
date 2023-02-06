package bathongshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bathongshop.constant.PublicConstant;
import bathongshop.entity.OrderItem;
import bathongshop.jdbcutil.JDBCUtil;

public class OrderItemDAO {
	private static Logger logger = LogManager.getLogger(OrderItemDAO.class);
	private static OrderItemDAO orderItemDAO = null;

	public static OrderItemDAO getOrderItemDAO() {
		if (orderItemDAO == null) {
			orderItemDAO = new OrderItemDAO();
		}
		return orderItemDAO;
	}
	public void addOrderItem(OrderItem orderItem) throws SQLException {
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.INSERT_ORDER_ITEM)) {
			logger.info(preparedStatement);
			preparedStatement.setInt(1, orderItem.getOrderId());
			preparedStatement.setInt(2, orderItem.getProductId());
			preparedStatement.setInt(3, orderItem.getQuantity());
			preparedStatement.execute();
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
	}
}
