package com.mpt.mpt.controller;

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
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
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
    }
}
