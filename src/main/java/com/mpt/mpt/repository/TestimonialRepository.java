package com.mpt.mpt.repository;

import com.mpt.mpt.entity.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
    
    List<Testimonial> findByIsApprovedTrue();
    
    List<Testimonial> findByCustomerCustomerId(Long customerId);
    
    List<Testimonial> findByRating(Integer rating);
    
    @Query("SELECT t FROM Testimonial t WHERE t.isApproved = true ORDER BY t.rating DESC, t.createdAt DESC")
    List<Testimonial> findApprovedTestimonialsOrderByRatingAndDate();
    
    @Query("SELECT t FROM Testimonial t WHERE t.rating >= ?1 AND t.isApproved = true")
    List<Testimonial> findTestimonialsByMinimumRating(Integer minRating);
}
