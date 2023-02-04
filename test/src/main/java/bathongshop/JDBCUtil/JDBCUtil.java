package bathongshop.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bathongshop.constant.PublicConstant;

public class JDBCUtil {
	private static Logger logger = LogManager.getLogger(JDBCUtil.class);

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
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
		} catch (ClassNotFoundException e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
		}
		return connection;
	}
}
