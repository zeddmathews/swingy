package swingy.util.database;

import java.sql.*;
import java.util.ArrayList;

public class LoadHeroes {
	public static ArrayList<String> loadHeroes() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rSet = null;
		// create arraylist and return that for accessing data
		// put names into an arraylist and use that for selection
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connection established");
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Checking database");
			stmt = conn.createStatement();

			String sql = "SELECT heroName, heroClass, heroLevel, heroExp, attack, defense, hp, inventory, currentX, currentY FROM heroes";
			rSet = stmt.executeQuery(sql);
			while (rSet.next()) {
				arrayList.add(rSet.getString("heroName") + " " + rSet.getInt("heroLevel") + " " + rSet.getInt("currentX") + " " + rSet.getInt("currentY"));
			}
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
		return (arrayList);
	}

	public static ArrayList<String> loadHero(String heroName) {
		Connection conn = null;
		PreparedStatement pStatement = null;
		PreparedStatement stmt = null;
		ResultSet rSet = null;
		ResultSet resultSet = null;
		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connection established");
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Checking database");

			String sql = "SELECT heroName, heroClass, heroLevel, heroExp, attack, defense, hp, inventory FROM heroes WHERE heroName = ?";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, heroName);
			rSet = pStatement.executeQuery();
			rSet.next();

			String fetchExp = "SELECT expRequired FROM levels WHERE heroLevel = ?";
			stmt = conn.prepareStatement(fetchExp);
			int totalExp = rSet.getInt("heroLevel");
			stmt.setInt(1, totalExp);
			resultSet = stmt.executeQuery();
			resultSet.next();

			arrayList.add(rSet.getString("heroName") + " " + rSet.getString("heroClass") + " " + rSet.getInt("heroLevel"));
			arrayList.add("Exp: " + rSet.getInt("heroExp") + "/" + resultSet.getInt("expRequired"));
			arrayList.add("Atk: " + rSet.getInt("attack") + " " + "Def: " + rSet.getInt("defense") + " " + "HP: " + rSet.getInt("hp"));
			arrayList.add("Inventory: " + rSet.getInt("inventory") + "/10");
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
		return (arrayList);
	}
}
