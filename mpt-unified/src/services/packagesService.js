import apiService from './api';

class PackagesService {
  // Get all packages
  async getPackages() {
    return await apiService.get('/packages');
  }

  // Get package by ID
  async getPackageById(id) {
    return await apiService.get(`/packages/${id}`);
  }

  // Create new package (admin only)
  async createPackage(packageData) {
    return await apiService.post('/packages', packageData);
  }

  // Update package (admin only)
  async updatePackage(id, packageData) {
    return await apiService.put(`/packages/${id}`, packageData);
  }

  // Delete package (admin only)
  async deletePackage(id) {
    return await apiService.delete(`/packages/${id}`);
  }

  // Get packages by category
  async getPackagesByCategory(category) {
    return await apiService.get(`/packages/category/${category}`);
  }
}

export default new PackagesService();
