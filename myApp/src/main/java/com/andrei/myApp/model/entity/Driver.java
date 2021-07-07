package com.andrei.myApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "driver_name",nullable = false)
    private String driverName;
    @Column(name = "driver_second_name",nullable = false)
    private String driverSecondName;
    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    private List<Trip> trips;



}
