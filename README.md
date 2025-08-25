# Movement Performance Training - Backend

A Spring Boot backend application for the Movement Performance Training system.

## Features

- **Customer Management**: CRUD operations for customers
- **Package Management**: CRUD operations for training packages
- **Booking System**: Manage training sessions and appointments
- **Testimonial System**: Customer reviews and ratings
- **Payment Tracking**: Payment management for bookings
- **RESTful API**: Complete REST API for frontend integration

## Technology Stack

- **Java 17**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **H2 Database** (in-memory for development)
- **Maven** for build management

## API Endpoints

### Customers
- `GET /api/customers` - Get all customers
- `GET /api/customers/{id}` - Get customer by ID
- `POST /api/customers` - Create new customer
- `PUT /api/customers/{id}` - Update customer
- `DELETE /api/customers/{id}` - Delete customer
- `GET /api/customers/search?name={name}` - Search customers by name

### Packages
- `GET /api/packages` - Get all packages
- `GET /api/packages/{id}` - Get package by ID
- `POST /api/packages` - Create new package
- `PUT /api/packages/{id}` - Update package
- `DELETE /api/packages/{id}` - Delete package
- `GET /api/packages/active` - Get active packages

### Bookings
- `GET /api/bookings` - Get all bookings
- `GET /api/bookings/{id}` - Get booking by ID
- `POST /api/bookings` - Create new booking
- `PUT /api/bookings/{id}` - Update booking
- `DELETE /api/bookings/{id}` - Delete booking
- `GET /api/bookings/customer/{customerId}` - Get bookings by customer

### Testimonials
- `GET /api/testimonials` - Get all testimonials
- `GET /api/testimonials/{id}` - Get testimonial by ID
- `POST /api/testimonials` - Create new testimonial
- `PUT /api/testimonials/{id}` - Update testimonial
- `DELETE /api/testimonials/{id}` - Delete testimonial
- `GET /api/testimonials/approved` - Get approved testimonials

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running Locally
1. Clone the repository
2. Navigate to the project directory
3. Run: `./mvnw spring-boot:run`
4. Access the API at: `http://localhost:8080`
5. H2 Console at: `http://localhost:8080/h2-console`

### Building
```bash
./mvnw clean install
```

### Running Tests
```bash
./mvnw test
```

## Database

The application uses H2 in-memory database for development with sample data pre-loaded.

## Deployment

The application is configured for deployment to Railway with Docker support.

## CORS Configuration

CORS is configured to allow requests from:
- Local development servers (localhost:3000, localhost:3001)
- Railway deployments
- Render deployments
- Netlify deployments
- Vercel deployments
