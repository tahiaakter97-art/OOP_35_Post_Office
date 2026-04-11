package com.example.postofficesystem.Mahfuz;

import com.example.postofficesystem.Mahfuz.model.ParcelTrack;
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
import java.util.List;

public class dailyDeliveryReportViewController {

    @FXML private TableView<ParcelTrack> dailyDeliveryReportTableView;

    @FXML private TableColumn<ParcelTrack, String> trackingIdCol;
    @FXML private TableColumn<ParcelTrack, String> receiverNameCol;
    @FXML private TableColumn<ParcelTrack, String> dateCol;
    @FXML private TableColumn<ParcelTrack, String> statusCol;

    @FXML private DatePicker selectDateDatePicker;

    @FXML private Label deliveredCountTextArea;
    @FXML private Label failedCountTextArea;
    @FXML private Label returnedCountTextArea;

    private ObservableList<ParcelTrack> reportList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        trackingIdCol.setCellValueFactory(new PropertyValueFactory<>("trackingId"));
        receiverNameCol.setCellValueFactory(new PropertyValueFactory<>("receiverName"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // No real date field in model → placeholder
        dateCol.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty("N/A")
        );
    }

    // ================= GENERATE REPORT =================
    @FXML
    public void generateReportOnAction(ActionEvent actionEvent) {

        List<ParcelTrack> list = ParcelTrackFileUtil.loadParcels();

        reportList.clear();
        reportList.addAll(list);

        dailyDeliveryReportTableView.setItems(reportList);

        int delivered = 0;
        int failed = 0;
        int returned = 0;

        for (ParcelTrack p : list) {

            String status = p.getStatus();

            if (status == null) continue;

            if (status.equalsIgnoreCase("Delivered")) {
                delivered++;
            } else if (status.equalsIgnoreCase("Failed")) {
                failed++;
            } else if (status.equalsIgnoreCase("Returned")) {
                returned++;
            }
        }

        deliveredCountTextArea.setText("Delivered: " + delivered);
        failedCountTextArea.setText("Failed: " + failed);
        returnedCountTextArea.setText("Returned: " + returned);
    }

    // ================= BACK =================
    @FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/postmanDashboard.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}