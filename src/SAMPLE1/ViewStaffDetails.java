package SAMPLE1;

import GUI.Panel;
import GUI.PanelManager;
import SQL.Connect;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class ViewStaffDetails extends Panel implements  ActionListener
{

	JPanel buttonPanel;
	JButton exitButton;	
	JLabel quantityLabel, nameLabel;
	JTextField itemNameTextField, quantityTextField;
	static JFrame frame = new JFrame("View Staff Details");

	public ViewStaffDetails(){
		this.panel = new JPanel();
		createAndShowGUI();

	}
	public JPanel createContentPane()
	{
		//Make bottom JPanel to place buttonPanel on
		//JPanel totalGUI = new JPanel();
		this.panel.setLayout(null);

		//Make Button Panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10, 10);
		buttonPanel.setSize(295, 185);
		this.panel.add(buttonPanel);


		//Make List and scroll pane for items
		JList items = new JList(help.getStaffDetails().toArray());

			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(items);
		scrollPane.setLocation(0,0);
		scrollPane.setSize(270, 150);
		
		
		JLabel text = new JLabel();
		text.setLocation(0,0);
		text.setSize(270, 150);
		
		
		buttonPanel.add(scrollPane);


		//Make buttons
		exitButton = new JButton("Exit");
		exitButton.setLocation(0, 150);
		exitButton.setSize(85, 30);
		exitButton.addActionListener(this);
		buttonPanel.add(exitButton);







		this.panel.setVisible(true);

		return this.panel;
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == exitButton)
		{
			frame.dispose();
			panelMgr.getPanelFromFactory(2);
		}

	}

	private void createAndShowGUI()
	{
		//Create and set up the content pane.
		frame.setContentPane(this.createContentPane());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(305, 240);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
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
