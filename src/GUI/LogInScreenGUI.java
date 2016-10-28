package GUI;

import SQL.Select;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LogInScreenGUI implements  ActionListener
{
    JPanel buttonPanel;
    JButton exitButton, logInButton, registerButton;
	JLabel userNameLabel, passwordLabel;
	JTextField userNameTextField;
	JPasswordField passwordTextField;
	JPanel totalGUI = new JPanel();
	static JFrame frame = new JFrame("Log In Screen");

    public JLabel addLabel(String labelText, int xLocation, int yLocation, int xSize, int ySize)
    {
        JLabel label = new JLabel(labelText);
        label.setLocation(xLocation, yLocation);
        label.setSize(xSize, ySize);
        buttonPanel.add(label);

        return label;
    }
    public JPanel addButtonPanel(int xLocation, int yLocation, int xSize, int ySize)
    {
        JPanel buttonPanel;
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(xLocation, yLocation);
        buttonPanel.setSize(xSize, ySize);
        totalGUI.add(buttonPanel);

        return buttonPanel;
    }

    public JButton addButton(String text, int xLocation, int yLocation, int xSize, int ySize)
    {
        JButton button;
        button = new JButton(text);
        button.setLocation(xLocation, yLocation);
        button.setSize(xSize, ySize);
        button.addActionListener(this);
        buttonPanel.add(button);

        return button;
    }

    public JTextField addTextField(int xLocation, int yLocation,int xSize, int ySize)
    {
        JTextField textField;
        textField = new JTextField();
        textField.setLocation(xLocation, yLocation);
        textField.setSize(xSize, ySize);
        buttonPanel.add(textField);

        return textField;
    }

    public JPasswordField addPasswordField(int xLocation, int yLocation,int xSize, int ySize)
    {
        JPasswordField passwordField;
        passwordField = new JPasswordField();
        passwordField.setLocation(xLocation, yLocation);
        passwordField.setSize(xSize, ySize);
        buttonPanel.add(passwordField);

        return passwordField;
    }

    public JPanel createContentPane()
	{
        //Make bottom JPanel to place buttonPanel on
        //JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        buttonPanel = addButtonPanel(10,10,295,185);

        userNameLabel = addLabel("Username:",0,0,80,30);
        passwordLabel = addLabel("Password:",0,40,80,30);

        userNameTextField = addTextField(90,0,180,30);
        passwordTextField = addPasswordField(90,40,180,30);

        exitButton = addButton("Exit",0,80,85,30);
        logInButton = addButton("Log In",93,80,85,30);
        registerButton = addButton("Register",185,80,90,30);
        
        totalGUI.setVisible(true);
        return totalGUI;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == exitButton)
        {
			System.exit(0);
			JOptionPane.showMessageDialog(null, "Register Course Director Window");
        }
        
        else if(e.getSource() == registerButton)
        {
			RegisterUserGUI.start();
        }
		
        else if(e.getSource() == logInButton)
        {

			//declare variables for username and password
			String userName = userNameTextField.getText();
			String password = passwordTextField.getText();

			//Random JOptionPane that shows username and password.
			//JOptionPane.showMessageDialog(null, userName + " " + password);

			//check if username and password exist
			try
			{
                /*
    		   Connect con = new Connect();
    		   Connection mycon =  con.getconnection();
    		   Statement mystat = mycon.createStatement();


    			//Get ID for Java.user
    			String sql = "select * from creationary..users WHERE username = '" + userName + "'";
    			ResultSet myRe = mystat.executeQuery(sql);
                */

    			String dbUser = "";
    			String dbPass = "";
                //uncomment after testing

                Select s = new Select("*","users","username",userName);
                ResultSet myRe = s.getResultset();
                System.out.print(myRe);



    			String[] line = new String [2];

    			//get db data
    			while (myRe.next()){
    			    dbUser = myRe.getString(2);
    				dbPass = myRe.getString(4);

    				line[0] = myRe.getString(2);
    				line[1] = myRe.getString(3);
    			}

    			//If Java.user/pass match, log in.
    			if (dbPass.equals(password)){
    				frame.setVisible(false);
    				DisplayGUI.main(line);

    			}
			}

			catch(Exception exc)
			{
				System.out.println("Exception");
				System.exit(0);
			}
		}
        
    }

    private static void createAndShowGUI()
	{
        //Create and set up the content pane.
        LogInScreenGUI window = new LogInScreenGUI();
        frame.setContentPane(window.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(305, 165);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
    
    private void register(){}//Decorator Pattern to be implemented here
}
