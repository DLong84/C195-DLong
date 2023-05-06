package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utlities.AlertUtils;
import utlities.ValidationUtils;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * TODO
 */
public class LoginController implements Initializable {

    // Elements of GUI form
    @FXML
    private Button loginBtn;

    @FXML
    private Button loginCancelBtn;

    @FXML
    private AnchorPane loginFormAll;

    @FXML
    private Label loginLbl;

    @FXML
    private PasswordField loginPassFld;

    @FXML
    private Label loginPassLbl;

    @FXML
    private Label loginTimeZoneLbl;

    @FXML
    private TextField loginUserFld;

    @FXML
    private Label loginUserLbl;

    /**
     * ResourceBundle object used to initialize the form with internationalized content
     */
    ResourceBundle rb_languages; //FIXME Delete????

    /**
     * This method loads the current form's GUI elements and obtains the current default locale accordingly
     * @param url The location of the controller's .fxml file.
     * @param rb_languages The locale-specific resources for the controller's objects.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb_languages) {
        System.out.println("Login form initialized");

        ResourceBundle.getBundle("languages.loginRB", Locale.getDefault());

        //loginBtn.setText(rb_french.getString("Login")); FIXME

    }

    /**
     * Checks user data pulled from text fields for validation against "Users" table in the database
     */
    void checkLogin() {
        //TODO
    }

    /**
     * TODO
     * @param actionEvent "Login" button click
     */
    @FXML
    void onActionLogin(ActionEvent actionEvent) {

        if (ValidationUtils.fieldIsEmpty(loginUserFld, AlertUtils.rb_languages.getString("Username"))) {
            return;
        }

        if (ValidationUtils.fieldIsEmpty(loginPassFld, AlertUtils.rb_languages.getString("Password"))) {
            return;
        }
    }

    /**
     * TODO
     * @param actionEvent "Exit" button click
     */
    @FXML
    void onActionLoginExit(ActionEvent actionEvent) {
    }
}
