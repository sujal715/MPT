# 🚀 MPT Railway Deployment - Simple Guide

## **What We're Building**
A **full-stack app** where both your React frontend and Node.js backend run together on Railway.

## **🚀 Step 1: Deploy to Railway**

### **Option A: Use the Script (Recommended)**
```bash
./deploy.sh
```

### **Option B: Manual Steps**
1. **Commit your changes:**
   ```bash
   git add .
   git commit -m "Ready for Railway deployment"
   git push origin main
   ```

2. **Go to Railway:**
   - Visit: https://railway.app/dashboard
   - Click "New Project"
   - Select "Deploy from GitHub repo"
   - Choose your MPT repository

## **🚀 Step 2: Railway Will Automatically**
- ✅ Detect your `railway.json` configuration
- ✅ Build your React frontend
- ✅ Install backend dependencies
- ✅ Deploy everything together
- ✅ Give you a live URL

## **🚀 Step 3: Get Your Link**
After deployment, Railway will give you:
- **Your app URL**: `https://your-app-name.railway.app`
- **Frontend**: Same URL (React app)
- **Backend API**: `https://your-app-name.railway.app/api`
- **Health check**: `https://your-app-name.railway.app/api/health`

## **🔧 Environment Variables (Optional)**
In Railway dashboard, you can set:
```env
NODE_ENV=production
MONGODB_URI=your-mongodb-connection
JWT_SECRET=your-secret-key
```

## **🎯 Result**
- **Single URL** for your entire app
- **No CORS issues** (frontend and backend on same domain)
- **Easy management** (one project)
- **Automatic scaling** (Railway handles everything)

## **💡 Pro Tip**
The easiest way is to just run:
```bash
./deploy.sh
```

This will do everything for you!

---

**Ready to deploy? Run `./deploy.sh` and your MPT app will be live on Railway! 🎉**
