package pack1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class jdbc_oracle {
	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			Statement stmt = con.createStatement();
			Scanner sc = new Scanner(System.in);
			int ch;
			do{
				System.out.println("1]Dispaly\n2]Update\n3]Insert\n4]Delete: ");
				int choice = sc.nextInt();
				switch (choice){
				case 1:
					ResultSet rs = stmt.executeQuery("select * from employee_2");
					while (rs.next()){
						System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3)+ " " + rs.getInt(4) + " " + rs.getInt(5));
					}
					break;
				case 2:
					System.out.println("Enter employee id: ");
					int id = sc.nextInt();
					System.out.println("Enter new salary: ");
					int sal = sc.nextInt();
					int count = stmt.executeUpdate("update employee_2 set salary="+sal+" where employee_id ="+id);
					System.out.println(count + " Salary successfully incremented!!");
					break;
				case 3:
					System.out.println("Enter employee id: ");
					int id1 = sc.nextInt();
					System.out.println("Enter employee first name: ");
					sc.nextLine();
					String name1 = sc.nextLine();
					System.out.println("Enter employee last name: ");
					String name2 = sc.nextLine();
					System.out.println("Enter salary: ");
					int sal1 = sc.nextInt();
					System.out.println("Enter department id: ");
					int d1 = sc.nextInt();
					int count1 = stmt.executeUpdate("insert into employee_2 values ( "+id1+" , '"+name1+"' , '"+name2+"' , "+sal1+" , "+d1+")");
					System.out.println(count1 + " Data inserted successfully!!");
					break;
				case 4:
					System.out.println("Enter employee id: ");
					int id2 = sc.nextInt();
					int count2 = stmt.executeUpdate("delete from employee_2 where employee_id = "+id2);
					System.out.println(count2 + " Data deleted successfully!!");
					break;
				}
				System.out.println("Press 1 to continue: ");
				ch = sc.nextInt();
			}while(ch == 1);
			con.close();
			sc.close();
		}
		catch (Exception e){
			e.toString();
		}
	}
}