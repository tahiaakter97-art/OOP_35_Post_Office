package com.example.postofficesystem.Mahfuz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class rescheduleDeliveryViewController {

    @FXML private TextField trackingIdTextField;
    @FXML private DatePicker newDeliveryDateDatePicker;
    @FXML private Label validationMessageTextArea;
    @FXML private Label successMessageTextArea;

    @FXML
    public void initialize() {
        validationMessageTextArea.setText("");
        successMessageTextArea.setText("");
    }

    @FXML
    public void rescheduleOnAction(ActionEvent actionEvent) {

        String id = trackingIdTextField.getText().trim();
        LocalDate newDate = newDeliveryDateDatePicker.getValue();

        // VALIDATION
        if (id.isEmpty() || newDate == null) {
            validationMessageTextArea.setText("Fill all fields");
            successMessageTextArea.setText("");
            return;
        }

        if (newDate.isBefore(LocalDate.now())) {
            validationMessageTextArea.setText("Date cannot be in past");
            successMessageTextArea.setText("");
            return;
        }

        List<com.example.postofficesystem.Mahfuz.model.ParcelTrack> list = ParcelTrackFileUtil.loadParcels();

        for (com.example.postofficesystem.Mahfuz.model.ParcelTrack p : list) {

            if (p.getTrackingId().equals(id)) {

                p.setStatus("Rescheduled");
                p.setRescheduleDate(newDate.toString());

                ParcelTrackFileUtil.saveAll(list);

                validationMessageTextArea.setText("");
                successMessageTextArea.setText("Delivery Rescheduled Successfully");
                return;
            }
        }

        validationMessageTextArea.setText("Parcel not found");
        successMessageTextArea.setText("");
    }

    @FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/postManDashboardView.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}