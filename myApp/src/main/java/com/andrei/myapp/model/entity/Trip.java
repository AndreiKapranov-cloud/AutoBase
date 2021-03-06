package com.andrei.myapp.model.entity;

import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.model.enums.TripEnum;
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
    @Column(name = "distance_km", nullable = false)
    private int distanceKm;
    @Column(name = "status")
    private TripEnum tripStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dispatcher_id")
    private User dispatcher;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private User driver;

}
