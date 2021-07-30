package com.andrei.myapp.controller;

import com.andrei.myapp.service.interfaces.RoleService;
import com.andrei.myapp.service.interfaces.TripService;
import com.andrei.myapp.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
    private final RoleService roleService;
    private final UserService userService;
    private final TripService tripService;


    public RoleController(RoleService roleService, UserService userService, TripService tripService) {

        this.roleService = roleService;
        this.userService = userService;
        this.tripService = tripService;
    }

    @GetMapping("/roles")
    public String showRoleList(Model model) {

        model.addAttribute("roles", roleService.getAll());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("trips", tripService.getAll());
        return "roles";
    }

}
