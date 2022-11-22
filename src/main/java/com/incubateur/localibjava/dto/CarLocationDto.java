package com.incubateur.localibjava.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter@Setter@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarLocationDto {
    private Long carId;
    private String brand;
    private String model;
    private String registration;
    private String firstName;
    private String lastName;
    private Date startLocation;
    private Date endLocation;
}
