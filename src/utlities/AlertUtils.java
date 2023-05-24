package utlities;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Appointment;
import model.Customer;

import java.util.Optional;
import java.util.ResourceBundle;

/**
 * This class creates alert dialog boxes.
 * @author David Long
 */
public class AlertUtils {

    public static ResourceBundle rb_languages = ResourceBundle.getBundle("languages.loginRB");

    /**
     * This method creates an error alert dialog box for an empty text field on the login form.
     * @param labelTxt The current GUI form's label name for the empty text field
     */
    public static void loginBlankAlert(String labelTxt) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(labelTxt + " " + rb_languages.getString("blankAlertHeader"));
        alert.setContentText(rb_languages.getString("blankAlertContent") + labelTxt);

        // Create and set "Ok" button
        ButtonType okButton = new ButtonType(rb_languages.getString("Ok"));
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
        return;
    }

    /**
     * This method creates an error alert dialog box for an empty text field.
     * @param labelTxt the current GUI form's label name for the empty text field
     */
    public static void blankFldAlert(String labelTxt) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Missing Information");
        alert.setHeaderText(labelTxt + " field is blank!");
        alert.setContentText("Please enter a valid " + labelTxt.toLowerCase());
        alert.showAndWait();
        return;
    }

    /**
     * This method creates an error alert dialog box for when an object in a tableview is not selected for removal or
     * modification.
     * @param objectType the type of object that the user is attempting to modify or delete
     * @param action the action the user is attempting to perform
     */
    public static void noSelectionAlert(String objectType, String action) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No " + objectType + " Selected");
        alert.setHeaderText("No " + objectType + " Selected!");
        alert.setContentText("Please select the " + objectType.toLowerCase() + " to " + action);
        alert.showAndWait();
    }

    /**
     * This method creates an error alert dialog box for when an object in a ComboBox is not selected when attempting to
     * save or modify a customer or appointment.
     * @param objectType the type of object that the user
     */
    public static void noSelectionAlert(String objectType) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No " + objectType + " Selected");
        alert.setHeaderText("No " + objectType + " Selected!");
        alert.setContentText("Please select a " + objectType.toLowerCase());
        alert.showAndWait();
    }

    /**
     * This method creates a confirmation dialog box for exiting the application.
     * @return Returns true if the "Yes" button is clicked, otherwise returns false
     */
    public static boolean loginExitAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(rb_languages.getString("Exit"));
        alert.setHeaderText(rb_languages.getString("Exit"));
        alert.setContentText(rb_languages.getString("confirmExitContent"));

        // Create and set "Yes" and "Cancel" buttons
        ButtonType yesButton = new ButtonType(rb_languages.getString("Yes"));
        ButtonType cancelButton = new ButtonType(rb_languages.getString("Cancel"));
        alert.getButtonTypes().setAll(yesButton, cancelButton);

        // Return true if "Yes" button is clicked
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method creates an error dialog box for bad login credentials.
     */
    public static void popCredentialsAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(rb_languages.getString("badCredentialsTitle"));
        alert.setHeaderText(rb_languages.getString("badCredentialsHeader"));
        alert.setContentText(rb_languages.getString("badCredentialsContent"));

        // Set "Ok" button
        ButtonType okButton = new ButtonType(rb_languages.getString("Ok"));
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
        return;
        }

    /**
     * This method creates a confirmation dialog box for logging out of the application.
     * @return Returns true if the "Yes" button is clicked, otherwise returns false
     */
    public static boolean mainLogoutConfirm() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logoff?");
        alert.setContentText("Are you sure you want to logoff?");

        // Create and set "Yes" and "Cancel" buttons
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType cancelButton = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(yesButton, cancelButton);

        // Return true if "Yes" button is clicked
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method creates a warning dialog box for cancelling the creation of a new customer or appointment.
     * @param objectType The type of object being created (Customer or Appointment)
     * @return Returns true if the "Yes" button is clicked, otherwise returns false
     */
    public static boolean cancelWarningYes(String objectType) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("This new " + objectType + " will not be saved. Are you sure you want to cancel?");

        // Create and set "Yes" and "No" buttons
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");
        alert.getButtonTypes().setAll(yesButton, noButton);

        // Return true if "Yes" button is clicked
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method creates a warning dialog box for cancelling the modification of an existing customer or appointment.
     * @return Returns true if the "Yes" button is clicked, otherwise returns false
     */
    public static boolean cancelWarningYes() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Any changes will not be saved. Are you sure you want to cancel?");

        // Create and set "Yes" and "No" buttons
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");
        alert.getButtonTypes().setAll(yesButton, noButton);

        // Return true if "Yes" button is clicked
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * TODO
     * @param objectType
     * @return
     */
    public static boolean deleteWarningYes(String objectType) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Are you sure you want to delete this " + objectType + "?");

        // Create and set "Yes" and "No" buttons
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");
        alert.getButtonTypes().setAll(yesButton, noButton);

        // Return true if "Yes" button is clicked
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * TODO
     * @param selectedCustomer
     */
    public static void remainingApptsAlert(Customer selectedCustomer) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Customer Cannot Be Deleted");
        alert.setHeaderText(selectedCustomer.getName() + " Has Appointments Scheduled!");
        alert.setContentText("All appointments for " + selectedCustomer.getName() + " must be removed before attempting"
                                + " to delete");
        alert.showAndWait();
    }

    /**
     * TODO
     * @param selectedCustomer
     */
    public static void customerRemovedAlert(Customer selectedCustomer) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Customer Removed");
        alert.setHeaderText("Customer Removed");
        alert.setContentText(selectedCustomer.getName() + " successfully removed");
        alert.showAndWait();
    }

    /**
     * TODO
     * @param selectedAppointment
     */
    public static void apptCanceledAlert(Appointment selectedAppointment) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Appointment Canceled");
        alert.setHeaderText("Appointment Canceled");
        alert.setContentText("Appointment having ID: " + selectedAppointment.getId() + ", "  + selectedAppointment.getType()
            + " successfully canceled");
        alert.showAndWait();
    }




}
