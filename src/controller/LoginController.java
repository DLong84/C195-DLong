package controller;

import DAO.JDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utlities.AlertUtils;
import utlities.SceneUtils;
import utlities.TimeUtils;
import utlities.ValidationUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class is used to manage the flow of data and view of the application's Login GUI form.
 * @author David Long
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
     * Object used to pass the value of the current user's Id FIXME??
     */
    public static Object currentUserId = null;

    /**
     * ResourceBundle object used to initialize the form with internationalized content
     */
    //ResourceBundle rb_languages; //FIXME Delete????

    /**
     * This method loads the current form's GUI elements and obtains the current default locale accordingly.
     * @param url The location of the controller's .fxml file
     * @param rb_languages The locale-specific resources for the controller's objects
     */
    @Override
    public void initialize (URL url, ResourceBundle rb_languages) {
        System.out.println("Login form initialized");

        // Load form with the properties file of the corresponding default locale's language
        ResourceBundle.getBundle("languages.loginRB", Locale.getDefault());

        // Set displayed timezone
        loginTimeZoneLbl.setText(TimeUtils.getTimezone());
    }

    /**
     * This method checks the user's login credentials with "getUserId" method for existence in the database. Upon
     * validation, it assigns the user's Id to a variable then it calls the "toMainForm" method.
     * @param actionEvent "Login" button click
     * @throws SQLException handles SQL errors
     * @throws IOException thrown by FXMLLoader.load() if the .fxml file URL is not input correctly
     */
    @FXML
    void onActionLogin(ActionEvent actionEvent) throws SQLException, IOException {
        // Check for empty text fields
        if (ValidationUtils.loginIsEmpty(loginUserFld, AlertUtils.rb_languages.getString("Username"))) {
            return;
        }
        if (ValidationUtils.loginIsEmpty(loginPassFld, AlertUtils.rb_languages.getString("Password"))) {
            return;
        }

        // Assign the user's ID object to the static variable
        currentUserId = JDBC.getUserId(loginUserFld.getText(), loginPassFld.getText());

        // Login credentials check
        if (currentUserId == null) {
            AlertUtils.popCredentialsAlert();
        }
        else {
            System.out.println("User with ID: " + currentUserId + " validated");
            SceneUtils.toMainForm(loginBtn);
        }
    }

    /**
     * This method throws a confirmation dialog box and, if confirmed, closes database connection and exits the
     * application
     * @param actionEvent "Exit" button click
     */
    @FXML
    void onActionLoginExit(ActionEvent actionEvent) {

        if (AlertUtils.loginExitAlert() == true) {
            JDBC.closeConnection(); // Close the connection
            System.exit(0);
        }
    }
}
