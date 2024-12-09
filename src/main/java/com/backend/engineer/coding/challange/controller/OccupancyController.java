package com.backend.engineer.coding.challange.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.engineer.coding.challange.model.OccupancyRequest;
import com.backend.engineer.coding.challange.model.OccupancyResponse;
import com.backend.engineer.coding.challange.service.OccupancyService;

@RestController
@RequestMapping("/occupancy")
public class OccupancyController {

    @Autowired
    private OccupancyService occupancyService;

    @PostMapping
    public OccupancyResponse calculateOccupancy(@RequestBody OccupancyRequest request) {
        return occupancyService.calculateOccupancy(request);
    }
}