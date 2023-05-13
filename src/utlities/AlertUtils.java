package utlities;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.ResourceBundle;

/**
 * This class creates alert dialog boxes.
 * @author David Long
 */
public class AlertUtils {

    public static ResourceBundle rb_languages = ResourceBundle.getBundle("languages.loginRB");

    /**
     * This method creates an error alert dialog box for an empty text field.
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
    public static boolean cancelWarning(String objectType) {
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
    public static boolean cancelWarning() {
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

}
