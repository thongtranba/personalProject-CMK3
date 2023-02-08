package bathongshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bathongshop.constant.ConstantIntegerEnum;
import bathongshop.constant.PublicConstant;
import bathongshop.entity.Customer;
import bathongshop.jdbcutil.JDBCUtil;

public class CustomerDAO {
	private static Logger logger = LogManager.getLogger(CustomerDAO.class);
	private static CustomerDAO customerDAO = null;

	public static CustomerDAO getCustomerDAO() {
		if (customerDAO == null) {
			customerDAO = new CustomerDAO();
		}
		return customerDAO;
	}

	public boolean checkDuplicatedEmailAndMobile(String email, String password) throws SQLException {
		boolean duplicated = false;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.CHECK_DUPLICATED_EMAIL_MOBILE_SQL)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			logger.info(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				duplicated = true;
			}
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
		return duplicated;
	}

	public int insertCustomer(Customer customer) throws SQLException {
		int result = ConstantIntegerEnum.CONSTANT_0.getValue();
		try (Connection connection = JDBCUtil.getConnection()) {
			connection.setAutoCommit(false);
			try (PreparedStatement preparedStatement = connection
					.prepareStatement(PublicConstant.INSERT_CUSTOMER_SQL)) {
				preparedStatement.setString(1, customer.getUsername());
				preparedStatement.setString(2, customer.getPassword());
				preparedStatement.setString(3, customer.getMobile());
				preparedStatement.setString(4, customer.getEmail());
				preparedStatement.setString(5, customer.getAddress());
				logger.info(preparedStatement);
				result = preparedStatement.executeUpdate();
				if (result != ConstantIntegerEnum.CONSTANT_0.getValue()) {
					connection.commit();
				}
			} catch (Exception e) {
				connection.rollback();
				logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
			}
		}
		return result;
	}

	public boolean updateCustomer(Customer updateCustomer, int id) throws SQLException {
		boolean status = false;
		int result = ConstantIntegerEnum.CONSTANT_0.getValue();
		try (Connection connection = JDBCUtil.getConnection()) {
			connection.setAutoCommit(false);
			try (PreparedStatement preparedStatement = connection
					.prepareStatement(PublicConstant.UPDATE_CUSTOMER_SQL)) {
				preparedStatement.setString(1, updateCustomer.getUsername());
				preparedStatement.setString(2, updateCustomer.getPassword());
				preparedStatement.setString(3, updateCustomer.getMobile());
				preparedStatement.setString(4, updateCustomer.getEmail());
				preparedStatement.setString(5, updateCustomer.getAddress());
				preparedStatement.setInt(6, id);
				result = preparedStatement.executeUpdate();
				if (result != ConstantIntegerEnum.CONSTANT_0.getValue()) {
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

	public boolean deleteCustomer(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(PublicConstant.DELETE_CUSTOMER_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > ConstantIntegerEnum.CONSTANT_0.getValue();
		}
		return rowDeleted;
	}

	public Customer selectCustomer(int id) {
		Customer customer = null;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_CUSTOMER_BY_ID);) {
			preparedStatement.setInt(1, id);
			logger.info(preparedStatement);
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
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
		return customer;
	}

	public List<Customer> selectAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_ALL_CUSTOMER);) {
			logger.info(preparedStatement);
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
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
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
			logger.info(preparedStatement);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(PublicConstant.ID);
				String username = rs.getString(PublicConstant.USERNAME);
				String mobile = rs.getString(PublicConstant.MOBILE);
				String address = rs.getString(PublicConstant.ADDRESS);
				customer = new Customer(id, username, mobile, email, address);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
		return customer;
	}
}
