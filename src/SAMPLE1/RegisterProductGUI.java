package SAMPLE1;

import GUI.GUIFactory;
import Java.I_Product;
import Java.ProductFactory;
import SQL.Connect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class RegisterProductGUI implements ActionListener {
    private JButton cancelButton, registerProductButton;
    private JTextField typeField, nameField, weightField, priceField, quantityField, descriptionField;
    private static JFrame frame = new JFrame("Register Product Screen");

    private JPanel createContentPane() {
        //Make bottom JPanel to place buttonPanel on
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        //Make Button Panel
        JPanel buttonPanel = GUIFactory.addButtonPanel(10, 10, 295, 485);
        totalGUI.add(buttonPanel);

        //Make Labels
        JLabel typeLabel = GUIFactory.addLabel("Type", 0, 0, 80, 30);
        JLabel nameLabel = GUIFactory.addLabel("Name:", 0, 40, 80, 30);
        JLabel weightLabel = GUIFactory.addLabel("Weight:", 0, 80, 80, 30);
        JLabel priceLabel = GUIFactory.addLabel("Price:", 0, 120, 80, 30);
        JLabel quantityLabel = GUIFactory.addLabel("Quantity:", 0, 160, 80, 30);
        JLabel descriptionLabel = GUIFactory.addLabel("Description", 0, 200, 80, 30);

        buttonPanel.add(typeLabel);
        buttonPanel.add(nameLabel);
        buttonPanel.add(weightLabel);
        buttonPanel.add(priceLabel);
        buttonPanel.add(quantityLabel);
        buttonPanel.add(descriptionLabel);

        //Make texts fields
        typeField = GUIFactory.addTextField(90,0,180,30);
        nameField = GUIFactory.addTextField(90,40,180,30);
        weightField = GUIFactory.addTextField(90,80,180,30);
        priceField = GUIFactory.addTextField(90,120,180,30);
        quantityField = GUIFactory.addTextField(90,160,180,30);
        descriptionField = GUIFactory.addTextField(90,200,180,30);

        buttonPanel.add(typeField);
        buttonPanel.add(nameField);
        buttonPanel.add(weightField);
        buttonPanel.add(priceField);
        buttonPanel.add(quantityField);
        buttonPanel.add(descriptionField);

        //Make Buttons
        cancelButton = GUIFactory.addButton("Cancel",0,280,135,30);
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        registerProductButton = GUIFactory.addButton("Register",140,280,135,30);
        registerProductButton.addActionListener(this);
        buttonPanel.add(registerProductButton);

        totalGUI.setVisible(true);
        return totalGUI;
    }

    public void actionPerformed(ActionEvent e) {
        Main.actionListener.actionPerformed(e);
        if (e.getSource() == cancelButton) {
            //frame.setVisible(false);
            frame.dispose();
        } else if (e.getSource() == registerProductButton) {
            //do shit in here
            if (typeField.getText().equals("") || nameField.getText().equals("") || priceField.getText().equals("") ||
                    weightField.getText().equals("") || quantityField.getText().equals("") || descriptionField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "There is a null field");
                return;
            }

            String type = typeField.getText();
            if (!(type.equalsIgnoreCase("pen") || type.equalsIgnoreCase("pencil") || type.equalsIgnoreCase("folder")
                                                || type.equalsIgnoreCase("paperclip") || type.equalsIgnoreCase("copy")
                                                || type.equalsIgnoreCase("envelope") || type.equalsIgnoreCase("ruler")
                                                || type.equalsIgnoreCase("paper"))) {
                JOptionPane.showMessageDialog(null, "This is not a product type \n product types include: \n pen " +
                                        "\n pencil \n folder \n copy \n paperclip \n ruler \n envelope \n paper");
                return;
            }

            String name = nameField.getText();
            int ID = 1;
            double weight = Double.parseDouble(weightField.getText());
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            String description = descriptionField.getText();

            ProductFactory productFactory = new ProductFactory();

            I_Product product = productFactory.createProduct(type);

            try
            {
                Connect con = new Connect();
                Connection mycon = con.getconnection();
                Statement mystat = mycon.createStatement();

                //Java.Connect to database

                //Get ID for Java.user
                ResultSet myRe = mystat.executeQuery("select * from dbo.items");
                System.out.println("{{{{{{" + myRe + "}}}}}}}");
                while (myRe.next()) {
                    ID++;

                }

                //Insert into table
                String sql = "INSERT into dbo.items (iditems, type, name, description, price, weight, quantity) VALUES('"
                        + ID + "','" + type + "','" + name + "','" + description + "','" + price + "','" + weight
                        + "','" + quantity + "');";
                System.out.println(sql);
                mystat.executeUpdate(sql);

                //ResultSet myRe = mystat.executeQuery("select * from creationary.items");

            }
            catch (Exception exc)
            {
                System.out.println(exc.getMessage());
            }

            product.setName(name);
            product.setID(ID);
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setWeight(weight);
        }

    }

    private static void createAndShowGUI() {
        //Create and set up the content pane.
        RegisterProductGUI window = new RegisterProductGUI();
        frame = GUIFactory.makeFrame("Register Product", 305, 365);
        frame.setContentPane(window.createContentPane());
    }

    public static void registerItem() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
