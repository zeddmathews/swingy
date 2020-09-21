package swingy.util.database;

import java.sql.*;

public class CreateTable {
	public static void createHeroesTable() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(Database.DB_URL + "/swingy", Database.username, Database.password);
			System.out.println("Connected to database");
			stmt = conn.createStatement();

			System.out.println("Creating table \"heroes\"");
			String sql = 	"CREATE TABLE IF NOT EXISTS heroes" +
							"(" +
							"id INTEGER NOT NULL AUTO_INCREMENT" +
							"PRIMARY KEY(id)" +
							"heroName VARCHAR(255) NOT NULL" +
							"heroClass VARCHAR(255) NOT NULL" +
							"heroLevel INTEGER(10) NOT NULL" +
							"heroExp INTEGER(10)" +
							"attack INTEGER(10)" +
							"defense INTEGER(10)" +
							"hp INTEGER(10)" +
							"inventory INTEGER(10)" +
							")";
			stmt.executeUpdate(sql);
			System.out.println("Table creation complete");
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
	public static void createInventoryTable() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(Database.DB_URL + "/swingy", Database.username, Database.password);
			System.out.println("Connected to database");
			stmt = conn.createStatement();

			System.out.println("Creating table \"inventory\"");
			String sql = 	"CREATE TABLE IF NOT EXISTS inventory" +
							"(" +
							"id INTEGER NOT NULL AUTO_INCREMENT" +
							"PRIMARY KEY(id)" +
							"heroName VARCHAR(255) NOT NULL" +
							"itemName VARCHAR(255) NOT NULL" +
							"affectedStat VARCHAR(255) NOT NULL" +
							"statValue INTEGER(10)" +
							"inventory INTEGER(10)" +
							")";
			stmt.executeUpdate(sql);
			System.out.println("Table creation complete");
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
