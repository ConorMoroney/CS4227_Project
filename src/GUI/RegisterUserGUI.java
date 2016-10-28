package GUI;

import SQL.Connect;
import Java.I_User;
import Java.UserFactory;
import SQL.Select;
import SQL.Insert;
import SQL.Connect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RegisterUserGUI implements  ActionListener
{
    JPanel buttonPanel;
    JButton cancelButton, registerUserButton;
	JLabel userLabel,passLabel, emailLabel, addressLabel;
	JTextField userField,passField, emailField, addressField;
	static JFrame frame = new JFrame("Register new User Screen");

    public JPanel createContentPane()
	{
        //Make bottom JPanel to place buttonPanel on
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        //Make Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(10, 10);
        buttonPanel.setSize(295, 485);
        totalGUI.add(buttonPanel);

        //Make Labels
        userLabel = GUIFactory.addLabel("Username:",0,0,80,30);
        passLabel = GUIFactory.addLabel("Password:",0,40,80,30);
        emailLabel = GUIFactory.addLabel("email:",0,80,80,30);
        addressLabel = GUIFactory.addLabel("Address:",0,120,80,30);

        buttonPanel.add(userLabel);
        buttonPanel.add(passLabel);
        buttonPanel.add(emailLabel);
        buttonPanel.add(addressLabel);

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
        cancelButton = GUIFactory.addButton("Cancel",0,160,135,30);
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        registerUserButton = GUIFactory.addButton("Register", 140,160,135,30);
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
    		
    		I_User user = userFactory.createUser("customer");
    		
    		int id = 1;
    		int accesslvl =1;
    		
    		try{
    			//Java.Connect to database
    			   Connect con = new Connect();
        		   Connection mycon =  con.getconnection();
        		   Statement mystat = mycon.createStatement();
        		   
    			//Get ID for Java.user
    			ResultSet myRe = mystat.executeQuery("select * from users");
    			while (myRe.next()){
    				id++;
    			}
    			
    			//Insert into table
    			String sql = "INSERT into users (idusers ,username,accesslvl ,password,email,address) VALUES('" 
    					 + id  + "','" + userName + "','" + accesslvl+ "','" + pass + "','" + email + "','" + address 
    						+ "');" ;
    			mystat.executeUpdate(sql);
    			
    			//ResultSet myRe = mystat.executeQuery("select * from creationary.users");
    			
    		}
    		catch(Exception exc){
    			System.out.println("Error cant connect to database");
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
    	RegisterUserGUI window = new RegisterUserGUI();
        frame = GUIFactory.makeFrame("Register User", 325, 250);
        frame.setContentPane(window.createContentPane());

    }

    public static void start()
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
