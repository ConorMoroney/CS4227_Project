package GUI;

import javax.swing.JPanel;

public interface Subject {		
	
	void registerObserver(MainWindow window);
	void removeObserver();
	void notifyObserver();
	Panel getCurrentPanel();
}