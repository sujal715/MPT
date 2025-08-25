# 🚀 MPT Full-Stack Railway Deployment Guide

## **Overview**
This guide will help you deploy your **complete Movement Performance Training (MPT) app** to Railway as a **full-stack application** - both backend AND frontend together!

## **🎯 What You Get**
- ✅ **Single URL** for your entire app
- ✅ **Backend API** running on the same domain
- ✅ **React Frontend** served by the backend
- ✅ **Automatic scaling** and monitoring
- ✅ **Easy deployment** from GitHub

## **Project Structure**
- **Frontend**: React app (React 19, React Router)
- **Backend**: Node.js/Express API
- **Database**: MongoDB (to be configured)
- **Deployment**: Single Railway project for everything

## **🚀 Step 1: Prepare Your Repository**

### **1.1 Run Full-Stack Deployment Script**
```bash
./deploy-fullstack.sh
```

### **1.2 Verify Files (Script will check these)**
- `railway.json` ✅ - Full-stack Railway configuration
- `railway.toml` ✅ - Railway deployment settings
- `package.json` ✅ - Full-stack build scripts
- `backend/` directory with all routes ✅

## **🚀 Step 2: Deploy to Railway**

### **2.1 Connect to Railway**
1. Go to [Railway Dashboard](https://railway.app/dashboard)
2. Click "New Project"
3. Select "Deploy from GitHub repo"
4. Choose your MPT repository

### **2.2 Railway Auto-Detection**
Railway will automatically:
- ✅ Detect your `railway.json` configuration
- ✅ Build both frontend and backend
- ✅ Deploy as a single full-stack app

### **2.3 Configure Environment Variables**
In Railway, set these environment variables:

```env
NODE_ENV=production
PORT=5000
MONGODB_URI=your-mongodb-connection-string
JWT_SECRET=your-super-secret-jwt-key-here
```

## **🚀 Step 3: How Full-Stack Works**

### **3.1 Build Process**
```bash
npm run build:fullstack
# 1. Builds React frontend (creates /build folder)
# 2. Installs backend dependencies
```

### **3.2 Runtime Process**
```bash
npm run start:fullstack
# 1. Starts Node.js backend server
# 2. Serves React frontend from backend
# 3. Single port, single URL for everything
```

### **3.3 URL Structure**
- **Frontend**: `https://your-app.railway.app`
- **Backend API**: `https://your-app.railway.app/api`
- **Health Check**: `https://your-app.railway.app/api/health`

## **🚀 Step 4: Test Your Full-Stack App**

### **4.1 Health Check**
Visit: `https://your-app.railway.app/api/health`
Should return: `{"status":"OK","message":"Movement Performance Training API is running"}`

### **4.2 Frontend**
Visit: `https://your-app.railway.app`
Should show your React MPT app

### **4.3 API Endpoints**
- `/api/auth` - Authentication
- `/api/gallery` - Gallery management
- `/api/services` - Services
- `/api/testimonials` - Testimonials
- `/api/bookings` - Booking system
- `/api/admin` - Admin panel

## **🚀 Step 5: Database Setup**

### **5.1 MongoDB Atlas (Recommended)**
1. Create free MongoDB Atlas account
2. Create new cluster
3. Get connection string
4. Add to Railway environment variables

### **5.2 Railway MongoDB (Alternative)**
1. Add MongoDB plugin in Railway
2. Railway will provide connection string
3. Add to environment variables

## **🔧 Troubleshooting**

### **Build Errors**
- Check `railway.json` syntax
- Verify all dependencies in both package.json files
- Check Node.js version compatibility

### **Runtime Errors**
- Check environment variables
- Verify MongoDB connection
- Check Railway logs

### **Frontend Not Loading**
- Verify React build completed successfully
- Check backend is serving static files
- Verify routing configuration

## **📱 Current Status**
- ✅ Full-stack configuration ready
- ✅ Backend routes created
- ✅ Railway configuration updated
- ✅ Deployment scripts ready
- 🔄 Ready for full-stack Railway deployment

## **🎯 Next Steps**
1. **Run deployment script**: `./deploy-fullstack.sh`
2. **Deploy to Railway** using this guide
3. **Set up MongoDB** database
4. **Configure environment variables**
5. **Test complete full-stack app**

## **💡 Benefits of Full-Stack Deployment**
- **Single URL** - No CORS issues
- **Easier management** - One project, one deployment
- **Better performance** - Frontend served from backend
- **Simplified scaling** - Railway handles everything
- **Cost effective** - Single service instead of two

## **🚀 Ready to Deploy?**

**Run this command to deploy everything together:**
```bash
./deploy-fullstack.sh
```

---

**Your MPT app will be a complete full-stack application running on Railway with a single URL! 🎉**
