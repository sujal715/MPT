const express = require('express');
const router = express.Router();

// Basic services routes
router.get('/', (req, res) => {
  res.json({ message: 'Services endpoint - to be implemented' });
});

module.exports = router;
