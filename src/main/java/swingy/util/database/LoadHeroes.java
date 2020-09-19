package swingy.util.database;

import java.sql.*;

public class LoadHeroes {
	public static void loadHeroes() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connection established");
			conn = DriverManager.getConnection(Database.DB_URL + "/heroes", Database.username, Database.password);
			System.out.println("Checking database");
			stmt = conn.createStatement();

			String sql = "SELECT hero";
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
