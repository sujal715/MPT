import apiService from './api';

class ServicesService {
  // Get all services
  async getAllServices() {
    try {
      return await apiService.get('/services');
    } catch (error) {
      throw error;
    }
  }

  // Get service by ID
  async getService(id) {
    try {
      return await apiService.get(`/services/${id}`);
    } catch (error) {
      throw error;
    }
  }

  // Create new service (admin only)
  async createService(serviceData) {
    try {
      return await apiService.post('/services', serviceData);
    } catch (error) {
      throw error;
    }
  }

  // Update service (admin only)
  async updateService(id, serviceData) {
    try {
      return await apiService.put(`/services/${id}`, serviceData);
    } catch (error) {
      throw error;
    }
  }

  // Delete service (admin only)
  async deleteService(id) {
    try {
      return await apiService.delete(`/services/${id}`);
    } catch (error) {
      throw error;
    }
  }

  // Get services by category
  async getServicesByCategory(category) {
    try {
      return await apiService.get(`/services/category/${category}`);
    } catch (error) {
      throw error;
    }
  }

  // Get service categories
  async getServiceCategories() {
    try {
      return await apiService.get('/services/categories');
    } catch (error) {
      throw error;
    }
  }
}

export default new ServicesService();




