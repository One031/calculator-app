module com.admin.calculatorapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.admin.calculatorapp to javafx.fxml;
    exports com.admin.calculatorapp;
}
