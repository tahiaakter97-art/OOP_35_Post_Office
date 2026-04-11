package com.example.postofficesystem.Mahfuz;

import com.example.postofficesystem.Transaction;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

public class transactionReportViewController {

    @FXML private TableView<Transaction> transactionReportTableView;
    @FXML private TableColumn<Transaction, String> trackingIdCol;
    @FXML private TableColumn<Transaction, String> typeCol;
    @FXML private TableColumn<Transaction, Float> amountCOl;
    @FXML private TableColumn<Transaction, String> dateCol;

    @FXML private DatePicker transactionReportdatepicker;
    @FXML private Label totalTransactionTextArea;
    @FXML private Label totalAmountTextArea;

    private final String FILE_PATH = "parcels.csv";

    @FXML
    public void initialize() {

        trackingIdCol.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getTransactionId()))
        );

        typeCol.setCellValueFactory(data ->
                new SimpleStringProperty("Parcel") // since CSV has no type field in this model
        );

        amountCOl.setCellValueFactory(data ->
                new SimpleObjectProperty<>(data.getValue().getAmount())
        );

        dateCol.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getDate()))
        );
    }

    @FXML
    public void generateReportOnAction(ActionEvent actionEvent) {

        LocalDate selectedDate = transactionReportdatepicker.getValue();

        if (selectedDate == null) {
            totalTransactionTextArea.setText("Select a date");
            return;
        }

        ObservableList<Transaction> list = FXCollections.observableArrayList();

        int count = 0;
        float totalAmount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length < 11) continue;

                int transactionId = Integer.parseInt(data[0].replaceAll("\\D", ""));
                float amount = Float.parseFloat(data[8]);
                LocalDate date = LocalDate.parse(data[10]);

                if (date.equals(selectedDate)) {

                    Transaction t = new Transaction(
                            transactionId,
                            amount,
                            0, // userId not used in parcel system
                            date
                    );

                    list.add(t);

                    count++;
                    totalAmount += amount;
                }
            }

        } catch (Exception e) {
            totalTransactionTextArea.setText("Error loading data");
            return;
        }

        transactionReportTableView.setItems(list);

        totalTransactionTextArea.setText("Total Transactions: " + count);
        totalAmountTextArea.setText("Total Amount: ৳ " + totalAmount);
    }

    @FXML
    public void backOnAction(ActionEvent actionEvent) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/counterClerkDashboard.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}