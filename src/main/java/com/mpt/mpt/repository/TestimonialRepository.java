package com.mpt.mpt.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mpt.mpt.entity.Testimonial;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Integer> {
    
    // Find testimonials by customer
    List<Testimonial> findByCustomerCustomerId(Integer customerId);
    
    // Find testimonials by rating
    List<Testimonial> findByRating(Integer rating);
    
    // Find testimonials by rating range
    List<Testimonial> findByRatingBetween(Integer minRating, Integer maxRating);
    
    // Find approved testimonials
    List<Testimonial> findByIsApprovedTrue();
    
    // Find pending testimonials
    List<Testimonial> findByIsApprovedFalse();
    
    // Find testimonials by submission date
    List<Testimonial> findByDateSubmitted(LocalDate dateSubmitted);
    
    // Find testimonials by submission date range
    List<Testimonial> findByDateSubmittedBetween(LocalDate startDate, LocalDate endDate);
    
    // Find testimonials by comment containing (case insensitive)
    List<Testimonial> findByCommentContainingIgnoreCase(String comment);
    
    // Find testimonials by customer name
    @Query("SELECT t FROM Testimonial t JOIN t.customer c WHERE c.firstName LIKE %:name% OR c.lastName LIKE %:name%")
    List<Testimonial> findByCustomerNameContaining(@Param("name") String name);
    
    // Find testimonials created in a specific date range
    @Query("SELECT t FROM Testimonial t WHERE t.createdAt BETWEEN :startDate AND :endDate")
    List<Testimonial> findTestimonialsCreatedBetween(@Param("startDate") LocalDateTime startDate, 
                                                   @Param("endDate") LocalDateTime endDate);
    
    // Count testimonials by rating
    @Query("SELECT t.rating, COUNT(t) FROM Testimonial t GROUP BY t.rating ORDER BY t.rating")
    List<Object[]> countTestimonialsByRating();
    
    // Find average rating
    @Query("SELECT AVG(t.rating) FROM Testimonial t WHERE t.isApproved = true")
    Double getAverageRating();
    
    // Find testimonials with high ratings (4-5 stars)
    @Query("SELECT t FROM Testimonial t WHERE t.rating >= 4 AND t.isApproved = true")
    List<Testimonial> findHighRatedTestimonials();
    
    // Find testimonials with low ratings (1-2 stars)
    @Query("SELECT t FROM Testimonial t WHERE t.rating <= 2 AND t.isApproved = true")
    List<Testimonial> findLowRatedTestimonials();
    
    // Find most recent testimonials
    @Query("SELECT t FROM Testimonial t WHERE t.isApproved = true ORDER BY t.dateSubmitted DESC")
    List<Testimonial> findRecentApprovedTestimonials();
    
    // Count total approved testimonials
    @Query("SELECT COUNT(t) FROM Testimonial t WHERE t.isApproved = true")
    long countApprovedTestimonials();
    
    // Count total pending testimonials
    @Query("SELECT COUNT(t) FROM Testimonial t WHERE t.isApproved = false")
    long countPendingTestimonials();
} 