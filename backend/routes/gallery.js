const express = require('express');
const router = express.Router();

// Basic gallery routes
router.get('/', (req, res) => {
  res.json({ message: 'Gallery endpoint - to be implemented' });
});

module.exports = router;
