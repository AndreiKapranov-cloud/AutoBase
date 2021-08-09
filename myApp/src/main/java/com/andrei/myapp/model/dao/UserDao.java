package com.andrei.myapp.model.dao;

import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User getUserByUserName(String userName);

    User getUserByUserId(Long userId);

    User getUserByUserEmail(String userEmail);

    List<User> getUsersByRoleEquals(Role role);

    List<User> getUsersByRoleRolEnum(RolEnum rolEnum);

    List<User> getUsersByRoleRolEnumAndAutosEmpty(RolEnum rolEnum);
}
