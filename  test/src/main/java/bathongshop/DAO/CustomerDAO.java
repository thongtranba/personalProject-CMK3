package bathongshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bathongshop.JDBCUtil.JDBCUtil;
import bathongshop.entity.Customer;

public class CustomerDAO {
	private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer"
			+ "  (username, password, mobile, email, address) VALUES " + " (?, ?, ?, ?, ?);";

	private static final String SELECT_CUSTOMER_BY_ID = "select id, username, password, mobile, email, address from customer where id =?";
	private static final String SELECT_ALL_CUSTOMER = "select * from customer";
	private static final String DELETE_CUSTOMER_SQL = "delete from customer where id =?;";
	private static final String UPDATE_CUSTOMER_SQL = "update customer set username =?, password=?, mobile=?, email=?, address =? where id =?;";


	public int insertCustomer(Customer customer) throws SQLException {
		System.out.println(INSERT_CUSTOMER_SQL);
		int result = 0;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
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
				PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
			statement.setString(1, customer.getUsername());
			statement.setString(2, customer.getPassword());
			statement.setString(3, customer.getMobile());
			statement.setString(4, customer.getEmail());
			statement.setString(5, customer.getAddress());
			statement.setInt(6, customer.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public boolean deleteCustomer(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public Customer selectCustomer(int id) {
		Customer customer = null;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String address = rs.getString("address");
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
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String address = rs.getString("address");
				customers.add(new Customer(id, username, password, mobile, email, address));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

}
