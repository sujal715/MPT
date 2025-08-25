package com.mpt.mpt.service;

import com.mpt.mpt.entity.Customer;
import com.mpt.mpt.entity.Booking;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class HubSpotService {

    @Value("${hubspot.api.key:}")
    private String hubspotApiKey;

    @Value("${hubspot.portal.id:}")
    private String hubspotPortalId;

    private final WebClient webClient;

    public HubSpotService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.hubapi.com")
                .build();
    }

    /**
     * Sync customer to HubSpot as a contact
     */
    public String syncCustomerToHubSpot(Customer customer) {
        try {
            if (hubspotApiKey == null || hubspotApiKey.isEmpty()) {
                return "HubSpot API key not configured";
            }

            // Create contact properties
            Map<String, String> properties = new HashMap<>();
            properties.put("email", customer.getEmail());
            properties.put("firstname", customer.getFirstName());
            properties.put("lastname", customer.getLastName());
            properties.put("phone", customer.getPhone() != null ? customer.getPhone() : "");
            properties.put("address", customer.getAddress() != null ? customer.getAddress() : "");

            // Create contact request body
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("properties", properties);

            String response = webClient.post()
                    .uri("/crm/v3/objects/contacts")
                    .header("Authorization", "Bearer " + hubspotApiKey)
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return "Contact created successfully: " + response;

        } catch (Exception e) {
            return "Error creating HubSpot contact: " + e.getMessage();
        }
    }

    /**
     * Sync booking to HubSpot as a deal
     */
    public String syncBookingToHubSpot(Booking booking) {
        try {
            if (hubspotApiKey == null || hubspotApiKey.isEmpty()) {
                return "HubSpot API key not configured";
            }

            // Create deal properties
            Map<String, String> properties = new HashMap<>();
            properties.put("dealname", "Booking #" + booking.getBookingId() + " - " + booking.getPackageItem().getPackageName());
            properties.put("amount", booking.getTotalAmount() != null ? booking.getTotalAmount().toString() : "0");
            properties.put("dealstage", mapBookingStatusToDealStage(booking.getStatus()));
            properties.put("closedate", booking.getBookingDate().toString());

            // Create deal request body
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("properties", properties);

            String response = webClient.post()
                    .uri("/crm/v3/objects/deals")
                    .header("Authorization", "Bearer " + hubspotApiKey)
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return "Deal created successfully: " + response;

        } catch (Exception e) {
            return "Error creating HubSpot deal: " + e.getMessage();
        }
    }

    /**
     * Map booking status to HubSpot deal stage
     */
    private String mapBookingStatusToDealStage(Booking.BookingStatus status) {
        switch (status) {
            case PENDING:
                return "appointmentscheduled";
            case CONFIRMED:
                return "qualifiedtobuy";
            case COMPLETED:
                return "closedwon";
            case CANCELLED:
                return "closedlost";
            default:
                return "appointmentscheduled";
        }
    }

    /**
     * Get HubSpot contact by email
     */
    public String getContactByEmail(String email) {
        try {
            if (hubspotApiKey == null || hubspotApiKey.isEmpty()) {
                return "HubSpot API key not configured";
            }

            String response = webClient.get()
                    .uri("/crm/v3/objects/contacts/" + email + "?idProperty=email")
                    .header("Authorization", "Bearer " + hubspotApiKey)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return "Contact found: " + response;

        } catch (Exception e) {
            return "Contact not found or error: " + e.getMessage();
        }
    }

    /**
     * Update contact in HubSpot
     */
    public String updateContactInHubSpot(Customer customer) {
        try {
            if (hubspotApiKey == null || hubspotApiKey.isEmpty()) {
                return "HubSpot API key not configured";
            }

            // Update contact properties
            Map<String, String> properties = new HashMap<>();
            properties.put("firstname", customer.getFirstName());
            properties.put("lastname", customer.getLastName());
            properties.put("phone", customer.getPhone() != null ? customer.getPhone() : "");
            properties.put("address", customer.getAddress() != null ? customer.getAddress() : "");

            // Create update request body
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("properties", properties);

            String response = webClient.patch()
                    .uri("/crm/v3/objects/contacts/" + customer.getEmail() + "?idProperty=email")
                    .header("Authorization", "Bearer " + hubspotApiKey)
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return "Contact updated successfully: " + response;

        } catch (Exception e) {
            return "Error updating HubSpot contact: " + e.getMessage();
        }
    }

    /**
     * Test HubSpot connection
     */
    public String testConnection() {
        try {
            if (hubspotApiKey == null || hubspotApiKey.isEmpty()) {
                return "HubSpot API key not configured";
            }

            String response = webClient.get()
                    .uri("/crm/v3/objects/contacts?limit=1")
                    .header("Authorization", "Bearer " + hubspotApiKey)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return "Connection successful: " + response;

        } catch (Exception e) {
            return "Connection failed: " + e.getMessage();
        }
    }
}
