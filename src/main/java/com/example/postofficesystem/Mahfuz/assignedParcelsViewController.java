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

public class assignedParcelsViewController {

    @FXML private TableView<ParcelTrack> assignedParcelsViewTableView;

    @FXML private TableColumn<ParcelTrack, String> trackingIdCol;
    @FXML private TableColumn<ParcelTrack, String> receiverNameCol;
    @FXML private TableColumn<ParcelTrack, String> addressCol;
    @FXML private TableColumn<ParcelTrack, String> statusCol;

    @FXML private Label trackingIdTextArea;
    @FXML private Label senderNameTextArea;
    @FXML private Label receiverNameTextArea;
    @FXML private Label addressTextArea;
    @FXML private Label statusTextArea;

    private ObservableList<ParcelTrack> parcelList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        trackingIdCol.setCellValueFactory(new PropertyValueFactory<>("trackingId"));
        receiverNameCol.setCellValueFactory(new PropertyValueFactory<>("receiverName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("receiverAddress"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        trackingIdTextArea.setText("");
        senderNameTextArea.setText("");
        receiverNameTextArea.setText("");
        addressTextArea.setText("");
        statusTextArea.setText("");
    }

    // ================= LOAD PARCELS =================
    @FXML
    public void loadParcelOnAction(ActionEvent actionEvent) {

        List<ParcelTrack> list = ParcelTrackFileUtil.loadParcels();

        parcelList.clear();
        parcelList.addAll(list);

        assignedParcelsViewTableView.setItems(parcelList);
    }

    // ================= VIEW DETAILS =================
    @FXML
    public void viewDetailsOnAction(ActionEvent actionEvent) {

        ParcelTrack selected = assignedParcelsViewTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            return;
        }

        trackingIdTextArea.setText("Tracking ID: " + selected.getTrackingId());
        senderNameTextArea.setText("Sender: " + selected.getSenderName());
        receiverNameTextArea.setText("Receiver: " + selected.getReceiverName());
        addressTextArea.setText("Address: " + selected.getReceiverAddress());
        statusTextArea.setText("Status: " + selected.getStatus());
    }

    // ================= BACK =================
    @FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/postManDashboardView.fxml")
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource())
                .getScene()
                .getWindow();

        stage.setScene(scene);
    }
}