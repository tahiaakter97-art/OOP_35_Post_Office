package com.example.postofficesystem;

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
import java.util.stream.Collectors;

public class mailFlowDashboardController {

    @FXML
    private Label lettersValueLabel;
    @FXML
    private Label parcelsValueLabel;
    @FXML
    private Label sentValueLabel;
    @FXML
    private Label pendingValueLabel;
    @FXML
    private Label outputLabel;
    @FXML
    private DatePicker selectDateDP;
    @FXML
    private TableView<MailRecord> mailAndParcelFlowTV;
    @FXML
    private TableColumn<MailRecord, Integer> idTC;
    @FXML
    private TableColumn<MailRecord, String> typeTC;
    @FXML
    private TableColumn<MailRecord, String> statusTC;
    @FXML
    private TableColumn<MailRecord, LocalDate> dateTC;
    @FXML
    private ComboBox<String> statusCB;
    @FXML
    private Label dateLabel;
    @FXML
    private ComboBox<String> typeCB;
    @FXML
    private Label lettersTitleLabel;
    @FXML
    private Label parcelsTitleLabel;
    @FXML
    private TextField idTF;
    private ObservableList<MailRecord> mailList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idTC.setCellValueFactory(new PropertyValueFactory<>("mailId"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusCB.getItems().addAll("Sent", "Pending");
        typeCB.getItems().addAll("Letter", "Parcel");
        mailAndParcelFlowTV.setItems(mailList);
        updateStatistics(mailList);
    }

    private void updateStatistics(ObservableList<MailRecord> list) {
        long letters = list.stream().filter(m -> m.getType().equals("Letter")).count();
        long parcels = list.stream().filter(m -> m.getType().equals("Parcel")).count();
        long sent = list.stream().filter(m -> m.getStatus().equals("Sent")).count();
        long pending = list.stream().filter(m -> m.getStatus().equals("Pending")).count();

        lettersValueLabel.setText(String.valueOf(letters));
        parcelsValueLabel.setText(String.valueOf(parcels));
        sentValueLabel.setText(String.valueOf(sent));
        pendingValueLabel.setText(String.valueOf(pending));
    }

    @FXML
    public void filterButtonOA(ActionEvent actionEvent) {
        LocalDate selectedDate = selectDateDP.getValue();
        String selectedStatus = statusCB.getValue();
        String selectedType = typeCB.getValue();

        int id = -1;

        if (!idTF.getText().isEmpty()) {
            try {
                id = Integer.parseInt(idTF.getText());
            } catch (NumberFormatException e) {
                outputLabel.setText("ID must be a number!");
                return;
            }
        }

        int finalId = id;

        ObservableList<MailRecord> filteredList = FXCollections.observableArrayList(
                mailList.stream()
                        .filter(m -> selectedDate == null || m.getDate().equals(selectedDate))
                        .filter(m -> selectedStatus == null || m.getStatus().equals(selectedStatus))
                        .filter(m -> selectedType == null || m.getType().equals(selectedType))
                        .filter(m -> finalId == -1 || m.getMailId() == finalId)
                        .toList()
        );

        mailAndParcelFlowTV.setItems(filteredList);
        updateStatistics(filteredList);

        if (filteredList.isEmpty()) {
            outputLabel.setText("No matching records found!");
        } else {
            outputLabel.setText("Filtered Data");
        }
    }

    @FXML
    public void refreshButtonOA(ActionEvent actionEvent) {
        mailAndParcelFlowTV.setItems(mailList);
        updateStatistics(mailList);
        outputLabel.setText("Data refreshed");
    }

    @FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("postmasterDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}