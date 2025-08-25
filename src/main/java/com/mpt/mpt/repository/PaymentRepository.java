package com.mpt.mpt.repository;

import com.mpt.mpt.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
    List<Payment> findByBookingBookingId(Long bookingId);
    
    List<Payment> findByStatus(String status);
    
    List<Payment> findByPaymentMethod(String paymentMethod);
    
    List<Payment> findByPaymentDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    @Query("SELECT p FROM Payment p WHERE p.booking.bookingId = ?1 ORDER BY p.paymentDate DESC")
    List<Payment> findPaymentsByBookingIdOrderByDate(Long bookingId);
    
    @Query("SELECT p FROM Payment p WHERE p.status = ?1 ORDER BY p.paymentDate DESC")
    List<Payment> findPaymentsByStatusOrderByDate(String status);
}
