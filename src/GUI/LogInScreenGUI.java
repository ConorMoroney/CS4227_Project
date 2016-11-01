package GUI;

import SQL.Select;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LogInScreenGUI extends GUI.ActionListenerSuper
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

        buttonPanel = GUIFactory.addButtonPanel(10,10,295,185);
        userNameLabel = GUIFactory.addLabel("Username:",0,0,80,30);
        passwordLabel = GUIFactory.addLabel("Password:",0,40,80,30);
        userNameTextField = GUIFactory.addTextField(90,0,180,30);
        passwordTextField = GUIFactory.addPasswordField(90,40,180,30);

        totalGUI.add(buttonPanel);
        buttonPanel.add(userNameLabel);
        buttonPanel.add(passwordLabel);
        buttonPanel.add(userNameTextField);
        buttonPanel.add(passwordTextField);

        /****
         *  Below shows the 3 different ways of making buttons.
         *  The exit button uses a builder to create a blank button and fills in the details.
         *  The LogInButton creates the button from the LogInButtonBuilder
         *  and the Register Button uses a regular Creation Method.
         */
        //Builder for LogInButton
        I_ButtonBuilder button = new LogInButtonBuilder();
        ButtonEngineer buttonEngineer = new ButtonEngineer(button);
        buttonEngineer.makeButton();

        //Builder for other 2 Buttons
        I_ButtonBuilder button2 = new EmptyButtonBuilder();
        ButtonEngineer buttonEngineer2 = new ButtonEngineer(button2);
        buttonEngineer2.makeButton();

        Button bLogInButton = buttonEngineer.getButton();

        //Make Buttons and set parameters
        Button bExitButton = buttonEngineer2.getButton();

        bExitButton.setButtonTitle("Exit");
        bExitButton.setButtonXLocation(0);
        bExitButton.setButtonYLocation(80);
        bExitButton.setButtonXSize(85);
        bExitButton.setButtonYSize(30);

        //buttons
        exitButton = GUIFactory.addButtonFromBuilder(bExitButton);
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        logInButton = GUIFactory.addButtonFromBuilder(bLogInButton);
        logInButton.addActionListener(this);
        buttonPanel.add(logInButton);

        registerButton = GUIFactory.addButton("Register",185,80,90,30);
        registerButton.addActionListener(this);
        buttonPanel.add(registerButton);
        
        totalGUI.setVisible(true);
        return totalGUI;
    }

    public void actionPerformed(ActionEvent e)
    {
        super.actionPerformed(e);
        if(e.getSource() == exitButton)
        {
			System.exit(0);
			JOptionPane.showMessageDialog(null, "Register Course Director Window");
        }
        
        else if(e.getSource() == registerButton)
        {
			//RegisterUserGUI.start();
            RegisterEmployeeGUI.main(null);
        }
		
        else if(e.getSource() == logInButton)
        {

			//declare variables for username and password
			String userName = userNameTextField.getText();
			String password = passwordTextField.getText();

            /*
                TODO
                Change code below to not have any SQL, use function calls.
             */

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

    public static void createAndShowGUI()
	{
        //Create and set up the content pane.
        LogInScreenGUI window = new LogInScreenGUI();
        frame = GUIFactory.makeFrame("Log In Screen", 305, 165);
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
    
    private void register(){}//Decorator Pattern to be implemented here
}
