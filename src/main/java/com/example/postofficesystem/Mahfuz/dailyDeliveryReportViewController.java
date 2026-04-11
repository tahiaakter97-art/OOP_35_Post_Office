package com.example.postofficesystem.Mahfuz;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class dailyDeliveryReportViewController
{
    @javafx.fxml.FXML
    private TableView dailyDeliveryReportTableView;
    @javafx.fxml.FXML
    private TableColumn dateCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private Label deliveredCountTextArea;
    @javafx.fxml.FXML
    private Label failedCountTextArea;
    @javafx.fxml.FXML
    private DatePicker selectDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn receiverNameCol;
    @javafx.fxml.FXML
    private TableColumn trackingIdCol;
    @javafx.fxml.FXML
    private Label returnedCountTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generateReportOnAction(ActionEvent actionEvent) {
    }
}