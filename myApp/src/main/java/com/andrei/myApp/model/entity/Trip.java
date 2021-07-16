package com.andrei.myApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auto_base_id")
    private AutoBase autoBase;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "trips")
    private List<UserRole> userRoles;

}
