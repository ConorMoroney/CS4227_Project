package Java;

import java.awt.event.ActionEvent;

import static GUI.MainWindow.c;

/**
 * Created by Conor on 28-Oct-16.
 */
public class Context {



    public Context()
    {}

    public ActionEvent getValue(){
        return c.access_Event();
    }
/*
    public void setValue(ActionEvent event){
        this.event = event;
    }
*/
    public String consumeService()
    {
        return c.access_User();
    }
}