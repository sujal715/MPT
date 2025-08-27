package com.mpt.mpt;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/services")
    public Map<String, Object> getServices() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", "Services data will be available soon");
        return response;
    }

    @GetMapping("/packages")
    public Map<String, Object> getPackages() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", "Packages data will be available soon");
        return response;
    }

    @GetMapping("/testimonials")
    public Map<String, Object> getTestimonials() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", "Testimonials data will be available soon");
        return response;
    }

    @GetMapping("/gallery")
    public Map<String, Object> getGallery() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", "Gallery data will be available soon");
        return response;
    }
}
