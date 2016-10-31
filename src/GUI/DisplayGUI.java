package GUI;

import Java.*;

import java.awt.event.*;
import javax.swing.*;

/*  No SQL Connection in here */

public class DisplayGUI implements ActionListener// extends JFrame implements ActionListener
{

	JPanel buttonPanel;
	JButton remaingModulesButton, viewResultsButton, exitButton;

	static String[] line2 = new String[2];
	
	/*TODO :
	 * make method to create a button and have it increment the location of the buttons
	 * and have some way of defining what to do with them  
	 *  */
	public static void main(String[] line)
	{
		line2[0] = line[0];
		line2[1] = line[1];
		createAndShowGUI(line);
	}

	private static void createAndShowGUI(String[] line)
	{
		int accessLevel = Integer.parseInt(line[1]);
		if (accessLevel == 1)
		{
			//Create and set up the content pane.
			DisplayGUI window = new DisplayGUI();
			JFrame frame = GUIFactory.makeFrame("Customer GUI", 405, 130);
			frame.setContentPane(window.createContentPane(accessLevel));
		}
		if (accessLevel == 2)
		{
			//Create and set up the content pane.
			DisplayGUI window = new DisplayGUI();
			JFrame frame = GUIFactory.makeFrame("Warehouse Staff GUI", 405, 130);
			frame.setContentPane(window.createContentPane(accessLevel));
		}
		if (accessLevel == 3)
		{
			//Create and set up the content pane.
			DisplayGUI window = new DisplayGUI();
			JFrame frame = GUIFactory.makeFrame("Logistsics Staff GUI", 405, 130);
			frame.setContentPane(window.createContentPane(accessLevel));
		}
		if (accessLevel == 4)
		{
			//Create and set up the content pane.
			DisplayGUI window = new DisplayGUI();
			JFrame frame = GUIFactory.makeFrame("Manager GUI", 405, 130);
			frame.setContentPane(window.createContentPane(accessLevel));
		}
	}

	public JPanel createContentPane (int accessLevel)
	{

		// get the title strings 
		String[] titles =  getTitles(accessLevel);

		//Make bottom JPanel to place buttonPanel on
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);

		//Make Button Panel
		buttonPanel = GUIFactory.addButtonPanel(10,10,380,190);
		totalGUI.add(buttonPanel);

		//Make Buttons
		remaingModulesButton = GUIFactory.addButton(titles[0],0,0,180,30);
		remaingModulesButton.addActionListener(this);
		buttonPanel.add(remaingModulesButton);

		viewResultsButton = GUIFactory.addButton(titles[1],190,0,180,30);
		viewResultsButton.addActionListener(this);
		buttonPanel.add(viewResultsButton);

		exitButton = GUIFactory.addButton("Exit",0,40,370,30);
		exitButton.addActionListener(this);
		buttonPanel.add(exitButton);

		totalGUI.setVisible(true);
		return totalGUI;
	}
	public void actionPerformed(ActionEvent e) {
		// this makes sure the button you are pressing is the button variable
		if(e.getSource() == remaingModulesButton) {
			System.out.println("Button clicked");
			String command = ((JButton) e.getSource()).getActionCommand();
			System.out.println(command);
			switch (command) {
			case "Generate Reports":				
				//Do action for manager generating reports
				System.out.println("Got here");
				BarChart.reports();
				break;
			case "View Account Details":
				ViewAccountDetails.display(line2);
				
				//Do action for User.customer viewing product
				break;
			case "Update Product Stock":
				updateDatabase.main2();
				break;
			}

		}
		else if(e.getSource() == viewResultsButton) {
			System.out.println("Button clicked");
			String command = ((JButton) e.getSource()).getActionCommand();
			System.out.println(command);
			switch (command) {
			case "View Staff Details":
				ViewStaffDetails.main2();
		
				break;
			case "Buy Product":
				ViewItems.main(line2);
				break;
			case "Register a product":
				RegisterProductGUI.registerItem();				
				break;
			case "View Orders":
				ViewOrders.view();
				

				break;

			}
		}
		else if(e.getSource() == exitButton) {
			System.exit(0);
		}
	}

	private String[] getTitles(int accesslvl) {
		String button1 = null;
		String button2 = null;


		switch(accesslvl){
		case 1:// User.customer
			button1 = "View Account Details";
			button2 = "Buy Product";
			break;
		case 2:// wareHouse Java.Staff
			button1 = "Update Product Stock";
			button2 = "Register a product";
			break;
		case 3://Logistics Java.Staff
			button1 = "Update Product Stock";
			button2 = "View Orders";
			break;
		case 4://manager
			button1 = "Generate Reports";
			//button1.addActionListener(this);
			button2 = "View Staff Details";
			break;
		default:
			System.out.println("Error no accesslvl found");
		}
		String [] output = {button1,button2};
		return output;		
	}



}