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

    public JPanel createContentPane()
	{
        //Make bottom JPanel to place buttonPanel on
        //JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        //Make Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(10, 10);
        buttonPanel.setSize(295, 185);
        totalGUI.add(buttonPanel);

		//Make Labels
		userNameLabel = new JLabel("Username:");
		userNameLabel.setLocation(0, 0);
        userNameLabel.setSize(80, 30);
        buttonPanel.add(userNameLabel);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setLocation(0, 40);
        passwordLabel.setSize(80, 30);
        buttonPanel.add(passwordLabel);
		
		//Username and Password Fields
		userNameTextField = new JTextField();
		userNameTextField.setLocation(90, 0);
        userNameTextField.setSize(180, 30);
        buttonPanel.add(userNameTextField);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setLocation(90, 40);
        passwordTextField.setSize(180, 30);
        buttonPanel.add(passwordTextField);
		
		//Make Buttons
		exitButton = new JButton("Exit");
        exitButton.setLocation(0, 80);
        exitButton.setSize(85, 30);
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);
		
        logInButton = new JButton("Log In");
        logInButton.setLocation(93, 80);
        logInButton.setSize(85, 30);
        logInButton.addActionListener(this);
        buttonPanel.add(logInButton);
        
        
        registerButton = new JButton("Register");
        registerButton.setLocation(185, 80);
        registerButton.setSize(90, 30);
        registerButton.addActionListener(this);
        buttonPanel.add(registerButton);
        
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
