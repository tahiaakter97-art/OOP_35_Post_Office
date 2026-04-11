package com.example.postofficesystem.Mahfuz;

import com.example.postofficesystem.Mahfuz.model.Parcel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class parcelBookingViewController {

    @javafx.fxml.FXML private TextField senderNameTextField;
    @javafx.fxml.FXML private TextField senderPhoneTextField;
    @javafx.fxml.FXML private TextField receiverNameTextField;
    @javafx.fxml.FXML private TextField receiverPhoneTextField;
    @javafx.fxml.FXML private TextField receiverAddressTextField;
    @javafx.fxml.FXML private TextField weightTextField;
    @javafx.fxml.FXML private ComboBox<String> parcelTypeComboBox;

    @javafx.fxml.FXML private Label calculateChargeArea;
    @javafx.fxml.FXML private Label trackingIdTextArea;
    @javafx.fxml.FXML private Label successMessageTextArea;

    private double charge = 0;

    @javafx.fxml.FXML
    public void initialize() {
        parcelTypeComboBox.getItems().addAll("Normal", "Fragile", "Document");
    }

    // BACK
    @javafx.fxml.FXML
    public void backOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/CounterClerkDashboard.fxml")
        );
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    // CALCULATE CHARGE
    @javafx.fxml.FXML
    public void calculateChargeOnAction(ActionEvent event) {

        try {
            double weight = Double.parseDouble(weightTextField.getText());

            if (weight <= 0) {
                calculateChargeArea.setText("Invalid weight");
                return;
            }

            String type = parcelTypeComboBox.getValue();

            if (type == null) {
                calculateChargeArea.setText("Select type");
                return;
            }

            if (type.equals("Normal")) {
                charge = weight * 50;
            } else if (type.equals("Fragile")) {
                charge = weight * 100;
            } else {
                charge = weight * 30;
            }

            calculateChargeArea.setText("Charge: " + charge);

        } catch (Exception e) {
            calculateChargeArea.setText("Invalid input");
        }
    }

    // BOOK PARCEL
    @javafx.fxml.FXML
    public void bookParcelOnAction(ActionEvent event) {

        String senderName = senderNameTextField.getText();
        String senderPhone = senderPhoneTextField.getText();
        String receiverName = receiverNameTextField.getText();
        String receiverPhone = receiverPhoneTextField.getText();
        String address = receiverAddressTextField.getText();
        String weightStr = weightTextField.getText();
        String type = parcelTypeComboBox.getValue();

        // VALIDATION
        if (senderName.isEmpty() || senderPhone.isEmpty() ||
                receiverName.isEmpty() || receiverPhone.isEmpty() ||
                address.isEmpty() || weightStr.isEmpty() || type == null) {

            successMessageTextArea.setText("Fill all fields");
            return;
        }

        if (senderPhone.length() != 11 || receiverPhone.length() != 11) {
            successMessageTextArea.setText("Phone must be 11 digits");
            return;
        }

        double weight;
        try {
            weight = Double.parseDouble(weightStr);
        } catch (Exception e) {
            successMessageTextArea.setText("Invalid weight");
            return;
        }

        if (charge == 0) {
            successMessageTextArea.setText("Calculate charge first");
            return;
        }

        // TRACKING ID
        String trackingId = "TRK" + (10000 + new Random().nextInt(90000));

        // MODEL OBJECT
        Parcel parcel = new Parcel(
                trackingId,
                senderName,
                senderPhone,
                receiverName,
                receiverPhone,
                address,
                weight,
                type,
                charge,
                "Booked",
                LocalDate.now().toString()
        );

        // SAVE TO CSV
        saveToCSV(parcel);

        trackingIdTextArea.setText(trackingId);
        successMessageTextArea.setText("Booking Successful!");
    }

    // CSV FUNCTION
    private void saveToCSV(Parcel parcel) {
        try {
            FileWriter fw = new FileWriter("parcels.csv", true);
            fw.write(parcel.toCSV() + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}