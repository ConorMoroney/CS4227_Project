package SAMPLE1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Sample1_Implementation implements  ActionListener {

    public void createContentPane() {

        //MakeButtonPanel(10,10,295,185,"buttonpanel","MainFrame");
        //MakeLabel(0,0,80,30,"Username","buttonpanel");
        //MakeLabel(0,40,80,30,"Password","buttonpanel");
        //MakeText(90,0,180,30,"userText","buttonpanel");
        //MakeText(90,0,180,30,"PassText","buttonpanel");
        //MakeButton(0,80,85,30,"exit","buttonpanel");
        //MakeButton(0,80,85,30,"login","buttonpanel");
        //MakeButton(0,80,85,30,"register","buttonpanel");

    }

    public void actionPerformed(ActionEvent e)


    /***
     Wait for command design pattern to be implemented to do work here



     EXAMPLE

     Command command = e.getsource();
     command.execute();


     *****/

    {

        /*
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


			try
			{

    			String dbUser = "";
    			String dbPass = "";
//uncomment after testing

                Select s = new Select("*","users","username",userName);
                ResultSet myRe = s.getResultset();




    			String[] line = new String [2];

    			//get db data
    			while (myRe.next()){
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

        Sample1_Implementation window = new Sample1_Implementation();
        // CreateFrame(305,165,"MainFrame");

    }
*/
    }
}
