package GUI;

interface Subject {

    void registerObserver(MainWindow window);
    void removeObserver();
    void notifyObserver();
    Panel getCurrentPanel();
}