package com.example.postofficesystem.Mahfuz;

import com.example.postofficesystem.Mahfuz.model.MoneyOrder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class moneyOrderViewController {

    @FXML private TextField senderNameTextField;
    @FXML private TextField receiverNameTextField;
    @FXML private TextField moneyOrderAmoundTextField;

    @FXML private Label moneyOrderIdTextArea;
    @FXML private Label serviceChageTextArea;
    @FXML private Label totalPayableTextArea;
    @FXML private Label successMessageTextArea;

    private double amount = 0;
    private double serviceCharge = 0;
    private double totalPayable = 0;

    @FXML
    public void initialize() {
        System.out.println("Money Order Controller Loaded");

        serviceChageTextArea.setText("");
        totalPayableTextArea.setText("");
        moneyOrderIdTextArea.setText("");
        successMessageTextArea.setText("");
    }

    // CALCULATE CHARGE
    @FXML
    public void moneyOrderCalculateChargeOnAction(ActionEvent event) {

        System.out.println("Calculate Button Clicked");

        try {
            amount = Double.parseDouble(moneyOrderAmoundTextField.getText().trim());

            if (amount <= 0) {
                serviceChageTextArea.setText("Amount must be > 0");
                return;
            }

            serviceCharge = amount * 0.05; // 5%
            totalPayable = amount + serviceCharge;

            serviceChageTextArea.setText("Service Charge: " + serviceCharge);
            totalPayableTextArea.setText("Total Payable: " + totalPayable);

        } catch (Exception e) {
            serviceChageTextArea.setText("Invalid amount");
        }
    }

    // SUBMIT MONEY ORDER
    @FXML
    public void moneyOrderSubmitOnAction(ActionEvent event) {

        System.out.println("Submit Button Clicked");

        String sender = senderNameTextField.getText().trim();
        String receiver = receiverNameTextField.getText().trim();

        if (sender.isEmpty() || receiver.isEmpty() || amount <= 0) {
            successMessageTextArea.setText("Fill all fields & calculate first");
            return;
        }

        String moneyOrderId = "MO" + (10000 + new Random().nextInt(90000));

        // MODEL OBJECT
        MoneyOrder mo = new MoneyOrder(
                moneyOrderId,
                sender,
                receiver,
                amount,
                serviceCharge,
                totalPayable
        );

        saveToCSV(mo);

        moneyOrderIdTextArea.setText("Money Order ID: " + moneyOrderId);
        successMessageTextArea.setText("Money Order Successfully Submitted!");
    }

    // SAVE CSV
    private void saveToCSV(MoneyOrder mo) {
        try {
            FileWriter fw = new FileWriter("money_orders.csv", true);
            fw.write(mo.toCSV() + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // BACK BUTTON
    @FXML
    public void backOnAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/counterClerkDashboard.fxml")
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}