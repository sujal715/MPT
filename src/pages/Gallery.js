import React, { useState } from 'react';
import './Gallery.css';

const Gallery = () => {
  const [selectedCategory, setSelectedCategory] = useState('all');
  const [selectedImage, setSelectedImage] = useState(null);

  const categories = [
    { id: 'all', name: 'All Photos', icon: '📸' },
    { id: 'kitesurfing', name: 'Kitesurfing', icon: '🏄‍♂️' },
    { id: 'hydrofoil', name: 'Hydrofoil', icon: '🪁' },
    { id: 'wingfoil', name: 'Wing Foil', icon: '🌊' },
    { id: 'training', name: 'Training', icon: '💪' },
    { id: 'locations', name: 'Locations', icon: '📍' }
  ];

  const galleryItems = [
    {
      id: 1,
      src: 'https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300&fit=crop',
      alt: 'Kitesurfing on the waves',
      category: 'kitesurfing',
      title: 'Wave Riding',
      description: 'Advanced kitesurfing techniques in perfect conditions'
    },
    {
      id: 2,
      src: 'https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=400&h=300&fit=crop',
      alt: 'Hydrofoil gliding above water',
      category: 'hydrofoil',
      title: 'Hydrofoil Mastery',
      description: 'Smooth hydrofoil riding with expert instruction'
    },
    {
      id: 3,
      src: 'https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300&fit=crop',
      alt: 'Wing foiling adventure',
      category: 'wingfoil',
      title: 'Wing Foil Adventure',
      description: 'Exploring the exciting world of wing foiling'
    },
    {
      id: 4,
      src: 'https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=400&h=300&fit=crop',
      alt: 'Training session in progress',
      category: 'training',
      title: 'Skill Development',
      description: 'Focused training sessions for all skill levels'
    },
    {
      id: 5,
      src: 'https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300&fit=crop',
      alt: 'Beautiful training location',
      category: 'locations',
      title: 'Perfect Conditions',
      description: 'Our stunning training locations around the Gold Coast'
    },
    {
      id: 6,
      src: 'https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=400&h=300&fit=crop',
      alt: 'Group training session',
      category: 'training',
      title: 'Group Learning',
      description: 'Fun and effective group training sessions'
    },
    {
      id: 7,
      src: 'https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300&fit=crop',
      alt: 'Advanced kitesurfing tricks',
      category: 'kitesurfing',
      title: 'Advanced Techniques',
      description: 'Mastering complex kitesurfing maneuvers'
    },
    {
      id: 8,
      src: 'https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=400&h=300&fit=crop',
      alt: 'Hydrofoil wave riding',
      category: 'hydrofoil',
      title: 'Wave Riding on Foil',
      description: 'Taking hydrofoil to the next level'
    },
    {
      id: 9,
      src: 'https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300&fit=crop',
      alt: 'Wing foil in action',
      category: 'wingfoil',
      title: 'Wing Foil Action',
      description: 'Dynamic wing foiling in perfect conditions'
    },
    {
      id: 10,
      src: 'https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=400&h=300&fit=crop',
      alt: 'Training equipment setup',
      category: 'training',
      title: 'Equipment Setup',
      description: 'Proper setup and safety equipment preparation'
    },
    {
      id: 11,
      src: 'https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=400&h=300&fit=crop',
      alt: 'Scenic training location',
      category: 'locations',
      title: 'Scenic Views',
      description: 'Breathtaking views from our training spots'
    },
    {
      id: 12,
      src: 'https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=400&h=300&fit=crop',
      alt: 'Student progress celebration',
      category: 'training',
      title: 'Student Success',
      description: 'Celebrating student achievements and progress'
    }
  ];

  const filteredItems = selectedCategory === 'all' 
    ? galleryItems 
    : galleryItems.filter(item => item.category === selectedCategory);

  const openImageModal = (item) => {
    setSelectedImage(item);
  };

  const closeImageModal = () => {
    setSelectedImage(null);
  };

  return (
    <div className="gallery-page">
      {/* Hero Section */}
      <section className="gallery-hero">
        <div className="hero-content">
          <h1>Our Gallery</h1>
          <p>Explore the exciting world of water sports through our collection of stunning photos and videos from training sessions, adventures, and beautiful locations.</p>
        </div>
      </section>

      {/* Category Filter */}
      <section className="gallery-filter">
        <div className="container">
          <div className="filter-buttons">
            {categories.map(category => (
              <button
                key={category.id}
                className={`filter-btn ${selectedCategory === category.id ? 'active' : ''}`}
                onClick={() => setSelectedCategory(category.id)}
              >
                <span className="filter-icon">{category.icon}</span>
                {category.name}
              </button>
            ))}
          </div>
        </div>
      </section>

      {/* Gallery Grid */}
      <section className="gallery-section">
        <div className="container">
          <div className="gallery-grid">
            {filteredItems.map(item => (
              <div key={item.id} className="gallery-item" onClick={() => openImageModal(item)}>
                <div className="gallery-image">
                  <img src={item.src} alt={item.alt} />
                  <div className="gallery-overlay">
                    <div className="gallery-info">
                      <h3>{item.title}</h3>
                      <p>{item.description}</p>
                      <span className="view-btn">Click to View</span>
                    </div>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* Image Modal */}
      {selectedImage && (
        <div className="image-modal" onClick={closeImageModal}>
          <div className="modal-content" onClick={(e) => e.stopPropagation()}>
            <button className="modal-close" onClick={closeImageModal}>×</button>
            <div className="modal-image">
              <img src={selectedImage.src} alt={selectedImage.alt} />
            </div>
            <div className="modal-info">
              <h3>{selectedImage.title}</h3>
              <p>{selectedImage.description}</p>
              <span className="modal-category">
                {categories.find(cat => cat.id === selectedImage.category)?.name}
              </span>
            </div>
          </div>
        </div>
      )}

      {/* Call to Action */}
      <section className="gallery-cta">
        <div className="container">
          <h2>Ready to Create Your Own Memories?</h2>
          <p>Join our training programs and capture your own amazing moments on the water!</p>
          <div className="cta-buttons">
            <a href="/booking" className="cta-btn primary">Book Your Session</a>
            <a href="/contact" className="cta-btn secondary">Contact Us</a>
          </div>
        </div>
      </section>
    </div>
  );
};

export default Gallery; 