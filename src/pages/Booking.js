import React, { useState } from 'react';
import './Booking.css';

const Booking = () => {
  const [selectedTime, setSelectedTime] = useState('20:00');
  const [selectedDate, setSelectedDate] = useState(new Date());
  const [isAM, setIsAM] = useState(false);

  const handleTimeChange = (newTime) => {
    setSelectedTime(newTime);
  };

  const handleDateSelect = (date) => {
    setSelectedDate(date);
  };

  const handleBooking = () => {
    // Handle booking logic here
    alert('Booking functionality would be implemented here');
  };

  return (
    <div className="booking-page">
      <div className="booking-container">
        {/* Left Side - Consultation Details */}
        <div className="consultation-details">
          <h1>Book your free 15-minute consultation.</h1>
          <h2>Your First Step to Better Performance on the Water! 🌊</h2>
          
          <p className="consultation-intro">
            In this quick, personalized 15-minute consultation, we'll dive into your kitesurfing or wing foiling goals and assess your current mobility, strength, and balance. Here's what you can expect:
          </p>
          
          <ul className="consultation-benefits">
            <li>
              <strong>Personalized Assessment</strong> – We'll discuss any challenges you're facing, from flexibility to injury concerns, and pinpoint key areas for improvement.
            </li>
            <li>
              <strong>Goal Setting</strong> – Together, we'll outline specific goals that will enhance your performance, whether it's boosting your stamina or perfecting your technique.
            </li>
            <li>
              <strong>Actionable Next Steps</strong> – Leave with clear, tailored advice on how to kickstart your training journey, with exercises or programs that fit your lifestyle.
            </li>
          </ul>
          
          <p className="consultation-conclusion">
            This is your opportunity to ask questions and learn how our expert training can help you maximize your potential. Let's take the first step together toward becoming stronger, more flexible, and unstoppable on the water! 🏄‍♀️💪
          </p>
          
          <p className="cta-text">
            Book your free 15-minute consultation now!
          </p>
        </div>

        {/* Right Side - Booking Widget */}
        <div className="booking-widget">
          {/* Time Selection */}
          <div className="time-selection">
            <div className="time-display">
              <span className="clock-icon">🕐</span>
              <span className="time-value">{selectedTime}</span>
            </div>
            <div className="am-pm-buttons">
              <button 
                className={`am-pm-btn ${!isAM ? 'active' : ''}`}
                onClick={() => setIsAM(false)}
              >
                AM
              </button>
              <button 
                className={`am-pm-btn ${isAM ? 'active' : ''}`}
                onClick={() => setIsAM(true)}
              >
                PM
              </button>
            </div>
            <div className="time-controls">
              <button className="time-btn">Minute</button>
              <button className="time-btn">Cancel</button>
              <button className="time-btn">OK</button>
            </div>
          </div>

          {/* Meet with Chloe */}
          <div className="meet-chloe">
            <div className="chloe-profile">
              <div className="chloe-avatar">👩‍🦰</div>
              <h3>Meet with Chloe Barre</h3>
            </div>
          </div>

          {/* Calendar */}
          <div className="calendar-section">
            <div className="calendar-header">
              <button className="calendar-nav">◀</button>
              <h4>May 2025</h4>
              <button className="calendar-nav">▶</button>
            </div>
            <div className="calendar-grid">
              <div className="calendar-days">
                <span>SUN</span>
                <span>MON</span>
                <span>TUE</span>
                <span>WED</span>
                <span>THU</span>
                <span>FRI</span>
                <span>SAT</span>
              </div>
              <div className="calendar-dates">
                {/* Calendar dates would be generated dynamically */}
                <span className="date faded">1</span>
                <span className="date faded">2</span>
                <span className="date faded">3</span>
                <span className="date">4</span>
                <span className="date">5</span>
                <span className="date">6</span>
                <span className="date">7</span>
                <span className="date">8</span>
                <span className="date">9</span>
                <span className="date">10</span>
                <span className="date">11</span>
                <span className="date">12</span>
                <span className="date">13</span>
                <span className="date">14</span>
                <span className="date">15</span>
                <span className="date">16</span>
                <span className="date">17</span>
                <span className="date">18</span>
                <span className="date">19</span>
                <span className="date">20</span>
                <span className="date">21</span>
                <span className="date">22</span>
                <span className="date">23</span>
                <span className="date">24</span>
                <span className="date">25</span>
                <span className="date">26</span>
                <span className="date">27</span>
                <span className="date">28</span>
                <span className="date">29</span>
                <span className="date">30</span>
                <span className="date">31</span>
              </div>
            </div>
          </div>

          {/* Book Now Button */}
          <button className="book-now-btn" onClick={handleBooking}>
            Book Now →
          </button>
        </div>
      </div>
    </div>
  );
};

export default Booking; 