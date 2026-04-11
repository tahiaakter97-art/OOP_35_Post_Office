package com.example.postofficesystem.Tahia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class financialReportsController {
    @javafx.fxml.FXML
    private Label reportTitleLabel;
    @javafx.fxml.FXML
    private Label reportDateLabel;
    @javafx.fxml.FXML
    private ListView<FinancialReport> reportListView;
    @javafx.fxml.FXML
    private Label reportIdLabel;
    @javafx.fxml.FXML
    private TextArea reportDetailsTA;
    @javafx.fxml.FXML
    private Label statusLabel;
    private ObservableList<FinancialReport> reportList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        reportList.add(new FinancialReport(1, "Report A", 5000, 3000,
                "Simple report A", "Pending", LocalDate.now()));
        reportList.add(new FinancialReport(2, "Report B", 7000, 4000,
                "Simple report B", "Pending", LocalDate.now()));
        reportListView.setItems(reportList);
        reportListView.setOnMouseClicked(e -> {
            FinancialReport r = reportListView.getSelectionModel().getSelectedItem();

            if (r != null) {
                reportIdLabel.setText(String.valueOf(r.getReportId()));
                reportTitleLabel.setText(r.getTitle());
                reportDateLabel.setText(r.getDate().toString());
                statusLabel.setText(r.getStatus());
            }
        });
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
    public void rejectButtonOA(ActionEvent actionEvent) {
        FinancialReport r = reportListView.getSelectionModel().getSelectedItem();
        if (r == null) {
            showAlert("Select report first");
            return;
        }
        r.setStatus("Rejected");
        statusLabel.setText("Rejected");
    }

    @javafx.fxml.FXML
    public void approveButtonOA(ActionEvent actionEvent) {

        FinancialReport r = reportListView.getSelectionModel().getSelectedItem();

        if (r == null) {
            showAlert("Select report first");
            return;
        }
        r.setStatus("Approved");
        statusLabel.setText("Approved");
    }

    @javafx.fxml.FXML
    public void viewDetailsButtonOA(ActionEvent actionEvent) {

        FinancialReport r = reportListView.getSelectionModel().getSelectedItem();

        if (r == null) {
            showAlert("Select report first");
            return;
        }

        reportDetailsTA.setText(
                "Income: " + r.getTotalIncome() + "\n" +
                        "Expense: " + r.getTotalExpense() + "\n" +
                        "Details: " + r.getDetails()
        );
    }

    @javafx.fxml.FXML
    public void refreshButtonOA(ActionEvent actionEvent) {
        reportListView.refresh();
        showAlert("Refreshed");
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

