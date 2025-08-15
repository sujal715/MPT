package com.mpt.mpt.controller;

import java.math.BigDecimal;
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

import com.mpt.mpt.entity.Package;
import com.mpt.mpt.repository.PackageRepository;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
public class PackageController {

    @Autowired
    private PackageRepository packageRepository;

    /**
     * Get all packages
     */
    @GetMapping
    public ResponseEntity<List<Package>> getAllPackages() {
        try {
            List<Package> packages = packageRepository.findAll();
            return ResponseEntity.ok(packages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get package by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Package> getPackageById(@PathVariable Integer id) {
        try {
            Optional<Package> package_ = packageRepository.findById(id);
            return package_.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get packages by price range
     */
    @GetMapping("/price-range")
    public ResponseEntity<List<Package>> getPackagesByPriceRange(
            @RequestParam BigDecimal minPrice, 
            @RequestParam BigDecimal maxPrice) {
        try {
            // Note: You'll need to add this method to PackageRepository
            // List<Package> packages = packageRepository.findByPriceBetween(minPrice, maxPrice);
            List<Package> packages = packageRepository.findAll().stream()
                .filter(p -> p.getPrice().compareTo(minPrice) >= 0 && p.getPrice().compareTo(maxPrice) <= 0)
                .toList();
            return ResponseEntity.ok(packages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Search packages by name or description
     */
    @GetMapping("/search")
    public ResponseEntity<List<Package>> searchPackages(@RequestParam String query) {
        try {
            // Note: You'll need to add this method to PackageRepository
            // List<Package> packages = packageRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
            List<Package> packages = packageRepository.findAll().stream()
                .filter(p -> (p.getPackageName() != null && p.getPackageName().toLowerCase().contains(query.toLowerCase())) ||
                           (p.getDescription() != null && p.getDescription().toLowerCase().contains(query.toLowerCase())))
                .toList();
            return ResponseEntity.ok(packages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get available packages (active packages)
     */
    @GetMapping("/available")
    public ResponseEntity<List<Package>> getAvailablePackages() {
        try {
            // Note: You'll need to add an 'active' field to Package entity and this method to PackageRepository
            // List<Package> packages = packageRepository.findByActiveTrue();
            List<Package> packages = packageRepository.findAll(); // For now, return all packages
            return ResponseEntity.ok(packages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Create a new package
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createPackage(@RequestBody Package package_) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Validate required fields
            if (package_.getPackageName() == null || package_.getPackageName().trim().isEmpty()) {
                response.put("error", "Package name is required");
                return ResponseEntity.badRequest().body(response);
            }
            
            if (package_.getPrice() == null || package_.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
                response.put("error", "Package price must be greater than 0");
                return ResponseEntity.badRequest().body(response);
            }

            // Check if package name already exists
            boolean nameExists = packageRepository.findAll().stream()
                .anyMatch(p -> p.getPackageName().equalsIgnoreCase(package_.getPackageName()));
            
            if (nameExists) {
                response.put("error", "Package with this name already exists");
                return ResponseEntity.badRequest().body(response);
            }

            Package savedPackage = packageRepository.save(package_);
            response.put("success", true);
            response.put("package", savedPackage);
            response.put("message", "Package created successfully");
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("error", "Failed to create package: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Update an existing package
     */
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updatePackage(@PathVariable Integer id, @RequestBody Package packageDetails) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Package> optionalPackage = packageRepository.findById(id);
            
            if (!optionalPackage.isPresent()) {
                response.put("error", "Package not found with id: " + id);
                return ResponseEntity.notFound().build();
            }

            Package package_ = optionalPackage.get();
            
            // Update fields
            if (packageDetails.getPackageName() != null) {
                // Check if new name already exists (excluding current package)
                boolean nameExists = packageRepository.findAll().stream()
                    .anyMatch(p -> !p.getPackageId().equals(id) && p.getPackageName().equalsIgnoreCase(packageDetails.getPackageName()));
                
                if (nameExists) {
                    response.put("error", "Package with this name already exists");
                    return ResponseEntity.badRequest().body(response);
                }
                package_.setPackageName(packageDetails.getPackageName());
            }
            if (packageDetails.getDescription() != null) {
                package_.setDescription(packageDetails.getDescription());
            }
            if (packageDetails.getPrice() != null) {
                if (packageDetails.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
                    response.put("error", "Package price must be greater than 0");
                    return ResponseEntity.badRequest().body(response);
                }
                package_.setPrice(packageDetails.getPrice());
            }
            if (packageDetails.getDuration() != null) {
                package_.setDuration(packageDetails.getDuration());
            }

            Package updatedPackage = packageRepository.save(package_);
            response.put("success", true);
            response.put("package", updatedPackage);
            response.put("message", "Package updated successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Failed to update package: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Delete a package
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletePackage(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<Package> package_ = packageRepository.findById(id);
            
            if (!package_.isPresent()) {
                response.put("error", "Package not found with id: " + id);
                return ResponseEntity.notFound().build();
            }

            packageRepository.deleteById(id);
            response.put("success", true);
            response.put("message", "Package deleted successfully");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Failed to delete package: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Get package statistics
     */
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getPackageStatistics() {
        try {
            List<Package> allPackages = packageRepository.findAll();
            Map<String, Object> stats = new HashMap<>();
            
            stats.put("totalPackages", allPackages.size());
            stats.put("averagePrice", allPackages.stream()
                .map(Package::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(Math.max(allPackages.size(), 1)), java.math.RoundingMode.HALF_UP));
            stats.put("minPrice", allPackages.stream()
                .map(Package::getPrice)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO));
            stats.put("maxPrice", allPackages.stream()
                .map(Package::getPrice)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO));
            stats.put("averageDuration", allPackages.stream()
                .filter(p -> p.getDuration() != null)
                .mapToLong(p -> p.getDuration().length()) // Using string length as placeholder
                .average()
                .orElse(0.0));
            
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get popular packages (placeholder - would typically be based on booking frequency)
     */
    @GetMapping("/popular")
    public ResponseEntity<List<Package>> getPopularPackages(@RequestParam(defaultValue = "5") int limit) {
        try {
            // Note: In a real implementation, this would be based on booking frequency
            // For now, just return packages ordered by price (descending) as a placeholder
            List<Package> packages = packageRepository.findAll().stream()
                .sorted((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()))
                .limit(limit)
                .toList();
            return ResponseEntity.ok(packages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Validate package data
     */
    @PostMapping("/validate")
    public ResponseEntity<Map<String, Object>> validatePackage(@RequestBody Package package_) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean isValid = true;
            String message = "Package data is valid";

            if (package_.getPackageName() == null || package_.getPackageName().trim().isEmpty()) {
                isValid = false;
                message = "Package name is required";
            } else if (package_.getPrice() == null || package_.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
                isValid = false;
                message = "Package price must be greater than 0";
            } else {
                // Check if name already exists
                boolean nameExists = packageRepository.findAll().stream()
                    .anyMatch(p -> p.getPackageName().equalsIgnoreCase(package_.getPackageName()));
                
                if (nameExists) {
                    isValid = false;
                    message = "Package with this name already exists";
                }
            }

            response.put("valid", isValid);
            response.put("message", message);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Failed to validate package: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
