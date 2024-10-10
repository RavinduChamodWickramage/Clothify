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
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import service.custom.AdminService;
import service.custom.StaffService;
import service.custom.impl.AdminServiceImpl;
import service.custom.impl.StaffServiceImpl;
import util.AlertUtil;

import java.io.IOException;

public class LoginPageController {

    private String role;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUsername;

    private final AdminService adminService = new AdminServiceImpl();
    private final StaffService staffService = new StaffServiceImpl();

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
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (role.equals("Admin")) {
            if (adminService.validateAdminLogin(username, password)) {
                loadAdminDashboard(username, event);
            } else {
                if (!adminService.usernameExists(username)) {
                    AlertUtil.showAlert("Login Error", "Username not found", null, Alert.AlertType.ERROR);
                } else {
                    AlertUtil.showAlert("Login Error", "Incorrect password", null, Alert.AlertType.ERROR);
                }
            }
        } else if (role.equals("Staff")) {
            if (staffService.validateStaffLogin(username, password)) {
                loadStaffDashboard(username, event);
            } else {
                if (!staffService.usernameExists(username)) {
                    AlertUtil.showAlert("Login Error", "Username not found", null, Alert.AlertType.ERROR);
                } else {
                    AlertUtil.showAlert("Login Error", "Incorrect password", null, Alert.AlertType.ERROR);
                }
            }
        }
    }

    private void loadAdminDashboard(String username, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/admin_dashboard_form.fxml"));
            Parent root = loader.load();

            AdminDashboardFormController adminDashboardFormController = loader.getController();
            adminDashboardFormController.setAdminUsername(username);

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

    private void loadStaffDashboard(String username, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/staff_dashboard_form.fxml"));
            Parent root = loader.load();

            StaffDashboardFormController staffDashboardFormController = loader.getController();
            staffDashboardFormController.setStaffUsername(username);

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
