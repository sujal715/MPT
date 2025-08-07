package com.mpt.mpt.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.mpt.mpt.entity.Payment.PaymentMethod;
import com.mpt.mpt.entity.Payment.PaymentStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mpt.mpt.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
    // Find payments by booking
    List<Payment> findByBookingBookingId(Integer bookingId);
    
    // Find payments by payment method
    List<Payment> findByPaymentMethod(PaymentMethod paymentMethod);
    
    // Find payments by status
    List<Payment> findByPaymentStatus(PaymentStatus paymentStatus);
    
    // Find payments by amount
    List<Payment> findByAmount(BigDecimal amount);
    
    // Find payments by amount range
    List<Payment> findByAmountBetween(BigDecimal minAmount, BigDecimal maxAmount);
    
    // Find payments by payment date
    List<Payment> findByPaymentDate(LocalDate paymentDate);
    
    // Find payments by payment date range
    List<Payment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);
    
    // Find payments by status (custom queries for specific statuses)
    @Query("SELECT p FROM Payment p WHERE p.paymentStatus = 'COMPLETED'")
    List<Payment> findCompletedPayments();
    
    @Query("SELECT p FROM Payment p WHERE p.paymentStatus = 'FAILED'")
    List<Payment> findFailedPayments();
    
    @Query("SELECT p FROM Payment p WHERE p.paymentStatus = 'PENDING'")
    List<Payment> findPendingPayments();
    
    // Find payments by transaction reference
    Optional<Payment> findByTransactionReference(String transactionReference);
    
    // Find payments created in a specific date range
    @Query("SELECT p FROM Payment p WHERE p.createdAt BETWEEN :startDate AND :endDate")
    List<Payment> findPaymentsCreatedBetween(@Param("startDate") LocalDateTime startDate, 
                                           @Param("endDate") LocalDateTime endDate);
    
    // Count payments by status
    @Query("SELECT p.paymentStatus, COUNT(p) FROM Payment p GROUP BY p.paymentStatus")
    List<Object[]> countPaymentsByStatus();
    
    // Count payments by payment method
    @Query("SELECT p.paymentMethod, COUNT(p) FROM Payment p GROUP BY p.paymentMethod")
    List<Object[]> countPaymentsByMethod();
    
    // Find total revenue by date range
    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.paymentDate BETWEEN :startDate AND :endDate AND p.paymentStatus = 'COMPLETED'")
    BigDecimal getTotalRevenueBetween(@Param("startDate") LocalDate startDate, 
                                     @Param("endDate") LocalDate endDate);
    
    // Find average payment amount by payment method
    @Query("SELECT p.paymentMethod, AVG(p.amount) FROM Payment p GROUP BY p.paymentMethod")
    List<Object[]> getAverageAmountByPaymentMethod();
    
    // Find payments with specific amount threshold
    @Query("SELECT p FROM Payment p WHERE p.amount > :threshold")
    List<Payment> findPaymentsAboveThreshold(@Param("threshold") BigDecimal threshold);
} 