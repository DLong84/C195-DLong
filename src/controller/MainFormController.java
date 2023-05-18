package controller;

import DAO.AppointmentDAO;
import DAO.CustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Appointment;
import model.Customer;
import utlities.AlertUtils;
import utlities.SceneUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
    private TableColumn<Appointment, String> apptContactCol;

    @FXML
    private TableColumn<Appointment, Integer> apptCustIdCol;

    @FXML
    private TableColumn<Appointment, String> apptDescripCol;

    @FXML
    private TableColumn<Appointment, LocalDateTime> apptEndDTCol;

    @FXML
    private ToggleGroup apptFilterTG;

    @FXML
    private TableColumn<Appointment, Integer> apptIdCol;

    @FXML
    private TableColumn<Appointment, String> apptLocationCol;

    @FXML
    private TableColumn<Appointment, LocalDateTime> apptStartDTCol;

    @FXML
    private TableColumn<Appointment, String> apptTitleCol;

    @FXML
    private TableColumn<Appointment, String> apptTypeCol;

    @FXML
    private TableColumn<Appointment, Integer> apptUserIdCol;

    @FXML
    private TableColumn<Customer, String> custAddressCol;

    @FXML
    private TableColumn<Customer, Integer> custIdCol;

    @FXML
    private TableColumn<Customer, String> custNameCol;

    @FXML
    private TableColumn<Customer, String> custPhoneCol;

    @FXML
    private TableColumn<Customer, String> custPostalCol;

    @FXML
    private TableColumn<Customer, String> custStateProvCol;

    @FXML
    private Button deleteAppt;

    @FXML
    private Button deleteCustomer;

    @FXML
    private Button logoutBtn;

    @FXML
    private TableView<Appointment> mainApptsTable;

    @FXML
    private TableView<Customer> mainCustomersTable;

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
        // Set tableview with all customers in database
        try {
            mainCustomersTable.setItems(CustomerDAO.getAllCustomers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        custIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        custNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        custAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        custStateProvCol.setCellValueFactory(new PropertyValueFactory<>("state"));
        custPostalCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        custPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        // Set tableview with all appointments in database relevant to current user
        try {
            mainApptsTable.setItems(AppointmentDAO.getAllAppts());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        apptIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        apptTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        apptDescripCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        apptLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        apptTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        apptContactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        apptStartDTCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        apptEndDTCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        apptCustIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        apptUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        System.out.println("Main Form initialized");
    }

    @FXML
    void onActionAddAppt(ActionEvent event) {

    }

    @FXML
    void onActionAddCustomer(ActionEvent event) throws IOException {
        SceneUtils.toCustomerForm(addCustomerBtn);
    }

    @FXML
    void onActionDeleteAppt(ActionEvent event) {

    }

    @FXML
    void onActionDeleteCustomer(ActionEvent event) throws SQLException {

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
