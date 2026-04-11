package com.example.postofficesystem.Mahfuz;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class stampsSalesViewController {

    @javafx.fxml.FXML
    private ComboBox<String> stampTypeComboBox;

    @javafx.fxml.FXML
    private Label availableStockTextArea;

    @javafx.fxml.FXML
    private Label stampTotalPriceTextArea;

    @javafx.fxml.FXML
    private Label successMessageTextArea;

    @javafx.fxml.FXML
    private TextField stampQuantityTextField;

    private Map<String, Integer> stockMap;

    @javafx.fxml.FXML
    public void initialize() {
        // Populate ComboBox
        stampTypeComboBox.getItems().addAll(
                "Stamp (Domestic) - 5৳",
                "Stamp (International) - 15৳",
                "Envelope (A4) - 10৳",
                "Postcard - 20৳",
                "Packing Box (Small) - 50৳"
        );

        // Load stock from CSV
        stockMap = StampStock.loadStock();

        // Clear labels
        availableStockTextArea.setText("");
        stampTotalPriceTextArea.setText("");
        successMessageTextArea.setText("");
    }

    // event-7: Check stock availability
    @javafx.fxml.FXML
    public void stampCheckStockOnAction(ActionEvent actionEvent) {
        String selectedType = stampTypeComboBox.getValue();

        if (selectedType == null) {
            successMessageTextArea.setText("Please select a stamp type.");
            successMessageTextArea.setStyle("-fx-text-fill: red;");
            return;
        }

        int available = stockMap.getOrDefault(selectedType, 0);
        availableStockTextArea.setText("Available Stock: " + available);
        successMessageTextArea.setText("");
        stampTotalPriceTextArea.setText("");
    }

    // event-8 to event-10: Validate → check stock → deduct → calculate → save
    @javafx.fxml.FXML
    public void sellStampOnAction(ActionEvent actionEvent) {
        String selectedType = stampTypeComboBox.getValue();
        String quantityText = stampQuantityTextField.getText().trim();

        // Validate stamp type selected
        if (selectedType == null) {
            successMessageTextArea.setText("Please select a stamp type.");
            successMessageTextArea.setStyle("-fx-text-fill: red;");
            return;
        }

        // event-6: Validate quantity > 0
        if (quantityText.isEmpty()) {
            successMessageTextArea.setText("Please enter a quantity.");
            successMessageTextArea.setStyle("-fx-text-fill: red;");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            successMessageTextArea.setText("Quantity must be a valid number.");
            successMessageTextArea.setStyle("-fx-text-fill: red;");
            return;
        }

        if (quantity <= 0) {
            successMessageTextArea.setText("Quantity must be greater than 0.");
            successMessageTextArea.setStyle("-fx-text-fill: red;");
            return;
        }

        // event-7 & event-8: Check stock
        int available = stockMap.getOrDefault(selectedType, 0);
        if (available < quantity) {
            availableStockTextArea.setText("Available Stock: " + available);
            successMessageTextArea.setText("Out of Stock! Only " + available + " left.");
            successMessageTextArea.setStyle("-fx-text-fill: red;");
            stampTotalPriceTextArea.setText("");
            return;
        }

        // Deduct stock
        stockMap.put(selectedType, available - quantity);

        // event-9: Calculate total price
        int pricePerUnit = StampStock.PRICES.getOrDefault(selectedType, 0);
        int totalPrice = pricePerUnit * quantity;

        // event-10: Save sale & updated stock
        StampStock.saveStock(stockMap);
        StampStock.saveSaleRecord(selectedType, quantity, totalPrice);

        // event-11: Display result
        availableStockTextArea.setText("Available Stock: " + (available - quantity));
        stampTotalPriceTextArea.setText("Total: " + totalPrice + "৳");
        successMessageTextArea.setText("Sale Successful!");
        successMessageTextArea.setStyle("-fx-text-fill: green;");
    }

    // Back to Counter Clerk Dashboard
    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/example/postofficesystem/Mahfuz/counterClerkDashboard.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}