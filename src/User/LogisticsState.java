package User;

/**
 * Created by Paul on 02/11/2016.
 */
public class LogisticsState implements UserState{
    public String[] getButtonTitles(){
        return new String[] {"Update Product Stock", "View Orders"};
    }
    public String getFrameTitle(){ return "LogisticsGUI";}
}
