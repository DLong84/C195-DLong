package controller;

import DAO.CountryDAO;
import DAO.DivisionDAO;
import Interfaces.ComboBoxInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Country;
import model.Division;
import utlities.SceneUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * This class is used to manage the flow of data and view of the application's Add/Update Customer GUI form.
 * @author David Long
 */
public class AddUpdateCustomerController implements Initializable {

    // Elements of GUI form
    @FXML
    private TextField custAddressFld;
    @FXML
    private Button custCancelBtn;
    @FXML
    private ComboBox<String> custCountryComboBox;
    @FXML
    private TextField custIDFld;
    @FXML
    private TextField custNameFld;
    @FXML
    private TextField custPhoneFld;
    @FXML
    private TextField custPostalFld;
    @FXML
    private Button custSaveBtn;
    @FXML
    private ComboBox<String> custStateComboBox;

    /**
     * Selected country from country ComboBox.
     */
    public static String selectedCountry;

    /**
     * TODO
     * @param url The location of the controller's .fxml file
     * @param resourceBundle The locale-specific resources for the controller's objects
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Customer form initialized");

        // Set Countries available in custCountryComboBox
        try {
            custCountryComboBox.setItems(CountryDAO.getAllCountryNames());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * TODO
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionCancelCustomer(ActionEvent event) throws IOException {
        SceneUtils.toMainForm(custCancelBtn);
        // TODO Add alert
    }

    /**
     * TODO
     * @param event
     * @throws SQLException
     */
    @FXML
    void onActionSaveCustomer(ActionEvent event) throws SQLException {
        //TODO
    }

    /**
     * Lambda expression used for filtering and setting Division names to be displayed in the "custStateComboBox".
     * It takes in a country's ID as a parameter, to be used as the filter. A lambda expression was chosen here for
     * clarity and conciseness.
     */
    ComboBoxInterface filter = (selectedCountryId) -> {
        // List for holding division names
        ObservableList<String> divisionNames = FXCollections.observableArrayList();

        // If the division's "Country ID" matches the selected country's ID, add it to the divisionNames list
        for (Division division : DivisionDAO.getAllDivisionObjects()) {
            if (division.getCountryId() == selectedCountryId) {
                divisionNames.add(division.getDivision());
            }
        }
        custStateComboBox.setItems(divisionNames); // Set the list of filtered division names in the ComboBox
    };

    /**
     * This method changes the available selections in the "custStateComboBox" depending on which country is selected in
     * the "custCountryComboBox".
     * @param event Selection made in "custCountryComboBox"
     * @throws SQLException
     */
    @FXML
    void onCountrySelection(ActionEvent event) throws SQLException {
        // Set currently selected country to static variable
        selectedCountry = custCountryComboBox.getSelectionModel().getSelectedItem();

        // Get selected country's ID and assign it to a variable
        int selectedCountryId = CountryDAO.getCountryId(selectedCountry);

        // Lambda expression call to filter divisions
        filter.filterComboBox(selectedCountryId);




        // FIXME Debugging purposes
        System.out.println(CountryDAO.getCountryId(selectedCountry));
    }
}
