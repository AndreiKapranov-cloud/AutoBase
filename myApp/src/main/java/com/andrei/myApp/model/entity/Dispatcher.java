package com.andrei.myApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table
public class Dispatcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dispatcher_id")
    private Long dispatcherId;
    @Column(name = "dispatcher_name",nullable = false)
    private String dispatcherName;
    @Column(name = "dispatcher_second_name",nullable = false)
    private String dispatcherSecondName;
    @OneToMany(mappedBy = "dispatcher", cascade = CascadeType.ALL)
    private List<Trip> trips;
    @OneToMany(mappedBy = "dispatcher", cascade = CascadeType.ALL)
    private List<Order> orders;


    }
