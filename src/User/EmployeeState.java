package User;

/**
 * Created by shane on 09-Nov-16.
 */
public class EmployeeState implements I_UserState {
    String [] concreteEmployeeTypes = {"warehouse","logistics","manager"};
    String employeeTitle;

    public EmployeeState(String name) {
        this.employeeTitle=name;
    }
    public String[] getButtonTitles(){
        for (String s : concreteEmployeeTypes) {
            if ("Warehouse".equalsIgnoreCase(employeeTitle)) {
                return new String[]{"Update Product Stock", "Register a product"};
            } else if ("Logistics".equalsIgnoreCase(employeeTitle)) {
                return new String[]{"Update Product Stock", "View Orders"};
            } else if ("Manager".equalsIgnoreCase(employeeTitle)) {
                return new String[]{"Generate duh Reports", "View Staff Details"};
            }
        }
        return null;
    }
    public String getFrameTitle(){
        for (String s : concreteEmployeeTypes) {
            if ("Warehouse".equalsIgnoreCase(employeeTitle)) {
                return "WarehouseGUI";
            }
            else if ("Logistics".equalsIgnoreCase(employeeTitle)) {
                return "LogisticsGUI";
            }
            else if ("Manager".equalsIgnoreCase(employeeTitle)) {
                return "ManagerGUI";
            }
        }
        return null;
    }



}
