package SAMPLE1;

import GUI.GUIFactory;
import GUI.MainWindow;
import GUI.Panel;
import GUI.PanelManager;
import User.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterUserGUI extends Panel implements  ActionListener
{
    private JPanel buttonPanel;
    private JButton cancelButton;
    private JButton registerUserButton;
    private final String [] userTypes = {"Manager", "Logistics" , "Warehouse" , "Customer"};
    private JLabel userLabel;
    private JLabel TypeLabel;
    private JLabel passLabel;
    private JLabel emailLabel;
    private JLabel addressLabel;
    private final JComboBox userType = new JComboBox(userTypes);
    private JTextField userField;
    private JTextField passField;
    private JTextField emailField;
    private JTextField addressField;

    public RegisterUserGUI(){
        this.panel = new JPanel();
        createAndShowGUI();
    }

    private JPanel createContentPane()
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
        userLabel = GUIFactory.addLabel("Username:",100,100,80,30);
        passLabel = GUIFactory.addLabel("Password:",100,140,80,30);
        emailLabel = GUIFactory.addLabel("email:",100,180,80,30);
        addressLabel = GUIFactory.addLabel("Address:",100,220,80,30);
        TypeLabel = GUIFactory.addLabel("Employee Type:",100,260,80,30);

        buttonPanel.add(userLabel);
        buttonPanel.add(passLabel);
        buttonPanel.add(emailLabel);
        buttonPanel.add(addressLabel);
        buttonPanel.add(TypeLabel);

        userType.setLocation(210, 260);
        userType.setSize(180, 30);
        buttonPanel.add(userType);

        //Make texts fields
        userField = GUIFactory.addTextField(210,100,180,30);
        passField = GUIFactory.addPasswordField(210,140,180,30);
        emailField = GUIFactory.addTextField(210,180,180,30);
        addressField = GUIFactory.addTextField(210,220,180,30);

        buttonPanel.add(userField);
        buttonPanel.add(passField);
        buttonPanel.add(emailField);
        buttonPanel.add(addressField);

        //Make Buttons
        cancelButton = GUIFactory.addButton("Cancel",245,300,135,30);
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        registerUserButton = GUIFactory.addButton("Register", 100,300,135,30);
        registerUserButton.addActionListener(this);
        buttonPanel.add(registerUserButton);

        this.panel.setVisible(true);
        return this.panel;
    }

    public void actionPerformed(ActionEvent e)
    {
        MainWindow.actionListener.actionPerformed(e);
        if(e.getSource() == cancelButton)
        {
            panelMgr.getPanelFromFactory(1);
        }

        else if(e.getSource() == registerUserButton)
        {

            if(userField.getText().equals("") ||passField.getText().equals("") ||emailField.getText().equals("")
                                                ||addressField.getText().equals("") ){
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
            MainWindow.actionListener.setUserName(userName);
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