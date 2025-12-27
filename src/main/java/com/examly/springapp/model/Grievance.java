package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Grievance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grievanceId;

    private String title;
    private String description;
    private String priority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User complainant;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private GrievanceCategory grievanceCategory;

    public Grievance() {
    }

    public Long getGrievanceId() {
        return grievanceId;
    }

    public void setGrievanceId(Long grievanceId) {
        this.grievanceId = grievanceId;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public User getComplainant() {
        return complainant;
    }
    
    public void setComplainant(User complainant) {
        this.complainant = complainant;
    }

    public GrievanceCategory getGrievanceCategory() {
        return grievanceCategory;
    }
    
    public void setGrievanceCategory(GrievanceCategory grievanceCategory) {
        this.grievanceCategory = grievanceCategory;
    }
}
