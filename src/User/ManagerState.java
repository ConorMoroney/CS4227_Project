package User;

/**
 * Created by Paul on 02/11/2016.
 */
public class ManagerState implements UserState {
    public String[] getButtonTitles(){
        return new String[] {"Generate Reports", "View Staff Details"};
    }
    public String getFrameTitle(){ return "ManagerGUI";}
}
