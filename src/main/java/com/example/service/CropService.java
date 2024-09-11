package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CropDao;
import com.example.entity.Crop;
import com.example.entity.Farmer;

@Service
public class CropService {

	@Autowired
	private CropDao cropDao;

	// Add a Crop
	public Crop addCrop(Crop crop) {
		return cropDao.addCrop(crop);
	}

	// Get all crops
	public List<Crop> getAllCrops() {
		return cropDao.getAllCrops();
	}

	// Get a Crop by ID
	public Crop getCropById(int id) {
		return cropDao.getCropById(id);
	}

	// Get Crops by Growth Stage
	public List<Crop> getCropsByGrowthStage(String growthStage) {
		return cropDao.getCropsByGrowthStage(growthStage);
	}

	// Update a Crop by ID
	public void updateCrop(int id, Crop updatedCrop) {
		cropDao.updateCrop(id, updatedCrop);
	}

	// Update Growth Stage by Index
	public void updateGrowthStage(int index, String growthStage) {
		cropDao.updateGrowthStage(index, growthStage);
	}

	// Delete a Crop by Index
	public String deleteCrop(int index) {
		return cropDao.deleteCrop(index);
	}

	// Delete All Crops
	public String deleteAllCrops() {
		return cropDao.deleteAllCrops();
	}

	// Replace All Crops
	public List<Crop> replaceAllCrops(List<Crop> crops) {
		return cropDao.replaceAllCrops(crops);
	}

	// Get count of Crops
	public int getCountOfCrops() {
		return cropDao.getCountOfCrops();
	}

	// Get the first Crop
	public Crop getFirstCrop() {
		return cropDao.getFirstCrop();
	}

	// Get the last Crop
	public Crop getLastCrop() {
		return cropDao.getLastCrop();
	}

	// Update Planting Date
	public Crop updatePlantingDate(int index, String plantingDate) {
		return cropDao.updatePlantingDate(index, plantingDate);
	}

	// Update Harvest Date
	public Crop updateHarvestDate(int index, String harvestDate) {
		return cropDao.updateHarvestDate(index, harvestDate);
	}

	// Get all Farmers
	public List<Farmer> getAllFarmers() {
		return cropDao.getAllFarmers();
	}

	// Get Farmer by ID
	public Farmer getFarmerById(long id) {
		return cropDao.getFarmerById(id);
	}

	// Get Crops for Farmer by Farmer ID
	public String getCropsForFarmer(String id) {
		return cropDao.getCropsForFarmer(id);
	}

	// Add a Farmer
	public Farmer addFarmer(Farmer farmer) {
		return cropDao.addFarmer(farmer);
	}

	// Update Farmer
	public Farmer updateFarmer(String id, Farmer updatedFarmer) {
		return cropDao.updateFarmer(id, updatedFarmer);
	}

	// Delete Farmer by ID
	public String deleteFarmer(String id) {
		return cropDao.deleteFarmer(id);
	}
}
