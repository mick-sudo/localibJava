package com.incubateur.localibjava.service;

import com.incubateur.localibjava.model.Car;
import com.incubateur.localibjava.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    public String deleteCarById(Long id) {
        carRepository.deleteById(id);
        return "car removed";
    }

    public Car updateCarById(Long id, Car car) {
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


    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }
}
