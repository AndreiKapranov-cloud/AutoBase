package com.andrei.myApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @Column(name = "term_of_delivery", nullable = false)
    private Time termOfDelivery;
    @Column(name = "weight_kg",nullable = false)
    private int weight;
    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dispatcher_id", nullable = false)
    private Dispatcher dispatcher;


}
