package com.example.postofficesystem.Tahia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class assignedDeliveriesController {
    @javafx.fxml.FXML
    private TableColumn<Delivery, String> deliveryStatusTC;
    @javafx.fxml.FXML
    private TableColumn<Delivery, String> mailTypeTC;
    @javafx.fxml.FXML
    private TableColumn<Delivery, String> deliveryAddressTC;
    @javafx.fxml.FXML
    private TableColumn<Delivery, String> receiverNameTC;
    @javafx.fxml.FXML
    private TableView<Delivery> assignedDeliveriesTV;
    @javafx.fxml.FXML
    private TableColumn<Delivery, Integer> deliveryIDTC;
    @javafx.fxml.FXML
    private TextField deliveryIdTF;
    @javafx.fxml.FXML
    private ComboBox <String> deliveryStatusCB;
    @javafx.fxml.FXML
    private ComboBox <String> mailTypeCB;
    @javafx.fxml.FXML
    private TextField deliveryAddressTF;
    @javafx.fxml.FXML
    private TextField receiverNameTF;

    private ObservableList<Delivery> deliveryList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        mailTypeCB.getItems().addAll("Letter","Parcel");
        deliveryStatusCB.getItems().addAll("Pending","Out for Delivery","Received");
        deliveryIDTC.setCellValueFactory(new PropertyValueFactory<>("deliveryId"));
        mailTypeTC.setCellValueFactory(new PropertyValueFactory<>("mailType"));
        receiverNameTC.setCellValueFactory(new PropertyValueFactory<>("receiverName"));
        deliveryAddressTC.setCellValueFactory(new PropertyValueFactory<>("address"));
        deliveryStatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

    }
    private void addSampleDeliveries() {
        deliveryList.add(new Delivery(1, "Letter", "Rahim", "Dhaka", "Pending"));
        deliveryList.add(new Delivery(2, "Parcel", "Karim", "Chittagong", "Out for Delivery"));
        deliveryList.add(new Delivery(3, "Parcel", "Sadia", "Khulna", "Pending"));
    }

    @javafx.fxml.FXML
    public void logOutButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("postmasterDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void addDelivery(Delivery delivery) {
        deliveryList.add(delivery);
    }
}