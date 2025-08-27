#!/bin/bash

echo "🚀 Deploying MPT Full Stack Application to Render..."
echo "=================================================="

# Deploy Backend First
echo ""
echo "📱 Step 1: Deploying Backend..."
./deploy-backend.sh

if [ $? -ne 0 ]; then
    echo "❌ Backend deployment failed! Stopping..."
    exit 1
fi

echo ""
echo "⏳ Waiting for backend to be ready..."
sleep 30

# Deploy Frontend
echo ""
echo "🌐 Step 2: Deploying Frontend..."
./deploy-frontend.sh

if [ $? -ne 0 ]; then
    echo "❌ Frontend deployment failed!"
    exit 1
fi

echo ""
echo "🎉 Full Stack Deployment Complete!"
echo "=================================="
echo "🔗 Backend: https://mpt-backend.onrender.com"
echo "🌐 Frontend: https://mpt-frontend.onrender.com"
echo ""
echo "📱 Your MPT application is now live!"
echo "💡 Check your Render dashboard for deployment status"
