package controller;

import DAO.AppointmentDAO;
import DAO.ContactDAO;
import DAO.CustomerDAO;
import DAO.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Appointment;
import model.Contact;
import model.Customer;
import model.User;
import utlities.AlertUtils;
import utlities.SceneUtils;
import utlities.TimeUtils;
import utlities.ValidationUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

/**
 * This class is used to manage the flow of data and view of the application's Appointment GUI form.
 * @author David Long
 */
public class ApptController implements Initializable {

    // Elements of GUI form
    @FXML
    private Button apptCancelBtn;
    @FXML
    private ComboBox<Contact> apptContactComboBox;
    @FXML
    private ComboBox<Customer> apptCustIdComboBox;
    @FXML
    private DatePicker apptDatePkr;
    @FXML
    private TextField apptDescriptFld;
    @FXML
    private ComboBox<LocalTime> apptEndComboBox;
    @FXML
    private TextField apptIDFld;
    @FXML
    private TextField apptLocationFld;
    @FXML
    private Button apptSaveBtn;
    @FXML
    private ComboBox<LocalTime> apptStartComboBox;
    @FXML
    private TextField apptTitleFld;
    @FXML
    private TextField apptTypeFld;
    @FXML
    private ComboBox<User> apptUserIdComboBox;

    /**
     * Boolean variable for keeping track of appointment modification status.
     */
    static boolean modifyAppt = false;

    /**
     * This method loads the form's GUI elements and sets all the ComboBoxes with relevant objects. If an
     * appointment was selected for modification, the fields and ComboBoxes are set with the selected appointment data.
     * Otherwise, all form fields and selections are empty.
     * @param url The location of the controller's .fxml file
     * @param resourceBundle The locale-specific resources for the controller's objects
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Get selected appointment from Main form
        Appointment selectedAppt = MainFormController.selectedAppt;

        try {
            // Set ComboBoxes with objects
            try {
                apptStartComboBox.setItems(TimeUtils.getAllApptTimes());
                apptEndComboBox.setItems(TimeUtils.getAllApptTimes());
                apptContactComboBox.setItems(ContactDAO.getAllContactObjects());
                apptCustIdComboBox.setItems(CustomerDAO.getAllCustomers());
                apptUserIdComboBox.setItems(UserDAO.getAllUserObjects());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            // Load existing appointment info into form for existing appointment
            if (modifyAppt) {
                apptIDFld.setText(Integer.toString(selectedAppt.getId()));
                apptTitleFld.setText(selectedAppt.getTitle());
                apptDescriptFld.setText(selectedAppt.getDescription());
                apptLocationFld.setText(selectedAppt.getLocation());
                apptTypeFld.setText(selectedAppt.getType());
                apptDatePkr.setValue(selectedAppt.getStart().toLocalDate());
                apptStartComboBox.setValue(selectedAppt.getStart().toLocalTime());
                apptEndComboBox.setValue(selectedAppt.getEnd().toLocalTime());
                apptContactComboBox.setValue(ContactDAO.getContactObject(selectedAppt.getContact()));
                // TODO Customer Box selection
                // TODO User Box selection

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method throws a specific warning dialog box, depending on whether the user was attempting to modify an existing
     * appointment or add a new appointment. Upon the user selecting "yes" button in the respective dialog box, the scene is
     * then changed to the "MainForm" GUI.
     * @param event "Cancel" button click
     * @throws IOException thrown by FXMLLoader.load() if the .fxml file URL is not input correctly
     */
    @FXML
    void onActionCancelAppt(ActionEvent event) throws IOException {
        // Existing appointment warning
        if (modifyAppt) {
            if (AlertUtils.cancelWarningYes()) {
                modifyAppt = false; // Reset modification variable
                MainFormController.selectedAppt = null; // Reset selected appointment, no longer needed
                SceneUtils.toMainForm(apptCancelBtn);
            }
        }
        // New appointment warning
        else if (AlertUtils.cancelWarningYes("appointment")) {
            modifyAppt = false; // Reset modification variable
            MainFormController.selectedAppt = null; // Reset selected appointment, no longer needed
            SceneUtils.toMainForm(apptCancelBtn);
        }
    }

    @FXML
    void onActionSaveAppt(ActionEvent event) {
        // Form validation check for blank fields or non-selected ComboBoxes/DatePicker
        if (    ValidationUtils.fldIsEmpty(apptTitleFld, "Title") ||
                ValidationUtils.fldIsEmpty(apptDescriptFld, "Description") ||
                ValidationUtils.fldIsEmpty(apptLocationFld, "Location") ||
                ValidationUtils.fldIsEmpty(apptTypeFld, "Type") ||
                ValidationUtils.dateNotSelected(apptDatePkr, "Date") ||
                ValidationUtils.boxNotSelected(apptStartComboBox, "Start Time") ||
                ValidationUtils.boxNotSelected(apptEndComboBox, "End Time") ||
                ValidationUtils.boxNotSelected(apptContactComboBox, "Contact") ||
                ValidationUtils.boxNotSelected(apptCustIdComboBox, "Customer ID") ||
                ValidationUtils.boxNotSelected(apptUserIdComboBox, "User ID"))
        {
            return;
        }

        // Pull date from DatePicker and store as variable
        LocalDate apptDate = apptDatePkr.getValue();

        // Pull start/end times, convert them to "EST" and set them to variables
        LocalTime estStart = TimeUtils.toEST(TimeUtils.toDateTime(apptDate, apptStartComboBox.getValue()));
        LocalTime estEnd = TimeUtils.toEST(TimeUtils.toDateTime(apptDate, apptEndComboBox.getValue()));

        // Appointment times validation
        if (ValidationUtils.endIsBeforeStart(estStart, estEnd) ||
            ValidationUtils.outsideBussHours(estStart, estEnd))
        {
            return;
        }
        else {
            // TODO Prepare to load appt data into query and add/update appointment
        }


    }


}
