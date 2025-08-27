# MPT Full Stack Application

This is a full-stack web application with a Spring Boot backend and React frontend.

## 🏗️ Project Structure

```
MpT/
├── backend/                 # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/mpt/mpt/
│   │   │   │       ├── MptApplication.java
│   │   │   │       ├── controller/
│   │   │   │       ├── service/
│   │   │   │       ├── repository/
│   │   │   │       └── entity/
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       ├── schema.sql
│   │   │       └── data.sql
│   ├── pom.xml
│   └── render.yaml
├── frontend/                # React Frontend
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── services/
│   │   └── config/
│   ├── public/
│   ├── package.json
│   └── render.yaml
└── deployment scripts
```

## 🚀 Quick Start

### Prerequisites
- Java 17
- Node.js 16+
- Maven
- Render account

### Local Development

#### Backend (Spring Boot)
```bash
cd backend
./mvnw spring-boot:run
```
Backend will be available at: http://localhost:8080

#### Frontend (React)
```bash
cd frontend
npm install
npm start
```
Frontend will be available at: http://localhost:3000

## 🌐 Deployment to Render

### Option 1: Deploy Both (Recommended)
```bash
./deploy-both.sh
```

### Option 2: Deploy Separately

#### Deploy Backend Only
```bash
./deploy-backend.sh
```

#### Deploy Frontend Only
```bash
./deploy-frontend.sh
```

## 📱 Application Features

### Backend (Spring Boot)
- RESTful API endpoints
- JPA/Hibernate for data persistence
- H2 database (can be configured for production)
- Entity relationships for:
  - Bookings
  - Services
  - Packages
  - Testimonials

### Frontend (React)
- Modern React 18 with hooks
- Responsive design
- Component-based architecture
- API integration with backend

## 🔧 Configuration

### Backend Configuration
- Database configuration in `backend/src/main/resources/application.properties`
- Render-specific config in `application-render.properties`

### Frontend Configuration
- API endpoint configuration in `frontend/src/config/`
- Environment variables for production deployment

## 📊 API Endpoints

- `GET /api/health` - Health check
- `GET /api/bookings` - Get all bookings
- `POST /api/bookings` - Create new booking
- `GET /api/services` - Get all services
- `GET /api/packages` - Get all packages
- `GET /api/testimonials` - Get all testimonials

## 🚨 Troubleshooting

### Common Issues

1. **Backend won't start**: Check Java version (requires Java 17)
2. **Frontend build fails**: Ensure Node.js version is 16+
3. **Deployment fails**: Check Render dashboard for build logs

### Local Testing
```bash
# Test backend
curl http://localhost:8080/api/health

# Test frontend
open http://localhost:3000
```

## 📝 Notes

- The backend uses H2 database by default (in-memory)
- For production, consider using PostgreSQL or MySQL
- Frontend is configured to proxy API calls to backend during development
- Both applications are configured for Render deployment

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test locally
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.
