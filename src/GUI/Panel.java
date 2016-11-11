package GUI;

import javax.swing.JPanel;

public abstract class Panel
{
    protected final Helper help = Helper.getInstance();
    protected PanelManager panelMgr;
    protected JPanel panel;

    protected Panel()
    {
    }

    public abstract JPanel sendToWindow();
    public void setPanelManager(PanelManager panelMgr)
    {
        this.panelMgr = panelMgr;
    }
}