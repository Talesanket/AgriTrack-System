package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Crop;
import com.example.entity.Farmer;
import com.example.service.CropService;

@RestController
@RequestMapping("/crops")
public class CropController {
@Autowired
CropService cropService;
	@PostMapping("addcrop")
	public Crop addCrop(@RequestBody Crop crop) {
		 return cropService.addCrop(crop);
	}

	@GetMapping("/all")
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

    @GetMapping("/{id}")
    public Crop getCropById(@PathVariable int id) {
        return cropService.getCropById(id);
    }

    @GetMapping("/stage/{growthStage}")
    public List<Crop> getCropsByGrowthStage(@PathVariable String growthStage) {
        return cropService.getCropsByGrowthStage(growthStage);
    }

    @PutMapping("/update/{id}")
    public Crop updateCrop(@PathVariable int id, @RequestBody Crop updatedCrop) {
        cropService.updateCrop(id, updatedCrop);
        return cropService.getCropById(id);
    }

    @PutMapping("/updateGrowthStage/{id}")
    public Crop updateGrowthStage(@PathVariable int id, @RequestParam String growthStage) {
        Crop crop = cropService.getCropById(id);
        if (crop != null) {
            cropService.updateGrowthStage(id, growthStage);
            return cropService.getCropById(id);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCrop(@PathVariable int id) {
        return cropService.deleteCrop(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllCrops() {
        return cropService.deleteAllCrops();
    }

    @PostMapping("/replaceAll")
    public List<Crop> replaceAllCrops(@RequestBody List<Crop> crops) {
        return cropService.replaceAllCrops(crops);
    }

    @GetMapping("/count")
    public int getCountOfCrops() {
        return cropService.getCountOfCrops();
    }

    @GetMapping("/first")
    public Crop getFirstCrop() {
        return cropService.getFirstCrop();
    }

    @GetMapping("/last")
    public Crop getLastCrop() {
        return cropService.getLastCrop();
    }

    @PutMapping("/updatePlantingDate/{id}")
    public Crop updatePlantingDate(@PathVariable int id, @RequestParam String plantingDate) {
        return cropService.updatePlantingDate(id, plantingDate);
    }

    @PutMapping("/updateHarvestDate/{id}")
    public Crop updateHarvestDate(@PathVariable int id, @RequestParam String harvestDate) {
        return cropService.updateHarvestDate(id, harvestDate);
    }

    // Farmer endpoints
    @GetMapping("/farmers")
    public List<Farmer> getAllFarmers() {
        return cropService.getAllFarmers();
    }

    @GetMapping("/farmers/{id}")
    public Farmer getFarmerById(@PathVariable Long id) {
        return cropService.getFarmerById(id);
    }

    @GetMapping("/farmers/{id}/crops")
    public String getCropsForFarmer(@PathVariable Long id) {
        return cropService.getCropsForFarmer(id.toString());
    }

    @PostMapping("/farmers/add")
    public Farmer addFarmer(@RequestBody Farmer farmer) {
        return cropService.addFarmer(farmer);
    }

    @PutMapping("/farmers/{id}")
    public Farmer updateFarmer(@PathVariable Long id, @RequestBody Farmer updatedFarmer) {
        return cropService.updateFarmer(id.toString(), updatedFarmer);
    }

    @DeleteMapping("/farmers/{id}")
    public String deleteFarmer(@PathVariable Long id) {
        return cropService.deleteFarmer(id.toString());
    }
}
