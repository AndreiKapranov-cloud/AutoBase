package com.andrei.myApp.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user_role")
@IdClass(UserRoleId.class)
public class UserRole implements Serializable {
    @Id
    private Long userId;
    @Id
    private Long roleId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "auto_user_role",
            joinColumns =
                    {@JoinColumn(table = "user_role", name = "user_id", referencedColumnName = "user_id"),
                            @JoinColumn(table = "user_role", name = "role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = @JoinColumn(table = "auto", name = "auto_id"))
    private Auto auto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "trip_user_role",
            joinColumns = {
                    @JoinColumn(table = "user_role", name = "user_id", referencedColumnName = "user_id"),
                    @JoinColumn(table = "user_role", name = "role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = @JoinColumn(table = "trip", name = "trip_id"))
    private List<Trip> trips;
}

