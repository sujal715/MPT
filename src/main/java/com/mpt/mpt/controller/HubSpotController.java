package com.mpt.mpt.controller;

import com.mpt.mpt.service.HubSpotService;
import com.mpt.mpt.entity.Customer;
import com.mpt.mpt.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/hubspot")
public class HubSpotController {

    @Autowired
    private HubSpotService hubSpotService;

    @GetMapping("/test")
    public Map<String, String> testHubSpotConnection() {
        Map<String, String> response = new HashMap<>();
        String result = hubSpotService.testConnection();
        response.put("status", result);
        response.put("message", "HubSpot integration test completed");
        return response;
    }

    @PostMapping("/sync-customer")
    public Map<String, String> syncCustomer(@RequestBody Customer customer) {
        Map<String, String> response = new HashMap<>();
        String result = hubSpotService.syncCustomerToHubSpot(customer);
        response.put("result", result);
        return response;
    }

    @PostMapping("/sync-booking")
    public Map<String, String> syncBooking(@RequestBody Booking booking) {
        Map<String, String> response = new HashMap<>();
        String result = hubSpotService.syncBookingToHubSpot(booking);
        response.put("result", result);
        return response;
    }

    @GetMapping("/contact/{email}")
    public Map<String, String> getContact(@PathVariable String email) {
        Map<String, String> response = new HashMap<>();
        String result = hubSpotService.getContactByEmail(email);
        response.put("result", result);
        return response;
    }

    @PutMapping("/update-contact")
    public Map<String, String> updateContact(@RequestBody Customer customer) {
        Map<String, String> response = new HashMap<>();
        String result = hubSpotService.updateContactInHubSpot(customer);
        response.put("result", result);
        return response;
    }
}
