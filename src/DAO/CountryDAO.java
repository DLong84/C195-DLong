package DAO;

import controller.AddUpdateCustomerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles database access for the Countries table.
 * @author David Long
 */
public class CountryDAO {

    // Query for everything in Countries table
    private static final String selectAllQuery = "SELECT * FROM COUNTRIES";

    /**
     * TODO
     * @return
     * @throws SQLException
     */
    public static ObservableList<Country> getAllCountries () throws SQLException {
        ObservableList<Country> countries = FXCollections.observableArrayList();

        PreparedStatement ps = JDBC.connection.prepareStatement(selectAllQuery);

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Country country = new Country(resultSet.getInt("Country_Id"),
                    resultSet.getString("Country"));

            countries.add(country);
        }
        return countries;
    }

    /**
     * TODO
     * @return
     * @throws SQLException
     */
    public static ObservableList<String> getAllCountryNames () throws SQLException {
        ObservableList<String> countries = FXCollections.observableArrayList();

        PreparedStatement ps = JDBC.connection.prepareStatement(selectAllQuery);

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Country country = new Country(resultSet.getInt("Country_Id"),
                    resultSet.getString("Country"));
            String countryName = country.getCountry();
            countries.add(countryName);
        }
        return countries;
    }

    /**
     * This method retrieves the ID of the currently selected country in a ComboBox from the database.
     * @param selectedCountry
     * @return the Country's ID
     * @throws SQLException
     */
    public static int getCountryId(String selectedCountry) throws SQLException {
        selectedCountry = AddUpdateCustomerController.selectedCountry;

        String query = "SELECT * FROM countries WHERE Country=?";

        PreparedStatement ps = JDBC.connection.prepareStatement(query);
        ps.setString(1, selectedCountry);

        ResultSet result = ps.executeQuery();

        // Instantiate the "ID" variable
        int countryId = -1;

        // If it exists, get the country's ID from the database results
        while (result.next()) {
            countryId = result.getInt("Country_ID");
        }

        return countryId;
    }


}
