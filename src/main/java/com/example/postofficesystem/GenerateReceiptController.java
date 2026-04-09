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

public class GenerateReceiptController
{
    @javafx.fxml.FXML
    private TableColumn<Receipt,Float> amountTC;
    @javafx.fxml.FXML
    private TextArea receiptPreviewTA;
    @javafx.fxml.FXML
    private TextField transactionIdTF;
    @javafx.fxml.FXML
    private TableColumn<Receipt, String> customerNameTC;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private TableColumn<Receipt, Integer>  transactionIdTC;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TableColumn <Receipt,LocalDate>dateTC;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableColumn<Receipt, String> serviceTypeTC;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableView<Receipt> transactionTV;
    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeCB;
    private ObservableList<Receipt> receiptList = FXCollections.observableArrayList();
    private int receiptCounter = 1;

    @javafx.fxml.FXML
    public void initialize() {
        serviceTypeCB.getItems().addAll("Parcel", "Money Order", "Stamp");

        transactionIdTC.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        customerNameTC.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        serviceTypeTC.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        receiptList.add(new Receipt(receiptCounter++, 101, "Rahim", "Parcel", 500, LocalDate.now()));
        receiptList.add(new Receipt(receiptCounter++, 102, "Karim", "Money Order", 1200, LocalDate.now().plusDays(1)));

        transactionTV.setItems(receiptList);
    }

    @javafx.fxml.FXML
    public void searchButtonOA(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(transactionIdTF.getText());
            Receipt found = null;

            for (Receipt r : receiptList) {
                if (r.getTransactionId() == id) {
                    found = r;
                    break;
                }
            }

            if (found != null) {
                customerNameTF.setText(found.getCustomerName());
                serviceTypeCB.setValue(found.getServiceType());
                amountTF.setText(String.valueOf(found.getAmount()));
                dateDP.setValue(found.getDate());

                transactionTV.getItems().clear();
                transactionTV.getItems().add(found);

                outputLabel.setText("Transaction Found!");
            } else {
                outputLabel.setText("Transaction Not Found!");
            }
        } catch (Exception e) {
            outputLabel.setText("Invalid Transaction ID!");
        }
    }

    @javafx.fxml.FXML
    public void generateReceiptButtonOA(ActionEvent actionEvent) {
        try {
            Receipt r = new Receipt(
                    receiptCounter++,
                    Integer.parseInt(transactionIdTF.getText()),
                    customerNameTF.getText(),
                    serviceTypeCB.getValue(),
                    Float.parseFloat(amountTF.getText()),
                    dateDP.getValue()
            );

            receiptPreviewTA.setText(
                    "----- RECEIPT -----\n" +
                            "Receipt ID: " + r.getReceiptId() + "\n" +
                            "Transaction ID: " + r.getTransactionId() + "\n" +
                            "Customer Name: " + r.getCustomerName() + "\n" +
                            "Service Type: " + r.getServiceType() + "\n" +
                            "Amount: " + r.getAmount() + "\n" +
                            "Date: " + r.getDate() + "\n"
            );

            receiptList.add(r);
            transactionTV.setItems(receiptList);

            outputLabel.setText("Receipt Generated!");
        } catch (Exception e) {
            outputLabel.setText("Error generating receipt!");
        }
    }

    @javafx.fxml.FXML
    public void saveReceiptButtonOA(ActionEvent actionEvent) {
        try {

            Receipt r = new Receipt(
                    receiptCounter, // same receipt ID or auto-generate
                    Integer.parseInt(transactionIdTF.getText()),
                    customerNameTF.getText(),
                    serviceTypeCB.getValue(),
                    Float.parseFloat(amountTF.getText()),
                    dateDP.getValue()
            );

            receiptList.add(r);

            outputLabel.setText("Receipt Saved in Memory!");
        } catch (Exception e) {
            outputLabel.setText("Error Saving Receipt!");
        }
    }

    @javafx.fxml.FXML
    public void printReceiptButtonOA(ActionEvent actionEvent) {
            System.out.println(receiptPreviewTA.getText());
            outputLabel.setText("Receipt Sent to Printer (Console)");
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