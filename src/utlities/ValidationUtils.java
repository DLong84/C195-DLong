package utlities;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * This class contains methods to handle validations for the application's GUI.
 * @author David Long
 */
public class ValidationUtils {

    /**
     * TODO
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



}
