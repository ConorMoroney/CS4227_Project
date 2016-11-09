package Java;

import java.awt.event.ActionEvent;

import SQL.Connect;
import SQL.Insert;

import java.awt.event.ActionEvent;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import static Database.DatabaseAccess.dba;
import static GUI.Helper.help;

/**
 * Created by Conor on 28-Oct-16.
 */
public class ConcreteInterceptor  implements I_Interceptor{
    private String user;

    @Override
    public void InterceptorMethod1(Context context) {
        /* Put implementation here */
      ActionEvent event = context.getValue();

        String output = "The " + event.getActionCommand() + " Button was pressed";
        //System.out.println(output);
        //"[TIME] User: Action"
        user = context.consumeService();

        // JOptionPane.showMessageDialog(null, user);
        try{
            addLogToFile(event.getActionCommand());
            addLogToDB(event.getActionCommand());

            if(!compareFileToDB())
            {
                System.out.println("Local log file did not match database.");
            }
        }
        catch (Exception e)
        {
            System.out.println("An IO error occurred in Concrete Interceptor");
        }
    }
    /**TODO
     * Instead of Printing to the command line
     *
     * 1. Write the contents to a local text file called LOG.txt        AddLogToFile
     * 2. Insert the contents into the database for Archiving           AddLogToDB
     * 3. Do error check to make sure the log was recorded correctly   Compare
     *
     *      NOTE:  Do These Functions in the Framework
     *
     * finally if correct continue onto normal functionality */

    private void addLogToFile(String action) throws IOException
    {
        String path = "CS4227Log1.txt";
        boolean appendToFile = true;

        FileWriter write = new FileWriter(path, appendToFile);
        PrintWriter print_line = new PrintWriter(write);

        print_line.printf("[%s] %s;%s\n", user, action, System.currentTimeMillis());
        print_line.close();
    }

    private void addLogToDB(String action) throws IOException
    {
        String LogText = "["+user+"] "+action+ " button was pressed;";
        try {
            dba.addLog(LogText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean compareFileToDB() {
        return false;
    }
}
