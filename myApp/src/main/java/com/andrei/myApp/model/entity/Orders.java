package com.andrei.myApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @Column(name = "term_of_delivery", nullable = false)
    private Date termOfDelivery;
    @Column(name = "weight_kg",nullable = false)
    private int weight;
    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Trip> trips;




}
