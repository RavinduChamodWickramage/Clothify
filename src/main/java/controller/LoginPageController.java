package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.admin.AdminDashboardFormController;
import controller.staff.StaffDashboardFormController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {

    private String role;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUsername;

    public void setRole(String role) {
        this.role = role;
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtUsername.clear();
        txtPassword.clear();
    }

    @FXML
    void btnHomepageOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/home_page.fxml"));
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
    void btnLoginOnAction(ActionEvent event) {
        if (role == "Admin") {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/admin_dashboard_form.fxml"));
                Parent root = loader.load();

                AdminDashboardFormController adminDashboardFormController = loader.getController();
                adminDashboardFormController.setAdminUsername(txtUsername.getText());

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Admin Dashboard");
                stage.setResizable(false);
                stage.show();
                stage.centerOnScreen();

                Stage disposeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                disposeStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (role == "Staff") {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/staff_dashboard_form.fxml"));
                Parent root = loader.load();

                StaffDashboardFormController staffDashboardFormController = loader.getController();
                staffDashboardFormController.setStaffUsername(txtUsername.getText());

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Staff Dashboard");
                stage.setResizable(false);
                stage.show();
                stage.centerOnScreen();

                Stage disposeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                disposeStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
