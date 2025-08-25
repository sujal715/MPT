# 🚀 Simple Deployment Guide

## **Option 1: Deploy to Render (Recommended - Free, No Credit Card)**

1. **Go to [render.com](https://render.com)**
2. **Sign up with GitHub** (free)
3. **Click "New +" → "Web Service"**
4. **Connect your GitHub repo**: `sujal715/MPT`
5. **Configure:**
   - **Name**: `mpt-backend`
   - **Environment**: `Java`
   - **Build Command**: `./mvnw clean install`
   - **Start Command**: `java -jar target/mpt-0.0.1-SNAPSHOT.jar`
6. **Click "Create Web Service"**

**Your app will get a public URL like:** `https://mpt-backend.onrender.com`

## **Option 2: Deploy to Railway (Alternative - Free)**

1. **Go to [railway.app](https://railway.app)**
2. **Sign up with GitHub**
3. **Click "New Project" → "Deploy from GitHub repo"**
4. **Select your repo**: `sujal715/MPT`
5. **Railway will auto-detect Java and deploy**

## **Option 3: Use Local IP with Port Forwarding**

1. **Find your public IP:** Go to [whatismyipaddress.com](https://whatismyipaddress.com)
2. **Set up port forwarding** on your router:
   - Forward port 8080 to your computer (192.168.1.4)
3. **Your friend uses:** `http://YOUR_PUBLIC_IP:8080`

## **After Deployment:**

Update your CORS config with the new public URL:

```java
.allowedOrigins(
    "http://localhost:3000",
    "https://your-app-name.onrender.com",  // Add your new URL here
    "https://your-app-name.railway.app"    // Or Railway URL
)
```

## **Why This is Better:**

✅ **Permanent public URL** - no more tunnel issues
✅ **Always accessible** - works 24/7
✅ **No passwords** - completely open
✅ **Professional** - looks like a real production app
✅ **Free forever** - no hidden costs

**Choose Option 1 (Render) - it's the easiest and most reliable!**
