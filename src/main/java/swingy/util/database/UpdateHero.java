package swingy.util.database;

import java.sql.*;

public class UpdateHero {
	public static void updateHero(
		String heroName, String heroClass, int heroLevel, int heroExp,
		int attack, int defense, int hp, int inventory, int x, int y) {
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			try {
				Class.forName(Database.JDBC_DRIVER);
				conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);

				String sql =
					"UPDATE heroes " +
					"SET heroLevel = ?, heroExp = ?, " +
					"attack = ?, defense = ?, hp = ?, inventory = ?, currentX = ?, currentY = ? " +
					"WHERE heroName = ?";
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, heroLevel);
				preparedStatement.setInt(2, heroExp);
				preparedStatement.setInt(3, attack);
				preparedStatement.setInt(4, defense);
				preparedStatement.setInt(5, hp);
				preparedStatement.setInt(6, inventory);
				preparedStatement.setInt(7, x);
				preparedStatement.setInt(8, y);
				preparedStatement.setString(9, heroName);
				preparedStatement.executeUpdate();
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
