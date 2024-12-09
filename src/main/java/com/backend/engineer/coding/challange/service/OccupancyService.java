package com.backend.engineer.coding.challange.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.backend.engineer.coding.challange.model.OccupancyRequest;
import com.backend.engineer.coding.challange.model.OccupancyResponse;

@Service
public class OccupancyService {

    public OccupancyResponse calculateOccupancy(OccupancyRequest request) {
        int premiumRooms = request.premiumRooms();
        int economyRooms = request.economyRooms();
        List<Double> guests = new ArrayList<>(request.potentialGuests()); // Create a modifiable copy

        // Sort guests by willingness to pay (highest to lowest)
        guests.sort(Collections.reverseOrder());

        // Variables for tracking room allocation and revenue
        int usedPremium = 0, usedEconomy = 0;
        double revenuePremium = 0, revenueEconomy = 0;

        for (double willingnessToPay : guests) {
            if (willingnessToPay >= 100 && usedPremium < premiumRooms) {
                // Allocate to premium room
                usedPremium++;
                revenuePremium += willingnessToPay;
            } else if (willingnessToPay < 100 && usedEconomy < economyRooms) {
                // Allocate to economy room
                usedEconomy++;
                revenueEconomy += willingnessToPay;
            } else if (willingnessToPay < 100 && usedPremium < premiumRooms) {
                // Upgrade lower-paying customer to premium room
                usedPremium++;
                revenuePremium += willingnessToPay;
            }
        }

        return new OccupancyResponse(usedPremium, revenuePremium, usedEconomy, revenueEconomy);
    }
}