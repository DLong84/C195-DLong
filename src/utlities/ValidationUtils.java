package utlities;

import DAO.AppointmentDAO;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Appointment;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * This class contains methods to handle validations for the application's GUI.
 * @author David Long
 */
public class ValidationUtils {

    /**
     * This method checks for
     * @param fieldId
     * @param labelTxt
     * @return
     */
    public static boolean loginIsEmpty(TextField fieldId, String labelTxt) {
        String field = fieldId.getText();
        if (field.isBlank()) {
            AlertUtils.loginBlankAlert(labelTxt);
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean fldIsEmpty(TextField fieldId, String labelTxt) {
        String field = fieldId.getText();
        if (field.isBlank()) {
            AlertUtils.blankFldAlert(labelTxt);
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean boxNotSelected(ComboBox boxId, String labelTxt) {
        Object field = boxId.getValue();
        if (field == null) {
            AlertUtils.noSelectionAlert(labelTxt);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * TODO
     * @param fieldId
     * @param labelTxt
     * @return
     */
    public static boolean loginIsEmpty(PasswordField fieldId, String labelTxt) {
        String field = fieldId.getText();
        if (field.isBlank()) {
            AlertUtils.loginBlankAlert(labelTxt);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method obtains the current system's timezone "ZoneId" and returns it as a String
     * @return the ZoneId (String)
     */
    public static String getTimezone() {
        String timezone = ZoneId.systemDefault().getId();
        return timezone;
    }

    // TODO Create overloaded getTimezone() method to return TimeZone type??

    public static boolean customerHasAppts(Customer selectedCustomer) throws SQLException {
        for (Appointment appt : AppointmentDAO.getAllAppts()) {
            if (selectedCustomer.getId() == appt.getCustomerId()) {
                return true;
            }
        }
        return false;
    }



}
