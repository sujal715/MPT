# 🚀 MPT Full-Stack Application

A complete **Spring Boot + React** application with database, API endpoints, and modern web interface.

## 📁 **Project Structure:**

```
mpt-unified/
├── src/
│   ├── main/
│   │   ├── java/com/mpt/mpt/
│   │   │   ├── entity/           # JPA Entities
│   │   │   │   └── Booking.java
│   │   │   ├── repository/       # Data Access Layer
│   │   │   │   └── BookingRepository.java
│   │   │   ├── service/          # Business Logic
│   │   │   │   └── BookingService.java
│   │   │   ├── BookingController.java
│   │   │   ├── HealthController.java
│   │   │   ├── MainController.java
│   │   │   ├── TestController.java
│   │   │   ├── WebConfig.java
│   │   │   └── MptApplication.java
│   │   └── resources/
│   │       ├── static/           # React Frontend (built)
│   │       ├── application.properties
│   │       ├── application-railway.properties
│   │       ├── schema.sql        # Database Schema
│   │       └── data.sql          # Sample Data
├── frontend-src/                  # React Source Code
├── pom.xml                       # Maven Configuration
└── build-and-run.sh              # Build & Run Script
```

## 🗄️ **Database Features:**

- **H2 In-Memory Database** (development)
- **JPA/Hibernate** for data persistence
- **Complete Schema** with tables for:
  - Bookings
  - Packages
  - Services
  - Testimonials
- **Sample Data** for testing

## 🔌 **API Endpoints:**

### Bookings
- `POST /api/bookings/create` - Create new booking
- `GET /api/bookings` - Get all bookings
- `GET /api/bookings/{id}` - Get booking by ID
- `PUT /api/bookings/{id}` - Update booking
- `DELETE /api/bookings/{id}` - Delete booking

### Health Check
- `GET /api/health` - Application health status

## 🚀 **Quick Start:**

### **Option 1: Run Everything Together (Recommended)**
```bash
# Build and run Spring Boot (includes React)
./build-and-run.sh
```
Then visit: `http://localhost:8080`

### **Option 2: Run Separately for Development**
```bash
# Terminal 1: Start Spring Boot Backend
./mvnw spring-boot:run

# Terminal 2: Start React Frontend
cd frontend-src
npm install
npm start
```

## 🌐 **Access Points:**

- **Frontend**: `http://localhost:8080`
- **H2 Database Console**: `http://localhost:8080/h2-console`
- **API Base**: `http://localhost:8080/api`

## 🗄️ **Database Connection (H2 Console):**
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## 🚂 **Deploy to Railway:**

```bash
# Deploy everything to Railway
./railway-deploy.sh
```

## 🎯 **Key Features:**

✅ **Complete Backend** - Spring Boot with JPA, H2 Database  
✅ **React Frontend** - Modern web interface  
✅ **Database Schema** - Complete table structure  
✅ **Sample Data** - Ready for testing  
✅ **API Endpoints** - Full CRUD operations  
✅ **Unified Project** - Everything in one place  

## 🔧 **Technologies Used:**

- **Backend**: Spring Boot 2.7.18, JPA, H2 Database
- **Frontend**: React.js, Modern CSS
- **Build Tool**: Maven
- **Database**: H2 (in-memory for development)

---

**🎉 Your complete MPT application is now ready with database, API, and frontend!**
