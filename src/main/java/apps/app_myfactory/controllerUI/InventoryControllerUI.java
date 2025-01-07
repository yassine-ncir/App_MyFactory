package apps.app_myfactory.controllerUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryControllerUI {
    private final Logger logger = Logger.getLogger(InventoryControllerUI.class.getName());
    @FXML public Pane invCenter;
    @FXML private BorderPane inventBorder;
    @FXML private Label botMatM;
    @FXML private Label botProdM;


    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent parent = loader.load();
            if (inventBorder != null) {
                inventBorder.setCenter(parent);
            } else {
                logger.warning("inventBorder is null; cannot set center view.");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to load view: " + fxmlFile, e);
            showErrorDialog("Error loading view: " + fxmlFile);
        }
    }

    @FXML
    public void onclickProds(ActionEvent event) {
        loadView("ProductsUI.fxml");
    }

    @FXML
    public void onclickMaterials(ActionEvent event) {
        loadView("MaterialUI.fxml");
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("View Load Failure");
        alert.setContentText(message);
        alert.showAndWait();
    }




}
