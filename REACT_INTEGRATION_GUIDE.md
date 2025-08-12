# React + Spring Boot Integration Guide

This guide helps your React frontend developer connect to your Spring Boot backend API.

## 🚀 Quick Start

### Backend Setup (Already Done ✅)
- ✅ CORS configuration enabled for React development ports
- ✅ REST API endpoints created for all entities
- ✅ JSON response format standardized
- ✅ Error handling implemented

### Frontend Requirements

Your React app should run on:
- `http://localhost:3000` (default Create React App port)
- `http://localhost:3001` (alternative port)

## 📡 API Endpoints Overview

### Base URL
```
Development: http://localhost:8080
Production: https://your-heroku-app.herokuapp.com
```

### Available Endpoints

#### 🏠 Health Check
```
GET /                    - Basic health check
GET /db-test            - Database connectivity test
```

#### 👥 Customer Management
```
GET    /api/customers              - Get all customers
GET    /api/customers/{id}         - Get customer by ID
GET    /api/customers/email/{email} - Get customer by email
GET    /api/customers/search?name={name} - Search customers by name
POST   /api/customers              - Create new customer
PUT    /api/customers/{id}         - Update customer
DELETE /api/customers/{id}         - Delete customer
GET    /api/customers/stats        - Get customer statistics
POST   /api/customers/validate-email - Validate email format and uniqueness
```

#### 📦 Package Management
```
GET    /api/packages                           - Get all packages
GET    /api/packages/{id}                      - Get package by ID
GET    /api/packages/price-range?minPrice={min}&maxPrice={max} - Get packages by price range
GET    /api/packages/search?query={query}     - Search packages
GET    /api/packages/available                - Get available packages
POST   /api/packages                          - Create new package
PUT    /api/packages/{id}                     - Update package
DELETE /api/packages/{id}                     - Delete package
GET    /api/packages/stats                    - Get package statistics
GET    /api/packages/popular?limit={limit}    - Get popular packages
POST   /api/packages/validate                 - Validate package data
```

#### 📅 Booking Management
```
GET    /api/bookings                     - Get all bookings
GET    /api/bookings/{id}               - Get booking by ID
GET    /api/bookings/customer/{customerId} - Get bookings by customer
POST   /api/bookings                    - Create new booking
PUT    /api/bookings/{id}               - Update booking
DELETE /api/bookings/{id}               - Delete booking
GET    /api/bookings/stats              - Get booking statistics
PATCH  /api/bookings/{id}/status?status={status} - Update booking status only
```

#### 🔗 HubSpot Integration
```
GET    /api/hubspot/test                - Test HubSpot connection
POST   /api/hubspot/sync-customer       - Sync customer to HubSpot
POST   /api/hubspot/sync-booking        - Sync booking to HubSpot
GET    /api/hubspot/contact/{email}     - Get HubSpot contact by email
PUT    /api/hubspot/update-contact      - Update HubSpot contact
```

## 💻 Frontend Code Examples

### 1. Basic API Service Setup

Create `src/services/api.js`:

```javascript
const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080';

class ApiService {
  async request(endpoint, options = {}) {
    const url = `${API_BASE_URL}${endpoint}`;
    const config = {
      headers: {
        'Content-Type': 'application/json',
        ...options.headers,
      },
      ...options,
    };

    try {
      const response = await fetch(url, config);
      const data = await response.json();
      
      if (!response.ok) {
        throw new Error(data.error || `HTTP error! status: ${response.status}`);
      }
      
      return data;
    } catch (error) {
      console.error('API request failed:', error);
      throw error;
    }
  }

  // GET request
  get(endpoint) {
    return this.request(endpoint);
  }

  // POST request
  post(endpoint, data) {
    return this.request(endpoint, {
      method: 'POST',
      body: JSON.stringify(data),
    });
  }

  // PUT request
  put(endpoint, data) {
    return this.request(endpoint, {
      method: 'PUT',
      body: JSON.stringify(data),
    });
  }

  // DELETE request
  delete(endpoint) {
    return this.request(endpoint, {
      method: 'DELETE',
    });
  }
}

export default new ApiService();
```

### 2. Customer Service

Create `src/services/customerService.js`:

```javascript
import ApiService from './api';

export const customerService = {
  // Get all customers
  getAllCustomers: () => ApiService.get('/api/customers'),

  // Get customer by ID
  getCustomerById: (id) => ApiService.get(`/api/customers/${id}`),

  // Get customer by email
  getCustomerByEmail: (email) => ApiService.get(`/api/customers/email/${email}`),

  // Search customers
  searchCustomers: (name) => ApiService.get(`/api/customers/search?name=${encodeURIComponent(name)}`),

  // Create customer
  createCustomer: (customer) => ApiService.post('/api/customers', customer),

  // Update customer
  updateCustomer: (id, customer) => ApiService.put(`/api/customers/${id}`, customer),

  // Delete customer
  deleteCustomer: (id) => ApiService.delete(`/api/customers/${id}`),

  // Get customer statistics
  getCustomerStats: () => ApiService.get('/api/customers/stats'),

  // Validate email
  validateEmail: (email) => ApiService.post('/api/customers/validate-email', { email }),
};
```

### 3. Package Service

Create `src/services/packageService.js`:

```javascript
import ApiService from './api';

export const packageService = {
  // Get all packages
  getAllPackages: () => ApiService.get('/api/packages'),

  // Get package by ID
  getPackageById: (id) => ApiService.get(`/api/packages/${id}`),

  // Search packages
  searchPackages: (query) => ApiService.get(`/api/packages/search?query=${encodeURIComponent(query)}`),

  // Get packages by price range
  getPackagesByPriceRange: (minPrice, maxPrice) => 
    ApiService.get(`/api/packages/price-range?minPrice=${minPrice}&maxPrice=${maxPrice}`),

  // Get available packages
  getAvailablePackages: () => ApiService.get('/api/packages/available'),

  // Get popular packages
  getPopularPackages: (limit = 5) => ApiService.get(`/api/packages/popular?limit=${limit}`),

  // Create package
  createPackage: (pkg) => ApiService.post('/api/packages', pkg),

  // Update package
  updatePackage: (id, pkg) => ApiService.put(`/api/packages/${id}`, pkg),

  // Delete package
  deletePackage: (id) => ApiService.delete(`/api/packages/${id}`),

  // Get package statistics
  getPackageStats: () => ApiService.get('/api/packages/stats'),

  // Validate package
  validatePackage: (pkg) => ApiService.post('/api/packages/validate', pkg),
};
```

### 4. Booking Service

Create `src/services/bookingService.js`:

```javascript
import ApiService from './api';

export const bookingService = {
  // Get all bookings
  getAllBookings: () => ApiService.get('/api/bookings'),

  // Get booking by ID
  getBookingById: (id) => ApiService.get(`/api/bookings/${id}`),

  // Get bookings by customer
  getBookingsByCustomer: (customerId) => ApiService.get(`/api/bookings/customer/${customerId}`),

  // Create booking
  createBooking: (booking) => ApiService.post('/api/bookings', booking),

  // Update booking
  updateBooking: (id, booking) => ApiService.put(`/api/bookings/${id}`, booking),

  // Update booking status
  updateBookingStatus: (id, status) => 
    ApiService.request(`/api/bookings/${id}/status?status=${status}`, { method: 'PATCH' }),

  // Delete booking
  deleteBooking: (id) => ApiService.delete(`/api/bookings/${id}`),

  // Get booking statistics
  getBookingStats: () => ApiService.get('/api/bookings/stats'),
};
```

### 5. React Hook Examples

Create `src/hooks/useCustomers.js`:

```javascript
import { useState, useEffect } from 'react';
import { customerService } from '../services/customerService';

export const useCustomers = () => {
  const [customers, setCustomers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchCustomers();
  }, []);

  const fetchCustomers = async () => {
    try {
      setLoading(true);
      const data = await customerService.getAllCustomers();
      setCustomers(data);
      setError(null);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  const createCustomer = async (customer) => {
    try {
      const response = await customerService.createCustomer(customer);
      if (response.success) {
        setCustomers(prev => [...prev, response.customer]);
        return response;
      }
    } catch (err) {
      throw err;
    }
  };

  const updateCustomer = async (id, customer) => {
    try {
      const response = await customerService.updateCustomer(id, customer);
      if (response.success) {
        setCustomers(prev => 
          prev.map(c => c.id === id ? response.customer : c)
        );
        return response;
      }
    } catch (err) {
      throw err;
    }
  };

  const deleteCustomer = async (id) => {
    try {
      const response = await customerService.deleteCustomer(id);
      if (response.success) {
        setCustomers(prev => prev.filter(c => c.id !== id));
        return response;
      }
    } catch (err) {
      throw err;
    }
  };

  return {
    customers,
    loading,
    error,
    fetchCustomers,
    createCustomer,
    updateCustomer,
    deleteCustomer,
  };
};
```

### 6. Component Example

Create `src/components/CustomerList.js`:

```javascript
import React from 'react';
import { useCustomers } from '../hooks/useCustomers';

const CustomerList = () => {
  const { customers, loading, error, deleteCustomer } = useCustomers();

  if (loading) return <div>Loading customers...</div>;
  if (error) return <div>Error: {error}</div>;

  const handleDelete = async (id) => {
    if (window.confirm('Are you sure you want to delete this customer?')) {
      try {
        await deleteCustomer(id);
        alert('Customer deleted successfully!');
      } catch (err) {
        alert('Failed to delete customer: ' + err.message);
      }
    }
  };

  return (
    <div>
      <h2>Customers</h2>
      <div className="customer-list">
        {customers.map(customer => (
          <div key={customer.id} className="customer-card">
            <h3>{customer.name}</h3>
            <p>Email: {customer.email}</p>
            <p>Phone: {customer.phone || 'N/A'}</p>
            <p>Address: {customer.address || 'N/A'}</p>
            <button onClick={() => handleDelete(customer.id)}>
              Delete
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default CustomerList;
```

## 🔧 Environment Variables

Create `.env` file in your React project:

```bash
# Backend API URL
REACT_APP_API_URL=http://localhost:8080

# For production
# REACT_APP_API_URL=https://your-heroku-app.herokuapp.com
```

## 📝 Data Models

### Customer Object
```javascript
{
  id: number,
  name: string,
  email: string,
  phone: string,
  address: string
}
```

### Package Object
```javascript
{
  id: number,
  name: string,
  description: string,
  price: number,
  durationMinutes: number
}
```

### Booking Object
```javascript
{
  id: number,
  bookingDate: string, // YYYY-MM-DD format
  bookingTime: string, // HH:MM:SS format
  status: string, // PENDING, CONFIRMED, COMPLETED, CANCELLED
  totalAmount: number,
  notes: string,
  customer: Customer,
  package: Package
}
```

## 🛠️ Testing the Connection

### 1. Test Backend Connectivity
```javascript
// In your browser console or React component
fetch('http://localhost:8080/')
  .then(response => response.text())
  .then(data => console.log(data));
```

### 2. Test API Endpoints
```javascript
// Test getting customers
fetch('http://localhost:8080/api/customers')
  .then(response => response.json())
  .then(data => console.log(data));
```

## 🚨 Common Issues & Solutions

### 1. CORS Errors
- **Problem**: "Access to fetch at 'http://localhost:8080' from origin 'http://localhost:3000' has been blocked by CORS policy"
- **Solution**: Already configured! Make sure your React app runs on port 3000 or 3001

### 2. Network Errors
- **Problem**: "Failed to fetch"
- **Solution**: Ensure Spring Boot backend is running on port 8080

### 3. 404 Errors
- **Problem**: API endpoints return 404
- **Solution**: Check endpoint URLs match exactly with the API documentation above

### 4. JSON Parsing Errors
- **Problem**: "Unexpected token < in JSON"
- **Solution**: Backend might be returning HTML error page instead of JSON

## 📱 Frontend Architecture Recommendations

```
src/
├── services/
│   ├── api.js              # Base API service
│   ├── customerService.js  # Customer API calls
│   ├── packageService.js   # Package API calls
│   └── bookingService.js   # Booking API calls
├── hooks/
│   ├── useCustomers.js     # Customer state management
│   ├── usePackages.js      # Package state management
│   └── useBookings.js      # Booking state management
├── components/
│   ├── customers/          # Customer components
│   ├── packages/           # Package components
│   └── bookings/           # Booking components
└── pages/
    ├── CustomersPage.js    # Customer management page
    ├── PackagesPage.js     # Package management page
    └── BookingsPage.js     # Booking management page
```

## 🔄 Real-time Updates (Optional)

For real-time updates, consider implementing WebSocket connection or polling:

```javascript
// Polling example
const useRealTimeBookings = () => {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    const interval = setInterval(async () => {
      try {
        const data = await bookingService.getAllBookings();
        setBookings(data);
      } catch (error) {
        console.error('Failed to fetch bookings:', error);
      }
    }, 30000); // Update every 30 seconds

    return () => clearInterval(interval);
  }, []);

  return bookings;
};
```

## 🚀 Next Steps

1. **Start with basic connectivity** - Test the health endpoint first
2. **Implement one entity at a time** - Start with customers, then packages, then bookings
3. **Add error handling** - Implement proper error boundaries and user feedback
4. **Add loading states** - Show loading indicators during API calls
5. **Implement form validation** - Use the validation endpoints provided
6. **Add search functionality** - Utilize the search endpoints
7. **Consider state management** - Redux or Context API for complex state

## 🆘 Getting Help

If you encounter issues:
1. Check browser console for errors
2. Verify backend is running: `http://localhost:8080/`
3. Test API endpoints directly in browser or Postman
4. Check network tab in browser developer tools
5. Verify CORS configuration includes your React app's port

Happy coding! 🎉