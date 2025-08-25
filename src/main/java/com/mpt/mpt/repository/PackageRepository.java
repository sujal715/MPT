package com.mpt.mpt.repository;

import com.mpt.mpt.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
    
    List<Package> findByIsActiveTrue();
    
    List<Package> findByPackageNameContainingIgnoreCase(String packageName);
    
    @Query("SELECT p FROM Package p WHERE p.isActive = true ORDER BY p.price ASC")
    List<Package> findActivePackagesOrderByPrice();
    
    @Query("SELECT p FROM Package p WHERE p.price BETWEEN ?1 AND ?2 AND p.isActive = true")
    List<Package> findPackagesByPriceRange(Double minPrice, Double maxPrice);
}
