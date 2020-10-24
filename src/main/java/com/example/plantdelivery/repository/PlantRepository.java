package com.example.plantdelivery.repository;

import com.example.plantdelivery.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    Boolean existsPlantByIdAndDeliveryIsCompleted(Long id, Boolean deliveryIsCompleted);

    @Query("select p.delivery.isCompleted from Plant p where p.id = :plantId")
    Boolean deliveryIsCompleted(Long plantId);

    @Query("select new java.lang.Boolean(p.delivery.isCompleted) from Plant p where p.id = :plantId")
    Boolean deliveryIsCompletedBoolean(Long plantId);

    Plant findPlantByName(String name);

    List<Plant> findPlantsByPriceLessThanEqual(BigDecimal price);
}
