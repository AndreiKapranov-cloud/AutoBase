package com.andrei.myApp.model.dao;

import com.andrei.myApp.model.entity.Auto;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRole,Long> {
    UserRole  getUserRoleByUserId(Long userId);
    UserRole getUserRoleByAutoTechnicalInspectionTrue();
}
