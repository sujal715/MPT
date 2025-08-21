# Movement Performance Training Website

A modern, responsive website for Movement Performance Training with admin dashboard, gallery management, and content management system.

## 🚀 Features

- **Admin Dashboard** - Content management system
- **Interactive Gallery** - Category-based filtering and image management
- **Smart Chatbot** - AI-powered customer support
- **Booking System** - Consultation and lesson booking
- **Responsive Design** - Works on all devices
- **Real-time Updates** - Dynamic content management

## 🏗️ Architecture

### Frontend (React)
- React 19 with modern hooks
- Responsive CSS with animations
- Service layer for API communication
- State management with React hooks

### Backend Integration
- RESTful API service layer
- Authentication and authorization
- File upload capabilities
- Error handling and fallbacks

## 📋 Prerequisites

- Node.js (v16 or higher)
- npm or yarn
- Your backend server running

## 🛠️ Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/12203112-ctrl/MpT.git
   cd MpT
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Environment Configuration**
   Create a `.env` file in the root directory:
   ```env
   # Backend API URL
   REACT_APP_API_URL=http://localhost:5000/api
   
   # App Configuration
   REACT_APP_NAME=Movement Performance Training
   REACT_APP_VERSION=1.0.0
   
   # Feature Flags
   REACT_APP_ENABLE_CHATBOT=true
   ```

4. **Start the development server**
   ```bash
   npm start
   ```

## 🔗 Backend Connection

### API Endpoints Expected

Your backend should provide these endpoints:

#### Authentication
- `POST /api/auth/login` - User login
- `POST /api/auth/logout` - User logout
- `GET /api/auth/me` - Get current user

#### Gallery Management
- `GET /api/gallery` - Get all gallery items
- `GET /api/gallery/category/:category` - Get items by category
- `POST /api/gallery` - Create new item (admin)
- `PUT /api/gallery/:id` - Update item (admin)
- `DELETE /api/gallery/:id` - Delete item (admin)
- `POST /api/gallery/upload` - Upload image (admin)

#### Services Management
- `GET /api/services` - Get all services
- `GET /api/services/:id` - Get service by ID
- `POST /api/services` - Create service (admin)
- `PUT /api/services/:id` - Update service (admin)
- `DELETE /api/services/:id` - Delete service (admin)

#### Testimonials
- `GET /api/testimonials` - Get all testimonials
- `POST /api/testimonials` - Create testimonial (admin)
- `PUT /api/testimonials/:id` - Update testimonial (admin)
- `DELETE /api/testimonials/:id` - Delete testimonial (admin)

#### Bookings
- `GET /api/bookings` - Get all bookings (admin)
- `POST /api/bookings` - Create new booking
- `PUT /api/bookings/:id` - Update booking (admin)
- `DELETE /api/bookings/:id` - Delete booking (admin)

### API Response Format

All API responses should follow this format:

```json
{
  "success": true,
  "data": { ... },
  "message": "Operation successful"
}
```

Error responses:
```json
{
  "success": false,
  "error": "Error message",
  "message": "Detailed error description"
}
```

### Authentication

The frontend expects JWT-based authentication:

1. **Login Response**
   ```json
   {
     "success": true,
     "data": {
       "token": "jwt_token_here",
       "user": { ... }
     }
   }
   ```

2. **Request Headers**
   ```
   Authorization: Bearer <jwt_token>
   Content-Type: application/json
   ```

## 🎯 Usage

### Admin Dashboard
- Navigate to `/admin`
- Login with your backend credentials
- Manage gallery, services, testimonials, and bookings

### Gallery
- Navigate to `/gallery`
- Filter by categories
- Click images to view full-size
- Admin can add/edit/delete items

### Chatbot
- Available on the home page
- Pre-programmed responses to common questions
- Helps guide users to booking

## 🔧 Development

### Project Structure
```
src/
├── components/          # Reusable components
│   ├── Header.js       # Navigation header
│   ├── Footer.js       # Site footer
│   └── Chatbot.js      # Interactive chatbot
├── pages/              # Page components
│   ├── Home.js         # Homepage
│   ├── Gallery.js      # Gallery page
│   ├── Admin.js        # Admin dashboard
│   └── ...
├── services/           # API services
│   ├── api.js          # Base API service
│   ├── authService.js  # Authentication
│   ├── galleryService.js # Gallery management
│   └── ...
└── ...
```

### Adding New Features

1. **Create API Service**
   ```javascript
   // src/services/newFeatureService.js
   import apiService from './api';
   
   class NewFeatureService {
     async getData() {
       return await apiService.get('/new-feature');
     }
   }
   
   export default new NewFeatureService();
   ```

2. **Update Component**
   ```javascript
   import newFeatureService from '../services/newFeatureService';
   
   // Use in component
   const data = await newFeatureService.getData();
   ```

## 🚀 Deployment

### Build for Production
```bash
npm run build
```

### Environment Variables for Production
```env
REACT_APP_API_URL=https://your-backend-domain.com/api
NODE_ENV=production
```

## 🐛 Troubleshooting

### Common Issues

1. **CORS Errors**
   - Ensure your backend allows requests from frontend domain
   - Check CORS configuration in backend

2. **Authentication Issues**
   - Verify JWT token format
   - Check token expiration
   - Ensure proper Authorization header

3. **API Connection**
   - Verify backend URL in `.env` file
   - Check if backend server is running
   - Test API endpoints with Postman/curl

### Debug Mode
Enable debug logging by setting in `.env`:
```env
REACT_APP_DEBUG=true
```

## 📱 Browser Support

- Chrome (latest)
- Firefox (latest)
- Safari (latest)
- Edge (latest)
- Mobile browsers (iOS Safari, Chrome Mobile)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.

## 📞 Support

For support and questions:
- Email: info@movementtraining.com
- Phone: 04 99 471 101

---

**Built with ❤️ for Movement Performance Training**
