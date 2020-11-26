package app;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	private static final String URL = "jdbc:mysql://localhost/ufmtalg3";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	public static boolean isConectado = false;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			isConectado = true;
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
