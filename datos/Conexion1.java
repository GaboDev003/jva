package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion1 {

	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/mrpets?useSSL=false&userTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

	private static final String JDBC_USER = "root";

	private static final String JDBC_PASS = "123456";

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

	}

	public static void close(ResultSet rs) throws SQLException {

		rs.close();
	}

	public static void close(PreparedStatement stmt) throws SQLException {

		stmt.close();
	}

	public static void close(Connection conn) throws SQLException {
		conn.close();
	}

}
