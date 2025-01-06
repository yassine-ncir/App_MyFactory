package apps.app_myfactory.product;

import java.sql.SQLException;
import java.util.List;

public interface ProductServices {
    void createProduct(Product product) throws SQLException;
    void updateProduct(Long id,Product newProduct);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
