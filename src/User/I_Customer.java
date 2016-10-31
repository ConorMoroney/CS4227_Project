package User;

public interface I_Customer {


    void setName(String name);
    void setType(String type);
    void setID(int id);
    void setPassword(String password);
    void setEmail(String email);
    void setAddress(String address);
    int getaccesslvl();
    String getName();
    String getEmail();
    String getAddress();

}
