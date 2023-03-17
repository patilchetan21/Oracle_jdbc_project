package pack1;
import java.sql.*;
public class Oracle_db {
	Connection con = null;
		public static Connection dbconnect() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
				return conn;
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}
	}
}
