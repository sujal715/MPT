-- Sample Data for Booking System
-- Insert sample data for testing and development

-- Insert sample customers
INSERT INTO Customer (FirstName, LastName, Email, Phone, DateOfBirth, Address) VALUES
('John', 'Doe', 'john.doe@email.com', '+1-555-0101', '1990-05-15', '123 Main St, Anytown, USA'),
('Jane', 'Smith', 'jane.smith@email.com', '+1-555-0102', '1985-08-22', '456 Oak Ave, Somewhere, USA'),
('Mike', 'Johnson', 'mike.johnson@email.com', '+1-555-0103', '1992-03-10', '789 Pine Rd, Elsewhere, USA'),
('Sarah', 'Williams', 'sarah.williams@email.com', '+1-555-0104', '1988-11-30', '321 Elm St, Nowhere, USA'),
('David', 'Brown', 'david.brown@email.com', '+1-555-0105', '1995-07-18', '654 Maple Dr, Anywhere, USA');

-- Insert sample packages
INSERT INTO Package (PackageName, Price, Duration, Description) VALUES
('Basic Package', 99.99, '1 hour', 'Basic service package with standard features'),
('Premium Package', 199.99, '2 hours', 'Premium service package with advanced features'),
('Deluxe Package', 299.99, '3 hours', 'Deluxe service package with all features included'),
('VIP Package', 499.99, '4 hours', 'VIP service package with exclusive features and priority service'),
('Corporate Package', 799.99, '6 hours', 'Corporate service package for business clients');

-- Insert sample bookings
INSERT INTO Booking (BookingDate, BookingTime, Status, CustomerID, PackageID, TotalAmount, Notes) VALUES
('2024-01-15', '10:00:00', 'CONFIRMED', 1, 2, 199.99, 'First booking for John Doe'),
('2024-01-16', '14:30:00', 'PENDING', 2, 1, 99.99, 'Basic package for Jane Smith'),
('2024-01-17', '09:00:00', 'CONFIRMED', 3, 3, 299.99, 'Deluxe package for Mike Johnson'),
('2024-01-18', '16:00:00', 'COMPLETED', 4, 4, 499.99, 'VIP package for Sarah Williams'),
('2024-01-19', '11:30:00', 'CONFIRMED', 5, 5, 799.99, 'Corporate package for David Brown');

-- Insert sample payments
INSERT INTO Payment (PaymentDate, Amount, PaymentMethod, PaymentStatus, BookingID, TransactionReference) VALUES
('2024-01-15', 199.99, 'CREDIT_CARD', 'COMPLETED', 1, 'TXN-001-2024'),
('2024-01-16', 99.99, 'ONLINE', 'PENDING', 2, 'TXN-002-2024'),
('2024-01-17', 299.99, 'DEBIT_CARD', 'COMPLETED', 3, 'TXN-003-2024'),
('2024-01-18', 499.99, 'BANK_TRANSFER', 'COMPLETED', 4, 'TXN-004-2024'),
('2024-01-19', 799.99, 'CREDIT_CARD', 'COMPLETED', 5, 'TXN-005-2024');

-- Insert sample testimonials
INSERT INTO Testimonial (Comment, DateSubmitted, CustomerID, Rating, IsApproved) VALUES
('Excellent service! The staff was very professional and the results exceeded my expectations.', '2024-01-20', 1, 5, TRUE),
('Great experience overall. Would definitely recommend to others.', '2024-01-21', 2, 4, TRUE),
('Amazing quality and attention to detail. Very satisfied with the service.', '2024-01-22', 3, 5, TRUE),
('Outstanding service from start to finish. Highly recommended!', '2024-01-23', 4, 5, TRUE),
('Professional team and excellent results. Will be coming back for sure.', '2024-01-24', 5, 4, TRUE); 