package com.backend.engineer.coding.challange.model;

import java.util.List;

public record OccupancyRequest(
        int premiumRooms,
        int economyRooms,
        List<Double> potentialGuests
) { }
