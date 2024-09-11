package com.example.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Component
@Entity
public class Crop {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String plantingDate;
	private String harvestDate;
	private String growthStage;
	 
	
	@JsonManagedReference
@OneToMany(mappedBy = "crop",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	List<Farmer> farmers;

	 
	public Crop() {
	}
	public Crop(String name, String plantingDate, String harvestDate, String growthStage, List<Farmer> farmers) {
		super();
		this.name = name;
		this.plantingDate = plantingDate;
		this.harvestDate = harvestDate;
		this.growthStage = growthStage;
		this.farmers = farmers;
	}


	public Crop(String name, String plantingDate, String harvestDate, String growthStage) {
		this.name = name;
		this.plantingDate = plantingDate;
		this.harvestDate = harvestDate;
		this.growthStage = growthStage;
	}
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlantingDate() {
		return plantingDate;
	}

	public void setPlantingDate(String plantingDate) {
		this.plantingDate = plantingDate;
	}

	public String getHarvestDate() {
		return harvestDate;
	}

	public void setHarvestDate(String harvestDate) {
		this.harvestDate = harvestDate;
	}

	public String getGrowthStage() {
		return growthStage;
	}

	public void setGrowthStage(String growthStage) {
		this.growthStage = growthStage;
	}
	public List<Farmer> getFarmers() {
		return farmers;
	}

	public void setFarmers(List<Farmer> farmers) {
		this.farmers = farmers;
	}

	@Override
	public String toString() {
		return "Crop{" + "id=" + id + ", name='" + name + '\'' + ", plantingDate='" + plantingDate + '\''
				+ ", harvestDate='" + harvestDate + '\'' + ", growthStage='" + growthStage + '\'' + '}';
	}
}
