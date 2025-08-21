import apiService from './api';

class GalleryService {
  // Get all gallery items
  async getAllGalleryItems() {
    try {
      return await apiService.get('/gallery');
    } catch (error) {
      throw error;
    }
  }

  // Get gallery items by category
  async getGalleryItemsByCategory(category) {
    try {
      return await apiService.get(`/gallery/category/${category}`);
    } catch (error) {
      throw error;
    }
  }

  // Get single gallery item
  async getGalleryItem(id) {
    try {
      return await apiService.get(`/gallery/${id}`);
    } catch (error) {
      throw error;
    }
  }

  // Create new gallery item (admin only)
  async createGalleryItem(itemData) {
    try {
      return await apiService.post('/gallery', itemData);
    } catch (error) {
      throw error;
    }
  }

  // Update gallery item (admin only)
  async updateGalleryItem(id, itemData) {
    try {
      return await apiService.put(`/gallery/${id}`, itemData);
    } catch (error) {
      throw error;
    }
  }

  // Delete gallery item (admin only)
  async deleteGalleryItem(id) {
    try {
      return await apiService.delete(`/gallery/${id}`);
    } catch (error) {
      throw error;
    }
  }

  // Upload gallery image
  async uploadGalleryImage(file, metadata = {}) {
    try {
      return await apiService.uploadFile('/gallery/upload', file, metadata);
    } catch (error) {
      throw error;
    }
  }

  // Get gallery categories
  async getGalleryCategories() {
    try {
      return await apiService.get('/gallery/categories');
    } catch (error) {
      throw error;
    }
  }
}

export default new GalleryService();




