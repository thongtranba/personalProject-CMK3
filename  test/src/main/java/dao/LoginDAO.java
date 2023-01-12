package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBCUtil.JDBCUtil;
import model.Customer;

public class LoginDAO {
	private static final String LOGIN_BY_USERNAME_PASSWORD = "select * from customer where email = ? and password = ? ";

	public Customer validate(String email, String password) throws SQLException {
		Customer customer = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = JDBCUtil.getConnection();

			preparedStatement = connection.prepareStatement(LOGIN_BY_USERNAME_PASSWORD);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			System.out.println(preparedStatement);

			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
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
