package bathongshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bathongshop.JDBCUtil.JDBCUtil;
import bathongshop.constant.PublicConstant;
import bathongshop.entity.Customer;

public class CustomerDAO {

	public int insertCustomer(Customer customer) throws SQLException {
		int result = Integer.parseInt(PublicConstant.CONSTANT_0);
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.INSERT_CUSTOMER_SQL)) {
			preparedStatement.setString(1, customer.getUsername());
			preparedStatement.setString(2, customer.getPassword());
			preparedStatement.setString(3, customer.getMobile());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getAddress());
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean updateCustomer(Customer customer) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(PublicConstant.UPDATE_CUSTOMER_SQL)) {
			statement.setString(1, customer.getUsername());
			statement.setString(2, customer.getPassword());
			statement.setString(3, customer.getMobile());
			statement.setString(4, customer.getEmail());
			statement.setString(5, customer.getAddress());
			statement.setInt(6, customer.getId());
			rowUpdated = statement.executeUpdate() > Integer.parseInt(PublicConstant.CONSTANT_0);
		}
		return rowUpdated;
	}

	public boolean deleteCustomer(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(PublicConstant.DELETE_CUSTOMER_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > Integer.parseInt(PublicConstant.CONSTANT_0);
		}
		return rowDeleted;
	}

	public Customer selectCustomer(int id) {
		Customer customer = null;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_CUSTOMER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String username = rs.getString(PublicConstant.USERNAME);
				String password = rs.getString(PublicConstant.PASSWORD);
				String mobile = rs.getString(PublicConstant.MOBILE);
				String email = rs.getString(PublicConstant.EMAIL);
				String address = rs.getString(PublicConstant.ADDRESS);
				customer = new Customer(id, username, password, mobile, email, address);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	public List<Customer> selectAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_ALL_CUSTOMER);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(PublicConstant.ID);
				String username = rs.getString(PublicConstant.USERNAME);
				String password = rs.getString(PublicConstant.PASSWORD);
				String mobile = rs.getString(PublicConstant.MOBILE);
				String email = rs.getString(PublicConstant.EMAIL);
				String address = rs.getString(PublicConstant.ADDRESS);
				customers.add(new Customer(id, username, password, mobile, email, address));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	public Customer validate(String email, String password) throws SQLException {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connection = JDBCUtil.getConnection();
			preparedStatement = connection.prepareStatement(PublicConstant.LOGIN_BY_USERNAME_PASSWORD);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			System.out.println(preparedStatement);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(PublicConstant.ID);
				String username = rs.getString(PublicConstant.USERNAME);
				String mobile = rs.getString(PublicConstant.MOBILE);
				String address = rs.getString(PublicConstant.ADDRESS);
				customer = new Customer(id, username, mobile, address);
			} else {

				return null;
			}
			return customer;

		} finally {
			close(connection, preparedStatement, rs);

		}
	}

	private void close(Connection connection, PreparedStatement preparedStatement, ResultSet rs) throws SQLException {
		connection.close();
		preparedStatement.close();
		rs.close();
	}

}
