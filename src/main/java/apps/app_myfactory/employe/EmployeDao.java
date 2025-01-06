package apps.app_myfactory.employe;

import apps.app_myfactory.product.Product;

import java.sql.SQLException;
import java.util.List;

public interface EmployeDao {
    void saveEmployeDao(Employe employe) ;
    void updateEmployeDao(Long id, Employe emp) throws SQLException;
    void deleteEmployeDao(Long id);
    Employe getEmployeByIdDao(Long id);
    List<Employe> getAllEmployeesDao();
}
