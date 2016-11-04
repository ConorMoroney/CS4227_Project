package User;

/**
 * Created by Paul on 02/11/2016.
 */
public class CustomerState implements UserState {
    public String[] getButtonTitles() {return new String[] {"View Account Details", "Buy Product"};}
    public String getFrameTitle(){ return "CustomerGUI";}
}
