import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Quiz 
{
	
	JFrame f;
	JLabel l;
	JRadioButton r1,r2,r3,r4;
	ButtonGroup bg;
	JButton b,b1;
	ResultSet rs;
	int count =0 ;
	
	public Quiz()
	{
		f = new JFrame();
		f.setTitle("Quiz");
		f.setSize(500,500);
		f.setLayout(null);
		
		l = new JLabel("Q1.Who is the Founder of Java?");
		l.setBounds(30, 40, 400, 40);
		f.add(l);
		
		r1=new JRadioButton("James Gosling");    
		r2=new JRadioButton("Arthur van Hoff"); 
		r3=new JRadioButton("Bruno Souza");
		r4=new JRadioButton("Rod Johnson");
		
		r1.setBounds(30,100,300,40);    
		r2.setBounds(30,140,300,40);
		r3.setBounds(30,180,300,40);
		r4.setBounds(30,220,300,40);
		bg = new ButtonGroup();    
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		f.add(r1);
		f.add(r2);
		f.add(r3);
		f.add(r4);
		
		b = new JButton("Next");
		b.setBounds(30, 270, 100, 40);
		f.add(b);
		
		b1 = new JButton("Answer");
		b1.setBounds(150, 270, 100, 40);
		f.add(b1);
		
		b.addActionListener(new ActionListener()
		 {
    	
		 

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
	          
	          Connection con = null;
			try
	          {
	        	  Class.forName("com.mysql.jdbc.Driver");
	        	  con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/quiz", "root", "");
	              Statement stmt = con.createStatement();
	               
	              
	              String qual = "";
	              String username = "question-1";
	              	  			
	  			  if (r1.isSelected())
	  			{
	  				qual = "James Gosling";
	  			}
	  			else if (r2.isSelected())
	  			{
	  				qual = "Arthur van Hoff";
	  			}
	  			else if (r3.isSelected())
	  			{
	  				qual = "Bruno Souza";
	  			}
	  			else if (r4.isSelected())
	  			{
	  				qual = "Rod Johnson";
	  			}
	  		 
	  			
	  			stmt.executeUpdate("insert into submittedanswer values('"+username+"','"+qual+"')");
	  			rs = stmt.executeQuery("select * from answer");
				
				while(rs.next()) 
				{
					if (username.equals(rs.getString(1)) && qual.equals(rs.getString(2))  ) 
					{
						count = count + 1 ;
						JOptionPane.showMessageDialog(f, "Correct answer");

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
		
			f.dispose();
			new Quiz1();
		}
		 });
         
		b1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				
				JOptionPane.showMessageDialog(f, "Answer : James Gosling");
			}
		});
		
		
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Quiz Q = new Quiz();
	}
	
}
