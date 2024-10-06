package controller.supply;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class SupplyManagementFormController implements Initializable {

    @FXML
    private JFXComboBox<?> cmbCategory;

    @FXML
    private JFXComboBox<?> cmbProductID;

    @FXML
    private JFXComboBox<?> cmbSize;

    @FXML
    private JFXComboBox<?> cmbSupplierID;

    @FXML
    private TableColumn<?, ?> colDateTime;

    @FXML
    private TableColumn<?, ?> colSupplierID;

    @FXML
    private TableColumn<?, ?> colSupplyCartProductID;

    @FXML
    private TableColumn<?, ?> colSupplyCartProductID1;

    @FXML
    private TableColumn<?, ?> colSupplyCartProductID2;

    @FXML
    private TableColumn<?, ?> colSupplyCartProductID3;

    @FXML
    private TableColumn<?, ?> colSupplyCartProductID4;

    @FXML
    private TableColumn<?, ?> colSupplyCartProductID5;

    @FXML
    private TableColumn<?, ?> colSupplyCartProductID6;

    @FXML
    private TableColumn<?, ?> colSupplyCartProductID7;

    @FXML
    private TableColumn<?, ?> colSupplyID;

    @FXML
    private TableColumn<?, ?> colSupplyTableProductID;

    @FXML
    private TableColumn<?, ?> colSupplyTableQty;

    @FXML
    private TableColumn<?, ?> colSupplyTableTotal;

    @FXML
    private TableColumn<?, ?> colSupplyTableUnitCost;

    @FXML
    private Label labelSupplyID;

    @FXML
    private TableView<?> tblSupplyCart;

    @FXML
    private TableView<?> tblSupplyTable;

    @FXML
    private Text txtID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private TextField txtSearchField;

    @FXML
    private JFXTextField txtTotal;

    @FXML
    private JFXTextField txtUnitCost;

    @FXML
    private JFXTextField txtUnitPrice;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDateAndTime();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddSupplyCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        try {
            FXMLLoader loader;
            if (role.equals("Admin")) {
                loader = new FXMLLoader(getClass().getResource("../../view/admin_dashboard_form.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("../../view/staff_dashboard_form.fxml"));
            }
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(role + " Dashboard");
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
    void btnClearOnAction(ActionEvent event) {

    }

    public void loadDateAndTime() {
        //        Date
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = simpleDateFormat.format(date);
        lblDate.setText(formatDate);

        //        Time
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime now = LocalTime.now();
            lblTime.setText(now.getHour()+":"+now.getMinute()+":"+now.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
}
