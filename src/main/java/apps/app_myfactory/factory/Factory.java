package apps.app_myfactory.factory;

public class Factory {
    private String name;
    private String password;
    private String tel;
    private String address;

    public Factory(String name, String password, String tel, String address) {
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.address = address;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
