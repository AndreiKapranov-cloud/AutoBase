package com.andrei.myapp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "auto_base")
public class AutoBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_base_id",nullable = false)
    private Long autoBaseId;
    @Column(nullable = false)
    private String address;
    @Column(name = "name_of_organization",nullable = false)
    private String nameOfOrganization;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "autoBase", cascade = CascadeType.ALL)
    private List<Trip> trips;
}
