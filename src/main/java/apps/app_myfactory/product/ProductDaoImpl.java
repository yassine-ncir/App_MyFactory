package apps.app_myfactory.product;

import apps.app_myfactory.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private final ConnectionDB cnx = new ConnectionDB();

    @Override
    public void saveProductDao(Product product) {
        String sql = "INSERT INTO products (name, price, quantity, description) VALUES (?,?,?,?)";
        try(Connection connection = cnx.getConnectionDB();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getDescription());
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long id = generatedKeys.getLong(1);
                        product.setId(id);  // Set the generated ID to the product object
                        System.out.println("Product added successfully with ID: " + id);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProductDao(Long id) {
        String req = "DELETE FROM products WHERE id = ?";
        try (Connection conn = cnx.getConnectionDB();
        PreparedStatement ps = conn.prepareStatement(req)) {
            ps.setLong(1, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Product deleted with ID: " + id);
            } else {
                System.out.println("No product found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findProductByIdDao(Long id) {
        String req = "SELECT * FROM products WHERE id = ?";
        try (Connection connection = cnx.getConnectionDB();
             PreparedStatement ps = connection.prepareStatement(req)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getInt("quantity"),
                            rs.getString("description")
                    );
                } else {
                    System.out.println("Product with id: " + id + " does not exist.");
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding product by ID: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAllProductsDao() {
        String req = "SELECT * FROM products";
        List<Product> list = new ArrayList<>();
        try (Connection conn = cnx.getConnectionDB();
        PreparedStatement ps = conn.prepareStatement(req)) {
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product(
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getInt("price"),
                            rs.getString("description"));
                    list.add(product);
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
