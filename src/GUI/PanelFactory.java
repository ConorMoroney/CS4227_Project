package GUI;

import javax.swing.*;

public class PanelFactory {
    private Helper help;
    
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
            /*case 3:
                panel = new RentPanel();
                panel.setPanelManager(pm);
                break;
            case 4:
                panel = new RentalsPanel();
                panel.setPanelManager(pm);
                break;         
            case 5:
                panel = new BasketPanel();
                panel.setPanelManager(pm);
                break;
            case 6:
                panel = new TopUpPanel();
                panel.setPanelManager(pm);
                break;  
            case 7:
                panel = new StaffPanel();
                panel.setPanelManager(pm);
                break;  
            case 8:
                panel = new ManagerPanel();
                panel.setPanelManager(pm);
                break;  
            case 9:
                panel = new AddItemPanel();
                panel.setPanelManager(pm);
                break;  */
            
        }
        return panel;
    }
}
