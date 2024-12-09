package com.backend.engineer.coding.challange.model;

public record OccupancyResponse(
        int usagePremium,
        double revenuePremium,
        int usageEconomy,
        double revenueEconomy
) { }
