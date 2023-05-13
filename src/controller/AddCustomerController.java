package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is used to manage the flow of data and view of the application's Add Customer GUI form.
 * @author David Long
 */
public class AddCustomerController implements Initializable {
    @FXML
    private ComboBox<?> addCountryComboBox;

    @FXML
    private TextField addCustAddressFld;

    @FXML
    private Button addCustCancelBtn;

    @FXML
    private TextField addCustIDFld;

    @FXML
    private TextField addCustNameFld;

    @FXML
    private TextField addCustPhoneFld;

    @FXML
    private TextField addCustPostalFld;

    @FXML
    private Button addCustSaveBtn;

    @FXML
    private ComboBox<?> addStateComboBox;

    /**
     * TODO
     * @param url The location of the controller's .fxml file
     * @param resourceBundle The locale-specific resources for the controller's objects
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Add customer form initialized");
    }

    @FXML
    void onActionAddCustCancel(ActionEvent event) {

    }

    @FXML
    void onActionSaveNewCustomer(ActionEvent event) {

    }

    @FXML
    void onCountrySelection(ActionEvent event) {

    }
}
