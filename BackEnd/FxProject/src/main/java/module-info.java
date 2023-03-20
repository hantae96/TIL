module com.example.fxproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxproject to javafx.fxml;
    exports com.example.fxproject;
}