#!/bin/bash

echo "🚀 Deploying MPT Spring Boot Backend to Heroku!"
echo "=================================================="

# Check if we're in the right directory
if [ ! -f "pom.xml" ]; then
    echo "❌ Error: pom.xml not found. Please run this script from the mpt directory."
    exit 1
fi

echo "📦 Building Spring Boot application..."
./mvnw clean package -DskipTests

if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    echo ""
    echo "🚀 Creating Heroku app..."
    
    # Create Heroku app
    heroku create mpt-backend-$(date +%s)
    
    echo ""
    echo "🔧 Setting Heroku environment variables..."
    heroku config:set SPRING_PROFILES_ACTIVE=heroku
    
    echo ""
    echo "🚂 Deploying to Heroku..."
    git add .
    git commit -m "Deploy Spring Boot backend to Heroku"
    git push heroku master
    
    echo ""
    echo "🎉 Your Spring Boot backend is now deployed to Heroku!"
    echo "🌐 Backend URL: https://your-app-name.herokuapp.com"
    echo "🗄️  H2 Console: https://your-app-name.herokuapp.com/h2-console"
    echo "🔌 API base: https://your-app-name.herokuapp.com/api"
    
else
    echo "❌ Build failed! Please check the errors above."
    exit 1
fi
