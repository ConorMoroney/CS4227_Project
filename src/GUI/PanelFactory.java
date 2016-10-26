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
        }
        return panel;
    }
    
}
