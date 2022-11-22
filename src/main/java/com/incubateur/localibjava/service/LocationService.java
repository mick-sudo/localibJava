package com.incubateur.localibjava.service;

import com.incubateur.localibjava.dto.CarLocationDto;
import com.incubateur.localibjava.model.Car;
import com.incubateur.localibjava.model.Location;
import com.incubateur.localibjava.repository.CarRepository;
import com.incubateur.localibjava.repository.LocationRepository;
import com.sun.jdi.JDIPermission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final CarRepository carRepository;
    private final LocationRepository locationRepository;

    public Location addLocation(Location location) {
        if(location.getCar().isAvailable()){
            return locationRepository.save(location);
        }else {
            return null;
        }

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

    public Boolean carsAvailable(Long carId, Date startLocation, Date endLocation){
        Optional<Car> car = carRepository.findById(carId);
        AtomicReference<Boolean> dispo = new AtomicReference<>(true);
        if(car.isPresent()){
           List<Location> carLocation = car.get().getCarsLocation();
           carLocation.forEach(location -> {
               if(!(startLocation.after(location.getEndLocation()) || endLocation.before(location.getStartLocation()))){
                   dispo.set(false);
               }
           });
        }
        return dispo.get();
    }

    public long carsInvoice(Location location){
            long startLocation = location.getStartLocation().getTime();
            long endLocation = location.getEndLocation().getTime();
            long duration = (endLocation - startLocation) / (1000 * 60 * 60 * 24);
            long price = location.getCar().getPricePerDay();
            long invoice = duration * price;
            return invoice;
    }
}
