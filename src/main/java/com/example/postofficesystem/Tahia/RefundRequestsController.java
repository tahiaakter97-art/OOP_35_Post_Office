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

public class RefundRequestsController {
    @javafx.fxml.FXML
    private TableColumn<RefundRequest, Float> amountTC;
    @javafx.fxml.FXML
    private ComboBox<String> decisionCB;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableView<RefundRequest> refundTableView;
    @javafx.fxml.FXML
    private TableColumn<RefundRequest, String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<RefundRequest, String> reasonTC;
    @javafx.fxml.FXML
    private TextField requestIdTF;
    @javafx.fxml.FXML
    private TextArea reasonTA;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private TableColumn<RefundRequest, Integer> requestIdTC;
    @javafx.fxml.FXML
    private Label statusLabel;
    private ObservableList<RefundRequest> refundList;

    @javafx.fxml.FXML
    public void initialize() {
        requestIdTC.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        reasonTC.setCellValueFactory(new PropertyValueFactory<>("reason"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));


        decisionCB.setItems(FXCollections.observableArrayList("Approve", "Reject"));
        decisionCB.setValue("Approve");


        refundList = FXCollections.observableArrayList(
                new RefundRequest(1, 101, 500f, "Wrong transaction", "Pending"),
                new RefundRequest(2, 102, 300f, "Service not provided", "Pending"),
                new RefundRequest(3, 103, 200f, "Duplicate payment", "Approved")
        );

        refundTableView.setItems(refundList);
        refundTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldItem, newItem) -> {

                    if (newItem != null) {
                        showDetails(newItem);
                    }

                }
        );
    }


    private void showDetails(RefundRequest r) {
        requestIdTF.setText(String.valueOf(r.getRequestId()));
        amountTF.setText(String.valueOf(r.getAmount()));
        reasonTA.setText(r.getReason());
        statusLabel.setText("Status: " + r.getStatus());
    }

    @javafx.fxml.FXML
    public void rejectButtonOA(ActionEvent actionEvent) {
        RefundRequest selected = refundTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            outputLabel.setText("Please select a request!");
            return;
        }

        if (!selected.getStatus().equals("Pending")) {
            outputLabel.setText("Already processed!");
            return;
        }

        selected.setStatus("Rejected");
        refundTableView.refresh();

        statusLabel.setText("Status: Rejected");
        outputLabel.setText("Refund Rejected!");
    }


    @javafx.fxml.FXML
    public void approveButtonOA(ActionEvent actionEvent) {
        RefundRequest selected = refundTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            outputLabel.setText("Please select a request!");
            return;
        }

        if (!selected.getStatus().equals("Pending")) {
            outputLabel.setText("Already processed!");
            return;
        }

        selected.setStatus("Approved");
        refundTableView.refresh();

        statusLabel.setText("Status: Approved");
        outputLabel.setText("Refund Approved!");

    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Tahia/AccountsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}


