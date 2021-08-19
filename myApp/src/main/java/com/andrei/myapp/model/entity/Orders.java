package com.andrei.myapp.model.entity;

import com.andrei.myapp.model.enums.OrderEnum;
import com.andrei.myapp.model.enums.RolEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
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
    @Column(name = "weight_kg", nullable = false)
    private int weight;
    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;
    @Column(name = "volume_m3", nullable = false)
    private int volumeM3;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Trip> trips;
    @Column(name = "status")
    private OrderEnum orderStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auto_base_id")
    private AutoBase autoBase;


}
