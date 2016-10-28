package GUI;

import javax.swing.*;

/**
 * Created by colmm on 28/10/2016.
 */
public class GUIFactory
{
    public static JLabel addLabel(String labelText, int xLocation, int yLocation, int xSize, int ySize)
    {
        JLabel label = new JLabel(labelText);
        label.setLocation(xLocation, yLocation);
        label.setSize(xSize, ySize);
        //buttonPanel.add(label);

        return label;
    }
    public static JPanel addButtonPanel(int xLocation, int yLocation, int xSize, int ySize)
    {
        JPanel buttonPanel;
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(xLocation, yLocation);
        buttonPanel.setSize(xSize, ySize);
        //totalGUI.add(buttonPanel);

        return buttonPanel;
    }


    public static JTextField addTextField(int xLocation, int yLocation,int xSize, int ySize)
    {
        JTextField textField;
        textField = new JTextField();
        textField.setLocation(xLocation, yLocation);
        textField.setSize(xSize, ySize);
        //buttonPanel.add(textField);

        return textField;
    }

    public static JPasswordField addPasswordField(int xLocation, int yLocation,int xSize, int ySize)
    {
        JPasswordField passwordField;
        passwordField = new JPasswordField();
        passwordField.setLocation(xLocation, yLocation);
        passwordField.setSize(xSize, ySize);
        //buttonPanel.add(passwordField);

        return passwordField;
    }
}
