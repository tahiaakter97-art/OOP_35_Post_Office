package com.example.postofficesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UserLogInDashboardController {

    @FXML
    private PasswordField password;

    @FXML
    private ComboBox<String> userComboBox;

    @FXML
    private CheckBox showPass;

    @FXML
    private PasswordField passLogIn;

    @FXML
    private TextField showPasswordField;

    @FXML
    private Label loginInfo;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Label createInfo;


    @FXML
    public void initialize() {
        userComboBox.getItems().addAll(
                "Counter Clerk",
                "Postman",
                "Accounts Officer",
                "Post Master"
        );

        showPasswordField.setVisible(false);
    }


    @FXML
    public void forgetPassword(ActionEvent actionEvent) {
        loginInfo.setText("Please contact admin to reset password.");
    }


    @FXML
    public void showPassword(ActionEvent actionEvent) {
        if (showPass.isSelected()) {
            showPasswordField.setText(passLogIn.getText());
            showPasswordField.setVisible(true);
            passLogIn.setVisible(false);
        } else {
            passLogIn.setText(showPasswordField.getText());
            passLogIn.setVisible(true);
            showPasswordField.setVisible(false);
        }
    }


    @FXML
    public void createAccount(ActionEvent actionEvent) {

        String username = userField.getText();
        String pass = password.getText();
        String confirmPass = confirmPassword.getText();

        if (username.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
            createInfo.setText("Please fill all fields!");
            return;
        }

        if (!pass.equals(confirmPass)) {
            createInfo.setText("Passwords do not match!");
            return;
        }

        createInfo.setText("Account created successfully!");
    }

    @FXML
    public void Login(ActionEvent actionEvent) {

        String role = userComboBox.getValue();
        String pass = passLogIn.getText();

        if (role == null || pass.isEmpty()) {
            loginInfo.setText("Please select role and enter password!");
            return;
        }

        try {
            Stage stage = (Stage) loginInfo.getScene().getWindow();


            if (role.equals("Accounts Officer") && pass.equals("12345")) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Tahia/AccountsDashboard.fxml"));
                Scene scene = new Scene(loader.load());

                stage.setTitle("Accounts Officer Dashboard");
                stage.setScene(scene);
            }

            else if (role.equals("Post Master") && pass.equals("12345")) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Tahia/postmasterDashboard.fxml"));
                Scene scene = new Scene(loader.load());

                stage.setTitle("Post Master Dashboard");
                stage.setScene(scene);
            }

            else if (role.equals("Counter Clerk") && pass.equals("12345")) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Mahfuz/counterClerkDashboard.fxml"));
                stage.setScene(new Scene(loader.load()));
                stage.setTitle("Counter Clerk Dashboard");
            }


            else if (role.equals("Postman") && pass.equals("12345")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/postofficesystem/Mahfuz/postmanDashboard.fxml"));
                Parent root = loader.load();

                stage.setScene(new Scene(root));
                stage.setTitle("Postman Dashboard");

               // FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/postofficesystem/Mahfuz/PostmanDashboard.fxml"));
               // stage.setScene(new Scene(loader.load()));
               // stage.setTitle("Postman Dashboard");
            }

            else {
                loginInfo.setText("Invalid role or password!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            loginInfo.setText("Error loading dashboard!");
        }
    }
}