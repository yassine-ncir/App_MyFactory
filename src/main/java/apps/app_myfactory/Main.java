package apps.app_myfactory;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static BorderPane rootLayer;
    @Override
    public void start(Stage stage) throws IOException {
        // Load the main layout
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainView.fxml"));
        rootLayer = loader.load();
        Scene scene = new Scene(rootLayer);
        stage.setTitle("MyFactory App");
        stage.setScene(scene);
        stage.show();

        // Default view
        showEmployeesView();
    }

    // Method to load the Employees view
    @FXML
    public void showEmployeesView() {
        loadView("EmployesUI.fxml");
    }

    // Method to load the Employees view
    @FXML
    public void showInventoryView() {
        loadView("InventoryUI.fxml");
    }

    @FXML
    public void showDashboardView() {
        loadView("DashboardUI.fxml");
    }

    // Utility method to load views dynamically
    private void loadView(String fxmlFile) {
        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent view = l.load();
            rootLayer.setCenter(view); // Replace the center of the BorderPane
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}