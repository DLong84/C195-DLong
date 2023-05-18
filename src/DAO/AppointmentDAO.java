package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles database access for the Appointments table.
 * @author David Long
 */
public class AppointmentDAO {

    // Select join query for pulling relevant appointment info
    private static final String getAllApptsQuery =
            "SELECT appt.Appointment_ID, appt.Title, appt.Description, appt.Location, appt.Type, appt.Start, appt.End,"
            + " appt.Customer_ID, appt.User_ID, ct.Contact_Name"
            + " FROM appointments AS appt"
            + " INNER JOIN contacts AS ct ON appt.Contact_ID = ct.Contact_ID";

    // FIXME MAY or MAY NOT remove!!
    private static final String getUserApptsQuery =
            "SELECT appt.Appointment_ID, appt.Title, appt.Description, appt.Location, appt.Type, appt.Start, appt.End,"
            + " appt.Customer_ID, appt.User_ID, ct.Contact_Name"
            + " FROM appointments AS appt"
            + " INNER JOIN contacts AS ct ON appt.Contact_ID = ct.Contact_ID"
            + " WHERE appt.User_ID = ?";

    public static ObservableList<Appointment> getAllAppts() throws SQLException {
        ObservableList<Appointment> appts = FXCollections.observableArrayList();

        PreparedStatement ps = JDBC.connection.prepareStatement(getAllApptsQuery);
        ResultSet rs = ps.executeQuery();

        // Create an appointment object for every record returned and add it to the list
        while (rs.next()) {
            Appointment appointment  = new Appointment(rs.getInt("Appointment_ID"), rs.getString("Title"),
                    rs.getString("Description"), rs.getString("Location"), rs.getString("Type"),
                    rs.getString("Contact_Name"), rs.getTimestamp("Start").toLocalDateTime(),
                    rs.getTimestamp("End").toLocalDateTime(), rs.getInt("Customer_ID"),
                    rs.getInt("User_ID"));

            appts.add(appointment);
        }
        return appts;
    }



    // FIXME May or may not implement this (Will be used to filter appts per user_id)
    public static ObservableList<Appointment> getUserAppts (Object userId) {
        ObservableList<Appointment> userAppts = FXCollections.observableArrayList();
        return userAppts;
    }
}
