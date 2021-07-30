package com.andrei.myapp.model.entity;

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
    @Column(name = "finished")
    private Boolean finished;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auto_base_id")
    private AutoBase autoBase;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dispatcher_id")
    private User dispatcher ;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private User driver;

}
