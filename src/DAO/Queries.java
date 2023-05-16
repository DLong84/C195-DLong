package DAO;

/**
 * This class assigns SQL queries to variables for ease of use.
 * @author David Long
 */
public class Queries {

    // SELECT queries
    public static final String userIdQuery = "SELECT User_ID FROM USERS WHERE User_Name=? AND Password=?"; // Login

    public static final String allCountriesQuery = "SELECT * FROM COUNTRIES"; // Countries

    // TODO DELETE THIS CLASS!!!
}
