import React from 'react';
import { FaMapMarkerAlt, FaEnvelope, FaPhone, FaPlay, FaComments } from 'react-icons/fa';
import './Home.css';

function Home() {
  return (
    <div className="home-page">
      {/* Hero Section */}
      <section className="hero">
        <div className="hero-content">
          <h1>Unlock Your Potential</h1>
          <p>Achieve optimal mobility, strength, and balance with our personalized training programs tailored to your goals and fitness level.</p>
          <button className="cta-btn">Book Now →</button>
        </div>
      </section>

      {/* MPT Section */}
      <section className="mpt-section">
        <div className="container">
          <div className="mpt-content">
            <div className="mpt-text">
              <h2>MPT</h2>
              <h3>Experience the Thrill of Adventure</h3>
              <p>MPT is Australia's longest-running kitesurfing school, established in 2000. With over 20 years of experience, we've helped thousands of students master the art of kitesurfing. Our instructors are fully qualified and passionate about sharing their knowledge with you.</p>
              <a href="#packages" className="view-packages">View our lesson packages</a>
            </div>
            <div className="mpt-image">
              <img src="https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300&fit=crop" alt="Women on beach with kitesurfing boards" />
            </div>
          </div>
        </div>
      </section>

      {/* Thrill Seekers Section */}
      <section className="thrill-seekers">
        <div className="container">
          <div className="thrill-content">
            <div className="thrill-text">
              <h3>THRILL SEEKERS</h3>
              <h2>Choose your Adventure</h2>
            </div>
            <div className="video-section">
              <button className="book-call-btn">Book a Free Call</button>
              <div className="video-player">
                <img src="https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=500&h=300&fit=crop" alt="Women on jet ski" />
                <div className="play-overlay">
                  <FaPlay />
                </div>
              </div>
              <button className="chat-btn">
                <FaComments />
                <span>CHAT NOW</span>
              </button>
            </div>
          </div>
        </div>
      </section>

      {/* Why Choose Us Section */}
      <section className="why-choose">
        <div className="container">
          <h2>Why Choose Movement performance training</h2>
          <div className="features-grid">
            <div className="feature">
              <div className="feature-image">
                <img src="https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=200&h=200&fit=crop" alt="Man kitesurfing" />
              </div>
              <h3>Experienced Instructors</h3>
              <p>Our instructors are fully qualified and have broad knowledge in water sports. They're passionate about teaching and ensuring you have a safe, enjoyable learning experience.</p>
            </div>
            <div className="feature">
              <div className="feature-image">
                <img src="https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=200&h=200&fit=crop" alt="Woman wakeboarding" />
              </div>
              <h3>Safe and Fun</h3>
              <p>We provide a fun, safe experience with full support and radio headsets. Your safety is our top priority while ensuring you have an amazing time on the water.</p>
            </div>
            <div className="feature">
              <div className="feature-image">
                <img src="https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=200&h=200&fit=crop" alt="Coastal city skyline" />
              </div>
              <h3>Great Locations</h3>
              <p>Experience beautiful locations around the Gold Coast. We operate in some of the most stunning water sports destinations in Australia.</p>
            </div>
          </div>
        </div>
      </section>

      {/* Lessons/Camps Section */}
      <section className="lessons-camps">
        <div className="container">
          <div className="lessons-grid">
            <div className="lesson-card">
              <a href="#kitesurfing">VIEW ALL</a>
              <div className="lesson-image">
                <img src="https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=200&h=200&fit=crop" alt="Kitesurfing" />
              </div>
              <h3>Kitesurfing Lessons</h3>
            </div>
            <div className="lesson-card">
              <a href="#hydrofoil">VIEW ALL</a>
              <div className="lesson-image">
                <img src="https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=200&h=200&fit=crop" alt="Hydrofoil" />
              </div>
              <h3>Hydrofoil Lessons</h3>
            </div>
            <div className="lesson-card">
              <a href="#wingfoil">VIEW ALL</a>
              <div className="lesson-image">
                <img src="https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=200&h=200&fit=crop" alt="Wingfoil" />
              </div>
              <h3>Wingfoil Lessons</h3>
            </div>
            <div className="lesson-card">
              <a href="#camps">VIEW ALL</a>
              <div className="lesson-image">
                <img src="https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=200&h=200&fit=crop" alt="Kite or Foil Camp" />
              </div>
              <h3>Kite or Foil Camp</h3>
            </div>
          </div>
        </div>
      </section>

      {/* Testimonials Section */}
      <section className="testimonials">
        <div className="container">
          <h2>Some of our happy customers</h2>
          <div className="testimonials-grid">
            <div className="testimonial">
              <div className="avatar">
                <img src="https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=100&h=100&fit=crop" alt="Customer" />
              </div>
              <p>im happy</p>
            </div>
            <div className="testimonial">
              <div className="avatar">
                <img src="https://images.unsplash.com/photo-1494790108755-2616b612b786?w=100&h=100&fit=crop" alt="Customer" />
              </div>
              <p>me too</p>
            </div>
            <div className="testimonial">
              <div className="avatar">
                <img src="https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=100&h=100&fit=crop" alt="Customer" />
              </div>
              <p>ola</p>
              <p>comostas</p>
            </div>
            <div className="testimonial">
              <div className="avatar">
                <img src="https://images.unsplash.com/photo-1494790108755-2616b612b786?w=100&h=100&fit=crop" alt="Customer" />
              </div>
              <p>oui</p>
            </div>
          </div>
        </div>
      </section>

      {/* Partners Section */}
      <section className="partners">
        <div className="container">
          <div className="partners-logos">
            <div className="partner-logo">🌊</div>
            <div className="partner-logo">e</div>
            <div className="partner-logo">dika</div>
            <div className="partner-logo">KITEBOARDING AUSTRALIA</div>
          </div>
        </div>
      </section>

      {/* Contact Section */}
      <section className="contact">
        <div className="container">
          <h2>Contact us</h2>
          <div className="contact-content">
            <div className="contact-info">
              <div className="contact-item">
                <FaMapMarkerAlt />
                <span>Eagle Health Club, Burleigh, QLD 4220</span>
              </div>
              <div className="contact-item">
                <FaEnvelope />
                <span>info@movementtraining@icloud.com</span>
              </div>
              <div className="contact-item">
                <FaPhone />
                <span>04 99 471 101</span>
              </div>
            </div>
            <div className="contact-form">
              <form>
                <div className="form-row">
                  <input type="text" placeholder="First Name" />
                  <input type="text" placeholder="Last Name" />
                </div>
                <input type="email" placeholder="Email" />
                <textarea placeholder="Message"></textarea>
                <button type="submit" className="submit-btn">Submit</button>
              </form>
            </div>
          </div>
        </div>
      </section>

      {/* Newsletter Section */}
      <section className="newsletter">
        <div className="container">
          <h2>Sign up to our Newsletter</h2>
          <form className="newsletter-form">
            <input type="email" placeholder="Email" />
            <button type="submit">Submit</button>
          </form>
        </div>
      </section>
    </div>
  );
}

export default Home; 