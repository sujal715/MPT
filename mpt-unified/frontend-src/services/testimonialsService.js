import apiService from './api';

class TestimonialsService {
  // Get all testimonials
  async getAllTestimonials() {
    try {
      return await apiService.get('/public/testimonials');
    } catch (error) {
      throw error;
    }
  }

  // Get testimonial by ID
  async getTestimonial(id) {
    try {
      return await apiService.get(`/public/testimonials/${id}`);
    } catch (error) {
      throw error;
    }
  }

  // Create new testimonial (admin only)
  async createTestimonial(testimonialData) {
    try {
      return await apiService.post('/public/testimonials', testimonialData);
    } catch (error) {
      throw error;
    }
  }

  // Update testimonial (admin only)
  async updateTestimonial(id, testimonialData) {
    try {
      return await apiService.put(`/public/testimonials/${id}`, testimonialData);
    } catch (error) {
      throw error;
    }
  }

  // Delete testimonial (admin only)
  async deleteTestimonial(id) {
    try {
      return await apiService.delete(`/public/testimonials/${id}`);
    } catch (error) {
      throw error;
    }
  }

  // Get featured testimonials
  async getFeaturedTestimonials() {
    try {
      return await apiService.get('/public/testimonials/featured');
    } catch (error) {
      throw error;
    }
  }

  // Get testimonials by rating
  async getTestimonialsByRating(rating) {
    try {
      return await apiService.get(`/public/testimonials/rating/${rating}`);
    } catch (error) {
      throw error;
    }
  }
}

export default new TestimonialsService();




