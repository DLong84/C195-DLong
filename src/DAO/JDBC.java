package DAO;

import java.sql.*;


public class JDBC {
    private static final String protocol = "jdbc";
        private static final String vendor = ":mysql:";
        private static final String location = "//localhost/";
        private static final String databaseName = "client_schedule";
        private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
        private static final String driver = "com.mysql.cj.jdbc.Driver"; // Driver reference
        private static final String userName = "sqlUser"; // Username
        private static String password = "Passw0rd!"; // Password
        public static Connection connection = null;  // Connection Interface

    /**
     * This method establishes the connection to the database.
     */
    public static void openConnection()
    {
        try {
            Class.forName(driver); // Locate Driver
            //password = Details.getPassword(); // Assign password FIXME???
            connection = DriverManager.getConnection(jdbcUrl, userName, password); // Reference Connection object
            System.out.println("Connection successful!");
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }

    /**
     * This method closes the connection to the database.
     */
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed");
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }

    /**
     * This method takes in a username and password, then executes a query which returns a matching ID object from the
     * USERS table. If there is no user with same username and password, it returns a null object.
     * @param userName The user's username
     * @param passWord The user's password
     * @return If it exists, the user's ID, otherwise null.
     * @throws SQLException handles SQL errors
     */
    public static Object getUserId (String userName, String passWord) throws SQLException {
        String query = "SELECT User_ID FROM USERS WHERE User_Name=? AND Password=?";

        PreparedStatement ps = JDBC.connection.prepareStatement(query);
        ps.setString(1, userName);
        ps.setString(2, passWord);

        ResultSet result = ps.executeQuery();

        Object userId = null;
        if (result.next()) {
            userId = result.getObject(1);
        }

        return userId;
    }



}
