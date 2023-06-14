package Interfaces;

import java.sql.SQLException;

/**
 * This is a functional interface for use with a lambda expression to check a user's upcoming appointments.
 * @author David Long
 */
public interface AppointmentInterface {

    // Abstract method for checking a user's appointments
    void apptCheck(Object userId) throws SQLException;
}