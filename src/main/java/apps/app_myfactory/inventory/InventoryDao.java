package apps.app_myfactory.inventory;

import apps.app_myfactory.material.Material;
import apps.app_myfactory.product.Product;

import java.util.List;

public interface InventoryDao {
    void saveProductIntoInv(Product product);

}
