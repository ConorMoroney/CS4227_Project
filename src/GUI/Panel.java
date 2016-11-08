package GUI;

import javax.swing.JPanel;

public abstract class Panel
{
    protected Helper help = Helper.getInstance();
    protected PanelManager panelMgr;
    protected JPanel panel;

    public Panel()
    {

    }

    public abstract JPanel sendToWindow();
    public void setPanelManager(PanelManager panelMgr)
    {
        this.panelMgr = panelMgr;
    }
}