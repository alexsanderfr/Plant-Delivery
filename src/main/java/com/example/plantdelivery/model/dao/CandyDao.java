package com.example.plantdelivery.model.dao;

import com.example.plantdelivery.model.Candy;

import java.util.List;

public interface CandyDao {

    List<Candy> list();

    void addToDelivery(Long candyId, Long deliveryid);

    List<Candy> findByDelivery(Long deliveryId);

}
