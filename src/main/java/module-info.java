module com.example.postofficesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.postofficesystem to javafx.fxml;
    exports com.example.postofficesystem;

    opens com.example.postofficesystem.Mahfuz to javafx.fxml;
    exports com.example.postofficesystem.Mahfuz;

    opens com.example.postofficesystem.Tahia to javafx.fxml;
    exports com.example.postofficesystem.Tahia;
}