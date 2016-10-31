package GUI;

import javax.swing.*;

public class PanelFactory {
    
    public PanelFactory() {
    }
    
    
    public Panel getPanel(int panelID, PanelManager pm) {
        Panel panel = null;
        switch (panelID) {
            /* Login Menu */
            case 1:
                panel = new LogInScreenGUI();
                panel.setPanelManager(pm);
                break;
            case 2:
                panel = new DisplayGUI();
                panel.setPanelManager(pm);
                break;
            case 3:
                panel = new RegisterUserGUI();
                panel.setPanelManager(pm);
                break; 
            case 4:
                panel = new ViewOrders();
                panel.setPanelManager(pm);
                break; 
            case 5:
            	panel = new ViewAccountDetails();
            	panel.setPanelManager(pm);
            	break;
            case 6:
            	panel = new ViewItems();
            	panel.setPanelManager(pm);
            	break;
        }
        return panel;
    }
    
}