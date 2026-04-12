package com.example.postofficesystem.Mahfuz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class reportDamagedParcelViewController {

    @FXML
    private ComboBox<String> damageTypeComboBox;

    @FXML
    private TextField trackingIdTextField;

    @FXML
    private Label confirmationMessageLabel;

    @FXML
    public void initialize() {
        damageTypeComboBox.getItems().addAll(
                "Broken",
                "Water Damage",
                "Lost Part",
                "Open Package",
                "Other"
        );
    }

    @FXML
    public void reportDamageOnAction(ActionEvent actionEvent) {

        String trackingId = trackingIdTextField.getText();
        String damageType = damageTypeComboBox.getValue();

        if (trackingId == null || trackingId.isEmpty() || damageType == null) {
            confirmationMessageLabel.setText("Please fill all fields!");
            return;
        }

        confirmationMessageLabel.setText(
                "Damage reported successfully for ID: " + trackingId +
                        " (" + damageType + ")"
        );

        trackingIdTextField.clear();
        damageTypeComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/postManDashboardView.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource())
                .getScene()
                .getWindow();

        stage.setScene(scene);
    }
}