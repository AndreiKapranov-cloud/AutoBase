package com.andrei.myapp.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username", nullable = false)
    private String userName;
    @Column(name = "email", nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private String password;
    @Column(name = "create_date", nullable = false)
    private Date createDate;
    @Column(name = "user_second_name")
    private String secondName;
    @Column(name = "ready")
    private Boolean ready;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Auto> autos;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dispatcher", cascade = CascadeType.ALL)
    private List<Trip> dispatchersTrips;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Trip> driversTrips;
}

