package com.example.postofficesystem.Tahia;

import com.example.postofficesystem.InventoryItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class inventoryManagementController
{
    @javafx.fxml.FXML
    private TableColumn<InventoryItem,Float> priceTC;
    @javafx.fxml.FXML
    private TableView<InventoryItem> inventoryTV;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TableColumn<InventoryItem, Integer> minRequiredTC;
    @javafx.fxml.FXML
    private TextField priceTF;
    @javafx.fxml.FXML
    private TextField minTF;
    @javafx.fxml.FXML
    private TableColumn<InventoryItem,String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<InventoryItem,String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<InventoryItem,Integer> idTC;
    @javafx.fxml.FXML
    private TableColumn <InventoryItem,Float> quantityTC;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private TextField quantityTF;
    private ObservableList<InventoryItem> list = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private ComboBox <String> statusCB;


    @javafx.fxml.FXML
    public void initialize() {
        idTC.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        minRequiredTC.setCellValueFactory(new PropertyValueFactory<>("minRequired"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusCB.getItems().addAll("Available", "Low Stock", "Out of Stock");
        inventoryTV.setItems(list);
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Tahia/postmasterDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void addItemButtonOA(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(idTF.getText());
            String name = nameTF.getText();
            int qty = Integer.parseInt(quantityTF.getText());
            float price = Float.parseFloat(priceTF.getText());
            int min = Integer.parseInt(minTF.getText());
            String status = statusCB.getValue();

            if (status == null) {
                showAlert("Select status!");
                return;
            }

            InventoryItem item = new InventoryItem(id, name, qty, price, min, status);
            list.add(item);

            clearFields();

        } catch (Exception e) {
            showAlert("Invalid input!");
        }
    }

    @javafx.fxml.FXML
    public void deleteItemButtonOA(ActionEvent actionEvent) {
        InventoryItem selected = inventoryTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Select an item first!");
            return;
        }

        list.remove(selected);
    }

    @javafx.fxml.FXML
    public void clearItemButtonOA(ActionEvent actionEvent) {
        clearFields();
    }

    private void clearFields() {
        idTF.clear();
        nameTF.clear();
        quantityTF.clear();
        priceTF.clear();
        minTF.clear();
    }
    private void showAlert(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(msg);
        a.show();
    }

    @javafx.fxml.FXML
    public void updateItemButtonOA(ActionEvent actionEvent) {
        InventoryItem selected = inventoryTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Select item to update!");
            return;
        }

        try {
            selected.setItemId(Integer.parseInt(idTF.getText()));
            selected.setName(nameTF.getText());
            selected.setQuantity(Integer.parseInt(quantityTF.getText()));
            selected.setPrice(Float.parseFloat(priceTF.getText()));
            selected.setMinRequired(Integer.parseInt(minTF.getText()));

            inventoryTV.refresh();
            clearFields();

        } catch (Exception e) {
            showAlert("Invalid input!");
        }
    }

}