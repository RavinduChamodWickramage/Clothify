package controller.staff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class StaffDashboardFormController {

    @FXML
    private Text txtStaffUsername;

    public void setStaffUsername(String username) {
        txtStaffUsername.setText(username);
    }

    @FXML
    void btnHomepageOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/home_page.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Home Page");
            stage.setResizable(false);
            stage.show();
            stage.centerOnScreen();

            Stage disposeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            disposeStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnManageAccountOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrderManagementOnAction(ActionEvent event) {

    }

    @FXML
    void btnProductManagementOnAction(ActionEvent event) {

    }

    @FXML
    void btnSupplierManagementOnAction(ActionEvent event) {

    }

    @FXML
    void btnSupplyManagementOnAction(ActionEvent event) {

    }

}
