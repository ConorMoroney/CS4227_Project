package SAMPLE1;

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
	private static String username = "";
	private JPanel buttonPanel;
	private JButton exitButton;
	private JButton purchaseButton;
	private ArrayList<String> items = new  ArrayList<String>();
	
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
		buttonPanel.setSize(295, 185);
		this.panel.add(buttonPanel);

		//Make List and scroll pane for items
		this.items = help.getItems();
		JList items = new JList(this.items.toArray());

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
		nameLabel = new JLabel("Product Name:");
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
