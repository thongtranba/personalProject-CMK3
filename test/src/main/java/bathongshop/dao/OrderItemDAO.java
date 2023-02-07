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

	public boolean addOrderItem(OrderItem orderItem) throws SQLException {
		boolean status = false;
		int result = Integer.parseInt(PublicConstant.CONSTANT_0);
		try (Connection connection = JDBCUtil.getConnection()) {
			connection.setAutoCommit(false);
			try (PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.INSERT_ORDER_ITEM)) {
				logger.info(preparedStatement);
				preparedStatement.setInt(1, orderItem.getOrderId());
				preparedStatement.setInt(2, orderItem.getProductId());
				preparedStatement.setInt(3, orderItem.getQuantity());
				result = preparedStatement.executeUpdate();
				if (result != Integer.parseInt(PublicConstant.CONSTANT_0)) {
					connection.commit();
					status = true;
				}
			} catch (Exception e) {
				connection.rollback();
				logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
			}
		}
		return status;
	}
}
