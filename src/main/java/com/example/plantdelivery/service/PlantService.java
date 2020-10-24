package com.example.plantdelivery.service;

import com.example.plantdelivery.model.Plant;
import com.example.plantdelivery.repository.PlantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Plant getPlantByName(String name) {
        return plantRepository.findPlantByName(name);
    }

    public Long save(Plant plant) {
        Plant savedPlant = plantRepository.save(plant);
        return savedPlant.getId();
    }

    public Boolean isDelivered(Long id) {
        return plantRepository.existsPlantByIdAndDeliveryIsCompleted(id, true);
    }

    public List<Plant> findPlantsCheaperThanPrice(BigDecimal price) {
        return plantRepository.findPlantsByPriceLessThanEqual(price);
    }
}