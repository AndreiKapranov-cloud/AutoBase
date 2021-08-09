package com.andrei.myapp.controller;

import com.andrei.myapp.service.interfaces.RoleDtoService;
import com.andrei.myapp.service.interfaces.TripDtoService;
import com.andrei.myapp.service.interfaces.UserDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
    private final RoleDtoService roleDtoService;
    private final UserDtoService userDtoService;
    private final TripDtoService tripDtoService;


    public RoleController(RoleDtoService roleDtoService, UserDtoService userDtoService, TripDtoService tripDtoService) {

        this.roleDtoService = roleDtoService;
        this.userDtoService = userDtoService;
        this.tripDtoService = tripDtoService;
    }

    @GetMapping("/roleDtos")
    public String showRoleList(Model model) {

        model.addAttribute("roles", roleDtoService.getAll());
        model.addAttribute("users", userDtoService.getAll());
        model.addAttribute("trips", tripDtoService.getAll());
        return "roleDtos";
    }

}
