package swingy.util.database;

import java.sql.*;

public class LoadHeroes {
	public static void loadHeroes() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rSet = null;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connection established");
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Checking database");
			stmt = conn.createStatement();

			String sql = "SELECT heroName, heroClass, heroLevel, heroExp, attack, defense, hp, inventory FROM heroes";
			rSet = stmt.executeQuery(sql);
			while (rSet.next()) {
				System.out.println("Name" + rSet.getString("heroName"));
				System.out.println("Class" + rSet.getString("heroClass"));
				System.out.println("Level" +rSet.getInt("heroLevel"));
				System.out.println("Experience" +rSet.getInt("heroExp"));
				System.out.println("Attack" +rSet.getInt("attack"));
				System.out.println("Defense" +rSet.getInt("defense"));
				System.out.println("HP" +rSet.getInt("hp"));
				System.out.println("Inventory" +rSet.getInt("inventory") + "/10");
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
			try {
				if (rSet != null) {
					rSet.close();
				}
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
}
