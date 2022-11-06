package com.incubateur.localibjava.model;

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
    private int id;

    @Column(length = 10)
    private String firstName;

    @Column(length = 10)
    private String lastName;

    @Column()
    private Date birthday;

    @Column
    private String email;

    @Column
    private String phone;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL
    )
    private List<Location> customers = new ArrayList<>();
}
