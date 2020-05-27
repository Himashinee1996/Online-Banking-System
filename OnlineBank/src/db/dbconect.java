package db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class dbconect {

	public static Connection connect() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebank", "root", "");
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return conn;
	}
}