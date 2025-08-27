# 🚀 Automated Deployment to Render - GitHub Actions

Since the Render CLI had issues, I've created a **GitHub Actions workflow** that will automatically deploy your app every time you push to GitHub!

## 🎯 What This Does

✅ **Automatically builds** your Spring Boot backend  
✅ **Automatically builds** your React frontend  
✅ **Automatically deploys** both to Render  
✅ **No manual work** needed after setup  

## 📋 Setup Steps (One Time Only)

### Step 1: Push Your Code to GitHub
```bash
# If you haven't already, initialize git and push
git init
git add .
git commit -m "Initial commit - MPT full stack app"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/MpT.git
git push -u origin main
```

### Step 2: Get Render API Key
1. Go to https://dashboard.render.com/
2. Click your profile → **Account Settings**
3. Go to **API Keys** tab
4. Click **"New API Key"**
5. Copy the API key (keep it secret!)

### Step 3: Create Services on Render (One Time)

#### Create Backend Service:
1. **New +** → **Web Service**
2. **Connect** your GitHub repo
3. **Name**: `mpt-backend`
4. **Environment**: `Java`
5. **Build Command**: `./mvnw clean package -DskipTests`
6. **Start Command**: `java -jar target/mpt-0.0.1-SNAPSHOT.jar`
7. **Create** the service
8. **Copy the Service ID** from the URL (looks like: `srv-abc123...`)

#### Create Frontend Service:
1. **New +** → **Static Site**
2. **Connect** same GitHub repo
3. **Name**: `mpt-frontend`
4. **Build Command**: `cd frontend && npm install && npm run build`
5. **Publish Directory**: `frontend/build`
6. **Create** the service
7. **Copy the Service ID** from the URL

### Step 4: Add GitHub Secrets
1. Go to your GitHub repo
2. **Settings** → **Secrets and variables** → **Actions**
3. Add these secrets:
   - **Name**: `RENDER_API_KEY` → **Value**: Your API key from Step 2
   - **Name**: `RENDER_BACKEND_SERVICE_ID` → **Value**: Backend service ID
   - **Name**: `RENDER_FRONTEND_SERVICE_ID` → **Value**: Frontend service ID

## 🚀 Deploy!

### Option 1: Automatic (Recommended)
- **Just push to GitHub!** The workflow runs automatically
- Every time you push to `main` branch, it deploys

### Option 2: Manual Trigger
- Go to **Actions** tab in your GitHub repo
- Click **"Deploy to Render"**
- Click **"Run workflow"**

## 📱 What Happens

1. **GitHub Actions** builds your backend
2. **Deploys backend** to Render
3. **Builds your frontend**
4. **Deploys frontend** to Render
5. **Both services** are live and connected!

## 🔗 Your URLs

- **Backend**: `https://mpt-backend.onrender.com`
- **Frontend**: `https://mpt-frontend.onrender.com`

## ✅ Verification

### Test Backend:
```bash
curl https://mpt-backend.onrender.com/api/health
```

### Test Frontend:
- Visit: `https://mpt-frontend.onrender.com`
- Should load your React app

## 🚨 Troubleshooting

### If Backend Fails:
- Check **Actions** tab for build logs
- Verify **Service ID** is correct
- Ensure **API Key** has proper permissions

### If Frontend Fails:
- Check build logs in **Actions** tab
- Verify **Service ID** is correct
- Check if `cd frontend` is in build command

## 🎉 Benefits of This Approach

- ✅ **Fully automated** - no manual deployment needed
- ✅ **Reliable** - GitHub Actions is very stable
- ✅ **Version controlled** - deployment tied to your code
- ✅ **Easy rollback** - just revert a commit
- ✅ **No CLI issues** - everything runs in GitHub's environment

---

**🎯 After following these steps, your MPT app will automatically deploy every time you push code!**
