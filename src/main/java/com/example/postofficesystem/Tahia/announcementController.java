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

public class announcementController
{
    @javafx.fxml.FXML
    private ListView<Announcement> announcementListView;
    @javafx.fxml.FXML
    private TextField titleTF;
    @javafx.fxml.FXML
    private TextArea messageTA;
    private ObservableList<Announcement> list = FXCollections.observableArrayList();
    private int id = 1;
    @javafx.fxml.FXML
    private Label validationLabel;


    @javafx.fxml.FXML
    public void initialize() {

        announcementListView.setItems(list);
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Tahia/postmasterDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void clearButtonOA(ActionEvent actionEvent) {
        titleTF.clear();
        messageTA.clear();
    }



    @javafx.fxml.FXML
    public void publishButtonOA(ActionEvent actionEvent) {
        String title = titleTF.getText();
        String message = messageTA.getText();
        if (title.isEmpty() || message.isEmpty()) {
            validationLabel.setText("Please write title and message!");
            return;
        }

        Announcement a = new Announcement(
                id++,
                title,
                message,
                LocalDate.now()
        );

        list.add(a);
        showAlert("Announcement Published!");
    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(s);
        alert.showAndWait();
        titleTF.clear();
        messageTA.clear();
    }
}

