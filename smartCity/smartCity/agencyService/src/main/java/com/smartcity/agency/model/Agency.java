package com.smartcity.agency.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Agency {

    @Id
    private String id;

    private String name;
    private String contactEmail;
    private String contactPhone;
    private boolean active;

    // Constructors
    public Agency() {}

    public Agency(String id, String name, String contactEmail, String contactPhone, boolean active) {
        this.id = id;
        this.name = name;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.active = active;
    }

    // Getters and setters
    // (You can generate them using your IDE)
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
