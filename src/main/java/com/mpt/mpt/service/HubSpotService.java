package com.mpt.mpt.service;

import com.hubspot.api.client.ApiClient;
import com.hubspot.api.client.ApiException;
import com.hubspot.api.client.api.crm.contacts.ContactsApi;
import com.hubspot.api.client.api.crm.deals.DealsApi;
import com.hubspot.api.client.model.*;
import com.mpt.mpt.entity.Customer;
import com.mpt.mpt.entity.Booking;
import com.mpt.mpt.entity.Package;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HubSpotService {

    @Value("${hubspot.api.key:}")
    private String hubspotApiKey;

    private ApiClient apiClient;
    private ContactsApi contactsApi;
    private DealsApi dealsApi;

    public HubSpotService() {
        // Initialize HubSpot client
        this.apiClient = new ApiClient();
        this.contactsApi = new ContactsApi(apiClient);
        this.dealsApi = new DealsApi(apiClient);
    }

    /**
     * Sync customer to HubSpot as a contact
     */
    public String syncCustomerToHubSpot(Customer customer) {
        try {
            if (hubspotApiKey == null || hubspotApiKey.isEmpty()) {
                return "HubSpot API key not configured";
            }

            apiClient.setApiKey(hubspotApiKey);

            // Create contact properties
            Map<String, String> properties = new HashMap<>();
            properties.put("email", customer.getEmail());
            properties.put("firstname", customer.getFirstName());
            properties.put("lastname", customer.getLastName());
            properties.put("phone", customer.getPhone() != null ? customer.getPhone() : "");
            properties.put("address", customer.getAddress() != null ? customer.getAddress() : "");

            // Create contact
            SimplePublicObjectInput contactInput = new SimplePublicObjectInput();
            contactInput.setProperties(properties);

            SimplePublicObject contact = contactsApi.create(contactInput);
            return "Contact created with ID: " + contact.getId();

        } catch (ApiException e) {
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

            apiClient.setApiKey(hubspotApiKey);

            // Create deal properties
            Map<String, String> properties = new HashMap<>();
            properties.put("dealname", "Booking #" + booking.getBookingId() + " - " + booking.getPackage_().getPackageName());
            properties.put("amount", booking.getTotalAmount() != null ? booking.getTotalAmount().toString() : "0");
            properties.put("dealstage", mapBookingStatusToDealStage(booking.getStatus()));
            properties.put("closedate", booking.getBookingDate().toString());

            // Create deal
            SimplePublicObjectInput dealInput = new SimplePublicObjectInput();
            dealInput.setProperties(properties);

            SimplePublicObject deal = dealsApi.create(dealInput);
            return "Deal created with ID: " + deal.getId();

        } catch (ApiException e) {
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

            apiClient.setApiKey(hubspotApiKey);
            SimplePublicObject contact = contactsApi.getById(email, null, null, null, null, null);
            return "Contact found: " + contact.getId();

        } catch (ApiException e) {
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

            apiClient.setApiKey(hubspotApiKey);

            // Update contact properties
            Map<String, String> properties = new HashMap<>();
            properties.put("firstname", customer.getFirstName());
            properties.put("lastname", customer.getLastName());
            properties.put("phone", customer.getPhone() != null ? customer.getPhone() : "");
            properties.put("address", customer.getAddress() != null ? customer.getAddress() : "");

            SimplePublicObjectInput contactInput = new SimplePublicObjectInput();
            contactInput.setProperties(properties);

            // First, try to find the contact by email
            try {
                SimplePublicObject existingContact = contactsApi.getById(customer.getEmail(), null, null, null, null, null);
                SimplePublicObject updatedContact = contactsApi.update(existingContact.getId(), contactInput);
                return "Contact updated with ID: " + updatedContact.getId();
            } catch (ApiException e) {
                // Contact doesn't exist, create new one
                return syncCustomerToHubSpot(customer);
            }

        } catch (ApiException e) {
            return "Error updating HubSpot contact: " + e.getMessage();
        }
    }
}
