package swingy.util.database;

import java.sql.*;

public class CreateTable {
	public static void createHeroesTable() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Connected to database");
			stmt = conn.createStatement();

			System.out.println("Creating table \"heroes\"");
			String sql = 	"CREATE TABLE IF NOT EXISTS heroes" +
							"(" +
							"id INTEGER NOT NULL AUTO_INCREMENT, " +
							"PRIMARY KEY(id), " +
							"heroName VARCHAR(255) NOT NULL, " +
							"heroClass VARCHAR(255) NOT NULL, " +
							"heroLevel INTEGER(10) NOT NULL, " +
							"heroExp INTEGER(10), " +
							"attack INTEGER(10), " +
							"defense INTEGER(10), " +
							"hp INTEGER(10), " +
							"inventory INTEGER(10), " +
							"currentX INTEGER(10), " +
							"currentY INTEGER(10)" +
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
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Connected to database");
			stmt = conn.createStatement();

			System.out.println("Creating table \"inventory\"");
			String sql = 	"CREATE TABLE IF NOT EXISTS inventory" +
							"(" +
							"id INTEGER NOT NULL AUTO_INCREMENT, " +
							"PRIMARY KEY(id), " +
							"heroName VARCHAR(255) NOT NULL, " +
							"itemName VARCHAR(255) NOT NULL, " +
							"affectedStat VARCHAR(255) NOT NULL, " +
							"statValue INTEGER(10)" +
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
	public static void createLevelsTable() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Connected to database");
			stmt = conn.createStatement();

			System.out.println("Creating table \"levels\"");
			String sql = 	"CREATE TABLE IF NOT EXISTS levels" +
							"(" +
							"id INTEGER NOT NULL AUTO_INCREMENT, " +
							"PRIMARY KEY(id), " +
							"heroLevel INTEGER(10) NOT NULL, " +
							"expRequired INTEGER(10) NOT NULL, " +
							"expGained INTEGER(10) NOT NULL" +
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
	public static void validateLevelsTable() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rSet = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName(Database.JDBC_DRIVER);
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(Database.DB_URL + "swingy", Database.username, Database.password);
			System.out.println("Connected to database");
			stmt = conn.createStatement();

			System.out.println("Validating table \"levels\"");
			String sql = "SELECT COUNT(*) FROM levels";
			rSet = stmt.executeQuery(sql);
			rSet.next();
			int results = rSet.getInt(1);
			if (results == 0) {
				sql =
				"INSERT INTO levels" +
				"(heroLevel, expRequired, expGained)" +
				"VALUES(?, ?, ?)";
				preparedStatement = conn.prepareStatement(sql);
				for (int i = 1; i <= 10; i++) {
					int base = i - 1, exponent = 2;

					int result = 1;

					while (exponent != 0)
					{
						result *= base;
						--exponent;
					}
					int formula = i * 1000 + (result) * 450;
					// level*1000+(level − 1)2*450
					preparedStatement.setInt(1, i);
					preparedStatement.setInt(2, formula);
					preparedStatement.setInt(3, formula/4);
					preparedStatement.execute();
				}
			}
			System.out.println("Table validation complete");
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
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
}
