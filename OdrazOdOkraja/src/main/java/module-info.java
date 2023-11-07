module com.example.odrazodokraja {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.odrazodokraja to javafx.fxml;
    exports com.example.odrazodokraja;
}