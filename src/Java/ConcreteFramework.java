package Java;

import java.awt.event.ActionEvent;

/**
 * Created by Conor on 28-Oct-16.
 */
public class ConcreteFramework implements I_Framework {

    private Context context;
    private String user;
    private final Dispacher d;

    public ConcreteFramework(){
        d = new Dispacher();
    }

    @Override
    public void service() {

    }

    @Override
    public void event(ActionEvent event , String username) {
        // Create  Context Object here once event happens
        user = username;
        context = new Context(event);
        d.callBack(context);
    }

    @Override
    public String access_internals() {
        return user;
    }

    //May not be Required
    public Context callBack(){
        return context;
    }

    public Dispacher getDispacher(){return d;}
}
