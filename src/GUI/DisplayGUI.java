package GUI;

import Java.*;

import java.awt.event.*;
import javax.swing.*;

public class DisplayGUI extends Panel implements ActionListener// extends JFrame implements ActionListener
{
	private PanelManager pm;
	private Helper help = Helper.getInstance();
	JPanel buttonPanel;
	JButton remaingModulesButton, viewResultsButton, exitButton;

	static String[] line2 = new String[2];
	
	/*TODO :
	 * make method to create a button and have it increment the location of the buttons
	 * and have some way of defining what to do with them  
	 *  */
	public DisplayGUI()
	{
		this.panel = new JPanel();
		createAndShowGUI();
	}

	private void createAndShowGUI()
	{
		
		if(help.getUser().getaccesslvl().equals("1")){
			JFrame frame = new JFrame("Customer GUI");

			//Create and set up the content pane.
			frame.setContentPane(this.createContentPane());

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setSize(405, 130);
			frame.setVisible(true);
		}
		/*
		if(help.getUser().getaccesslvl().equals("2"))
		{
			JFrame frame = new JFrame("Warehouse Staff GUI");

			//Create and set up the content pane.
			DisplayGUI window = new DisplayGUI();
			frame.setContentPane(window.createContentPane(accessLevel));

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setSize(405, 130);
			frame.setVisible(true);
		}
		
		if (accessLevel == 3)
		{
			JFrame frame = new JFrame("Logistics Staff GUI");

			//Create and set up the content pane.
			DisplayGUI window = new DisplayGUI();
			frame.setContentPane(window.createContentPane(accessLevel));

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setSize(405, 130);
			frame.setVisible(true);
		}
		if (accessLevel == 4)
		{
			JFrame frame = new JFrame("Manager GUI");

			//Create and set up the content pane.
			DisplayGUI window = new DisplayGUI();
			frame.setContentPane(window.createContentPane(accessLevel));

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setSize(405, 130);
			frame.setVisible(true);
		}*/
	}

	public JPanel createContentPane ()
	{

		// get the title strings 
		String[] titles =  getTitles(1);

		//Make bottom JPanel to place buttonPanel on
		this.panel.setLayout(null);

		//Make Button Panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10, 10);
		buttonPanel.setSize(380, 190);
		this.panel.add(buttonPanel);

		//Make Buttons
		remaingModulesButton = new JButton(titles[0]);
		System.out.println(titles[0]);
		remaingModulesButton.setLocation(0, 0);
		remaingModulesButton.setSize(180, 30);
		remaingModulesButton.addActionListener(this);
		buttonPanel.add(remaingModulesButton);

		viewResultsButton = new JButton(titles[1]);
		System.out.println(titles[1]);
		viewResultsButton.setLocation(190, 0);
		viewResultsButton.setSize(180, 30);
		viewResultsButton.addActionListener(this);
		buttonPanel.add(viewResultsButton);

		exitButton = new JButton("Exit");
		exitButton.setLocation(00, 40);
		exitButton.setSize(370, 30);
		exitButton.addActionListener(this);
		buttonPanel.add(exitButton);

		this.panel.setVisible(true);
		return this.panel;
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
				
				//Do action for Java.customer viewing product
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
		case 1:// Java.customer
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
	
    @Override
    public JPanel sendToWindow()
    { 
        return this.panel;
    }
	
    @Override
    public void setPanelManager(PanelManager pm)
    {
	this.pm = pm;
    }



}