package apps.app_myfactory.product;

import java.util.List;

public interface ProductDao {
    void saveProductDao(Product product);
    void deleteProductDao(Long id);
    Product findProductByIdDao(Long id);
    List<Product> findAllProductsDao();
}
