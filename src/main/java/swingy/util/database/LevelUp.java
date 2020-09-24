package swingy.util.database;

import java.sql.*;

public class LevelUp {
	public static int fetchMapExp(int heroLevel) {
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		int mapExp = 0;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connection established");
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Checking database");

			String fetchExp = "SELECT expGained FROM levels WHERE heroLevel = ?";
			pStatement = conn.prepareStatement(fetchExp);
			pStatement.setInt(1, heroLevel);
			rSet = pStatement.executeQuery();
			rSet.next();
			mapExp = rSet.getInt(1);
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (NullPointerException npe) {
			npe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			try {
				if (rSet != null) {
					rSet.close();
				}
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return (mapExp);
	}
}
