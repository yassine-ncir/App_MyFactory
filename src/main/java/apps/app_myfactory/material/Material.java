package apps.app_myfactory.material;

public class Material {
    private Long id;                 // Unique identifier
    private String name;             // Material name
    private String unit;
    private double quantity;
    private double price;

    public Material(String itemName, String unit, double quantity, double price) {
        this.name = itemName;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String itemName) {
        this.name = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
