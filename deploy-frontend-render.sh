#!/bin/bash

echo "🚀 Deploying MPT React Frontend to Render!"
echo "============================================="

# Check if we're in the right directory
if [ ! -f "package.json" ]; then
    echo "❌ Error: package.json not found. Please run this script from the mpt directory."
    exit 1
fi

echo "📦 Installing React dependencies..."
npm install

if [ $? -eq 0 ]; then
    echo "✅ Dependencies installed successfully!"
    echo ""
    echo "🔨 Building React application..."
    npm run build
    
    if [ $? -eq 0 ]; then
        echo "✅ Build successful!"
        echo ""
        echo "🚀 Your React frontend is ready for Render deployment!"
        echo ""
        echo "🌐 To deploy to Render:"
        echo "1. Go to: https://render.com"
        echo "2. Sign up/Login with GitHub"
        echo "3. Click 'New +' → 'Web Service'"
        echo "4. Connect your GitHub repository"
        echo "5. Select this 'mpt' repository"
        echo "6. Render will auto-detect it's a React app"
        echo "7. Click 'Create Web Service'"
        echo ""
        echo "✅ Render will automatically:"
        echo "   - Install Node.js"
        echo "   - Install dependencies (npm install)"
        echo "   - Build your app (npm run build)"
        echo "   - Start your app (npm start)"
        echo "   - Give you a live URL!"
        echo ""
        echo "🎯 Your frontend will be available at:"
        echo "   - Main App: https://your-app-name.onrender.com"
        echo "   - All your React pages and components!"
        echo ""
        echo "🚀 Ready to deploy! Go to https://render.com now!"
        
    else
        echo "❌ Build failed! Please check the errors above."
        exit 1
    fi
    
else
    echo "❌ Dependencies installation failed! Please check the errors above."
    exit 1
fi
