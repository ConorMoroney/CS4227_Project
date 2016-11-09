package SAMPLE1;

import GUI.Panel;
import GUI.PanelManager;
import SQL.Connect;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ViewAccountDetails extends Panel implements  ActionListener
{

    JPanel buttonPanel;
    JButton exitButton;

    JLabel quantityLabel, nameLabel;

    JTextField itemNameTextField, quantityTextField;
    static JFrame frame = new JFrame("View Account Details");
    static int id;


    public ViewAccountDetails(){
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