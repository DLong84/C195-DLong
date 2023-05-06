package utlities;

import javafx.scene.control.Alert;

import java.util.ResourceBundle;

/**
 * This class creates alert dialog boxes
 */
public class AlertUtils {

    public static ResourceBundle rb_languages = ResourceBundle.getBundle("languages.loginRB");

    /**
     * This method creates an error alert dialog box for an empty text field
     * @param labelTxt The current GUI form's label name for the empty text field
     */
    public static void popBlankAlert(String labelTxt) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(labelTxt + " " + rb_languages.getString("blankAlertHeader"));
        alert.setContentText(rb_languages.getString("blankAlertContent")+ labelTxt);
        alert.showAndWait();
        return;
    }



}
