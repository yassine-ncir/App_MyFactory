package apps.app_myfactory.inventory;

import apps.app_myfactory.material.Material;
import apps.app_myfactory.product.Product;

import java.util.List;

public class Inventory {
    private Long id;
    private List<Product> products;
    private List<Material> materials;

    public Inventory(Long id, List<Product> products, List<Material> materials) {
        this.id = id;
        this.products = products;
        this.materials = materials;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }


}
