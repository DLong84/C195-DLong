package DAO;

import controller.AddUpdateCustomerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;
import model.Division;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles database access for the First Level Divisions table.
 * @author David Long
 */
public class DivisionDAO {

    // Query for everything in First Level Divisions table
    private static final String selectAllQuery= "SELECT * FROM first_level_divisions";

    /**
     * TODO.......Is this function NEEDED???
     * @return
     * @throws SQLException
     */
    public static ObservableList<String> getAllDivisionNames () throws SQLException {
        ObservableList<String> divisions = FXCollections.observableArrayList();

        PreparedStatement ps = JDBC.connection.prepareStatement(selectAllQuery);

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Division division = new Division(resultSet.getInt("Division_ID"),
                    resultSet.getString("Division"), resultSet.getInt("Country_ID"));
            String divisionName = division.getDivision();
            divisions.add(divisionName);
        }
        return divisions;
    }

    /**
     * TODO
     * @return
     * @throws SQLException
     */
    public static ObservableList<Division> getAllDivisionObjects () throws SQLException {
        ObservableList<Division> divisions = FXCollections.observableArrayList();

        PreparedStatement ps = JDBC.connection.prepareStatement(selectAllQuery);

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Division division = new Division(resultSet.getInt("Division_ID"),
                    resultSet.getString("Division"), resultSet.getInt("Country_ID"));

            divisions.add(division);
        }
        return divisions;
    }

}
