package com.example.postofficesystem.Tahia;

import com.example.postofficesystem.Transaction;
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
import java.util.List;

public class SearchTransactionController
{
    @javafx.fxml.FXML
    private Label totalTransactionsLabel;
    @javafx.fxml.FXML
    private TableColumn<Transaction, Float>  amountTC;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Transaction,Integer>  transactionIdTC;
    @javafx.fxml.FXML
    private TableColumn<Transaction, LocalDate> dateTC;
    @javafx.fxml.FXML
    private TableColumn<Transaction,Integer> userIdTC;
    private ObservableList<Transaction> allTransactions = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TableView<Transaction> transactionTV;

    @javafx.fxml.FXML
    public void initialize() {
        transactionIdTC.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        userIdTC.setCellValueFactory(new PropertyValueFactory<>("userId"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        allTransactions.add(new Transaction(1, 101.0f, 500, LocalDate.now()));
        allTransactions.add(new Transaction(2, 102.2f, 250, LocalDate.of(2026, 4, 6)));
        allTransactions.add(new Transaction(3, 103.0f, 300, LocalDate.of(2026, 4, 7)));

        transactionTV.setItems(allTransactions);
        totalTransactionsLabel.setText("Total Transactions: " + allTransactions.size());
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
        try {
            LocalDate fromDate = fromDatePicker.getValue();
            LocalDate toDate = toDatePicker.getValue();

            if (fromDate == null || toDate == null) {
                totalTransactionsLabel.setText("Please select both From and To dates!");
                return;
            }

            // Filter transactions in the date range
            List<Transaction> filtered = allTransactions.stream()
                    .filter(t -> !t.getDate().isBefore(fromDate) && !t.getDate().isAfter(toDate))
                    .toList();

            transactionTV.getItems().clear();
            transactionTV.getItems().addAll(filtered);

            totalTransactionsLabel.setText("Total Transactions: " + filtered.size());

            if (filtered.isEmpty()) {
                totalTransactionsLabel.setText("No transactions found!");
            } else {
                totalTransactionsLabel.setText("Transactions found!");
            }
        } catch (Exception e) {
            totalTransactionsLabel.setText("Error searching transactions!");
        }
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Tahia/AccountsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}