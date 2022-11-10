package com.incubateur.localibjava.dto;

import com.incubateur.localibjava.model.Location;
import lombok.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Builder
@Getter@Setter@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarLocationDto {
    private String brand;
    private String model;
    private String registration;
    private String firstName;
    private String lastName;
    private Date startLocation;
    private Date endLocation;
}
