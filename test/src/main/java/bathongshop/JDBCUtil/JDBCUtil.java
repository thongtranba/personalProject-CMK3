package bathongshop.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	//localhost
	private static String jdbcURL = "jdbc:mysql://localhost:3306/bathongshop?useSSL=false";
	private static String jdbcUsername = "bathong";
	private static String jdbcPassword = "123123";
	
	//digitalOcean 
//	private static String jdbcURL = "jdbc:mysql://db-mysql-bathongshop-do-user-13241251-0.b.db.ondigitalocean.com:25060/bathongshop?useSSL=false";
//	private static String jdbcUsername = "doadmin";
//	private static String jdbcPassword = "AVNS_uDp9UhuFWJQLdR-OqdU";

	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
