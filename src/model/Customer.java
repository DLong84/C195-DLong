package model;

/**
 * This class represents a Customer.
 * @author David Long
 */
public class Customer {
    private int id;
    private String name;
    private String address;
    private String country;
    private String state;
    private String postalCode;
    private int divisionId;

    /**
     * This is the Customer constructor.
     *
     * @param id the customer's ID
     * @param name the customer's Name
     * @param address the customer's Address
     * @param country the customer's Country
     * @param state the customer's State
     * @param divisionId the customer's Division ID
     */
    public Customer(int id, String name, String address, String country, String state, int divisionId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.state = state;
        this.divisionId = divisionId;
    }

    // Setters for Customer attributes
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    // Getters for Customer attributes
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getDivisionId() {
        return divisionId;
    }
}