package com.example.plantdelivery;

import com.example.plantdelivery.model.Delivery;
import com.example.plantdelivery.model.Plant;
import com.example.plantdelivery.repository.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
class PlantDeliveryApplicationTests {


    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PlantRepository plantRepository;

    @Test
    public void testPriceLessThan() {
        //test boundary conditions
        Plant p = testEntityManager.persist(new Plant("Foo Leaf", 4.99));
        testEntityManager.persist(new Plant("Bar Weed", 5.01));

        List<Plant> cheapPlants = plantRepository.findPlantsByPriceLessThanEqual(BigDecimal.valueOf(5));
        Assertions.assertEquals(1, cheapPlants.size(), "Size");
        Assertions.assertEquals(p.getId(), cheapPlants.get(0).getId(), "Id");
    }

    @Test
    public void testDeliveryCompleted() {
        Plant p = testEntityManager.persist(new Plant("Baz Root", 9.99));
        Delivery d = testEntityManager.persist(new Delivery("Leonard Bernstein", "234 West Side", LocalDateTime.now()));

        d.setPlants(Lists.newArrayList(p));
        p.setDelivery(d);

        //test both before and after
        Assertions.assertFalse(plantRepository.existsPlantByIdAndDeliveryIsCompleted(p.getId(), false));
        d.setCompleted(true);
        Assertions.assertTrue(plantRepository.existsPlantByIdAndDeliveryIsCompleted(p.getId(), true));
    }

}
