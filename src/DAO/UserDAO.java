package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contact;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles database access for the "users" table.
 * @author David Long
 */
public class UserDAO {

    // Query for everything in "users" table
    private static final String selectAllQuery= "SELECT * FROM users";

    /**
     * This method retrieves all user information currently in the database and instantiates a new user object for every
     * record that is returned from the query. All user objects are added to an observable list, the list is then
     * returned.
     * @return the list of users
     * @throws SQLException handles SQL errors
     */
    public static ObservableList<User> getAllUserObjects () throws SQLException {
        ObservableList<User> users = FXCollections.observableArrayList();

        PreparedStatement ps = JDBC.connection.prepareStatement(selectAllQuery);
        ResultSet rs = ps.executeQuery();

        // Create a User object for every record returned and add it to the list
        while (rs.next()) {
            User user = new User(rs.getInt("User_ID"), rs.getString("User_Name"));

            users.add(user);
        }
        return users;
    }
}
