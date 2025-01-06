package apps.app_myfactory.inventory;

import apps.app_myfactory.material.Material;
import apps.app_myfactory.material.MaterialServices;
import apps.app_myfactory.material.MaterialServicesImpl;
import apps.app_myfactory.product.Product;
import apps.app_myfactory.product.ProductServices;
import apps.app_myfactory.product.ProductServicesImpl;

import java.sql.SQLException;
import java.util.List;

public class InventoryServicesImpl implements InventoryServices{
    private InventoryDao inventoryDao;
    private final ProductServices productServices = new ProductServicesImpl();
    private final MaterialServices materialServices  = new MaterialServicesImpl();

    public InventoryServicesImpl() {
    }

    @Override
    public void addProductToInventory(Product product) throws SQLException {
        productServices.createProduct(product);
    }

    @Override
    public void removeProductFromInventory(Product product) {
        productServices.deleteProduct(product.getId());
    }

    @Override
    public void addMaterialToInventory(Material material) {
        materialServices.createMaterial(material);
    }

    @Override
    public void removeMaterialFromInventory(Material material) {
        materialServices.deleteMaterial(material.getId());
    }

    @Override
    public void updateProductInInventory(Long id, Product product) {
        productServices.updateProduct(id, product);
    }

    @Override
    public void updateMaterialInInventory(Long id, Material material) {
        materialServices.updateMaterial(id, material);
    }

    @Override
    public List<Material> getMaterials() {
        return materialServices.getAllMaterials();
    }

    @Override
    public List<Product> getProducts() {
        return productServices.getAllProducts();
    }

    @Override
    public Material getMaterialById(Long id) {
        return materialServices.getMaterialById(id);
    }

    @Override
    public Product getProductById(Long id) {
        return productServices.getProductById(id);
    }

}
