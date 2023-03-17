package pack1;
import java.sql.*;
import java.util.Scanner;
public class o_jdbc1 {
	public static void main(String[] args) {
		        try{
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		            System.out.println("Connecting to a selected database...");
		            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		            System.out.println("Connection to the database successful...");
		            Statement stmt = con.createStatement();
		            Scanner sc = new Scanner(System.in);		            
//		            System.out.print("Enter first number- ");
//		            int a= sc.nextInt();
//		            System.out.print(a);
		            ResultSet rs = stmt.executeQuery("select * from emp");
//		            stmt.executeUpdate("update emp set age=49 where eid=101");
//		            stmt.executeInsert("insert into emp values(199,'SD',20,43000)");
		            while(rs.next()){
		                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3)+ " " + rs.getInt(4));
		            }
		            con.close();
		            sc.close();
		        }
		        catch(Exception e){
		            e.toString();
		        }
	}
}
