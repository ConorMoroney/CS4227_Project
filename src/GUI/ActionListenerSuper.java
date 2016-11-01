package GUI;

import Java.ConcreteFramework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by colmm on 01/11/2016.
 */
public class ActionListenerSuper implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print(e.getActionCommand());
        ConcreteFramework c = new ConcreteFramework();
        c.event(e);
    }
}
