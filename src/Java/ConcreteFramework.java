package Java;

import java.awt.event.ActionEvent;

/**
 * Created by Conor on 28-Oct-16.
 */
public class ConcreteFramework implements I_Framework {

    private Context context;
    private String user;
    private final Dispacher d;
    private ActionEvent event;

    public ConcreteFramework(){
        d = new Dispacher();
    }

    @Override
    public void service() {}

    @Override
    public void event(ActionEvent event , String username) {
        // Create  Context Object here once event happens
        this.event = event;
        user = username;
        context = new Context();
        d.callBack(context);
    }

    @Override
    public String access_User() {
        return user;
    }


    public ActionEvent access_Event() {
        return event;
    }

    //May not be Required
    /*public Context callBack(){
        return context;
    }
*/
    public Dispacher getDispacher(){return d;}
}
