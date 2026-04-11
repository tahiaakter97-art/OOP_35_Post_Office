package com.example.postofficesystem.Mahfuz;

import com.example.postofficesystem.Mahfuz.model.StampSale;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class stampsSalesViewController {

    @javafx.fxml.FXML private ComboBox<String> stampTypeComboBox;
    @javafx.fxml.FXML private TextField stampQuantityTextField;
    @javafx.fxml.FXML private Label availableStockTextArea;
    @javafx.fxml.FXML private Label stampTotalPriceTextArea;
    @javafx.fxml.FXML private Label successMessageTextArea;

    private Map<String, Integer> stock = new HashMap<>();

    private Map<String, Integer> priceMap = new HashMap<>();

    @javafx.fxml.FXML
    public void initialize() {

        // Stamp types
        stampTypeComboBox.getItems().addAll(
                "Stamp (Domestic) - 5",
                "Stamp (International) - 15",
                "Envelope (A4) - 10",
                "Postcard - 20",
                "Packing Box (Small) - 50"
        );

        // Stock initialization
        for (String item : stampTypeComboBox.getItems()) {
            stock.put(item, 50);
        }

        // Price map
        priceMap.put("Stamp (Domestic) - 5", 5);
        priceMap.put("Stamp (International) - 15", 15);
        priceMap.put("Envelope (A4) - 10", 10);
        priceMap.put("Postcard - 20", 20);
        priceMap.put("Packing Box (Small) - 50", 50);
    }

    // CHECK STOCK
    @javafx.fxml.FXML
    public void stampCheckStockOnAction(ActionEvent event) {

        String type = stampTypeComboBox.getValue();

        if (type == null) {
            successMessageTextArea.setText("Select stamp type");
            return;
        }

        availableStockTextArea.setText("Available Stock: " + stock.get(type));
        successMessageTextArea.setText("");
    }

    // SELL STAMP
    @javafx.fxml.FXML
    public void sellStampOnAction(ActionEvent event) {

        String type = stampTypeComboBox.getValue();
        String qtyText = stampQuantityTextField.getText();

        if (type == null || qtyText.isEmpty()) {
            successMessageTextArea.setText("Fill all fields");
            return;
        }

        int qty;

        try {
            qty = Integer.parseInt(qtyText);
        } catch (Exception e) {
            successMessageTextArea.setText("Invalid quantity");
            return;
        }

        if (qty <= 0) {
            successMessageTextArea.setText("Quantity must be > 0");
            return;
        }

        int available = stock.get(type);

        if (qty > available) {
            successMessageTextArea.setText("Out of Stock");
            return;
        }

        // update stock
        stock.put(type, available - qty);

        int price = priceMap.get(type);
        int total = price * qty;

        // MODEL OBJECT (IMPORTANT FOR CRA)
        StampSale sale = new StampSale(type, qty, price, total);

        // SAVE TO CSV
        saveToCSV(sale);

        // OUTPUT
        availableStockTextArea.setText("Available Stock: " + (available - qty));
        stampTotalPriceTextArea.setText("Total: " + total + "৳");
        successMessageTextArea.setText("Sale Successful!");
    }

    // CSV SAVE METHOD
    private void saveToCSV(StampSale sale) {
        try {
            FileWriter fw = new FileWriter("stamp_sales.csv", true);
            fw.write(sale.toCSV() + "\n");
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