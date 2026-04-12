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
import java.util.List;

public class deliveryFailedViewController {

    @FXML private TextField trackingIdTextField;
    @FXML private ComboBox<String> reasonComboBox;
    @FXML private Label statusMessageTextArea;

    @FXML
    public void initialize() {

        reasonComboBox.getItems().addAll(
                "Receiver Absent",
                "Wrong Address",
                "Phone Unreachable",
                "Other"
        );
    }

    @FXML
    public void submitOnAction(ActionEvent actionEvent) {

        String id = trackingIdTextField.getText().trim();
        String reason = reasonComboBox.getValue();

        if (id.isEmpty() || reason == null) {
            statusMessageTextArea.setText("Fill all fields");
            return;
        }

        List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> list = ParcelTrackFileUtil.loadParcels();

        for (com.example.postofficesystem.Mahfuz.model.ParcelTrack p : list) {

            if (p.getTrackingId().equals(id)) {

                p.setStatus("Failed");
                p.setFailureReason(reason);

                ParcelTrackFileUtil.saveAll(list);

                statusMessageTextArea.setText("Delivery marked as FAILED");
                return;
            }
        }

        statusMessageTextArea.setText("Parcel not found");
    }

    @FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/com/example/postofficesystem/Mahfuz/postManDashboardView.fxml"
        ));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}