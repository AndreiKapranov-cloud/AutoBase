package com.andrei.myApp.controller;

import com.andrei.myApp.service.serviceInterfaces.RoleService;
import com.andrei.myApp.service.serviceInterfaces.TripService;
import com.andrei.myApp.service.serviceInterfaces.UserService;
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
