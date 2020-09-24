package swingy.util.database;

import java.sql.*;

public class InventoryManagement {
	public static void addItem(String heroName, String itemName, String affectedStat, int statValue) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement pStatement = null;
		PreparedStatement fetchInventory = null;
		ResultSet rSet = null;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connection established");
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Checking database status");

			String sql =
				"INSERT INTO inventory " +
				"(heroName, itemName, affectedStat, statValue)" +
				"VALUES(?, ?, ?, ?)";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, heroName);
			preparedStatement.setString(2, itemName);
			preparedStatement.setString(3, affectedStat);
			preparedStatement.setInt(4, statValue);
			preparedStatement.execute();

			String currInv = "SELECT inventory FROM heroes WHERE heroName = ?";
			fetchInventory = conn.prepareStatement(currInv);
			fetchInventory.setString(1, heroName);
			rSet = fetchInventory.executeQuery();
			rSet.next();
			int currentInventory = rSet.getInt(1);
			currentInventory += 1;
			System.out.println(currentInventory);

			String updateInv = "UPDATE heroes " +
			"SET inventory = ? " +
			"WHERE heroName = ?";
			pStatement = conn.prepareStatement(updateInv);
			pStatement.setInt(1, currentInventory);
			pStatement.setString(2, heroName);
			pStatement.executeUpdate();

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
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
}
