package pack1;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
public class Frame1 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField eid;
	private JTextField fname;
	private JTextField l_name;
	private JTextField salary;
	private JTextField did;
	JFrame f;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con =null;
	public Frame1() {
		con = Oracle_db.dbconnect();
	  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee id*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(74, 61, 96, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Insert Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(eid.getText()==null) {
					f=new JFrame();  
					JOptionPane.showMessageDialog(f,"Employee id must be entered!"); 
				}
				else {
					int e_eid = Integer.parseInt(eid.getText());
					String e_fname = fname.getText();
					String e_lname = l_name.getText();
					float e_sal = Float.parseFloat(salary.getText());
					int e_did = Integer.parseInt(did.getText());
					try {
						  Statement stmt=con.createStatement();  
						  int count = stmt.executeUpdate("insert into employee_2 values( "+e_eid+ " , '"+e_fname+ "' , '" +e_lname+ "' , " +e_sal+ " , " +e_did+" )");
						  JOptionPane.showMessageDialog(null,"Data inserted into database!");
						  eid.setText("");
						  fname.setText("");
						  l_name.setText("");
						  salary.setText("");
						  did.setText("");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(449, 59, 137, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(eid.getText()==null) {
					f=new JFrame();  
					JOptionPane.showMessageDialog(f,"Employee id must be entered!"); 
				}
				else {
					int e_eid = Integer.parseInt(eid.getText());
					String e_fname = fname.getText();
					String e_lname = l_name.getText();
					float e_sal = Float.parseFloat(salary.getText());
					int e_did = Integer.parseInt(did.getText());
					try {
						Statement stmt=con.createStatement();  
					    int count = stmt.executeUpdate("update employee_2 set salary= " + e_sal + " ,first_name = '"+e_fname+"' ,last_name = '"+e_lname+"' ,dept_id = "+e_did+" where employee_id="+e_eid);
						JOptionPane.showMessageDialog(null,"Data updated in database!");
						eid.setText("");
						fname.setText("");
						l_name.setText("");
						salary.setText("");
						did.setText("");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(449, 132, 137, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete data");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(eid.getText()==null) {
					f=new JFrame();  
					JOptionPane.showMessageDialog(f,"Employee id must be entered!"); 
				}
				else {
					int e_eid = Integer.parseInt(eid.getText());
					try {
						Statement stmt=con.createStatement();
						int count = stmt.executeUpdate("delete from employee_2 where employee_id = "+e_eid);
						JOptionPane.showMessageDialog(null,"Data deleted from database!");
						eid.setText("");
						fname.setText("");
						l_name.setText("");
						salary.setText("");
						did.setText("");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(449, 197, 132, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Display ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(eid.getText()==null) {
					f=new JFrame();  
					JOptionPane.showMessageDialog(f,"Employee id must be entered!"); 
				}
				else {
					int e_eid = Integer.parseInt(eid.getText());
					try {
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("select * from employee_2 where employee_id = "+e_eid);
						while (rs.next()) {
							eid.setText(Integer.toString(rs.getInt(1)));
							fname.setText(rs.getString(2));
							l_name.setText(rs.getString(3));
							salary.setText(Float.toString(rs.getFloat(4)));
							did.setText(Integer.toString(rs.getInt(5)));
						}
						con.close();
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	        
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(449, 267, 129, 34);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Display All ");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from employee_2");
					while(rs.next()) { 
						System.out.println(rs.getInt(1)+" " + rs.getString(2)+" " + rs.getString(3)+" "+rs.getInt(4)+"  "+rs.getInt(5));
					}
					con.close();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3_1.setBounds(449, 337, 129, 34);
		contentPane.add(btnNewButton_3_1);
		
		eid = new JTextField();
		eid.setBounds(193, 61, 151, 33);
		contentPane.add(eid);
		eid.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(74, 127, 87, 29);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(74, 199, 87, 29);
		contentPane.add(lblLastName);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalary.setBounds(74, 270, 87, 29);
		contentPane.add(lblSalary);
		
		JLabel lblDepartmentId = new JLabel("Department Id");
		lblDepartmentId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDepartmentId.setBounds(74, 340, 122, 29);
		contentPane.add(lblDepartmentId);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(193, 134, 151, 33);
		contentPane.add(fname);
		
		l_name = new JTextField();
		l_name.setColumns(10);
		l_name.setBounds(193, 199, 151, 33);
		contentPane.add(l_name);
		
		salary = new JTextField();
		salary.setColumns(10);
		salary.setBounds(193, 270, 151, 33);
		contentPane.add(salary);
		
		did = new JTextField();
		did.setColumns(10);
		did.setBounds(193, 340, 151, 33);
		contentPane.add(did);
	}
}
