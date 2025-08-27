# 🚂 Railway All-in-One Deployment Guide

## 🎯 **What This Solves:**

✅ **No More Port Conflicts** - Everything runs on one domain  
✅ **Single Deployment** - Both backend and frontend deploy together  
✅ **Automatic Routing** - `/api/*` goes to Spring Boot, everything else to React  
✅ **Production Ready** - Optimized for production deployment  

## 🏗️ **How It Works:**

1. **React Frontend** gets built and copied to Spring Boot's static resources
2. **Spring Boot** serves both the API endpoints AND the React frontend
3. **Railway** hosts everything on one domain with automatic port management
4. **No port conflicts** - Railway handles all routing internally

## 🚀 **Deployment Steps:**

### **Step 1: Install Railway CLI**
```bash
npm install -g @railway/cli
```

### **Step 2: Login to Railway**
```bash
railway login
```

### **Step 3: Run the Deployment Script**
```bash
chmod +x railway-deploy.sh
./railway-deploy.sh
```

### **Step 4: Manual Deployment (Alternative)**
```bash
# Build React frontend
npm run build

# Copy to Spring Boot
cp -r build/* ../mpt-backend/src/main/resources/static/

# Deploy Spring Boot
cd ../mpt-backend
railway up
```

## 🔧 **Configuration Files Created:**

### **railway.json** - Main Railway configuration
### **application-railway.properties** - Spring Boot Railway config
### **WebConfig.java** - Frontend serving configuration

## 🌐 **After Deployment:**

- **Single URL**: `https://your-app.railway.app`
- **API Endpoints**: `https://your-app.railway.app/api/*`
- **Frontend Routes**: `https://your-app.railway.app/*` (React handles routing)

## 📱 **What Users Will See:**

1. **Visit your domain** → React frontend loads
2. **Navigate to /booking** → React booking form
3. **Submit booking** → API call to `/api/bookings/create`
4. **Spring Boot processes** → Returns confirmation
5. **React displays** → Success message to user

## 🔍 **Testing Your Deployed App:**

```bash
# Test API endpoint
curl -X POST https://your-app.railway.app/api/bookings/create \
  -H "Content-Type: application/json" \
  -d '{"customerName":"Test","customerEmail":"test@example.com","packageId":1,"selectedDate":"2024-01-15","selectedTime":"10:00"}'

# Test frontend
open https://your-app.railway.app
```

## 🎉 **Benefits of This Setup:**

- **No Port Management** - Railway handles everything
- **Single Domain** - Professional, clean URLs
- **Automatic Scaling** - Railway scales based on traffic
- **Easy Updates** - Deploy both together with one command
- **Production Ready** - Optimized builds and configurations

## 🚨 **Important Notes:**

- **Environment Variables**: Set `SPRING_PROFILES_ACTIVE=railway` in Railway
- **Build Process**: React builds first, then Spring Boot includes it
- **Static Files**: React build gets embedded in Spring Boot JAR
- **CORS**: Configured for production use

## 🔄 **Updating Your App:**

```bash
# Make changes to your code
# Then run:
./railway-deploy.sh
# Or manually:
npm run build && cp -r build/* ../mpt-backend/src/main/resources/static/ && cd ../mpt-backend && railway up
```

Your app will now run as **one unified service** on Railway with no port conflicts! 🎯
