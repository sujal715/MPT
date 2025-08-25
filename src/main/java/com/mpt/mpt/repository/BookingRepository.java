package com.mpt.mpt.repository;

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
