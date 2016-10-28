package GUI;

import Java.I_User;
import Java.UserFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import SQL.Select;
import java.sql.*;
import SQL.*;

import javax.swing.*;

public class RegisterEmployeeGUI implements  ActionListener
{
	String [] employeeTypes = {"manager", "logistics" , "warehouse"};
    
	JPanel buttonPanel;
    JButton cancelButton, registerUserButton;
	JLabel TypeLabel,userLabel,passLabel, emailLabel, addressLabel;
	JComboBox userType = new JComboBox(employeeTypes);
	JTextField userField,passField, emailField, addressField;
	static JFrame frame = new JFrame("Register Employee Screen");
	

    public JPanel createContentPane()
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
        	
        	String userName = userField.getText();
        	String pass = passField.getText();
        	String email = emailField.getText();
        	String address = addressField.getText();

    		UserFactory userFactory = new UserFactory();
    		
    		I_User user = userFactory.createUser(employeeTypes[userType.getSelectedIndex()]);
    		
    		int id = 1;
    		int accesslvl = user.getaccesslvl();
    		
    		try {


                Select s = new Select("*", "users");
                ResultSet myRe = s.getResultset();

                while (myRe.next()) {
                    id++;
                }
            }
            catch(Exception exc){
                System.out.println("Error cant connect to database");
            }

            try {

                Insert i =new Insert();
                i.CreateUserInsert(id,userName,accesslvl,pass,email,address,i.getConnection());
                /*
                Connect con = new Connect();
                Connection mycon = con.getconnection();
                Statement mystat = mycon.createStatement();
                //Insert into table
                String sql = "INSERT into users (idusers ,username,accesslvl ,password,email,address) VALUES('"
                        + id + "','" + userName + "','" + accesslvl + "','" + pass + "','" + email + "','" + address
                        + "');";

                mystat.executeUpdate(sql);
                System.out.println("object added to database");*/
                //ResultSet myRe = mystat.executeQuery("select * from creationary.users");
            }
            catch(Exception exc){
                System.out.println("Error Insert Failed ??? ");
            }

    		user.setName(userName);;
    		user.setPassword(pass);
    		user.setEmail(email);
    		user.setAddress(address);
    		user.setID(id);
    		
        }
        
    }

    private static void createAndShowGUI()
	{
        //Create and set up the content pane.
    	RegisterEmployeeGUI window = new RegisterEmployeeGUI();
        frame = GUIFactory.makeFrame("Register Employee", 345, 290);
        frame.setContentPane(window.createContentPane());
    }

    public static void main(String[] args)
	{
        SwingUtilities.invokeLater(new Runnable()
		{
            public void run()
			{
                createAndShowGUI();
            }
        });
    }
    
   
}
