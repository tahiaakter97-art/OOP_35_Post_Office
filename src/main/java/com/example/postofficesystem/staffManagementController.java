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

public class staffManagementController {
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private ComboBox<String> staffRoleCB;
    @javafx.fxml.FXML
    private TableColumn<Staff, String> staffRoleTC;
    @javafx.fxml.FXML
    private TableColumn<Staff, String> nameTC;
    @javafx.fxml.FXML
    private TableView<Staff> staffTableView;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableColumn<Staff, String> statusTC;
    private ObservableList<Staff> staffList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private Label outputLabel;


    @javafx.fxml.FXML
    public void initialize() {
        staffRoleCB.getItems().addAll("Postman", "Counter Clerk", "Accountant");
        statusCB.getItems().addAll("Present", "Absent", "On Leave");
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        staffRoleTC.setCellValueFactory(new PropertyValueFactory<>("role"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        staffTableView.setItems(staffList);
    }

    @FXML
    public void updateStaffButtonOA(ActionEvent actionEvent) {
        Staff selected = staffTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Please select a staff first!");
            return;
        }

        if (nameTF.getText().isEmpty()
                || staffRoleCB.getValue() == null
                || statusCB.getValue() == null) {

            showAlert("Please fill all fields!");
            return;
        }

        selected.setName(nameTF.getText());
        selected.setRole(staffRoleCB.getValue());
        selected.setStatus(statusCB.getValue());

        staffTableView.refresh();
        showAlert("Staff updated successfully!");
        clearFields();
    }


    @FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        showAlert("Going back to Dashboard...");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("postmasterDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void clearFields() {
        nameTF.clear();
        staffRoleCB.getSelectionModel().clearSelection();
        statusCB.getSelectionModel().clearSelection();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}


