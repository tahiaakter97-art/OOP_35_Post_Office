package com.example.postofficesystem.Tahia;

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

public class ExportReportController
{

    @javafx.fxml.FXML
    private TableColumn<PaymentReport,Integer> amountTC;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private Label ReportPreviewLabel;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn<PaymentReport,String> receiverNameTC;
    @javafx.fxml.FXML
    private TableColumn<PaymentReport,String> statusTC;
    @javafx.fxml.FXML
    private ComboBox<String> exportFormatCB;
    @javafx.fxml.FXML
    private TableColumn<PaymentReport,Integer> paymentIdTC;
    @javafx.fxml.FXML
    private TableView<PaymentReport> paymentReportTableView;
    @javafx.fxml.FXML
    private TableColumn<PaymentReport, LocalDate> dateTC;
    @javafx.fxml.FXML
    private TableColumn<PaymentReport,String> senderNameTC;
    @javafx.fxml.FXML
    private Label statusLabel;
    private ObservableList<PaymentReport> reportList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        exportFormatCB.getItems().addAll("PDF", "CSV", "TXT");
        paymentIdTC.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        senderNameTC.setCellValueFactory(new PropertyValueFactory<>("senderName"));
        receiverNameTC.setCellValueFactory(new PropertyValueFactory<>("receiverName"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));


        reportList.add(new PaymentReport(101, "Rahim", "Karim", 500f, LocalDate.now(), "Success"));
        reportList.add(new PaymentReport(102, "Asha", "Nila", 1200f, LocalDate.now().minusDays(1), "Pending"));

        paymentReportTableView.setItems(reportList);
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Tahia/AccountsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void generateReportButtonOA(ActionEvent actionEvent) {
        LocalDate fromDate = fromDatePicker.getValue();
        LocalDate toDate = toDatePicker.getValue();

        if (fromDate == null || toDate == null) {
            statusLabel.setText("Please select date range!");
            return;
        }

        ObservableList<PaymentReport> filteredList = FXCollections.observableArrayList();

        for (PaymentReport p : reportList) {
            if ((p.getDate().isEqual(fromDate) || p.getDate().isAfter(fromDate)) &&
                    (p.getDate().isEqual(toDate) || p.getDate().isBefore(toDate))) {
                filteredList.add(p);
            }
        }
        paymentReportTableView.setItems(filteredList);
        statusLabel.setText("Report generated successfully!");

    }

    @javafx.fxml.FXML
    public void exportReportButtonOA(ActionEvent actionEvent) {
        String format = exportFormatCB.getValue();

        if (format == null) {
            statusLabel.setText("Please select export format!");
            return;
        }

        statusLabel.setText("Report exported as " + format + " successfully!");
    }
}