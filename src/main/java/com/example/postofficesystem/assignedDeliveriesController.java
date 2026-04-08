package com.example.postofficesystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class assignedDeliveriesController {

    @javafx.fxml.FXML
    private TableView<Delivery> assignedDeliveriesTV;
    @javafx.fxml.FXML
    private TableColumn<Delivery, Integer> deliveryIDTC;
    @javafx.fxml.FXML
    private TableColumn<Delivery, String> mailTypeTC;
    @javafx.fxml.FXML
    private TableColumn<Delivery, String> receiverNameTC;
    @javafx.fxml.FXML
    private TableColumn<Delivery, String> deliveryAddressTC;
    @javafx.fxml.FXML
    private TableColumn<Delivery, String> deliveryStatusTC;
    @javafx.fxml.FXML
    private TextField deliveryIdTF;
    @javafx.fxml.FXML
    private TextField receiverNameTF;
    @javafx.fxml.FXML
    private TextField deliveryAddressTF;
    @javafx.fxml.FXML
    private ComboBox<String> mailTypeCB;
    @javafx.fxml.FXML
    private ComboBox<String> deliveryStatusCB;


    private ObservableList<Delivery> deliveryList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        mailTypeCB.getItems().addAll("Letter", "Parcel");
        deliveryStatusCB.getItems().addAll("Pending", "Out for Delivery", "Received");

        deliveryIDTC.setCellValueFactory(new PropertyValueFactory<>("deliveryId"));
        mailTypeTC.setCellValueFactory(new PropertyValueFactory<>("mailType"));
        receiverNameTC.setCellValueFactory(new PropertyValueFactory<>("receiverName"));
        deliveryAddressTC.setCellValueFactory(new PropertyValueFactory<>("address"));
        deliveryStatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        assignedDeliveriesTV.setItems(deliveryList);
    }

    @javafx.fxml.FXML
    public void addDeliveryButtonOA(ActionEvent actionEvent) {

        if (mailTypeCB.getValue() == null || deliveryStatusCB.getValue() == null
                || receiverNameTF.getText().isEmpty()
                || deliveryAddressTF.getText().isEmpty()
                || deliveryIdTF.getText().isEmpty()) {

            showAlert("Please fill all fields!");
            return;
        }

        try {
            int deliveryId = Integer.parseInt(deliveryIdTF.getText());

            Delivery newDelivery = new Delivery(
                    deliveryId,
                    mailTypeCB.getValue(),
                    receiverNameTF.getText(),
                    deliveryAddressTF.getText(),
                    deliveryStatusCB.getValue()
            );

            deliveryList.add(newDelivery);
            showAlert("New delivery added successfully!");

            clearFields();

        } catch (NumberFormatException e) {
            showAlert("Please enter a valid number for Delivery ID.");
        }
    }


    @javafx.fxml.FXML
    public void updateDeliveryButtonOA(ActionEvent actionEvent) {

        Delivery selected = assignedDeliveriesTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Please select a delivery to update.");
            return;
        }

        try {
            selected.setDeliveryId(Integer.parseInt(deliveryIdTF.getText()));
        } catch (NumberFormatException e) {
            showAlert("Please enter a valid number for Delivery ID.");
            return;
        }

        selected.setMailType(mailTypeCB.getValue());
        selected.setReceiverName(receiverNameTF.getText());
        selected.setAddress(deliveryAddressTF.getText());
        selected.setStatus(deliveryStatusCB.getValue());

        assignedDeliveriesTV.refresh();
        showAlert("Delivery updated successfully!");

        clearFields();
    }




    @FXML
    public void logOutButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("postmasterDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void clearFields() {
        deliveryIdTF.clear();
        receiverNameTF.clear();
        deliveryAddressTF.clear();
        mailTypeCB.getSelectionModel().clearSelection();
        deliveryStatusCB.getSelectionModel().clearSelection();
    }
}


