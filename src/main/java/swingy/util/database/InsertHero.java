package swingy.util.database;

import java.sql.*;

public class InsertHero {
	public static void insertHero(String heroName, String heroClass, int heroLevel, int heroExp, int attack, int defense, int hp, int x, int y) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connection established");
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Checking database status");

			String sql =
				"INSERT INTO heroes" +
				"(heroName, heroClass, heroLevel, heroExp, attack, defense, hp, inventory, currentX, currentY)" +
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, heroName);
			preparedStatement.setString(2, heroClass);
			preparedStatement.setInt(3, heroLevel);
			preparedStatement.setInt(4, heroExp);
			preparedStatement.setInt(5, attack);
			preparedStatement.setInt(6, defense);
			preparedStatement.setInt(7, hp);
			preparedStatement.setInt(8, 0);
			preparedStatement.setInt(9, x);
			preparedStatement.setInt(10, y);
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
