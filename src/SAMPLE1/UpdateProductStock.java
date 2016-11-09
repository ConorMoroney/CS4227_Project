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
import java.util.ArrayList;

import javax.swing.*;

public class UpdateProductStock extends Panel implements  ActionListener
{
	static String username = "";

	private JPanel buttonPanel;
	private JButton exitButton, updateButton;
	private JLabel quantityLabel, nameLabel;
	private JTextField itemNameTextField, quantityTextField;
	private static final JFrame frame = new JFrame("Update Stock");
	private ArrayList<String> items = new  ArrayList<String>();

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

		//Make List and scroll pane for items
		this.items = help.getItems();
		JList items = new JList(this.items.toArray());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(items);
		scrollPane.setLocation(5,5);
		scrollPane.setSize(270, 440);

		buttonPanel.add(scrollPane);

		//Make buttons
		exitButton = GUIFactory.addButton("Exit",280,410,180,30);
		exitButton.addActionListener(this);
		buttonPanel.add(exitButton);

		updateButton = GUIFactory.addButton("Purchase",280,150,180,30);
		updateButton.addActionListener(this);
		buttonPanel.add(updateButton);

		//make Labels
		nameLabel = GUIFactory.addLabel("Product Name:",280,0,120,30);
		quantityLabel = GUIFactory.addLabel("New Quantity:",280,60,120,30);

		buttonPanel.add(nameLabel);
		buttonPanel.add(quantityLabel);

		//Make Text fields
		itemNameTextField = GUIFactory.addTextField(280,30,180,30);
		quantityTextField = GUIFactory.addTextField(280,90,180,30);

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
			int newQuantity = Integer.parseInt(quantityTextField.getText());

			try
			{
				help.updateItemQuantity(newQuantity, itemName);
				JOptionPane.showMessageDialog(null, "Product Stock Update Confirmed.");
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