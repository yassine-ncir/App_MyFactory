package apps.app_myfactory.inventory;

import apps.app_myfactory.material.Material;
import apps.app_myfactory.product.Product;

import java.sql.SQLException;
import java.util.List;

public interface InventoryServices {
    void addProductToInventory(Product product) throws SQLException;
    void removeProductFromInventory( Product product);
    void addMaterialToInventory(Material material);
    void removeMaterialFromInventory(Material material);
    void updateProductInInventory(Long id,Product product);
    void updateMaterialInInventory(Long id,Material material);
    List<Material> getMaterials();
    List<Product> getProducts();
    Material getMaterialById(Long id);
    Product getProductById(Long id);
}
