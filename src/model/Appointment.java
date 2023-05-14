package model;

import java.time.LocalDateTime;

/**
 * This class represents an Appointment.
 * @author David Long
 */
public class Appointment {

    private int id;
    private String title;
    private String description;
    private String location;
    private String contact; //FIXME to int/contact id???
    private LocalDateTime start;
    private LocalDateTime end;
    private int customerId;
    private int userId;
    private int contactId;

    /**
     * This is the Appointment constructor.
     * @param id the appointment's ID
     * @param title the appointment's title
     * @param description the appointment's description
     * @param location the appointment's location
     * @param contact the appointment's contact
     * @param start the appointment's start date and time
     * @param end the appointment's end date and time
     * @param customerId the appointment's Customer ID
     * @param userId the appointment's User ID
     * @param contactId the appointment's Contact ID
     */
    public Appointment(int id, String title, String description, String location, String contact, LocalDateTime start,
                       LocalDateTime end, int customerId, int userId, int contactId)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.start = start;
        this.end = end;
        this.customerId = customerId;
        this.userId = userId;
        this.contactId = contactId;
    }

    // Setters for Appointment attributes
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    // Getters for Appointment attributes
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getUserId() {
        return userId;
    }

    public int getContactId() {
        return contactId;
    }
}
