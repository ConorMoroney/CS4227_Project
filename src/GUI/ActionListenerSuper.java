package GUI;

import SAMPLE1.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by colmm on 01/11/2016.
 */
public class ActionListenerSuper implements ActionListener{

    private String userName = "No User";

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.print(e.getActionCommand());
        Main.c.event(e, userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
}
