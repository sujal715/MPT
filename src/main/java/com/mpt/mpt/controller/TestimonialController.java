package com.mpt.mpt.controller;

import com.mpt.mpt.entity.Testimonial;
import com.mpt.mpt.entity.Customer;
import com.mpt.mpt.repository.TestimonialRepository;
import com.mpt.mpt.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/testimonials")
@CrossOrigin(origins = "*")
public class TestimonialController {

    @Autowired
    private TestimonialRepository testimonialRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Get all testimonials
    @GetMapping
    public ResponseEntity<List<Testimonial>> getAllTestimonials() {
        List<Testimonial> testimonials = testimonialRepository.findAll();
        return ResponseEntity.ok(testimonials);
    }

    // Get testimonial by ID
    @GetMapping("/{id}")
    public ResponseEntity<Testimonial> getTestimonialById(@PathVariable Long id) {
        Optional<Testimonial> testimonial = testimonialRepository.findById(id);
        return testimonial.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new testimonial
    @PostMapping
    public ResponseEntity<Testimonial> createTestimonial(@RequestBody Testimonial testimonial) {
        // Set customer if ID is provided
        if (testimonial.getCustomer() != null && testimonial.getCustomer().getCustomerId() != null) {
            Optional<Customer> customer = customerRepository.findById(testimonial.getCustomer().getCustomerId());
            if (customer.isPresent()) {
                testimonial.setCustomer(customer.get());
            }
        }
        
        testimonial.setCreatedAt(LocalDateTime.now());
        testimonial.setUpdatedAt(LocalDateTime.now());
        Testimonial savedTestimonial = testimonialRepository.save(testimonial);
        return ResponseEntity.ok(savedTestimonial);
    }

    // Update testimonial
    @PutMapping("/{id}")
    public ResponseEntity<Testimonial> updateTestimonial(@PathVariable Long id, @RequestBody Testimonial testimonialDetails) {
        Optional<Testimonial> testimonialOptional = testimonialRepository.findById(id);
        if (testimonialOptional.isPresent()) {
            Testimonial testimonial = testimonialOptional.get();
            testimonial.setContent(testimonialDetails.getContent());
            testimonial.setRating(testimonialDetails.getRating());
            testimonial.setIsApproved(testimonialDetails.getIsApproved());
            testimonial.setUpdatedAt(LocalDateTime.now());
            
            Testimonial updatedTestimonial = testimonialRepository.save(testimonial);
            return ResponseEntity.ok(updatedTestimonial);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete testimonial
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonial(@PathVariable Long id) {
        if (testimonialRepository.existsById(id)) {
            testimonialRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Get approved testimonials
    @GetMapping("/approved")
    public ResponseEntity<List<Testimonial>> getApprovedTestimonials() {
        List<Testimonial> testimonials = testimonialRepository.findByIsApprovedTrue();
        return ResponseEntity.ok(testimonials);
    }

    // Get testimonials by customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Testimonial>> getTestimonialsByCustomerId(@PathVariable Long customerId) {
        List<Testimonial> testimonials = testimonialRepository.findByCustomerCustomerId(customerId);
        return ResponseEntity.ok(testimonials);
    }

    // Get testimonials by rating
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Testimonial>> getTestimonialsByRating(@PathVariable Integer rating) {
        List<Testimonial> testimonials = testimonialRepository.findByRating(rating);
        return ResponseEntity.ok(testimonials);
    }

    // Approve testimonial
    @PutMapping("/{id}/approve")
    public ResponseEntity<Testimonial> approveTestimonial(@PathVariable Long id) {
        Optional<Testimonial> testimonialOptional = testimonialRepository.findById(id);
        if (testimonialOptional.isPresent()) {
            Testimonial testimonial = testimonialOptional.get();
            testimonial.setIsApproved(true);
            testimonial.setUpdatedAt(LocalDateTime.now());
            
            Testimonial updatedTestimonial = testimonialRepository.save(testimonial);
            return ResponseEntity.ok(updatedTestimonial);
        }
        return ResponseEntity.notFound().build();
    }
}
