package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles database access for the Customers table.
 * @author David Long
 */
public class CustomerDAO {

    // Query for everything in Customers table
    private static final String selectAllQuery = "SELECT * FROM CUSTOMERS"; //FIXME DELETE???

    // Select join query for pulling relevant customer info
    private static final String getAllCustomersQuery =
                    "SELECT cust.Customer_ID, cust.Customer_Name, cust.Address, cust.Postal_Code, cust.Phone, divs.Division, cnt.Country"
                    + " FROM customers AS cust"
                    + " INNER JOIN first_level_divisions AS divs ON cust.Division_ID = divs.Division_ID"
                    + " INNER JOIN countries AS cnt ON divs.Country_ID = cnt.Country_ID";

    /**
     * This method retrieves all relevant customer information currently in the database and instantiates a new Customer
     * object for every record that is returned from the query. All customer objects are added to an observable list,
     * which is what is returned.
     * @return the list of customers
     * @throws SQLException
     */
    public static ObservableList<Customer> getAllCustomers () throws SQLException {
        ObservableList<Customer> customers = FXCollections.observableArrayList();

        PreparedStatement ps = JDBC.connection.prepareStatement(getAllCustomersQuery);
        ResultSet rs = ps.executeQuery();

        // Create a customer object for every record returned and add it to the list
        while (rs.next()) {
            Customer customer = new Customer(rs.getInt("Customer_ID"), rs.getString("Customer_Name"),
                    rs.getString("Address"), rs.getString("Country"), rs.getString("Division"),
                    rs.getString("Postal_Code"), rs.getString("Phone"));

            customers.add(customer);
        }
        return customers;
    }

}
