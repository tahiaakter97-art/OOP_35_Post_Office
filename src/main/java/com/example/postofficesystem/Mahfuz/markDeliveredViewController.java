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

public class markDeliveredViewController {

    @javafx.fxml.FXML
    private TextField trackingIdTextField;

    @javafx.fxml.FXML
    private TextField receiverNameTextField;

    @javafx.fxml.FXML
    private Label verificationMessageTextArea;

    @javafx.fxml.FXML
    private Label successMessageTextArea;

    private com.example.postofficesystem.Mahfuz.model.ParcelTrack currentParcel = null;

    @javafx.fxml.FXML
    public void initialize() {
        verificationMessageTextArea.setText("");
        successMessageTextArea.setText("");
    }

    // ================= VERIFY PARCEL =================
    @javafx.fxml.FXML
    public void verifyParcelOnAction(ActionEvent actionEvent) {

        String id = trackingIdTextField.getText().trim();
        String receiver = receiverNameTextField.getText().trim();

        if (id.isEmpty() || receiver.isEmpty()) {
            verificationMessageTextArea.setText("Enter all fields!");
            return;
        }

        List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> list = ParcelTrackFileUtil.loadParcels();

        for (com.example.postofficesystem.Mahfuz.model.ParcelTrack p : list) {

            if (p.getTrackingId().equals(id)) {

                if (p.getReceiverName().equalsIgnoreCase(receiver)) {

                    verificationMessageTextArea.setText("✔ Parcel Verified!");
                    currentParcel = p;
                    return;

                } else {
                    verificationMessageTextArea.setText("❌ Receiver name does not match!");
                    return;
                }
            }
        }

        verificationMessageTextArea.setText("❌ Parcel not found!");
    }

    // ================= MARK DELIVERED =================
    @javafx.fxml.FXML
    public void markAsDeliveredOnAction(ActionEvent actionEvent) {

        if (currentParcel == null) {
            successMessageTextArea.setText("Verify first!");
            return;
        }

        List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> list = ParcelTrackFileUtil.loadParcels();

        for (com.example.postofficesystem.Mahfuz.model.ParcelTrack p : list) {

            if (p.getTrackingId().equals(currentParcel.getTrackingId())) {
                p.setStatus("Delivered");
            }
        }

        ParcelTrackFileUtil.saveAll(list);

        successMessageTextArea.setText("✅ Parcel Delivered Successfully!");

        currentParcel = null;
    }

    // ================= BACK BUTTON =================
    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/postmanDashboard.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}