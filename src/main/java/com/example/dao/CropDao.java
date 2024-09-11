package com.example.dao;

  

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Crop;
import com.example.entity.Farmer;

 

@Repository
public class CropDao {
	
	@Autowired
	private SessionFactory factory;
	
	private ArrayList<Farmer> listFarmers = new ArrayList<>();

	// Add a Crop
	public Crop addCrop(Crop crop) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(crop);
		session.getTransaction().commit();
		session.close();
		return crop;
	}

	// Get all crops
	public List<Crop> getAllCrops() {
		Session session = factory.openSession();
		session.beginTransaction();
		List<Crop> crops = session.createQuery("from Crop", Crop.class).getResultList();
		session.getTransaction().commit();
		session.close();
		return crops;
	}

	// Get a Crop by ID
	public Crop getCropById(int id) {
		Session session = factory.openSession();
		session.beginTransaction();
		Crop crop = session.get(Crop.class, id);
		session.getTransaction().commit();
		session.close();
		return crop;
	}

	// Get Crops by Growth Stage
	public List<Crop> getCropsByGrowthStage(String growthStage) {
		Session session = factory.openSession();
		session.beginTransaction();
		List<Crop> crops = session.createQuery("from Crop where growthStage = :growthStage", Crop.class)
				.setParameter("growthStage", growthStage).getResultList();
		session.getTransaction().commit();
		session.close();
		return crops;
	}

	// Update a Crop by ID
	public void updateCrop(int id, Crop updatedCrop) {
		Session session = factory.openSession();
		session.beginTransaction();
		Crop crop = session.get(Crop.class, id);
		if (crop != null) {
			crop.setName(updatedCrop.getName());
			crop.setPlantingDate(updatedCrop.getPlantingDate());
			crop.setHarvestDate(updatedCrop.getHarvestDate());
			crop.setGrowthStage(updatedCrop.getGrowthStage());
			session.update(crop);
		}
		session.getTransaction().commit();
		session.close();
	}

	// Update Growth Stage by Index
	public void updateGrowthStage(int index, String growthStage) {
		Session session = factory.openSession();
		session.beginTransaction();
		Crop crop = session.get(Crop.class, index);
		if (crop != null) {
			crop.setGrowthStage(growthStage);
			session.update(crop);
		}
		session.getTransaction().commit();
		session.close();
	}

	// Delete a Crop by Index
	public String deleteCrop(int index) {
		Session session = factory.openSession();
		session.beginTransaction();
		Crop crop = session.get(Crop.class, index);
		if (crop != null) {
			session.delete(crop);
			session.getTransaction().commit();
			session.close();
			return "Crop deleted successfully.";
		} else {
			session.getTransaction().rollback();
			session.close();
			return "Crop not found.";
		}
	}

	// Delete All Crops
	public String deleteAllCrops() {
		Session session = factory.openSession();
		session.beginTransaction();
		session.createQuery("delete from Crop").executeUpdate();
		session.getTransaction().commit();
		session.close();
		return "All crops deleted successfully.";
	}

	// Replace All Crops
	public List<Crop> replaceAllCrops(List<Crop> crops) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.createQuery("delete from Crop").executeUpdate();
		for (Crop crop : crops) {
			session.save(crop);
		}
		session.getTransaction().commit();
		session.close();
		return crops;
	}

	// Get count of Crops
	public int getCountOfCrops() {
		Session session = factory.openSession();
		session.beginTransaction();
		Long count = (Long) session.createQuery("select count(*) from Crop").uniqueResult();
		session.getTransaction().commit();
		session.close();
		return count.intValue();
	}

	// Get the first Crop
	public Crop getFirstCrop() {
		Session session = factory.openSession();
		session.beginTransaction();
		List<Crop> crops = session.createQuery("from Crop", Crop.class).setMaxResults(1).getResultList();
		session.getTransaction().commit();
		session.close();
		return crops.isEmpty() ? null : crops.get(0);
	}

	// Get the last Crop
	public Crop getLastCrop() {
		Session session = factory.openSession();
		session.beginTransaction();
		List<Crop> crops = session.createQuery("from Crop order by id desc", Crop.class).setMaxResults(1)
				.getResultList();
		session.getTransaction().commit();
		session.close();
		return crops.isEmpty() ? null : crops.get(0);
	}

	// Update Planting Date
	public Crop updatePlantingDate(int index, String plantingDate) {
		Session session = factory.openSession();
		session.beginTransaction();
		Crop crop = session.get(Crop.class, index);
		if (crop != null) {
			crop.setPlantingDate(plantingDate);
			session.update(crop);
		}
		session.getTransaction().commit();
		session.close();
		return crop;
	}

	// Update Harvest Date
	public Crop updateHarvestDate(int index, String harvestDate) {
		Session session = factory.openSession();
		session.beginTransaction();
		Crop crop = session.get(Crop.class, index);
		if (crop != null) {
			crop.setHarvestDate(harvestDate);
			session.update(crop);
		}
		session.getTransaction().commit();
		session.close();
		return crop;
	}

	// Get all Farmers
	public List<Farmer> getAllFarmers() {
		// Logic to get all farmers (can be customized if farmers are stored in a separate table)
		return listFarmers;
	}

	// Get Farmer by ID
	public Farmer getFarmerById(long id) {
		Session session = factory.openSession();
		session.beginTransaction();
		Farmer farmer = session.get(Farmer.class, id);
		session.getTransaction().commit();
		session.close();
		return farmer;
	}

	// Get Crops for Farmer by Farmer ID
	public String getCropsForFarmer(String id) {
		for (Farmer farmer : listFarmers) {
			if (farmer.getId().equals(id)) {
				return farmer.getName();  // Assuming this method returns the name of the crops or farmer
			}
		}
		return null;
	}

	// Add a Farmer
	public Farmer addFarmer(Farmer farmer) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(farmer);
		session.getTransaction().commit();
		session.close();
		return farmer;
	}

	// Update Farmer
	public Farmer updateFarmer(String id, Farmer updatedFarmer) {
		Session session = factory.openSession();
		session.beginTransaction();
		Farmer farmer = session.get(Farmer.class, Long.parseLong(id));
		if (farmer != null) {
			farmer.setName(updatedFarmer.getName());
			farmer.setContactNumber(updatedFarmer.getContactNumber());
			farmer.setEmail(updatedFarmer.getEmail());
			farmer.setAddress(updatedFarmer.getAddress());
			session.update(farmer);
		}
		session.getTransaction().commit();
		session.close();
		return farmer;
	}

	// Delete Farmer by ID
	public String deleteFarmer(String id) {
		Session session = factory.openSession();
		session.beginTransaction();
		Farmer farmer = session.get(Farmer.class, Long.parseLong(id));
		if (farmer != null) {
			session.delete(farmer);
			session.getTransaction().commit();
			session.close();
			return "Farmer deleted successfully.";
		} else {
			session.getTransaction().rollback();
			session.close();
			return "Farmer not found.";
		}
	}
}
