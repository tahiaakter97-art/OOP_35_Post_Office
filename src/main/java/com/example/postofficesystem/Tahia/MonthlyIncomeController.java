package com.example.postofficesystem.Tahia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class MonthlyIncomeController
{
    @javafx.fxml.FXML
    private TableColumn<Income,Float> amountTC;
    @javafx.fxml.FXML
    private TableColumn<Income,Integer> transactionCountTC;
    @javafx.fxml.FXML
    private Label totalIncomeLabel;
    @javafx.fxml.FXML
    private ComboBox<String> monthCB;
    @javafx.fxml.FXML
    private TableView<Income> serviceIncomeTableView;
    @javafx.fxml.FXML
    private ComboBox<Integer> yearCB;
    @javafx.fxml.FXML
    private TableColumn <Income,String> serviceNameTC;

    private ObservableList<Income> incomeList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        monthCB.getItems().addAll("January","February","March","April","May","June", "July","August","September","October","November","December");

        yearCB.getItems().addAll(2023, 2024, 2025, 2026);
        serviceNameTC.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transactionCountTC.setCellValueFactory(new PropertyValueFactory<>("transactionCount"));

        serviceIncomeTableView.setItems(incomeList);

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
    public void generateReportButtonOA(ActionEvent actionEvent) {
        String month = monthCB.getValue();
        Integer year = yearCB.getValue();

        if (month == null || year == null) {
            totalIncomeLabel.setText("Please select month & year");
            return;
        }

        incomeList.clear();

        incomeList.addAll(
                new Income("Parcel Service", 1200.5f, 10, month, year),
                new Income("Money Transfer", 3000.0f, 25, month, year),
                new Income("Stamp Sale", 500.0f, 40, month, year)
        );

        float total = 0;

        for (Income i : incomeList) {
            total += i.getAmount();
        }
        totalIncomeLabel.setText(String.valueOf(total));
    }

}