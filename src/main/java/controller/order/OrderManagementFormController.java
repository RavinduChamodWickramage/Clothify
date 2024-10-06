package controller.order;

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

public class OrderManagementFormController implements Initializable {

    @FXML
    private JFXComboBox<?> cmbProductID;

    @FXML
    private JFXComboBox<?> cmbSupplyID;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colCartDiscount;

    @FXML
    private TableColumn<?, ?> colCartProduct;

    @FXML
    private TableColumn<?, ?> colCartProductID;

    @FXML
    private TableColumn<?, ?> colCartQty;

    @FXML
    private TableColumn<?, ?> colCartSize;

    @FXML
    private TableColumn<?, ?> colCartTotal;

    @FXML
    private TableColumn<?, ?> colCartUnitPrice;

    @FXML
    private TableColumn<?, ?> colOrderDetailsDiscount;

    @FXML
    private TableColumn<?, ?> colOrderDetailsOrderID;

    @FXML
    private TableColumn<?, ?> colOrderDetailsProduct;

    @FXML
    private TableColumn<?, ?> colOrderDetailsProductID;

    @FXML
    private TableColumn<?, ?> colOrderDetailsQty;

    @FXML
    private TableColumn<?, ?> colOrderDetailsSize;

    @FXML
    private TableColumn<?, ?> colOrderDetailsTotal;

    @FXML
    private TableColumn<?, ?> colOrderDetailsUnitPrice;

    @FXML
    private Label labelOrderID;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblNetDiscount;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblTime;

    @FXML
    private TableView<?> tblCart;

    @FXML
    private TableView<?> tblOrderDetails;

    @FXML
    private JFXTextField txtCategory;

    @FXML
    private JFXTextField txtCustomerContact;

    @FXML
    private JFXTextField txtCustomerEmail;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private Text txtID;

    @FXML
    private JFXTextField txtProduct;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private TextField txtSearchField;

    @FXML
    private JFXTextField txtSize;

    @FXML
    private JFXTextField txtTotal;

    @FXML
    private JFXTextField txtUnitPrice;

    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDateAndTime();
    }

    @FXML
    void btnAddCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

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
