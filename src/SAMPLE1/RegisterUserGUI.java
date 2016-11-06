package SAMPLE1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.GUIFactory;

import java.sql.*;
import SQL.*;
import User.*;

import javax.swing.*;

public class RegisterUserGUI implements  ActionListener
{
	private final String [] userTypes = {"Manager", "Logistics" , "Warehouse" , "Customer"};
	private JPanel buttonPanel;
    private JButton cancelButton, registerUserButton;
	private JLabel TypeLabel, userLabel, passLabel, emailLabel, addressLabel;
	private final JComboBox userType = new JComboBox(userTypes);
	private JTextField userField, passField, emailField, addressField;
	private static JFrame frame = new JFrame("Register Employee Screen");

    private JPanel createContentPane()
	{
        //Make bottom JPanel to place buttonPanel on
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        //Make Button Panel
        buttonPanel = GUIFactory.addButtonPanel(10,10,295,485);
        totalGUI.add(buttonPanel);

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

		//Make texts fields
        userField = GUIFactory.addTextField(110,0,180,30);
        passField = GUIFactory.addPasswordField(110,40,180,30);
        emailField = GUIFactory.addTextField(110,80,180,30);
        addressField = GUIFactory.addTextField(110,120,180,30);

        buttonPanel.add(userField);
        buttonPanel.add(passField);
        buttonPanel.add(emailField);
        buttonPanel.add(addressField);
        
        userType.setLocation(110, 160);
        userType.setSize(180, 30);
        buttonPanel.add(userType);

		//Make Buttons
        cancelButton = GUIFactory.addButton("Cancel",0,200,135,30);
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        registerUserButton = GUIFactory.addButton("Register",160,200,135,30);
        registerUserButton.addActionListener(this);
        buttonPanel.add(registerUserButton);
        
        totalGUI.setVisible(true);
        return totalGUI;
    }

    public void actionPerformed(ActionEvent e)
	{
        Main.actionListener.actionPerformed(e);
        if(e.getSource() == cancelButton)
        {
        	frame.dispose();
        }
        
        else if(e.getSource() == registerUserButton)
        {
			//do shit in here
        	if(userField.getText().equals("") ||passField.getText().equals("") ||emailField.getText().equals("") ||addressField.getText().equals("") ){
        		JOptionPane.showMessageDialog(null,"There is a null field" );
        		return;
        	}
            int id = 1;
        	int accesslvl=1;
        	String userName = userField.getText();
        	String pass = passField.getText();
        	String email = emailField.getText();
        	String address = addressField.getText();




            int count = userType.getItemCount();
            String selectedType = (String) userType.getSelectedItem();

            if(selectedType.equalsIgnoreCase("Customer")){
                AbstractUserFactory custFactory = FactoryProducer.getFactory("Customer");
                I_Customer cust1 = (I_Customer) custFactory.createUser("Customer");


                cust1.setName(userName);
                cust1.setPassword(pass);
                cust1.setEmail(email);
                cust1.setAddress(address);
                cust1.setID(id);
            }
            else {
                AbstractUserFactory empFactory = FactoryProducer.getFactory("Employee");
                I_Employee emp1 = (I_Employee) empFactory.createUser(selectedType);
                emp1.setType(selectedType);
                //ConcreteEmployee emp1 = empFactory.
                accesslvl = emp1.getaccesslvl();
                emp1.setName(userName);
                emp1.setPassword(pass);
                emp1.setEmail(email);
                emp1.setAddress(address);
                emp1.setID(id);

            }



    		
    		try
            {
                //Connect c = new Connect();
                Select s = new Select("*", "users");
                ResultSet myRe = s.getResultset();

                while (myRe.next()) {
                    id++;
                }
            }

            catch(Exception exc)
            {
                System.out.println("Error cant connect to database");
            }

            try
            {

                Insert i =new Insert();
                i.CreateUserInsert(userName,accesslvl,pass,email,address,i.getConnection());
            }
            catch(Exception exc)
            {
                System.out.println("Error Insert Failed ??? ");
            }


        }
    }

    private static void createAndShowGUI()
	{
        //Create and set up the content pane.
        RegisterUserGUI window = new RegisterUserGUI();
        frame = GUIFactory.makeFrame("Register Employee", 345, 290);
        frame.setContentPane(window.createContentPane());
    }

    public static void main(String[] args)
	{
        SwingUtilities.invokeLater(RegisterUserGUI::createAndShowGUI);
    }
}
