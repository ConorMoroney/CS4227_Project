package SAMPLE1;

import GUI.GUIFactory;
import GUI.Panel;
import GUI.PanelManager;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAccountDetails extends Panel implements  ActionListener
{
    private JPanel buttonPanel;
    private JButton exitButton;

    public ViewAccountDetails(){
        this.panel = new JPanel();
        createAndShowGUI();
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
        buttonPanel.setSize(500, 500);
        this.panel.add(buttonPanel);

        //Assign values to listData based on DB values.
        String[] listData = new String[3];
        if(help.getEmployee() != null) {
            listData[0] = "Username: " + help.getEmployee().getName();
            listData[1] = "Address: " + help.getEmployee().getAddress();
            listData[2] = "Email: " + help.getEmployee().getEmail();
        }
        else if(help.getCustomer() != null){
            listData[0] = "Username: " + help.getCustomer().getName();
            listData[1] = "Address: " + help.getCustomer().getAddress();
            listData[2] = "Email: " + help.getCustomer().getEmail();
        }

        //Make List and scroll pane for items
        JList items = new JList(listData);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(items);
        scrollPane.setLocation(0,0);
        scrollPane.setSize(270, 440);
        buttonPanel.add(scrollPane);

        //Add Label
        JLabel actionsLabel = GUIFactory.addLabel("Actions:",280,0,80,30);
        buttonPanel.add(actionsLabel);

        //Make buttons
        exitButton = GUIFactory.addButton("Exit",280,410,180,30);
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        return this.panel;
    }

    public void actionPerformed(ActionEvent e)
    {
        Main.actionListener.actionPerformed(e);
        if(e.getSource() == exitButton)
        {
            panelMgr.getPanelFromFactory(2);
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