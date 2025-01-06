package apps.app_myfactory.employe;

import apps.app_myfactory.Enum.EmployeCategory;

public class Employe {
    private Long id;
    private String name;
    private String tel;
    private String address;
    private float salary;
    private EmployeCategory category;
    private Long factoryId; // forgiving key of factory

    public Employe() {
    }

    public Employe(String employeName, String tel, String adress, float salary,EmployeCategory category) {
        this.name = employeName;
        this.tel = tel;
        this.address = adress;
        this.salary = salary;
        this.category = category;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public EmployeCategory getCategory() {
        return category;
    }

    public void setCategory(EmployeCategory category) {
        this.category = category;
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }
}
