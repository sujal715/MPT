# 🚀 Manual Deployment to Render - Step by Step

Since the Render CLI had issues, here's how to deploy manually:

## 📱 Step 1: Deploy Backend (Spring Boot)

### 1. Go to Render Dashboard
- Visit: https://dashboard.render.com/
- Sign in to your account

### 2. Create New Service
- Click **"New +"** button
- Select **"Web Service"**

### 3. Connect Repository
- Connect your GitHub repository
- Select the **MpT** repository
- Choose the **main** branch

### 4. Configure Backend Service
- **Name**: `mpt-backend`
- **Environment**: `Java`
- **Build Command**: `./mvnw clean package -DskipTests`
- **Start Command**: `java -jar target/mpt-0.0.1-SNAPSHOT.jar`

### 5. Environment Variables
Add these environment variables:
- **Key**: `SPRING_PROFILES_ACTIVE` → **Value**: `render`
- **Key**: `JAVA_VERSION` → **Value**: `17`

### 6. Deploy
- Click **"Create Web Service"**
- Wait for build and deployment (5-10 minutes)

---

## 🌐 Step 2: Deploy Frontend (React)

### 1. Create Another Service
- Click **"New +"** button again
- Select **"Static Site"**

### 2. Connect Same Repository
- Connect the same **MpT** repository
- Select **main** branch

### 3. Configure Frontend Service
- **Name**: `mpt-frontend`
- **Build Command**: `cd frontend && npm install && npm run build`
- **Publish Directory**: `frontend/build`

### 4. Environment Variables
Add this environment variable:
- **Key**: `REACT_APP_API_URL` → **Value**: `https://mpt-backend.onrender.com`

### 5. Deploy
- Click **"Create Static Site"**
- Wait for build and deployment (3-5 minutes)

---

## 🔗 Your URLs After Deployment

- **Backend API**: `https://mpt-backend.onrender.com`
- **Frontend App**: `https://mpt-frontend.onrender.com`

## ✅ Verification Steps

### Test Backend
```bash
curl https://mpt-backend.onrender.com/api/health
```

### Test Frontend
- Visit: `https://mpt-frontend.onrender.com`
- Should load your React app

## 🚨 If You Get Errors

### Backend Issues
- Check build logs in Render dashboard
- Ensure Java 17 is selected
- Verify build command is correct

### Frontend Issues
- Check build logs
- Ensure `cd frontend` is in build command
- Verify publish directory is `frontend/build`

## 🎯 Alternative: Use render.yaml Files

If you prefer, you can also:
1. Push your code to GitHub
2. In Render dashboard, select "Blueprint" 
3. Upload your `render.yaml` files
4. Render will auto-configure everything

---

**🎉 After following these steps, your MPT application will be live on Render!**
