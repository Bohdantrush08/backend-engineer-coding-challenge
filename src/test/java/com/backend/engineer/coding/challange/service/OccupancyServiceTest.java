package com.backend.engineer.coding.challange.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.backend.engineer.coding.challange.model.OccupancyRequest;

class OccupancyServiceTest {

    private final OccupancyService service = new OccupancyService();

    @Test
    void testCalculateOccupancy_Scenario1() {
        var request = new OccupancyRequest(
                3, 3, List.of(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0)
        );

        var result = service.calculateOccupancy(request);

        assertEquals(3, result.usagePremium());
        assertEquals(738.0, result.revenuePremium());
        assertEquals(3, result.usageEconomy());
        assertEquals(167.99, result.revenueEconomy());
    }

    @Test
    void testCalculateOccupancy_Scenario2() {
        var request = new OccupancyRequest(
                7, 5, List.of(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0)
        );

        var result = service.calculateOccupancy(request);

        assertEquals(6, result.usagePremium());
        assertEquals(1054.0, result.revenuePremium());
        assertEquals(4, result.usageEconomy());
        assertEquals(189.99, result.revenueEconomy());
    }
}