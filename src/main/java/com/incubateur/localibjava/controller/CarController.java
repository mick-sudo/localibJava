package com.incubateur.localibjava.controller;

import com.incubateur.localibjava.dto.CarLocationDto;
import com.incubateur.localibjava.model.Car;
import com.incubateur.localibjava.service.CarService;
import com.incubateur.localibjava.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @DeleteMapping("delete/{id}")
    public String deleteCar(@PathVariable Integer id){
        return carService.deleteCarById(id);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Integer id, @RequestBody Car car){
        return carService.updateCarById(id, car);
    }

    @GetMapping("/locations")
    public List<CarLocationDto> getAllCarLocation(){
        return locationService.getAllCarLocation();
    }
}
