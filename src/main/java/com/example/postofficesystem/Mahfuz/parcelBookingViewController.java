package com.example.postofficesystem.Mahfuz;

//import com.example.postofficesystem.Mahfuz.Parcel;
//import com.example.postofficesystem.Mahfuz.FileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
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

    @javafx.fxml.FXML
    public void initialize() {
        parcelTypeComboBox.getItems().addAll("Normal", "Fragile", "Document");
        successMessageTextArea.setText("");
        trackingIdTextArea.setText("");
        calculateChargeArea.setText("");
    }

    // ── BACK ──────────────────────────────────────────────────────────────────
    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/CounterClerkDashboard.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // ── CALCULATE CHARGE ──────────────────────────────────────────────────────
    @javafx.fxml.FXML
    public void calculateChargeOnAction(ActionEvent actionEvent) {
        try {
            double weight = Double.parseDouble(weightTextField.getText().trim());

            if (weight <= 0) {
                calculateChargeArea.setText("Weight must be > 0");
                return;
            }

            String type = parcelTypeComboBox.getValue();
            if (type == null) {
                calculateChargeArea.setText("Select parcel type");
                return;
            }

            switch (type) {
                case "Normal"   -> charge = weight * 50;
                case "Fragile"  -> charge = weight * 100;
                case "Document" -> charge = weight * 30;
            }

            calculateChargeArea.setText("৳ " + charge);

        } catch (NumberFormatException e) {
            calculateChargeArea.setText("Invalid weight");
        }
    }

    // ── BOOK PARCEL ───────────────────────────────────────────────────────────
    @javafx.fxml.FXML
    public void bookParcelOnAction(ActionEvent actionEvent) {

        String senderName    = senderNameTextField.getText().trim();
        String senderPhone   = senderPhoneTextField.getText().trim();
        String receiverName  = receiverNameTextField.getText().trim();
        String receiverPhone = receiverPhoneTextField.getText().trim();
        String address       = receiverAddressTextField.getText().trim();
        String weightStr     = weightTextField.getText().trim();
        String type          = parcelTypeComboBox.getValue();

        // ── Validation ────────────────────────────────────────────────────────
        if (senderName.isEmpty() || receiverName.isEmpty() ||
                senderPhone.isEmpty() || receiverPhone.isEmpty() ||
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
            if (weight <= 0) {
                successMessageTextArea.setText("Weight must be > 0");
                return;
            }
        } catch (NumberFormatException e) {
            successMessageTextArea.setText("Invalid weight");
            return;
        }

        if (charge == 0) {
            successMessageTextArea.setText("Click Calculate first");
            return;
        }

        // ── Generate Tracking ID ──────────────────────────────────────────────
        String trackingId = "TRK" + (10000 + new Random().nextInt(89999));
        String date = LocalDate.now().toString();

        // ── Create Parcel object ──────────────────────────────────────────────
        Parcel parcel = new Parcel(
                trackingId, senderName, senderPhone,
                receiverName, receiverPhone, address,
                weight, type, charge, "Booked", "", date
        );

        // ── Save to .bin file ─────────────────────────────────────────────────
        //FileManager.saveParcel(parcel);

        // ── Show result ───────────────────────────────────────────────────────
        trackingIdTextArea.setText(trackingId);
        successMessageTextArea.setText("Booking Successful!");
    }
}