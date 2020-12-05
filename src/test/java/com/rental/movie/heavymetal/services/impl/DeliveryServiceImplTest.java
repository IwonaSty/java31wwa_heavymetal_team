package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.Delivery;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class DeliveryServiceImplTest {
    @Autowired
    private DeliveryServiceImpl deliveryService;

    private static Long expectedId;
    private static Delivery delivery;


    @BeforeAll
    public static void init() {
        expectedId = 1L;
        delivery = Delivery.builder()
                .shipmentDate(LocalDate.now())
                .build();
    }

    @Test
    public void deliveryShouldBeAdded(){
        //when
        deliveryService.save(delivery);
        Delivery addedDelivery= deliveryService.getById(expectedId);
        //then
        assertEquals(addedDelivery.getShipmentDate(), delivery.getShipmentDate());
    }

    @Test
    public void deliveryShouldBeFindable(){
        //when
        deliveryService.save(delivery);
        Delivery addedDelivery= deliveryService.getById(expectedId);
        //then
        assertEquals(addedDelivery.getShipmentDate(), delivery.getShipmentDate());
    }

    @Test
    public void deliveryShouldBeUpdated(){
        //when
        LocalDate updatedShipmentDate = LocalDate.of(2021, 12, 12);
        deliveryService.save(delivery);
        Delivery delivery = deliveryService.getById(expectedId);
        delivery.setShipmentDate(updatedShipmentDate);
        deliveryService.update(delivery);
        Delivery updatedDelivery = deliveryService.getById(expectedId);
        //then
        assertEquals(updatedDelivery.getId(), delivery.getId());
        assertEquals(updatedShipmentDate, updatedDelivery.getShipmentDate());

    }

    @Test
    public void deliveryShouldBeDeleted(){
        //when
        deliveryService.save(delivery);
        deliveryService.delete(expectedId);
        //then
        Delivery gotDelivery = deliveryService.getById(expectedId);
        assertNull(gotDelivery);
    }

}