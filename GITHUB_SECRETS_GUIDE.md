# 🔐 How to Add GitHub Secrets - Step by Step

## 🎯 **What You Need to Add:**

| Secret Name | Value |
|-------------|-------|
| `RENDER_API_KEY` | Your Render API key |
| `RENDER_BACKEND_SERVICE_ID` | `srv-d2n7kmf5r7bs73f77q70` |
| `RENDER_FRONTEND_SERVICE_ID` | `srv-d2n83l75r7bs73f7pue0` |

---

## 📋 **Step-by-Step Instructions:**

### **Step 1: Go to GitHub Secrets Page**
1. Open: https://github.com/sujal715/MPT
2. Click **"Settings"** tab (near the top)
3. In the left sidebar, click **"Secrets and variables"**
4. Click **"Actions"**

### **Step 2: Add First Secret (RENDER_API_KEY)**
1. Click **"New repository secret"** button
2. **Name**: Type `RENDER_API_KEY` (exactly like this)
3. **Value**: Paste your Render API key
4. Click **"Add secret"**

### **Step 3: Add Second Secret (RENDER_BACKEND_SERVICE_ID)**
1. Click **"New repository secret"** button again
2. **Name**: Type `RENDER_BACKEND_SERVICE_ID`
3. **Value**: Type `srv-d2n7kmf5r7bs73f77q70`
4. Click **"Add secret"**

### **Step 4: Add Third Secret (RENDER_FRONTEND_SERVICE_ID)**
1. Click **"New repository secret"** button again
2. **Name**: Type `RENDER_FRONTEND_SERVICE_ID`
3. **Value**: Type `srv-d2n83l75r7bs73f7pue0`
4. Click **"Add secret"**

---

## 🔑 **How to Get Your Render API Key:**

### **Option 1: From Render Dashboard**
1. Go to: https://dashboard.render.com/
2. Click your **profile picture** (top right)
3. Click **"Account Settings"**
4. Click **"API Keys"** tab
5. Click **"New API Key"**
6. Give it a name (e.g., "MPT Deployment")
7. Click **"Create API Key"**
8. **Copy the key** (it looks like: `rnd_abc123...`)

### **Option 2: Quick Link**
- Direct link: https://dashboard.render.com/account/api-keys

---

## ✅ **Verification:**

After adding all 3 secrets, you should see:
- `RENDER_API_KEY` (with a value)
- `RENDER_BACKEND_SERVICE_ID` (with value: srv-d2n7kmf5r7bs73f77q70)
- `RENDER_FRONTEND_SERVICE_ID` (with value: srv-d2n83l75r7bs73f7pue0)

---

## 🚀 **After Adding Secrets:**

1. **Test the deployment** by making a small change
2. **Push to GitHub**: `git push origin main`
3. **Check GitHub Actions**: https://github.com/sujal715/MPT/actions
4. **Watch your services** update automatically on Render!

---

## 🎉 **Result:**

- **Every `git push`** = automatic deployment
- **Your MPT app** stays updated automatically
- **No more manual deployment** needed
- **Professional deployment pipeline** active!

---

## 🆘 **Need Help?**

- **GitHub Actions**: https://github.com/sujal715/MPT/actions
- **Render Dashboard**: https://dashboard.render.com/
- **Your Services**: 
  - Backend: https://mpt.onrender.com
  - Frontend: https://mpt-1.onrender.com
