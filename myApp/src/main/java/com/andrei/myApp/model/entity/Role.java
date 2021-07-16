package com.andrei.myApp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role")
    private String role;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
    private List<User>users;

}

