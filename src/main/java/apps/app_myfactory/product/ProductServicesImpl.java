package apps.app_myfactory.product;

import apps.app_myfactory.employe.Employe;
import apps.app_myfactory.employe.EmployeDao;
import apps.app_myfactory.employe.EmployeDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductServicesImpl implements ProductServices{
    private final ProductDao productDao;

    public ProductServicesImpl() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public void createProduct(Product product) throws SQLException {
        Product p = productDao.findProductByIdDao(product.getId());
        if(p == null){
            productDao.saveProductDao(product);
        }
    }

    @Override
    public void updateProduct(Long id, Product newProduct) {
        Product p = productDao.findProductByIdDao(id);
        if(p != null){
            p.setName(newProduct.getName());
            p.setPrice(newProduct.getPrice());
            p.setQuantity(newProduct.getQuantity());
            p.setDescription(newProduct.getDescription());
            productDao.saveProductDao(p);
            System.out.println("Product with id: " + id + " updated successfully.");
        }else{
            System.out.println("Product with id: " + id + " does not exist.");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Product p = productDao.findProductByIdDao(id);
        if(p!= null){
            productDao.deleteProductDao(id);
            System.out.println("Product with id: " + id + " deleted successfully.");
        }else{
            System.out.println("Product with id: " + id + " does not exist.");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAllProductsDao();
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.findProductByIdDao(id);
    }
}
