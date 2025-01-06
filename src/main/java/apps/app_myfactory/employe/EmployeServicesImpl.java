package apps.app_myfactory.employe;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class EmployeServicesImpl implements EmployeServices{
    private final EmployeDao employeDao;
    private final Logger logger = Logger.getLogger(EmployeServicesImpl.class.getName());
    public EmployeServicesImpl() {
        this.employeDao = new EmployeDaoImpl();
    }

    @Override
    public void createEmploye(Employe employe){
        employeDao.saveEmployeDao(employe);
    }

    @Override
    public void deleteEmploye(Long id) throws SQLException {
        if(employeDao.getEmployeByIdDao(id) != null){
            employeDao.deleteEmployeDao(id);
            logger.info("Employe deleted");
        }else{
            logger.warning("Employe with id: " + id + " does not exist.");
        }
    }

    @Override
    public void updateEmploye(Long id, Employe newEmploye) throws SQLException {
        Employe e = employeDao.getEmployeByIdDao(id);
        if(e != null){
            e.setName(newEmploye.getName());
            e.setTel(newEmploye.getTel());
            e.setAddress(newEmploye.getAddress());
            e.setSalary(newEmploye.getSalary());
            employeDao.updateEmployeDao(id,e);
            logger.info("Employe with id: " + id + " updated successfully.");
        }else{
            logger.warning("Employe with id: " + id + " does not exist.");
        }
    }

    @Override
    public Employe getEmployeById(Long id) throws SQLException {
        return employeDao.getEmployeByIdDao(id);
    }

    @Override
    public List<Employe> getAllEmployes() throws SQLException {
        return employeDao.getAllEmployeesDao();
    }
}
