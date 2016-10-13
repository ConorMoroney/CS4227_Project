package Java;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ViewOrders implements  ActionListener
{
	
	JPanel buttonPanel;
	JButton exitButton;
	
	JLabel quantityLabel, nameLabel;

	JPanel totalGUI = new JPanel();
	
	JTextField itemNameTextField, quantityTextField;
	static JFrame frame = new JFrame("View Order Queue");


	
	public JPanel createContentPane()
	{
		//Make bottom JPanel to place buttonPanel on
		//JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);

		//Make Button Panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10, 10);
		buttonPanel.setSize(295, 185);
		totalGUI.add(buttonPanel);
		int i = 0;
		
		//get number of rows returned
		try
		{
			//Java.Connect to database
			   Connect con = new Connect(); 
    		   Connection mycon =  con.getconnection();
    		   Statement mystat = mycon.createStatement();
			ResultSet myRe = mystat.executeQuery("select * from items");




			//get db data
			while (myRe.next())
				i++;
		}
		catch(Exception exc)
		{
			System.out.println("Database error");
		}
		
		
		//Assign values to listData based on DB values.
		Object[] listData = new Object[i];
		
		i = 0;
		try
		{
			//get array of names/quantities
			//Java.Connect to database
			 Connect con = new Connect(); 
  		   Connection mycon =  con.getconnection();
  		   Statement mystat = mycon.createStatement();		
			String sql = "select * from orderqueue";
			System.out.println(sql);
			ResultSet myRe = mystat.executeQuery(sql);
			
			String name = "";
			String qty = "";
			String customer = "";
				
			//get db data
			while (myRe.next())
			{							
				name = "Java.Product Name: " + myRe.getString(1) + ", ";
				qty = "Quantity:  " +  myRe.getInt(2) + ", ";
				customer = "Customer:  " +  myRe.getString(3) + ", ";
													
				listData[i] =name + qty + customer;
				
				i++;
			}
		}
		catch(Exception exc)
		{
			System.out.println("Database error");
		}
		

		
		//Make List and scroll pane for items
		JList items = new JList(listData);
		
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setViewportView(items);
	    scrollPane.setLocation(0,0);
	    scrollPane.setSize(270, 150);
	    
	    buttonPanel.add(scrollPane);

		
	    //Make buttons
		exitButton = new JButton("Exit");
		exitButton.setLocation(0, 150);
		exitButton.setSize(85, 30);
		exitButton.addActionListener(this);
		buttonPanel.add(exitButton);
		

		
		
		
		

		totalGUI.setVisible(true);


		try
		{	
			//Java.Connect to database
			   Connect con = new Connect(); 
    		   Connection mycon =  con.getconnection();
    		   Statement mystat = mycon.createStatement();
			
			String sql = "select * from users";
			ResultSet myRe = mystat.executeQuery(sql);

			//get db data
			while (myRe.next())
			{
				System.out.println(myRe.getString(2));
				System.out.println(myRe.getString(4));
				System.out.println(myRe.getString(6));
			}
		}

		catch(Exception exc)
		{
			System.out.println("Error");
		}

		return totalGUI;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == exitButton)
		{
			frame.dispose();
		}
		
	}

	private static void createAndShowGUI()
	{
		//Create and set up the content pane.
		ViewOrders window = new ViewOrders();
		frame.setContentPane(window.createContentPane());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(305, 240);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void view()
	{		
		
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				createAndShowGUI();
			}
		});
	}


}
