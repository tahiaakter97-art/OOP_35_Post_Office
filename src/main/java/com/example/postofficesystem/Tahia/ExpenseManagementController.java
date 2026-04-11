package com.example.postofficesystem.Tahia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class ExpenseManagementController
{
    @javafx.fxml.FXML
    private TableColumn<Expense,Float> amountTC;
    @javafx.fxml.FXML
    private TableColumn<Expense, LocalDate>  dueDateTC;
    @javafx.fxml.FXML
    private TableColumn<Expense,String> referenceTC;
    @javafx.fxml.FXML
    private TextField referenceTF;
    @javafx.fxml.FXML
    private ComboBox<String> expenseTypeCB;
    @javafx.fxml.FXML
    private TableColumn<Expense,String> typeTC;
    @javafx.fxml.FXML
    private TextField budgetStatusTF;
    @javafx.fxml.FXML
    private TableColumn<Expense,String>  statusTC;
    @javafx.fxml.FXML
    private TextField filePathTF;
    @javafx.fxml.FXML
    private TextField amountTF;
    @javafx.fxml.FXML
    private DatePicker dueDateDP;
    @javafx.fxml.FXML
    private TableView<Expense>  expenseTV;
    private final ObservableList<Expense> expenseList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        typeTC.setCellValueFactory(new PropertyValueFactory<>("expenseType"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        referenceTC.setCellValueFactory(new PropertyValueFactory<>("referenceNo"));
        dueDateTC.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        expenseTypeCB.getItems().addAll("Electricity", "Internet", "Water", "Office Supplies", "Maintenance");
        expenseTV.setItems(expenseList);
    }


    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Tahia/AccountsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void processPaymentButtonOA(ActionEvent actionEvent) {
        if (expenseTypeCB.getValue() == null ||
                amountTF.getText().isEmpty() ||
                referenceTF.getText().isEmpty() ||
                dueDateDP.getValue() == null) {

            showAlert("Please fill all fields!");
            return;
        }

        String type = expenseTypeCB.getValue();
        float amount = Float.parseFloat(amountTF.getText());
        String ref = referenceTF.getText();
        LocalDate date = dueDateDP.getValue();

        Expense expense = new Expense(
                expenseList.size() + 1,
                type,
                amount,
                ref,
                date,
                "Paid"
        );

        expenseList.add(expense);

        showAlert("Payment Processed Successfully!");
        clearFields();
    }

    @javafx.fxml.FXML
    public void checkBudgetButtonOA(ActionEvent actionEvent) {
        if (amountTF.getText().isEmpty()) {
            budgetStatusTF.setText("Enter amount first");
            return;
        }

        float amount = Float.parseFloat(amountTF.getText());
        if (amount <= 5000) {
            budgetStatusTF.setText("Within Budget");
        } else {
            budgetStatusTF.setText("Exceeds Budget");
        }
    }

    @javafx.fxml.FXML
    public void browseFileButtonOA(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            filePathTF.setText(file.getAbsolutePath());
        }

    }

    private void clearFields() {
        expenseTypeCB.setValue(null);
        amountTF.clear();
        referenceTF.clear();
        dueDateDP.setValue(null);
        filePathTF.clear();
        budgetStatusTF.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}