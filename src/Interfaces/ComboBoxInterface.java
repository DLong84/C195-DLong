package Interfaces;

import java.sql.SQLException;

/**
 * This is a functional interface for use with a lambda expression to filter a combo box's available selections.
 * @author David Long
 */
public interface ComboBoxInterface {

    // Abstract method for filtering/setting the combo box's selections
    void filterComboBox (int selectedCountryId) throws SQLException;
}
