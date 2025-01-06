package apps.app_myfactory.factory;

import java.sql.SQLException;

public interface FactoryDao {
    void saveFactoryDao(Factory factory) throws SQLException;
}
