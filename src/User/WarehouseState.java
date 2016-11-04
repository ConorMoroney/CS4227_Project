package User;

/**
 * Created by Paul on 02/11/2016.
 */
public class WarehouseState implements UserState {
    public String[] getButtonTitles(){
        return new String[] {"Update Product Stock", "Register a product"};}
    public String getFrameTitle(){ return "ManagerGUI";}
}
