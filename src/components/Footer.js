import React from 'react';
import { Link } from 'react-router-dom';
import './Footer.css';

const Footer = () => {
  return (
    <footer className="footer">
      {/* Social Media Top Section */}
      <div className="social-media-top">
        <div className="social-icons">
          <a href="#" className="social-icon facebook">f</a>
          <a href="#" className="social-icon linkedin">in</a>
          <a href="#" className="social-icon twitter">🐦</a>
          <a href="#" className="social-icon instagram">📷</a>
        </div>
      </div>

      <div className="footer-content">
        <div className="footer-section">
          <div className="footer-logo">
            <div className="footer-logo-icon">🌊</div>
            <div className="footer-logo-text">
              Movement Performance Training
            </div>
          </div>
          <div className="tripadvisor-badge">
            2021 Travellers' Choice Tripadvisor
          </div>
        </div>

        <div className="footer-section">
          <h3>GET IN TOUCH</h3>
          <div className="contact-info">
            <div className="contact-item">
              <span className="contact-icon">📍</span>
              <span>Ezyfit Health Club, Birtinya, QLD 4575</span>
            </div>
            <div className="contact-item">
              <span className="contact-icon">📞</span>
              <span>0404 445 000</span>
            </div>
            <div className="contact-item">
              <span className="contact-icon">✉️</span>
              <span>info@goldcoastwatersports.com.au</span>
            </div>
            <div className="contact-item">
              <span className="contact-icon">🕒</span>
              <span>Mon-Sun: 08:00-18:00</span>
            </div>
          </div>
        </div>

        <div className="footer-section">
          <h3>USEFUL LINKS</h3>
          <div className="footer-links">
            <Link to="/">Home</Link>
            <Link to="/products">Products/Packages</Link>
            <Link to="/about">About Us</Link>
            <Link to="/resources">Blog</Link>
            <Link to="/services">Services</Link>
            <Link to="/privacy">Privacy Policies</Link>
            <Link to="/faqs">FAQs</Link>
          </div>
        </div>

        <div className="footer-section">
          <h3>FOLLOW US</h3>
          <div className="footer-social">
            <a href="#" className="footer-social-icon">f</a>
            <a href="#" className="footer-social-icon">📷</a>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer; 