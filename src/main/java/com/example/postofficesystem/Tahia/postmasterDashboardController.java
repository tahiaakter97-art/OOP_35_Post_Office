package com.example.postofficesystem.Tahia;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class postmasterDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void assignedDeliveriesButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("assignedDeliveries.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Use the current stage instead of opening a new one
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void staffManagementButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mailAndParcelFlowButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateReportsButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveFinancialReportsButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void manageAnnouncementsButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void inventoryManagementButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void publicProfileSettingsButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logOutButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPostMaster.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}