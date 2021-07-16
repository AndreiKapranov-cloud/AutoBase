package com.andrei.myApp.controller;

import com.andrei.myApp.model.entity.AutoBase;
import com.andrei.myApp.model.entity.Role;
import com.andrei.myApp.model.entity.User;
import com.andrei.myApp.service.serviceInterfaces.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final AutoBaseService autoBaseService;
    private final RoleService roleService;

    public UserController(UserService userService, AutoBaseService autoBaseService, RoleService roleService) {

        this.userService = userService;
        this.autoBaseService = autoBaseService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/user/new")
    public String showAddUserForm(Model model) {
        List<AutoBase> autoBases = autoBaseService.getAll();
        List<Role> roles = roleService.getAll();
        model.addAttribute("autoBases", autoBases);
        model.addAttribute("user", new User());
        model.addAttribute("roles", roles);
        return "user_form";

    }

    @PostMapping("user/save")
    public String saveUserDto(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/users/edit/{userId}")
    public String showEditUserForm(@PathVariable("userId") Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        List<Role> roles = roleService.getAll();
        model.addAttribute("roles", roles);
        return "user_form";

    }
}


