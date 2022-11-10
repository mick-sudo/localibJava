package com.incubateur.localibjava.service;

import com.incubateur.localibjava.dto.CarLocationDto;
import com.incubateur.localibjava.model.Car;
import com.incubateur.localibjava.repository.CarRepository;
import com.incubateur.localibjava.repository.LocationRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public String deleteCarById(Integer id) {
        carRepository.deleteById(id);
        return "car removed";
    }

    public Car updateCarById(Integer id, Car car) {
        return carRepository.findById(id)
                .map(c->{
                    c.setBrand(car.getBrand());
                    c.setModel(car.getModel());
                    c.setRegistration(car.getRegistration());
                    c.setVehicleCondition((car.getVehicleCondition()));
                    c.setPricePerDay(car.getPricePerDay());
                    c.setAvailable(car.isAvailable());
                    return carRepository.save(c);
                        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }


}
