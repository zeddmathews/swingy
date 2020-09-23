package swingy.util.database;

import java.sql.*;

public class CheckExists {
	public static boolean checkHero(String heroName) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		boolean nameFound = false;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connection established");
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Checking database status");

			String testy =
				"SELECT COUNT(*) FROM heroes WHERE heroName = ?";
			PreparedStatement pStatement = conn.prepareStatement(testy);
			pStatement.setString(1, heroName);
			ResultSet rSet = pStatement.executeQuery();
			rSet.next();
			System.out.println(rSet.getInt(1));
			if (rSet.getInt(1) > 0) {
				nameFound = true;
			}
			else {
				nameFound = false;
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
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
		return (nameFound);
	}
}
