package com.andrei.myApp.controller;

import com.andrei.myApp.service.serviceInterfaces.RoleDtoService;
import com.andrei.myApp.service.serviceInterfaces.TripDtoService;
import com.andrei.myApp.service.serviceInterfaces.UserDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleDtoController {
    private final RoleDtoService roleDtoService;
    private final UserDtoService userDtoService;
    private final TripDtoService tripDtoService;


    public RoleDtoController(RoleDtoService roleDtoService, UserDtoService userDtoService, TripDtoService tripDtoService) {

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
