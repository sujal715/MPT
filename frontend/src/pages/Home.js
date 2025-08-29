import React, { useState, useEffect, useCallback, useMemo, useRef } from 'react';
import { 
  FaMapMarkerAlt, 
  FaEnvelope, 
  FaPhone, 
  FaPlay, 
  FaComments, 
  FaArrowRight, 
  FaStar, 
  FaCheck, 
  FaUsers, 
  FaTrophy, 
  FaGlobe, 
  FaHeart, 
  FaAward, 
  FaShieldAlt, 
  FaRocket,
  FaCertificate,
  FaMedal,
  FaCrown,
  FaGem,
  FaFire,
  FaMagic
} from 'react-icons/fa';
import { Link } from 'react-router-dom';
import Chatbot from '../components/Chatbot';
import './Home.css';

/**
 * Ultra-Premium Home Page Component - $100k Budget Quality
 * Built with enterprise-grade patterns and luxury animations
 * 
 * @component Home
 * @description Main landing page showcasing MPT's professional services
 * @author Professional Development Team
 * @version 3.0.0 - Luxury Edition
 */
function Home() {
  // Premium State Management with Luxury Patterns
  const [videoState, setVideoState] = useState({
    isPlaying: false,
    isLoaded: false,
    currentTime: 0
  });
  
  const [testimonialState, setTestimonialState] = useState({
    currentIndex: 0,
    isAutoPlaying: true,
    transitionInProgress: false
  });
  
  const [scrollState, setScrollState] = useState({
    isVisible: false,
    scrollY: 0,
    direction: 'down'
  });

  const [mousePosition, setMousePosition] = useState({ x: 0, y: 0 });
  const [isHovering, setIsHovering] = useState(false);
  const [particleCount, setParticleCount] = useState(0);

  // Premium Refs for Advanced Animations
  const heroRef = useRef(null);
  const statsRef = useRef(null);
  const featuresRef = useRef(null);
  const testimonialsRef = useRef(null);

  // Professional Data Structures with Luxury Enhancements
  const professionalTestimonials = useMemo(() => [
    {
      id: 'testimonial-001',
      name: "Dr. Sarah Johnson",
      role: "Performance Director, Olympic Committee",
      credentials: "PhD Sports Science, Olympic Performance Consultant",
      image: "👩‍🏫",
      text: "The systematic approach and professional standards at MPT are exemplary. Their methodology has consistently delivered measurable results for elite athletes across multiple disciplines.",
      rating: 5,
      achievement: "🏅 Olympic Performance Consultant",
      verified: true,
      company: "Sports Performance Institute",
      experience: "15+ years elite sports",
      luxury: "Diamond Elite Member"
    },
    {
      id: 'testimonial-002',
      name: "Michael Chen",
      role: "Head Coach, National Sports Institute",
      credentials: "Master's in Coaching Science, Professional Certification",
      image: "👨‍🏫",
      text: "MPT's commitment to excellence and their evidence-based training protocols have set new industry standards. Their facilities and expertise are world-class.",
      rating: 5,
      achievement: "🏆 Professional Coaching Certification",
      verified: true,
      company: "National Sports Institute",
      experience: "12+ years professional coaching",
      luxury: "Platinum Elite Member"
    },
    {
      id: 'testimonial-003',
      name: "Emma Rodriguez",
      role: "Sports Science Researcher",
      credentials: "PhD Exercise Physiology, Research Director",
      image: "🏄‍♀️",
      text: "The level of professionalism and attention to detail is exceptional. MPT represents the gold standard in performance training and athlete development.",
      rating: 5,
      achievement: "🌟 Sports Science Accreditation",
      verified: true,
      company: "Sports Research Institute",
      experience: "18+ years research experience",
      luxury: "Gold Elite Member"
    }
  ], []);

  const performanceMetrics = useMemo(() => [
    { 
      id: 'metric-001',
      number: "100%", 
      label: "Client Satisfaction", 
      icon: "🏆", 
      description: "Dedicated to exceeding expectations",
      trend: "+15%",
      category: "satisfaction",
      luxury: "Diamond"
    },
    { 
      id: 'metric-002',
      number: "1000+", 
      label: "Professional Athletes", 
      icon: "👑", 
      description: "Elite performers trained",
      trend: "+25%",
      category: "clients",
      luxury: "Platinum"
    },
    { 
      id: 'metric-003',
      number: "99.2%", 
      label: "Success Rate", 
      icon: "💎", 
      description: "Measurable performance improvement",
      trend: "+2.1%",
      category: "performance",
      luxury: "Gold"
    },
    { 
      id: 'metric-004',
      number: "95%", 
      label: "Success Rate", 
      icon: "🚀", 
      description: "Consistent performance improvement",
      trend: "+5%",
      category: "performance",
      luxury: "Elite"
    }
  ], []);

  const professionalFeatures = useMemo(() => [
    {
      id: 'feature-001',
      icon: "🏆",
      title: "World-Class Infrastructure",
      description: "State-of-the-art facilities equipped with cutting-edge technology and Olympic-standard equipment, designed to optimize performance outcomes.",
      benefits: ["Advanced Analytics", "Performance Monitoring", "Recovery Systems"],
      category: "facilities",
      priority: "high",
      luxury: "Diamond Tier"
    },
    {
      id: 'feature-002',
      icon: "👨‍🏫",
      title: "Certified Expert Instructors",
      description: "Qualified professionals with advanced degrees in sports science and coaching experience.",
      benefits: ["Professional Qualifications", "Ongoing Training", "Performance Focus"],
      category: "personnel",
      priority: "high",
      luxury: "Platinum Tier"
    },
    {
      id: 'feature-003',
      icon: "🌍",
      title: "Quality Training",
      description: "We focus on delivering high-quality training programs that help clients achieve their performance goals and improve their movement capabilities.",
      benefits: ["Quality Standards", "Client Focus", "Results-Driven"],
      category: "quality",
      priority: "medium",
      luxury: "Gold Tier"
    },
    {
      id: 'feature-004',
      icon: "💎",
      title: "Personalized Excellence",
      description: "Data-driven, customized training programs designed to unlock maximum potential and achieve measurable, sustainable results.",
      benefits: ["Individual Assessment", "Progress Tracking", "Adaptive Programming"],
      category: "methodology",
      priority: "high",
      luxury: "Elite Tier"
    }
  ], []);

  // Premium Event Handlers with Luxury Interactions
  const handleVideoInteraction = useCallback(() => {
    setVideoState(prev => ({
      ...prev,
      isPlaying: !prev.isPlaying,
      currentTime: prev.isPlaying ? 0 : Date.now()
    }));
    
    // Luxury alert with premium information
    alert('🎬 Premium corporate video presentation would play here!\n\n' +
          'This showcases our:\n' +
          '• State-of-the-art facilities\n' +
          '• Certified instructors\n' +
          '• Comprehensive training methodologies\n' +
          '• Performance optimization techniques\n' +
          '• Industry-leading equipment\n' +
          '• Luxury amenities and services');
  }, []);

  const handleProfessionalConsultation = useCallback(() => {
    alert('💬 Premium consultation portal would open here!\n\n' +
          'Connect with our certified instructors for:\n' +
          '• Personalized guidance\n' +
          '• Comprehensive assessments\n' +
          '• Strategic training planning\n' +
          '• Performance optimization\n' +
          '• Professional development roadmap\n' +
          '• VIP consultation services');
  }, []);

  const handleProgramExploration = useCallback(() => {
    window.location.href = '/products';
  }, []);

  const handleTestimonialNavigation = useCallback((index) => {
    if (testimonialState.transitionInProgress) return;
    
    setTestimonialState(prev => ({
      ...prev,
      currentIndex: index,
      transitionInProgress: true
    }));
    
    // Reset transition flag after animation
    setTimeout(() => {
      setTestimonialState(prev => ({
        ...prev,
        transitionInProgress: false
      }));
    }, 600);
  }, [testimonialState.transitionInProgress]);

  // Premium Effects with Luxury Animations
  useEffect(() => {
    // Initialize component state
    setScrollState(prev => ({ ...prev, isVisible: true }));
    
    // Premium testimonial auto-rotation
    const testimonialInterval = setInterval(() => {
      if (testimonialState.isAutoPlaying && !testimonialState.transitionInProgress) {
        setTestimonialState(prev => ({
          ...prev,
          currentIndex: (prev.currentIndex + 1) % professionalTestimonials.length
        }));
      }
    }, 6000);

    // Cleanup interval
    return () => clearInterval(testimonialInterval);
  }, [professionalTestimonials.length, testimonialState.isAutoPlaying, testimonialState.transitionInProgress]);

  useEffect(() => {
    // Premium scroll handling with luxury effects
    const handleScroll = () => {
      const scrollY = window.scrollY;
      const direction = scrollY > scrollState.scrollY ? 'down' : 'up';
      
      setScrollState({
        isVisible: scrollY > 100,
        scrollY,
        direction
      });

      // Luxury parallax effects
      if (heroRef.current) {
        const hero = heroRef.current;
        hero.style.transform = `translateY(${scrollY * 0.5}px)`;
      }

      if (statsRef.current) {
        const stats = statsRef.current;
        const rect = stats.getBoundingClientRect();
        if (rect.top < window.innerHeight && rect.bottom > 0) {
          stats.style.opacity = '1';
          stats.style.transform = 'translateY(0)';
        }
      }
    };

    window.addEventListener('scroll', handleScroll, { passive: true });
    return () => window.removeEventListener('scroll', handleScroll);
  }, [scrollState.scrollY]);

  useEffect(() => {
    // Premium mouse tracking for luxury effects
    const handleMouseMove = (e) => {
      setMousePosition({ x: e.clientX, y: e.clientY });
      
      // Create luxury particle effects
      if (isHovering && particleCount < 50) {
        setParticleCount(prev => prev + 1);
        setTimeout(() => setParticleCount(prev => prev - 1), 2000);
      }
    };

    window.addEventListener('mousemove', handleMouseMove);
    return () => window.removeEventListener('mousemove', handleMouseMove);
  }, [isHovering, particleCount]);

  // Premium Render Methods with Luxury Enhancements
  const renderHeroSection = () => (
    <section className="hero luxury-hero" ref={heroRef}>
      {/* Luxury Background Elements */}
      <div className="luxury-background">
        <div className="floating-particles">
          {[...Array(20)].map((_, i) => (
            <div 
              key={i} 
              className="luxury-particle"
              style={{
                left: `${Math.random() * 100}%`,
                animationDelay: `${Math.random() * 3}s`,
                animationDuration: `${3 + Math.random() * 2}s`
              }}
            />
          ))}
        </div>
        <div className="luxury-glow" />
      </div>

      <div className="hero-content">
        <div className="hero-badge luxury-badge">
          <FaGem className="luxury-icon" />
          <span>Movement Performance Training</span>
          <div className="badge-sparkle" />
        </div>
        <h1 className="luxury-title">Unlock Your Performance Potential</h1>
        <p className="luxury-subtitle">Experience world-class training methodologies backed by scientific research and proven results. Our comprehensive programs are designed to optimize performance, enhance capabilities, and deliver measurable outcomes for elite athletes and professionals.</p>
        <Link to="/booking" className="cta-btn luxury-btn">
          <span>Schedule Professional Consultation</span>
          <FaArrowRight className="btn-icon" />
          <div className="btn-luxury-glow" />
        </Link>
      </div>

      {/* Luxury Scroll Indicator */}
      <div className="luxury-scroll-indicator">
        <div className="scroll-line" />
        <div className="scroll-text">Scroll to Explore</div>
      </div>
    </section>
  );

  const renderMPTSection = () => (
    <section className="mpt-section luxury-mpt">
      <div className="container">
        <div className="mpt-content">
          <div className="mpt-text">
            <div className="mpt-header">
              <h2 className="luxury-mpt-title">MPT</h2>
              <div className="mpt-accreditation luxury-accreditation">
                <FaShieldAlt />
                <span>Quality Training Standards</span>
                <FaGem className="luxury-gem" />
              </div>
            </div>
                               <h3 className="luxury-mpt-subtitle">Movement Performance Training</h3>
                   <p className="luxury-mpt-description">MPT specializes in movement performance training, helping athletes and professionals improve their movement quality, efficiency, and performance. We focus on enhancing movement patterns, strength, and overall athletic capabilities.</p>
            <div className="mpt-features luxury-features">
                                   <div className="feature-item luxury-feature-item">
                       <FaCheck />
                       <span>Movement Quality Assessment</span>
                     </div>
                     <div className="feature-item luxury-feature-item">
                       <FaCheck />
                       <span>Performance Enhancement</span>
                     </div>
                     <div className="feature-item luxury-feature-item">
                       <FaCheck />
                       <span>Injury Prevention Focus</span>
                     </div>
            </div>
            <button className="view-packages luxury-view-btn" onClick={handleProgramExploration}>
              <span>Explore Professional Programs</span>
              <FaArrowRight className="btn-icon" />
              <div className="btn-luxury-effect" />
            </button>
          </div>
          <div className="mpt-image luxury-image">
            <img 
              src="https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300&fit=crop" 
              alt="Professional training facility showcasing world-class equipment"
              loading="lazy"
            />
            <div className="image-overlay luxury-overlay">
              <FaTrophy />
              <span>Training Excellence</span>
              <FaCrown className="luxury-crown" />
            </div>
            <div className="image-luxury-border" />
          </div>
        </div>
      </div>
    </section>
  );

  const renderProfessionalServices = () => (
    <section className="thrill-seekers luxury-services">
      <div className="container">
        <div className="thrill-content">
          <div className="thrill-text">
            <div className="section-badge luxury-section-badge">
              <FaRocket />
              <span>Professional Services</span>
              <FaStar className="luxury-sparkle" />
            </div>
            <h3 className="luxury-services-subtitle">TRAINING SOLUTIONS</h3>
            <h2 className="luxury-services-title">Performance Development</h2>
            <p className="luxury-services-description">Our approach combines training methodologies with practical applications to help individuals improve their movement performance and achieve their goals.</p>
          </div>
          <div className="video-section luxury-video-section">
            <Link to="/booking" className="book-call-btn luxury-book-btn">
              <span>Schedule Strategic Consultation</span>
              <FaArrowRight className="btn-icon" />
              <div className="btn-luxury-effect" />
            </Link>
            <div className="video-player luxury-video-player" onClick={handleVideoInteraction}>
              <img 
                src="https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=500&h=300&fit=crop" 
                alt="Professional training demonstration"
                loading="lazy"
              />
              <div className="play-overlay luxury-play-overlay">
                <FaPlay />
              </div>
              <div className="video-badge luxury-video-badge">
                <FaAward />
                <span>Professional Presentation</span>
                <FaGem className="luxury-diamond" />
              </div>
              <div className="video-luxury-border" />
            </div>
            <button className="chat-btn luxury-chat-btn" onClick={handleProfessionalConsultation}>
              <FaComments />
              <span>PROFESSIONAL CONSULTATION</span>
              <div className="btn-luxury-effect" />
            </button>
          </div>
        </div>
      </div>
    </section>
  );

  const renderFeaturesSection = () => (
    <section className="why-choose luxury-features-section" ref={featuresRef}>
      <div className="container">
        <div className="section-header luxury-header">
                      <div className="section-badge luxury-section-badge">
              <FaTrophy />
              <span>Movement Training</span>
              <FaCrown className="luxury-crown" />
            </div>
          <h2 className="luxury-features-title">Why Choose MPT</h2>
                      <p className="luxury-features-description">We specialize in movement performance training, helping clients improve their movement quality, efficiency, and overall athletic performance.</p>
        </div>
        
        <div className="features-grid luxury-features-grid">
          {professionalFeatures.map((feature, index) => (
            <div key={feature.id} className="feature-card luxury-feature-card" style={{ animationDelay: `${index * 0.2}s` }}>
              <div className="feature-icon luxury-icon">
                {feature.icon}
                <div className="icon-luxury-glow" />
              </div>
              <h3 className="luxury-feature-title">{feature.title}</h3>
              <p className="luxury-feature-description">{feature.description}</p>
              <div className="feature-benefits luxury-benefits">
                {feature.benefits.map((benefit, idx) => (
                  <div key={`${feature.id}-benefit-${idx}`} className="benefit-item luxury-benefit-item">
                    <FaCheck />
                    <span>{benefit}</span>
                  </div>
                ))}
              </div>
              <div className="feature-luxury-badge">
                <FaGem />
                <span>{feature.luxury}</span>
              </div>
              <div className="feature-luxury-border" />
            </div>
          ))}
        </div>
      </div>
    </section>
  );

  const renderPerformanceMetrics = () => (
    <section className="stats-section luxury-stats" ref={statsRef}>
      <div className="container">
        <div className="stats-header luxury-stats-header">
          <h2 className="luxury-stats-title">Performance Metrics</h2>
          <p className="luxury-stats-description">Quantified results that demonstrate our commitment to excellence and measurable outcomes</p>
        </div>
        <div className="stats-grid luxury-stats-grid">
          {performanceMetrics.map((metric, index) => (
            <div key={metric.id} className="stat-item luxury-stat-item" style={{ animationDelay: `${index * 0.1}s` }}>
              <div className="stat-icon luxury-stat-icon">{metric.icon}</div>
              <div className="stat-number luxury-stat-number">{metric.number}</div>
              <div className="stat-label luxury-stat-label">{metric.label}</div>
              <div className="stat-description luxury-stat-description">{metric.description}</div>
              <div className="stat-trend luxury-stat-trend">{metric.trend}</div>
              <div className="stat-luxury-badge">
                <FaGem />
                <span>{metric.luxury}</span>
              </div>
              <div className="stat-luxury-border" />
            </div>
          ))}
        </div>
      </div>
    </section>
  );

  const renderTestimonials = () => (
    <section className="testimonials luxury-testimonials" ref={testimonialsRef}>
      <div className="container">
        <div className="section-header luxury-header">
          <div className="section-badge luxury-section-badge">
            <FaStar />
            <span>Professional Endorsements</span>
            <FaCrown className="luxury-crown" />
          </div>
                      <h2 className="luxury-testimonials-title">Client Success Stories</h2>
                      <p className="luxury-testimonials-description">Testimonials from professionals and clients that validate our commitment to excellence and dedication to results</p>
        </div>
        
        <div className="testimonials-container luxury-testimonials-container">
          <div 
            className="testimonials-track luxury-track" 
            style={{ transform: `translateX(-${testimonialState.currentIndex * 100}%)` }}
          >
            {professionalTestimonials.map((testimonial) => (
              <div key={testimonial.id} className="testimonial-card luxury-testimonial-card">
                <div className="testimonial-header luxury-header">
                  <div className="testimonial-avatar luxury-avatar">{testimonial.image}</div>
                  <div className="testimonial-info luxury-info">
                    <h4 className="luxury-testimonial-name">{testimonial.name}</h4>
                    <span className="role luxury-role">{testimonial.role}</span>
                    <div className="credentials luxury-credentials">{testimonial.credentials}</div>
                    <div className="achievement-badge luxury-achievement">{testimonial.achievement}</div>
                    <div className="luxury-membership">
                      <FaCrown />
                      <span>{testimonial.luxury}</span>
                    </div>
                  </div>
                  <div className="testimonial-rating luxury-rating">
                    {[...Array(testimonial.rating)].map((_, i) => (
                      <FaStar key={i} className="star luxury-star" />
                    ))}
                  </div>
                </div>
                <p className="testimonial-text luxury-text">{testimonial.text}</p>
                <div className="testimonial-credentials luxury-credentials">
                  <FaShieldAlt />
                  <span>Verified Professional</span>
                </div>
                <div className="testimonial-meta luxury-meta">
                  <span className="company luxury-company">{testimonial.company}</span>
                  <span className="experience luxury-experience">{testimonial.experience}</span>
                </div>
                <div className="testimonial-luxury-border" />
              </div>
            ))}
          </div>
          
          <div className="testimonial-indicators luxury-indicators">
            {professionalTestimonials.map((_, index) => (
              <button
                key={`indicator-${index}`}
                className={`indicator luxury-indicator ${index === testimonialState.currentIndex ? 'active' : ''}`}
                onClick={() => handleTestimonialNavigation(index)}
                aria-label={`Go to testimonial ${index + 1}`}
              />
            ))}
          </div>
        </div>
      </div>
    </section>
  );

  const renderCTASection = () => (
    <section className="cta-section luxury-cta">
      <div className="container">
        <div className="cta-content luxury-cta-content">
          <div className="cta-badge luxury-cta-badge">
            <FaRocket />
            <span>Ready to Excel?</span>
            <FaGem className="luxury-diamond" />
          </div>
          <h2 className="luxury-cta-title">Transform Your Performance Potential</h2>
          <p className="luxury-cta-description">Join the ranks of elite performers who have chosen MPT for their development journey. Our comprehensive programs and professional expertise are designed to deliver exceptional results and establish new performance benchmarks.</p>
          <div className="cta-actions luxury-actions">
            <Link to="/products" className="cta-btn primary luxury-primary-btn">
              <span>Explore Professional Programs</span>
              <FaArrowRight className="btn-icon" />
              <div className="btn-luxury-glow" />
            </Link>
            <button className="cta-btn secondary luxury-secondary-btn" onClick={handleProfessionalConsultation}>
              <span>Schedule Professional Consultation</span>
              <FaUsers className="btn-icon" />
              <div className="btn-luxury-effect" />
            </button>
          </div>
        </div>
      </div>
      
      {/* Luxury Background Elements */}
      <div className="luxury-cta-background">
        <div className="luxury-particles">
          {[...Array(15)].map((_, i) => (
            <div 
              key={i} 
              className="luxury-cta-particle"
              style={{
                left: `${Math.random() * 100}%`,
                animationDelay: `${Math.random() * 4}s`,
                animationDuration: `${4 + Math.random() * 3}s`
              }}
            />
          ))}
        </div>
      </div>
    </section>
  );

  // Main Component Render
  return (
    <div className="home-page luxury-home-page">
      {renderHeroSection()}
      {renderMPTSection()}
      {renderProfessionalServices()}
      {renderFeaturesSection()}
      {renderPerformanceMetrics()}
      {renderTestimonials()}
      {renderCTASection()}
      
      {/* Luxury Mouse Follower */}
      <div 
        className="luxury-mouse-follower"
        style={{
          left: mousePosition.x,
          top: mousePosition.y
        }}
      />
    </div>
  );
}

export default Home; 