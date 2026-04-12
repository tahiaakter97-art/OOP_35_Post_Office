package com.example.postofficesystem.Mahfuz;

import com.example.postofficesystem.Mahfuz.model.ParcelTrack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class collectSignatureViewController {

    @FXML
    private TextField receiverNameTextField;

    @FXML
    private Label validationMessageTextArea;

    @FXML
    private Label successMessageTextArea;

    private ParcelTrack currentParcel = null;

    @FXML
    public void initialize() {
        validationMessageTextArea.setText("");
        successMessageTextArea.setText("");
    }

    // ================= SAVE SIGNATURE =================
    @FXML
    public void saveSignatureOnAction(ActionEvent actionEvent) {

        String name = receiverNameTextField.getText().trim();

        if (name.isEmpty()) {
            validationMessageTextArea.setText("Receiver name cannot be empty!");
            return;
        }

        List<ParcelTrack> list = ParcelTrackFileUtil.loadParcels();

        for (ParcelTrack p : list) {

            // simplest validation: match latest entered logic
            if (p.getReceiverName().equalsIgnoreCase(name)) {

                p.setReceiverSignature(name);

                ParcelTrackFileUtil.saveAll(list);

                successMessageTextArea.setText("Signature saved successfully ✔");
                validationMessageTextArea.setText("");

                return;
            }
        }

        validationMessageTextArea.setText("Parcel not found!");
    }



    @FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/com/example/postofficesystem/Mahfuz/postManDashboardView.fxml"
        ));

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}