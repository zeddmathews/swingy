package swingy.util;

import java.sql.*;

public class Database {
	private static final String username = "root";
	private static final String password = "1234";
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/";

	public static void createDB() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connection established");
			conn = DriverManager.getConnection(DB_URL, username, password);
			System.out.println("Checking database");
			stmt = conn.createStatement();

			String sql = "CREATE DATABASE IF NOT EXISTS HEROES";
			stmt.executeUpdate(sql);
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
}
