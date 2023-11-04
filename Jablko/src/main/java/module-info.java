module com.example.jablko {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jablko to javafx.fxml;
    exports com.example.jablko;
}