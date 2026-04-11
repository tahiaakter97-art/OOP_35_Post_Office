package com.example.postofficesystem.Mahfuz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class returnParcelViewController {

    @FXML private TextField trackingIdTextField;
    @FXML private Label attemptCountTextArea;
    @FXML private Label statusMessageTextArea;

    private com.example.postofficesystem.Mahfuz.model.ParcelTrack currentParcel = null;

    @FXML
    public void initialize() {
        attemptCountTextArea.setText("");
        statusMessageTextArea.setText("");
    }

    // ================= CHECK ATTEMPT =================
    @FXML
    public void checkAttemptOnAction(ActionEvent actionEvent) {

        String id = trackingIdTextField.getText().trim();

        if (id.isEmpty()) {
            statusMessageTextArea.setText("Enter Tracking ID");
            return;
        }

        List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> list = ParcelTrackFileUtil.loadParcels();

        for (com.example.postofficesystem.Mahfuz.model.ParcelTrack p : list) {

            if (p.getTrackingId().equals(id)) {

                attemptCountTextArea.setText("Attempts: " + p.getAttemptCount());
                currentParcel = p;
                return;
            }
        }

        statusMessageTextArea.setText("Parcel not found");
    }

    // ================= RETURN PARCEL =================
    @FXML
    public void returnParcelOnAction(ActionEvent actionEvent) {

        if (currentParcel == null) {
            statusMessageTextArea.setText("Check attempt first!");
            return;
        }

        List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> list = ParcelTrackFileUtil.loadParcels();

        for (com.example.postofficesystem.Mahfuz.model.ParcelTrack p : list) {

            if (p.getTrackingId().equals(currentParcel.getTrackingId())) {

                if (p.getAttemptCount() >= 2) {

                    p.setStatus("Returned");
                    ParcelTrackFileUtil.saveAll(list);

                    statusMessageTextArea.setText("Parcel Returned Successfully");

                } else {
                    statusMessageTextArea.setText("Cannot return (attempt < 2)");
                }

                return;
            }
        }
    }
}