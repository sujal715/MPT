package com.mpt.mpt;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MainController {

    @GetMapping("/test")
    public Map<String, Object> test() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Backend is working!");
        response.put("status", "success");
        return response;
    }

    @GetMapping("/customers")
    public Map<String, Object> getCustomers() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            
            Map<String, Object> customer1 = new HashMap<>();
            customer1.put("customerId", 1);
            customer1.put("firstName", "John");
            customer1.put("lastName", "Doe");
            customer1.put("email", "john@example.com");
            
            Map<String, Object> customer2 = new HashMap<>();
            customer2.put("customerId", 2);
            customer2.put("firstName", "Jane");
            customer2.put("lastName", "Smith");
            customer2.put("email", "jane@example.com");
            
            response.put("data", Arrays.asList(customer1, customer2));
            return response;
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", "Failed to fetch customers: " + e.getMessage());
            return errorResponse;
        }
    }

    @GetMapping("/packages")
    public Map<String, Object> getPackages() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            
            Map<String, Object> package1 = new HashMap<>();
            package1.put("packageId", 1);
            package1.put("packageName", "Basic Package");
            package1.put("price", 99.99);
            package1.put("duration", "1 hour");
            
            Map<String, Object> package2 = new HashMap<>();
            package2.put("packageId", 2);
            package2.put("packageName", "Premium Package");
            package2.put("price", 199.99);
            package2.put("duration", "2 hours");
            
            Map<String, Object> package3 = new HashMap<>();
            package3.put("packageId", 3);
            package3.put("packageName", "Deluxe Package");
            package3.put("price", 299.99);
            package3.put("duration", "3 hours");
            
            Map<String, Object> package4 = new HashMap<>();
            package4.put("packageId", 4);
            package4.put("packageName", "VIP Package");
            package4.put("price", 499.99);
            package4.put("duration", "4 hours");
            
            Map<String, Object> package5 = new HashMap<>();
            package5.put("packageId", 5);
            package5.put("packageName", "Corporate Package");
            package5.put("price", 799.99);
            package5.put("duration", "6 hours");
            
            response.put("data", Arrays.asList(package1, package2, package3, package4, package5));
            return response;
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", "Failed to fetch packages: " + e.getMessage());
            return errorResponse;
        }
    }

    // Removed /bookings endpoint to avoid conflict with BookingController

    @GetMapping("/testimonials")
    public Map<String, Object> getTestimonials() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            
            Map<String, Object> testimonial1 = new HashMap<>();
            testimonial1.put("testimonialId", 1);
            testimonial1.put("content", "Amazing experience! The trainers are professional and the facilities are top-notch.");
            testimonial1.put("rating", 5);
            
            Map<String, Object> testimonial2 = new HashMap<>();
            testimonial2.put("testimonialId", 2);
            testimonial2.put("content", "Great workout session, really pushed my limits in a safe way.");
            testimonial2.put("rating", 4);
            
            Map<String, Object> testimonial3 = new HashMap<>();
            testimonial3.put("testimonialId", 3);
            testimonial3.put("content", "Excellent service and very knowledgeable staff.");
            testimonial3.put("rating", 5);
            
            Map<String, Object> testimonial4 = new HashMap<>();
            testimonial4.put("testimonialId", 4);
            testimonial4.put("content", "The premium package was worth every penny. Highly recommend!");
            testimonial4.put("rating", 5);
            
            Map<String, Object> testimonial5 = new HashMap<>();
            testimonial5.put("testimonialId", 5);
            testimonial5.put("content", "Corporate package exceeded our expectations. Perfect for team building.");
            testimonial5.put("rating", 4);
            
            response.put("data", Arrays.asList(testimonial1, testimonial2, testimonial3, testimonial4, testimonial5));
            return response;
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", "Failed to fetch testimonials: " + e.getMessage());
            return errorResponse;
        }
    }

    @GetMapping("/gallery")
    public Map<String, Object> getGallery() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            
            Map<String, Object> item1 = new HashMap<>();
            item1.put("id", 1);
            item1.put("title", "Training Session 1");
            item1.put("category", "training");
            item1.put("imageUrl", "https://via.placeholder.com/300x200");
            
            Map<String, Object> item2 = new HashMap<>();
            item2.put("id", 2);
            item2.put("title", "Training Session 2");
            item2.put("category", "training");
            item2.put("imageUrl", "https://via.placeholder.com/300x200");
            
            Map<String, Object> item3 = new HashMap<>();
            item3.put("id", 3);
            item3.put("title", "Facility Tour");
            item3.put("category", "facility");
            item3.put("imageUrl", "https://via.placeholder.com/300x200");
            
            response.put("data", Arrays.asList(item1, item2, item3));
            return response;
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", "Failed to fetch gallery: " + e.getMessage());
            return errorResponse;
        }
    }

    @GetMapping("/services")
    public Map<String, Object> getServices() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            
            Map<String, Object> service1 = new HashMap<>();
            service1.put("id", 1);
            service1.put("name", "Personal Training");
            service1.put("description", "One-on-one training sessions");
            
            Map<String, Object> service2 = new HashMap<>();
            service2.put("id", 2);
            service2.put("name", "Group Classes");
            service2.put("description", "Group fitness classes");
            
            Map<String, Object> service3 = new HashMap<>();
            service3.put("id", 3);
            service3.put("name", "Nutrition Coaching");
            service3.put("description", "Diet and nutrition guidance");
            
            response.put("data", Arrays.asList(service1, service2, service3));
            return response;
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", "Failed to fetch services: " + e.getMessage());
            return errorResponse;
        }
    }
}
