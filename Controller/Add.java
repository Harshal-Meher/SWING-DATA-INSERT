package Controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Add
{
	public static Connection connect() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/IMSC", uname = "root", pass = "abc123";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);

		return con;
	}
	
	JFrame f = new JFrame("Inventry Mangement System");

	public void add() throws SQLException, ClassNotFoundException {

		JButton add = new JButton("Add");
		add.setFont(new Font("Algerian", Font.BOLD, 17));
		add.setBounds(50, 50, 100, 40);

		Connection con = Add.connect();
		Statement st = con.createStatement();
		
		
		add.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JFrame f1 = new JFrame("Add Product");

				JTextField t1 = new JTextField();
				t1.setFont(new Font("Algerian", Font.BOLD, 17));
				t1.setBounds(50, 90, 300, 40);
				JLabel l1 = new JLabel("Product Name");
				l1.setFont(new Font("Algerian", Font.BOLD, 17));
				l1.setBounds(60, 50, 200, 40);

				JTextField t2 = new JTextField();
				t2.setFont(new Font("Algerian", Font.BOLD, 17));
				t2.setBounds(50, 180, 300, 40);
				JLabel l2 = new JLabel("Product Quantity");
				l2.setFont(new Font("Algerian", Font.BOLD, 17));
				l2.setBounds(60, 140, 200, 40);

				JTextField t3 = new JTextField();
				t3.setFont(new Font("Algerian", Font.BOLD, 17));
				t3.setBounds(50, 270, 300, 40);
				JLabel l3 = new JLabel("Per Product Rate");
				l3.setFont(new Font("Algerian", Font.BOLD, 17));
				l3.setBounds(60, 230, 200, 40);

				JButton total = new JButton("TOTAL");
				total.setFont(new Font("Algerian", Font.BOLD, 17));
				total.setBounds(50, 350, 160, 30);

				JLabel label = new JLabel("TOTAL");
				label.setFont(new Font("Algerian", Font.BOLD, 20));
				label.setBounds(60, 390, 300, 40);

				total.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						int ProductQ = Integer.parseInt(t2.getText());
						int Rate = Integer.parseInt(t3.getText());
						label.setText("TOTAL AMOUNT : " + (ProductQ * Rate));

					}
				});
				
				JButton addp = new JButton("Add Product");
				addp.setFont(new Font("Algerian", Font.BOLD, 17));
				addp.setBounds(50, 450, 160, 30);

				addp.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						String name = t1.getText();
						int ProductQ = Integer.parseInt(t2.getText());
						int Rate = Integer.parseInt(t3.getText());

						try {
							int a = st.executeUpdate("Insert into imsc1 values('" + name + "'," + ProductQ + "," + Rate
									+ "," + ProductQ * Rate + ")");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(addp, "DATA -INSETED");

					}
				});
				
				JButton clear = new JButton("clear");
				clear.setFont(new Font("Algerian", Font.BOLD, 17));
				clear.setBounds(230, 450, 100, 30);
				clear.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						t1.setText("");//clear text
						t2.setText("");
						t3.setText("");
						label.setText("");
					}
				});
				
				f1.add(t1);//Textfield 1-product name
				f1.add(t2);//Textfield 2-product quantity
				f1.add(t3);//Textfield 3-per product Rate
				
				f1.add(total);//total button
				f1.add(label);//total label			
				
				f1.add(l1);//label 1-product name
				f1.add(l2);//label 2-product quantity
				f1.add(l3);//label 3-per product Rate
				
				f1.add(addp);//add product
				f1.add(clear);//clear
				

				f1.setSize(500, 800);//frame size
				f1.setLayout(null);
				f1.setVisible(true);

			}
					
			});
		f.add(add);
		f.setSize(1200, 700);
		f.setLayout(null);
		f.setVisible(true);

		}	

	
	
	
	
	
	
}
