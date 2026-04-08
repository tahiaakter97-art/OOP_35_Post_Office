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
import java.util.stream.Collectors;

public class DailyIncomeController {

    @javafx.fxml.FXML
    private TableColumn<DeliveryIncome, Float> amountTC;

    @javafx.fxml.FXML
    private TableView<DeliveryIncome> transactionTableView;

    @javafx.fxml.FXML
    private TextField totalIncomeTF;

    @javafx.fxml.FXML
    private TableColumn<DeliveryIncome, String> statusTC;

    @javafx.fxml.FXML
    private TableColumn<DeliveryIncome, LocalDate> dateTC;

    @javafx.fxml.FXML
    private TableColumn<DeliveryIncome, String> paymentModeTC;

    @javafx.fxml.FXML
    private TextField totalTransactionsTF;

    @javafx.fxml.FXML
    private ComboBox<String> paymentModeCB;

    @javafx.fxml.FXML
    private TableColumn<DeliveryIncome, String> serviceTypeTC;

    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeCB;

    @javafx.fxml.FXML
    private TextField searchTF;

    @javafx.fxml.FXML
    private TextField amountTF;

    @javafx.fxml.FXML
    private ComboBox<String> statusCB;

    private ObservableList<DeliveryIncome> list = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private DatePicker selectDateDP;

    @javafx.fxml.FXML
    public void initialize() {
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        serviceTypeTC.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentModeTC.setCellValueFactory(new PropertyValueFactory<>("paymentMode"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        serviceTypeCB.getItems().addAll("Mail", "Parcel", "Savings");
        paymentModeCB.getItems().addAll("Cash", "Card", "Mobile Banking");
        statusCB.getItems().addAll("Completed", "Pending");

        transactionTableView.setItems(list);
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
        String keyword = searchTF.getText().toLowerCase();

        ObservableList<DeliveryIncome> filtered = list.stream()
                .filter(t -> t.getServiceType().toLowerCase().contains(keyword))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        transactionTableView.setItems(filtered);
        updateSummary(filtered);
    }

    @javafx.fxml.FXML
    public void resetButtonOA(ActionEvent actionEvent) {
        searchTF.clear();
        transactionTableView.setItems(list);
        updateSummary(list);
    }

    @javafx.fxml.FXML
    public void filterButtonOA(ActionEvent actionEvent) {
        String selectedService = serviceTypeCB.getValue();
        String selectedPayment = paymentModeCB.getValue();
        LocalDate selectedDate = selectDateDP.getValue();

        ObservableList<DeliveryIncome> filteredList = list.stream()
                .filter(t -> selectedService == null || t.getServiceType().equals(selectedService))
                .filter(t -> selectedPayment == null || t.getPaymentMode().equals(selectedPayment))
                .filter(t -> selectedDate == null || t.getDate().equals(selectedDate))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        transactionTableView.setItems(filteredList);
        updateSummary(filteredList);
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOA(ActionEvent actionEvent) {
        DeliveryIncome selected = transactionTableView.getSelectionModel().getSelectedItem();

        if (selected != null) {
            showAlert("Service: " + selected.getServiceType() +
                    "\nAmount: " + selected.getAmount() +
                    "\nPayment: " + selected.getPaymentMode());
        } else {
            showAlert("Select a row!");
        }
    }

    private void updateSummary(ObservableList<DeliveryIncome> list) {
        totalTransactionsTF.setText(String.valueOf(list.size()));

        double total = list.stream()
                .mapToDouble(DeliveryIncome::getAmount)
                .sum();

        totalIncomeTF.setText(String.valueOf(total));
    }

    @javafx.fxml.FXML
    public void addButtonOA(ActionEvent actionEvent) {
        try {
            String service = serviceTypeCB.getValue();
            String payment = paymentModeCB.getValue();
            String status = statusCB.getValue();
            LocalDate date = selectDateDP.getValue();
            double amount = Double.parseDouble(amountTF.getText());

            if (service == null || payment == null || status == null || date == null) {
                showAlert("Error: Fill all fields!");
                return;
            }

            DeliveryIncome income = new DeliveryIncome(
                    0, service, (float) amount, payment, status, date
            );

            list.add(income);
            updateSummary(list);
            clearFields();

        } catch (Exception e) {
            showAlert("Error: Invalid input!");
        }
    }

    private void clearFields() {
        amountTF.clear();
        serviceTypeCB.setValue(null);
        paymentModeCB.setValue(null);
        statusCB.setValue(null);
        selectDateDP.setValue(null);
    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(s);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccountsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}