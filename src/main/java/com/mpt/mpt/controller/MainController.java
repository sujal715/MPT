package com.mpt.mpt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/test")
    public Map<String, Object> test() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Backend is working!");
        response.put("status", "success");
        return response;
    }

    @PostMapping("/test-post")
    public Map<String, Object> testPost() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "POST endpoint working!");
        response.put("status", "success");
        return response;
    }

    @GetMapping("/customers")
    public Map<String, Object> getCustomers() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", new Object[]{
            Map.of("customerId", 1, "firstName", "John", "lastName", "Doe", "email", "john@example.com"),
            Map.of("customerId", 2, "firstName", "Jane", "lastName", "Smith", "email", "jane@example.com")
        });
        return response;
    }

    @GetMapping("/packages")
    public Map<String, Object> getPackages() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", new Object[]{
            Map.of("packageId", 1, "packageName", "Basic Package", "price", 99.99, "duration", "1 hour"),
            Map.of("packageId", 2, "packageName", "Premium Package", "price", 199.99, "duration", "2 hours"),
            Map.of("packageId", 3, "packageName", "Deluxe Package", "price", 299.99, "duration", "3 hours"),
            Map.of("packageId", 4, "packageName", "VIP Package", "price", 499.99, "duration", "4 hours"),
            Map.of("packageId", 5, "packageName", "Corporate Package", "price", 799.99, "duration", "6 hours")
        });
        return response;
    }

    @GetMapping("/bookings")
    public Map<String, Object> getBookings() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", new Object[]{
            Map.of("bookingId", 1, "status", "CONFIRMED", "totalAmount", 99.99),
            Map.of("bookingId", 2, "status", "PENDING", "totalAmount", 199.99)
        });
        return response;
    }

    @PostMapping("/bookings/create")
    public Map<String, Object> createBooking(@RequestBody Map<String, Object> bookingRequest) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // Extract booking details
            String customerName = (String) bookingRequest.get("customerName");
            String customerEmail = (String) bookingRequest.get("customerEmail");
            String customerPhone = (String) bookingRequest.get("customerPhone");
            Integer packageId = (Integer) bookingRequest.get("packageId");
            String selectedDate = (String) bookingRequest.get("selectedDate");
            String selectedTime = (String) bookingRequest.get("selectedTime");
            String specialRequests = (String) bookingRequest.get("specialRequests");
            
            // Validate required fields
            if (customerName == null || customerEmail == null || packageId == null || 
                selectedDate == null || selectedTime == null) {
                response.put("success", false);
                response.put("message", "Missing required fields");
                return response;
            }
            
            // Generate a booking ID (in a real app, this would be from database)
            int bookingId = (int) (Math.random() * 10000) + 1000;
            
            // Create the booking response
            Map<String, Object> booking = new HashMap<>();
            booking.put("bookingId", bookingId);
            booking.put("customerName", customerName);
            booking.put("customerEmail", customerEmail);
            booking.put("customerPhone", customerPhone);
            booking.put("packageId", packageId);
            booking.put("selectedDate", selectedDate);
            booking.put("selectedTime", selectedTime);
            booking.put("specialRequests", specialRequests);
            booking.put("status", "CONFIRMED");
            booking.put("totalAmount", getPackagePrice(packageId));
            booking.put("createdAt", java.time.LocalDateTime.now().toString());
            
            response.put("success", true);
            response.put("message", "Booking created successfully!");
            response.put("data", booking);
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error creating booking: " + e.getMessage());
        }
        
        return response;
    }

    @GetMapping("/testimonials")
    public Map<String, Object> getTestimonials() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", new Object[]{
            Map.of("testimonialId", 1, "content", "Amazing experience! The trainers are professional and the facilities are top-notch.", "rating", 5),
            Map.of("testimonialId", 2, "content", "Great workout session, really pushed my limits in a safe way.", "rating", 4),
            Map.of("testimonialId", 3, "content", "Excellent service and very knowledgeable staff.", "rating", 5),
            Map.of("testimonialId", 4, "content", "The premium package was worth every penny. Highly recommend!", "rating", 5),
            Map.of("testimonialId", 5, "content", "Corporate package exceeded our expectations. Perfect for team building.", "rating", 4)
        });
        return response;
    }

    @GetMapping("/gallery")
    public Map<String, Object> getGallery() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", new Object[]{
            Map.of("id", 1, "title", "Training Session 1", "category", "training", "imageUrl", "https://via.placeholder.com/300x200"),
            Map.of("id", 2, "title", "Training Session 2", "category", "training", "imageUrl", "https://via.placeholder.com/300x200"),
            Map.of("id", 3, "title", "Facility Tour", "category", "facility", "imageUrl", "https://via.placeholder.com/300x200")
        });
        return response;
    }

    @GetMapping("/services")
    public Map<String, Object> getServices() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", new Object[]{
            Map.of("id", 1, "name", "Personal Training", "description", "One-on-one training sessions"),
            Map.of("id", 2, "name", "Group Classes", "description", "Group fitness classes"),
            Map.of("id", 3, "name", "Nutrition Coaching", "description", "Diet and nutrition guidance")
        });
        return response;
    }
    
    private Double getPackagePrice(Integer packageId) {
        switch (packageId) {
            case 1: return 99.99;  // Basic Package
            case 2: return 199.99; // Premium Package
            case 3: return 299.99; // Deluxe Package
            case 4: return 499.99; // VIP Package
            case 5: return 799.99; // Corporate Package
            default: return 99.99;
        }
    }
}
