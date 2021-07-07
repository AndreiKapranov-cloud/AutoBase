package com.andrei.myApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long tripId;
    @Column(name = "distance_km",nullable = false)
    private int distanceKm;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auto_id")
    private Auto auto;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dispatcher_id")
    private Dispatcher dispatcher;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autobase_id")
    private AutoBase autoBase;

}
