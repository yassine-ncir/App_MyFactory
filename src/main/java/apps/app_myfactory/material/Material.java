package apps.app_myfactory.material;

public class Material {
    private Long id;                 // Unique identifier
    private String materialName;             // Material name
    private String unit;
    private double quantity;

    public Material(String itemName, String unit, double quantity) {
        this.materialName = itemName;
        this.unit = unit;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return materialName;
    }

    public void setItemName(String itemName) {
        this.materialName = itemName;
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
}
