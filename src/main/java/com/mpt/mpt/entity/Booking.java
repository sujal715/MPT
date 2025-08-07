package com.mpt.mpt.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingID")
    private Integer bookingId;
    
    @Column(name = "BookingDate", nullable = false)
    private LocalDate bookingDate;
    
    @Column(name = "BookingTime", nullable = false)
    private LocalTime bookingTime;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private BookingStatus status;
    
    @Column(name = "TotalAmount", precision = 10, scale = 2)
    private BigDecimal totalAmount;
    
    @Column(name = "Notes", columnDefinition = "TEXT")
    private String notes;
    
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;
    
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PackageID", nullable = false)
    private Package package_;
    
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> payments;
    
    // Constructors
    public Booking() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = BookingStatus.PENDING;
    }
    
    public Booking(LocalDate bookingDate, LocalTime bookingTime, Customer customer, Package package_) {
        this();
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.customer = customer;
        this.package_ = package_;
    }
    
    // Getters and Setters
    public Integer getBookingId() {
        return bookingId;
    }
    
    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
    
    public LocalDate getBookingDate() {
        return bookingDate;
    }
    
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
    
    public LocalTime getBookingTime() {
        return bookingTime;
    }
    
    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }
    
    public BookingStatus getStatus() {
        return status;
    }
    
    public void setStatus(BookingStatus status) {
        this.status = status;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
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
    
    public Package getPackage_() {
        return package_;
    }
    
    public void setPackage_(Package package_) {
        this.package_ = package_;
    }
    
    public List<Payment> getPayments() {
        return payments;
    }
    
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
    
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", bookingTime=" + bookingTime +
                ", status=" + status +
                ", totalAmount=" + totalAmount +
                '}';
    }
    
    // Enum for Booking Status
    public enum BookingStatus {
        PENDING, CONFIRMED, CANCELLED, COMPLETED
    }
} 