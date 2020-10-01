package swingy.util.database;

import java.sql.*;

public class InsertItems {
	public static void insertItems(
		String heroName, String itemName, String affectedStat, int statValue) {
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			try {
				Class.forName(Database.JDBC_DRIVER);
				conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);

				String sql =
				"INSERT INTO inventory" +
				"(heroName, heroClass, heroLevel, heroExp, attack, defense, hp, inventory, currentX, currentY)" +
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, heroName);
				preparedStatement.setString(2, itemName);
				preparedStatement.setString(3, affectedStat);
				preparedStatement.setInt(4, statValue);
				preparedStatement.execute();
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
	}
}
