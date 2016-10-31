package GUI;

import javax.swing.JPanel;
/**
 *
 * @author nrage
 */
public class PanelManager implements Subject 
{
	private PanelFactory panelFac;		
	private MainWindow window;
	private Panel currentPanel;
	
	public PanelManager(PanelFactory panelFac)
	{
		this.panelFac = panelFac;		
	}
	
	@Override
	public void registerObserver(MainWindow window) 
	{
		this.window = window;
		
		getPanelFromFactory(1);
		notifyObserver();
	}

	@Override
	public void removeObserver() 
	{
		this.window = null;
	}

	@Override
	public void notifyObserver()
	{
		window.update(this);
	}
	
	public void getPanelFromFactory(int panelID)
	{
		this.currentPanel = panelFac.getPanel(panelID,this);
		notifyObserver();
	}
	
	public Panel getCurrentPanel()
	{
		return this.currentPanel;
	}
	
	public void setCurrentPanel(Panel panel)
	{
		this.currentPanel = panel;
	}
	
}