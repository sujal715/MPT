<<<<<<< HEAD
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
=======
# Booking System - Spring Boot Application

This is a Spring Boot application implementing a booking system based on the provided Entity Relationship Diagram (ERD).

## 🗄️ Database Schema

The application includes a complete database schema with the following entities:

- **Customer**: Personal information with unique email
- **Package**: Service packages with pricing
- **Booking**: Links customers to packages with status tracking
- **Payment**: Payment records linked to bookings
- **Testimonial**: Customer feedback with ratings

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/mpt/mpt/
│   │   ├── entity/           # JPA Entity classes
│   │   ├── repository/       # Spring Data JPA repositories
│   │   ├── service/          # Business logic services
│   │   ├── controller/       # REST API controllers
│   │   ├── config/           # Configuration classes
│   │   └── MptApplication.java
│   └── resources/
│       ├── schema.sql        # Database schema creation
│       ├── data.sql          # Sample data insertion
│       └── application.properties
```

## 🚀 Quick Start

### Prerequisites
- Java 24 (as specified in pom.xml)
- Maven 3.6+

### Running the Application

1. **Clone and navigate to the project directory**
   ```bash
   cd mpt
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the application**
   - Main application: http://localhost:8080
   - H2 Database Console: http://localhost:8080/h2-console
   - API Health Check: http://localhost:8080/api/bookings/health
   - Database Test: http://localhost:8080/api/test/database

### H2 Database Console Access
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## 📊 SQL Files

### schema.sql
Contains the complete database schema with:
- Table creation statements
- Foreign key relationships
- Indexes for performance
- Audit fields (CreatedAt, UpdatedAt)

### data.sql
Contains sample data for testing:
- 5 customers with realistic information
- 5 service packages with different pricing tiers
- 5 bookings linking customers to packages
- 5 payments with various payment methods
- 5 testimonials with ratings

## 🔧 Configuration

### Database Configuration (application.properties)
```properties
# H2 Database
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.username=sa
spring.datasource.password=password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=none
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
```

### Switching to MySQL
1. Uncomment MySQL dependency in `pom.xml`
2. Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/booking_system
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
   ```

## 🛠️ API Endpoints

### Booking API
- `GET /api/bookings/health` - Health check
- `GET /api/bookings/statistics` - Booking statistics
- `POST /api/bookings/check-availability` - Check time slot availability
- `GET /api/bookings/revenue` - Calculate revenue for date range

### Database Test API
- `GET /api/test/database` - Test database connectivity and data
- `GET /api/test/tables` - List all database tables

## 🔍 Troubleshooting

### "No data sources are configured" Error
This error occurs when Spring Boot can't find the database configuration. Solutions:

1. **Check dependencies**: Ensure all database dependencies are in `pom.xml`
2. **Verify configuration**: Check `application.properties` for correct database settings
3. **Rebuild project**: Run `./mvnw clean install`
4. **Check logs**: Look for database initialization errors in application logs

### Database Connection Issues
1. **H2 Console**: Access http://localhost:8080/h2-console to verify database
2. **Test endpoint**: Use http://localhost:8080/api/test/database
3. **Check schema**: Verify `schema.sql` and `data.sql` are in `src/main/resources/`

## 📈 Advanced Features

### Entity Relationships
- **Customer → Booking**: One-to-Many (one customer can have multiple bookings)
- **Package → Booking**: One-to-Many (one package can be used in multiple bookings)
- **Booking → Payment**: One-to-Many (one booking can have multiple payments)
- **Customer → Testimonial**: One-to-Many (one customer can submit multiple testimonials)

### Business Logic
- Booking status management (PENDING, CONFIRMED, CANCELLED, COMPLETED)
- Payment status tracking (PENDING, COMPLETED, FAILED, REFUNDED)
- Revenue calculation and reporting
- Time slot availability checking

## 🧪 Testing

### Manual Testing
1. Start the application
2. Access H2 console to verify data
3. Test API endpoints using browser or Postman
4. Check database test endpoint for connectivity

### Sample API Calls
```bash
# Health check
curl http://localhost:8080/api/bookings/health

# Database test
curl http://localhost:8080/api/test/database

# Check availability
curl -X POST "http://localhost:8080/api/bookings/check-availability?date=2024-01-15&time=10:00:00"
```

## 📝 Notes

- The application uses H2 in-memory database for development
- All SQL scripts are automatically executed on startup
- JPA entities are configured but not actively used in this version
- The focus is on demonstrating the SQL schema and data setup
- For production, consider switching to MySQL or PostgreSQL

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## 📄 License

This project is for educational purposes. Feel free to use and modify as needed. 
>>>>>>> fdcf6fbd346bf74cc21f14886fa500b7f9407bbd
