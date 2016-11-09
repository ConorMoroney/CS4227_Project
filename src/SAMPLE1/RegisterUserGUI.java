package SAMPLE1;

import GUI.GUIFactory;
import GUI.Panel;
import GUI.PanelManager;
import User.I_Customer;
import User.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RegisterUserGUI extends Panel implements  ActionListener
{
    JPanel buttonPanel;
    JButton cancelButton, registerUserButton;
    private final String [] userTypes = {"Manager", "Logistics" , "Warehouse" , "Customer"};
    JLabel userLabel,TypeLabel, passLabel, emailLabel, addressLabel;
    private final JComboBox userType = new JComboBox(userTypes);
    JTextField userField,passField, emailField, addressField;

    public RegisterUserGUI(){
        this.panel = new JPanel();
        createAndShowGUI();
    }

    public JPanel createContentPane()
    {
        //Make bottom JPanel to place buttonPanel on
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

        //Make Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(10, 10);
        buttonPanel.setSize(295, 485);

        this.panel.add(buttonPanel);

        //Make Labels
        userLabel = GUIFactory.addLabel("Username:",0,0,80,30);
        passLabel = GUIFactory.addLabel("Password:",0,40,80,30);
        emailLabel = GUIFactory.addLabel("email:",0,80,80,30);
        addressLabel = GUIFactory.addLabel("Address:",0,120,80,30);
        TypeLabel = GUIFactory.addLabel("Employee Type:",0,160,80,30);

        buttonPanel.add(userLabel);
        buttonPanel.add(passLabel);
        buttonPanel.add(emailLabel);
        buttonPanel.add(addressLabel);
        buttonPanel.add(TypeLabel);

        userType.setLocation(110, 160);
        userType.setSize(180, 30);
        buttonPanel.add(userType);

        //Make texts fields
        userField = GUIFactory.addTextField(110,0,180,30);
        passField = GUIFactory.addPasswordField(110,40,180,30);
        emailField = GUIFactory.addTextField(110,80,180,30);
        addressField = GUIFactory.addTextField(110,120,180,30);

        buttonPanel.add(userField);
        buttonPanel.add(passField);
        buttonPanel.add(emailField);
        buttonPanel.add(addressField);

        //Make Buttons
        cancelButton = GUIFactory.addButton("Cancel",145,190,135,30);
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        registerUserButton = GUIFactory.addButton("Register", 0,190,135,30);
        registerUserButton.addActionListener(this);
        buttonPanel.add(registerUserButton);

        this.panel.setVisible(true);
        return this.panel;
    }

    public void actionPerformed(ActionEvent e)
    {
        Main.actionListener.actionPerformed(e);
        if(e.getSource() == cancelButton)
        {
            panelMgr.getPanelFromFactory(1);
        }

        else if(e.getSource() == registerUserButton)
        {

            if(userField.getText().equals("") ||passField.getText().equals("") ||emailField.getText().equals("") ||addressField.getText().equals("") ){
                JOptionPane.showMessageDialog(null,"There is a null field" );
                return;
            }

            String userName = userField.getText();
            String pass = passField.getText();
            String email = emailField.getText();
            String address = addressField.getText();

            int count = userType.getItemCount();
            String selectedType = (String) userType.getSelectedItem();
            int accesslvl = 1;


            //UserFactory userFactory = new UserFactory();
            if(selectedType.equalsIgnoreCase("Customer")) {
                AbstractUserFactory custFactory = FactoryProducer.getFactory("Customer");
                I_Customer cust1 = (I_Customer) custFactory.createUser("Customer");


                try {
                    int id = help.registerUser(userName, accesslvl, pass, email, address);
                    cust1.setName(userName);
                    cust1.setPassword(pass);
                    cust1.setEmail(email);
                    cust1.setAddress(address);
                    cust1.setID(id);
                    help.setCustomer(cust1);
                    panelMgr.getPanelFromFactory(2);
                } catch (Exception exc) {
                    System.out.println(exc.fillInStackTrace());
                }
            }
            else{
                AbstractUserFactory empFactory = FactoryProducer.getFactory("Employee");
                I_Employee emp1 = (I_Employee) empFactory.createUser(selectedType);
                emp1.setType(selectedType);
                //ConcreteEmployee emp1 = empFactory.
                accesslvl = emp1.getaccesslvl();
                try {
                    int id = help.registerUser(userName, accesslvl, pass, email, address);
                    emp1.setName(userName);
                    emp1.setPassword(pass);
                    emp1.setEmail(email);
                    emp1.setAddress(address);
                    emp1.setID(id);
                    help.setEmployee(emp1);
                    panelMgr.getPanelFromFactory(2);
                } catch (Exception exc) {
                    System.out.println(exc.fillInStackTrace());
                }
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