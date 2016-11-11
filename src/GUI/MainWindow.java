package GUI;

import javax.swing.*;
import java.awt.*;

/* Implements the observer pattern */
public class MainWindow extends JFrame implements Observer
{
    private static final long serialVersionUID = 1L;
    private JPanel viewCurrentPanel = null;

    public MainWindow()
    {
        initialiseWindow();
    }

    /* Gets screen width and height and draws window based on those sizes */
    private void initialiseWindow()
    {
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        int SCREEN_WIDTH = toolKit.getScreenSize().width;
        int SCREEN_HEIGHT = toolKit.getScreenSize().height;


        this.setSize(500, 500);
        this.setLocationRelativeTo(null);

        this.setResizable(true);
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

    private void removeCurrentPanelFromWindow()
    {
        if(viewCurrentPanel != null)
        {
            this.remove(viewCurrentPanel);
            viewCurrentPanel = null;
        }
    }
}
