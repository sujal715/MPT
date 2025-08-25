package com.mpt.mpt.controller;

<<<<<<< HEAD
import com.mpt.mpt.entity.Customer;
import com.mpt.mpt.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
=======
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mpt.mpt.entity.Customer;
import com.mpt.mpt.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
>>>>>>> fdcf6fbd346bf74cc21f14886fa500b7f9407bbd
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

<<<<<<< HEAD
    // Get all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    // Update customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setFirstName(customerDetails.getFirstName());
            customer.setLastName(customerDetails.getLastName());
            customer.setEmail(customerDetails.getEmail());
            customer.setPhone(customerDetails.getPhone());
            customer.setDateOfBirth(customerDetails.getDateOfBirth());
            customer.setAddress(customerDetails.getAddress());
            customer.setUpdatedAt(LocalDateTime.now());
            
            Customer updatedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok(updatedCustomer);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Search customers by name
    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomers(@RequestParam String name) {
        List<Customer> customers = customerRepository.searchCustomersByName(name);
        return ResponseEntity.ok(customers);
    }

    // Get customer by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        return customer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
=======
    /**
     * Get all customers
     */
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerRepository.findAll();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get customer by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            return customer.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get customer by email
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        try {
            // Note: You'll need to add this method to CustomerRepository
            // Optional<Customer> customer = customerRepository.findByEmail(email);
            Optional<Customer> customer = customerRepository.findAll().stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email))
                .findFirst();
            return customer.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Search customers by name
     */
    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomers(@RequestParam String name) {
        try {
            // Note: You'll need to add this method to CustomerRepository
            // List<Customer> customers = customerRepository.findByNameContainingIgnoreCase(name);
            List<Customer> customers = customerRepository.findAll().stream()
                .filter(c -> (c.getFirstName() + " " + c.getLastName()).toLowerCase().contains(name.toLowerCase()))
                .toList();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Create a new customer
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createCustomer(@RequestBody Customer customer) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Validate required fields
            if ((customer.getFirstName() == null || customer.getFirstName().trim().isEmpty()) &&
                (customer.getLastName() == null || customer.getLastName().trim().isEmpty())) {
                response.put("error", "Customer first name or last name is required");
                return ResponseEntity.badRequest().body(response);
            }
            
            if (customer.getEmail() == null || customer.getEmail().trim().isEmpty()) {
                response.put("error", "Customer email is required");
                return ResponseEntity.badRequest().body(response);
            }

            // Check if email already exists
            boolean emailExists = customerRepository.findAll().stream()
                .anyMatch(c -> c.getEmail().equalsIgnoreCase(customer.getEmail()));
            
            if (emailExists) {
                response.put("error", "Customer with this email already exists");
                return ResponseEntity.badRequest().body(response);
            }

            Customer savedCustomer = customerRepository.save(customer);
            response.put("success", true);
            response.put("customer", savedCustomer);
            response.put("message", "Customer created successfully");
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("error", "Failed to create customer: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Update an existing customer
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCustomer(@PathVariable Integer id, @RequestBody Customer customerDetails) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Customer> optionalCustomer = customerRepository.findById(id);
            
            if (!optionalCustomer.isPresent()) {
                response.put("error", "Customer not found with id: " + id);
                return ResponseEntity.notFound().build();
            }

            Customer customer = optionalCustomer.get();
            
            // Update fields
            if (customerDetails.getFirstName() != null) {
                customer.setFirstName(customerDetails.getFirstName());
            }
            if (customerDetails.getLastName() != null) {
                customer.setLastName(customerDetails.getLastName());
            }
            if (customerDetails.getEmail() != null) {
                // Check if new email already exists (excluding current customer)
                boolean emailExists = customerRepository.findAll().stream()
                    .anyMatch(c -> !c.getCustomerId().equals(id) && c.getEmail().equalsIgnoreCase(customerDetails.getEmail()));
                
                if (emailExists) {
                    response.put("error", "Customer with this email already exists");
                    return ResponseEntity.badRequest().body(response);
                }
                customer.setEmail(customerDetails.getEmail());
            }
            if (customerDetails.getPhone() != null) {
                customer.setPhone(customerDetails.getPhone());
            }
            if (customerDetails.getAddress() != null) {
                customer.setAddress(customerDetails.getAddress());
            }

            Customer updatedCustomer = customerRepository.save(customer);
            response.put("success", true);
            response.put("customer", updatedCustomer);
            response.put("message", "Customer updated successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Failed to update customer: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Delete a customer
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCustomer(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            
            if (!customer.isPresent()) {
                response.put("error", "Customer not found with id: " + id);
                return ResponseEntity.notFound().build();
            }

            customerRepository.deleteById(id);
            response.put("success", true);
            response.put("message", "Customer deleted successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Failed to delete customer: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Get customer statistics
     */
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getCustomerStatistics() {
        try {
            List<Customer> allCustomers = customerRepository.findAll();
            Map<String, Object> stats = new HashMap<>();
            
            stats.put("totalCustomers", allCustomers.size());
            stats.put("customersWithPhone", allCustomers.stream()
                .mapToLong(c -> c.getPhone() != null && !c.getPhone().trim().isEmpty() ? 1 : 0)
                .sum());
            stats.put("customersWithAddress", allCustomers.stream()
                .mapToLong(c -> c.getAddress() != null && !c.getAddress().trim().isEmpty() ? 1 : 0)
                .sum());
            
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Validate customer email format
     */
    @PostMapping("/validate-email")
    public ResponseEntity<Map<String, Object>> validateEmail(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            String email = request.get("email");
            
            if (email == null || email.trim().isEmpty()) {
                response.put("valid", false);
                response.put("message", "Email is required");
                return ResponseEntity.ok(response);
            }

            // Basic email validation
            boolean isValidFormat = email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
            boolean emailExists = customerRepository.findAll().stream()
                .anyMatch(c -> c.getEmail().equalsIgnoreCase(email));

            response.put("valid", isValidFormat && !emailExists);
            response.put("formatValid", isValidFormat);
            response.put("emailExists", emailExists);
            
            if (!isValidFormat) {
                response.put("message", "Invalid email format");
            } else if (emailExists) {
                response.put("message", "Email already exists");
            } else {
                response.put("message", "Email is valid");
            }
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Failed to validate email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
>>>>>>> fdcf6fbd346bf74cc21f14886fa500b7f9407bbd
    }
}
