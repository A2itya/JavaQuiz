import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class RegistrationForm 
{
	JFrame f;
	JLabel l,l1,l2,l3,l4,l5,l6;
	JTextField t,t1,t2,t3,t4,t5;
	Connection con = null;
	Statement stmt;
		 
    public RegistrationForm()
	 {
		 f = new JFrame();
		 f.setTitle("Registration Form");
		 f.setSize(500,500);
		 f.setLayout(null);
		 
		 l = new JLabel("Registration");
		 l.setBounds(30,30,100,40);
		 f.add(l);
		 
		 l1 = new JLabel("Full name");
		 l1.setBounds(30,80,100,40);
		 f.add(l1);
		 
		 t = new JTextField();
		 t.setBounds(160, 80, 100, 40);
		 f.add(t);
		 
		 l2 = new JLabel("Address");
		 l2.setBounds(30,130,100,40);
		 f.add(l2);
		 
		 t1 = new JTextField();
		 t1.setBounds(160, 130, 100, 40);
		 f.add(t1);
		 
		 l3 = new JLabel("Email id");
		 l3.setBounds(30,180,100,40);
		 f.add(l3);
		 
		 t2 = new JTextField();
		 t2.setBounds(160, 180, 100, 40);
		 f.add(t2);
		 
		 l4 = new JLabel("Contact No.");
		 l4.setBounds(30,230,100,40);
		 f.add(l4);
		 
		 t3 = new JTextField();
		 t3.setBounds(160, 230, 100, 40);
		 f.add(t3);
		 
		 l5 = new JLabel("Username:");
		 l5.setBounds(30, 280, 100, 40);
		 f.add(l5);
		 
		 t4 = new JTextField();
		 t4.setBounds(160, 280, 100, 40);
		 f.add(t4);
		 
		 l6 = new JLabel("Password:");
		 l6.setBounds(30, 330, 100, 40);
		 f.add(l6);
		 
		 JPasswordField p = new JPasswordField();
		 p.setBounds(160, 330, 100, 40);
		 f.add(p);
		 
		 JButton btn = new JButton("Register");
    	 btn.setBounds(30, 400, 100, 40);
    	 f.add(btn);
		 
    	 JButton btn1 = new JButton("Login");
    	 btn1.setBounds(120, 400, 100, 40);
    	 f.add(btn1);
    	 
         btn.addActionListener(new ActionListener()
        		 {
             	
        		 

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
			          String username = t4.getText().toString();
			          String Fullname = t.getText().toString();
			          String Address = t1.getText().toString();
			          String ContactNo = t3.getText().toString();
			          String EmailId = t2.getText().toString();
        	          char pass[]= p.getPassword();
        	          String  password = new String(pass);
        	          
        	          try
        	          {
        	        	  Class.forName("com.mysql.jdbc.Driver");
        	        	  con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/RIT", "root", "");
        	              stmt = con.createStatement();
        	              stmt.executeUpdate("insert into user values('"+Fullname+"','"+Address+"','"+EmailId+"','"+ContactNo+"','"+username+"','"+password+"')");
        	              JOptionPane.showMessageDialog(f, "Registered Successfully");
        	              
        	          }
        	          catch(ClassNotFoundException e1)
        	          {
        	        	  e1.printStackTrace();
        	          } 
        	          catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	          finally
        	          {
        	        	  try {
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        	          }
				
        		 
				}
        		 });
         

         btn1.addActionListener(new ActionListener()
        		 {
             	
     
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new LoginForm();
					f.dispose();
				}
				});		
				
         
    	 f.setVisible(true);
    	 
	 } 
       
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
          RegistrationForm r = new RegistrationForm(); 
        
	}
	 }
 

	