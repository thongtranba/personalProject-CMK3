package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import JDBCUtil.JDBCUtil;
import model.Login;

public class LoginDAO {
	private static final String LOGIN_BY_USERNAME_PASSWORD = "select * from customer where username = ? and password = ? ";

	public boolean validate(Login login) throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_BY_USERNAME_PASSWORD)) {
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}