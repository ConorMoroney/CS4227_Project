package SAMPLE1;

import GUI.PanelManager;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import GUI.Panel;

public class ViewOrders extends Panel implements  ActionListener
{
	
	private JPanel buttonPanel;
	private JButton exitButton;

	public ViewOrders(){
		this.panel = new JPanel();
		this.createAndShowGUI();
	}
	private JPanel createContentPane()
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
		JList items = new JList(help.getOrders().toArray());
		
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setViewportView(items);
	    scrollPane.setLocation(0,0);
	    scrollPane.setSize(270, 150);
	    
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
			panelMgr.getPanelFromFactory(2);
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
