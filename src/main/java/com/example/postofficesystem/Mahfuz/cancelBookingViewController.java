package com.example.postofficesystem.Mahfuz;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class cancelBookingViewController {

    @javafx.fxml.FXML
    private TextField trackingIdTextField;

    @javafx.fxml.FXML
    private Label currentStatusTextArea;

    @javafx.fxml.FXML
    private Label resultMessageTextArea;

    private com.example.postofficesystem.Mahfuz.model.ParcelTrack selectedParcel;

    @javafx.fxml.FXML
    public void initialize() {
        currentStatusTextArea.setText("");
        resultMessageTextArea.setText("");
    }

    // ✅ CHECK STATUS
    @javafx.fxml.FXML
    public void checkStatusOnAction(ActionEvent actionEvent) {

        String id = trackingIdTextField.getText().trim();

        if (id.isEmpty()) {
            resultMessageTextArea.setText("Enter Tracking ID");
            return;
        }

        List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> list = ParcelTrackFileUtil.loadParcels();

        for (com.example.postofficesystem.Mahfuz.model.ParcelTrack p : list) {

            if (p.getTrackingId().equals(id)) {

                selectedParcel = p;
                currentStatusTextArea.setText("Status: " + p.getStatus());
                resultMessageTextArea.setText("Found");
                return;
            }
        }

        currentStatusTextArea.setText("");
        resultMessageTextArea.setText("Parcel Not Found");
    }

    // ✅ CANCEL BOOKING
    @javafx.fxml.FXML
    public void cacncelBookingOnAction(ActionEvent actionEvent) {

        if (selectedParcel == null) {
            resultMessageTextArea.setText("Search parcel first");
            return;
        }

        if (selectedParcel.getStatus().equalsIgnoreCase("Cancelled")) {
            resultMessageTextArea.setText("Already Cancelled");
            return;
        }

        selectedParcel.setStatus("Cancelled");

        resultMessageTextArea.setText("Booking Cancelled Successfully");
        currentStatusTextArea.setText("Status: Cancelled");
    }

    // ✅ BACK BUTTON FIXED
    @javafx.fxml.FXML
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