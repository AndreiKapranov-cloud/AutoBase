package com.andrei.myapp.controller;

import com.andrei.myapp.service.interfaces.RoleDtoService;
import com.andrei.myapp.service.interfaces.TripDtoService;
import com.andrei.myapp.service.interfaces.UserDtoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RoleController {
    Logger logger = LoggerFactory.getLogger(RoleController.class);
    private final RoleDtoService roleDtoService;
    private final UserDtoService userDtoService;
    private final TripDtoService tripDtoService;

    @GetMapping("admin/roleDtos")
    public String showRoleList(Model model) {

        model.addAttribute("roles", roleDtoService.getAll());
        model.addAttribute("users", userDtoService.getAll());
        model.addAttribute("trips", tripDtoService.getAll());
        return "roleDtos";
    }

}
