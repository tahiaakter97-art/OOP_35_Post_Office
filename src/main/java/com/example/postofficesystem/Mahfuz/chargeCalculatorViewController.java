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

public class chargeCalculatorViewController {

    @FXML private TextField weightTextField;
    @FXML private ComboBox<String> distanceComboBox;
    @FXML private ComboBox<String> serviceTypeComboBox;
    @FXML private Label totalChargeTextArea;

    private double totalCharge = 0;

    @FXML
    public void initialize() {

        distanceComboBox.getItems().addAll(
                "Local",
                "National"
        );

        serviceTypeComboBox.getItems().addAll(
                "Normal",
                "Speed"
        );

        totalChargeTextArea.setText("");
    }

    @FXML
    public void chargeCalculateOnAction(ActionEvent actionEvent) {

        try {
            double weight = Double.parseDouble(weightTextField.getText().trim());

            if (weight <= 0) {
                totalChargeTextArea.setText("Weight must be > 0");
                return;
            }

            String distance = distanceComboBox.getValue();
            String service = serviceTypeComboBox.getValue();

            if (distance == null || service == null) {
                totalChargeTextArea.setText("Select all options");
                return;
            }

            // BASE CHARGE
            if (distance.equals("Local")) {
                totalCharge = weight * 20;
            } else {
                totalCharge = weight * 50;
            }

            // SERVICE CHARGE
            if (service.equals("Speed")) {
                totalCharge += 50;
            }

            totalChargeTextArea.setText("Total Charge: " + totalCharge + " ৳");

        } catch (NumberFormatException e) {
            totalChargeTextArea.setText("Invalid weight");
        }
    }

    // BACK BUTTON
    @FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/counterClerkDashboard.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}