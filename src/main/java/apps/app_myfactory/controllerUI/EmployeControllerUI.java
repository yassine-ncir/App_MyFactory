package apps.app_myfactory.controllerUI;

import apps.app_myfactory.Enum.EmployeCategory;
import apps.app_myfactory.employe.Employe;
import apps.app_myfactory.employe.EmployeServices;
import apps.app_myfactory.employe.EmployeServicesImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Float.parseFloat;

public class EmployeControllerUI {
    private final Logger logger = Logger.getLogger(EmployeControllerUI.class.getName());
    private final EmployeServices employeServices = new EmployeServicesImpl();
    // buttons
    @FXML private Button botDelEmpl;
    @FXML private Button botSaveEmp;
    @FXML private Button botUpdateEmpl;
    // columns
    @FXML private TableColumn<Employe, String> col_adress;
    @FXML private TableColumn<Employe, Long> col_id;
    @FXML private TableColumn<Employe, String> col_name;
    @FXML private TableColumn<Employe, Float> col_salary;
    @FXML private TableColumn<Employe, String> col_tel;
    @FXML private TableColumn<Employe,EmployeCategory> col_category;
    // fields
    @FXML private TextField employeAdress;
    @FXML private ComboBox<EmployeCategory> employeCategory;
    @FXML private TextField employeName;
    @FXML private TextField employeSalary;
    @FXML private TextField employeTel;
    // table employes
    @FXML private TableView<Employe> table_employes;

    // ObservableList for TableView
    @FXML
    private final ObservableList<Employe> employeeList = FXCollections.observableArrayList();

    // Initialize method to set up the TableView
    @FXML
    public void initialize() throws SQLException {
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        col_adress.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        col_category.setCellValueFactory(new PropertyValueFactory<>("category"));

        employeeList.setAll(employeServices.getAllEmployes());
        table_employes.setItems(employeeList);

        employeCategory.getItems().addAll(EmployeCategory.values());
    }

    @FXML
    public void onClickSave(ActionEvent event) {
        String name = String.valueOf(employeName.getText());
        String adress = String.valueOf(employeAdress.getText());
        String tel = String.valueOf(employeTel.getText());
        float salary = parseFloat(employeSalary.getText());
        EmployeCategory category = employeCategory.getValue();
        if (employeName.getText().isEmpty() && employeSalary.getText().isEmpty() && employeTel.getText().isEmpty() && employeAdress.getText().isEmpty() && employeCategory.isCache()){
            getMessage("Please fill the fields.");
            return;
        }else {
            Employe emp = new Employe(name, tel, adress, salary,category);
            try {
                employeServices.createEmploye(emp);
                employeeList.add(emp);
                clearFields();
                getMessage("Employe saved successfully");
                logger.log(Level.INFO,"Employ are saved successfully");
            }catch (Exception e) {
                getMessage("Employe failed to save");
                e.getMessage();
            }
        }
    }

    @FXML
    public void onClickDel(ActionEvent event) throws SQLException {
        Employe selectedItem = table_employes.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            getMessage("Please select an employee to remove.");
            return;
        }
        employeServices.deleteEmploye(selectedItem.getId());
        employeeList.remove(selectedItem);
        getMessage("Employee removed successfully.");
        logger.log(Level.INFO,"Employ are removed successfully");
    }
    @FXML
    public void onClickUpdate(ActionEvent event) throws SQLException {
        Employe selectedItem = table_employes.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            getMessage("Please select an employee to update.");
            return;
        }else if (employeName.getText().isEmpty() && employeSalary.getText().isEmpty() && employeTel.getText().isEmpty() && employeAdress.getText().isEmpty() && employeCategory.isCache()){
            getMessage("Please fill the fields.");
            return;
        }
        String name = String.valueOf(employeName.getText());
        String adress = String.valueOf(employeAdress.getText());
        String tel = String.valueOf(employeTel.getText());
        float salary = parseFloat(employeSalary.getText());
        EmployeCategory category = employeCategory.getValue();
        Employe emp = new Employe(name, tel, adress, salary,category);
        //update employee in the database
        employeServices.updateEmploye(selectedItem.getId(), emp);
        //update employee in the interface
        int index = table_employes.getItems().indexOf(selectedItem);
        if (index != -1){
            table_employes.getItems().set(index,emp);
        }
        getMessage("Employe updated successfully.");
        clearFields();
    }

    @FXML
    private void clearFields() {
        employeName.clear();
        employeAdress.clear();
        employeTel.clear();
        employeSalary.clear();
        employeCategory.setValue(null);
    }
    @FXML
    public void getMessage(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }


}
