package bathongshop.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import bathongshop.constant.PublicConstant;

public class JDBCUtil {
	public static void main(String[] args) {
		System.out.println(getConnection());
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(PublicConstant.jdbcURL, PublicConstant.jdbcUsername,
					PublicConstant.jdbcPassword);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return connection;
	}
}
