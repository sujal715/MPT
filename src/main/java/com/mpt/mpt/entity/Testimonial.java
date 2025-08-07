package com.mpt.mpt.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Testimonial")
public class Testimonial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TestimonialID")
    private Integer testimonialId;
    
    @Column(name = "Comment", nullable = false, columnDefinition = "TEXT")
    private String comment;
    
    @Column(name = "DateSubmitted", nullable = false)
    private LocalDate dateSubmitted;
    
    @Column(name = "Rating")
    private Integer rating;
    
    @Column(name = "IsApproved")
    private Boolean isApproved;
    
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;
    
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customer;
    
    // Constructors
    public Testimonial() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isApproved = false;
    }
    
    public Testimonial(String comment, LocalDate dateSubmitted, Customer customer) {
        this();
        this.comment = comment;
        this.dateSubmitted = dateSubmitted;
        this.customer = customer;
    }
    
    // Getters and Setters
    public Integer getTestimonialId() {
        return testimonialId;
    }
    
    public void setTestimonialId(Integer testimonialId) {
        this.testimonialId = testimonialId;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public LocalDate getDateSubmitted() {
        return dateSubmitted;
    }
    
    public void setDateSubmitted(LocalDate dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }
    
    public Integer getRating() {
        return rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    public Boolean getIsApproved() {
        return isApproved;
    }
    
    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "Testimonial{" +
                "testimonialId=" + testimonialId +
                ", comment='" + comment + '\'' +
                ", dateSubmitted=" + dateSubmitted +
                ", rating=" + rating +
                ", isApproved=" + isApproved +
                '}';
    }
} 