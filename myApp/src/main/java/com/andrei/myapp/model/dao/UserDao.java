package com.andrei.myapp.model.dao;

import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.model.enums.UserEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User getUserByUserName(String userName);

    User getUserByLogin(String login);

    List<User> findAll();

    List<User> getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThan(UserEnum userStatus, int carryingCapacity);

    List<User> getUsersByUserStatusAndAuto_CarryingCapacityIsGreaterThanAndAuto_maxVolumeM3IsGreaterThan(UserEnum userStatus, int carryingCapacity, int volumeM3);

    User getUserByUserId(Long userId);

    List<User> getUsersByAuto_CarryingCapacityIsGreaterThan(int carryingCapacity);

    User getUserByUserEmail(String userEmail);

    List<User> getUsersByRoleEquals(Role role);

    List<User> getUsersByRoleRolEnum(RolEnum rolEnum);


}
