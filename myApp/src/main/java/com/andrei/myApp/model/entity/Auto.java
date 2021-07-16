package com.andrei.myApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table
public class Auto {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id")
    private Long autoId;
    @Column(nullable = false)
    private String number;
    @Column(name = "carrying_capacity",nullable = false)
    private int carryingCapacity;
    @Column(name = "max_weight_with_cargo_kg",nullable = false)
    private int maxWeightWithCargoKg;
    @Column(name = "max_volume_m3",nullable = false)
    private int maxVolumeM3;
    @Column(name = "technical_inspection",nullable = false)
    private Boolean technicalInspection;
    @OneToOne(mappedBy = "auto")
    private UserRole userRole;

}
