package apps.app_myfactory.factory;

import java.sql.SQLException;

public interface FactoryServices {
    void createFactory(Factory factory) throws SQLException;
}
