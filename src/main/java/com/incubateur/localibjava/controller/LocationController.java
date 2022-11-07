package com.incubateur.localibjava.controller;

import com.incubateur.localibjava.model.Location;
import com.incubateur.localibjava.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {


    private final LocationService locationService;

    @PostMapping("/add")
    public Location createLocation(@RequestBody Location location){
        return locationService.addLocation(location);
    }

    @GetMapping
    public List<Location> locationList(){
        return locationService.getAllLocation();
    }
}
