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
		logger.info(getConnection());
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(PublicConstant.jdbcURL, PublicConstant.jdbcUsername,
					PublicConstant.jdbcPassword);
		} catch (SQLException e) {
			logger.info(PublicConstant.LOG_INFO, e);
			logger.warn(PublicConstant.LOG_WARN, e);
			logger.debug(PublicConstant.LOG_DEBUG, e);
			logger.error(PublicConstant.LOG_ERROR, e);
		} catch (ClassNotFoundException e) {
			logger.info(PublicConstant.LOG_INFO, e);
			logger.warn(PublicConstant.LOG_WARN, e);
			logger.debug(PublicConstant.LOG_DEBUG, e);
			logger.error(PublicConstant.LOG_ERROR, e);
		}
		return connection;
	}
}
