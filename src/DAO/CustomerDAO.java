package DAO;

import controller.AddUpdateCustomerController;
import controller.MainFormController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;
import utlities.AlertUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles database access for the Customers table.
 * @author David Long
 */
public class CustomerDAO {

    // List of customer objects instantiated from all records in the "customers" table
    private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();

    // Query for everything in "customers" table
    private static final String selectAllQuery = "SELECT * FROM CUSTOMERS"; //FIXME DELETE???

    // Select join query for pulling relevant customer info from "customers", "first_level_divisions", & "countries" tables
    private static final String getAllCustomersQuery =
                    "SELECT cust.Customer_ID, cust.Customer_Name, cust.Address, cust.Postal_Code, cust.Phone, divs.Division, cnt.Country"
                    + " FROM customers AS cust"
                    + " INNER JOIN first_level_divisions AS divs ON cust.Division_ID = divs.Division_ID"
                    + " INNER JOIN countries AS cnt ON divs.Country_ID = cnt.Country_ID";

    // Insert statement for adding a new customer record to the "customers" table
    public static final String addCustomerStmt =
            "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Division_ID)"
            + " VALUES (?, ?, ?, ?, ?)";

    // Delete statement for removing a customer record from the "customers" table
    private static final String deleteCustomerStmt = "DELETE FROM customers WHERE Customer_ID=?";

    /**
     * This method retrieves all relevant customer information currently in the database and instantiates a new customer
     * object for every record that is returned from the query. All customer objects are added to an observable list,
     * the list is then returned.
     * @return the list of customers
     * @throws SQLException handles SQL errors
     */
    public static ObservableList<Customer> getAllCustomers() throws SQLException {
        // Clear out list of customers
        allCustomers.clear();

        PreparedStatement ps = JDBC.connection.prepareStatement(getAllCustomersQuery);
        ResultSet rs = ps.executeQuery();

        // Create a customer object for every record returned and add it to the list
        while (rs.next()) {
            Customer customer = new Customer(rs.getInt("Customer_ID"), rs.getString("Customer_Name"),
                    rs.getString("Address"), rs.getString("Country"), rs.getString("Division"),
                    rs.getString("Postal_Code"), rs.getString("Phone"));

            allCustomers.add(customer);
        }
        return allCustomers;
    }

    /**
     * TODO
     * @param selectedCustomer
     * @return
     * @throws SQLException handles SQL errors
     */
    public static boolean deleteCustomer(Customer selectedCustomer) throws SQLException {

        PreparedStatement ps = JDBC.connection.prepareStatement(deleteCustomerStmt);
        ps.setInt(1, selectedCustomer.getId());
        int isDeleted = ps.executeUpdate();

        // If successful
        if (isDeleted == 1) {
            System.out.println("Customer with ID: " + selectedCustomer.getId() + " deleted");
            getAllCustomers(); // Reload the observable list with updated table data
            AlertUtils.customerRemovedAlert(MainFormController.selectedCustomer);
            return true;
        }
        else {
            System.out.println("Something went wrong!");
            return false;
        }
    }

}
