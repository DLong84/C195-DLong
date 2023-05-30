package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles database access for the "contacts" table.
 * @author David Long
 */
public class ContactDAO {

    // Query for everything in "contacts" table
    private static final String selectAllQuery= "SELECT * FROM contacts";

    /**
     * This method retrieves all contact information currently in the database and instantiates a new contact
     * object for every record that is returned from the query. All contact objects are added to an observable list,
     * the list is then returned.
     * @return the list of contacts
     * @throws SQLException handles SQL errors
     */
    public static ObservableList<Contact> getAllContactObjects () throws SQLException {
        ObservableList<Contact> contacts = FXCollections.observableArrayList();

        PreparedStatement ps = JDBC.connection.prepareStatement(selectAllQuery);
        ResultSet rs = ps.executeQuery();

        // Create a Contact object for every record returned and add it to the list
        while (rs.next()) {
            Contact contact = new Contact(rs.getInt("Contact_ID"), rs.getString("Contact_Name"),
                    rs.getString("Email"));

            contacts.add(contact);
        }
        return contacts;
    }


}
