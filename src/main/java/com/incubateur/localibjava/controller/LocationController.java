package com.incubateur.localibjava.controller;

import com.incubateur.localibjava.dto.CarLocationDto;
import com.incubateur.localibjava.model.Location;
import com.incubateur.localibjava.service.LocationService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {


    private final LocationService locationService;

    @PostMapping("/add")
    public Location createLocation(@RequestBody Location location){
        if(locationService.carsAvailable(location.getCar().getId(), location.getStartLocation(), location.getEndLocation())){
           return locationService.addLocation(location);
        }else {
            return null;
        }
    }

    @GetMapping
    public List<Location> locationList(){
        return locationService.getAllLocation();
    }

    @PostMapping("/dispo")
    public Boolean testdispo(@RequestBody CarLocationDto carLocationDto){
        return locationService.carsAvailable(carLocationDto.getCarId(), carLocationDto.getStartLocation(), carLocationDto.getEndLocation());
    }

    @GetMapping("/carprice")
    public long test(@RequestBody Location location){
        return locationService.carsInvoice(location);
    }
}
