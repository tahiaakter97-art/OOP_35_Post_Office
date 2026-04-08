module com.example.postofficesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.postofficesystem to javafx.fxml;
    exports com.example.postofficesystem;
}