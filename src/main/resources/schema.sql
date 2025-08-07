-- Database Schema for Booking System
-- Based on Entity Relationship Diagram (ERD)

-- Create Customer table
CREATE TABLE IF NOT EXISTS Customer (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Phone VARCHAR(20),
    DateOfBirth DATE,
    Address TEXT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create Package table
CREATE TABLE IF NOT EXISTS Package (
    PackageID INT AUTO_INCREMENT PRIMARY KEY,
    PackageName VARCHAR(100) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    Duration VARCHAR(50),
    Description TEXT,
    IsActive BOOLEAN DEFAULT TRUE,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create Booking table
CREATE TABLE IF NOT EXISTS Booking (
    BookingID INT AUTO_INCREMENT PRIMARY KEY,
    BookingDate DATE NOT NULL,
    BookingTime TIME NOT NULL,
    Status ENUM('PENDING', 'CONFIRMED', 'CANCELLED', 'COMPLETED') DEFAULT 'PENDING',
    CustomerID INT NOT NULL,
    PackageID INT NOT NULL,
    TotalAmount DECIMAL(10,2),
    Notes TEXT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE CASCADE,
    FOREIGN KEY (PackageID) REFERENCES Package(PackageID) ON DELETE RESTRICT
);

-- Create Payment table
CREATE TABLE IF NOT EXISTS Payment (
    PaymentID INT AUTO_INCREMENT PRIMARY KEY,
    PaymentDate DATE NOT NULL,
    Amount DECIMAL(10,2) NOT NULL,
    PaymentMethod ENUM('CASH', 'CREDIT_CARD', 'DEBIT_CARD', 'BANK_TRANSFER', 'ONLINE') NOT NULL,
    PaymentStatus ENUM('PENDING', 'COMPLETED', 'FAILED', 'REFUNDED') DEFAULT 'PENDING',
    BookingID INT NOT NULL,
    TransactionReference VARCHAR(100),
    Notes TEXT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (BookingID) REFERENCES Booking(BookingID) ON DELETE CASCADE
);

-- Create Testimonial table
CREATE TABLE IF NOT EXISTS Testimonial (
    TestimonialID INT AUTO_INCREMENT PRIMARY KEY,
    Comment TEXT NOT NULL,
    DateSubmitted DATE NOT NULL,
    CustomerID INT NOT NULL,
    Rating INT CHECK (Rating >= 1 AND Rating <= 5),
    IsApproved BOOLEAN DEFAULT FALSE,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE CASCADE
);

-- Create indexes for better performance
CREATE INDEX idx_customer_email ON Customer(Email);
CREATE INDEX idx_booking_customer ON Booking(CustomerID);
CREATE INDEX idx_booking_package ON Booking(PackageID);
CREATE INDEX idx_booking_date ON Booking(BookingDate);
CREATE INDEX idx_payment_booking ON Payment(BookingID);
CREATE INDEX idx_testimonial_customer ON Testimonial(CustomerID);
CREATE INDEX idx_testimonial_date ON Testimonial(DateSubmitted);
