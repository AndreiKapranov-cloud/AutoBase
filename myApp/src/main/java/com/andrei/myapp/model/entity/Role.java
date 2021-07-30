package com.andrei.myapp.model.entity;

import com.andrei.myapp.model.enums.RolEnum;
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
    private RolEnum rolEnum;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "role", cascade = CascadeType.ALL)
    private List<User>users;
}

