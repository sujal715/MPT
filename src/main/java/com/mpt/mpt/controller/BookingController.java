package com.mpt.mpt.controller;

<<<<<<< HEAD
import com.mpt.mpt.entity.Booking;
import com.mpt.mpt.entity.Customer;
import com.mpt.mpt.entity.Package;
import com.mpt.mpt.repository.BookingRepository;
import com.mpt.mpt.repository.CustomerRepository;
import com.mpt.mpt.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mpt.mpt.entity.Booking;
import com.mpt.mpt.repository.BookingRepository;
import com.mpt.mpt.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
>>>>>>> fdcf6fbd346bf74cc21f14886fa500b7f9407bbd
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
<<<<<<< HEAD
    private CustomerRepository customerRepository;

    @Autowired
    private PackageRepository packageRepository;

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return ResponseEntity.ok(bookings);
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new booking
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        // Set customer and package if IDs are provided
        if (booking.getCustomer() != null && booking.getCustomer().getCustomerId() != null) {
            Optional<Customer> customer = customerRepository.findById(booking.getCustomer().getCustomerId());
            if (customer.isPresent()) {
                booking.setCustomer(customer.get());
            }
        }
        
        if (booking.getPackageItem() != null && booking.getPackageItem().getPackageId() != null) {
            Optional<Package> packageItem = packageRepository.findById(booking.getPackageItem().getPackageId());
            if (packageItem.isPresent()) {
                booking.setPackageItem(packageItem.get());
            }
        }
        
        booking.setCreatedAt(LocalDateTime.now());
        booking.setUpdatedAt(LocalDateTime.now());
        Booking savedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(savedBooking);
    }

    // Update booking
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setBookingDate(bookingDetails.getBookingDate());
            booking.setStartTime(bookingDetails.getStartTime());
            booking.setEndTime(bookingDetails.getEndTime());
            booking.setStatus(bookingDetails.getStatus());
            booking.setTotalAmount(bookingDetails.getTotalAmount());
            booking.setNotes(bookingDetails.getNotes());
            booking.setUpdatedAt(LocalDateTime.now());
            
            Booking updatedBooking = bookingRepository.save(booking);
            return ResponseEntity.ok(updatedBooking);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Get bookings by customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getBookingsByCustomerId(@PathVariable Long customerId) {
        List<Booking> bookings = bookingRepository.findByCustomerCustomerId(customerId);
        return ResponseEntity.ok(bookings);
    }

    // Get bookings by package ID
    @GetMapping("/package/{packageId}")
    public ResponseEntity<List<Booking>> getBookingsByPackageId(@PathVariable Long packageId) {
        List<Booking> bookings = bookingRepository.findByPackageItemPackageId(packageId);
        return ResponseEntity.ok(bookings);
    }

    // Get bookings by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Booking>> getBookingsByStatus(@PathVariable String status) {
        List<Booking> bookings = bookingRepository.findByStatus(status);
        return ResponseEntity.ok(bookings);
    }

    // Get bookings by date range
    @GetMapping("/date-range")
    public ResponseEntity<List<Booking>> getBookingsByDateRange(
            @RequestParam String startDate, 
            @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        List<Booking> bookings = bookingRepository.findByBookingDateBetween(start, end);
        return ResponseEntity.ok(bookings);
=======
    private BookingService bookingService;

    /**
     * Get all bookings
     */
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        try {
            List<Booking> bookings = bookingRepository.findAll();
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get booking by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id) {
        try {
            Optional<Booking> booking = bookingRepository.findById(id);
            return booking.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Create a new booking
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createBooking(@RequestBody Booking booking) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Validate required fields
            if (booking.getBookingDate() == null || booking.getBookingTime() == null) {
                response.put("error", "Booking date and time are required");
                return ResponseEntity.badRequest().body(response);
            }

            // Check if time slot is available
            if (!bookingService.isTimeSlotAvailable(booking.getBookingDate(), booking.getBookingTime())) {
                response.put("error", "Time slot is not available");
                return ResponseEntity.badRequest().body(response);
            }

            // Set default status if not provided
            if (booking.getStatus() == null) {
                booking.setStatus(Booking.BookingStatus.PENDING);
            }

            Booking savedBooking = bookingRepository.save(booking);
            response.put("success", true);
            response.put("booking", savedBooking);
            response.put("message", "Booking created successfully");
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("error", "Failed to create booking: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Update an existing booking
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateBooking(@PathVariable Integer id, @RequestBody Booking bookingDetails) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Booking> optionalBooking = bookingRepository.findById(id);
            
            if (!optionalBooking.isPresent()) {
                response.put("error", "Booking not found with id: " + id);
                return ResponseEntity.notFound().build();
            }

            Booking booking = optionalBooking.get();
            
            // Update fields
            if (bookingDetails.getBookingDate() != null) {
                booking.setBookingDate(bookingDetails.getBookingDate());
            }
            if (bookingDetails.getBookingTime() != null) {
                booking.setBookingTime(bookingDetails.getBookingTime());
            }
            if (bookingDetails.getStatus() != null) {
                booking.setStatus(bookingDetails.getStatus());
            }
            if (bookingDetails.getNotes() != null) {
                booking.setNotes(bookingDetails.getNotes());
            }
            if (bookingDetails.getTotalAmount() != null) {
                booking.setTotalAmount(bookingDetails.getTotalAmount());
            }

            Booking updatedBooking = bookingRepository.save(booking);
            response.put("success", true);
            response.put("booking", updatedBooking);
            response.put("message", "Booking updated successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Failed to update booking: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Delete a booking
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteBooking(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Booking> booking = bookingRepository.findById(id);
            
            if (!booking.isPresent()) {
                response.put("error", "Booking not found with id: " + id);
                return ResponseEntity.notFound().build();
            }

            bookingRepository.deleteById(id);
            response.put("success", true);
            response.put("message", "Booking deleted successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Failed to delete booking: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Get bookings by customer ID
     */
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Booking>> getBookingsByCustomerId(@PathVariable Integer customerId) {
        try {
            // Note: You'll need to add this method to BookingRepository
            // List<Booking> bookings = bookingRepository.findByCustomerId(customerId);
            List<Booking> bookings = bookingRepository.findAll().stream()
                .filter(booking -> booking.getCustomer() != null && booking.getCustomer().getCustomerId().equals(customerId))
                .toList();
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get booking statistics
     */
    @GetMapping("/stats")
    public ResponseEntity<BookingService.BookingStatistics> getBookingStatistics() {
        try {
            BookingService.BookingStatistics stats = bookingService.getBookingStatistics();
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Update booking status only
     */
    @PatchMapping("/{id}/status")
    public ResponseEntity<Map<String, Object>> updateBookingStatus(@PathVariable Integer id, @RequestParam String status) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Booking> optionalBooking = bookingRepository.findById(id);
            
            if (!optionalBooking.isPresent()) {
                response.put("error", "Booking not found with id: " + id);
                return ResponseEntity.notFound().build();
            }

            Booking booking = optionalBooking.get();
            Booking.BookingStatus bookingStatus = Booking.BookingStatus.valueOf(status.toUpperCase());
            bookingService.updateBookingStatus(booking, bookingStatus);
            
            Booking updatedBooking = bookingRepository.save(booking);
            response.put("success", true);
            response.put("booking", updatedBooking);
            response.put("message", "Booking status updated successfully");
            
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("error", "Invalid status: " + status);
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            response.put("error", "Failed to update booking status: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
>>>>>>> fdcf6fbd346bf74cc21f14886fa500b7f9407bbd
    }
}
