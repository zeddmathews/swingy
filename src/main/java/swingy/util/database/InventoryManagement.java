package swingy.util.database;

import java.sql.*;
import java.util.ArrayList;

public class InventoryManagement {
	public static void addItem(String heroName, String itemName, String affectedStat, int statValue) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement pStatement = null;
		PreparedStatement fetchInventory = null;
		ResultSet rSet = null;
		try {
			Class.forName(Database.JDBC_DRIVER);
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);

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
	public static ArrayList<String> fetchItems(String heroName) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;
		ArrayList<String> items = new ArrayList<String>();
		try {
			Class.forName(Database.JDBC_DRIVER);
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);

			String sql =
				"SELECT heroName, itemName, affectedStat, statValue FROM inventory WHERE heroName = ?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, heroName);
			preparedStatement.executeQuery();
			rSet = preparedStatement.executeQuery();
			while(rSet.next()) {
				items.add(rSet.getString("heroName") + rSet.getString("itemName") + rSet.getString("affectedStat") + rSet.getInt("statValue"));
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
			try {
				if (rSet != null) {
					rSet.close();
				}
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return (items);
	}
}
