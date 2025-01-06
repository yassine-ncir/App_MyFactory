module apps.app_myfactory {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens apps.app_myfactory to javafx.fxml;
    exports apps.app_myfactory;
    exports apps.app_myfactory.controllerUI;
    opens apps.app_myfactory.controllerUI to javafx.fxml;
    opens apps.app_myfactory.employe; // Opens package to all
    opens apps.app_myfactory.Enum to javafx.fxml;
}