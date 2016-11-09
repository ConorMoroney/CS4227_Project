package SAMPLE1;

import GUI.GUIFactory;
import GUI.Panel;
import GUI.PanelManager;

import Java.QtyGrabber;
import SQL.Connect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class UpdateProductStock extends Panel implements  ActionListener
{
	static String username = "";

	private JPanel buttonPanel;
	private JButton exitButton, updateButton;
	private JLabel quantityLabel, nameLabel;
	private JTextField itemNameTextField, quantityTextField;
	private static final JFrame frame = new JFrame("Update Stock");

	public UpdateProductStock(){
		this.panel = new JPanel();
		createAndShowGUI();
	}

	private void updateProducts(String itemName, int quantity){
		QtyGrabber G = ViewItems.getQtyGrabber();
		G.setQty(itemName , quantity);
	}

	private JPanel createContentPane()
	{
		//Make bottom JPanel to place buttonPanel on
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

		//Make Button Panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10, 10);
		buttonPanel.setSize(295, 485);

		this.panel.add(buttonPanel);

		int i = 0;

		/**
		 * TODO
		 * Change SQL code in this to match what Paul has in the other methods
		 */
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
		scrollPane.setLocation(5,5);
		scrollPane.setSize(115, 115);

		buttonPanel.add(scrollPane);

		//Make buttons
		exitButton = GUIFactory.addButton("Cancel",5,150,115,30);
		exitButton.addActionListener(this);
		buttonPanel.add(exitButton);

		updateButton = GUIFactory.addButton("Update",130,150,180,30);
		updateButton.addActionListener(this);
		buttonPanel.add(updateButton);

		//make Labels
		nameLabel = GUIFactory.addLabel("Product Name:",130,0,120,30);
		quantityLabel = GUIFactory.addLabel("Add Quantity:",130,60,120,30);

		buttonPanel.add(nameLabel);
		buttonPanel.add(quantityLabel);

		//Make Text fields
		itemNameTextField = GUIFactory.addTextField(130,30,180,30);
		quantityTextField = GUIFactory.addTextField(130,90,180,30);

		buttonPanel.add(itemNameTextField);
		buttonPanel.add(quantityTextField);

		this.panel.setVisible(true);

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

		return this.panel;
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == exitButton)
		{
			help.logoutUser();
			panelMgr.getPanelFromFactory(1);
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
			}
			catch(Exception exc)
			{
				System.out.println(" couldnt connect to DB 1234 ");
			}
		}

	}

	private void createAndShowGUI()
	{
		this.createContentPane();
	}

	@Override
	public JPanel sendToWindow()
	{
		return this.panel;
	}

	@Override
	public void setPanelManager(PanelManager pm)
	{
		this.panelMgr = pm;
	}
}