package bathongshop.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bathongshop.JDBCUtil.JDBCUtil;
import bathongshop.constant.PublicConstant;
import bathongshop.entity.Order;

public class OrderDAO {

	public int addOrder(Order order) throws SQLException {
		int insertedId = 0;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.INSERT_NEW_ORDER,
						Statement.RETURN_GENERATED_KEYS)) {
			System.out.println(preparedStatement);
			preparedStatement.setInt(1, order.getCustomerId());
			preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
			preparedStatement.execute();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertedId;
	}

	public List<Order> selectAllOrderByCustomerId(int customerId) {
		List<Order> orders = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_ORDER_BY_CUTOMER_ID);) {
			preparedStatement.setInt(1, customerId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				Date createdDate = rs.getDate("created_date");
				orders.add(new Order(id, createdDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

}
