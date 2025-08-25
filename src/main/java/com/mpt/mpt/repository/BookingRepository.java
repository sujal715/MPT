package com.mpt.mpt.repository;

<<<<<<< HEAD
import com.mpt.mpt.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    List<Booking> findByCustomerCustomerId(Long customerId);
    
    List<Booking> findByPackageItemPackageId(Long packageId);
    
    List<Booking> findByStatus(String status);
    
    List<Booking> findByBookingDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    @Query("SELECT b FROM Booking b WHERE b.customer.customerId = ?1 ORDER BY b.bookingDate DESC")
    List<Booking> findBookingsByCustomerIdOrderByDate(Long customerId);
    
    @Query("SELECT b FROM Booking b WHERE b.packageItem.packageId = ?1 ORDER BY b.bookingDate DESC")
    List<Booking> findBookingsByPackageIdOrderByDate(Long packageId);
    
    @Query("SELECT b FROM Booking b WHERE b.status = ?1 ORDER BY b.bookingDate ASC")
    List<Booking> findBookingsByStatusOrderByDate(String status);
}
=======
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mpt.mpt.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
    // Find bookings by customer
    List<Booking> findByCustomerCustomerId(Integer customerId);
    
    // Find bookings by package
    @Query("SELECT b FROM Booking b WHERE b.packageItem.packageId = :packageId")
    List<Booking> findByPackageId(@Param("packageId") Integer packageId);
    
    // Find bookings by status
    List<Booking> findByStatus(String status);
    
    // Find bookings by booking date
    List<Booking> findByBookingDate(LocalDate bookingDate);
    
    // Find bookings by date range
    List<Booking> findByBookingDateBetween(LocalDate startDate, LocalDate endDate);
    
    // Find bookings by total amount
    List<Booking> findByTotalAmount(BigDecimal totalAmount);
    
    // Find bookings by amount range
    List<Booking> findByTotalAmountBetween(BigDecimal minAmount, BigDecimal maxAmount);
    
    // Find bookings created in a specific date range
    @Query("SELECT b FROM Booking b WHERE b.createdAt BETWEEN :startDate AND :endDate")
    List<Booking> findBookingsCreatedBetween(@Param("startDate") LocalDateTime startDate, 
                                           @Param("endDate") LocalDateTime endDate);
    
    // Count bookings by status
    @Query("SELECT b.status, COUNT(b) FROM Booking b GROUP BY b.status")
    List<Object[]> countBookingsByStatus();
    
    // Find total revenue by date range
    @Query("SELECT SUM(b.totalAmount) FROM Booking b WHERE b.bookingDate BETWEEN :startDate AND :endDate AND b.status = 'CONFIRMED'")
    Double getTotalRevenueBetween(@Param("startDate") LocalDate startDate, 
                                 @Param("endDate") LocalDate endDate);
    
    // Find most popular packages
    @Query("SELECT b.packageItem.packageId, b.packageItem.packageName, COUNT(b) FROM Booking b GROUP BY b.packageItem.packageId, b.packageItem.packageName ORDER BY COUNT(b) DESC")
    List<Object[]> findMostPopularPackages();
    
    // Find bookings with payments
    @Query("SELECT b FROM Booking b JOIN b.payments p")
    List<Booking> findBookingsWithPayments();
    
    // Find bookings without payments
    @Query("SELECT b FROM Booking b WHERE b.payments IS EMPTY")
    List<Booking> findBookingsWithoutPayments();
} 
>>>>>>> fdcf6fbd346bf74cc21f14886fa500b7f9407bbd
