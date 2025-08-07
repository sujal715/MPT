package com.mpt.mpt.repository;

import com.mpt.mpt.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
    // Find customer by email
    Optional<Customer> findByEmail(String email);
    
    // Find customers by first name
    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);
    
    // Find customers by last name
    List<Customer> findByLastNameContainingIgnoreCase(String lastName);
    
    // Find customers by first name and last name
    List<Customer> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
            String firstName, String lastName);
    
    // Find customers by phone number
    Optional<Customer> findByPhone(String phone);
    
    // Find customers with active bookings
    @Query("SELECT DISTINCT c FROM Customer c JOIN c.bookings b WHERE b.status = 'CONFIRMED'")
    List<Customer> findCustomersWithActiveBookings();
    
    // Find customers who have submitted testimonials
    @Query("SELECT DISTINCT c FROM Customer c JOIN c.testimonials t WHERE t.isApproved = true")
    List<Customer> findCustomersWithApprovedTestimonials();
    
    // Count total customers
    @Query("SELECT COUNT(c) FROM Customer c")
    long countTotalCustomers();
    
    // Find customers created in a specific date range
    @Query("SELECT c FROM Customer c WHERE c.createdAt BETWEEN :startDate AND :endDate")
    List<Customer> findCustomersCreatedBetween(@Param("startDate") String startDate, 
                                             @Param("endDate") String endDate);
} 