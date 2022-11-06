package com.incubateur.localibjava.model;

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
    private int id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String registration;

    @Column(length = 1)
    private String vehicleCondition;

    @Column(length = 3)
    private int pricePerDay;

    @Column
    private boolean available;

    @OneToMany(
            mappedBy = "car",
            cascade = CascadeType.ALL
    )
    private List<Location> cars = new ArrayList<>();

}
