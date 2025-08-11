import React from 'react';
import './Resources.css';

function Resources() {
  return (
    <div className="resources-page">
      {/* Hero Section */}
      <section className="resources-hero">
        <div className="hero-content">
          <h1>Resources</h1>
          <p>Helpful guides, tips, and information to enhance your water sports journey and improve your skills.</p>
        </div>
      </section>

      {/* Safety Guides */}
      <section className="resources-section">
        <div className="container">
          <h2>Safety Guides</h2>
          <div className="resources-grid">
            <div className="resource-card">
              <h3>Kitesurfing Safety</h3>
              <p>Essential safety guidelines for kitesurfing, including weather conditions, equipment checks, and emergency procedures.</p>
              <button className="resource-btn">Download Guide</button>
            </div>
            <div className="resource-card">
              <h3>Hydrofoil Safety</h3>
              <p>Safety protocols for hydrofoiling, including foil handling, launch techniques, and emergency procedures.</p>
              <button className="resource-btn">Download Guide</button>
            </div>
            <div className="resource-card">
              <h3>Wing Foil Safety</h3>
              <p>Comprehensive safety guide for wing foiling, covering wing control, foil safety, and rescue procedures.</p>
              <button className="resource-btn">Download Guide</button>
            </div>
          </div>
        </div>
      </section>

      {/* Tips & Tricks */}
      <section className="tips-section">
        <div className="container">
          <h2>Tips & Tricks</h2>
          <div className="tips-grid">
            <div className="tip-card">
              <h3>Beginner Tips</h3>
              <ul>
                <li>Start with proper instruction</li>
                <li>Practice kite control on land</li>
                <li>Always check weather conditions</li>
                <li>Use appropriate safety gear</li>
              </ul>
            </div>
            <div className="tip-card">
              <h3>Advanced Techniques</h3>
              <ul>
                <li>Master wave riding</li>
                <li>Perfect your jumps</li>
                <li>Learn advanced maneuvers</li>
                <li>Improve board control</li>
              </ul>
            </div>
            <div className="tip-card">
              <h3>Equipment Care</h3>
              <ul>
                <li>Regular equipment inspection</li>
                <li>Proper storage techniques</li>
                <li>Maintenance schedules</li>
                <li>Repair best practices</li>
              </ul>
            </div>
          </div>
        </div>
      </section>

      {/* Weather Information */}
      <section className="weather-section">
        <div className="container">
          <h2>Weather & Conditions</h2>
          <div className="weather-content">
            <div className="weather-info">
              <h3>Best Conditions</h3>
              <p>Learn about optimal weather conditions for different water sports activities.</p>
              <ul>
                <li>Wind speed and direction</li>
                <li>Wave conditions</li>
                <li>Temperature considerations</li>
                <li>Seasonal variations</li>
              </ul>
            </div>
            <div className="weather-widget">
              <h3>Current Conditions</h3>
              <div className="weather-display">
                <p>Check our live weather feed for real-time conditions</p>
                <button className="weather-btn">View Live Weather</button>
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* FAQ Section */}
      <section className="faq-section">
        <div className="container">
          <h2>Frequently Asked Questions</h2>
          <div className="faq-grid">
            <div className="faq-item">
              <h3>What equipment do I need to start?</h3>
              <p>We provide all necessary equipment for beginners. As you progress, you may want to invest in your own gear.</p>
            </div>
            <div className="faq-item">
              <h3>How long does it take to learn?</h3>
              <p>Most students see significant progress within 5-10 lessons, depending on their athletic background and dedication.</p>
            </div>
            <div className="faq-item">
              <h3>What age can you start?</h3>
              <p>We offer programs for ages 12 and up, with special youth programs designed for younger athletes.</p>
            </div>
            <div className="faq-item">
              <h3>Do you offer group lessons?</h3>
              <p>Yes, we offer both private and group lessons. Group lessons are great for friends and families.</p>
            </div>
          </div>
        </div>
      </section>

      {/* Contact Information */}
      <section className="contact-resources">
        <div className="container">
          <h2>Need More Information?</h2>
          <p>Contact our team for personalized advice and recommendations.</p>
          <button className="contact-btn">Get in Touch</button>
        </div>
      </section>
    </div>
  );
}

export default Resources; 