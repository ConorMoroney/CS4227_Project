package Java;

import SQL.Select;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ViewItems implements  ActionListener
{
	
	static QtyGrabber G = new QtyGrabber();
	static String username = "";
	JPanel buttonPanel;
	JButton exitButton, purchaseButton;
	
	JLabel quantityLabel, nameLabel;

	JPanel totalGUI = new JPanel();
	
	JTextField itemNameTextField, quantityTextField;
	static JFrame frame = new JFrame("View items");

	public static QtyGrabber  getQtyGrabber(){
		return G;
	}
	
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
		int[] quantities = new int[i];
		i = 0;
		try
		{
			//get array of names/quantities
			//Java.Connect to database
			  Connect con = new Connect(); 
   		   Connection mycon =  con.getconnection();
   		   Statement mystat = mycon.createStatement();

			String sql = "select * from items";
			System.out.println(sql);


			Select s = new Select("*","items");
			ResultSet myRe = s.getResultset();

			String name = "";
			int quantity = 0;
				
			//get db data
			while (myRe.next())
			{
				name = myRe.getString(3);
				quantity = myRe.getInt(7);
				
				listData[i] = name;
				quantities[i] = quantity;
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
	    scrollPane.setSize(120, 120);
	    
	    buttonPanel.add(scrollPane);

		
	    //Make buttons
		exitButton = new JButton("Exit");
		exitButton.setLocation(0, 150);
		exitButton.setSize(85, 30);
		exitButton.addActionListener(this);
		buttonPanel.add(exitButton);
		
		purchaseButton = new JButton("Purchase");
		purchaseButton.setLocation(130, 150);
		purchaseButton.setSize(120, 30);
		purchaseButton.addActionListener(this);
		buttonPanel.add(purchaseButton);
		
		//make Labels
		nameLabel = new JLabel("Java.Product Name:");
		nameLabel.setLocation(130, 0);
		nameLabel.setSize(120, 30);
		buttonPanel.add(nameLabel);
		
		quantityLabel = new JLabel("Purchase Quantity:");
		quantityLabel.setLocation(130, 60);
		quantityLabel.setSize(120, 30);
		buttonPanel.add(quantityLabel);
		
		//Make Text fields
		itemNameTextField = new JTextField();
		itemNameTextField.setLocation(130, 25);
		itemNameTextField.setSize(120, 30);
        buttonPanel.add(itemNameTextField);
        
        quantityTextField = new JTextField();
        quantityTextField.setLocation(130, 85);
        quantityTextField.setSize(120, 30);
        buttonPanel.add(quantityTextField);
		

		totalGUI.setVisible(true);


		try
		{	
			//Java.Connect to database
			  Connect con = new Connect(); 
   		   Connection mycon =  con.getconnection();
   		   Statement mystat = mycon.createStatement();
			String sql = "select * from items";
			ResultSet myRe = mystat.executeQuery(sql);

			//get db data
			while (myRe.next())
			{
				System.out.println(myRe.getString(3));
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
		if (e.getSource() == purchaseButton)
		{
			String itemName = itemNameTextField.getText();
			int orderQuantity = Integer.parseInt(quantityTextField.getText());
			
			try
			{
				//Java.Connect to database
				  Connect con = new Connect(); 
	    		   Connection mycon =  con.getconnection();
	    		   Statement mystat = mycon.createStatement();
				String sql = "select * from items WHERE name = '" + itemName + "'";
				ResultSet myRe = mystat.executeQuery(sql);
				
				myRe.next();
				System.out.println(myRe.getInt(7));
				if(orderQuantity <= myRe.getInt(7))
				{
					int newQuantity = myRe.getInt(7) - orderQuantity;
					//update table to have less quantity
					sql = "UPDATE items SET quantity = " + newQuantity + " WHERE name = '" + itemName + "'";
					mystat.executeUpdate(sql);
					
					//add order to table
					sql = "INSERT INTO orderqueue VALUES('" + itemName + "', " + orderQuantity + ", '" + username + "')";
					System.out.println(sql);
					mystat.executeUpdate(sql);
					
					frame.dispose();
					JOptionPane.showMessageDialog(null, "Order Confirmed");
				}
				else
				{
					String sql1 = "select * from users WHERE username = '" + username + "'";
					System.out.println(sql1);
					ResultSet myRe1 = mystat.executeQuery(sql1);
					myRe1.next();
					customer c = new customer(); 
					int newCustId = myRe1.getInt(1) ;
					String newCustName = myRe1.getString(2) ;
					String newCustPassword = myRe1.getString(4) ;
					String newCustEmail = myRe1.getString(5) ;
					String newCustAddress = myRe1.getString(6) ;
					
					
					c.setName(newCustName);;
		    		c.setPassword(newCustPassword);
		    		c.setEmail(newCustEmail);
		    		c.setAddress(newCustAddress);
		    		c.setID(newCustId);
					//Not enough quantity notification
					JOptionPane.showMessageDialog(null, "There is not enough quantity in stock, you have been added to a notification list");
					 
					G.registerObserver(c);
					
				
				}
				
			
				

			}
			catch(Exception exc)
			{
				System.out.println(" couldnt connect to DB 1234 ");
			}
		}

	}

	private static void createAndShowGUI()
	{
		//Create and set up the content pane.
		ViewItems window = new ViewItems();
		frame.setContentPane(window.createContentPane());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(305, 240);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		System.out.println(args[0] + "    "+ args[1]);
		username = args[0];
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				createAndShowGUI();
			}
		});
	}


}
