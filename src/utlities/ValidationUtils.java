package utlities;

import DAO.AppointmentDAO;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Appointment;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
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

    /**
     * TODO
     * @param fieldId
     * @param labelTxt
     * @return
     */
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

    /**
     * TODO
     * @param boxId
     * @param labelTxt
     * @return
     */
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
     * @param pickerId
     * @param labelTxt
     * @return
     */
    public static boolean dateNotSelected(DatePicker pickerId, String labelTxt) {
        Object field = pickerId.getValue();
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
     * TODO
     * @param selectedCustomer
     * @return
     * @throws SQLException
     */
    public static boolean customerHasAppts(Customer selectedCustomer) throws SQLException {
        for (Appointment appt : AppointmentDAO.getAllAppts()) {
            if (selectedCustomer.getId() == appt.getCustomerId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method compares the appointment starting time to the appointment ending time for validation. If the appointment
     * ending time is before or equal to the appointment starting time, the "apptTimesAlert" method is called and
     * the method returns true. Otherwise, it returns false.
     * @param apptStart the appointment starting time
     * @param apptEnd the appointment ending time
     * @return "true" if end time is before or equal to start time, otherwise "false"
     */
    public static boolean endIsBeforeStart(LocalTime apptStart, LocalTime apptEnd) {
        if (apptEnd.isBefore(apptStart) || apptEnd.equals(apptStart)) {
            AlertUtils.apptTimesAlert(); // Alert dialog box
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method compares the appointment starting time to the start of business hours and the appointment ending time
     * to the end of business hours. If the proposed start is before 8am or the proposed end is after 10pm, the
     * "businessHoursAlert" method is called and the method returns true. Otherwise, it returns false.
     * @param apptStart the appointment starting time
     * @param apptEnd the appointment ending time
     * @return "true" if start is before 8am or end is after 10pm, otherwise "false"
     */
    public static boolean outsideBussHours(LocalTime apptStart, LocalTime apptEnd) {

        if (apptStart.isBefore(LocalTime.of(8, 00)) || apptEnd.isAfter(LocalTime.of(22, 00))) {
            AlertUtils.businessHoursAlert(); // Alert dialog box
            return true;
        }
        else {
            return false;
        }
    }

}
