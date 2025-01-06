package apps.app_myfactory.controllerUI;

import apps.app_myfactory.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainView {
    private Main m = new Main();
    @FXML
    private Button btn_dashboard;

    @FXML
    private Button btn_employes;

    @FXML
    private Button btn_inventory;

    @FXML
    private Button btn_orders;

    @FXML
    private Label logo;

    @FXML
    void navigateToEmployes() {
        m.showEmployeesView();
    }
    @FXML
    void navigateToInventory() throws IOException {
        m.showInventoryView();
    }
    @FXML
    void navigateToDashboard() {
        m.showDashboardView();
    }
}