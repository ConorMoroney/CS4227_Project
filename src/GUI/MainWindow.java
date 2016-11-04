package GUI;

import javax.swing.*;
import java.awt.*;

/* Implements the observer pattern */
public class MainWindow extends JFrame implements Observer
{
    private static final long serialVersionUID = 1L;
    private JPanel viewCurrentPanel = null;
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;

    public MainWindow()
    {
        initialiseWindow();
    }

    /* Gets screen width and height and draws window based on those sizes */
    private void initialiseWindow()
    {
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        SCREEN_WIDTH = toolKit.getScreenSize().width;
        SCREEN_HEIGHT = toolKit.getScreenSize().height;
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /* Updates window by applying new panels to window */
    @Override
    public void update(Subject s)
    {
		/* Removes panel on window and applys new panel */
        removeCurrentPanelFromWindow();
        Panel currentPanel = s.getCurrentPanel();
        viewCurrentPanel = currentPanel.sendToWindow();
        this.add(viewCurrentPanel);
        this.setVisible(true);
    }


    public void removeCurrentPanelFromWindow()
    {
        if(viewCurrentPanel != null)
        {
            this.remove(viewCurrentPanel);
            viewCurrentPanel = null;
        }
    }
}