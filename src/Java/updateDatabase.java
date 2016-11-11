package Java;

import SAMPLE1.ViewItems;
import SQL.Connect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class updateDatabase implements  ActionListener{

	static String username = "";
	private JButton exitButton;
	private JButton updateButton;

	private final JPanel totalGUI = new JPanel();

	private JTextField itemNameTextField;
	private JTextField quantityTextField;
	private static final JFrame frame = new JFrame("Update Stock");


	private void updateProducts(String itemName, int quantity){
		QtyGrabber G = ViewItems.getQtyGrabber();
		G.setQty(itemName , quantity);
	}

	private JPanel createContentPane()
	{
		//Make bottom JPanel to place buttonPanel on
		//JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);

		//Make Button Panel
		JPanel buttonPanel = new JPanel();
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
			ResultSet myRe = mystat.executeQuery("select * from creationary.items");

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

			String sql = "select * from creationary.items";
			System.out.println(sql);
			ResultSet myRe = mystat.executeQuery(sql);

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

		updateButton = new JButton("Update");
		updateButton.setLocation(130, 150);
		updateButton.setSize(120, 30);
		updateButton.addActionListener(this);
		buttonPanel.add(updateButton);

		//make Labels
		JLabel nameLabel = new JLabel("Product Name:");
		nameLabel.setLocation(130, 0);
		nameLabel.setSize(120, 30);
		buttonPanel.add(nameLabel);

		JLabel quantityLabel = new JLabel("Add Quantity:");
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
		if (e.getSource() == updateButton)
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
				int newQuantity = myRe.getInt(7) + orderQuantity;
				//update table to have less quantity
				sql = "UPDATE items SET quantity = " + newQuantity + " WHERE name = '" + itemName + "'";
				mystat.executeUpdate(sql);

				updateProducts(itemName, newQuantity);

				frame.dispose();
				JOptionPane.showMessageDialog(null, "Stock Update Confirmed");

				//do stuff here



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
		updateDatabase window = new updateDatabase();
		frame.setContentPane(window.createContentPane());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(305, 240);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main2(){
		//System.out.println(args[0] + "    " + args[1]);
		//username = args[0];
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
}