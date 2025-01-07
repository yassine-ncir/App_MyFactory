package apps.app_myfactory.material;

import apps.app_myfactory.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDaoImpl implements MaterialDao{
    private final ConnectionDB cnx = new ConnectionDB();

    @Override
    public void saveMaterialDao(Material material) {
        String sql = "INSERT INTO materials (itemName, unit, quantity, price) VALUES (?, ?, ?,?)";
        try (Connection connection = cnx.getConnectionDB();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, material.getItemName());
            ps.setString(2, material.getUnit());
            ps.setDouble(3, material.getQuantity());
            ps.setDouble(3, material.getPrice());
            ps.executeUpdate();

            // Retrieve the generated ID
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    material.setId(id);  // Set the ID to the object
                    System.out.println("Material added successfully with ID: " + id);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteMaterialDao(Long id){
        String sql = "DELETE FROM materials WHERE id = ?";
        try (Connection connection = cnx.getConnectionDB();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Material deleted successfully with ID: " + id);
            } else {
                System.out.println("No material found with ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Material getMaterialByIdDao(Long id) {
        String sql = "SELECT * FROM materials WHERE id = ?";
        try (Connection connection = cnx.getConnectionDB();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Material material = new Material(
                            rs.getString("itemName"),
                            rs.getString("unit"),
                            rs.getDouble("quantity"),
                            rs.getDouble("price")
                    );
                    material.setId(rs.getLong("id"));
                    return material;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("No material found with ID: " + id);
        return null;
    }

    @Override
    public List<Material> getAllMaterialsDao()  {
        String sql = "SELECT * FROM materials";
        List<Material> materialList = new ArrayList<>();

        try (Connection connection = cnx.getConnectionDB();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Material material = new Material(
                        rs.getString("itemName"),
                        rs.getString("unit"),
                        rs.getDouble("quantity"),
                        rs.getDouble("price")
                );
                material.setId(rs.getLong("id"));
                materialList.add(material);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return materialList;
    }
}
