import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginForm 
{
	JFrame f;
	JLabel l,l1;
	JTextField t,t2;
	JButton b,b1;
	ResultSet rs;
	
      public LoginForm()
      {
    	 f = new JFrame();
 		 f.setTitle("Login");
 		 f.setSize(500,500);
 		 f.setLayout(null);
 		 
 		 l = new JLabel("Username");
 		 l.setBounds(40, 40, 100, 40);
 		 f.add(l);
 		 
 		 t = new JTextField();
 		 t.setBounds(160, 40, 100, 40);
 		 f.add(t);
 		 
 		 l1 = new JLabel("Password");
		 l1.setBounds(40, 90, 100, 40);
		 f.add(l1);
		 
		 JPasswordField p= new JPasswordField();
		 p.setBounds(160, 90, 100, 40);
		 f.add(p);
		 
		 b = new JButton("Login");
		 b.setBounds(40, 150, 100, 40);
		 f.add(b);
		 
		 b1 = new JButton("Cancel");
		 b1.setBounds(160, 150, 100, 40);
		 f.add(b1);
 		 
		 b.addActionListener(new ActionListener()
		 {
     	
		 

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	          String username = t.getText().toString();
	          char pass[]= p.getPassword();
	          String  password = new String(pass);
	          
	          Connection con = null;
			try
	          {
	        	  Class.forName("com.mysql.jdbc.Driver");
	        	  con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/RIT", "root", "");
	              Statement stmt = con.createStatement();
	              String dbPassword = "";
	              
					
	              if (username.equals("") || password.equals(""))
	              {
	                  JOptionPane.showMessageDialog(f, "For a successful login, you must provide both username and password", "Error", JOptionPane.ERROR_MESSAGE);
	              }
	              else 
	              {
	                  String query = "SELECT password FROM user WHERE username = '" + username + "';";
	                  try
	                  {
	                	  rs = stmt.executeQuery(query);
	                      rs.next();
	                      dbPassword = rs.getString(1);
	                  }
	                  catch (SQLException e1)
	                  {
	                      JOptionPane.showMessageDialog(f, "Something went wrong. Please try again later!");
	                  }
	                  if (password.equals(dbPassword) && !dbPassword.equals(""))
	                  {
	                      f.dispose();
	                      new Quiz();
	                  }
	                  else
	                  {
	                      JOptionPane.showMessageDialog(f, "Provided credentials are not valid. try again!", "Invalid credentials", JOptionPane.ERROR_MESSAGE);
	                  }
	              }
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
		 
		 b1.addActionListener(new ActionListener()
		 {
     	
		 

		@Override
		public void actionPerformed(ActionEvent e)
		{
		 
          t.setText("");
          p.setText("");
		}
		 
		 
	});
			
 		 f.setVisible(true);
    	  
      }
      
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
        LoginForm L = new LoginForm();
        
	}

}
 