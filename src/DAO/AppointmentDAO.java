package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointment;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles database access for the Appointments table.
 * @author David Long
 */
public class AppointmentDAO {

    // List of appointment objects instantiated from all records in the "appointments" table
    private static ObservableList<Appointment> allAppts = FXCollections.observableArrayList();

    // Select join query for pulling relevant appointment info from "appointments" & "contacts" tables
    private static final String getAllApptsQuery =
            "SELECT appt.Appointment_ID, appt.Title, appt.Description, appt.Location, appt.Type, appt.Start, appt.End,"
            + " appt.Customer_ID, appt.User_ID, ct.Contact_Name"
            + " FROM appointments AS appt"
            + " INNER JOIN contacts AS ct ON appt.Contact_ID = ct.Contact_ID";

    // Delete query for removing an appointment record from the "appointments" table
    private static final String deleteApptQuery = "DELETE FROM appointments WHERE Appointment_ID=?";

    // FIXME MAY or MAY NOT remove!!
    private static final String getUserApptsQuery =
            "SELECT appt.Appointment_ID, appt.Title, appt.Description, appt.Location, appt.Type, appt.Start, appt.End,"
            + " appt.Customer_ID, appt.User_ID, ct.Contact_Name"
            + " FROM appointments AS appt"
            + " INNER JOIN contacts AS ct ON appt.Contact_ID = ct.Contact_ID"
            + " WHERE appt.User_ID = ?";

    /**
     * This method retrieves all relevant appointment information currently in the database and instantiates a new
     * appointment object for every record that is returned from the query. All appointment objects are added to an
     * observable list, the list is then returned.
     * @return the list of appointments
     * @throws SQLException
     */
    public static ObservableList<Appointment> getAllAppts() throws SQLException {

        PreparedStatement ps = JDBC.connection.prepareStatement(getAllApptsQuery);
        ResultSet rs = ps.executeQuery();

        // Create an appointment object for every record returned and add it to the list
        while (rs.next()) {
            Appointment appointment  = new Appointment(rs.getInt("Appointment_ID"), rs.getString("Title"),
                    rs.getString("Description"), rs.getString("Location"), rs.getString("Type"),
                    rs.getString("Contact_Name"), rs.getTimestamp("Start").toLocalDateTime(),
                    rs.getTimestamp("End").toLocalDateTime(), rs.getInt("Customer_ID"),
                    rs.getInt("User_ID"));

            allAppts.add(appointment);
        }
        return allAppts;
    }

    // FIXME May or may not implement this (Will be used to filter appts per user_id)
    public static ObservableList<Appointment> getUserAppts (Object userId) {
        ObservableList<Appointment> userAppts = FXCollections.observableArrayList();
        return userAppts;
    }

    /**
     * TODO
     * @param selectedAppt
     * @return
     */
    public static boolean deleteAppt (Appointment selectedAppt) throws SQLException {

        PreparedStatement ps = JDBC.connection.prepareStatement(deleteApptQuery);
        ps.setInt(1, selectedAppt.getId());
        int isDeleted = ps.executeUpdate();

        if (isDeleted == 1) {
            System.out.println("Appointment with ID: " + selectedAppt.getId() + " deleted");
            return true;
        }
        else {
            System.out.println("Appointment with ID: " + selectedAppt.getId() + " not deleted");
            return false;
        }
    }
}
