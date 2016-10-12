package GUI;

import Java.Connect;
import Java.I_Product;
import Java.ProductFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RegisterProductGUI implements  ActionListener
{
    JPanel buttonPanel;
    JButton cancelButton, registerProductButton;
	JLabel TypeLabel,idLabel, nameLabel, weightLabel, priceLabel, quantityLabel, descriptionLabel;
	JTextField typeField,idField, nameField, weightField, priceField, quantityField, descriptionField;
	static JFrame frame = new JFrame("Register Product Screen");

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
        TypeLabel = new JLabel("Type:");
        TypeLabel.setLocation(0, 0);
        TypeLabel.setSize(80, 30);
        buttonPanel.add(TypeLabel);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setLocation(0, 40);
        nameLabel.setSize(80, 30);
        buttonPanel.add(nameLabel);
        
        weightLabel = new JLabel("Weight:");
		weightLabel.setLocation(0,80);
        weightLabel.setSize(80, 30);
        buttonPanel.add(weightLabel);
        
        priceLabel = new JLabel("Price:");
		priceLabel.setLocation(0, 120);
        priceLabel.setSize(80, 30);
        buttonPanel.add(priceLabel);
        
        quantityLabel = new JLabel("Quantity:");
		quantityLabel.setLocation(0, 160);
        quantityLabel.setSize(80, 30);
        buttonPanel.add(quantityLabel);
        
        descriptionLabel = new JLabel("Description:");
		descriptionLabel.setLocation(0, 200);
        descriptionLabel.setSize(80, 30);
        buttonPanel.add(descriptionLabel);
                

		//Make texts fields
        typeField= new JTextField();
        typeField.setLocation(90, 0);
        typeField.setSize(180, 30);
        buttonPanel.add(typeField);

        nameField = new JTextField();
        nameField.setLocation(90, 40);
        nameField.setSize(180, 30);
        buttonPanel.add(nameField);

        weightField = new JTextField();
        weightField.setLocation(90, 80);
        weightField.setSize(180, 30);
        buttonPanel.add(weightField);

        priceField = new JTextField();
        priceField.setLocation(90, 120);
        priceField.setSize(180, 30);
        buttonPanel.add(priceField);

        quantityField = new JTextField();
        quantityField.setLocation(90, 160);
        quantityField.setSize(180, 30);
        buttonPanel.add(quantityField);

        descriptionField = new JTextField();
        descriptionField.setLocation(90, 200);
        descriptionField.setSize(180, 30);
        buttonPanel.add(descriptionField);
		

		//Make Buttons
		cancelButton = new JButton("Cancel");
        cancelButton.setLocation(0, 280);
        cancelButton.setSize(135, 30);
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);
		
        registerProductButton = new JButton("Register");
        registerProductButton.setLocation(140, 280);
        registerProductButton.setSize(135, 30);
        registerProductButton.addActionListener(this);
        buttonPanel.add(registerProductButton);
        
        totalGUI.setVisible(true);
        return totalGUI;
    }

    public void actionPerformed(ActionEvent e)
	{
        if(e.getSource() == cancelButton)
        {
			//frame.setVisible(false);
			frame.dispose();
        }
        
        else if(e.getSource() == registerProductButton)
        {
			//do shit in here
        	if(typeField.getText().equals("") ||nameField.getText().equals("") ||priceField.getText().equals("") ||
        			weightField.getText().equals("") ||quantityField.getText().equals("") ||descriptionField.getText().equals("")){
        		JOptionPane.showMessageDialog(null,"There is a null field" );
        		return;
        	}
        	
        	String type = typeField.getText();
        	if(!(type.equalsIgnoreCase("pen") ||type.equalsIgnoreCase("pencil") ||type.equalsIgnoreCase("folder")
        			||type.equalsIgnoreCase("paperclip") ||type.equalsIgnoreCase("copy") ||type.equalsIgnoreCase("envelope") 
        			||type.equalsIgnoreCase("ruler")||type.equalsIgnoreCase("paper"))){
        		JOptionPane.showMessageDialog(null,"this is not a product type \n product types include: \n pen \n pencil \n folder \n copy \n paperclip \n ruler \n envelope \n paper" );
        			return;
        	}
        	
        	String name = nameField.getText();
        	int ID = 1;
        	double weight = Double.parseDouble(weightField.getText());
        	double price = Double.parseDouble(priceField.getText());
        	int quantity = Integer.parseInt(quantityField.getText());
        	String description = descriptionField.getText();
        	
        	
        		
        		
        	String productType = type;
    		
    		ProductFactory productFactory = new ProductFactory();
    		
    		I_Product product = productFactory.createProduct(productType);
    		
    		try{
    			
    			
    			   Connect con = new Connect();
        		   Connection mycon =  con.getconnection();
        		   Statement mystat = mycon.createStatement();

    			//Java.Connect to database
    			
    		
    			//Get ID for Java.user
    			ResultSet myRe = mystat.executeQuery("select * from dbo.items");
                System.out.println("{{{{{{" + myRe  + "}}}}}}}");
    			while (myRe.next()){
    				ID++;
    			
    			}
    		
    			//Insert into table
    			String sql = "INSERT into dbo.items (iditems, type, name, description, price, weight, quantity) VALUES('"
    						+ ID + "','" + type + "','" + name + "','" + description + "','" + price + "','" + weight 
    						+ "','"  + quantity + "');" ;
    			System.out.println(sql);
    			mystat.executeUpdate(sql);
    			
    			//ResultSet myRe = mystat.executeQuery("select * from creationary.items");
    		
    		}
    		catch(Exception exc){
    			System.out.println(exc.getMessage());
    			//System.out.println("Error cant connect to database");
    		}
    		
    		product.setName(name);
    		product.setID(ID);
    		product.setDescription(description);
    		product.setPrice(price);
    		product.setQuantity(quantity);
    		product.setWeight(weight);
        }
        
    }

    private static void createAndShowGUI()
	{
        //Create and set up the content pane.
    	RegisterProductGUI window = new RegisterProductGUI();
        frame.setContentPane(window.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(305, 365);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void registerItem()
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
