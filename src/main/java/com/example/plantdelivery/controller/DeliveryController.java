package com.example.plantdelivery.controller;

import com.example.plantdelivery.model.Delivery;
import com.example.plantdelivery.model.RecipientAndPrice;
import com.example.plantdelivery.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Delivery> getDelivery(@PathVariable Long id) {
        Delivery delivery = this.deliveryService.get(id);
        return new ResponseEntity<Delivery>(delivery, HttpStatus.OK);
    }

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }
}
