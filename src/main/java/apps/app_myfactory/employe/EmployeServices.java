package apps.app_myfactory.employe;

import java.sql.SQLException;
import java.util.List;

public interface EmployeServices {
    void createEmploye(Employe employe);
    void deleteEmploye(Long id) throws SQLException;
    void updateEmploye(Long id, Employe newEmploye) throws SQLException;
    Employe getEmployeById(Long id) throws SQLException;
    List<Employe> getAllEmployes() throws SQLException;

}
