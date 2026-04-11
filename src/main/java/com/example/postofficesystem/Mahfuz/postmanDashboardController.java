package com.example.postofficesystem.Mahfuz;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class postmanDashboardController {

    @javafx.fxml.FXML
    public void initialize() {
    }

    private void switchScene(ActionEvent actionEvent, String fxml, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Mahfuz/" + fxml));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    @javafx.fxml.FXML
    public void markDeliveredOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(actionEvent, "markDelivered.fxml", "Mark Delivered");
    }

    @javafx.fxml.FXML
    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/UserLogInDashboard.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void reportDamagedParcelOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(actionEvent, "reportDamagedParcel.fxml", "Report Damaged Parcel");
    }

    @javafx.fxml.FXML
    public void rescheduleDeliveryOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(actionEvent, "rescheduleDelivery.fxml", "Reschedule Delivery");
    }

    @javafx.fxml.FXML
    public void deliveryReportOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(actionEvent, "deliveryReport.fxml", "Delivery Report");
    }

    @javafx.fxml.FXML
    public void viewAssignedParcelsOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(actionEvent, "viewAssignedParcels.fxml", "Assigned Parcels");
    }

    @javafx.fxml.FXML
    public void returnParcelOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(actionEvent, "returnParcel.fxml", "Return Parcel");
    }

    @javafx.fxml.FXML
    public void deliveryFailedOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(actionEvent, "deliveryFailed.fxml", "Delivery Failed");
    }

    @javafx.fxml.FXML
    public void collectSignatureOnAction(ActionEvent actionEvent) throws IOException {
        switchScene(actionEvent, "collectSignature.fxml", "Collect Signature");
    }
}