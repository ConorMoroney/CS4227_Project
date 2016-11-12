package SAMPLE1;

import GUI.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInScreenGUI extends Panel implements  ActionListener
{
    private JPanel buttonPanel;
    private JButton exitButton;
    private JButton logInButton;
    private JButton registerButton;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;

    public LogInScreenGUI(){
        this.panel = new JPanel();
        createAndShowGUI();
    }
    private JPanel createContentPane()
    {
        //Make bottom JPanel to place buttonPanel on
        this.panel.setLayout(null);

        buttonPanel = GUIFactory.addButtonPanel(10,10,500,485);
        userNameLabel = GUIFactory.addLabel("Username:",90,150,80,30);
        passwordLabel = GUIFactory.addLabel("Password:",90,190,80,30);
        userNameTextField = GUIFactory.addTextField(180,150,180,30);
        passwordTextField = GUIFactory.addPasswordField(180,190,180,30);

        this.panel.add(buttonPanel);
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
        bExitButton.setButtonXLocation(90);
        bExitButton.setButtonYLocation(230);
        bExitButton.setButtonXSize(85);
        bExitButton.setButtonYSize(30);

        //buttons
        exitButton = GUIFactory.addButtonFromBuilder(bExitButton);
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        logInButton = GUIFactory.addButtonFromBuilder(bLogInButton);
        logInButton.addActionListener(this);
        buttonPanel.add(logInButton);

        registerButton = GUIFactory.addButton("Register",275,230,90,30);
        registerButton.addActionListener(this);
        buttonPanel.add(registerButton);

        this.panel.setVisible(true);
        return this.panel;
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
            panelMgr.getPanelFromFactory(3);
        }

        else if(e.getSource() == logInButton)
        {
            //declare variables for username and password
            String userName = userNameTextField.getText();
            String password = passwordTextField.getText();

            //check if username and password exist
            try
            {
                if(help.canUserLogin(userName, password)){
                    if(help.getAccessLevel(userName) == 1){
                        help.getCustomerDetails(userName);
                    }
                    else{
                        help.getEmployeeDetails(userName);
                    }
                    panelMgr.getPanelFromFactory(2);
                }
                MainWindow.actionListener.setUserName(userName);
            }

            catch(Exception exc)
            {
                System.out.println(exc.fillInStackTrace());
                System.exit(0);
            }
        }
        MainWindow.actionListener.actionPerformed(e);

    }

    private void createAndShowGUI()
    {
        this.createContentPane();
    }

    private void register(){}//Decorator Pattern to be implemented here

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