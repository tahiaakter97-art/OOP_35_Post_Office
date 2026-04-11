package com.example.postofficesystem.Mahfuz;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class parcelBookingViewController {

    @javafx.fxml.FXML
    private TextField senderNameTextField;
    @javafx.fxml.FXML
    private TextField receiverNameTextField;
    @javafx.fxml.FXML
    private Label calculateChargeArea;
    @javafx.fxml.FXML
    private TextField receiverPhoneTextField;
    @javafx.fxml.FXML
    private ComboBox<String> parcelTypeComboBox;
    @javafx.fxml.FXML
    private TextField receiverAddressTextField;
    @javafx.fxml.FXML
    private Label trackingIdTextArea;
    @javafx.fxml.FXML
    private Label successMessageTextArea;
    @javafx.fxml.FXML
    private TextField senderPhoneTextField;
    @javafx.fxml.FXML
    private TextField weightTextField;

    private double charge = 0;

    // EVENT-2 / INIT
    @javafx.fxml.FXML
    public void initialize() {
        parcelTypeComboBox.getItems().addAll("Normal", "Fragile", "Document");
        successMessageTextArea.setText("");
        trackingIdTextArea.setText("");
        calculateChargeArea.setText("");
    }

    // EVENT-7 + EVENT-6 VALIDATION
    private boolean validateInputs() {

        if (senderNameTextField.getText().isEmpty()
                || receiverNameTextField.getText().isEmpty()
                || senderPhoneTextField.getText().isEmpty()
                || receiverPhoneTextField.getText().isEmpty()
                || receiverAddressTextField.getText().isEmpty()
                || weightTextField.getText().isEmpty()
                || parcelTypeComboBox.getValue() == null) {

            successMessageTextArea.setText("❌ All fields required");
            return false;
        }

        if (senderPhoneTextField.getText().length() != 11
                || receiverPhoneTextField.getText().length() != 11) {

            successMessageTextArea.setText("❌ Phone must be 11 digits");
            return false;
        }

        return true;
    }

    // EVENT-8 CALCULATE CHARGE
    private void calculateCharge() {

        double weight = Double.parseDouble(weightTextField.getText());
        String type = parcelTypeComboBox.getValue();

        if (weight <= 0) {
            successMessageTextArea.setText("❌ Weight must be > 0");
            return;
        }

        if (type.equals("Document")) {
            charge = weight * 50;
        } else if (type.equals("Normal")) {
            charge = weight * 100;
        } else if (type.equals("Fragile")) {
            charge = weight * 150;
        }

        calculateChargeArea.setText("৳ " + charge);
    }

    // EVENT-9 TRACKING ID
    private String generateTrackingId() {
        return "TRK-" + (10000 + new Random().nextInt(90000));
    }

    // EVENT-10 SAVE CSV
    private void saveToCSV(String trackingId) {

        try (FileWriter fw = new FileWriter("parcel_booking.csv", true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(
                    trackingId + "," +
                            senderNameTextField.getText() + "," +
                            senderPhoneTextField.getText() + "," +
                            receiverNameTextField.getText() + "," +
                            receiverPhoneTextField.getText() + "," +
                            receiverAddressTextField.getText() + "," +
                            weightTextField.getText() + "," +
                            parcelTypeComboBox.getValue() + "," +
                            charge
            );

            bw.newLine();

        } catch (IOException e) {
            successMessageTextArea.setText("❌ File Error");
        }
    }

    // EVENT-11 BOOK PARCEL (MAIN FLOW)
    @javafx.fxml.FXML
    public void bookParcelOnAction(ActionEvent actionEvent) {

        // validation
        if (!validateInputs()) return;

        // calculate
        calculateCharge();

        // tracking id
        String trackingId = generateTrackingId();
        trackingIdTextArea.setText(trackingId);

        // save
        saveToCSV(trackingId);

        // success message
        successMessageTextArea.setText("✅ Parcel Booked Successfully!");
    }

    // BACK EVENT
    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("CounterClerkDashboard.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource())
                .getScene()
                .getWindow();

        stage.setScene(scene);
        stage.show();
    }

    // OPTIONAL MANUAL CALCULATE BUTTON
    @javafx.fxml.FXML
    public void calculateChargeOnAction(ActionEvent actionEvent) {
        calculateCharge();
    }
}