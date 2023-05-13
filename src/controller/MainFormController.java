package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import utlities.AlertUtils;
import utlities.SceneUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is used to manage the flow of data and view of the application's main GUI form.
 * @author David Long
 */
public class MainFormController  implements Initializable {

    // Elements of GUI form
    @FXML
    private Button addApptBtn;

    @FXML
    private Button addCustomerBtn;

    @FXML
    private RadioButton allApptsRBtn;

    @FXML
    private ToggleGroup apptFilterTG;

    @FXML
    private Button deleteAppt;

    @FXML
    private Button deleteCustomer;

    @FXML
    private Button logoutBtn;

    @FXML
    private TableView<?> mainApptsTable;

    @FXML
    private TableView<?> mainCustomersTable;

    @FXML
    private Button mainReportsBtn;

    @FXML
    private RadioButton monthViewRBtn;

    @FXML
    private Button updateApptBtn;

    @FXML
    private Button updateCustomerBtn;

    @FXML
    private RadioButton weekViewRBtn;

    /**
     * TODO
     * @param url The location of the controller's .fxml file
     * @param resourceBundle The locale-specific resources for the controller's objects
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Main Form initialized");
    }

    @FXML
    void onActionAddAppt(ActionEvent event) {

    }

    @FXML
    void onActionAddCustomer(ActionEvent event) {

    }

    @FXML
    void onActionDeleteAppt(ActionEvent event) {

    }

    @FXML
    void onActionDeleteCustomer(ActionEvent event) {

    }

    /**
     * Upon confirmation though use of a dialog box, this method changes the current scene to the Login GUI form and
     * sets "currentUserID" object to null.
     * @param event "Logout" button click
     * @throws IOException thrown by FXMLLoader.load() if the .fxml file URL is not input correctly
     */
    @FXML
    void onActionLogOut(ActionEvent event) throws IOException {

        if (AlertUtils.mainLogoutConfirm() == true) {

            SceneUtils.toLoginForm(logoutBtn);

            // Set static variable to null (safety measure)
            LoginController.currentUserId = null;
        }
        System.out.println(LoginController.currentUserId);
    }

    @FXML
    void onActionShowReports(ActionEvent event) {

    }

    @FXML
    void onActionUpdateAppt(ActionEvent event) {

    }

    @FXML
    void onActionUpdateCustomer(ActionEvent event) {

    }

    @FXML
    void onViewAllAppts(ActionEvent event) {

    }

    @FXML
    void onViewMonthAppts(ActionEvent event) {

    }

    @FXML
    void onViewWeekAppts(ActionEvent event) {

    }

}
