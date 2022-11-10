package com.incubateur.localibjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String firstName;

    @Column(length = 10)
    private String lastName;


    private Date birthday;


    private String email;


    private String phone;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL
    )
    @JsonIgnoreProperties({"customer", "car"})
    private List<Location> customersLocation = new ArrayList<>();
}
