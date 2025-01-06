package apps.app_myfactory.controllerUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class InventoryControllerUI {
    @FXML private BorderPane inventBorder;
    @FXML private Label botMatM;
    @FXML private Label botProdM;

    @FXML
    public void showProductsPanel() {
        onclickProds("apps/app_myfactory/ProductsUI.fxml");
    }

    private void onclickProds(String fxmlFile){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent parent = loader.load();
            inventBorder.setCenter(parent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
