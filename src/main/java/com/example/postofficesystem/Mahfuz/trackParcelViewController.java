package com.example.postofficesystem.Mahfuz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class trackParcelViewController {

    @FXML private TextField trackingIdTextField;
    @FXML private Label senderNameTextArea;
    @FXML private Label receiverNameTextArea;
    @FXML private Label addressTextArea;
    @FXML private Label statusTextArea;
    @FXML private Label notFoundTextArea;

    @FXML
    public void initialize() {
        notFoundTextArea.setText("");
    }

    @FXML
    public void searchOnAction(ActionEvent actionEvent) {

        String id = trackingIdTextField.getText().trim();

        if (id.isEmpty()) {
            notFoundTextArea.setText("Enter Tracking ID");
            return;
        }

        List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> parcels = ParcelTrackFileUtil.loadParcels();

        for (com.example.postofficesystem.Mahfuz.model.ParcelTrack p : parcels) {

            if (p.getTrackingId().equalsIgnoreCase(id)) {

                senderNameTextArea.setText("Sender: " + p.getSenderName());
                receiverNameTextArea.setText("Receiver: " + p.getReceiverName());
                addressTextArea.setText("Address: " + p.getReceiverAddress());
                statusTextArea.setText("Status: " + p.getStatus());

                notFoundTextArea.setText("");
                return;
            }
        }

        notFoundTextArea.setText("Parcel Not Found");

        senderNameTextArea.setText("");
        receiverNameTextArea.setText("");
        addressTextArea.setText("");
        statusTextArea.setText("");
    }

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