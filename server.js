const express = require('express');
const cors = require('cors');

const app = express();

// Middleware
app.use(cors());
app.use(express.json());

// Health check
app.get('/api/health', (req, res) => {
  res.json({ 
    status: 'OK', 
    message: 'MPT Clean API is running',
    timestamp: new Date().toISOString()
  });
});

// Simple HTML page
app.get('/', (req, res) => {
  res.send(`
    <!DOCTYPE html>
    <html>
    <head>
      <title>MPT Clean - Railway Test</title>
      <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .success { color: green; font-weight: bold; }
      </style>
    </head>
    <body>
      <h1>🎉 MPT Clean App</h1>
      <p class="success">✅ Successfully deployed on Railway!</p>
      <p>This is a minimal test deployment to verify Railway works.</p>
      <p><a href="/api/health">Check API Health</a></p>
    </body>
    </html>
  `);
});

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
  console.log(`🚀 MPT Clean app running on port ${PORT}`);
  console.log(`🌐 Frontend: http://localhost:${PORT}`);
  console.log(`🔗 API: http://localhost:${PORT}/api/health`);
});
