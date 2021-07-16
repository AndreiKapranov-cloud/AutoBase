package com.andrei.myApp.model.dao;

import com.andrei.myApp.model.entity.Role;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User  getUserByUserId(Long userId);

}
