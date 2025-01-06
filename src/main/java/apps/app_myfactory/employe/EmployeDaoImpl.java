package apps.app_myfactory.employe;

import apps.app_myfactory.Enum.EmployeCategory;
import apps.app_myfactory.utils.ConnectionDB;
import apps.app_myfactory.utils.Utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static apps.app_myfactory.utils.Utility.getEnumValue;

public class EmployeDaoImpl implements EmployeDao{
    private final ConnectionDB cnx = new ConnectionDB();
    private final Logger logger = Logger.getLogger(EmployeDaoImpl.class.getName());


    @Override
    public void saveEmployeDao(Employe employe) {
        String req = "INSERT INTO Employes (name, tel, address, salary, category) VALUES (?, ?, ?, ?,?)";
        try (Connection connection = cnx.getConnectionDB();
             PreparedStatement ps = connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, employe.getName());
            ps.setString(2, employe.getTel());
            ps.setString(3, employe.getAddress());
            ps.setFloat(4, employe.getSalary());
            ps.setString(5, employe.getCategory().name());
            ps.addBatch();
            int test = ps.executeUpdate();
            if (test > 0) {
                logger.info("Successfully inserted employe "+ employe.getName());
            }
        } catch (SQLException e) {
            logger.severe("Error saving employe: "+employe.getName()+ " " + e.getMessage());
        }
    }

    @Override
    public void updateEmployeDao(Long id, Employe emp){
        String query = "UPDATE Employes SET name = ?, tel = ?, address = ?, salary = ?, category =? WHERE id = ?";
        try (Connection con = cnx.getConnectionDB();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getTel());
            stmt.setString(3, emp.getAddress());
            stmt.setFloat(4, emp.getSalary());
            stmt.setString(5, emp.getCategory().name());
            stmt.setLong(6, id);
            stmt.executeUpdate();
            logger.info(emp.getName() + " are updated successfully");
        }catch (Exception e){
            logger.severe("Error updating employe: " + emp.getName() +" "+ e.getMessage());
        }
    }

    // Delete Employe
    @Override
    public void deleteEmployeDao(Long id)  {
        String req = "DELETE FROM Employes WHERE id = ?";
        try (Connection connection = cnx.getConnectionDB();
             PreparedStatement ps = connection.prepareStatement(req)) {

            ps.setLong(1, id);
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                logger.info("Employe deleted with ID: " + id);
            } else {
                logger.info("No employe found with ID: " + id);
            }
        } catch (SQLException e) {
            logger.warning("Error deleting employe: " + e.getMessage());
        }
    }

    // Get Employe by ID
    @Override
    public Employe getEmployeByIdDao(Long id){
        String req = "SELECT * FROM Employes WHERE id = ?";
        try (Connection connection = cnx.getConnectionDB();
             PreparedStatement ps = connection.prepareStatement(req)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    return new Employe(
                            rs.getString("name"),
                            rs.getString("tel"),
                            rs.getString("address"),
                            rs.getFloat("salary"),
                            getEnumValue(EmployeCategory.class, rs.getString("category"), null) // Default value as null
                    );
                } else {
                    logger.info("No employe found with ID: " + id);
                }
            }
        } catch (SQLException e) {
            logger.warning("Error retrieving employe: " + e.getMessage());
        }
        return null;
    }

    // Get All Employees
    @Override
    public List<Employe> getAllEmployeesDao() {
        String req = "SELECT * FROM Employes";
        List<Employe> list = new ArrayList<>();

        try (Connection connection = cnx.getConnectionDB();
             PreparedStatement ps = connection.prepareStatement(req)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employe employe = new Employe(
                        rs.getString("name"),
                        rs.getString("tel"),
                        rs.getString("address"),
                        rs.getFloat("salary"),
                        getEnumValue(EmployeCategory.class,rs.getString("category"),null) // Default value as null
                );
                employe.setId(rs.getLong("id"));
                list.add(employe);
             }
             logger.log(Level.FINE,"Employes are fetched from DB ");
        } catch (SQLException e) {
            logger.severe("Error fetching all employees: " + e.getMessage());
        }
        return list; // Return the populated list
    }
}
