package Java;

import java.awt.event.ActionEvent;

/**
 * Created by Conor on 28-Oct-16.
 */
public class ConcreteFramework implements I_Framework {

    Context context;

    @Override
    public void service() {

    }

    @Override
    public void event(ActionEvent event) {
        // Create  Context Object here once event happens
        context = new Context(event);
        Dispacher d = new Dispacher();
        //d.callBack();
    }

    @Override
    public void access_internals() {

    }

    public  Context callBack(){return context;}
}
