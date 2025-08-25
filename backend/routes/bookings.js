const express = require('express');
const router = express.Router();

// Basic bookings routes
router.get('/', (req, res) => {
  res.json({ message: 'Bookings endpoint - to be implemented' });
});

router.post('/', (req, res) => {
  res.json({ message: 'Create booking endpoint - to be implemented' });
});

module.exports = router;
