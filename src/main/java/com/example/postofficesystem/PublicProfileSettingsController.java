package com.example.postofficesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PublicProfileSettingsController
{
    @javafx.fxml.FXML
    private TextField officeHoursTF;
    @javafx.fxml.FXML
    private Label validationLabel;
    @javafx.fxml.FXML
    private TextArea noticeTA;
    @javafx.fxml.FXML
    private TextField contactTF;

    @javafx.fxml.FXML
    public void initialize() {
        validationLabel.setText("");
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("postmasterDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void clearButtonOA(ActionEvent actionEvent) {
        officeHoursTF.clear();
        contactTF.clear();
        noticeTA.clear();
        validationLabel.setText("");
    }

    @javafx.fxml.FXML
    public void saveButtonOA(ActionEvent actionEvent) {
        String hours = officeHoursTF.getText();
        String contact = contactTF.getText();
        String notice = noticeTA.getText();
        if (hours.isEmpty() || contact.isEmpty()) {
            validationLabel.setText("Please fill all required fields!");
            return;
        }

        if (!contact.matches("\\d+")) {
            validationLabel.setText("Contact must be numeric!");
            return;
        }

        ProfileSettings ps = new ProfileSettings(hours, contact, notice);
        System.out.println(ps);
        validationLabel.setText("Profile Updated Successfully!");
    }
}