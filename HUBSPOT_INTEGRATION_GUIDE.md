# HubSpot Integration Guide

## 🎯 What This Integration Does

Your booking system now automatically syncs with HubSpot CRM:

### **Customer Sync**
- ✅ New customers → HubSpot contacts
- ✅ Customer updates → HubSpot contact updates
- ✅ Customer data (name, email, phone, address) → HubSpot contact properties

### **Booking Sync**
- ✅ New bookings → HubSpot deals
- ✅ Booking status changes → Deal stage updates
- ✅ Booking amounts → Deal amounts
- ✅ Booking dates → Deal close dates

### **Status Mapping**
- **PENDING** → "Appointment Scheduled"
- **CONFIRMED** → "Qualified to Buy"
- **COMPLETED** → "Closed Won"
- **CANCELLED** → "Closed Lost"

---

## 🔑 Setup Instructions for Your Client

### **Step 1: Get HubSpot API Key**

1. **Login to HubSpot** (your client's account)
2. **Go to Settings** → **Account Setup** → **Integrations** → **API Keys**
3. **Create a new API key** or use existing one
4. **Copy the API key** (starts with `pat-`)

### **Step 2: Get HubSpot Portal ID**

1. **In HubSpot**, go to **Settings** → **Account Setup** → **Account Information**
2. **Copy the Portal ID** (usually a 6-8 digit number)

### **Step 3: Configure Environment Variables**

#### **For Local Development:**
Add to `application.properties`:
```properties
hubspot.api.key=pat-your-api-key-here
hubspot.portal.id=12345678
```

#### **For Production (Heroku):**
```bash
heroku config:set HUBSPOT_API_KEY=pat-your-api-key-here
heroku config:set HUBSPOT_PORTAL_ID=12345678
```

#### **For Other Cloud Platforms:**
Set environment variables:
- `HUBSPOT_API_KEY`
- `HUBSPOT_PORTAL_ID`

---

## 🚀 Testing the Integration

### **Test Endpoints**

1. **Test Connection:**
   ```
   GET /api/hubspot/test
   ```

2. **Sync Customer:**
   ```
   POST /api/hubspot/sync-customer
   Content-Type: application/json
   
   {
     "firstName": "John",
     "lastName": "Doe",
     "email": "john.doe@example.com",
     "phone": "+1-555-0101",
     "address": "123 Main St"
   }
   ```

3. **Sync Booking:**
   ```
   POST /api/hubspot/sync-booking
   Content-Type: application/json
   
   {
     "bookingId": 1,
     "bookingDate": "2024-01-15",
     "bookingTime": "10:00:00",
     "status": "CONFIRMED",
     "totalAmount": 199.99,
     "customer": {
       "customerId": 1,
       "email": "john.doe@example.com"
     },
     "package_": {
       "packageId": 1,
       "packageName": "Premium Package"
     }
   }
   ```

4. **Get Contact by Email:**
   ```
   GET /api/hubspot/contact/john.doe@example.com
   ```

---

## 🔄 Automatic Sync Features

### **Customer Sync Triggers**
- ✅ New customer registration
- ✅ Customer profile updates
- ✅ Customer data changes

### **Booking Sync Triggers**
- ✅ New booking creation
- ✅ Booking status changes
- ✅ Booking amount updates
- ✅ Booking date changes

---

## 📊 HubSpot Data Mapping

### **Customer → Contact Properties**
| Booking System | HubSpot Contact Property |
|----------------|--------------------------|
| firstName | firstname |
| lastName | lastname |
| email | email |
| phone | phone |
| address | address |

### **Booking → Deal Properties**
| Booking System | HubSpot Deal Property |
|----------------|----------------------|
| bookingId + packageName | dealname |
| totalAmount | amount |
| bookingStatus | dealstage |
| bookingDate | closedate |

---

## 🛠️ Customization Options

### **Custom Properties**
You can add custom HubSpot properties by modifying `HubSpotService.java`:

```java
// Add custom properties
properties.put("custom_property_name", "value");
```

### **Custom Deal Stages**
Modify `mapBookingStatusToDealStage()` method to match your client's deal stages.

### **Custom Contact Properties**
Add more contact properties in `syncCustomerToHubSpot()` method.

---

## 🔒 Security & Best Practices

### **API Key Security**
- ✅ Never commit API keys to version control
- ✅ Use environment variables in production
- ✅ Rotate API keys regularly
- ✅ Use least-privilege API keys

### **Data Privacy**
- ✅ Only sync necessary data
- ✅ Respect customer privacy preferences
- ✅ Follow GDPR/CCPA compliance
- ✅ Secure data transmission (HTTPS)

---

## 🚨 Troubleshooting

### **Common Issues**

1. **"HubSpot API key not configured"**
   - Check environment variables
   - Verify API key format (starts with `pat-`)

2. **"Contact not found"**
   - Check email format
   - Verify contact exists in HubSpot

3. **"Deal creation failed"**
   - Check deal stage names
   - Verify required properties

### **Debug Mode**
Enable debug logging in `application.properties`:
```properties
logging.level.com.mpt.mpt.service.HubSpotService=DEBUG
```

---

## 📞 Support

### **HubSpot Resources**
- [HubSpot API Documentation](https://developers.hubspot.com/docs/api/overview)
- [HubSpot API Reference](https://developers.hubspot.com/docs/api/crm/contacts)
- [HubSpot Community](https://community.hubspot.com/)

### **Integration Support**
- Check application logs for errors
- Test with HubSpot's API testing tools
- Verify API key permissions

---

## ✅ Integration Checklist

- [ ] HubSpot API key obtained
- [ ] HubSpot Portal ID obtained
- [ ] Environment variables configured
- [ ] Integration tested with sample data
- [ ] Customer sync working
- [ ] Booking sync working
- [ ] Status mapping verified
- [ ] Error handling tested
- [ ] Security measures implemented
- [ ] Documentation provided to client

**Your booking system is now fully integrated with HubSpot CRM!** 🎉
