package com.incubateur.localibjava.service;

import com.incubateur.localibjava.dto.CarLocationDto;
import com.incubateur.localibjava.model.Car;
import com.incubateur.localibjava.model.Location;
import com.incubateur.localibjava.repository.LocationRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


    public List<CarLocationDto> getAllCarLocation(){
        return locationRepository.findAll().stream().map(this::carLocationDto).collect(Collectors.toList());
    }
    private CarLocationDto carLocationDto(Location location){
        CarLocationDto carLocationDto = new CarLocationDto();
        carLocationDto.setBrand(location.getCar().getBrand());
        carLocationDto.setModel(location.getCar().getModel());
        carLocationDto.setRegistration(location.getCar().getRegistration());
        carLocationDto.setFirstName(location.getCustomer().getFirstName());
        carLocationDto.setLastName(location.getCustomer().getLastName());
        carLocationDto.setStartLocation(location.getStartLocation());
        carLocationDto.setEndLocation(location.getEndLocation());
        return  carLocationDto;
    }
}
