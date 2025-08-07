package com.mpt.mpt.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mpt.mpt.entity.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package, Integer> {
    
    // Find package by name
    Optional<Package> findByPackageName(String packageName);
    
    // Find packages by price range
    List<Package> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    
    // Find active packages
    List<Package> findByIsActiveTrue();
    
    // Find packages by duration
    List<Package> findByDurationContaining(String duration);
    
    // Find packages with price less than specified amount
    List<Package> findByPriceLessThan(BigDecimal price);
    
    // Find packages with price greater than specified amount
    List<Package> findByPriceGreaterThan(BigDecimal price);
    
    // Find packages by name containing (case insensitive)
    List<Package> findByPackageNameContainingIgnoreCase(String packageName);
    
    // Find packages by description containing (case insensitive)
    List<Package> findByDescriptionContainingIgnoreCase(String description);
    
    // Count packages by duration
    @Query("SELECT p.duration, COUNT(p) FROM Package p GROUP BY p.duration")
    List<Object[]> countPackagesByDuration();
    
    // Find average price by duration
    @Query("SELECT p.duration, AVG(p.price) FROM Package p GROUP BY p.duration")
    List<Object[]> getAveragePriceByDuration();
    
    // Find most expensive package
    @Query("SELECT p FROM Package p WHERE p.price = (SELECT MAX(price) FROM Package)")
    Optional<Package> findMostExpensivePackage();
    
    // Find packages created in a specific date range
    @Query("SELECT p FROM Package p WHERE p.createdAt BETWEEN :startDate AND :endDate")
    List<Package> findPackagesCreatedBetween(@Param("startDate") String startDate, 
                                           @Param("endDate") String endDate);
} 