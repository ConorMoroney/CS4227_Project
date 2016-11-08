package SAMPLE1;

import GUI.GUIFactory;
import GUI.Panel;
import GUI.PanelManager;
import Java.*;
import SAMPLE1.RegisterProductGUI;

import java.awt.event.*;
import javax.swing.*;

/*  No SQL Connection in here */

public class DisplayGUI extends Panel implements ActionListener// extends JFrame implements ActionListener
{

	JPanel buttonPanel;
	JFrame frame;
	JButton remaingModulesButton, viewResultsButton, exitButton;


	/*TODO :
	 * make method to create a button and have it increment the location of the buttons
	 * and have some way of defining what to do with them
	 *  */

	public DisplayGUI(){
		this.panel = new JPanel();
		createAndShowGUI();
	}

	private void createAndShowGUI()
	{
		frame = GUIFactory.makeFrame(help.getUserState().getFrameTitle(), 405, 130);
		frame.setContentPane(this.createContentPane());

	}

	public JPanel createContentPane ()
	{

		// get the title strings

		String[] titles =  help.getUserState().getButtonTitles();

		//Make bottom JPanel to place buttonPanel on
		this.panel.setLayout(null);

		//Make Button Panel
		buttonPanel = GUIFactory.addButtonPanel(10,10,380,190);
		this.panel.add(buttonPanel);

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
					frame.dispose();
					panelMgr.getPanelFromFactory(5);
					break;
				//ViewAccountDetails.display(line2);

				//Do action for Java.customer viewing product
				case "Update Product Stock":
					break;
			}

		}
		else if(e.getSource() == viewResultsButton) {
			System.out.println("Button clicked");
			String command = ((JButton) e.getSource()).getActionCommand();
			System.out.println(command);
			switch (command) {
				case "View Staff Details":
					panelMgr.getPanelFromFactory(6);

					break;
				case "Buy Product":
					frame.dispose();
					panelMgr.getPanelFromFactory(6);
					break;
				case "Register a product":
					RegisterProductGUI.registerItem();
					break;
				case "View Orders":
					//ViewOrders.view();


					break;

			}
		}
		else if(e.getSource() == exitButton) {
			help.logoutUser();
			frame.dispose();
			panelMgr.getPanelFromFactory(1);
		}
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