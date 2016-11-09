package Java;

import java.awt.event.ActionEvent;

/**
 * Created by Conor on 28-Oct-16.
 */
public class Context {

    private ActionEvent event;

    public Context(ActionEvent event){
        this.event = event;
    }

    public ActionEvent getValue(){
        return event;
    }

    public void setValue(ActionEvent event){
        this.event = event;
    }

    public String consumeService()
    {
        return SAMPLE1.Main.c.access_internals();
    }
}