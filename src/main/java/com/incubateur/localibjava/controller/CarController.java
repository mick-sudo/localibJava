package com.incubateur.localibjava.controller;

import com.incubateur.localibjava.dto.CarLocationDto;
import com.incubateur.localibjava.model.Car;
import com.incubateur.localibjava.service.CarService;
import com.incubateur.localibjava.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public Car createCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping()
    public List<Car> carsList(){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Optional<Car> carsById(@PathVariable Long id){return carService.getCarById(id);}

    @DeleteMapping("delete/{id}")
    public String deleteCar(@PathVariable Long id){
        return carService.deleteCarById(id);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car){
        return carService.updateCarById(id, car);
    }

    @GetMapping("/locations")
    public List<CarLocationDto> getAllCarLocation(){
        return locationService.getAllCarLocation();
    }
}
