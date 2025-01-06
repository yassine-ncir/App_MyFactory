package apps.app_myfactory.factory;

import java.sql.SQLException;

public class FactoryServicesImlp implements FactoryServices {
    private FactoryDao factoryDao = new FactoryDaoImpl();
    @Override
    public void createFactory(Factory factory) throws SQLException {
        factoryDao.saveFactoryDao(factory);
    }
}
