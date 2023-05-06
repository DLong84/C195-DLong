package utlities;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * This class contains methods to handle validations for the application's GUI
 */
public class ValidationUtils {

    public static boolean fieldIsEmpty(TextField fieldId, String labelTxt) {
        String field = fieldId.getText();
        if (field.isBlank()) {
            AlertUtils.popBlankAlert(labelTxt);
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean fieldIsEmpty(PasswordField fieldId, String labelTxt) {
        String field = fieldId.getText();
        if (field.isBlank()) {
            AlertUtils.popBlankAlert(labelTxt);
            return true;
        }
        else {
            return false;
        }
    }


}
