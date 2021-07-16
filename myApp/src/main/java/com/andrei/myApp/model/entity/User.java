package com.andrei.myApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
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
    @Column (name = "ready")
    private Boolean ready;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}

