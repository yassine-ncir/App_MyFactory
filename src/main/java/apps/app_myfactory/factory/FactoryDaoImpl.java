package apps.app_myfactory.factory;

import apps.app_myfactory.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FactoryDaoImpl implements FactoryDao{
    private  ConnectionDB cnx = new ConnectionDB();
    @Override
    public void saveFactoryDao(Factory factory) {
        String req = "INSERT INTO factory (name,password) VALUES(?,?)";
        try (Connection conn = cnx.getConnectionDB();
        PreparedStatement ps = conn.prepareStatement(req)) {
            ps.setString(1,factory.getName());
            ps.setString(2, factory.getPassword());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
