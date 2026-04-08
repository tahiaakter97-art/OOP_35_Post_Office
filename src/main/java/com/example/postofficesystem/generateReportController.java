package com.example.postofficesystem;

import javafx.application.Platform;
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
import java.time.LocalDate;

public class generateReportController
{
    @javafx.fxml.FXML
    private TableView<Report> reportPreviewTV;
    @javafx.fxml.FXML
    private TableColumn <Report,LocalDate> dateTC;
    @javafx.fxml.FXML
    private Label submissionStatusLabel;
    @javafx.fxml.FXML
    private TextField reportTitleTF;
    @javafx.fxml.FXML
    private DatePicker endDateDP;
    @javafx.fxml.FXML
    private TableColumn <Report,String>titleTC;
    @javafx.fxml.FXML
    private TableColumn <Report,Integer>serialNumberTC;
    @javafx.fxml.FXML
    private TableColumn <Report,String> contentTC;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextArea contentTA;
    @javafx.fxml.FXML
    private ComboBox <String> reportTypeCB;
    @javafx.fxml.FXML
    private Label dataStatusLabel;
    @javafx.fxml.FXML
    private DatePicker startDateDP;
    @javafx.fxml.FXML
    private ProgressBar progressDataCollection;
    private ObservableList<Report> reportList = FXCollections.observableArrayList();
    @FXML
    private TextField serialNumberTF;

    @javafx.fxml.FXML
    public void initialize() {

        reportTypeCB.getItems().addAll("Daily", "Weekly", "Monthly");
        serialNumberTC.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        contentTC.setCellValueFactory(new PropertyValueFactory<>("content"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        reportPreviewTV.setItems(reportList);
    }


    @FXML
    public void validateInputsButtonOA(ActionEvent actionEvent) {

        if (reportTitleTF.getText().isEmpty() ||
                serialNumberTF.getText().isEmpty() ||
                contentTA.getText().isEmpty() ||
                reportTypeCB.getValue() == null ||
                startDateDP.getValue() == null ||
                endDateDP.getValue() == null) {

            showAlert("Please fill all fields!");
            return;
        }

        if (endDateDP.getValue().isBefore(startDateDP.getValue())) {
            showAlert("End date must be after start date!");
            return;
        }
        showAlert("All inputs are valid ");
    }
    @FXML
    public void startCollectingDataButtonOA(ActionEvent actionEvent) {

        progressDataCollection.setProgress(0);
        dataStatusLabel.setText("Collecting...");

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                double progress = i / 10.0;

                Platform.runLater(() -> progressDataCollection.setProgress(progress));
            }

            Platform.runLater(() -> {
                dataStatusLabel.setText("Data Collected ✅");
                showAlert("Data collection completed!");
            });

        }).start();
    }

    @FXML
    public void formatTheReportButtonOA(ActionEvent actionEvent) {

        if (contentTA.getText().isEmpty()) {
            showAlert("No content to format!");
            return;
        }

        contentTA.setText(contentTA.getText().toUpperCase());
        dataStatusLabel.setText("Formatted");
    }

    @FXML
    public void submitReportButtonOA(ActionEvent actionEvent) {

        if (reportTitleTF.getText().isEmpty()) {
            showAlert("Enter report title!");
            return;
        }

        int id = reportList.size() + 1;

        Report report = new Report(
                Integer.parseInt(serialNumberTF.getText()),
                reportTitleTF.getText(),
                contentTA.getText(),
                LocalDate.now()
        );

        reportList.add(report);

        submissionStatusLabel.setText("Submitted ✅");
        showAlert("Report submitted successfully!");

        clearFields();
    }


    @FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("postmasterDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        Integer.parseInt(serialNumberTF.getText());
        reportTitleTF.clear();
        contentTA.clear();
        reportTypeCB.getSelectionModel().clearSelection();
        startDateDP.setValue(null);
        endDateDP.setValue(null);
    }
}