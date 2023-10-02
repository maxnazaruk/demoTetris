module com.example.demotetris {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demotetris to javafx.fxml;
    exports com.example.demotetris;
}