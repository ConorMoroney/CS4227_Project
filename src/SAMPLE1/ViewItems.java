package SAMPLE1;

import GUI.GUIFactory;
import GUI.PanelManager;
import Java.QtyGrabber;

import GUI.Panel;
import javax.swing.*;
import User.ConcreteCustomer;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

public class ViewItems extends Panel implements  ActionListener
{
	private static final QtyGrabber G = new QtyGrabber();
	private JPanel buttonPanel;
	private JButton exitButton;
	private JButton purchaseButton;
	private ArrayList<String> items = new ArrayList<String>();
	
	private JLabel quantityLabel;
	private JLabel nameLabel;
	
	private JTextField itemNameTextField;
	private JTextField quantityTextField;

	public static QtyGrabber  getQtyGrabber(){
		return G;
	}

	public ViewItems(){
		this.panel = new JPanel();
		createAndShowGUI();
	}
	private JPanel createContentPane()
	{
		//Make bottom JPanel to place buttonPanel on
		this.panel.setLayout(null);

		//Make Button Panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10, 10);
		buttonPanel.setSize(500, 500);
		this.panel.add(buttonPanel);

		//Make List and scroll pane for items
		this.items = help.getItems();
		JList items = new JList(this.items.toArray());

	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setViewportView(items);
	    scrollPane.setLocation(0,0);
		scrollPane.setSize(270, 440);
	    
	    buttonPanel.add(scrollPane);

	    //Make buttons
		exitButton = GUIFactory.addButton("Exit",280,410,180,30);
		exitButton.addActionListener(this);
		buttonPanel.add(exitButton);

		purchaseButton = GUIFactory.addButton("Purchase",280,150,180,30);
		purchaseButton.addActionListener(this);
		buttonPanel.add(purchaseButton);

		//Add Labels
		nameLabel = GUIFactory.addLabel("Product Name:",280,0,120,30);
		buttonPanel.add(nameLabel);

		quantityLabel = GUIFactory.addLabel("Purchase Quantity:",280,60,120,30);
		buttonPanel.add(quantityLabel);
		
		//Make Text fields
		itemNameTextField = GUIFactory.addTextField(280,25,180,30);
		buttonPanel.add(itemNameTextField);

		quantityTextField = GUIFactory.addTextField(280,85,180,30);
        buttonPanel.add(quantityTextField);

		//set visible and return
		this.panel.setVisible(true);
		return this.panel;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//Main.actionListener.actionPerformed(e);
		if(e.getSource() == exitButton)
		{
			panelMgr.getPanelFromFactory(2);
		}
		if (e.getSource() == purchaseButton)
		{
			String name = "";
			int quant = 0;
			String itemName = itemNameTextField.getText();
			int orderQuantity = Integer.parseInt(quantityTextField.getText());
			for(String s : items){
				String tmp[] = s.split(":");
				if(tmp[0].equals(itemName)) {
					name = tmp[0].trim();
					quant = Integer.parseInt(tmp[1].trim());
				}
			}
			try
			{
				if(orderQuantity <= quant)
				{
					help.addOrder(itemName, orderQuantity, help.getCustomer().getName());
					help.updateItemQuantity(quant - orderQuantity, name);

					JOptionPane.showMessageDialog(null, "Order Confirmed");
				}
				else
				{
					ConcreteCustomer c = new ConcreteCustomer();
					c.setName(help.getCustomer().getName());
		    		c.setEmail(help.getCustomer().getEmail());
		    		c.setAddress(help.getCustomer().getAddress());
		    		c.setID(help.getCustomer().getID());
					//Not enough quantity notification
					JOptionPane.showMessageDialog(null, "There is not enough quantity in stock, you have been added to a notification list");
					 
					G.registerObserver(c);
				}
			}

			catch(Exception exc)
			{
				System.out.println(exc.fillInStackTrace());
				System.out.println(" couldnt connect to DB 1234 ");
			}
		}
	}

	private void createAndShowGUI()
	{
		//Create and set up the content pane.
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
