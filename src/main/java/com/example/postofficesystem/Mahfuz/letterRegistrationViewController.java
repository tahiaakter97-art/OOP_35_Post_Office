package com.example.postofficesystem.Mahfuz;

import com.example.postofficesystem.Mahfuz.model.Letter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class letterRegistrationViewController {

    @javafx.fxml.FXML private TextField senderNameTextField;
    @javafx.fxml.FXML private TextField receiverNameTextField;
    @javafx.fxml.FXML private TextField receiverAddressTextField;
    @javafx.fxml.FXML private ComboBox<String> letterTypeComboBox;

    @javafx.fxml.FXML private Label registrationNumberTextArea;
    @javafx.fxml.FXML private Label registrationLetterChargeTextArea;

    private double charge = 0;

    @javafx.fxml.FXML
    public void initialize() {

        letterTypeComboBox.getItems().addAll(
                "Normal Letter",
                "Urgent Letter",
                "Confidential Letter"
        );
    }

    // REGISTER LETTER
    @javafx.fxml.FXML
    public void registrationLetterOnAction(ActionEvent event) {

        String sender = senderNameTextField.getText();
        String receiver = receiverNameTextField.getText();
        String address = receiverAddressTextField.getText();
        String type = letterTypeComboBox.getValue();

        if (sender.isEmpty() || receiver.isEmpty() || address.isEmpty() || type == null) {
            registrationLetterChargeTextArea.setText("Fill all fields");
            return;
        }

        // charge calculation
        switch (type) {
            case "Normal Letter" -> charge = 20;
            case "Urgent Letter" -> charge = 50;
            case "Confidential Letter" -> charge = 100;
        }

        String regNo = "REG" + (10000 + new Random().nextInt(90000));

        Letter letter = new Letter(
                regNo,
                sender,
                receiver,
                address,
                type,
                charge,
                LocalDate.now().toString()
        );

        saveToCSV(letter);

        registrationNumberTextArea.setText("Reg No: " + regNo);
        registrationLetterChargeTextArea.setText("Charge: " + charge + "৳");
    }

    // SAVE CSV
    private void saveToCSV(Letter letter) {
        try {
            FileWriter fw = new FileWriter("letters.csv", true);
            fw.write(letter.toCSV() + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // BACK BUTTON
    @javafx.fxml.FXML
    public void backOnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/counterClerkDashboard.fxml")
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}