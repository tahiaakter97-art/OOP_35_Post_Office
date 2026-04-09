package com.example.postofficesystem.Mahfuz;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class transactionReportViewController
{
    @javafx.fxml.FXML
    private TableColumn typeCol;
    @javafx.fxml.FXML
    private Label totalTransactionTextArea;
    @javafx.fxml.FXML
    private DatePicker transactionReportdatepicker;
    @javafx.fxml.FXML
    private TableColumn amountCOl;
    @javafx.fxml.FXML
    private TableColumn dateCol;
    @javafx.fxml.FXML
    private TableColumn trackingIdCol;
    @javafx.fxml.FXML
    private Label totalAmountTextArea;
    @javafx.fxml.FXML
    private TableView transactionReportTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generateReportOnAction(ActionEvent actionEvent) {
    }
}