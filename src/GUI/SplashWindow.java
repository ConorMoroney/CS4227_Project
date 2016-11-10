package GUI;

import javax.swing.*;

/**
 * Created by shane on 10-Nov-16.
 */
public class SplashWindow {

    public SplashWindow()
    {
        initialiseWindow();
    }

    /* Gets screen width and height and draws window based on those sizes */
    private void initialiseWindow()
    {
       ImageIcon loadIcon = new ImageIcon("src/Resources/splash.gif");
        JWindow splashWindow = new JWindow();
        splashWindow.getContentPane().add(new JLabel(loadIcon));
        splashWindow.setSize(500,500);
        splashWindow.setLocationRelativeTo(null);
        splashWindow.setVisible(true);
        try {
            Thread.sleep(8200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splashWindow.setVisible(false);
        splashWindow.dispose();
    }

}
