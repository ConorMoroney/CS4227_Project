package SAMPLE1;

import GUI.GUIFactory;
import GUI.MainWindow;
import GUI.Panel;
import GUI.PanelManager;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStaffDetails extends Panel implements  ActionListener
{

    private JPanel buttonPanel;
    private JButton exitButton;

    public ViewStaffDetails(){
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
        JList items = new JList(help.getStaffDetails().toArray());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(items);
        scrollPane.setLocation(0,0);
        scrollPane.setSize(465, 400);

        buttonPanel.add(scrollPane);

        //Make buttons
        exitButton = GUIFactory.addButton("Exit",0,410,465,30);
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        //set visible and return
        this.panel.setVisible(true);
        return this.panel;
    }

    public void actionPerformed(ActionEvent e)
    {
        MainWindow.actionListener.actionPerformed(e);
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
