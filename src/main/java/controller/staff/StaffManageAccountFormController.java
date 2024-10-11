package controller.staff;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.admin.AdminDashboardFormController;
import entity.AdminEntity;
import entity.StaffEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.custom.StaffService;
import util.AdminSession;
import util.AlertUtil;
import util.ServiceType;
import util.StaffSession;

import java.io.IOException;

public class StaffManageAccountFormController {

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtRePassword;

    @FXML
    private Text txtStaffID;

    @FXML
    private JFXTextField txtUsername;

    private final StaffService staffService = ServiceFactory.getInstance().getServiceType(ServiceType.STAFF_SERVICE);

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/staff_dashboard_form.fxml"));
            Parent root = loader.load();

            StaffDashboardFormController controller = loader.getController();
            StaffEntity staff = StaffSession.getInstance().getStaff();
            controller.setStaffUsername(staff.getUsername());

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Manage Account - Staff");
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
    void btnUpdateOnAction(ActionEvent event) {
        if (!txtPassword.getText().equals(txtRePassword.getText())) {
            AlertUtil.showAlert("Password Mismatch", "Passwords do not match.", "Please ensure both password fields match.", javafx.scene.control.Alert.AlertType.ERROR);
            return;
        }

        String staffId = txtStaffID.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        StaffEntity existingStaff = staffService.findStaffById(staffId);

        if (existingStaff != null) {
            boolean isUpdated = staffService.updateStaffAccount(staffId, username, password);

            if (isUpdated) {
                existingStaff.setUsername(username);
                existingStaff.setPassword(password);
                StaffSession.getInstance().setStaff(existingStaff);

                AlertUtil.showAlert("Success", "Staff details updated successfully", null, javafx.scene.control.Alert.AlertType.INFORMATION);
                btnDashboardOnAction(event);
            } else {
                AlertUtil.showAlert("Update Failed", "Could not update staff details", null, javafx.scene.control.Alert.AlertType.ERROR);
            }
        } else {
            AlertUtil.showAlert("Update Failed", "Staff member not found", null, javafx.scene.control.Alert.AlertType.ERROR);
        }
    }

    public void setStaffDetails(String staffId, String username, String phoneNumber, String password) {
        txtStaffID.setText(staffId);
        txtUsername.setText(username);
        txtPassword.setText(password);
        txtRePassword.clear();
    }
}
