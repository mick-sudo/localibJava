package com.incubateur.localibjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String registration;

    private String vehicleCondition;

    private Long pricePerDay;

    private boolean available;

    @OneToMany(
            mappedBy = "car",
            cascade = CascadeType.ALL
    )
    @JsonIgnoreProperties("car")
    private List<Location> carsLocation = new ArrayList<>();

}
