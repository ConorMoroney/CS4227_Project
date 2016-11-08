package User;

public interface I_Customer {


    void setName(String name);
    void setID(int id);
    void setPassword(String password);
    void setEmail(String email);
    void setAddress(String address);
    int getaccesslvl();
    void setaccesslvl(int a);
    int getID();
    String getName();
    String getEmail();
    String getAddress();

}
