package com.example.postofficesystem;

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
import java.time.LocalDate;

public class PaymentRecordsController
{
    @javafx.fxml.FXML
    private TableColumn<Payment,Float> amountTC;
    @javafx.fxml.FXML
    private DatePicker toDateDP;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableColumn<Payment,String> customerNameTC;
    @javafx.fxml.FXML
    private TextField transactionIdTF;
    @javafx.fxml.FXML
    private TableColumn<Payment,Integer> transactionIdTC;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TableView<Payment> paymentTableView;
    @javafx.fxml.FXML
    private TableColumn <Payment, LocalDate>dateTC;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TextArea descriptionTA;
    @javafx.fxml.FXML
    private ComboBox <String> paymentTypeCB;
    @javafx.fxml.FXML
    private DatePicker fromDateDP;
    @javafx.fxml.FXML
    private TableColumn<Payment,String> statusTC;
    @javafx.fxml.FXML
    private TableColumn <Payment,String> paymentTypeTC;
    private ObservableList<Payment> paymentList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        transactionIdTC.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        customerNameTC.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentTypeTC.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        paymentTableView.setItems(paymentList);

        // ComboBox values
        paymentTypeCB.getItems().addAll("Cash", "Card", "Online");
        statusCB.getItems().addAll("Completed", "Pending", "Failed");

    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccountsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void viewDetailsButtonOA(ActionEvent actionEvent) {
        Payment selectedPayment = paymentTableView.getSelectionModel().getSelectedItem();
        if (selectedPayment != null) {
            showPayment(selectedPayment);
        } else {
            showAlert("Please select a row first.");
        }
    }

    private void showPayment(Payment selectedPayment) {
        paymentTypeCB.setValue(selectedPayment.getPaymentType()); // Set the selected value
        amountTF.setText(String.valueOf(selectedPayment.getAmount())); // Show amount
        dateDP.setValue(selectedPayment.getDate()); // Show date
    }

    @javafx.fxml.FXML
    public void closeButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateButtonOA(ActionEvent actionEvent) {
        try {
            String id = transactionIdTF.getText();
            String name = customerNameTF.getText();
            float amount = Float.parseFloat(amountTF.getText());
            String type = paymentTypeCB.getValue();
            String status = statusCB.getValue();
            LocalDate date = dateDP.getValue();

            Payment payment = new Payment();

            payment.setTransactionId(id);
            payment.setCustomerName(name);
            payment.setAmount(amount);
            payment.setPaymentType(type);
            payment.setStatus(status);
            payment.setDate(date);
            paymentList.add(payment);

            clearFields();

        } catch (Exception e) {
            showAlert("Please fill all fields correctly!");
        }
    }
    private void clearFields() {
        transactionIdTF.clear();
        customerNameTF.clear();
        amountTF.clear();
        paymentTypeCB.setValue(null);
        statusCB.setValue(null);
        dateDP.setValue(null);
        descriptionTA.clear();
    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(s);
        alert.show();
    }
}