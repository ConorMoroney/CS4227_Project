package Java;

import java.awt.event.ActionEvent;

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

        addLogToFile();
        addLogToDB();

        if(!compareFileToDB())
        {
           // JOptionPane.showMessageDialog(null, "An error has occurred. Please notify an administrator.");
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

    private void addLogToFile()
    {

    }

    private void addLogToDB()
    {

    }
    private boolean compareFileToDB()
    {

        return false;
    }
}
