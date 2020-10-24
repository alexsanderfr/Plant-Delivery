package com.example.plantdelivery.service;

import com.example.plantdelivery.model.Delivery;
import com.example.plantdelivery.model.RecipientAndPrice;
import com.example.plantdelivery.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeliveryService {
    final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery get(Long id) {
        return deliveryRepository.find(id);
    }

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public RecipientAndPrice getBill(Long deliveryId) {
        return deliveryRepository.getBill(deliveryId);
    }
}
