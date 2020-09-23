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

			String sql = "SELECT heroName, heroClass, heroLevel, heroExp, attack, defense, hp, inventory FROM heroes";
			rSet = stmt.executeQuery(sql);
			while (rSet.next()) {
				arrayList.add(rSet.getString("heroName") + " " + rSet.getInt("heroLevel"));
				// System.out.println(
				// 	"Name " + rSet.getString("heroName") +
				// 	"\tClass " + rSet.getString("heroClass") +
				// 	"\tLevel " +rSet.getInt("heroLevel") +
				// 	"\tExperience " +rSet.getInt("heroExp") +
				// 	"\tAttack " +rSet.getInt("attack") +
				// 	"\tDefense " +rSet.getInt("defense") +
				// 	"\tHP " +rSet.getInt("hp") +
				// 	"\tInventory " +rSet.getInt("inventory") + "/10"
				// );
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
}
