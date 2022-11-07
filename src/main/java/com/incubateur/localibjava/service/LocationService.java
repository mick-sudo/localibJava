package com.incubateur.localibjava.service;

import com.incubateur.localibjava.model.Location;
import com.incubateur.localibjava.repository.LocationRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {


    private final LocationRepository locationRepository;

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    public List<Location> getAllLocation() {
        List<Location> test = locationRepository.findAll();
        return test;
    }
}
